package com.miooyuki.docsys;

import com.miooyuki.docsys.entity.DocumentList;
import com.miooyuki.docsys.mapper.DocumentListMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DocSystemTest {

    @Autowired
    DocumentListMapper documentListMapper;

    @Test
    public void test() {
        List<List<String>> list = new ArrayList<>();
        for (DocumentList document : documentListMapper.selectList(null)) {
            List<String> str = new ArrayList<>();
            str.add(document.getId());
            str.add(document.getName());
            str.add(document.getDescription());
            str.add(document.getImageUrl());
            list.add(str);
        }
        System.out.println(list);
    }

}
