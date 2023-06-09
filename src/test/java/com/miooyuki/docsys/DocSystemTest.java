package com.miooyuki.docsys;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.miooyuki.docsys.entity.DocumentList;
import com.miooyuki.docsys.entity.toolbox.TenantProduct;
import com.miooyuki.docsys.mapper.DocumentListMapper;
import com.miooyuki.docsys.mapper.toolbox.TenantMapper;
import com.miooyuki.docsys.mapper.toolbox.TenantProductMapper;
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

    @Autowired
    TenantMapper tenantMapper;

    @Autowired
    TenantProductMapper tenantProductMapper;

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

    @Test
    public void testPage() {

        Page<DocumentList> page = Page.of(1, 7);
        for (DocumentList record : documentListMapper.selectPage(page, null).getRecords()) {
            System.out.println(record);
        }
        System.out.println(documentListMapper.selectPage(page, null).getTotal());

    }

    @Test
    public void queryTenant() {

        LambdaQueryWrapper<TenantProduct> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(TenantProduct::getTenantId, "31");
        System.out.println(tenantProductMapper.selectList(queryWrapper));

    }

}
