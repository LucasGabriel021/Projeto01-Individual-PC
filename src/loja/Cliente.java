package loja;

import conta.Conta;

public class Cliente extends Thread{
    private String nome;
    private int cpf;
    private Conta conta;

    public Cliente(String nome, int cpf, int numConta, double valorInicial) {
        this.nome = nome;
        this.cpf = cpf;
        this.conta = new Conta(numConta, valorInicial);
    }

    public String getNome() {
        return nome;
    }

    public Conta getValorInicial() {
        return conta;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", conta=" + conta +
                '}';
    }
}
