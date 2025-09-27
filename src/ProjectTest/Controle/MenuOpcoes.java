package ProjectTest.Controle;

import java.time.LocalDate;
import java.util.Scanner;

public class MenuOpcoes {
    public void opcoes(){
        Scanner scan = new Scanner(System.in);
        MenuDocumentos docs = new MenuDocumentos();

        int escolha = 0;

        while (escolha != 4 || escolha != 5) {
            System.out.println("""
                1. Checar Manual de Regras
                2. Checar Documentos
                3. Perguntar Dados Básicos
                4. Permitir Entrada de Imigrante
                5. Negar Entrada de Imigrante
                
                """);
            escolha = scan.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("""
                            O que avaliar em cada documento?
                                Documentos Obrigatórios para todas Nacionalidades:
                                - Identidade:
                                  - Checar validade;
                                  - Checar o nome do passaporte com o nome da identidade;
                                  - Verificar se a data de nascimento condiz com a idade dita.
                            
                                - Passaporte:
                                  - O país dito pelo imigrante deve estar de acordo com o redigido em seu passaporte;
                                  - O nome do imigrante deve coincidir com o nome dito;
                                  - No final de todo código de número do passaporte, deve conter o ano atual.
                            
                                - Residência Temporária:
                                  - O Tempo de Residência deve ser igual ou menor a 3 meses.
                            
                                - Visto de Trabalho:
                                  - A estadia máxima a um trabalhador estrangeiro, é de meio ano.                                     
                            
                            """);
                    System.out.println("Data atual: " + LocalDate.now());
                    break;
                case 2:
                    docs.checarDocumentos();
                    break;
                case 3:

                    break;

                case 4:

                    break;

                case 5:

                    break;

                default:
                    System.out.println("Opção Inválida!");
            }
        }
    }
}