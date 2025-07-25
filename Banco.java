public class Banco {
    public static void main(String[] args) {
        Cliente maria = new Cliente("Maria Silva", "12345678900");
        Cliente joao = new Cliente("João Souza", "98765432100");

        Conta contaMaria = new ContaCorrente(maria);
        Conta contaJoao = new ContaPoupanca(joao);

        contaMaria.depositar(1000);
        contaMaria.sacar(200);
        contaMaria.transferir(contaJoao, 300);

        contaJoao.sacar(100);
        contaJoao.depositar(50);

        contaMaria.imprimirHistorico();
        contaJoao.imprimirHistorico();

        Investimento.simular(500, 12, 10);
    }
}