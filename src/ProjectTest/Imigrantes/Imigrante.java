package ProjectTest.Imigrantes;

import ProjectTest.Documentos.Documento;

import javax.swing.text.html.parser.DocumentParser;
import java.util.List;

public class Imigrante {
    //Atributos essenciais de um Imigrante
    private String nome;
    private String nacionalidadeReal; //A real naciolidade pra comparar
    private List<Documento> documentos; //Lista de docs gerados
    private Decisao decisaoCorreta; //A decisão correta/resposta certa

    //Construtor
    public Imigrante(String nome, String nacionalidadeReal, List<Documento> documentos, Decisao decisaoCorreta) {
        this.nome = nome;
        this.nacionalidadeReal = nacionalidadeReal;
        this.documentos = documentos;
        this.decisaoCorreta = decisaoCorreta;
    }

    //Getter and setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getNacionalidadeReal() {
        return nacionalidadeReal;
    }
    public void setNacionalidadeReal(String nacionalidadeReal) {
        this.nacionalidadeReal = nacionalidadeReal;
    }

    public Decisao isDecisaoCorreta() {
        return decisaoCorreta;
    }
    public void setImigranteLegal(Decisao decisaoCorreta) {
        this.decisaoCorreta = decisaoCorreta;
    }

    //Métodos
    public void dialogo() {
        System.out.println("Olá, meu nome é " + nome + "e sou de " + nacionalidadeReal + ".");
    }

    public Documento getDocumentoPorTipo(String tipo)

}
