package com.cerradoSic.test.main;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cerradoSic.model.facade.ModelFacade;
import com.cerradoSic.model.valueObjects.Usuario;

public class DefaultTestSuite {
  public static void main(String[] args) {
    
      ModelFacade facade = ModelFacade.getInstance();
      Usuario user = facade.load(Usuario.class, "sergio");
      System.out.println(user);
  }
}
