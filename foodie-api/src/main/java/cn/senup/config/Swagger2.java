package cn.senup.config;

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
 * @Author: 涛哥
 * @Description: http://localhost:8088/doc.html
 * @Date: Created in 2020/5/30  10:44
 * @Modified By:
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    /**
     *
     * @auther: 涛哥
     * @Description: 配置swagger核心 docket
     * @date: 2020/5/30 10:55
     * @param: []
     * @return: springfox.documentation.spring.web.plugins.Docket
     *
     */
    @Bean
    public Docket createRestApi() {
        //指定api类型
        return new Docket(DocumentationType.SWAGGER_2)
                //用于定义api文档汇总信息
                .apiInfo(apiInfo())
                .select()
                //指定controller包
                .apis(RequestHandlerSelectors.basePackage("cn.senup.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("天天吃货 电商平台API")
                .contact(new Contact("涛哥", "https://www.senup.cn", "bestkxt@gmail.com"))
                .description("专为天天吃货提供的API文档")
                .version("1.0.1")
                .termsOfServiceUrl("https://www.senup.cn")
                .build();
    }
}
