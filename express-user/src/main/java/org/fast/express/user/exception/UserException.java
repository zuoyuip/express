package org.fast.express.user.exception;

import org.fast.express.order.common.exception.BaseException;
import org.fast.express.order.common.status.BaseStatus.Status;
import org.fast.express.user.status.UserStatus;
import org.springframework.http.HttpStatus;

/**
 * 用户业务异常.
 *
 * @author zuoyu
 * @program express
 * @create 2020-03-10 19:07
 **/
public class UserException extends BaseException {

  public UserException(UserStatus.Status status) {
    super(status);
  }


  public UserException(HttpStatus status) {
    super(status);
  }

  public UserException(String message) {
    super(message);
  }
}
