package Digital.Bank;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class ContaPoupanca implements ContaBanco {
    private BigDecimal jurosPeriodo = new BigDecimal("1.01");
    private int contaNumero;
    private BigDecimal saldo = new BigDecimal("0.00");
    private boolean ePessoaJuridica = false;
    DecimalFormat df = new DecimalFormat("0000");


    public ContaPoupanca(int contaNumero) { this.contaNumero = contaNumero;}

    public int getContaNumero() { return contaNumero; }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal valor) { saldo = valor; }

    public boolean ePessoaFisica() {
        return ePessoaJuridica;
    }

    public void setPessoa(boolean ePessoaFisica) {ePessoaJuridica = ePessoaFisica;}

    public void deposito(BigDecimal valor){
        saldo =  new BigDecimal(String.valueOf(saldo)).add(valor);
    }  //saldo += valor

    public void saque(BigDecimal valor){
        if ( valor.compareTo(saldo) == -1 ) {
            saldo = new BigDecimal(String.valueOf(saldo)).subtract(valor);
        } else {System.out.println("Operação negada, saldo insuficiente");}
    }

    public boolean temFundosSuficiente(BigDecimal valorLimite){
        return (saldo.compareTo(valorLimite) == 1);
    }

    public String toString() {
        return "Conta Poupança " + df.format(contaNumero) + ": tem saldo = "
                + saldo + ", é "
                + (ePessoaJuridica ? "Pessoa Física" : "Pessoa Jurídica");
    }
    public void adicionaJuros() {
        saldo = saldo.multiply(jurosPeriodo);
    }
}
