package pessoas;

import java.time.LocalDate;

import pacoteEnum.ExpecificaDependentes;
import pacoteInterface.Verificacoes;

public class Dependentes extends Pessoas implements Verificacoes, Comparable<Dependentes>{

	private ExpecificaDependentes tipoDependente;

	
	
	public Dependentes(String nome, String cpf, LocalDate dataNascimento, ExpecificaDependentes tipoDependente) {
		super(nome, cpf, dataNascimento);
		this.tipoDependente = tipoDependente;
	}



	public ExpecificaDependentes getTipoDependente() {
		return tipoDependente;
	}
	public void setTipoDependente(ExpecificaDependentes tipoDependente) {
		this.tipoDependente = tipoDependente;
	}


	@Override
	public void verificaLetrasCpf() {	
	}

	

	@Override
	public String toString() {
		return "Tipo Dependente: " + tipoDependente;
	}



	@Override
	public int compareTo(Dependentes ordenarPorNome) {
		return Pessoas.cpf.compareToIgnoreCase(ordenarPorNome.getCpf());
	}
	
}
