package org.fast.express.server;

import org.fast.express.order.OrderModuleContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zuoyu
 */
@EnableCaching
@EnableScheduling
@EnableTransactionManagement
@SpringBootApplication(scanBasePackageClasses = OrderModuleContext.class)
public class ExpressApplication {

  public static void main(String[] args) {
    SpringApplication.run(ExpressApplication.class, args);
  }

}

