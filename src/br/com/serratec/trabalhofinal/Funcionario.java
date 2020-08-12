package br.com.serratec.trabalhofinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Pessoa implements CalculadoraIR {
	private double salarioBruto;
	private double salarioLiquido;
	private double descontoInss;
	private double descontoIR;
	private List<Dependente> listaDependentes = new ArrayList<Dependente>();

	public Funcionario(String nome, String cpf, LocalDate dataNascimento, double salarioBruto) {
		super(nome, cpf, dataNascimento);
		this.salarioBruto = salarioBruto;
	}

	public double getSalarioBruto() {
		return salarioBruto;
	}

	public double getSalarioLiquido() {
		return salarioLiquido;
	}

	public double getDescontoInss() {
		return descontoInss;
	}

	public double getDescontoIR() {
		return descontoIR;
	}

	@Override
	public String toString() {
		return "Funcionario [salarioBruto=" + salarioBruto + ", salarioLiquido=" + salarioLiquido + ", descontoInss="
				+ descontoInss + ", descontoIR=" + descontoIR + "Dependente" + listaDependentes + "]";
	}

	//Calcula o INSS do funcionário e retorna o valor do desconto
	@Override
	public double calcularInss() {
		if (salarioBruto <= 1751.81) {
			descontoInss = salarioBruto * 0.08;
		}
		if (salarioBruto >= 1751.82 && salarioBruto <= 2919.72) {
			descontoInss = salarioBruto * 0.09;
		}
		if (salarioBruto >= 2919.73 && salarioBruto <= 5839.45 || salarioBruto >= 5839.46) {
			descontoInss = salarioBruto * 0.11;
		}
		return descontoInss;
	}

	//Verifica se o dependente tem 18 anos ou mais / verifica se o cpf do dependente já existe / adiciona o dependente na lista
	public void adicionarDependente(Dependente d, String cpfDepen, LocalDate data) {

		if (LocalDate.now().getYear() - data.getYear() >= 18) {
			throw new DependenteException("O dependente � maior de idade ");
		} else {
			for (Dependente a : listaDependentes) {
				if (a.getCpf().equals(cpfDepen)) {
					throw new DependenteException("O cpf j� existe");
				}
			}
			listaDependentes.add(d);
		}
	}

	//Realiza o calculo do salário bruto menos os dencontos de INSS e dos dependentes (se houver) / Faz o cálculo do imposto de renda
	@Override
	public double calcularIR() {

		double valorCalculo;

		valorCalculo = salarioBruto - descontoInss - listaDependentes.size() * 189.59;

		if (valorCalculo <= 1903.98) {
			return 0;

		}
		if (valorCalculo > 1903.99 && valorCalculo < 2826.65) {
			descontoIR = valorCalculo * 0.075 - 142.8;

		}
		if (valorCalculo > 2826.66 && valorCalculo < 3751.05) {
			descontoIR = valorCalculo * 0.15 - 354.8;

		}
		if (valorCalculo > 3751.06 && valorCalculo < 4664.68) {
			descontoIR = valorCalculo * 0.225 - 636.13;

		}
		if (valorCalculo >= 4664.69) {
			descontoIR = valorCalculo * 0.275 - 869.36;
		}

		return descontoIR;
	}
	
	//Calcula o sálario bruto menos os descontos (INSS/IR) / retorna o salário líquido
	@Override
	public double calcularSalarioLiquido() {
		return salarioLiquido = salarioBruto - descontoInss - descontoIR;
	}

}
