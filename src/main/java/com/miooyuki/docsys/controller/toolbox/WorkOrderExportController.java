package com.miooyuki.docsys.controller.toolbox;

import com.miooyuki.docsys.entity.toolbox.Tenant;
import com.miooyuki.docsys.entity.toolbox.TenantProduct;
import com.miooyuki.docsys.service.toolbox.WorkOrderExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
