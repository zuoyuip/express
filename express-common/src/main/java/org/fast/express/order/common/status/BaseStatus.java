package org.fast.express.order.common.status;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.lang.NonNull;

/**
 * 基础状态枚举.
 *
 * @author zuoyu
 * @program express
 * @create 2020-03-08 15:02
 **/
@ApiModel(value = "BaseStatus", description = "状态数据和信息的详情")
public interface BaseStatus {

  @Getter
  @ToString
  @AllArgsConstructor
  final class Status{
    /**
     * 状态码
     */
    private int code;

    /**
     * 相应信息
     */
    @NonNull
    private String message;
  }


  /**
   * 操作成功
   */
  @ApiModelProperty(value = "操作成功")
  Status SUCCESS = new Status(1, "操作成功");

  /**
   * 操作失败
   */
  @ApiModelProperty(value = "操作失败")
  Status FAIL = new Status(0, "操作失败");



}
