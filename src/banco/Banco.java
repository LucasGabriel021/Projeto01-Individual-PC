package banco;

import funcionario.Funcionario;
import loja.Cliente;
import loja.Loja;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Banco {
    public static void main(String[] args) {
        // Criar lojas
        Loja loja01 = new Loja("Botafogo Store", 777, 0);
        Loja loja02 = new Loja("Reebok", 888, 0);

        //Criar funcionários
        Funcionario funcionario01 = new Funcionario("Tiquinho", 333333, 0, 0);
        Funcionario funcionario02 = new Funcionario("Danilo", 121212, 0, 0);
        Funcionario funcionario03 = new Funcionario("Eduardo", 424242, 0, 0);
        Funcionario funcionario04 = new Funcionario("Hugo", 666666, 0, 0);

        // Add funcionários as lojas
        loja01.addFuncionarios(funcionario01);
        loja01.addFuncionarios(funcionario02);
        loja02.addFuncionarios(funcionario03);
        loja02.addFuncionarios(funcionario04);

        List<Loja> lojas = Arrays.asList(loja01, loja02);

        // Criar clientes
        Cliente cliente01 = new Cliente("Evelyn", "1111111111", 111, 1000, lojas);
        Cliente cliente02 = new Cliente("Lucas", "212121212", 212, 1000, lojas);
        Cliente cliente03 = new Cliente("Gilsimar", "999999999", 999, 1000, lojas);
        Cliente cliente04 = new Cliente("Christian", "888888888", 888, 1000, lojas);

        // Dados em arrays
        List<Funcionario> funcionarios = Arrays.asList(funcionario01, funcionario02, funcionario03, funcionario04);
        List<Cliente> clientes = Arrays.asList(cliente01, cliente02, cliente03, cliente04);

        // Incializar Thread
        for(Thread item : funcionarios) {
            item.start();
        }
        for(Thread item : clientes) {
            item.start();
        }

        for(Funcionario item : funcionarios) {
            try {
                item.join();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(Cliente item : clientes) {
            try {
                item.join();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Dados Finais
        System.out.println("\n\nSaldo final das lojas: ");
        for(Loja item : lojas) {
            System.out.println(String.format("A loja %s(%d) possui um saldo de R$: %.2f na conta bancária", item.getNomeLoja(), item.hashCode(), item.getConta().getSaldo()));
        }

        System.out.println("\nSaldo final dos cliente: ");
        for(Cliente item : clientes) {
            System.out.println(String.format("O cliente(a) %s(%d) possui saldo de R$ %.2f em sua conta bancária", item.getNome(), item.getId(), item.getConta().getSaldo()));
        }

    }
}
