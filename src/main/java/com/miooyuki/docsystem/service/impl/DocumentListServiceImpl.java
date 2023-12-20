package com.miooyuki.docsystem.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.miooyuki.docsystem.common.PageBean;
import com.miooyuki.docsystem.common.ResponseResult;
import com.miooyuki.docsystem.common.enums.ResponseStatusEnum;
import com.miooyuki.docsystem.entity.DocumentEntity;
import com.miooyuki.docsystem.entity.dto.DocumentDto;
import com.miooyuki.docsystem.entity.vo.DocumentVo;
import com.miooyuki.docsystem.mapper.DocumentMapper;
import com.miooyuki.docsystem.service.DocumentListService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentListServiceImpl implements DocumentListService {

    @Autowired
    DocumentMapper documentMapper;

    /**
     * 查询所有文档
     * @return 所有文档列表的响应结果
     */
    @Override
    public ResponseResult<List<DocumentVo>> findAll() {
        List<DocumentEntity> documentEntities = documentMapper.selectList(null);
        List<DocumentVo> documentVos = new ArrayList<>();
        for (DocumentEntity documentEntity : documentEntities) {
            DocumentVo documentVo = new DocumentVo();
            BeanUtils.copyProperties(documentEntity, documentVo);
            documentVos.add(documentVo);
        }
        return ResponseResult.success(documentVos);
    }

    /**
     * 分页查询文档
     * @param current 当前页码
     * @param size    每页条数
     * @return 查询结果的响应结果
     */
    @Override
    public ResponseResult<PageBean<DocumentVo>> findPage(long current, long size) {
        Page<DocumentEntity> documentEntityPage = documentMapper.selectPage(Page.of(current, size), null);
        PageBean<DocumentVo> documentVoPage = new PageBean<>();
        BeanUtils.copyProperties(documentEntityPage, documentVoPage, "records");
        List<DocumentVo> documentVoList = new ArrayList<>();
        for (DocumentEntity record : documentEntityPage.getRecords()) {
            DocumentVo documentVo = new DocumentVo();
            BeanUtils.copyProperties(record, documentVo);
            documentVoList.add(documentVo);
        }
        documentVoPage.setRecords(documentVoList);
        return ResponseResult.success(documentVoPage);
    }

    /**
     * 创建文档
     * @param documentDto 文档信息
     * @return 创建结果的响应结果
     */
    @Override
    public ResponseResult<String> createDoc(DocumentDto documentDto) {
        DocumentEntity documentEntity = new DocumentEntity();
        BeanUtils.copyProperties(documentDto, documentEntity);
        documentEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        documentEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        int insert = documentMapper.insert(documentEntity);
        if (insert >= 0) {
            return ResponseResult.success("创建成功");
        }
        return ResponseResult.success("创建失败");
    }

    /**
     * 本地文件上传，将文件上传到本地
     * @param file 上传的文件
     * @return 文件在服务器上的地址
     * @throws IOException IO异常
     */
    @Override
    public ResponseResult<String> localUpload(MultipartFile file) throws IOException {
        String originalName = file.getOriginalFilename();
        if (originalName != null) {
            String[] split = originalName.split("\\.");
            String extensionName = split[split.length - 1];
            String fileName = System.currentTimeMillis() + "." + extensionName;
            file.transferTo(new File("D:/BaiduNetdiskDownload/miooyuki-docsys-upload/" + fileName));
            return ResponseResult.success("http://192.168.0.103:1233/chfs/shared/BaiduNetdiskDownload/miooyuki-docsys-upload/" + fileName);
        }
        return ResponseResult.failure(ResponseStatusEnum.PARAM_ERROR);
    }

    /**
     * 阿里云文件上传，将文件上传到阿里云OSS
     * @param file 上传的文件
     * @return 文件在服务器上的地址
     * @throws IOException IO异常
     */
    @Override
    public ResponseResult<String> ossUpload(MultipartFile file) throws IOException {
        return null;
    }

}
