package com.cerradoSic.test.main;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.cerradoSic.model.enumerators.Genero;
import com.cerradoSic.model.facade.ModelFacade;
import com.cerradoSic.model.valueObjects.Aluno;
import com.cerradoSic.model.valueObjects.Matricula;
import com.cerradoSic.model.valueObjects.Mensalidade;


public class DefaultTest {
  public static void main(String[] args) {

    ModelFacade facade = ModelFacade.getInstance();
    
    Mensalidade mensalidade = facade.load(Mensalidade.class, 2);
    
//    Mensalidade mensalidade = new Mensalidade();
//    mensalidade.setNome("Mensalidade Comum");
//    mensalidade.setValor(100f);
    
//    Mensalidade mensalidade = new Mensalidade();
//    mensalidade.setNome("Mensalidade Especial");
//    mensalidade.setValor(50f);

//    Aluno aluno = new Aluno();
//    aluno.setNome("Pedro Leal Martinez");
//    aluno.setGenero(Genero.MASCULINO);
//    aluno.setObservacao("Aluno teste");
//    aluno.setCpf("87958456852");
    
//    Aluno aluno = new Aluno();
//    aluno.setNome("Luiza Leal Martinez");
//    aluno.setGenero(Genero.FEMININO);
//    aluno.setObservacao("Aluno teste");
//    aluno.setCpf("68579855412");
    
    Aluno aluno = new Aluno();
    aluno.setNome("Sérgio Clemente");
    aluno.setGenero(Genero.MASCULINO);
    aluno.setObservacao("Aluno teste");
    aluno.setCpf("00526661151");

    Matricula matricula = new Matricula();
    matricula.setDataMatricula(new Date());
    matricula.setPago(false);
    matricula.setValorDesconto(0.00f);
    matricula.setMensalidade(mensalidade);
    matricula.setAluno(aluno);

//    Object[] obj = {aluno, matricula};
    Object[] obj = {mensalidade, aluno, matricula};

    facade.multiInsert(obj);
  }
}
