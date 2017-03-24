package com.cerradoSecurityService.dao;

import com.cerradoSecurityService.model.valueObjects.UserVO;

public interface IUserDAO {
  UserVO getActiveUser(String username);
} 