package org.fast.express.user;

import org.fast.express.user.security.SecurityConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
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
@Import(value = {SecurityConfig.class})
public class UserModuleContext {

}
