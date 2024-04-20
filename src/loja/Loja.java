package loja;

import conta.Conta;
import funcionario.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    private int cnpj;
    private String endereco;
    private String nomeLoja;
    private Conta conta;
    private List<Funcionario> funcionariosEmpresa;

    public Loja(int cnpj, String endereco, String nomeLoja, int numConta, double saldo) {
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.nomeLoja = nomeLoja;
        this.conta = new Conta(numConta, saldo);
        this.funcionariosEmpresa = new ArrayList<>();
    }

    public void addFuncionarios(Funcionario funcrionario) {
        funcionariosEmpresa.add(funcrionario);
    }

    public Conta getConta() {
        return conta;
    }

    public synchronized void realizarCompra(Cliente cliente, double valor) {
        if(cliente.getConta().getSaldo() >= valor) {
            cliente.getConta().debitarSaldo(valor);
            conta.depositarValor(valor);
            System.out.println(String.format("O cliente %d gastou na loja %2.f uma quantia de %.2f", cliente.getId(), valor, this.hashCode()));
            pagarFuncionario();
        }
    }

    public void pagarFuncionario() {
        for (Funcionario item: funcionariosEmpresa) {
            if(conta.getSaldo() >= 1400.0) {
                conta.debitarSaldo(1400.0);
                item.receberPagamento(1400.0);
            }
        }
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

}
