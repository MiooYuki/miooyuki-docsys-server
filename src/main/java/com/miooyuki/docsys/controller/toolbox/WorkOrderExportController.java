package com.miooyuki.docsys.controller.toolbox;

import com.alibaba.excel.EasyExcel;
import com.miooyuki.docsys.entity.toolbox.TableEntity;
import com.miooyuki.docsys.entity.toolbox.Tenant;
import com.miooyuki.docsys.entity.toolbox.TenantProduct;
import com.miooyuki.docsys.service.toolbox.WorkOrderExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/toolbox/orderwork")
public class WorkOrderExportController {

    @Autowired
    WorkOrderExportService workOrderExportService;

    @GetMapping("/tenant/list")
    public List<Tenant> findAllTenant() {
        return workOrderExportService.findAllTenant();
    }

    @GetMapping("/tenant/products")
    public List<TenantProduct> findProductsByTenant(@RequestParam("tenant_id") String tenant_id) {
        return workOrderExportService.findProductsByTenant(tenant_id);
    }

    @PostMapping("/download")
    public void downloadExcel(@RequestBody List<TableEntity> tableEntity, HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("table", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), TableEntity.class).sheet("sheet1").doWrite(tableEntity);
    }

}
