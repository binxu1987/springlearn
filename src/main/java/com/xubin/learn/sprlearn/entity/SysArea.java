package com.xubin.learn.sprlearn.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 《行政区域表》
 * 
 * 
 * @Project:  platform-facade
 * @Module ID:   <(模块)类编号，可以引用系统设计中的类编号>
 * @Comments:  <对此类的描述，可以引用系统设计中的描述>
 * @JDK version used:      <JDK1.7> 
 * @author JannyShao(邵建义) [ksgameboy@qq.com]
 * @since 2017-7-17-下午2:01:48
 */

@TableName("sys_area")
@Document(indexName = "sys_area",type = "sysArea", shards = 1, replicas = 0)
public  class SysArea implements Serializable {
	private static final long serialVersionUID = 2520722068631720337L;

	/**
     * ID
     */
    @TableId(value ="id", type = IdType.INPUT)
    @Id
    private Long id;

    /**
     * 父编号
     */


    @Field(type = FieldType.Long)
    private Long parentId;

    /**
     * 简称
     */

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String shortName;

    /**
     * 名称
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String name;

    /**
     * 简拼
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String py;

    /**
     * 全拼
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String pyFull;

    /**
     * 经度
     */
    @Field(type = FieldType.Text)
    private String lng;

    /**
     * 纬度
     */
    @Field(type = FieldType.Text)
    private String lat;

    /**
     * 级别(0-国家,1-省,2-市,3-区,4-乡,5-村)
     */
    @Field(type = FieldType.Integer)
    private Byte level;

    /**
     * 热度
     */
    @Field(type = FieldType.Integer)
    private Integer orderBy;
    
    /**
     * 同一级的区域排序字段(默认为id值)
     */
    @Field(type = FieldType.Long)
    private Long sort;
    
    /**
     * 省编号
     */
    @Field(type = FieldType.Long)
    private Long provinceId;

    /**
     * 省名称
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String provinceName;

    /**
     * 市编号
     */
    @Field(type = FieldType.Long)
    private Long cityId;

    /**
     * 市名称
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String cityName;

    /**
     * 区域ID
     */

    @Field(type = FieldType.Long)
    private Long areaId;

    /**
     * 区域名称
     */

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String areaName;

    /**
     * 乡镇街道编号
     */

    @Field(type = FieldType.Long)
    private Long streetId;

    /**
     * 乡镇街道名称
     */

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String streetName;

    /**
     * 是否有效（0-无效，1-有效）
     */

    @Field(type = FieldType.Boolean)
    private Boolean isValid;

    /**
     * 创建者
     */

    @Field(type = FieldType.Long)
    private Long createBy;

    /**
     * 创建时间
     */

    @Field(type = FieldType.Date,format = DateFormat.basic_date)
    private Date createDate;

    /**
     * 更新者
     */

    @Field(type = FieldType.Long)
    private Long updateBy;

    /**
     * 更新时间
     */
    @Field(type = FieldType.Date,format = DateFormat.basic_date)
    private Date updateDate;


}