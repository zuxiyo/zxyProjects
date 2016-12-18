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
import org.springframework.data.domain.PageRequest;
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
	 * 检查 数据字典的种类 是否已存在
	 * @param categoryCode
	 * @return 存在 true，不存在 false
	 */
	public boolean existsCategory(String categoryCode){
		DictionaryCategoryInfo model = dataCategoryDao.findOneByCategoryCode(categoryCode);
		if(model != null){
			return true;
		}
		return false;
	}
	
	/**
	 * 保存一条数据字典的种类
	 * @param model 数据字典种类信息
	 * @return addedModel
	 */
	public DictionaryCategoryInfo addCategory(DictionaryCategoryInfo model){		
		DictionaryCategoryInfo addedModel = dataCategoryDao.save(model);
		return addedModel;		
	}
	
	/**
	 * 更新一条数据字典的种类
	 * @param model
	 */
	public DictionaryCategoryInfo updateCategory(DictionaryCategoryInfo model) {
		if (dataCategoryDao.exists(model.getUid())) {
			DictionaryCategoryInfo updatedModel = dataCategoryDao.save(model);
			return updatedModel;
		}
		return null;
	}
	
	/**
	 * 获得一个数据字典种类
	 * @param uid
	 * @return
	 */
	public DictionaryCategoryInfo getCategoryEntity(String uid) {
		return dataCategoryDao.findOne(uid);
	}

	/**
	 * 获得同类别代码的数据字典种类
	 * @param categoryCode
	 * @return 同类别代码的数据集
	 */
	public List<DictionaryCategoryInfo> getCategoryEntityByCategoryCode(String categoryCode) {
		return dataCategoryDao.findByCategoryCode(categoryCode);
	}
	/**
	 * 删除一批数据字典种类
	 * @param uid
	 */
	public void deleteCategory(String[] uid) {
		for(String s:uid)
			deleteCategory(s);
	}

	/**
	 * 删除一个数据字典种类
	 * @param string
	 */
	public void deleteCategory(String uid) {
		 dataCategoryDao.delete(uid);;		
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
	 * 获得数据字典类别的分页数据
	 * @param pageIndex 当前页码
	 * @param pageSize 一页的记录数
	 * @return 数据字典类别的分页数据
	 */
	public Page<DictionaryCategoryInfo> getCategoryPage(int pageIndex, int pageSize) {
		Pageable pageable = new PageRequest(pageIndex, pageSize); 
		Page<DictionaryCategoryInfo> page = dataCategoryDao.findAllByOrderBySortAsc(pageable);
		return page;
	}
	
	/**
	 * 检查 数据字典 是否已存在
	 * @param Item
	 * @return 存在 true，不存在 false
	 */
	public boolean existsItem(String categoryCode,String dictionaryCode){
		
		List<DictionaryItemInfo> list = getItemEntityByCategoryCodeAndDictionaryCode(categoryCode,dictionaryCode);
		if(list != null && list.size() > 0){
			return true;
		}
		return false;
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
		Page<DictionaryItemInfo> page = dataItemsDao.findByCategoryCodeOrderBySortAsc(pageable,categoryCode);	
		return page;
	}

	/**
	 * 获得全部数据字典项
	 * @param categoryCode
	 * @return
	 */
	public Iterable<DictionaryItemInfo> getItemDataByCategoryCode(String categoryCode) {		
		Iterable<DictionaryItemInfo> list = dataItemsDao.findByCategoryCodeOrderBySortAsc(categoryCode);
		return list;
	}
	/**
	 * 使用categoryCode和dictionaryCode 获得数据字典项
	 * @param categoryCode
	 * @param dictionaryCode
	 * @return
	 */
	public List<DictionaryItemInfo> getItemEntityByCategoryCodeAndDictionaryCode(String categoryCode, String dictionaryCode) {
		List<DictionaryItemInfo> list = dataItemsDao.findByCategoryCodeAndDictionaryCodeOrderBySortAsc(categoryCode,dictionaryCode);
		return list;
	}
	
	/**
	 * 活动指定页的数据字典项
	 * @param pageIndex
	 * @param pageSize
	 * @param categoryCode
	 * @return 指定页的数据字典项列表
	 */
	public Page<DictionaryItemInfo> getItemPage(int pageIndex, int pageSize, String categoryCode) {

		Pageable pageable = new PageRequest(pageIndex, pageSize); 
		Page<DictionaryItemInfo> page = dataItemsDao.findByCategoryCodeOrderBySortAsc(pageable, categoryCode);
		return page;
	}
	
	/**
	 * 获得字典项
	 * @param categoryCode
	 * @return
	 */
	public Iterable<DictionaryItemInfo> getDictionary(String categoryCode) {		
		return getItemDataByCategoryCode(categoryCode);
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

	/**
	 * 获取一个数据字典
	 * @param uid
	 * @return
	 */
	public DictionaryItemInfo getItemEntity(String uid) {
		return dataItemsDao.findOne(uid);
	}

	/**
	 * 删除一批数据字典
	 * @param uid
	 */
	public void deleteItem(String[] uid) {
		for(String s:uid)
			deleteItem(s);
	}

	/**
	 * 删除一个数据字典
	 * @param string
	 */
	public void deleteItem(String uid) {
		dataItemsDao.delete(uid);
	}

	/**
	 * 更新一个数据字典
	 * @param model
	 */
	public DictionaryItemInfo updateItem(DictionaryItemInfo model) {
		if (dataItemsDao.exists(model.getUid())) {
			DictionaryItemInfo result = dataItemsDao.save(model);
			return result;
		}
		return null;
	}
}
