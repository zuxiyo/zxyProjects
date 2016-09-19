/*
 * Created by Zhu XiYong <zuxiyo@sohu.com> at 2016年9月4日下午1:56:22
 * 
 * 作        者：Zhu XiYong(zuxiyo@sohu.com)
 * 创建时间： 2016年9月4日下午1:56:22
 */
package com.zxy.admin.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.zxy.admin.entities.OrgInfo;

/**
 * 
 * @author Zhu XiYong 
 * @Date 2016年9月4日下午1:56:22
 */
public interface IOrgsDao extends Repository<OrgInfo,String> {
	
	Page<OrgInfo> findAll(); 
	@Query("select org from OrgInfo org where org.parentCode = 0")
	Page<OrgInfo> findByNameAndStateAllIgnoringCase(Pageable pageable); 
	
}
