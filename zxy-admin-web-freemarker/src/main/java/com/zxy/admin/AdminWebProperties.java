
package com.zxy.admin;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "zxy.admin")  
public class AdminWebProperties {

	private String _countryCode;  
    public String getDefaultCountryCode() {  
        return _countryCode;  
    }  
    public void setDefaultCountryCode(String countryCode) {  
        this._countryCode = countryCode;  
    }  
}
