package com.miooyuki.docsys.entity.toolbox;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TenantProduct {

    private Integer id;
    private String tenantId;
    private String name;
    private String code;

}
