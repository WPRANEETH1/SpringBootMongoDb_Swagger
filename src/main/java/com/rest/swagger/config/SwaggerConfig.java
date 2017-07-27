package com.rest.swagger.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import javax.servlet.ServletContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(ServletContext servletContext) {
        return new Docket(DocumentationType.SWAGGER_2)
                //                .pathProvider(new RelativePathProvider(servletContext) {
                //                    @Override
                //                    public String getApplicationBasePath() {
                ////                        return super.getApplicationBasePath() + "/api";
                //                        return "/api";
                //                    }
                //                })

                //                .host("maze.world")
                .apiInfo(studentAPIInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(studentsPaths())
                .build();
    }

    private Predicate<String> studentsPaths() {
        return Predicates
                .or(regex("/api/buildings.*"));
    }

    private ApiInfo studentAPIInfo() {
        return new ApiInfoBuilder()
                .title("Maze Server API")
                .description("Maze AI for querying and submitting data into data store")
                .license("")
                .licenseUrl("")
                .termsOfServiceUrl("")
                .version("1.0.0")
                .contact(new Contact("", "", ""))
                .build();
    }
}
