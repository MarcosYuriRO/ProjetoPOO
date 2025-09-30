package ProjectTest.Controle;

import java.util.Scanner;

public class MenuInicial {
    public void menuInicial() {
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;

        while (opcao != 4) {
            System.out.println("""
                    Bem vindo(a) a PAPÉIS, POR FAVOR!!!
                    
                    1. Iniciar novo Jogo
                    2. Resumo da Jogabilidade
                    3. Créditos
                    4. Sair do Jogo
                    """);
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("""
                            Cá está você em mais uma fria manhã de trabalho em 198
                            Você adentra à fronteira pelo lado de dentro, mas já vendo 
                            uma enorme fila de imigrantes que buscam adentrar ao seu país.
                            Sabendo disso, está na hora de você checar seus documentos
                            e saber quem de fato merece adentrar a Arstotzka!
                           
                            Assim que adentra em sua cabine, já começam os trabalhos, com o primeiro imigrante 
                            aparecendo na frente da janela escura que o protegia daqueles de fora.
                            
                            """);
                    Jogo opcoes = new Jogo();
                    opcoes.iniciarJogo();

                    break;
                case 2:
                    System.out.println("""
                            PAPÉIS, POR FAVOR é um jogo que conta a história de um vigilante de uma fronteira
                            de um país chamdo Arstotzka; ele ganha seu salário a partir de descobrir os
                            imigrantes legais e ilegais que tentam entrar em seu país, através de análises
                            em busca de irregularidades nos documentos apresentados de cada imigrante.
                            
                            """);
                    break;
                case 3:
                    System.out.println("""
                            Criadores deste Código:
                            André Arthur 🐻
                            Gabriel Tavares 🦃
                            Kaillanny Fontana 🦕
                            Marcos Yuri 🐨
                            Moisés Dutra 🐙
                            
                            """);
                    break;
                case 4:
                    System.out.println("Adeus!!! 👋👋");
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        }
    }
}
