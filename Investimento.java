public class Investimento {
    public static void simular(double valor, int meses, double taxaJurosAnual) {
        double taxaMensal = taxaJurosAnual / 12 / 100;
        double montante = valor * Math.pow(1 + taxaMensal, meses);
        System.out.printf("\n🔍 Simulação de Investimento:\nValor inicial: R$ %.2f\nPeríodo: %d meses\nMontante final: R$ %.2f\n",
                valor, meses, montante);
    }
}