<#macro CountriesDropDownList id  dataSource name="" selected="" class="form-control">
  <#if (name == "")|| name?? >
	  <#local name = id>
  </#if>
   <select id="${id}" name="${name}" class="${class}">
      <option  value="">---请选择---</option>
      <#list dataSource as item>
	     <#if item.countryCode == selected>
	        <option value="${item.countryCode}" selected>${item.countryName}</option>
	     <#else>   
	        <option value="${item.countryCode}">${item.countryName}</option>
	     </#if>
	  </#list>
   </select>
</#macro>