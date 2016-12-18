/*
 * Created by Zhu XiYong <zuxiyo@sohu.com> at 2016年9月8日下午6:43:16
 * 
 * 作        者：Zhu XiYong(zuxiyo@sohu.com)
 * 创建时间： 2016年9月8日下午6:43:16
 */
package com.zxy.admin.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.zxy.admin.entities.DictionaryItemInfo;

/**
 * 数据字典具体项数据层接口
 * @author Zhu XiYong 
 * @Date 2016年9月8日下午6:43:16
 */
public interface IDictionaryItemsDao extends PagingAndSortingRepository<DictionaryItemInfo,String>{

	/**
	 * 通过字典的类别找到字典项
	 * @param pageable
	 * @return
	 */
	Page<DictionaryItemInfo> findByCategoryCodeOrderBySortAsc(Pageable pageable,String categoryCode);

	/**
	 * @param dictionaryCod
	 */
	Iterable<DictionaryItemInfo> findByCategoryCodeOrderBySortAsc(String categoryCode);

	/**
	 * 获得一条数据字典项
	 * @param itemCode
	 * @return
	 */
	DictionaryItemInfo findOneByDictionaryCode(String dictionaryCode);

	/**
	 * 通过字典的类别和代码找到字典项
	 * @param categoryCode
	 * @param dictionaryCode
	 * @return
	 */
	List<DictionaryItemInfo> findByCategoryCodeAndDictionaryCodeOrderBySortAsc(String categoryCode,String dictionaryCode);

}
