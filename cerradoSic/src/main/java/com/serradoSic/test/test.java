package com.serradoSic.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.cerradoSic.model.valueObjects.Mensalidade;

public class test {
  public static void main(String[] args) {
    Mensalidade m = new Mensalidade(new Date(), 102.00f);
    
    
    Configuration con = new Configuration().configure().addAnnotatedClass(Mensalidade.class);
    
//    ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(con.getProperties()); 
    
    SessionFactory sf = con.buildSessionFactory(builder.build());
    
    Session session = sf.openSession();
    
    Transaction t = session.beginTransaction();
    
    session.save(m);
    
    t.commit();
    session.close();
  }
}
