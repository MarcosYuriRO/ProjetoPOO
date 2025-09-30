package ProjectTest.Documentos;

import java.time.LocalDate;

public class Identidade extends Documento{
    //Atributos
    private LocalDate dataNascimento;
    private int numeroRG;

    //Construtor
    public Identidade(String nomeCompleto, LocalDate validade, LocalDate dataNascimento, int numeroRG) {
        super(nomeCompleto, validade, "identidade");
        this.dataNascimento = dataNascimento;
        this.numeroRG = numeroRG;
    }

    public Identidade() {
    }

    //Metodo obrigatorio herdado da super Documento
    @Override
    public void exibirDetalhes() {

        //$-20S EQUIVALE AQUELE %S SÓ QUE COM O AJUSTE DE 20 CARACTERES PRA FICAR FOFINHO E N MUDAR A FORMATAÇÃO
        System.out.printf("""
                =======================================================
                |       🌟 ID CARD | CARTEIRA DE IDENTIDADE 🌟        |
                =======================================================
                | 📝 NOME COMPLETO:  %-20s           ------------     |
                | 👶 NASCIMENTO:  %-20s              |   FACE   |     |
                | 🔢 NÚMERO RG:  %-20d               |    ID    |     |
                | ♾️ VALIDADE:  %-20s                ------------     |
                =======================================================
                """, getNomeCompleto(), dataNascimento, numeroRG, getDataValidade());
    }

    public String toString() {
        return String.format("Validade: " + getDataValidade());
    }
}
