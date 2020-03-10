package org.fast.express.user.status;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.fast.express.order.common.status.BaseStatus;

/**
 * 用户状态.
 *
 * @author zuoyu
 * @program express
 * @create 2020-03-10 19:18
 **/
@ApiModel(value = "BaseStatus", description = "状态数据和信息的详情")
public interface UserStatus extends BaseStatus {

  /**
   * 账户已存在
   */
  @ApiModelProperty(value = "账户已存在")
  Status USER_IS_EXISTS = new Status(-1, "账户已存在");

  /**
   * 帐号不存在
   */
  @ApiModelProperty(value = "帐号不存在")
  Status ACCOUNT_NOT_EXIST = new Status(-2, "帐号不存在");

  /**
   * 注册成功
   */
  @ApiModelProperty(value = "注册成功")
  Status REGISTER_SUCCESS = new Status(1, "注册成功");

}
