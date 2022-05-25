package com.edusoft.desafio.models;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.edusoft.desafio.enums.AlunoEnum;

@Entity
@Table(name = "TB_ALUNO")
public class AlunoModel implements Serializable {

	private static final long serialVersilUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	private int codigoAluno;
	@Column(nullable = false, length = 130)
	private String nome;
	private int[] notas = new int[3];
	private int qtdFaltas;
	private int totalAulas;
	private AlunoEnum status;
	private double mediaFinal;

	public int[] getNotas() {
		return notas;
	}

	public void setNotas(int[] notas) {
		this.notas = notas;
	}

	public void setMediaFinal(double mediaFinal) {
		this.mediaFinal = mediaFinal;
	}

	public int getCodigoAluno() {
		return codigoAluno;
	}

	public void setCodigoAluno(int codigoAluno) {
		this.codigoAluno = codigoAluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtdFaltas() {
		return qtdFaltas;
	}

	public void setQtdFaltas(int qtdFaltas) {
		this.qtdFaltas = qtdFaltas;
	}

	public int getTotalAulas() {
		return totalAulas;
	}

	public void setTotalAulas(int totalAulas) {
		this.totalAulas = totalAulas;
	}

	public AlunoEnum getStatus() {
		double frequencia;
		frequencia = 100 - (100 * qtdFaltas) / totalAulas;
		if (frequencia >= 75 && mediaFinal >= 7) {
			return status.AP;
		}

		return status.RF;
	}

	public void setStatus(AlunoEnum status) {
		this.status = status;
	}

	public double getMediaFinal() {

		for (int i = 0; i < notas.length; i++) {
			mediaFinal += notas[i] / 3;
		}

		return mediaFinal;
	}

}
