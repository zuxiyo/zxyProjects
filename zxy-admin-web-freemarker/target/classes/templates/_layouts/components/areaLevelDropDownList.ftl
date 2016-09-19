
<#macro areaLevelSelect id  selected="" class="form-control">
   <#local areaDatas = {"1":"省级","2":"地市级","3":"县级","4":"镇"}>  
   <select id="${id}" name="${id}" class="${class}">
      <option>---请选择---</option>
      <#list areaDatas?keys as mKey>
	     <#if mKey == selected>
	        <option value="${mKey}" selected>${areaDatas[mKey]}</option>
	     <#else>   
	       <option value="${mKey}">${areaDatas[mKey]}</option>
	     </#if>
	  </#list>
   </select>
</#macro>