package com.cerradoSic.test.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.cerradoSic.model.facade.ModelFacade;
import com.cerradoSic.model.valueObjects.Aluno;
import com.cerradoSic.model.valueObjects.Matricula;
import com.cerradoSic.model.valueObjects.Mensalidade;

public class DefaultTest {
	public static void main(String[] args) {
		
		ModelFacade facade = ModelFacade.getInstance();
		Mensalidade mensalidade = facade.load(Mensalidade.class, 6);
		
		
		Aluno aluno = new Aluno();
		aluno.setNome("Pedro Leal Martinez");
		aluno.setGenero(1);
		aluno.setObservacao("Aluno teste");
		aluno.setCpf("1234666115");
		
		Matricula matricula = new Matricula();
		matricula.setDataMatricula(new Date());
		matricula.setPago(false);
		matricula.setValorDesconto(0.00f);
		matricula.setMensalidade(mensalidade);
		matricula.setAluno(aluno);
	    
	    
	    facade.insert(aluno);
	    facade.insert(matricula);
	}
}
