package com.studentsadmin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * configuration specific for the swagger documentation.
 * This configuration is currently only active if the spring-profile test is activated.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${application.version}")
    private String version;

    @Value("${application.name}")
    private String name;

    /**
     * bean which creates the swaggerjson, if activated it is shown at url {root}/v2/api-docs.
     * @return a bean.
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.regex("/.*"))
            .build()
            .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title(name)
            .version(version)
            .build();
    }

}
