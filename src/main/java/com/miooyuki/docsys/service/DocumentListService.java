package com.miooyuki.docsys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.miooyuki.docsys.entity.DocumentList;

import java.util.List;

public interface DocumentListService {

    List<List<String>> findAll();

    Page<DocumentList> findPage(long current, long size);

}
