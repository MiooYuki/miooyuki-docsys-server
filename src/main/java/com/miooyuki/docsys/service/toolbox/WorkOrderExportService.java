package com.miooyuki.docsys.service.toolbox;

import com.miooyuki.docsys.entity.toolbox.TableEntity;
import com.miooyuki.docsys.entity.toolbox.Tenant;
import com.miooyuki.docsys.entity.toolbox.TenantProduct;

import java.io.IOException;
import java.util.List;

public interface WorkOrderExportService {

    List<Tenant> findAllTenant();

    List<TenantProduct> findProductsByTenant(String tenant_id);

    void generateExcel(String newdir, List<TableEntity> tableEntity) throws IOException;

}
