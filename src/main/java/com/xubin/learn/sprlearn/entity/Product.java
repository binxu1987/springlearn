package com.xubin.learn.sprlearn.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "item",type = "docs", shards = 1, replicas = 0,indexStoreType="product")
public class Product {

    @Id
    private Long id;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String name; //标题

    @Field(type = FieldType.Keyword)
    private Long count;// 分类

    public Product(Long id, String name, Long count){
      this.id=id;
      this.name=name;
      this.count=count;
    }
    public Product(){}
}
