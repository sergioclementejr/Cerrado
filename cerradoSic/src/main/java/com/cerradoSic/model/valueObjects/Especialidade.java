package com.cerradoSic.model.valueObjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="especialidade")
public class Especialidade {
	@Id @GeneratedValue
	@Column(name="idt_especialidade")
	private int id;
	@Column(name="nme_especialidade")
	private String nome;
	@Column(name="dsc_especialidade")
	private String descricao;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
