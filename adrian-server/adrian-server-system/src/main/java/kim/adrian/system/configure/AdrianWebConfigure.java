package kim.adrian.system.configure;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import kim.adrian.system.properties.AdrianServerSystemProperties;
import kim.adrian.system.properties.AdrianSwaggerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName AdrianWebConfigure
 * @Description MyBatis Plus分页插件配置
 * @Date 2020-01-07 14:22
 */
@EnableSwagger2
@Configuration
public class AdrianWebConfigure {

    private final AdrianServerSystemProperties properties;

    public AdrianWebConfigure(AdrianServerSystemProperties properties) {
        this.properties = properties;
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        List<ISqlParser> sqlParserList = new ArrayList<>();
        sqlParserList.add(new BlockAttackSqlParser());
        paginationInterceptor.setSqlParserList(sqlParserList);
        return paginationInterceptor;
    }

    @Bean
    public Docket swaggerApi() {
        AdrianSwaggerProperties swagger = properties.getSwagger();
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(swagger.getBasePackage()))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo(swagger))
                .securitySchemes(Collections.singletonList(securityScheme(swagger)))
                .securityContexts(Collections.singletonList(securityContext(swagger)));
    }

    private ApiInfo apiInfo(AdrianSwaggerProperties swagger) {
        return new ApiInfo(
                swagger.getTitle(),
                swagger.getDescription(),
                swagger.getVersion(),
                null,
                new Contact(swagger.getAuthor(), swagger.getUrl(), swagger.getEmail()),
                swagger.getLicense(), swagger.getLicenseUrl(), Collections.emptyList());
    }

    private SecurityScheme securityScheme(AdrianSwaggerProperties swagger) {
        GrantType grantType = new ResourceOwnerPasswordCredentialsGrant("http://localhost:8301/auth/oauth/token");

        return new OAuthBuilder()
                .name("adrian_oauth_swagger")
                .grantTypes(Collections.singletonList(grantType))
                .scopes(Arrays.asList(scopes(swagger)))
                .build();
    }

    private SecurityContext securityContext(AdrianSwaggerProperties swagger) {
        return SecurityContext.builder()
                .securityReferences(Collections.singletonList(new SecurityReference("adrian_oauth_swagger", scopes(swagger))))
                .forPaths(PathSelectors.any())
                .build();
    }

    private AuthorizationScope[] scopes(AdrianSwaggerProperties swagger) {
        return new AuthorizationScope[]{
                new AuthorizationScope("test", "")
        };
    }
}
