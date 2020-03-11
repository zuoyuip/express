package org.fast.express.server.config;

import static springfox.documentation.schema.AlternateTypeRules.newRule;

import com.fasterxml.classmate.TypeResolver;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.petstore.controller.PetController;

/**
 * SwaggerAPI配置.
 *
 * @author zuoyu
 * @program express
 * @create 2020-03-10 14:03
 **/
@EnableSwagger2
@Import(value = {PetController.class, BeanValidatorPluginsConfiguration.class})
@ConfigurationProperties(prefix = "swagger.config")
public class SwaggerConfig {


  private final TypeResolver typeResolver;
  private boolean enabled = false;
  private boolean urlTemplating = true;
  private boolean forCodeGen = true;

  public SwaggerConfig(TypeResolver typeResolver) {
    this.typeResolver = typeResolver;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public void setUrlTemplating(boolean urlTemplating) {
    this.urlTemplating = urlTemplating;
  }

  public void setForCodeGen(boolean forCodeGen) {
    this.forCodeGen = forCodeGen;
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
        .directModelSubstitute(LocalDate.class, String.class)
        .genericModelSubstitutes(ResponseEntity.class)
        .alternateTypeRules(
            newRule(typeResolver.resolve(DeferredResult.class,
                typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
                typeResolver.resolve(WildcardType.class)))
        .useDefaultResponseMessages(true)
        .securitySchemes(Collections.singletonList(apiKey()))
        .securityContexts(Collections.singletonList(securityContext()))
//        .globalResponseMessage(null, null)
//        .additionalModels(null)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors
            .any())
        .paths(PathSelectors.any())
        .build()
        .pathMapping("/")
        .enable(enabled)
        .enableUrlTemplating(urlTemplating)
        .forCodeGeneration(forCodeGen);
  }

  @Bean
  SecurityConfiguration security() {
    return SecurityConfigurationBuilder.builder()
        .clientId("express-client-id")
        .clientSecret("express-client-secret")
        .realm("express-app-realm")
        .appName("Express")
        .scopeSeparator(",")
        .additionalQueryStringParams(null)
        .useBasicAuthenticationWithAccessCodeGrant(true)
        .build();
  }

  private ApiKey apiKey() {
    return new ApiKey("zuoyu", "express_key", "header");
  }

  private SecurityContext securityContext() {
    return SecurityContext.builder()
        .securityReferences(defaultAuth())
        .forPaths(PathSelectors.any())
        .build();
  }

  private List<SecurityReference> defaultAuth() {
    AuthorizationScope authorizationScope
        = new AuthorizationScope("global", "accessEverything");
    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
    authorizationScopes[0] = authorizationScope;
    return Collections.singletonList(
        new SecurityReference("zuoyu", authorizationScopes));
  }

  /**
   * UI设置
   */
  @Bean
  UiConfiguration uiConfig() {
    return UiConfigurationBuilder.builder()
        .deepLinking(true)
        .displayOperationId(false)
        .defaultModelsExpandDepth(1)
        .defaultModelExpandDepth(1)
        .defaultModelRendering(ModelRendering.EXAMPLE)
        .displayRequestDuration(true)
        .docExpansion(DocExpansion.NONE)
        .filter(false)
        .maxDisplayedTags(null)
        .operationsSorter(OperationsSorter.ALPHA)
        .showExtensions(true)
        .tagsSorter(TagsSorter.ALPHA)
        .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
        .validatorUrl(null)
        .build();
  }

}
