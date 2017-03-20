package com.cerradoSic.test.main;

import java.util.List;

import com.cerradoSic.model.facade.ModelFacade;
import com.cerradoSic.model.valueObjects.Aluno;

public class LoadTest {
	public static void main(String[] args) {
		ModelFacade facade = ModelFacade.getInstance();
		List<Aluno> alunos = facade.loadAll(Aluno.class);
		
		for (Aluno aluno : alunos) {
			System.out.println("------");
			System.out.println(aluno.getNome());
			System.out.println(aluno.getCpf());
			System.out.println(aluno.getGenero().getDescricao());
			System.out.println(aluno.getMatricula().get(0).getDataMatricula());
		}
	}
}
