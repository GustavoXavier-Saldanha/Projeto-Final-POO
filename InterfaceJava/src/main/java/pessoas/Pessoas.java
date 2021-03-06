package pessoas;

import java.time.LocalDate;

public abstract class Pessoas {

    private String nome;
    protected String cpf;
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
        return String.format("Nome: %s || CPF: %s || Data de nascimento: %s", nome, cpf, dataNascimento);
    }

    public boolean verificaCPF(String cpf) {

        long totalCaracter = cpf.chars().filter(ch -> ch != '.' && ch != '-' && Character.isDigit(ch)).count();
        if (totalCaracter == 11) {
            return true;
        } else {
            return false;
        }
    }

}