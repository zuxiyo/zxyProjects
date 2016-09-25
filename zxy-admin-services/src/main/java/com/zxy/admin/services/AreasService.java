/*
 * Created by Zhu XiYong <zuxiyo@sohu.com> at 2016年9月19日上午12:05:23
 * 
 * 作        者：Zhu XiYong(zuxiyo@sohu.com)
 * 创建时间： 2016年9月19日上午12:05:23
 */
package com.zxy.admin.services;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.zxy.admin.dao.IAreasDao;
import com.zxy.admin.entities.AreaInfo;
import com.zxy.admin.entities.queries.AreaQueryInfo;

/**
 * 行政区划逻辑层
 * @author Zhu XiYong 
 * @Date 2016年9月19日上午12:05:23
 */
@Service
public class AreasService {
	@Autowired
	private IAreasDao areasDao;

	/**
	 * 检查 行政区划 是否已存在
	 * @param areaCode
	 * @return 存在 true，不存在 false
	 */
	public boolean exists(String areaCode){
		if(areasDao.exists(areaCode)){
			return true;
		}
		return false;
	}
	
	/**
	 * 新增一个 行政区划
	 * @param model
	 * @return 新增后的实体
	 * @throws IllegalArgumentException 行政区划代码【areaCode】已存在！
	 */ 
	public AreaInfo add(AreaInfo model) {
		
		if(exists(model.getAreaCode())){
			throw new IllegalArgumentException("行政区划代码【" + model.getAreaCode() +"】已存在！");
		}
		
		AreaInfo result = areasDao.save(model);
		return result;
	}
	
	/**
	 * 更新一个 行政区划
	 * @param model
	 * @return 更新后的实体
	 */
	public AreaInfo update(AreaInfo model) {
		AreaInfo result = areasDao.save(model);
		return result;	
	}
	
	/**
	 * 删除 一个 行政区划 信息
	 * @param areaCode
	 * @return
	 */
	public void delete(String areaCode){
		areasDao.delete(areaCode);	
	}
	
	/**
	 *  删除 一批 行政区划 信息
	 * @param AreaInfo
	 */
	public void delete(String[] AreaInfo) {
		for(String s:AreaInfo)
			delete(s);
	}
	
	/**
	 * 获得数据列表
	 * @param pageable
	 * @return
	 */
	public Page<AreaInfo> getPageList(Pageable pageable) {
		
		if(pageable.getSort() == null){
			Order[] order = { new Order(Direction.ASC,"areaCode"), new Order(Direction.ASC,"sort")};
			Sort sort = new Sort(order);
			pageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(),sort);
		}
					
		Page<AreaInfo> pageData = areasDao.findAll(pageable);
		return pageData;
	}
	
	public Page<AreaInfo> getPageList(Pageable pageable, AreaQueryInfo queryInfo) {
		Page<AreaInfo> pageData;
		pageData = areasDao.findAll(
				new Specification<AreaInfo>() {

					public Predicate toPredicate(Root<AreaInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
						
						Predicate predicate = cb.conjunction();
			            List<Expression<Boolean>> expressions = predicate.getExpressions();
			            
						if(!StringUtils.isEmpty(queryInfo.getCountryCode())){
							expressions.add(cb.equal(root.get("countryCode").as(String.class), queryInfo.getCountryCode()));							  
						}
						
						if(!StringUtils.isEmpty(queryInfo.getAreaCode())){
							expressions.add(cb.like(root.get("areaCode").as(String.class), queryInfo.getAreaCode()+"%"));							  
						}
						
						if(!StringUtils.isEmpty(queryInfo.getAreaName())){
							expressions.add(cb.like(root.get("areaName").as(String.class),  "%" + queryInfo.getAreaName()+"%"));							  
						}
				        				        					        
				        Predicate[] p = new Predicate[expressions.size()]; 
				        cb.and(expressions.toArray(p));
				        query.where(cb.and(expressions.toArray(p)));
				        query.orderBy(cb.asc(root.get("areaCode").as(String.class)),cb.asc(root.get("sort").as(Integer.class)));  
				        
				        return query.getRestriction();  
					}
					
				}, pageable);
		
		return pageData;
	}
	
	/**
	 * 获得一个实体信息类
	 * @param areaCode
	 * @return
	 */
	public AreaInfo getEntity(String areaCode) {	
		return areasDao.findOne(areaCode);
	}
	
	/**
	 * 通过国家代码获得省一级的行政区划
	 * @param countryCode
	 * @return
	 */
	public Iterable<AreaInfo> getProvinceAreasByCountyCode(String countryCode){
		return areasDao.findByCountryCodeAndParentCode(countryCode,"0"); 
	}

	/**
	 * 通过父级行政区划代码获得子级行政区划
	 * @param parentCode
	 * @return
	 */
	public Iterable<AreaInfo> getAreasByParentCode(String parentCode) {
		return areasDao.findByParentCode(parentCode); 
	}
}
