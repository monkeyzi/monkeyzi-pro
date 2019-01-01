package com.monkeyzi.mcloud.common.swagger.config;

import cn.hutool.core.collection.CollUtil;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
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
import sun.security.krb5.internal.APOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 高yg
 * @date: 2018/12/23 21:37
 * @qq:854152531@qq.com
 * @blog http://www.monkeyzi.xin
 * @description:swagger配置
 */
@Configuration
@EnableSwagger2
public class SwaggerAutoConfiguration {
    /**
     * 默认排除的url
     */
    private static final String DEFAULT_EXCLUDE_PATH="/error";
    /**
     * 基础的路径
     */
    private static final String BASE_PATH="/**";

    @Bean
    @ConditionalOnMissingBean
    public SwaggerProperties swaggerProperties(){
        return new SwaggerProperties();
    }

    @Bean
    public Docket api(SwaggerProperties swaggerProperties){
        if (CollUtil.isEmpty(swaggerProperties.getBasePath())){
            swaggerProperties.getBasePath().add(BASE_PATH);
        }
        List<Predicate<String>> basePath=new ArrayList<>();
        swaggerProperties.getBasePath().forEach(path->basePath.add(PathSelectors.ant(path))
        );
        //exclude_path的处理
        if (CollUtil.isEmpty(swaggerProperties.getExcludePath())){
            swaggerProperties.getExcludePath().add(DEFAULT_EXCLUDE_PATH);
        }
        List<Predicate<String>> excludePath=new ArrayList<>();
        swaggerProperties.getExcludePath().forEach(path->excludePath.add(PathSelectors.ant(path)));
        return new Docket(DocumentationType.SWAGGER_2)
               .host(swaggerProperties.getHost())
                .apiInfo(apiInfo(swaggerProperties)).select()
                .apis(RequestHandlerSelectors.basePackage(swaggerProperties.getBasePackage()))
                .paths(Predicates.and(Predicates.not(Predicates.or(excludePath)), Predicates.or(basePath)))
                .build();

    }

    private ApiInfo apiInfo(SwaggerProperties swaggerProperties) {
        return new ApiInfoBuilder()
                .title(swaggerProperties.getTitle())
                .description(swaggerProperties.getDescription())
                .license(swaggerProperties.getLicense())
                .licenseUrl(swaggerProperties.getLicenseUrl())
                .termsOfServiceUrl(swaggerProperties.getTermsOfServiceUrl())
                .contact(new Contact(swaggerProperties.getContact().getName(), swaggerProperties.getContact().getUrl(), swaggerProperties.getContact().getEmail()))
                .version(swaggerProperties.getVersion())
                .build();
    }


}
