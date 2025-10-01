package ProjectMain.Controle;

import ProjectMain.Documentos.Identidade;
import ProjectMain.Documentos.Passaporte;
import ProjectMain.Imigrantes.GeradorDeImigrantes;
import ProjectMain.Imigrantes.Imigrante;

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


    //Constantes
    private final int DIA_LIMITE = 5;
    private final int META_DINHEIRO = 1500; //Não sei exatamente qual é a meta
    private final int PAGAMENTO_POR_ACERTO = 50; //Cada acerto dará 50 pro jogador
    private final int CUSTO_POR_ERRO = 80; //Cada erro custará 80 pro jogador
    private final int CUSTO_DIARIO_FIXO = 100; //Aluguel, comida, agua
    private final long TEMPO_LIMITE = 90000;

    Scanner escanear = new Scanner(System.in);

    //Construtor
    public Jogo() {
        this.diaAtual = 1;
        this.dataAtual = LocalDate.of(1982, 11, 23); //Data inicial
    }
    //Metodos

    //Inicia a lógica do jogo
    public void iniciarJogo() {
        this.diaAtual = 1;

        while ((diaAtual <= DIA_LIMITE) && (saldo < META_DINHEIRO)) {
            System.out.printf("""
                            LEMBRETE: Em seu contrato, você ganhará %d a cada acerto, mas perderá %d para cada erro
                            na liberação e negação de imigrantes. (Lembre-se, seu aluguel diário é de %d.)\n
                    """, PAGAMENTO_POR_ACERTO, CUSTO_POR_ERRO, CUSTO_DIARIO_FIXO);
            System.out.println("Você inicia sua jornada na fronteira de Arstotzka!");
            System.out.println("Dia: " + diaAtual + "\nMeta: $" + META_DINHEIRO);

            //Inicia o timer
            iniciarDia();
        }

        //Se sai do loop, quer dizer que acabou algo (tempo ou dinhero)
        finalizarJogo();
        return;
    }

    private void iniciarDia() {
        //TIMER 60S
        long tempoInicial = System.currentTimeMillis();
        long tempoLimite = tempoInicial + TEMPO_LIMITE;//Quando o dia acabaa

        while (System.currentTimeMillis() < tempoLimite) {
            proximoImigrante(tempoLimite);
        }
        System.out.println("Seu turno acabou!!");
        finalizarDia();

    }

    //Chama o proximo imigrante
    private void proximoImigrante(long TEMPO_LIMITE) {

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
            if (System.currentTimeMillis() >= TEMPO_LIMITE) {
                System.out.println("O tempo acabou enquanto você estava verificando os dados!");
                return;  //Quita o metodo
            }

            System.out.println("""
                        [R] - Regras (Checar Data);
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
                                Documentos Obrigatórios para todas as nacionalidades:
                                - Identidade:
                                  - Nome da Identidade diferente com o nome ditado pelo imigrante;
                                  - Verificar expiração do documento;
                            
                                - Passaporte:
                                  - Nome no Passaporte não coincide com o dito pelo imigrante;
                                  - Verificar expiração do documento;
                            
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
                    decisaoTomada = true;
                    System.out.println("A porta ao lado do imigrante se abre. Você permite a entrada dele.");
                    processarDecisao(imigrante, true);
                    break;

                case "N":
                    decisaoTomada = true;
                    System.out.println("Você chama os guardas para acompanharem o imigrante à saída.");
                    processarDecisao(imigrante, false);
                    break;

                default:
                    System.out.println("Opção inserida é inválida!");

            }
        } while (!decisaoTomada); //Continua até que A ou N seja escolhida
    }

    private void finalizarDia() {
        System.out.println("Após um cansativo dia de trabalho, você volta para casa.");
        System.out.println("Acertos: " + acertos);
        System.out.println("Erros: " + erros);

        //Exibir dinheiro recebido no dia e dinheiro total
        ganhosDiario = acertos * PAGAMENTO_POR_ACERTO;
        System.out.println("\nGanhos do dia: " + ganhosDiario);
        perdasDiarias = erros * CUSTO_POR_ERRO + CUSTO_DIARIO_FIXO;
        System.out.println("Gastos do dia: " + perdasDiarias);
        saldo += (ganhosDiario - perdasDiarias);


        System.out.println("Saldo total: " + saldo);

        if (saldo < 0) {
            System.out.println("Seu saldo zerou! Você não pôde pagar o aluguel e foi despejado.");
            System.out.println("Fim de jogo.");
            finalizarJogo();
            return; //Termina o metodo

        } else if (saldo >= META_DINHEIRO) {
            System.out.println("Parabéns, você venceu o jogo!!");
            finalizarJogo();
            return; //Termina o metodo
        }

        avancarProximoDia();

    }

    private void avancarProximoDia() {
        System.out.println("O dia acabou...\n Mas um novo dia está para começar!");

        //Arruma os contadores e avança o dia
        diaAtual++;
        acertos = 0;
        erros = 0;

        //Inicia um novo dia
        iniciarDia();
    }

    private void finalizarJogo() {

        System.out.println("FIM DE JOGO: Arstotzka agradece seus serviços");
        System.out.println("Saldo final: " + saldo);
        return;
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
        Passaporte passaporte = (Passaporte) dadosImigrante.getDocumentoPorTipo("passaporte");
        Identidade identidade = (Identidade) dadosImigrante.getDocumentoPorTipo("identidade");

        if (passaporte == null || identidade == null) {
            //Documento não está aqui, corrige o erro do terminal
            return false;
        }

        boolean nomeEstaCerto = dadosImigrante.getNome().equals(dadosImigrante.getDocumentoPorTipo("identidade").getNomeCompleto()) &&
                dadosImigrante.getNome().equals(dadosImigrante.getDocumentoPorTipo("passaporte").getNomeCompleto());

        boolean docsEstaoValidos = dadosImigrante.getDocumentoPorTipo("identidade").estaValido(dataAtual) &&
                dadosImigrante.getDocumentoPorTipo("passaporte").estaValido(dataAtual);

        return nomeEstaCerto && docsEstaoValidos;


    }
}