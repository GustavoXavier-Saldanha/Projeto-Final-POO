package pessoas;

import java.time.LocalDate;

public abstract class Pessoas{
		private String nome;
		private String cpf;
		private LocalDate dataNascimento;
		
		
		public Pessoas(String nome, String cpf, LocalDate dataNascimento) {
			super();
			this.nome = nome;
			this.cpf = cpf;
			this.dataNascimento = dataNascimento;
		}


		
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}


		public String getCpf() {
			return cpf;
		}
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}


		public LocalDate getDataNascimento() {
			return dataNascimento;
		}
		public void setDataNascimento(LocalDate dataNascimento) {
			this.dataNascimento = dataNascimento;
		}



		@Override
		public String toString() {
			return "Nome " + nome + " - CPF: " + cpf + " - Data de nascimento: " + dataNascimento;
		}
		
		

		
}
