package loja;

import conta.Conta;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cliente extends Thread{
    private String nome;
    private String cpf;
    private Conta conta;
    private List<Loja> lojas;
    private List<Double> valoresGasto = Arrays.asList(100.0, 200.0);
    private int indexCompra = 0;

    public Cliente(String nome, String cpf, int numConta, double valorInicial, List<Loja> lojas) {
        this.nome = nome;
        this.cpf = cpf;
        this.conta = new Conta(numConta, valorInicial);
        this.lojas = lojas;
    }

    public String getNome() {
        return nome;
    }

    public Conta getConta() {
        return conta;
    }

    public List<Loja> getLojas() {
        return lojas;
    }

    @Override
    public void run() {
        // System.out.println(valoresGasto.size());
        // System.out.println(lojas.size());
        while(conta.getSaldo() >= valoresGasto.get(indexCompra % 2)) {
            double valor = valoresGasto.get(indexCompra % 2);
            Loja loja = lojas.get(indexCompra % lojas.size());

            /*
            O uso de this como primeiro argumento na chamada do método processarCompra é para indica
            que o objeto atual (ou seja, a instância da classe Cliente que está executando o método run())
            está sendo passado como parâmetro. Isso permite que a loja (representada pela instância da classe
            Loja) saiba qual cliente está fazendo a compra.
             */
            loja.realizarCompra(this, valor);
            indexCompra++;
        }
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", conta=" + conta +
                ", lojas=" + lojas +
                ", valoresGasto=" + valoresGasto +
                ", indexCompra=" + indexCompra +
                '}';
    }
}
