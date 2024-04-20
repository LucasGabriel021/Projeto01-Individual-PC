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

    public synchronized void realizarCompra(Cliente cliente, double valor) {
        if(cliente.getConta().getSaldo() >= valor) {
            cliente.getConta().debitarSaldo(valor);
            conta.depositarValor(valor);
            System.out.println(String.format("O cliente %d gastou na loja %d uma quantia de %.2f", cliente.getId(), this.hashCode(), valor));
            pagarFuncionario();
        }
    }

    public void pagarFuncionario() {
        for (Funcionario item: funcionariosEmpresa) {
            if(conta.getSaldo() >= 1400.0) {
                conta.debitarSaldo(1400.0);
                item.receberPagamento(1400.0);
                System.out.println("Foi realizado o pagamento para o funcionário " + item.getNome() + " no valor de R$: 1400.00");
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
