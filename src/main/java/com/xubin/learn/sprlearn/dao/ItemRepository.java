package com.xubin.learn.sprlearn.dao;

import com.xubin.learn.sprlearn.entity.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ItemRepository extends ElasticsearchRepository<Item,Long> {
}
