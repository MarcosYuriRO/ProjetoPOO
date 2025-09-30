package ProjectTest.Controle;

import ProjectTest.Documentos.Identidade;
import ProjectTest.Documentos.Passaporte;
import ProjectTest.Imigrantes.GeradorDeImigrantes;
import ProjectTest.Imigrantes.Imigrante;

import java.time.LocalDate;
import java.util.Scanner;

public class Jogo {

    //Atributos
    private int saldo;
    private int acertos;
    private int erros;
    private int ganhosDiario;
    private int perdasDiarias;
    private int diaAtual;
    private LocalDate dataAtual;
    private long tempoLimite;

    //Constantes
    private final int DIA_LIMITE = 10;
    private final int META_DINHEIRO = 1500; //Não sei exatamente qual é a meta
    private final int PAGAMENTO_POR_ACERTO = 50; //Cada acerto dará 50 pro jogador
    private final int CUSTO_POR_ERRO = 80; //Cada erro custará 80 pro jogador
    private final int CUSTO_DIARIO_FIXO = 100; //Aluguel, comida, agua

    Scanner escanear = new Scanner(System.in);

    //Construtor
    public Jogo() {
        this.diaAtual = 1;
        this.dataAtual = LocalDate.of(1982, 11, 23); //Data inicial
    }
    //Metodos

    //Inicia a lógica do jogo
    public void iniciarJogo() {
        iniciarDia(1);
    }

    private void iniciarDia(int dia) {
        long tempoInicial = System.currentTimeMillis();
       tempoLimite = tempoInicial + 60000;
        while ( System.currentTimeMillis() <= tempoLimite) {
            proximoImigrante(60000);
        }
        System.out.println("Seu turno acabou!!");
        finalizarDia();
    }

    //Chama o proximo imigrante
    private void proximoImigrante(long tempoLimite) {

        //Cria um imigrante
        Imigrante imigrante = GeradorDeImigrantes.gerarImigranteAleatorio(dataAtual);
        imigrante.dialogo(); //Chama o dialogo

        //Chama os docs do imigrantes
        Passaporte passaporte = (Passaporte) imigrante.getDocumentoPorTipo("passaporte");
        Identidade identidade = (Identidade) imigrante.getDocumentoPorTipo("identidade");
        verificarLegalidade(imigrante);

        String escolha;
        boolean decisaoTomada = false;

        //Loop que vai verificar (dura até o timer ter 60s ou até tomarem uma decisão)
        do {
            //Checaqgem de tempo interno (se o jogador demorar dmais no menu
            if (System.currentTimeMillis() >= tempoLimite) {
                System.out.println("O tempo acabou enquanto você estava verificar os dados!");
                return;  //Quita o metodo
            }

            System.out.println("""
                        [R] - Regras;
                        [P] - Passaporte;
                        [I] - Identidade;
                        [A] - Aceitar Entrada;
                        [N] - Negar Entrada.
                    """);
            System.out.println("Sua escolha:  ");
            escolha = escanear.nextLine().trim().toUpperCase();

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
                System.out.println("Data atual: " + dataAtual);
                    break;

                case "P":
                    if (passaporte != null) {
                        passaporte.exibirDetalhes();
                    } else {
                        System.out.println("Passaporte ausente");
                    }
                    break;

                case "I":
                    if (identidade != null) {
                        identidade.exibirDetalhes();
                    } else {
                        System.out.println("Identidade ausente");
                    }
                    break;

                case "A":
                    System.out.println("A porta ao lado do imigrante se abre. Você permite a entrada dele.");
                    if (verificarLegalidade(imigrante)) {
                        System.out.println("Você Acertou!");
                    } else {
                        System.out.println("Você Errou!");
                    }
                    break;

                case "N":
                    decisaoTomada = true;
                    System.out.println("Você chama os guardas para acompanharem o imigrante à saída.");
                    if (verificarLegalidade(imigrante)) {
                        System.out.println("Você Acertou!");
                    } else {
                        System.out.println("Você Errou!");
                    }
                    break;

                default:
                    System.out.println("Opção inserida é inválida!");

            }
        } while (!decisaoTomada) ; //Continua até que A ou N seja escolhida
    }

    private void finalizarDia() {
        System.out.println("Após um cansativo dia de trabalho, você volta para casa.");
        System.out.println("Acertos: " + acertos);
        System.out.println("Erros: " + erros);
        //Exibir dinheiro recebido no dia e dinheiro total
        ganhosDiario = acertos * PAGAMENTO_POR_ACERTO;
        System.out.println("\n Ganhos do dia: " + ganhosDiario);
        perdasDiarias = erros * CUSTO_POR_ERRO + CUSTO_DIARIO_FIXO;
        System.out.println("Gastos do dia: " + perdasDiarias);
        saldo += (ganhosDiario - perdasDiarias);
        System.out.println("Saldo total: " + saldo);

        if (saldo < 0) {
            System.out.println("Seu saldo zerou Você não pode pagar o aluguel e foi despejado.");
            System.out.println("Fim de jogo.");
            finalizarJogo();

        } else if (saldo >= META_DINHEIRO) {
            System.out.println("Parabéns, você venceu o jogo!!");
            finalizarJogo();
        }

    }
    private void avancarProximoDia () {
          System.out.println("O dia acabou..., mas um novo dia está para começar");
          diaAtual++;
          acertos = 0;
          erros = 0;
          iniciarDia(diaAtual);
        }

    private void finalizarJogo(){
    /*if (diaAtual >= DIA_LIMITE ) {
    } else {
    }*/
        System.out.println("FIM DE JOGO: Arstotzka agradece seus serviços");
        System.out.println("Saldo final: " + saldo);
    }

    private void processarDecisao(Imigrante imigrante, boolean aceitou) {
          boolean legal = verificarLegalidade(imigrante);
          boolean acertou = (aceitou && legal) || (!aceitou && !legal);

          if (acertou) {
              acertos++;
              System.out.println("✅ Você acertou! Ganhos contabilizados.");
          } else {
              erros++;
              System.out.println("❌ Você errou! Perdas contabilizadas.");
          }
        }

    //Insere o imigrante instanciado. caso a validade não esteja vencida e o nome e a idade coincidam com os ditos, retorna true. Se não, false
    public boolean verificarLegalidade(Imigrante dadosImigrante) {
         if(dadosImigrante.getNome().equals(dadosImigrante.getDocumentoPorTipo("identidade").getNomeCompleto()) &&
               dadosImigrante.getNome().equals(dadosImigrante.getDocumentoPorTipo("passaporte").getNomeCompleto()) && dadosImigrante.getDocumentoPorTipo("identidade").estaValido(LocalDate.now()) && dadosImigrante.getDocumentoPorTipo("passaporte").estaValido(LocalDate.now())) {
                return true;
            } else {
                return false;
            }
        }


}