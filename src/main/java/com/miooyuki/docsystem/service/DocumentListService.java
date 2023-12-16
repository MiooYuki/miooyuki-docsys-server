package com.miooyuki.docsystem.service;

import com.miooyuki.docsystem.common.PageBean;
import com.miooyuki.docsystem.common.ResponseResult;
import com.miooyuki.docsystem.entity.vo.DocumentVo;

import java.util.List;

public interface DocumentListService {

    /**
     * 查询所有文档
     * @return 所有文档列表的应结果
     */
    ResponseResult<List<DocumentVo>> findAll();

    /**
     * 分页查询文档
     * @param current 当前页码
     * @param size    每页条数
     * @return 查询结果的响应结果
     */
    ResponseResult<PageBean<DocumentVo>> findPage(long current, long size);

}
