package com.miooyuki.docsystem.controller;

import com.miooyuki.docsystem.common.PageBean;
import com.miooyuki.docsystem.common.ResponseResult;
import com.miooyuki.docsystem.common.enums.ResponseStatusEnum;
import com.miooyuki.docsystem.entity.dto.DocumentDto;
import com.miooyuki.docsystem.entity.vo.DocumentVo;
import com.miooyuki.docsystem.service.DocumentListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentListController {

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
     * @param documentDto 文档信息
     * @return 创建结果的响应结果
     */
    @PostMapping("/create")
    public ResponseResult<String> create(@RequestBody DocumentDto documentDto) {
        return documentListService.createDoc(documentDto);
    }

    /**
     * 上传文件
     * @param file 上传的文件
     */
    @PostMapping("/upload")
    public ResponseResult<String> upload(MultipartFile file) throws IOException {
        return documentListService.localUpload(file);
    }

}
