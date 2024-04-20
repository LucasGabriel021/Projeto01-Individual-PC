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

    public void addFuncionarios(Funcionario funcionario) {
        funcionariosEmpresa.add(funcionario);
    }

    public Conta getConta() {
        return conta;
    }

    /*
    * O método realizar compra utiliza da palavra-chave "synchronized", ele permite a utilização da Thread
    * sem que haja interfência e erros por memória.
    * */
    public synchronized void realizarCompra(Cliente cliente, double valor) {
        if(cliente.getConta().getSaldo() >= valor) {
            cliente.getConta().debitarSaldo(valor);
            conta.depositarValor(valor);
            System.out.println(String.format("O cliente %s(%d) gastou na loja %s(%d) uma quantia de R$: %.2f. Seu saldo bancário é R$: %.2f.", cliente.getNome(), cliente.getId(), this.getNomeLoja(), this.hashCode(), valor, cliente.getConta().getSaldo()));
            pagarFuncionario();
        }
    }

    public void pagarFuncionario() {
        for (Funcionario item: funcionariosEmpresa) {
            if(conta.getSaldo() >= 1400.0) {
                conta.debitarSaldo(1400.0);
                System.out.println("\nFoi realizado o pagamento para o funcionário " + item.getNome() + " no valor de R$: 1400.00 pela Loja " + this.getNomeLoja() + ".");
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
