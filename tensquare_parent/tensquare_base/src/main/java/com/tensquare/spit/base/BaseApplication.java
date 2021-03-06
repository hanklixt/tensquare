package com.tensquare.spit.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import util.IdWorker;

@EnableSwagger2
@SpringBootApplication
@MapperScan("com.tensquare.base.mapper")
public class BaseApplication {
  public static void main(String[] args) {
    //
      SpringApplication.run(BaseApplication.class,args);
  }

  @Bean
    public IdWorker idWorker(){
      return new IdWorker(1,1);
  }

  @Bean
  public Docket createRestApi() {
    return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            ////为当前包路径
            .apis(RequestHandlerSelectors.basePackage("com.tensquare.base.controller"))
            .paths(PathSelectors.any())
            .build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
            .title("Spring Boot中使用Swagger2构建RESTful APIs")
            .version("1.0")
            .build();
  }
}
