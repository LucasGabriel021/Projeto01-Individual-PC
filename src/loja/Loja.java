package loja;

import conta.Conta;

public class Loja {
    private int cnpj;
    private String endereco;
    private String nomeLoja;
    private Conta conta;

    public Loja(int cnpj, String endereco, String nomeLoja, int numConta, double saldo) {
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.nomeLoja = nomeLoja;
        this.conta = new Conta(numConta, saldo);
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

}
