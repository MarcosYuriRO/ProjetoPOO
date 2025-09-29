package ProjectTest.Controle;

import ProjectTest.Documentos.Identidade;
import ProjectTest.Documentos.Passaporte;
import ProjectTest.Imigrantes.GeradorDeImigrantes;
import ProjectTest.Imigrantes.Imigrante;

import java.time.LocalDate;
import java.util.Scanner;

public class MenuInGame {
    public void menu(){
        Scanner scan = new Scanner(System.in);

        int escolha = 0;
        int pararCodigo = 0;

        do {
            System.out.println("""
                1. Checar Manual de Regras
                2. Verificar Passaporte
                3. Verificar Identidade
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
                                  - Nome da Identidade diferente com o nome ditado pelo imigrante;
                            
                                - Passaporte:
                                  - Checar data de validade do documento;
                                  - Nome no Passaporte não coincide com o dito pelo imigrante;
                           
                            """);
                    System.out.println("Data atual: " + LocalDate.now());
                    break;
                case 2:
                    Imigrante imigrante = GeradorDeImigrantes.gerarImigranteAleatorio(LocalDate.now());
                    Passaporte passaporte = (Passaporte) imigrante.getDocumentoPorTipo("passaporte");
                    System.out.println(passaporte.exibirDetalhes());


                    break;
                case 3:

                    break;

                case 4:
                    System.out.println("A porta ao lado do imigrante se abre. Você permite a entrada dele.");
                    pararCodigo = 1;
                    break;

                case 5:
                    System.out.println("Você chama os guardas para acompanharem o imigrante à saída.");
                   pararCodigo = 1;
                    break;

                default:
                    System.out.println("Opção Inválida!");
            }
        } while (pararCodigo == 0);
    }
}
