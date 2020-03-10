package org.fast.express.user.service;

import org.fast.express.user.entity.UserDO;
import org.fast.express.user.model.UserDTO;
import org.springframework.lang.NonNull;

/**
 * 用户业务.
 *
 * @author zuoyu
 * @program express
 * @create 2020-03-10 18:51
 **/
public interface IUserService {

  /**
   * 用户注册
   * @param dto - 用户数据
   */
  void register(@NonNull UserDTO dto);

  /**
   * 用户登录
   * @param dto - 帐号密码
   * @return - 登录结果
   */
  UserDO login(UserDTO dto);
}
