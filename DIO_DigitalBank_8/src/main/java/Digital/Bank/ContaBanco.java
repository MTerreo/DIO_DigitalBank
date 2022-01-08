package Digital.Bank;
import java.math.BigDecimal;

public interface ContaBanco {
    public abstract int getContaNumero();

    public abstract BigDecimal getSaldo();

    public abstract boolean ePessoaFisica();

    public abstract void setPessoa(boolean ePessoaFisica);

    public abstract void deposito(BigDecimal valor);

    public abstract void saque(BigDecimal valor);

    public abstract boolean temFundosSuficiente(BigDecimal valorLimite);

    public abstract String toString();

    public abstract void adicionaJuros();
}


