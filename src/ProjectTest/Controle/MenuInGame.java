package ProjectTest.Controle;

import ProjectTest.Documentos.Identidade;
import ProjectTest.Documentos.Passaporte;
import ProjectTest.Imigrantes.GeradorDeImigrantes;
import ProjectTest.Imigrantes.Imigrante;

import java.time.LocalDate;
import java.util.Scanner;

public class MenuInGame {
    public void menu(){

        Imigrante imigrante = GeradorDeImigrantes.gerarImigranteAleatorio(LocalDate.now());
        Passaporte passaporte = (Passaporte) imigrante.getDocumentoPorTipo("passaporte");
        Identidade identidade = (Identidade) imigrante.getDocumentoPorTipo("identidade");
        Jogo verificar = new Jogo();
        verificar.verificarLegalidade(imigrante);


        String escolha;
        int pararCodigo = 0;


        do {

            escolha = scan.nextLine();



        } while (pararCodigo == 0);
    }
}
