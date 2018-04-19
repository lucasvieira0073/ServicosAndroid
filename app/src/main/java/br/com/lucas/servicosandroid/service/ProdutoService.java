package br.com.lucas.servicosandroid.service;

import br.com.lucas.servicosandroid.dto.ProdutoRetorno;
import retrofit2.Call;
import retrofit2.http.POST;

public interface ProdutoService {
    @POST("listar")
    Call<ProdutoRetorno> listar();
}
