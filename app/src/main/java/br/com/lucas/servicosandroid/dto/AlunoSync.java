package br.com.lucas.servicosandroid.dto;

import java.util.List;

import br.com.lucas.servicosandroid.model.Aluno;

//recebe fielmente os dados do json recebidos
public class AlunoSync {

    private List<Aluno> alunos;

    private String momentoDaUltimaModificacao;

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public String getMomentoDaUltimaModificacao() {
        return momentoDaUltimaModificacao;
    }
}
