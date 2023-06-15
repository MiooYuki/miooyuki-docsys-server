package com.miooyuki.docsys;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.miooyuki.docsys.entity.DocumentList;
import com.miooyuki.docsys.entity.toolbox.TableEntity;
import com.miooyuki.docsys.entity.toolbox.TenantProduct;
import com.miooyuki.docsys.mapper.DocumentListMapper;
import com.miooyuki.docsys.mapper.toolbox.TenantMapper;
import com.miooyuki.docsys.mapper.toolbox.TenantProductMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DocSystemTest {

    @Autowired
    DocumentListMapper documentListMapper;

    @Autowired
    TenantMapper tenantMapper;

    @Autowired
    TenantProductMapper tenantProductMapper;

    @Test
    public void test() {
        List<List<String>> list = new ArrayList<>();
        for (DocumentList document : documentListMapper.selectList(null)) {
            List<String> str = new ArrayList<>();
            str.add(document.getId());
            str.add(document.getName());
            str.add(document.getDescription());
            str.add(document.getImageUrl());
            list.add(str);
        }
        System.out.println(list);
    }

    @Test
    public void testPage() {

        Page<DocumentList> page = Page.of(1, 7);
        for (DocumentList record : documentListMapper.selectPage(page, null).getRecords()) {
            System.out.println(record);
        }
        System.out.println(documentListMapper.selectPage(page, null).getTotal());

    }

    @Test
    public void queryTenant() {

        LambdaQueryWrapper<TenantProduct> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(TenantProduct::getTenantId, "31");
        System.out.println(tenantProductMapper.selectList(queryWrapper));

    }

    @Test
    public void testWrite() {
        File file = new File("C:/Users/PC/Desktop/2023-06-08工单导入模板.xlsx");
        File tempFile = new File("C:/Users/PC/Desktop/temp.xlsx");
        if (file.exists()) {
            // 第二次按照原有格式，不需要表头，追加写入
            EasyExcel.write(new File("C:/Users/PC/Desktop/123123.xlsx"), TableEntity.class).needHead(false).
                    withTemplate(file).file(tempFile).sheet().doWrite(data());
        } else {
            // 第一次写入需要表头
            EasyExcel.write(file, TableEntity.class).sheet().doWrite(data());
        }
        if (tempFile.exists()) {
            file.delete();
            tempFile.renameTo(file);
        }
    }

    public List<TableEntity> data() {
        List<TableEntity> lists = new ArrayList<>();
        TableEntity t1 = new TableEntity();
        t1.setTenantCode("awdawd");
        t1.setProductCode("adawf");
        t1.setDescription("awdawfawf");
        TableEntity t2 = new TableEntity();
        t2.setTenantCode("afafegwe");
        t2.setProductCode("gergerh");
        t2.setDescription("rthrtrthrth");
        lists.add(t1);
        lists.add(t2);
        return lists;
    }

}
