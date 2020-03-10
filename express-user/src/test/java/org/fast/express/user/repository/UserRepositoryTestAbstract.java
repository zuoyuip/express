package org.fast.express.user.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.fast.express.order.common.status.BaseStatus;
import org.fast.express.order.common.utils.JsonUtil;
import org.fast.express.order.common.utils.Result;
import org.fast.express.user.AbstractExpressUserModuleTests;
import org.fast.express.user.entity.UserDO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
class UserRepositoryTestAbstract extends AbstractExpressUserModuleTests {


  @Autowired
  private UserRepository userRepository;


  @Test
  void save() {
    UserDO userDO = userRepository
        .save(new UserDO().setUserPhone("15838271463").setUserPassword("123"));
    assertNotNull(userDO, "user return is null! error");
  }

  @Test
  void findAll() {
    userRepository.findAll().forEach(System.out::println);
  }

  @Test
  void result() {
    List<UserDO> userDOList = userRepository.findAll();
    Result<Object> result = Result.builder().resultStatus(BaseStatus.SUCCESS).data(userDOList)
        .build();
    String jsonString = JsonUtil.objectToJsonString(result);
    log.info(jsonString);
  }
}