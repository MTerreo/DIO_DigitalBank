package Digital.Bank;

import java.math.BigDecimal;
import java.util.HashMap;

public class Bank {
    private HashMap<Integer, ContaBanco> contas;
    private int proximaConta;

    public Bank(HashMap<Integer, ContaBanco> contas, int numeroNovaConta) {
        this.contas = contas;
        proximaConta = numeroNovaConta;
    }

    public int novaConta(int tipo, boolean ePessoaFisica) {
        int contaNumero = proximaConta++;
        ContaBanco contaAtiva;
        if (tipo == 1)
            contaAtiva = new ContaPoupanca(contaNumero);
        else
            contaAtiva = new ContaCorrente(contaNumero);
        contaAtiva.setPessoa(ePessoaFisica);
        contas.put(contaNumero, contaAtiva);
        return contaNumero;
    }

    public BigDecimal getBalance(int contaNumero) {
        ContaBanco contaAtiva = contas.get(contaNumero);
        return contaAtiva.getSaldo();
    }

    public void setPessoa(int contaNumero,
                          boolean ePessoaFisica) {
        ContaBanco contaAtiva = contas.get(contaNumero);
        contaAtiva.setPessoa(ePessoaFisica);
    }

    public void deposito(int contaNumero, BigDecimal valor) {
        ContaBanco contaAtiva = contas.get(contaNumero);
        contaAtiva.deposito(valor);
    }

    public void saque(int contaNumero, BigDecimal valor) {
        ContaBanco contaAtiva = contas.get(contaNumero);
        contaAtiva.saque(valor);
    }

    public boolean autorizaLimite(int contaNumero, BigDecimal valorLimite) {
        ContaBanco contaAtiva = contas.get(contaNumero);
        return contaAtiva.temFundosSuficiente(valorLimite);
    }

    public String toString() {
        String result = "O banco tem " + contas.size()  + " contas.";
        for (ContaBanco contaAtiva : contas.values())
            result += "\n\t" + contaAtiva.toString();
        return result;
    }

    public void adicionaJuros() {
        for (ContaBanco contaAtiva : contas.values()) {
                contaAtiva.adicionaJuros();
            }
    }
}