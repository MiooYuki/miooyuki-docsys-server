package com.miooyuki.docsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miooyuki.docsystem.entity.DocumentEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DocumentMapper extends BaseMapper<DocumentEntity> {

}
