package com.miooyuki.docsys.entity.toolbox;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Tenant {

    private Integer id;
    private String name;
    private String code;

}
