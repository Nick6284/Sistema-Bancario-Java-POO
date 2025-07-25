import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
    protected double saldo;
    protected Cliente cliente;
    protected List<String> historico;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.historico = new ArrayList<>();
    }

    public void depositar(double valor) {
        saldo += valor;
        historico.add("Depósito: R$ " + valor);
    }

    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            historico.add("Saque: R$ " + valor);
            return true;
        } else {
            historico.add("Tentativa de saque falhou: saldo insuficiente.");
            return false;
        }
    }

    public boolean transferir(Conta destino, double valor) {
        if (sacar(valor)) {
            destino.depositar(valor);
            historico.add("Transferência PIX para " + destino.cliente.getNome() + ": R$ " + valor);
            return true;
        } else {
            historico.add("Transferência PIX falhou.");
            return false;
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void imprimirHistorico() {
        System.out.println("=== Histórico da Conta de " + cliente.getNome() + " ===");
        for (String linha : historico) {
            System.out.println(linha);
        }
        System.out.printf("Saldo atual: R$ %.2f\n\n", saldo);
    }
}