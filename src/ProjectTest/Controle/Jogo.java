package ProjectTest.Controle;

import ProjectTest.Documentos.Identidade;
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
    private int diaLimite;
    private LocalDate dataAtual;
    private long tempoLimite;

    //Constantes
    private final int DIA_LIMITE = 10;
    private final int META_DINHEIRO = 1500; //Não sei exatamente qual é a meta
    private final int PAGAMENTO_POR_ACERTO = 50; //Cada acerto dará 50 pro jogador
    private final int CUSTO_POR_ERRO = 80; //Cada erro custará 80 pro jogador
    private final int CUSTO_DIARIO_FIXO = 100; //Aluguel, comida, agua


    //Metodos

    public void iniciarJogo() {
        iniciarDia(1);
    }

    private void iniciarDia(int dia) {
        MenuInGame menuInGame = new MenuInGame();
        long tempoInicial = System.currentTimeMillis();
       tempoLimite = tempoInicial + 60000;
        while ( System.currentTimeMillis() <= tempoLimite) {
            proximoImigrante();
            menuInGame.menu();
        }
        System.out.println("Seu turno acabou!!");
        finalizarDia();
    }

    private void proximoImigrante() {
        GeradorDeImigrantes.gerarImigranteAleatorio(LocalDate.now());
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

        if (diaAtual >= DIA_LIMITE )
        }


    //Insere o imigrante instanciado. caso a validade não esteja vencida e o nome e a idade coincidam com os ditos, retorna true. Se não, false
      public boolean verificarLegalidade(Imigrante dadosImigrante) {
            if(){
                return true;
            } else {
                return false;
            }
        }


}