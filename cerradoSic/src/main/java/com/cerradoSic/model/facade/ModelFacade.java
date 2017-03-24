package com.cerradoSic.model.facade;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.cerradoSic.util.ClassFinder;


public class ModelFacade {

  private static ModelFacade modelFacade;
  private static Configuration con;
  private static StandardServiceRegistryBuilder builder;
  private static SessionFactory sessionFactory;
  private static final String MODEL_CLASS_PATH =
    "com.cerradoSic.model.valueObjects";

  public static ModelFacade getInstance() {
    if (modelFacade == null) {
      modelFacade = new ModelFacade();
    }
    return modelFacade;
  }

  private ModelFacade() {
    con = new Configuration().configure();
    for (Class<?> c : ClassFinder.find(MODEL_CLASS_PATH)) {
      con.addAnnotatedClass(c);
    }
    builder =
      new StandardServiceRegistryBuilder().applySettings(con.getProperties());
    sessionFactory = con.buildSessionFactory(builder.build());
  }
  
  public SessionFactory getSessionFactory(){
    return sessionFactory;
  }

  public void insert(Object obj) {
    Session session = sessionFactory.openSession();
    Transaction t = null;
    try {
      t = session.beginTransaction();
      session.save(obj);
      t.commit();

    }
    catch (HibernateException e) {
      if (t != null) {
        t.rollback();
      }
      e.printStackTrace();
    }
    catch (Exception e) {
      if (t != null) {
        t.rollback();
      }
      e.printStackTrace();
    }
    finally {
      session.close();
    }
  }

  public void update(Object obj) {
    Session session = sessionFactory.openSession();
    Transaction t = null;
    try {
      t = session.beginTransaction();
      session.update(obj);
      t.commit();
    }
    catch (HibernateException e) {
      if (t != null) {
        t.rollback();
      }
      e.printStackTrace();
    }
    catch (Exception e) {
      if (t != null) {
        t.rollback();
      }
      e.printStackTrace();
    }
    finally {
      session.close();
    }
  }

  public void delete(Object obj) {
    Session session = sessionFactory.openSession();
    Transaction t = null;
    try {
      t = session.beginTransaction();
      session.delete(obj);
      t.commit();
    }
    catch (HibernateException e) {
      if (t != null) {
        t.rollback();
      }
      e.printStackTrace();
    }
    catch (Exception e) {
      if (t != null) {
        t.rollback();
      }
      e.printStackTrace();
    }
    finally {
      session.close();
    }
  }

  public <T> T load(Class<T> c, Serializable id) {
    Session session = sessionFactory.openSession();
    Transaction t = null;
    try {
      t = session.beginTransaction();
      T o = (T) session.get(c, id);
      t.commit();
      return o;
    }
    catch (HibernateException e) {
      if (t != null) {
        t.rollback();
      }
      e.printStackTrace();
    }
    catch (Exception e) {
      if (t != null) {
        t.rollback();
      }
      e.printStackTrace();
    }
    finally {
      session.close();
    }
    return null;
  }

  public <T> List<T> loadAll(Class<T> c) {
    Session session = sessionFactory.openSession();
    List<T> list = new ArrayList<T>();
    Transaction t = null;
    try {
      t = session.beginTransaction();
      Criteria criteria = session.createCriteria(c);
      list = criteria.list();
      t.commit();
    }
    catch (HibernateException e) {
      if (t != null)
        t.rollback();
      e.printStackTrace();
    }
    catch (Exception e) {
      if (t != null) {
        t.rollback();
      }
      e.printStackTrace();
    }
    finally {
      session.close();
    }
    return list;
  }

  public void multiUpdate(Object[] obj) {
    Session session = sessionFactory.openSession();
    Transaction t = null;
    try {
      t = session.beginTransaction();
      for (Object object : obj) {
        session.update(object);
      }
      t.commit();
    }
    catch (HibernateException e) {
      if (t != null) {
        t.rollback();
      }
      e.printStackTrace();
    }
    catch (Exception e) {
      if (t != null) {
        t.rollback();
      }
      e.printStackTrace();
    }
    finally {
      session.close();
    }
  }

  public void multiInsert(Object[] obj) {
    Session session = sessionFactory.openSession();
    Transaction t = null;
    try {
      t = session.beginTransaction();
      for (Object object : obj) {
        session.save(object);
      }
      t.commit();

    }
    catch (HibernateException e) {
      if (t != null) {
        t.rollback();
      }
      e.printStackTrace();
    }
    catch (Exception e) {
      if (t != null) {
        t.rollback();
      }
      e.printStackTrace();
    }
    finally {
      session.close();
    }
  }

  public void multiDelete(Object[] obj) {
    Session session = sessionFactory.openSession();
    Transaction t = null;
    try {
      t = session.beginTransaction();
      for (Object object : obj) {
        session.delete(object);
      }
      t.commit();
    }
    catch (HibernateException e) {
      if (t != null) {
        t.rollback();
      }
      e.printStackTrace();
    }
    catch (Exception e) {
      if (t != null) {
        t.rollback();
      }
      e.printStackTrace();
    }
    finally {
      session.close();
    }
  }

}
