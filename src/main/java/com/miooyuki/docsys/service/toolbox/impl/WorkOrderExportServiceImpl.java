package com.miooyuki.docsys.service.toolbox.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.miooyuki.docsys.entity.toolbox.TableEntity;
import com.miooyuki.docsys.entity.toolbox.Tenant;
import com.miooyuki.docsys.entity.toolbox.TenantProduct;
import com.miooyuki.docsys.mapper.toolbox.TenantMapper;
import com.miooyuki.docsys.mapper.toolbox.TenantProductMapper;
import com.miooyuki.docsys.service.toolbox.WorkOrderExportService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class WorkOrderExportServiceImpl implements WorkOrderExportService {

    @Autowired
    TenantMapper tenantMapper;

    @Autowired
    TenantProductMapper tenantProductMapper;

    @Override
    public List<Tenant> findAllTenant() {
        return tenantMapper.selectList(null);
    }

    @Override
    public List<TenantProduct> findProductsByTenant(String tenant_id) {
        LambdaQueryWrapper<TenantProduct> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(TenantProduct::getTenantId, tenant_id);
        return tenantProductMapper.selectList(queryWrapper);
    }

    @Override
    public void generateExcel(String newdir, List<TableEntity> tableEntity) {

        File dir = new File("C:/Users/PC/Downloads/Download/workorder_template/" + newdir);
        boolean mkdirs = dir.mkdirs();

        if (mkdirs) {
            FileInputStream inputStream = null;
            FileOutputStream outputStream = null;
            File importFile = null;
            File tempFile = null;

            try {
                inputStream = new FileInputStream("C:/Users/PC/Downloads/Download/workorder_template/source/2023-06-08工单导入模板.xlsx");
                outputStream = new FileOutputStream(dir + "/2023-06-08工单导入模板.xlsx");

                IOUtils.copy(inputStream, outputStream);
                importFile = new File(dir + "/2023-06-08工单导入模板.xlsx");
                tempFile = new File(dir + "/temp.xlsx");

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if(inputStream != null)
                        inputStream.close();
                    if(outputStream != null)
                        outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (importFile.exists()) {
                // 第二次按照原有格式，不需要表头，追加写入
                EasyExcel.write(importFile, TableEntity.class).needHead(false).
                        withTemplate(importFile).file(tempFile).sheet().doWrite(tableEntity);
            } else {
                // 第一次写入需要表头
                EasyExcel.write(importFile, TableEntity.class).sheet().doWrite(tableEntity);
            }
            if (tempFile.exists()) {
                importFile.delete();
                tempFile.renameTo(importFile);
            }
        }

    }

}
