package org.fast.express.order;

import org.fast.express.user.UserModuleContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

/**
 * 订单模块扫描.
 *
 * @author zuoyu
 * @program express
 * @create 2020-03-07 23:01
 **/
@Profile("dev")
@SpringBootApplication(scanBasePackageClasses = UserModuleContext.class)
public class OrderModuleContext {

}
