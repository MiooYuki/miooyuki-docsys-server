package com.miooyuki.docsystem.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean<T> {

    private long total;      // 总条数
    private long size;       // 每页条数
    private long current;    // 当前页码
    private long pages;      // 总页数
    private List<T> records;    // 数据列表

}
