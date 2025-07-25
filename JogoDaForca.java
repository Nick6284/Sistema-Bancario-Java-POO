import java.util.Scanner;

public class JogoDaForca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean jogarNovamente;

        do {
            Forca forca = new Forca();
            System.out.println("=== JOGO DA FORCA ===");

            while (!forca.venceu() && !forca.perdeu()) {
                forca.mostrarEstado();
                System.out.print("Digite uma letra: ");
                char tentativa = scanner.next().toLowerCase().charAt(0);
                forca.tentarLetra(tentativa);
            }

            forca.mostrarEstado();
            if (forca.venceu()) {
                System.out.println("\n🎉 Parabéns! Você venceu!");
            } else {
                System.out.println("\n💀 Você perdeu!");
            }

            System.out.print("\nDeseja jogar novamente? (s/n): ");
            jogarNovamente = scanner.next().toLowerCase().startsWith("s");

        } while (jogarNovamente);

        System.out.println("Obrigado por jogar!");
        scanner.close();
    }
}