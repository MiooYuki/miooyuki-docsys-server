package com.miooyuki.docsys.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.miooyuki.docsys.entity.DocumentList;
import com.miooyuki.docsys.service.DocumentListService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/document")
@CrossOrigin("*")
public class DocumentListController {

    @Autowired
    DocumentListService documentListService;

    @GetMapping("/render")
    public String renderMarkdown() throws IOException {
        return IOUtils.toString(new FileInputStream("C:/Users/PC/Documents/Java Projects/personal-knowledge-repository/src/java/面试/redis.md"), StandardCharsets.UTF_8);
    }

    @GetMapping("/list")
    public List<List<String>> findAll() {
        return documentListService.findAll();
    }

    @GetMapping("/list/{current}/{size}")
    public Page<DocumentList> findPage(@PathVariable("current") long current, @PathVariable("size") long size) {
        return documentListService.findPage(current, size);
    }

}
