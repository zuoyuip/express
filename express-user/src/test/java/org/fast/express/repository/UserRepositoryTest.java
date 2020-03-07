package org.fast.express.repository;

//import static org.junit.jupiter.api.Assertions.*;

import org.fast.express.ExpressUserApplicationTests;
import org.fast.express.entity.UserDO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class UserRepositoryTest extends ExpressUserApplicationTests {


  @Autowired
  private UserRepository userRepository;

  @Test
  void testSave(){
    userRepository.save(new UserDO());
  }
}