package br.com.lucas.servicosandroid.model;

public class Aluno {
    private String id;
    private String nome;
    private String endereco;
    private String telefone;
    private String site;
    private Double nota;
    private int desativado;
    private int idCliente;

    public Aluno() {}

    public Aluno(String nome, String endereco, String telefone, String site, Double nota, int desativado, int idCliente) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.site = site;
        this.nota = nota;
        this.desativado = desativado;
        this.idCliente = idCliente;
    }

    public Aluno(String id, String nome, String endereco, String telefone, String site, Double nota, int desativado, int idCliente) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.site = site;
        this.nota = nota;
        this.desativado = desativado;
        this.idCliente = idCliente;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public int getDesativado() {
        return desativado;
    }

    public void setDesativado(int desativado) {
        this.desativado = desativado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return getId() + " - " + getNome();
    }
}
