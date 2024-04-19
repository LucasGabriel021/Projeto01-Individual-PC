package loja;

import conta.Conta;

public class Cliente extends Thread{
    private String nome;
    private int cpf;
    private Conta valorInicial;

    public Cliente(String nome, int cpf, double valorInicial) {
        this.nome = nome;
        this.cpf = cpf;
        this.valorInicial = new Conta(valorInicial);
    }

    public String getNome() {
        return nome;
    }

    public Conta getValorInicial() {
        return valorInicial;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", valorInicial=" + valorInicial +
                '}';
    }
}
