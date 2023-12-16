package com.miooyuki.docsystem.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.miooyuki.docsystem.common.PageBean;
import com.miooyuki.docsystem.common.ResponseResult;
import com.miooyuki.docsystem.entity.DocumentEntity;
import com.miooyuki.docsystem.entity.vo.DocumentVo;
import com.miooyuki.docsystem.mapper.DocumentMapper;
import com.miooyuki.docsystem.service.DocumentListService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
