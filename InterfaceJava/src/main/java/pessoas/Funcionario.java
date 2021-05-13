package pessoas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Pessoas implements Comparable<Funcionario> {
    static double salario1 = 1903.98;
    static double salario2 = 2826.65;
    static double salario3 = 3751.05;
    static double salario4 = 4664.68;
    static double aliquota1 = 7.5;
    static double aliquota2 = 15;
    static double aliquota3 = 22.5;
    static double aliquota4 = 27.5;
    private double salarioBruto;
    private double salarioLiquido;
    private double descontoInss;
    private double descontoIr;
    private List<Dependentes> dependentes;

    public Funcionario(String nome, String cpf, LocalDate dataNascimento, double salarioBruto) {
        super(nome, cpf, dataNascimento);
        this.salarioBruto = salarioBruto;
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

    public double getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(double salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    @Override
    public String toString() {
        if(dependentes.isEmpty()){
        return String.format("Funcionario: %s\nSalario Bruto: R$%.2f\nSalario Liquido: R$%.2f\nDependentes %d\nDescontoInss R$%.2f\nDescontoIr R$%.2f\nSem dependentes ", super.toString(), salarioBruto, salarioLiquido, this.dependentes.size(), descontoInss, descontoIr);
        }else {
        return String.format("Funcionario: %s\nSalario Bruto: R$%.2f\nSalario Liquido: R$%.2f\nDependentes %d\nDescontoInss R$%.2f\nDescontoIr R$%.2f\nDependentes %s", super.toString(), salarioBruto, salarioLiquido, this.dependentes.size(), descontoInss, descontoIr, dependentes);
        }
    }
    
    public String SaidaFinal(){
        return String.format("Funcionario: %s;CPF: %s;Desconto_INSS: %.2f;Desconto_IR: R$%.2f;Salario_Liquido: %.2f", super.getNome(), super.getCpf(),descontoInss, descontoIr, salarioLiquido);
    }
    
    @Override
    public int compareTo(Funcionario ordenarPorNome) {
        return Funcionario.this.getCpf().compareToIgnoreCase(ordenarPorNome.getCpf());
    }

    public static void descontoInss(Funcionario funcionario) {
        System.out.println(funcionario.salarioBruto);
        if (funcionario != null) {
            if (funcionario.salarioBruto <= 1100) {
                funcionario.descontoInss = (funcionario.salarioBruto * 7.5 / 100) - 0;
            } else if (funcionario.salarioBruto <= 2203.48 && funcionario.salarioBruto >= 1100.01) {

                funcionario.descontoInss = (funcionario.salarioBruto * 9 / 100) - 16.5;
            } else if (funcionario.salarioBruto <= 3305.22 && funcionario.salarioBruto >= 2203.49) {

                funcionario.descontoInss = (funcionario.salarioBruto * 12 / 100) - 82.61;
            } else if (funcionario.salarioBruto >= 3305.23) {

                funcionario.descontoInss = (funcionario.salarioBruto * 14 / 100) - 148.72;
            }
            calculoIr(funcionario, funcionario.dependentes.size(), funcionario.descontoInss);
        }
    }

    public static void calculoIr(Funcionario funcionario, int dependentes, double descontoInss) {
        double abatimentoDependente = dependentes * 189.59;
         double salarioCalculaIr = funcionario.salarioBruto - abatimentoDependente - descontoInss;
        if (funcionario.salarioBruto < salario1) {
            funcionario.descontoIr = 0;
        } else if (funcionario.salarioBruto < salario2 ) {
            funcionario.descontoIr = (salarioCalculaIr * aliquota1 / 100) - 142.8;
        } else if (funcionario.salarioBruto < salario3 ) {
            funcionario.descontoIr = (salarioCalculaIr * aliquota2 / 100) - 354.8;
        } else if (funcionario.salarioBruto < salario4 ) {
            funcionario.descontoIr = (salarioCalculaIr * aliquota3 / 100) - 636.13;
        } else if (funcionario.salarioBruto >= salario4) {
            funcionario.descontoIr = (salarioCalculaIr * aliquota4 / 100) - 869.36;
        }
        salarioLiquido(funcionario);

    }

    public static double salarioLiquido(Funcionario funcionario) {
        return funcionario.salarioLiquido = funcionario.salarioBruto - funcionario.descontoInss - funcionario.descontoIr;
    }

}
