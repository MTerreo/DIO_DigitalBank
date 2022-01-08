package Digital.Bank;
import java.math.RoundingMode;
import java.util.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class BankClient {
    private Scanner scanner;
    private boolean done = false;
    private Bank bank;
    private int contaAtual = 0;
    DecimalFormat df = new DecimalFormat("0000");

    public BankClient(Scanner scanner, Bank bank) {
        this.scanner = scanner;
        this.bank = bank;
    }

    public void run() {
        while (!done) {
            System.out.println("Escolha uma opção: ");
            System.out.println("0 Para sair");
            System.out.println("1 Para criar uma nova conta");
            System.out.println("2 Para selecionar uma conta existente");
            System.out.println("3 Para fazer um deposito");  //dependendo da instalçao do sistema opercional pode ser necessários entrar com ponto ou com virgula para a parte decimal no console
            System.out.println("4 Para fazer um saque");
            System.out.println("5 Para solicitar um limite");
            System.out.println("6 Para listar todas as contas");
            System.out.println("7 Para aplicar o juros ");
            System.out.println("8 Para marcar como pessoa juridica");
            int opcao = scanner.nextInt();
            executaOpcao(opcao);
        }
    }

    private void executaOpcao(int opcao) {
        switch (opcao){
            case 0:
                System.out.println("Entrou na opcao 0");
                sair();
                break;
            case 1:
                System.out.println("Entrou na opcao 1");
                novaConta();
                break;
            case 2:
                System.out.println("Entrou na opcao 2");
                selecionaConta();
                break;
            case 3:
                System.out.println("Entrou na opcao 3");
                deposito();
                break;
            case 4:
                System.out.println("Entrou na opcao 4");
                saque();
                break;
            case 5:
                System.out.println("Entrou na opcao 5");
                autorizaLimite();
                break;
            case 6:
                System.out.println("Entrou na opcao 6");
                listaContas();
                break;
            case 7:
                System.out.println("Entrou na opcao 7");
                adicionaJuros();
                break;
            case 8:
                System.out.println("Entrou na opcao 8");
                setPessoa();
                break;
            default:
                System.out.println("Opção inválida, tente novamente.");
        }
    }

    private void sair() {
        done = true;
        System.out.println("Obrigado por usar o BancoDigital, até logo!");
    }

    private void novaConta() {
        System.out.print("Escolha o tipo de conta: 1 para poupança, 2 para conta corrente: ");
        int tipo = scanner.nextInt();
        boolean ePessoaFisica = solicitaPessoa();
        contaAtual = bank.novaConta(tipo, ePessoaFisica);
        System.out.println("A sua nova conta é " + df.format(contaAtual));
        System.out.println(" ");
    }

    private void selecionaConta() {
        System.out.print("Entre com o número da conta: ");
        contaAtual = scanner.nextInt();
        BigDecimal saldo = bank.getBalance(contaAtual);
        System.out.println("O saldo da conta " + df.format(contaAtual) + " is " + saldo);
    }

    private void deposito() {
        System.out.print("Entre com o valor do deposito: ");
        BigDecimal valor = scanner.nextBigDecimal();
        bank.deposito(contaAtual, valor);
    }

    private void saque() {
        System.out.print("Entre com o valor do saque: ");
        BigDecimal valor = scanner.nextBigDecimal();
        bank.saque(contaAtual, valor);
    }

    private void autorizaLimite() {
        System.out.print("Entre com o valor solicitado para o limite do cheque especial: ");
        BigDecimal valorLimite = scanner.nextBigDecimal();
        if (bank.autorizaLimite(contaAtual, valorLimite))
            System.out.println("O seu limite está aprovado");
        else
            System.out.println("O seu limite não foi aprovado");
    }

    private void listaContas() {
        System.out.println(bank.toString());
    }

    private void adicionaJuros() {
        bank.adicionaJuros();
    }

    private void setPessoa() {
        bank.setPessoa(contaAtual, solicitaPessoa());
    }

    private boolean solicitaPessoa() {
        System.out.print("Entre 1 para pessoa física, 2 para pessoa jurídica: ");
        int val = scanner.nextInt();
        return val == 1;
    }
}