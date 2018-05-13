package br.com.lucas.servicosandroid.teste;

import java.util.List;

import br.com.lucas.servicosandroid.model.Aluno;
import retrofit2.Call;
import retrofit2.http.POST;

public interface TesteService {
    @POST("aluno/listar")
    Call<List<Aluno>> alunos();
}
