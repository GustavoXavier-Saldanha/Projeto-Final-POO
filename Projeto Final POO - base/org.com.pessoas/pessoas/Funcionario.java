package pessoas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import pacoteInterface.Verificacoes;

public class Funcionario extends Pessoas implements Verificacoes, Comparable<Funcionario>{
	private double salarioBruto;
	private double descontoInss;
	private double descontoIr;
	private List<Dependentes> dependentes;
	
	
	public Funcionario(String nome, String cpf, LocalDate dataNascimento, double salarioBruto, double descontoInss,
			double descontoIr) {
		super(nome, cpf, dataNascimento);
		this.salarioBruto = salarioBruto;
		this.descontoInss = descontoInss;
		this.descontoIr = descontoIr;
		this.dependentes = new ArrayList<>();
	}


	
	public double getSalarioBruto() {
		return salarioBruto;
	}
	public void setSalarioBruto(double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}


	public double getDescontoInss() {
		return descontoInss;
	}
	public void setDescontoInss(double descontoInss) {
		this.descontoInss = descontoInss;
	}


	public double getDescontoIr() {
		return descontoIr;
	}
	public void setDescontoIr(double descontoIr) {
		this.descontoIr = descontoIr;
	}

	
	public List<Dependentes> getDependentes() {
		return dependentes;
	}
	public void setDependentes(List<Dependentes> dependentes) {
		this.dependentes = dependentes;
	}



	@Override
	public String toString() {
		return "\nSalario bruto" + salarioBruto + " - Desconto Inss:" + descontoInss + " - Desconto Ir: "
				+ descontoIr;
	}

	@Override
	public void verificaLetrasCpf() {
	}



	@Override
	public int compareTo(Funcionario ordenarPorNome) {
		return Pessoas.cpf.compareToIgnoreCase(ordenarPorNome.getCpf());
		
	}
		

}
