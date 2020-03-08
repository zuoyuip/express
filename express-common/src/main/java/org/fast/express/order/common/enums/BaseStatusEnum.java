package org.fast.express.order.common.enums;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 基础返回枚举.
 *
 * @author zuoyu
 * @program express
 * @create 2020-03-08 15:02
 **/
@Getter
@AllArgsConstructor
@ApiModel(value = "BaseResultEnum", description = "响应数据和信息的详情")
public enum BaseStatusEnum {

  /**
   * 操作成功
   */
  @ApiModelProperty(value = "操作成功")
  SUCCESS(1, "操作成功"),

  /**
   * 操作失败
   */
  @ApiModelProperty(value = "操作失败")
  FAIL(0, "操作失败"),

  ;

  /**
   * 状态码
   */
  private int code;

  /**
   * 相应信息
   */
  private String message;


}
