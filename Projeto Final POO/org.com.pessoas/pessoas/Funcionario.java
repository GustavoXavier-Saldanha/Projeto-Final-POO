package pessoas;

import java.time.LocalDate;

public class Funcionario extends Pessoas implements Verificacoes{
	private double salarioBruto;
	private double descontoInss;
	private double descontoIr;
	
	
	public Funcionario(String nome, String cpf, LocalDate dataNascimento, double salarioBruto, double descontoInss,
			double descontoIr) {
		super(nome, cpf, dataNascimento);
		this.salarioBruto = salarioBruto;
		this.descontoInss = descontoInss;
		this.descontoIr = descontoIr;
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



	@Override
	public String toString() {
		return "\nSalario bruto" + salarioBruto + " - Desconto Inss:" + descontoInss + " - Desconto Ir: "
				+ descontoIr;
	}



	@Override
	public void verificaCpf() {	
	}

	@Override
	public void verificaLetrasCpf() {
	}
		

}
