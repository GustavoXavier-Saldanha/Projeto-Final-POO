package MainPrograma;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pessoas.Dependentes;
import pessoas.Funcionario;

public class Menu {
	
	public void menu() {
	
	List<Funcionario> funcionarios = new ArrayList<>();
	DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	Scanner sc;
	int opcao = 0;
	
	
	do {
		System.out.println("1 - Realizar os c�lculos com o sal�rio de um funcionario.");
		System.out.println("2 - Exibir todos os funcionarios e dependentes.");
		System.out.println("3 - Exibir os dados de salario de todos os funcionarios.");
		System.out.println("4 - Remover um funcionario da lista funcionario.");
		System.out.println("5 - Sair");
		
		try {
			opcao = sc.nextInt();	
		} catch (Exception e) {
			System.out.println("Encerrando, pois n�o digitou valor inteiro");
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
				                    String cpf = dadoDaLinha[1];
				                    double descontoInss = Integer.parseInt(dadoDaLinha[2]);
				                    double descontoIr = Integer.parseInt(dadoDaLinha[3]);
				                    double salarioBruto = Integer.parseInt(dadoDaLinha[4]);
				                    funcionario = new Funcionario(nome, cpf, descontoInss, descontoIr, salarioBruto);
			                	}	              

			                } else {
			                	funcionarios.add(funcionario);
			                	funcionario = null;
			                }
			                
			            }
			            funcionarios.add(funcionario);
			            
			        } catch (FileNotFoundException e) {
			            e.printStackTrace();
			        }
				
				break;
				
			case 3:
				
				System.out.println("Digite o CPF do usuario para a visualiza��o:");
				String cpfVisualiza��o = sc.nextLine();
				
				for (Funcionario funcionario : funcionarios) {

		            if (funcionario.getCpf().equalsIgnoreCase(cpfVisualiza��o)) {
		     
		            	System.out.println(funcionario);
		            }
				}
				break;
				
			case 4:
				System.out.println("Informe o funcionario a remover: ");
				funcionarios.remove(sc.nextLine());
				break;

			case 5:
				System.out.println("A aplica��o foi encerrada");
				break;
				default:
					System.out.println("Op��o invalida");
					break;
			}
			
		}while (opcao != 4);
		
		sc.close();
	}
	
}
	


