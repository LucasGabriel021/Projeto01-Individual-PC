package conta;

import loja.Cliente;

public class Conta {
    private double saldo;

    public Conta(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "R$: " + String.valueOf(this.getSaldo());
    }
}
