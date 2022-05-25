package com.edusoft.desafio.dtos;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import com.edusoft.desafio.enums.AlunoEnum;
import com.edusoft.desafio.models.AlunoModel;

public class AlunoDto {

	@NotBlank
	private int codigoAluno;
	@NotBlank
	private String nome;
	@NotBlank
	private int[] notas = new int[3];
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
	public int[] getNotas() {
		return notas;
	}
	public void setNotas(int[] notas) {
		this.notas = notas;
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
		return status;
	}
	public void setStatus(AlunoEnum status) {
		this.status = status;
	}
	public double getMediaFinal() {
		return mediaFinal;
	}
	public void setMediaFinal(double mediaFinal) {
		this.mediaFinal = mediaFinal;
	}
	private int qtdFaltas;
	@NotBlank
	private int totalAulas;
	@NotBlank
	private AlunoEnum status;
	@NotBlank
	private double mediaFinal;

}
