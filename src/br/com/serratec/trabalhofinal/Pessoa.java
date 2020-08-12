package br.com.serratec.trabalhofinal;


import java.time.LocalDate;

public abstract class Pessoa {
	public String nome;
	public String cpf;
	public LocalDate dataNascimento;
	
	

	public Pessoa(String nome, String cpf, LocalDate dataNascimento) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + "]";
	}
	
	//Verifica se o CPF tem 11 caracteres / verifica se todos os caracteres inseridos são números
	public void verificarCpf(String cpf) {
		if(cpf.length() < 11 || cpf.length() > 11) {
			 throw new CpfException("CPF INVALIDO !!!");
		}else {
			boolean validaNumero=false;

		     for (int i=0;i< cpf.length(); i++){
		         if (Character.isDigit(cpf.charAt(i))){
		             validaNumero=true;

		         }else{
		             validaNumero=false;
		             throw new CpfException("CPF INVALIDO !!!");
		         }
		     }
		}
	}
	
	 
	
}
