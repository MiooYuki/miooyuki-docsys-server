package com.miooyuki.docsystem.controller;

import com.miooyuki.docsystem.common.PageBean;
import com.miooyuki.docsystem.common.ResponseResult;
import com.miooyuki.docsystem.entity.DocumentEntity;
import com.miooyuki.docsystem.entity.vo.DocumentVo;
import com.miooyuki.docsystem.mapper.DocumentMapper;
import com.miooyuki.docsystem.service.DocumentListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentListController {

    @Autowired
    DocumentMapper documentMapper;

    @Autowired
    DocumentListService documentListService;

    /**
     * 列举所有文档
     * @return 所有文档列表的响应结果
     */
    @GetMapping("all")
    public ResponseResult<List<DocumentVo>> listAll() {
        return documentListService.findAll();
    }

    /**
     * 分页查询文档
     * @param current 当前页码
     * @param size    每页条数
     * @return 查询结果的响应结果
     */
    @GetMapping("list/{current}/{size}")
    public ResponseResult<PageBean<DocumentVo>> listPage(@PathVariable long current, @PathVariable long size) {
        return documentListService.findPage(current, size);
    }

    /**
     * 创建文档
     * @param document 文档对象
     */
    @PostMapping("/create")
    public void create(@RequestBody DocumentEntity document) {
        System.out.println(document);
        documentMapper.insert(document);
    }

}
