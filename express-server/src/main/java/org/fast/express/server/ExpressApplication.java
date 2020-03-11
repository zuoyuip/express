package org.fast.express.server;

import org.fast.express.order.OrderModuleContext;
import org.fast.express.server.config.RedisCacheConfig;
import org.fast.express.server.config.SwaggerConfig;
import org.fast.express.server.config.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zuoyu
 */
@EnableCaching
@EnableScheduling
@EnableTransactionManagement
@EnableConfigurationProperties(value = {SwaggerConfig.class})
@SpringBootApplication
@Import(value = {WebConfig.class, RedisCacheConfig.class, OrderModuleContext.class})
public class ExpressApplication {


  public static void main(String[] args) {
    SpringApplication.run(ExpressApplication.class, args);
  }

}

