/*
 * Created by Zhu XiYong <zuxiyo@sohu.com> at 2016年9月6日下午11:07:41
 * 
 * 作        者：Zhu XiYong(zuxiyo@sohu.com)
 * 创建时间： 2016年9月6日下午11:07:41
 */
package com.zxy.admin.controllers.utils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * 
 * @author Zhu XiYong 
 * @Date 2016年9月6日下午11:07:41
 */
public class DataTablesUtil {
	
	/**
	 * 获得适合DataTables的分页参数
	 * @param request Web请求
	 * @param class1 
	 * @return 分页对象
	 */
	/*public static Paging getPaging(HttpServletRequest request) {
		int pageIndex = 0;
		int pageSize = 10;

		if (request.getParameter("start") != null && !request.getParameter("start").isEmpty())
			pageIndex = Integer.parseInt(request.getParameter("start"));

		if (request.getParameter("length") != null && !request.getParameter("length").isEmpty())
			pageSize = Integer.parseInt(request.getParameter("length"));

		return new Paging(pageIndex, pageSize);
	}*/
	/**
	 * 获得适合DataTables的分页参数
	 * @param request Web请求
	 * @return 分页对象
	 */
	public static Pageable getPageable(HttpServletRequest request) {
		int pageIndex = 0;
		int pageSize = 10;
		
		/*Map<String,String[]> params = request.getParameterMap();  
        for(String attr:params.keySet()){  
            String[] val = params.get(attr);  
            
            if(attr.equals("start"))  
            	pageIndex = Integer.parseInt(val[0]);  
            if(attr.equals("length"))  
            	pageSize = Integer.parseInt(val[0]);
            if(attr.equals("search[value]"))  
                pattern = val[0];  
            
            //if(attr.equals("search[value]"))  
            //    pattern = val[0];  
            //if(attr.equals("draw"))  
            //    draw=val[0];  
        }
        //String str1 = request.getParameter("order");
		//String[] str2 = request.getParameterValues("order");
		//order[i]
		//		order[i][dir]
		//Sort sort = new Sort();
        */  	        
		
		if (request.getParameter("length") != null && !request.getParameter("length").isEmpty())
			pageSize = Integer.parseInt(request.getParameter("length"));
		
		//start 参数返回的是起始记录好，比如pageSize为10时值为0,10,20等，在这里将其转化为分页的索引号，以符合Spring对方法参数的要求。
		if (request.getParameter("start") != null && !request.getParameter("start").isEmpty())
			pageIndex = Math.abs(Integer.parseInt(request.getParameter("start"))/pageSize);
				
		return new PageRequest(pageIndex, pageSize);
	}
	/**= 
	 * 将JPA的page对象转换到适合DataTables的分页对象
	 * @param request
	 * @param page
	 * @return DataTables的分页对象
	 */
	public static DataTablesPageable ConvertToDataTablesPageable(HttpServletRequest request,Page<?> page){		
		DataTablesPageable dataTables = new DataTablesPageable();
		
		if (request.getParameter("draw") != null && !request.getParameter("draw").isEmpty())
			dataTables.setDraw(Integer.parseInt(request.getParameter("draw")));
		else
			dataTables.setDraw(1);
	
		dataTables.setData(page.getContent());
		dataTables.setRecordsTotal(page.getTotalElements());
		dataTables.setRecordsFiltered(page.getTotalElements());
		return dataTables;
	}
}
