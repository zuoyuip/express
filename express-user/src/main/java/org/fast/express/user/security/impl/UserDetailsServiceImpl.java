package org.fast.express.user.security.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 认证实现.
 *
 * @author zuoyu
 * @program express
 * @create 2020-03-07 22:52
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {


  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    return null;
  }
}
