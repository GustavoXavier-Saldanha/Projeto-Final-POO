package pessoas;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class Dependentes extends Pessoas implements Comparable<Dependentes>{
	private String tipoDependente;

	
	
	public Dependentes(String nome, String cpf, LocalDate dataNascimento, String tipoDependente) {
		super(nome, cpf, dataNascimento);
		this.tipoDependente = tipoDependente;
	}



	public String getTipoDependente() {
		return tipoDependente;
	}
	public void setTipoDependente(String tipoDependente) {
		this.tipoDependente = tipoDependente;
	}


	public boolean verificaIdadeDependente(LocalDate dataDependente){

        Period periodo = Period.between(dataDependente, LocalDate.now());

        if(periodo.getYears()>= 18) {

            return true;

        }else {
            return false;}
    }
	
	

	@Override
	public String toString() {    
            return String.format("\n %s || Tipo Dependente: %s", super.toString(), tipoDependente);
	}



	@Override
        public int compareTo(Dependentes ordenarPorNome) {
            return Dependentes.this.getCpf().compareToIgnoreCase(ordenarPorNome.getCpf());
        }


	
}