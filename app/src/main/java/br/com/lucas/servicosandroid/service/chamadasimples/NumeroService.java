package br.com.lucas.servicosandroid.service.chamadasimples;

import retrofit2.Call;
import retrofit2.http.POST;

public interface NumeroService {
    @POST("aluno/numero")
    Call<RetornoNumero> numero();
}
