/*
、 * Created by Zhu XiYong <zuxiyo@sohu.com> at 2016年9月4日下午4:05:15
 * 
 * 作        者：Zhu XiYong(zuxiyo@sohu.com)
 * 创建时间： 2016年9月4日下午4:05:15
 */
package com.zxy.admin.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.zxy.admin.entities.DictionaryCategoryInfo;

/**
 * 数据字典类别数据层接口
 * @author Zhu XiYong 
 * @Date 2016年9月4日下午4:05:15
 */
public interface IDictionaryCategoryDao extends PagingAndSortingRepository<DictionaryCategoryInfo,String> {
	
}