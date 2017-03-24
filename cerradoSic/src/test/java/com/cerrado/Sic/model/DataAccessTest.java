package com.cerrado.Sic.model;


import org.junit.Assert;
import org.junit.Test;

import com.cerradoSic.model.facade.ModelFacade;
import com.cerradoSic.model.valueObjects.Aluno;
import com.cerradoSic.model.valueObjects.Especialidade;
import com.cerradoSic.model.valueObjects.Matricula;
import com.cerradoSic.model.valueObjects.Mensalidade;
import com.cerradoSic.model.valueObjects.Modalidade;
import com.cerradoSic.model.valueObjects.Professor;
import com.cerradoSic.test.factory.TestModelFactory;


public class DataAccessTest {
  ModelFacade facade;
  TestModelFactory factory;

  public DataAccessTest() {
    facade = ModelFacade.getInstance();
    factory = TestModelFactory.getInstace();
  }

  @Test
  public void testAluno() {
    Aluno aluno = factory.createAluno();
    facade.insert(aluno);
    Aluno aluno2 = facade.load(Aluno.class, aluno.getId());
    Assert.assertTrue(aluno.equals(aluno2));
    facade.delete(aluno);
  }
  
  @Test
  public void testMensalidade() {
    Mensalidade mensalidade = factory.createMensalidade();
    facade.insert(mensalidade);
    Mensalidade mensalidade2 = facade.load(Mensalidade.class, mensalidade.getId());
    Assert.assertTrue(mensalidade.equals(mensalidade2));
    facade.delete(mensalidade);
  }
  
  @Test
  public void testMatricula(){
   Matricula matricula = factory.createMatriculaComAlunoComMensalidade();
   facade.multiInsert(new Object[]{matricula.getMensalidade(),matricula.getAluno(),matricula});
   Matricula matricula2 = facade.load(Matricula.class, matricula.getId());
   Assert.assertTrue(matricula.equals(matricula2));
   facade.multiDelete(new Object[]{matricula,matricula.getMensalidade(),matricula.getAluno()});
  }
  
  @Test
  public void testEspecialidade(){
    Especialidade especialidade = factory.createEspecialidade();
    facade.insert(especialidade);
    Especialidade especialidade2 = facade.load(Especialidade.class, especialidade.getId());
    Assert.assertTrue(especialidade.equals(especialidade2));
    facade.delete(especialidade);
  }
  
  @Test
  public void testModalidade(){
    Modalidade modalidade = factory.createModalidade();
    facade.insert(modalidade);
    Modalidade modalidade2 = facade.load(Modalidade.class, modalidade.getId());
    Assert.assertTrue(modalidade.equals(modalidade2));
    facade.delete(modalidade);
  }
  
  @Test
  public void testProfessor(){
    Professor professor = factory.createProfessor();
    facade.insert(professor);
    Professor professor2 = facade.load(Professor.class, professor.getId());
    Assert.assertTrue(professor.equals(professor2));
    facade.delete(professor);
  }
  
  @Test
  public void testProfessorComEspecialidade(){
    Especialidade especialidade = factory.createEspecialidade();
    facade.insert(especialidade);
    Professor professor = factory.createProfessorComEspecialidade(especialidade);
    facade.insert(professor);
    Professor professor2 = facade.load(Professor.class, professor.getId());
    Assert.assertTrue(professor.equals(professor2));
    facade.multiDelete(new Object[]{professor,especialidade});
  }
  
  @Test
  public void testProfessorComModalidade(){
    Modalidade modalidade = factory.createModalidade();
    facade.insert(modalidade);
    Professor professor = factory.createProfessorComModalidade(modalidade);
    facade.insert(professor);
    Professor professor2 = facade.load(Professor.class, professor.getId());
    Assert.assertTrue(professor.equals(professor2));
    facade.multiDelete(new Object[]{professor,modalidade});
  }
  
  @Test
  public void testProfessorComEspecialidadeEModalidade(){
    Modalidade modalidade = factory.createModalidade();
    facade.insert(modalidade);
    Especialidade especialidade = factory.createEspecialidade();
    facade.insert(especialidade);
    Professor professor = factory.createProfessorComEspecialidadeComModalidade(especialidade, modalidade);
    facade.insert(professor);
    Professor professor2 = facade.load(Professor.class, professor.getId());
    Assert.assertTrue(professor.equals(professor2));
    facade.multiDelete(new Object[]{professor,modalidade});
  }
  
}
