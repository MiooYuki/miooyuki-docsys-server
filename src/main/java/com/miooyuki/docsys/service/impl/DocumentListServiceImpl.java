package com.miooyuki.docsys.service.impl;

import com.miooyuki.docsys.entity.DocumentList;
import com.miooyuki.docsys.mapper.DocumentListMapper;
import com.miooyuki.docsys.service.DocumentListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentListServiceImpl implements DocumentListService {

    @Autowired
    DocumentListMapper documentListMapper;

    @Override
    public List<List<String>> findAll() {
        List<List<String>> list = new ArrayList<>();
        for (DocumentList document : documentListMapper.selectList(null)) {
            List<String> str = new ArrayList<>();
            str.add(document.getId());
            str.add(document.getName());
            str.add(document.getDescription());
            str.add(document.getImageUrl());
            list.add(str);
        }
        return list;
    }

}
