package com.cerradoSic.test.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.cerradoSic.model.valueObjects.Aluno;
import com.cerradoSic.model.valueObjects.Matricula;
import com.cerradoSic.model.valueObjects.Mensalidade;

public class DefaultTest {
	public static void main(String[] args) {
		
		Mensalidade mensalidade = new Mensalidade();
		mensalidade.setNome("Mensalidade Padrão");
		mensalidade.setValor(100.00f);
		
		Aluno aluno = new Aluno();
		aluno.setNome("Sérgio Clemente");
		aluno.setGenero(1);
		aluno.setObservacao("Aluno teste");
		aluno.setCpf("00526661151");
		
		Matricula matricula = new Matricula();
		matricula.setDataMatricula(new Date());
		matricula.setPago(false);
		matricula.setValorDesconto(0);
		matricula.setMensalidade(mensalidade);
		matricula.setAluno(aluno);
	    
	    Configuration con = new Configuration().configure().addAnnotatedClass(Mensalidade.class);
	    con.addAnnotatedClass(Aluno.class);
	    con.addAnnotatedClass(Matricula.class);
	    
	    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(con.getProperties()); 
	    
	    SessionFactory sf = con.buildSessionFactory(builder.build());
	    
	    Session session = sf.openSession();
	    
	    Transaction t = session.beginTransaction();
	    
	    session.save(mensalidade);
	    session.save(aluno);
	    session.save(matricula);
	    
	    t.commit();
	    session.close();
	}
}
