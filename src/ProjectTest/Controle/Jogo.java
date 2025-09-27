package ProjectTest.Controle;

import java.time.LocalDate;
import java.util.Scanner;

public class Jogo {

    //Insere o imigrante instanciado. caso a validade não esteja vencida e o nome e a idade coincidam com os ditos, retorna true. Se não, false
    /*  public boolean verificarLegalidade(Imigrante dadosImigrante) {
            if(estaValido() && dadosImigrante.getNome().equals(getNomeCompleto()) && dadosImigrante.getIdade() == calcularIdade()){
                return true;
            } else {
                return false;
            }
        }
    //Diminui o ano atual, pelo ano de nascimento presente na identidade, resultando na idade
    public int calcularIdade(){
        return LocalDate.now().getYear() - getDataNascimento().getYear();
    }*/

    public void menu(){
        Scanner scan = new Scanner(System.in);

        int escolha = 0;

        while (escolha != 4 || escolha != 5) {
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
                                  - Checar validade;
                                  - Checar o nome do passaporte com o nome da identidade;
                                  - Verificar se a data de nascimento condiz com a idade dita.
                            
                                - Passaporte:
                                  - O país dito pelo imigrante deve estar de acordo com o redigido em seu passaporte;
                                  - O nome do imigrante deve coincidir com o nome dito.
                            
                            """);
                    System.out.println("Data atual: " + LocalDate.now());
                    break;
                case 2:

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

