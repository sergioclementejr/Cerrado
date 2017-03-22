package com.cerradoSic.test.main;

import com.cerradoSic.model.facade.ModelFacade;
import com.cerradoSic.model.valueObjects.Aluno;
import org.hibernate.Session;

public class DefaultTestSuite {
  public static void main(String[] args) {
//    TestSuite suite = new TestSuite(DataAccessTest.class);
//    TestResult result = new TestResult();
//    suite.run(result);
//    System.out.println("Number of test cases = " + result.runCount());
//    System.out.println(result.wasSuccessful());
    
    ModelFacade facade = ModelFacade.getInstance();
//    Aluno aluno = facade.load(Aluno.class, 21);
//    System.out.println(aluno);
//    aluno = facade.load(Aluno.class, 21);
//    System.out.println(aluno);
    
    Aluno a = null;
    Session session1 = facade.getSessionFactory().openSession();
    session1.beginTransaction();
    
    a = (Aluno) session1.get(Aluno.class, 21);
    System.out.println(a);
    
    session1.getTransaction().commit();
    session1.close();
    
    Session session2 = facade.getSessionFactory().openSession();
    session2.beginTransaction();

    a = (Aluno) session2.get(Aluno.class, 21);
    System.out.println(a);
    
    session2.getTransaction().commit();
    session2.close();
    
    
  }
  
  
}
