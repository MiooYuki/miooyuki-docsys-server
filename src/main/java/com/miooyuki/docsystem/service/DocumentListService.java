package com.miooyuki.docsystem.service;

import com.miooyuki.docsystem.common.PageBean;
import com.miooyuki.docsystem.common.ResponseResult;
import com.miooyuki.docsystem.entity.dto.DocumentDto;
import com.miooyuki.docsystem.entity.vo.DocumentVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    /**
     * 创建文档
     * @param documentDto 文档信息
     * @return 创建结果的响应结果
     */
    ResponseResult<String> createDoc(DocumentDto documentDto);

    /**
     * 本地文件上传，将文件上传到本地
     * @param file 上传的文件
     * @return 文件在服务器上的地址
     * @throws IOException IO异常
     */
    ResponseResult<String> localUpload(MultipartFile file) throws IOException;

    /**
     * 阿里云文件上传，将文件上传到阿里云OSS
     * @param file 上传的文件
     * @return 文件在服务器上的地址
     * @throws IOException IO异常
     */
    ResponseResult<String> ossUpload(MultipartFile file) throws IOException;

}
