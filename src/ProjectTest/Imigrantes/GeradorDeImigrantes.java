package ProjectTest.Imigrantes;

import ProjectTest.Documentos.Documento;
import ProjectTest.Documentos.Identidade;
import ProjectTest.Documentos.Passaporte;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeradorDeImigrantes {

    //Randomizando as coisas
    private static final Random aleatorio = new Random();

    //Arrays de nomes e paises a serem utilizados nos imigrantes
    private static final String[] NOMES = {"Victor", "Maria", "Sergei", "Katrina", "Zoran", "Elsa", "Javier"};
    private static final String[] PAISES = {"Arstotzka", "Kolechia", "Republia", "Obristan", "Antaria"};

    //Metodo simples pra gerar numeros pro numero de passaporte e pro RG
    private static int gerarNumeroUnico() {
        return 1000000 + aleatorio.nextInt(9999999);
    }

    //O metodo principal
    public static Imigrante gerarImigranteAleatorio(LocalDate dataAtual) {
        //Sorteando dados do imigrante
        String nomeSorteado = NOMES[aleatorio.nextInt(NOMES.length)];
        String paisSorteado = PAISES[aleatorio.nextInt(PAISES.length)];
        List<Documento> documentos = new ArrayList<>();

        // Assume que está correto(TRUE) por padrão
        boolean deveSerAceito = true;

        // ----------- GERANDO PASSAPORTE (30% de chance de sairr)

        //Válidoo por até 5 anos
        LocalDate validadePassaporte = dataAtual.plusDays(1 + aleatorio.nextInt(365 * 5));
        int numeroPassaporte = Integer.parseInt(String.valueOf(gerarNumeroUnico()));


        //Tem 70% de chance de não ter uma
        if (aleatorio.nextDouble() < 0.30) {
            deveSerAceito = false; // Se há erro, a resposta correta do sistema é rejeitar

            switch (aleatorio.nextInt(3)) {
                case 0:
                    //Erro 01 --> PASSAPORTE venciido
                    validadePassaporte = dataAtual.minusDays(1 + aleatorio.nextInt(365));
                    break;
                case 1:
                    //Error 02 --> Nome errado no passaporte --- comparado com o do imigrante
                    String nomeFalso = NOMES[aleatorio.nextInt(NOMES.length)];
                    nomeSorteado = nomeFalso; //Nome do imigrante será o falso
                    break;
                case 2:
                    //Erro 03 --> Não tem passaporte
                    //Não vamos add o passaporte ao Imigrante
                    return new Imigrante(nomeSorteado, paisSorteado, documentos, false);
            }
        }

            //Aqui cria e add o passaporte
            Passaporte passaporte = new Passaporte(nomeSorteado, validadePassaporte, numeroPassaporte, paisSorteado);
            documentos.add(passaporte);


            // ----------- GERANDO IDENTIDADE (80% de chance de sair uma)

            // 80% de chance de ter identidade, 20% de chance de estar ausente
            if (aleatorio.nextDouble() < 0.80) {
                LocalDate validadeIdentidade = dataAtual.plusYears(10);
                //O imigrante vai ser adulto (podemos mudar se quiserem)
                LocalDate dataNascimento = dataAtual.minusYears(18 + aleatorio.nextInt(40));
                int numeroRG = gerarNumeroUnico();

                //20% de chance de erro nos dados do ID
                if (deveSerAceito && aleatorio.nextDouble() < 0.20) {
                    deveSerAceito = false; // Se o nome estiver errado, o imigrante deve ser rejeitado

                    String nomeErrado = NOMES[aleatorio.nextInt(NOMES.length)];
                    nomeSorteado = nomeErrado; //O nome sorteado será o errado

                }

                Identidade identidade = new Identidade(nomeSorteado, validadeIdentidade, dataNascimento, numeroRG);
                documentos.add(identidade);
            } else {
                //Se não tiver identidade
                if (deveSerAceito) {
                    deveSerAceito = false;
                }

            }

            // Retorna o objeto Imigrante totalmente construído
            return new Imigrante(nomeSorteado, paisSorteado, documentos, deveSerAceito);
        }
}