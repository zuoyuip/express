package org.fast.express.server;

import org.fast.express.order.OrderModuleContext;
import org.fast.express.server.config.SwaggerConfig;
import org.fast.express.server.config.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
@SpringBootApplication(scanBasePackageClasses = OrderModuleContext.class)
@Import(value = {SwaggerConfig.class, WebConfig.class})
public class ExpressApplication {

  public static void main(String[] args) {
    SpringApplication.run(ExpressApplication.class, args);
  }

}

