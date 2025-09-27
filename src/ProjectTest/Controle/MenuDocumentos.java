package ProjectTest.Controle;

import java.util.Scanner;

public class MenuDocumentos {
    public void checarDocumentos() {
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;

        do {
            System.out.println("""
                    1. Exibir Identidade
                    2. Exibir Passaporte
                    3. Exibir Residência Temporária
                    4. Exibit Visto de Trabalho
                    0. Voltar para menu inicial de escolhas
                    
                    """);
            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    //Exibir Identidade
                    break;

                case 2:
                    //Exibir Passaporte
                    break;

                case 3:
                    //Exibir Residência Temporária
                    break;

                case 4:
                    //Exibir Visto de Trabalho
                    break;

                case 0:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opção Inválida!");
            }
        } while(opcao != 0);
    }
}