package br.com.lucas.servicosandroid.service;

import br.com.lucas.servicosandroid.model.Aluno;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AlunoService {
    @POST("aluno")
    Call<Aluno> aluno();

}
