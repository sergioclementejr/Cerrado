package com.cerradoSic.model.valueObjects;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="mes_matricula")
public class Matricula {

	@Id @GeneratedValue
	@Column(name="idt_mes_matricula")
	private int id;
	
	@Column(name="dta_mes_matricula")
	@Type(type="date")
	private Date dataMatricula;
	
	@Column(name="flg_pago")
	private boolean pago;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idt_aluno")
	private Aluno aluno;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idt_mensalidade")
	private Mensalidade mensalidade;
	
	@Column(name="vlr_desconto")
	private float valorDesconto = 0f;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Mensalidade getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(Mensalidade mensalidade) {
		this.mensalidade = mensalidade;
	}

	public float getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(float valorDesconto) {
		this.valorDesconto = valorDesconto;
	}
}
