package org.fast.express.user.service.impl;

import com.google.common.base.Preconditions;
import java.util.Optional;
import java.util.function.Predicate;
import org.fast.express.user.entity.UserDO;
import org.fast.express.user.exception.UserException;
import org.fast.express.user.model.UserDTO;
import org.fast.express.user.repository.UserRepository;
import org.fast.express.user.service.IUserService;
import org.fast.express.user.status.UserStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * UserServiceImpl.
 *
 * @author zuoyu
 * @program express
 * @create 2020-03-10 18:57
 **/
@Service
@Transactional(rollbackFor = {UserException.class, Exception.class})
class UserServiceImpl implements IUserService {

  private final UserRepository userRepository;

  UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void register(@NonNull UserDTO dto) {
    UserDO userDO = new UserDO();
    BeanUtils.copyProperties(dto, userDO);
    ExampleMatcher userPhoneExact = ExampleMatcher.matching()
        .withMatcher("userPhone", GenericPropertyMatchers.exact());
    boolean userPhoneExists = userRepository.exists(Example.of(userDO, userPhoneExact));
    if (userPhoneExists){
      throw new UserException(UserStatus.USER_IS_EXISTS);
    }
    userRepository.save(userDO);
  }

  @Override
  public UserDO login(UserDTO dto) {
    UserDO userDO = new UserDO();
    BeanUtils.copyProperties(dto, userDO);
    ExampleMatcher userPhoneExact = ExampleMatcher.matching()
        .withMatcher("userPhone", GenericPropertyMatchers.exact());
    Optional<UserDO> one = userRepository.findOne(Example.of(userDO, userPhoneExact));
    return one.orElseThrow(() -> new UserException(UserStatus.ACCOUNT_NOT_EXIST));
  }
}
