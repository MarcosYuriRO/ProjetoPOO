package ProjectTest.Documentos;

import java.time.LocalDate;

public abstract class Documento {
    //Atributos
    //Protected pra que o passaporte e a identidade acessem mais precisamente
    protected String nomeCompleto;
    protected LocalDate dataValidade;
    protected String tipo;
    //2025-05-20

    //Construtor
    public Documento(String nomeCompleto, LocalDate dataValidade, String tipo) {
        this.nomeCompleto = nomeCompleto;
        this.dataValidade = dataValidade;
        this.tipo = tipo;
    }

    //Metodo que checa se o doc é valido na data atual do game
    public boolean estaValido(LocalDate dataAtualDoJogo) {
        //Se o documento tiver data de validade antes ou igual, ele é TRUE e depois ele é FALSE
         return dataAtualDoJogo.isBefore(this.dataValidade) || dataAtualDoJogo.isEqual(this.dataValidade);
    }

    //Metodo abstrato que exibe os docs
    public abstract String exibirDetalhes();

    //Todos documentos devem ter este metodo, mas ele varia a cada subclasse devido seus diferentes atributos


    //Getters
    public String getNomeCompleto() {
        return nomeCompleto;
    }
    public LocalDate getDataValidade() {
        return dataValidade;
    }
    public String getTipo() {
        return tipo;
    }
}