package com.miooyuki.docsys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DocumentList {

    // ID
    @TableId
    private String id;
    // 文档名称
    private String name;
    // 文档描述
    private String description;
    // 文档封面图链接
    private String imageUrl;

}
