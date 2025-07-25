import java.util.Random;

public class PalavraSecreta {
    private String[] palavras = {"java", "orientacao", "objeto", "console", "programacao"};
    private String palavraEscolhida;

    public PalavraSecreta() {
        escolherPalavra();
    }

    private void escolherPalavra() {
        Random random = new Random();
        palavraEscolhida = palavras[random.nextInt(palavras.length)];
    }

    public String getPalavraEscolhida() {
        return palavraEscolhida;
    }

    public int getTamanho() {
        return palavraEscolhida.length();
    }

    public boolean contemLetra(char letra) {
        return palavraEscolhida.indexOf(letra) >= 0;
    }
}