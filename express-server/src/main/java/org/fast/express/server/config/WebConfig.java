package org.fast.express.server.config;

import java.nio.charset.StandardCharsets;
import java.util.List;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Web配置.
 *
 * @author zuoyu
 * @program express
 * @create 2020-03-10 14:25
 **/
public class WebConfig extends WebMvcConfigurationSupport {

  /**
   * 跨域
   */
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowedHeaders(CorsConfiguration.ALL)
        .allowedMethods(CorsConfiguration.ALL)
        .allowedOrigins(CorsConfiguration.ALL)
        .allowCredentials(true)
        .maxAge(3600L);
    super.addCorsMappings(registry);
  }

  @Override
  protected void addResourceHandlers(ResourceHandlerRegistry registry) {
    /*放行swagger*/
//    registry.addResourceHandler("swagger-ui.html")
//        .addResourceLocations("classpath:/META-INF/resources/");
//    registry.addResourceHandler("/webjars/**")
//        .addResourceLocations("classpath:/META-INF/resources/webjars/");
    super.addResourceHandlers(registry);
  }

  /**
   * 解决乱码
   */
  @Override
  protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
    super.configureMessageConverters(converters);
  }
}
