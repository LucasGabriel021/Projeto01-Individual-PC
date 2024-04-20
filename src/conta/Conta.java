package conta;

import loja.Cliente;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Conta {
    private int numConta;
    private double saldo;
    private Lock lock = new ReentrantLock();

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

    public void debitarSaldo(double valor) {
        lock.lock();
        try {
            this.saldo -= valor;
        } finally {
            lock.unlock();
        }
    }

    public void depositarValor(double valor) {
        lock.lock();
        try {
            this.saldo += valor;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numConta=" + numConta +
                ", saldo=" + saldo +
                '}';
    }
}
