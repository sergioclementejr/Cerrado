package com.cerradoSic.control.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cerradoSic.model.facade.ModelFacade;
import com.cerradoSic.model.valueObjects.Usuario;


@Service
public class MyAppUserDetailsService implements UserDetailsService {
  @Autowired
  private ModelFacade facade;
  @Override
  public UserDetails loadUserByUsername(String userName)
      throws UsernameNotFoundException {
    Usuario usuario = facade.load(Usuario.class, userName);
    GrantedAuthority authority = new SimpleGrantedAuthority(usuario.getRole());
    UserDetails userDetails = (UserDetails)new User(usuario.getNome(),
                                                    usuario.getPassword(), Arrays.asList(authority));
    return userDetails;
  }
} 