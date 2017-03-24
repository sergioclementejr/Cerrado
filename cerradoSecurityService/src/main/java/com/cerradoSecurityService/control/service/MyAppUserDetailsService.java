package com.cerradoSecurityService.control.service;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cerradoSecurityService.dao.IUserDAO;
import com.cerradoSecurityService.model.valueObjects.UserVO;


@Service
public class MyAppUserDetailsService
  implements UserDetailsService {
  @Autowired
  private IUserDAO userDAO;

  @Override
  public UserDetails loadUserByUsername(String userName)
    throws UsernameNotFoundException {
    UserVO activeUser = userDAO.getActiveUser(userName);
    GrantedAuthority authority =
      new SimpleGrantedAuthority(activeUser.getRole());
    UserDetails userDetails =
      (UserDetails) new User(activeUser.getUsername(),
                             activeUser.getPassword(),
                             Arrays.asList(authority));
    return userDetails;
  }
}
