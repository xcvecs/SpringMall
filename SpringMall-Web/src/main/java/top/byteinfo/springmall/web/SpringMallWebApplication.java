package top.byteinfo.springmall.web;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScannerRegistrar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMallWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMallWebApplication.class, args);
    }
    MapperScannerRegistrar mapperScannerRegistrar;
    MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean;
    SqlSessionTemplate sqlSessionTemplate;

//    @Bean
//    public GroupedOpenApi adminApi() {
//        return GroupedOpenApi.builder()
//                .build();
//    }
//    @Bean
//    public GroupedOpenApi usersGroup(@Value("${springdoc.version}") String appVersion) {
//        return GroupedOpenApi.builder()
//                .group("users")
//                .addOperationCustomizer((operation, handlerMethod) -> {
//                    operation.addSecurityItem(new SecurityRequirement().addList("basicScheme"));
//                    return operation;
//                })
//                .addOpenApiCustomiser(openApi -> openApi.info(new Info().title("Users API").version(appVersion)))
//                .packagesToScan("top.byteinfo.springmall.web")
//                .build();
//    }


}
