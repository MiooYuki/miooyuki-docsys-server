package com.miooyuki.docsys.service.toolbox;

import com.miooyuki.docsys.entity.toolbox.Tenant;
import com.miooyuki.docsys.entity.toolbox.TenantProduct;

import java.util.List;

public interface WorkOrderExportService {

    List<Tenant> findAllTenant();

    List<TenantProduct> findProductsByTenant(String tenant_id);

}
