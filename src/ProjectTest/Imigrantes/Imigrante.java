package ProjectTest.Imigrantes;

import ProjectTest.Documentos.Documento;

import java.util.List;

public class Imigrante {
    //Atributos essenciais de um Imigrante
    private String nome;
    private String nacionalidadeReal; //A real naciolidade pra comparar
    private List<Documento> documentos; //Lista de docs gerados
    private boolean decisaoCorreta; //A decisão correta/resposta certa

    //Construtores
    public Imigrante(String nome, String nacionalidadeReal, List<Documento> documentos, boolean decisaoCorreta) {
        this.nome = nome;
        this.nacionalidadeReal = nacionalidadeReal;
        this.documentos = documentos;
        this.decisaoCorreta = decisaoCorreta;
    }

    //Getters
    public String getNome() {
        return nome;
    }


    //Métodos
    public void dialogo() {
        System.out.println("Olá, meu nome é " + nome + " e sou de " + nacionalidadeReal + ".");
    }

    public Documento getDocumentoPorTipo(String tipo) {
        //For-each pra procurar por tipo na lista de documentos se tem um documento
        for (Documento doc : documentos) {
            if (doc.getTipo().equalsIgnoreCase(tipo)) {
                return doc;
            }
        }
        //Se o loop terminar e não tiver nenhum doc, retorna Null
        return null;
    }

    @Override
    public String toString() {
        return "Imigrante: " + nome + " |  Documentos: " + documentos + "|  Nacionalidade Declarada: " + nacionalidadeReal + " | Decisão correta: " + decisaoCorreta;
    }
}