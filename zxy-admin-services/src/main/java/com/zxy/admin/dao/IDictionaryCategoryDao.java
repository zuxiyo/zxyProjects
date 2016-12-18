/*
、 * Created by Zhu XiYong <zuxiyo@sohu.com> at 2016年9月4日下午4:05:15
 * 
 * 作        者：Zhu XiYong(zuxiyo@sohu.com)
 * 创建时间： 2016年9月4日下午4:05:15
 */
package com.zxy.admin.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.zxy.admin.entities.DictionaryCategoryInfo;

/**
 * 数据字典类别数据层接口
 * @author Zhu XiYong 
 * @Date 2016年9月4日下午4:05:15
 */
public interface IDictionaryCategoryDao extends PagingAndSortingRepository<DictionaryCategoryInfo,String> {

	/**
	 * 获得一条指定的数据字典的种类
	 * @param categoryCode
	 * @return
	 */			    
	DictionaryCategoryInfo findOneByCategoryCode(String categoryCode);

	/**
	 *  获得同类别代码的数据字典种类
	 * @param categoryCode
	 * @return
	 */
	List<DictionaryCategoryInfo> findByCategoryCode(String categoryCode);

	/**
	 * 获得已排序号排列的数据
	 * @param pageable
	 * @return
	 */
	Page<DictionaryCategoryInfo> findAllByOrderBySortAsc(Pageable pageable);
	
}