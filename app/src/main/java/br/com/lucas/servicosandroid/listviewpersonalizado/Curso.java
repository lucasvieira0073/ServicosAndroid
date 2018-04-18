package br.com.lucas.servicosandroid.listviewpersonalizado;

public class Curso {

    private int id;
    private String nome;
    private String quant;

    public Curso() {

    }

    public Curso(int id, String nome, String quant) {
        this.id = id;
        this.nome = nome;
        this.quant = quant;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQuant() {
        return quant;
    }

    public void setQuant(String quant) {
        this.quant = quant;
    }
}
