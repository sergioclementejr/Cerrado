package com.cerradoSic.model.valueObjects;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno {

	@Id @GeneratedValue
	@Column(name="idt_aluno")
	private int id;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="nme_aluno")
	private String nome;
	
	@Column(name="ind_genero")
	private int Genero;
	
	@Column(name="observacao")
	private String observacao;
	
	@OneToMany(mappedBy="aluno")
	private List<Matricula> matricula;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public int getGenero() {
		return Genero;
	}

	public void setGenero(int genero) {
		Genero = genero;
	}

	public List<Matricula> getMatricula() {
		return matricula;
	}

	public void setMatricula(List<Matricula> matricula) {
		this.matricula = matricula;
	}
}
