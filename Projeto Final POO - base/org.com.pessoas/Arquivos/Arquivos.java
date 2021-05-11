package Arquivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

import pessoas.Dependentes;
import pessoas.Funcionario;

public class Arquivos {
	protected String arquivo;
	Scanner sc;

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	public Arquivos(String arquivo) {
		super();
		this.arquivo = arquivo;
	}
	
	public void lerArquivos() {
		try {
			sc = new Scanner(new File(arquivo));
			  Funcionario funcionario = null;
              while(sc.hasNext()) {
                  String linha = sc.nextLine();
                  if(!linha.isEmpty()) {
                      if(funcionario != null) {
                          String[] dadoDependente = linha.split(";");
                          String nomeDependente = dadoDependente[0];
                          //if
                          //verificarIdadeDependente();
                    	  //verificarCPF();
                          //true ->
	                          Dependentes dependentes = new Dependentes(nomeDependente);
	                          funcionario.getDependentes().add(dependentes);
                          //else
	                          //dependente nomeDependente do funcionario.getNome nao esta qualificado
	                      continue;
                      }else {
                          String[] dadoDaLinha = linha.split(";");
                          String nome = dadoDaLinha[0];
                          String cpf = dadoDaLinha[1];
                          LocalDate data = LocalDate.parse(dadoDaLinha[2], df);
                          double descontoInss = Integer.parseInt(dadoDaLinha[3]);
                          double descontoIr = Integer.parseInt(dadoDaLinha[4]);
                          double salarioBruto = Integer.parseInt(dadoDaLinha[5]);
                          funcionario = new Funcionario(nome, cpf, data, descontoInss, descontoIr, salarioBruto);						
                      }
                      } else {
                          funcionarios.add(funcionario);
                          funcionario = null;
                      }
                  }
                  funcionarios.add(funcionario);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

//verificarIdadeDependente();