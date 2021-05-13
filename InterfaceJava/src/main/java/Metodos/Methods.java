package Metodos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import pacoteInterface.DependenteExeption;
import pacoteInterface.FuncionarioExeption;
import pessoas.Dependentes;
import pessoas.Funcionario;

public class Methods {

    static DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static List<Funcionario> funcionariosNoArquivo = new ArrayList<>();
    Scanner sc;

    public static void lerArquivos() {
        try {
            Scanner sc = new Scanner(new File("C:\\ArquivosPOO\\entradas.txt"));
            Funcionario funcionario = null;
            while (sc.hasNext()) {
                String linha = sc.nextLine();
                if (!linha.isEmpty()) {
                    if (funcionario != null) {
                        String[] dadoDependente = linha.split(";");
                        String nomeDependente = dadoDependente[0];
                        String cpfDependente = dadoDependente[1];
                        LocalDate dataDependente = LocalDate.parse(dadoDependente[2], df);
                        String tipoDependente = dadoDependente[3];
                        Dependentes dependentes = new Dependentes(nomeDependente, cpfDependente, dataDependente, tipoDependente);
                        try {
                            verificaDependente(dataDependente, dependentes, funcionario);
                            funcionario.getDependentes().add(dependentes);
                        } catch (DependenteExeption e) {
                            JOptionPane.showMessageDialog(null, "Dependente " + dependentes.getNome() + " nao pode ser armazenado");;
                        }
                        continue;
                    } else {
                        String[] dadoDaLinha = linha.split(";");
                        String nome = dadoDaLinha[0];
                        LocalDate data = LocalDate.parse(dadoDaLinha[2], df);
                        double salarioBruto = Integer.parseInt(dadoDaLinha[3]);
                        funcionario = new Funcionario(nome, dadoDaLinha[1], data, salarioBruto);

                    }
                } else {
                     funcionariosNoArquivo.add(funcionario);
                     funcionario = null;


                }

            }
                funcionariosNoArquivo.add(funcionario);
                funcionario = null;


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }

    }

    public static void mostrarFuncionarios() {
        for (Funcionario funcionario : funcionariosNoArquivo) {
            if (funcionario != null) {
                JOptionPane.showMessageDialog(null, funcionario);
            }
        }
    }

    public static void procuraCPF() {
        String cpfVisualização = JOptionPane.showInputDialog("Digite o CPF: ");

        for (Funcionario funcionario : funcionariosNoArquivo) {

            if (funcionario.getCpf().equalsIgnoreCase(cpfVisualização)) {

                JOptionPane.showMessageDialog(null, funcionario);
            }
        }

    }

    public static void Contas() {
        for (Funcionario funcionario : funcionariosNoArquivo) {
            if (funcionario != null) {
                Funcionario.descontoInss(funcionario);

            }
        }
        JOptionPane.showMessageDialog(null, "Salarios ajustados");
    }

    public static void CriarArquivo() {
        try {
            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("C:\\ArquivosPOO\\saidas.txt", true));
            for (Funcionario funcionario : funcionariosNoArquivo) {
                if (funcionario != null) {
                    out.append(funcionario.SaidaFinal() + "\n");
                }
            }
            JOptionPane.showMessageDialog(null, "Arquivo criado com sucesso");
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void verificaDependente(LocalDate data, Dependentes dependente, Funcionario funcionario) throws DependenteExeption {
        Period periodo = Period.between(data, LocalDate.now());
        boolean repetido = false;
        for (Dependentes d : funcionario.getDependentes()) { 
            repetido = d.getCpf().contains(dependente.getCpf());
        }
        if (periodo.getYears() < 18 || repetido == true) {
            throw new DependenteExeption("Dependente " + dependente.getNome() + " nao qualificado");
        }
    }

}
