package br.com.lucas.servicosandroid.service;

import java.util.List;

import br.com.lucas.servicosandroid.dto.AlunoSync;
import br.com.lucas.servicosandroid.model.Aluno;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AlunoService {

    @POST("aluno")
    Call<Void> insere(@Body Aluno aluno);

    @GET("aluno")
    Call<AlunoSync> lista();


}
