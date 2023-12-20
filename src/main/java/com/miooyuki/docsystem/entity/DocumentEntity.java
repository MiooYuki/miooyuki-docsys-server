package com.miooyuki.docsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("document")
public class DocumentEntity {

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;              // 文档ID
    private String name;            // 文档名称
    private String description;     // 文档描述
    private String imageUrl;        // 文档封面链接
    private Timestamp createdAt;    // 文档创建时间
    private Timestamp updatedAt;    // 文档更新时间

}
