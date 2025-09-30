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
        Imigrante imigrante = GeradorDeImigrantes.gerarImigranteAleatorio(LocalDate.now());
        Passaporte passaporte = (Passaporte) imigrante.getDocumentoPorTipo("passaporte");
        Identidade identidade = (Identidade) imigrante.getDocumentoPorTipo("identidade");
        Jogo verificar = new Jogo();
        verificar.verificarLegalidade(imigrante);


        String escolha;
        int pararCodigo = 0;


        do {
            System.out.println("""
                [R] - Regras
                [P] - Passaporte
                [I] - Identidade
                [A] - Aceitar Entrada
                [N] - Negar Entrada de Imigrante
                
                """);
            escolha = scan.nextLine();


            switch (escolha) {
                case "R":
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
                case "P":
                    passaporte.exibirDetalhes();

                    break;
                case "I":
                    identidade.exibirDetalhes();

                    break;
                case "A":
                    System.out.println("A porta ao lado do imigrante se abre. Você permite a entrada dele.");
                    if(verificar.verificarLegalidade(imigrante)){
                        System.out.println("Você Acertou!");
                    } else {
                        System.out.println("Você Errou!");
                    }

                    pararCodigo = 1;
                    break;
                case "N":
                    System.out.println("Você chama os guardas para acompanharem o imigrante à saída.");
                    if(verificar.verificarLegalidade(imigrante)){
                        System.out.println("Você Acertou!");
                    } else {
                        System.out.println("Você Errou!");
                    }

                    pararCodigo = 1;
                    break;
                default:
                    System.out.println("Opção Inválida!");

            }
        } while (pararCodigo == 0);
    }
}
