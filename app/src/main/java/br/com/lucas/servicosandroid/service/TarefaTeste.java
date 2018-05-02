package br.com.lucas.servicosandroid.service;

import br.com.lucas.servicosandroid.retrofit.RetrofitInit;
import br.com.lucas.servicosandroid.retrofit.thread.ITarefaExecutar;
import retrofit2.Call;
import retrofit2.Response;

public class TarefaTeste implements ITarefaExecutar {

    @Override
    public Call getCall() {
        return new RetrofitInit().getRetrofit().create(AlunoService.class).aluno();
    }

    @Override
    public void retornoComSucesso(Response response) {

    }

    @Override
    public void retornoSemSucesso(Response response) {

    }

    @Override
    public void retornoComErro(String message) {

    }
}
