package ProjectTest.Imigrantes;

import ProjectTest.Documentos.Documento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeradorDeImigrantes {
    package ProjectTest.Imigrantes;

import ProjectTest.Documentos.Documento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

    public class GeradorDeImigrantes {
        private static final Random aleatorio = new Random();

        private static final String[] NOMES = {"Victor", "Maria", "Sergei", "Katrina", "Zoran", "Elsa", "Javier"};
        private static final String[] PAISES = {"Arstotzka", "Kolechia", "Republia", "Obristan", "Antaria"};

        // O método principal
        public static Imigrante gerarImigranteAleatorio(LocalDate dataAtual) {
            //Sorteando dados
            String nomeSorteado = NOMES[aleatorio.nextInt(NOMES.length)];
            String paisSorteado = PAISES[aleatorio.nextInt(PAISES.length)];

            List<Documento> documentos = new ArrayList<>();
            boolean deveSerAceito = true; // Assume que o imigrante é bom por padrão
            boolean temErroNoDocumento = false; // Se tiver algum erro

            if (aleatorio.nextDouble() < 0.30) {
                temErroNoDocumento = true;
                deveSerAceito = false; // Se há erro, a resposta correta do sistema é rejeitar
            }

            LocalDate dataDeValidade;

            if (temErroNoDocumento && aleatorio.nextBoolean()) {
                // Causa um ERRO de VENCIMENTO no Passaporte
                dataDeValidade = dataAtual.minusDays(1 + aleatorio.nextInt(365));
                temErroNoDocumento = false; // Se o erro já foi usado, guarda aqui
            } else {
                // Passaporte valido
                dataDeValidade = dataAtual.plusDays(1 + aleatorio.nextInt(365));
            }

            // 80% de chance de ter identidade, 20% de chance de estar ausente
            if (aleatorio.nextDouble() < 0.80) {
                LocalDate validadeIdentidade = dataAtual.plusYears(10);
                boolean erroDeConteudo = false;
                if (deveSerAceito && aleatorio.nextDouble() < 0.15) {
                    erroDeConteudo = true;
                    deveSerAceito = false; // Se o nome estiver errado, o imigrante deve ser rejeitado
                    System.out.println("  ERRO! - Nome diferente na Identidade.");
                }


            } else {
                //Se não tiver identidade
                if (deveSerAceito) {
                    deveSerAceito = false;
                }

                // Não adicionamos nenhum objeto à lista de documentos, simulando a falta.
                System.out.println("  ERRO! - Identidade ausente.");
            }

            // Retorna o objeto Imigrante totalmente construído
            return new Imigrante(nomeSorteado, paisSorteado, documentos, deveSerAceito);

        }

    }
}
