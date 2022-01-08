package Digital.Bank;

import java.util.HashMap;
import java.util.Scanner;

public class BankProgram {

    public static void main(String[] args) {
        HashMap<Integer, ContaBanco> contas = new HashMap<>();
        Bank bank = new Bank(contas, 0);
        Scanner scanner = new Scanner(System.in);
        BankClient cliente = new BankClient(scanner, bank);
        cliente.run();
    }
}

