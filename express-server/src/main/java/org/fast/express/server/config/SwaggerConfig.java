package org.fast.express.server.config;

import com.fasterxml.classmate.TypeResolver;
import io.swagger.models.Swagger;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRule;
import springfox.documentation.schema.AlternateTypeRuleConvention;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerAPI配置.
 *
 * @author zuoyu
 * @program express
 * @create 2020-03-10 14:03
 **/
@EnableSwagger2
@ConfigurationProperties(prefix = "swagger.config")
public class SwaggerConfig {


  private boolean enabled = false;

  private boolean urlTemplating = true;

  private boolean forCodeGen = true;

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public void setUrlTemplating(boolean urlTemplating) {
    this.urlTemplating = urlTemplating;
  }

  public void setForCodeGen(boolean forCodeGen) {
    this.forCodeGen = forCodeGen;
  }

  @Bean
  public AlternateTypeRuleConvention pageableConvention(final TypeResolver resolver) {
    return new AlternateTypeRuleConvention() {
      @Override
      public List<AlternateTypeRule> rules() {
        return null;
      }

      @Override
      public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
      }


    };
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("快递平台后端API文档")
        .description("快递平台接口说明")
        .version("1.0.0")
        .build();
  }

  @Bean
  public Docket restApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .enable(enabled)
        .enableUrlTemplating(urlTemplating)
        .forCodeGeneration(forCodeGen)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors
            .basePackage("org.fast.express"))
        .paths(PathSelectors.any())
        .build();
  }
}
