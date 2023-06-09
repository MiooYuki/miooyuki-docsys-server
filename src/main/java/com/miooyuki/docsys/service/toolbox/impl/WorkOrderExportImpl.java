package com.miooyuki.docsys.service.toolbox.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.miooyuki.docsys.entity.toolbox.Tenant;
import com.miooyuki.docsys.entity.toolbox.TenantProduct;
import com.miooyuki.docsys.mapper.toolbox.TenantMapper;
import com.miooyuki.docsys.mapper.toolbox.TenantProductMapper;
import com.miooyuki.docsys.service.toolbox.WorkOrderExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkOrderExportImpl implements WorkOrderExportService {

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

}
