package ProjectTest.Menu;

import java.util.Scanner;

public class MenuOpcoes {
    public void opcoes(){
        Scanner scan = new Scanner(System.in);

        System.out.println("""
                1. Checar Manual de Regras
                2.
                3.
                4.
                5.
                
                """);
        int escolha = scan.nextInt();

        switch (escolha) {
            case 1:
                System.out.println("""
                        O que avaliar em cada documento?
                            Documentos Obrigatórios para todas Nacionalidades:
                            - Identidade:
                              - Checar validade;
                              - Checar o nome dito com o nome documentado;
                              -
                        
                        
                        """);
        }
    }
}
