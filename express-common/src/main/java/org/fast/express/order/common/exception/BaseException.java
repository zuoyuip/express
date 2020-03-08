package org.fast.express.order.common.exception;

import org.fast.express.order.common.enums.BaseStatusEnum;
import org.springframework.http.HttpStatus;

/**
 * 自定义基础异常.
 *
 * @author zuoyu
 * @program express
 * @create 2020-03-08 15:54
 **/
public abstract class BaseException extends RuntimeException {

  /**
   * 状态码
   */
  private int code;

  public BaseException(BaseStatusEnum statusEnum) {
    super(statusEnum.getMessage());
    this.code = statusEnum.getCode();
  }

  public BaseException(HttpStatus status) {
    super(status.getReasonPhrase());
    this.code = status.value();
  }

  public BaseException(String message) {
    super(message);
  }
}
