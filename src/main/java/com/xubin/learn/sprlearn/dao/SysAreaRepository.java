package com.xubin.learn.sprlearn.dao;

import com.xubin.learn.sprlearn.entity.SysArea;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SysAreaRepository extends ElasticsearchRepository<SysArea,Long> {
}
