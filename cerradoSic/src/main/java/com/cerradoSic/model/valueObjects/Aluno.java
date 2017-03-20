package com.cerradoSic.model.valueObjects;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cerradoSic.model.enumerators.Genero;
import com.cerradoSic.model.enumerators.GeneroConverter;

@Entity
@Table(name = "aluno")
public class Aluno {

	@Id @GeneratedValue
	@Column(name="idt_aluno")
	private int id;
	
	@Column(name="cod_cpf")
	private String cpf;
	
	@Column(name="nme_aluno")
	private String nome;
	
	@Column(name="ind_genero")
	@Convert(converter=GeneroConverter.class)
	private Genero genero;
	
	@Column(name="dsc_aluno")
	private String observacao;
	
	@OneToMany(mappedBy="aluno", fetch=FetchType.EAGER)
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

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public List<Matricula> getMatricula() {
		return matricula;
	}

	public void setMatricula(List<Matricula> matricula) {
		this.matricula = matricula;
	}
}
