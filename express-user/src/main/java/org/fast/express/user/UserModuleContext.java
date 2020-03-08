package org.fast.express.user;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

/**
 * 用户模块扫描.
 *
 * @author zuoyu
 * @program express
 * @create 2020-03-07 23:01
 **/
@Profile("dev")
@SpringBootApplication
public class UserModuleContext {

}
