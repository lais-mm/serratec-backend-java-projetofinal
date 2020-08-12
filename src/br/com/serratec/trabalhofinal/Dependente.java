package br.com.serratec.trabalhofinal;

import java.time.LocalDate;

public class Dependente extends Pessoa {
	private GrauParentesco grauParentesco;
	
	public Dependente(String nome, String cpf, LocalDate dataNascimento, GrauParentesco grauParentesco) {
		super(nome, cpf, dataNascimento);
		this.grauParentesco = grauParentesco;
	}

	@Override
	public String toString() {
		return "Dependente" + " nome: " + nome + " grauParentesco= " + grauParentesco;
	}

}
