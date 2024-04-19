package funcionario;

import conta.Conta;

public class Funcionario extends Thread {
    private String nome;
    private Conta contaSalario;
    private Conta contaInvestimentos;

    public Funcionario(String nome, int numConta, double salario, double investimento) {
        this.nome = nome;
        this.contaSalario = new Conta(numConta, salario);
        this.contaInvestimentos = new Conta(numConta, investimento);
    }

    public String getNome() {
        return nome;
    }

    public Conta getContaSalario() {
        return contaSalario;
    }

    public Conta getContaInvestimentos() {
        return contaInvestimentos;
    }
}
