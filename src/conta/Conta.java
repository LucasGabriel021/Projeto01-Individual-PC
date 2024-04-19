package conta;

import loja.Cliente;

public class Conta {
    private int numConta;
    private double saldo;

    public Conta(int numConta, double saldo) {
        this.saldo = saldo;
        this.numConta = numConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getNumConta() {
        return numConta;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numConta=" + numConta +
                ", saldo=" + saldo +
                '}';
    }
}
