package MainPrograma;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pessoas.Dependentes;
import pessoas.Funcionario;

public class MainPrograma {
	public static void main(String[] args) {
	
		List<Funcionario> funcionarios = new ArrayList<>();
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner sc;
		int opcao = 0;
		
		
		do {
			System.out.println("1 - Realizar os cálculos com o salário de um funcionario.");
			System.out.println("2 - Exibir todos os funcionarios e dependentes.");
			System.out.println("3 - Exibir os dados de salario de todos os funcionarios.");
			System.out.println("4 - Remover um funcionario da lista funcionario.");
			System.out.println("5 - Sair");
			
			try {
				opcao = sc.nextInt();	
			} catch (Exception e) {
				System.out.println("Encerrando, pois não digitou valor inteiro");
			}
			sc.nextLine();
			switch(opcao) {
			
				case 1:
					
					

					break;
					
				case 2:
					 try {
				            sc = new Scanner(new File("e:\\Serratec-Pastas\\"));
				            Funcionario funcionario = null;
				            while(sc.hasNext()) {	            
				                String linha = sc.nextLine();
				                if(!linha.isEmpty()) {
				                	if(funcionario != null) {
				                		String[] dadoPet = linha.split(";");
					                    String nomePet = dadoPet[0];
					                    Dependentes dependentes = new Dependentes(nome);
					                    funcionario.getDependentes().add(dependentes);
					                    continue;
				                	}else {
				                		String[] dadoDaLinha = linha.split(";");
					                    String nome = dadoDaLinha[0];
					                    int idade = Integer.parseInt(dadoDaLinha[1]);
					                    LocalDate data = LocalDate.parse(dadoDaLinha[2], df);
					                    double salario = Integer.parseDouble(dadoDaLinha[3]);
					                    funcionario = new Funcionario(nome, idade, data, salario);
				                	}	              

				                } else {
				                	funcionarios.add(pessoa);
				                	pessoa = null;
				                }
				                
				            }
				            funcionarios.add(pessoa);
				            
				        } catch (FileNotFoundException e) {
				            e.printStackTrace();
				        }
					
					break;
					
				case 3:
					
					System.out.println("Digite o CPF do usuario para a visualização:");
					String cpfVisualização = sc.nextLine();
					
					for (Funcionario funcionario : funcionarios) {

			            if (funcionario.getCpf().equalsIgnoreCase(cpfVisualização)) {
			     
			            	System.out.println(funcionario);
			            }
					}
					break;
					
				case 4:
					System.out.println("Informe o funcionario a remover: ");
					funcionarios.remove(sc.nextLine());
					break;
	
				case 5:
					System.out.println("A aplicação foi encerrada");
					break;
					default:
						System.out.println("Opção invalida");
						break;
				}
				
			}while (opcao != 4);
			
			sc.close();
		}
			
				
}
