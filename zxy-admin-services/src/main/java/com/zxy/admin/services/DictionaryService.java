/*
 * Created by Zhu XiYong <zuxiyo@sohu.com> at 2016年9月4日下午4:01:23
 * 
 * 作        者：Zhu XiYong(zuxiyo@sohu.com)
 * 创建时间： 2016年9月4日下午4:01:23
 */
package com.zxy.admin.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.zxy.admin.dao.IDictionaryCategoryDao;
import com.zxy.admin.dao.IDictionaryItemsDao;
import com.zxy.admin.entities.DictionaryCategoryInfo;
import com.zxy.admin.entities.DictionaryItemInfo;
import com.zxy.admin.utils.TreeNode;


/**
 * 数据字典服务
 * @author Zhu XiYong 
 * @Date 2016年9月4日下午4:01:23
 */
@Service
public class DictionaryService {

	@Autowired
	private IDictionaryCategoryDao dataCategoryDao;
	
	@Autowired
	private IDictionaryItemsDao dataItemsDao;
	/**
	 * 保存一条数据字典的种类
	 * @param model 数据字典种类信息
	 * @return
	 */
	public boolean addCategory(DictionaryCategoryInfo model){		
		dataCategoryDao.save(model);
		if(StringUtils.isEmpty(model.getUid()))
			return false;
		return true;		
	}
	
	/**
	 * 获得数据字典类别的分页数据
	 * @return 数据字典类别的集合
	 */
	public Page<DictionaryCategoryInfo> getCategoryPage(Pageable pageable){
		Page<DictionaryCategoryInfo> page = dataCategoryDao.findAll(pageable);
		return page;
	}
	
	
	/**
	 * 保存一条数据字典项
	 * @param model 数据字典项信息
	 * @return
	 */
	public boolean addItem(DictionaryItemInfo model){		
		dataItemsDao.save(model);
		if(StringUtils.isEmpty(model.getUid()))
			return false;
		return true;		
	}
	
	/**
	 * 获得全部数据字典项
	 * @return 全部数据字典项的集合
	 */
	public Page<DictionaryItemInfo> getItemPageByCategoryCode(Pageable pageable,String categoryCode){
		Page<DictionaryItemInfo> page = dataItemsDao.findByCategoryCode(pageable,categoryCode);	
		return page;
	}

	/**
	 * @param dictionaryCode
	 * @return
	 */
	public Iterable<DictionaryItemInfo> getItemDataByCategoryCode(String categoryCode) {
		Iterable<DictionaryItemInfo> list = dataItemsDao.findByCategoryCode(categoryCode);
		return list;
	}
	
	/**
	 * 获得zTree控件所需的数据格式
	 * @param categoryCode
	 * @return
	 */
	public Iterable<TreeNode> getZTreeItemList(String categoryCode){
		
		Iterable<DictionaryItemInfo> list = getItemDataByCategoryCode(categoryCode);
		
		List<TreeNode> result = new ArrayList<TreeNode>();
		for(DictionaryItemInfo info : list){
			TreeNode node = new TreeNode();
			node.setId(info.getDictionaryCode());
			node.setName(info.getDictionaryName());
			node.setpId(info.getParentCode());
			result.add(node);
		}
		return result;	
	}
}
