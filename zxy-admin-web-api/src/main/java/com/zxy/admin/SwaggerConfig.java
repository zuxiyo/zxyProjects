/*
 * Created by Zhu XiYong <zuxiyo@sohu.com> at 2016年12月7日 下午5:09:16
 * 
 * 作        者：Zhu XiYong(zuxiyo@sohu.com)
 * 创建时间： 2016年12月7日 下午5:09:16
 */
package com.zxy.admin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ZhuXY 
 * @date 2016年12月7日 下午5:09:16 
 * 查看API地址 http://localhost:8090/swagger-ui.html
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zxy.admin.api"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
        .title(" zxy-admin 后台管理  RESTful APIs")
        .description("项目地址：https://github.com/zuxiyo/zxyProjects")    //http://www.cnblogs.com/zuxiyo/
        .termsOfServiceUrl("https://github.com/zuxiyo/zxyProjects")
        .contact(new Contact("ZhuXY","https://github.com/zuxiyo/zxyProjects","zuxiyo@sohu.com"))
        .version("1.0")
        .build();
    }
}
