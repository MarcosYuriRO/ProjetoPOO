package ProjectTest;

import ProjectTest.Controle.Jogo;
import ProjectTest.Controle.MenuInicial;

public class MainTest {
    public static void main(String[] args) {

        Jogo jogo = new Jogo();
        MenuInicial menuInicial = new MenuInicial();

        menuInicial.menuInicial();
        jogo.iniciarJogo();


        //System.out.println("Gerando imigrante: " + GeradorDeImigrantes.gerarImigranteAleatorio(LocalDate.of(1982, 11, 23)));

    }
}
