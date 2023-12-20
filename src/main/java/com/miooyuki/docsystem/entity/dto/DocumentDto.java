package com.miooyuki.docsystem.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDto {

    private String name;            // 文档名称
    private String description;     // 文档描述
    private String imageUrl;        // 文档封面链接

}
