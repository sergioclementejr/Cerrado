package com.cerradoSecurityService.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cerradoSecurityService.model.valueObjects.UserVO;
@Repository
@Transactional
public class UserDAO implements IUserDAO {
  @PersistenceContext 
  private EntityManager entityManager;
  public UserVO getActiveUser(String userName) {
    UserVO activeUser = new UserVO();
    short enabled = 1;
    List<?> list = entityManager.createQuery("SELECT u FROM UserVO u WHERE username=? and enabled=?")
        .setParameter(1, userName).setParameter(2, enabled).getResultList();
    if(!list.isEmpty()) {
      activeUser = (UserVO)list.get(0);
    }
    return activeUser;
  }
} 