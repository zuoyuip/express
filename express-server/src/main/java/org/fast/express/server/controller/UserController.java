package org.fast.express.server.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.fast.express.order.common.utils.Result;
import org.fast.express.user.model.UserDTO;
import org.fast.express.user.service.IUserService;
import org.fast.express.user.status.UserStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制.
 *
 * @author zuoyu
 * @program express
 * @create 2020-03-10 23:16
 **/
@RestController
@RequestMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "安全账户操作API", tags = "userAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

  private final IUserService iUserService;

  public UserController(IUserService iUserService) {
    this.iUserService = iUserService;
  }

  @PostMapping(path = "/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  @ApiOperation(value = "根据传入的信息进行注册", response = Result.class,
      consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, ignoreJsonView = true)
  @ApiImplicitParams({
      @ApiImplicitParam(name = "phone", value = "手机号", required = true, dataTypeClass = String.class),
      @ApiImplicitParam(name = "password", value = "密码", required = true, dataTypeClass = String.class)
  })
  public ResponseEntity<Result> register(String phone, String password) {
    iUserService.register(new UserDTO());
    return ResponseEntity.ok(Result.builder()
        .resultStatus(UserStatus.REGISTER_SUCCESS).build());
  }
}
