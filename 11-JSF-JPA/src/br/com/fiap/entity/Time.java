package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seqTime",sequenceName="SEQ_TIME",
allocationSize=1)
public class Time {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="seqTime")
	private int codigo;
	
	private String nome;
	
	private Calendar dataFundacao;
	
	private long qtdSocios;
	
	private double receita;
	
	public Time() {
		// Nada Auto-generated constructor stub
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Calendar dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public long getQtdSocios() {
		return qtdSocios;
	}

	public void setQtdSocios(long qtdSocios) {
		this.qtdSocios = qtdSocios;
	}

	public double getReceita() {
		return receita;
	}

	public void setReceita(double receita) {
		this.receita = receita;
	}
	
}
