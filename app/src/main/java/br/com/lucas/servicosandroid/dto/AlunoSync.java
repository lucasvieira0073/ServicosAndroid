package br.com.lucas.servicosandroid.dto;

import java.util.List;
import java.util.Objects;

import br.com.lucas.servicosandroid.model.Aluno;

//recebe fielmente os dados do json recebidos
public class AlunoSync {

    private List<Aluno> alunos;

    private String momentoDaUltimaModificacao;

    private String eco;

    public String getEco() {
        return eco;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public String getMomentoDaUltimaModificacao() {
        return momentoDaUltimaModificacao;
    }

}
