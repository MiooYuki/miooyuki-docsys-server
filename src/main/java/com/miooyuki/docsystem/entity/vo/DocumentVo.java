package com.miooyuki.docsystem.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentVo {

    private String name;
    private String description;
    private String imageUrl;

}
