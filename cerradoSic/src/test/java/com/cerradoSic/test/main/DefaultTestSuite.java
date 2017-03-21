package com.cerradoSic.test.main;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.cerrado.Sic.model.DataAccessTest;

import junit.framework.TestResult;
import junit.framework.TestSuite;

public class DefaultTestSuite {
  public static void main(String[] args) {
    TestSuite suite = new TestSuite(DataAccessTest.class);
    TestResult result = new TestResult();
    suite.run(result);
    System.out.println("Number of test cases = " + result.runCount());
    System.out.println(result.wasSuccessful());
  }
  
}
