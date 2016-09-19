/*
 * Created by Zhu XiYong <zuxiyo@sohu.com> at 2016年9月12日下午1:54:14
 * 
 * 作        者：Zhu XiYong(zuxiyo@sohu.com)
 * 创建时间： 2016年9月12日下午1:54:14
 */
package com.zxy.admin.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.zxy.admin.entities.AreaInfo;

/**
 * 行政区划数据层接口
 * @author Zhu XiYong 
 * @Date 2016年9月12日下午1:54:14
 */
public  interface IAreasDao extends PagingAndSortingRepository<AreaInfo,String> {

}
