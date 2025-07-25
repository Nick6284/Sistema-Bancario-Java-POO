public class Forca {
    private PalavraSecreta palavra;
    private char[] progresso;
    private int tentativasRestantes;
    private String letrasUsadas;

    public Forca() {
        palavra = new PalavraSecreta();
        progresso = new char[palavra.getTamanho()];
        for (int i = 0; i < progresso.length; i++) {
            progresso[i] = '_';
        }
        tentativasRestantes = 6;
        letrasUsadas = "";
    }

    public boolean tentarLetra(char letra) {
        boolean acerto = false;
        letra = Character.toLowerCase(letra);

        if (letrasUsadas.contains(String.valueOf(letra))) {
            System.out.println("Letra já utilizada.");
            return false;
        }

        letrasUsadas += letra + " ";

        if (palavra.contemLetra(letra)) {
            for (int i = 0; i < palavra.getPalavraEscolhida().length(); i++) {
                if (palavra.getPalavraEscolhida().charAt(i) == letra) {
                    progresso[i] = letra;
                    acerto = true;
                }
            }
        } else {
            tentativasRestantes--;
        }

        return acerto;
    }

    public boolean venceu() {
        return new String(progresso).equals(palavra.getPalavraEscolhida());
    }

    public boolean perdeu() {
        return tentativasRestantes <= 0;
    }

    public void mostrarEstado() {
        System.out.println("\nPalavra: " + new String(progresso));
        System.out.println("Tentativas restantes: " + tentativasRestantes);
        System.out.println("Letras usadas: " + letrasUsadas);
        desenharForca();
    }

    private void desenharForca() {
        String[] boneco = {
            "  _______     ",
            " |/      |    ",
            " |      " + (tentativasRestantes <= 5 ? "O" : "") + "    ",
            " |     " + (tentativasRestantes <= 3 ? "/" : " ") + 
                        (tentativasRestantes <= 4 ? "|" : " ") + 
                        (tentativasRestantes <= 2 ? "\\" : " "),
            " |      " + (tentativasRestantes <= 1 ? "/" : " ") + 
                        (tentativasRestantes <= 0 ? " \\" : ""),
            " |            ",
            "_|___         "
        };

        for (String linha : boneco) {
            System.out.println(linha);
        }
    }
}