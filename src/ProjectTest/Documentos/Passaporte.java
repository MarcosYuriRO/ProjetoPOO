package ProjectTest.Documentos;

import java.time.LocalDate;

public class Passaporte extends Documento{
    //Atributos
    private int numeroDoPassaporte;
    private String paisDeOrigem;

    //Construtor
    public Passaporte(String nomeCompleto, LocalDate validade, int numeroDoPassaporte, String paisDeOrigem) {
        super(nomeCompleto, validade, "passaporte");
        this.numeroDoPassaporte = numeroDoPassaporte;
        this.paisDeOrigem = paisDeOrigem;
    }

    //Getters
    public int getNumeroDoPassaporte() {
        return numeroDoPassaporte;
    }
    public String getPaisDeOrigem() {
        return paisDeOrigem;
    }

    //Metodo obrigatorio herdado da super Documento
    @Override
    public void exibirDetalhes() {
        System.out.printf("""
                =======================================================
                |            ✈️ PASSAPORTE DE VIAGEM ✈️               |
                -------------------------------------------------------
                | 🌍 PAÍS DE ORIGEM:  %-18s                           |
                -------------------------------------------------------
                | 📝 NOME:  %-18s                                     |
                -------------------------------------------------------
                | 🔢 NÚMERO: %-18d                                    |
                | 📅 EXPIRAÇÃO:  %-18s     <-- CHECAR ESSE DADO       |
                =======================================================
                """, paisDeOrigem, getNomeCompleto(), numeroDoPassaporte, getDataValidade());

    }
}

