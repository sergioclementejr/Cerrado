package com.cerradoSic.model.valueObjects;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

@Entity
@Table(name="mes_matricula")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((aluno == null)? 0: aluno.hashCode());
    result = prime * result +
      ((dataMatricula == null)? 0: dataMatricula.hashCode());
    result = prime * result + id;
    result =
      prime * result + ((mensalidade == null)? 0: mensalidade.hashCode());
    result = prime * result + (pago? 1231: 1237);
    result = prime * result + Float.floatToIntBits(valorDesconto);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Matricula other = (Matricula) obj;
    if (aluno == null) {
      if (other.aluno != null)
        return false;
    }
    else if (!(aluno.getId()==other.aluno.getId()))
      return false;
    if (dataMatricula == null) {
      if (other.dataMatricula != null)
        return false;
    }
    else if (!(dataMatricula.getTime()==other.dataMatricula.getTime()))
      return false;
    if (id != other.id)
      return false;
    if (mensalidade == null) {
      if (other.mensalidade != null)
        return false;
    }
    else if (!mensalidade.equals(other.mensalidade))
      return false;
    if (pago != other.pago)
      return false;
    if (Float.floatToIntBits(valorDesconto) != Float.floatToIntBits(other.valorDesconto))
      return false;
    return true;
  }
}
