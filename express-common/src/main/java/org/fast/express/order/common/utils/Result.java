package org.fast.express.order.common.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.fast.express.order.common.status.BaseStatus;
import org.springframework.util.Assert;

/**
 * 响应数据封装.
 *
 * @author zuoyu
 * @program express
 * @create 2020-03-08 14:57
 **/
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Result", description = "响应数据和信息的封装")
public class Result<T> {

  @NonNull
  @ApiModelProperty(value = "响应代码")
  private int code;

  @NonNull
  @ApiModelProperty(value = "响应信息")
  private String message;

  @ApiModelProperty(value = "响应数据")
  private T data;

  private Result(@NonNull int code, @NonNull String message) {
    this.code = code;
    this.message = message;
  }

  private Result(Builder<T> builder) {
    Assert.notNull(builder, "builder is not allowed null");
    this.code = builder.code;
    this.message = builder.message;
    this.data = builder.data;
  }

  public static <T> Result.Builder<T> builder() {
    return new Result.Builder<>();
  }


  public static class Builder<T> {

    private int code;

    private String message;

    private T data;

    public Builder<T> resultStatus(BaseStatus.Status status) {
      Assert.notNull(status, String.format("%s is not allowed null", status.toString()));
      this.code = status.getCode();
      this.message = status.getMessage();
      return this;
    }

    public Builder<T> data(T data) {
      this.data = data;
      return this;
    }

    public Result<T> build() {
      return new Result<>(this);
    }

  }


}
