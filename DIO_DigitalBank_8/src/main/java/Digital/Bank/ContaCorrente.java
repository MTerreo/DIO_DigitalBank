package Digital.Bank;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class ContaCorrente implements ContaBanco {

    private int contaNumero;
    private BigDecimal saldo = new BigDecimal("0.00");
    private boolean ePessoaJuridica = false;
    DecimalFormat df = new DecimalFormat("0000");


    public ContaCorrente(int contaNumero) {
        this.contaNumero = contaNumero;
    }

    public int getContaNumero() { return contaNumero; }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal amt) {
        saldo = amt;
    }

    public boolean ePessoaFisica() {
        return ePessoaJuridica;
    }

    public void setPessoa(boolean ePessoaFisica) {
        ePessoaJuridica = ePessoaFisica;
    }

    public void deposito(BigDecimal valor){
        saldo =  new BigDecimal(String.valueOf(saldo)).add(valor);
    }

    public void saque(BigDecimal valor){
        if ( valor.compareTo(saldo) == -1 ) {
            saldo =  new BigDecimal(String.valueOf(saldo)).subtract(valor);
        } else {
            System.out.println("Operação negada, saldo insuficiente");
        }
    }

    public boolean temFundosSuficiente(BigDecimal valorLimite){
        return (saldo.compareTo(valorLimite) == 1);
    }

    public String toString() {
        return "Conta Corrente " + df.format(contaNumero) + ": tem saldo = "
                + saldo + ", é "
                + (ePessoaJuridica ? "Pessoa Física" : "Pessoa Jurídica");
    }
    public void adicionaJuros() {
        // do nothing
    }
}
