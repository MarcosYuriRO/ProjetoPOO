package ProjectTest;

import ProjectTest.Controle.Jogo;

public class MainTest {
    public static void main(String[] args) {
        Jogo menu = new Jogo();
        System.out.println("""
                Você inicia mais uma rotina de trabalho. Ao entrar em sua cabine
                e organizar sua mesa, você clica o alarme para a análise do primeiro imigrante
                que possivelmente poderá adentrar em seu país.""");

        //Após isso, já pode haver um metodo de exibição/introdução do imigrante junto de uma lista de ações


        //TESTE:
        menu.menu();


    }
}
