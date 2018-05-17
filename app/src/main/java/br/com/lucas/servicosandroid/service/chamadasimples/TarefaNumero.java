package br.com.lucas.servicosandroid.service.chamadasimples;

import br.com.lucas.servicosandroid.retrofit.RetrofitInit;
import br.com.lucas.servicosandroid.retrofit.thread.ITarefaExecutar;
import br.com.lucas.servicosandroid.teste.Processador;
import br.com.lucas.servicosandroid.teste.TesteErroActivity;
import retrofit2.Call;
import retrofit2.Response;

public class TarefaNumero implements ITarefaExecutar {
    private TesteErroActivity testeErroActivity;

    public TarefaNumero(TesteErroActivity testeErroActivity) {
        this.testeErroActivity = testeErroActivity;
    }

    @Override
    public Call getCall() {
        return new RetrofitInit().getRetrofit().create(NumeroService.class).numero();
    }

    @Override
    public void retornoComSucesso(Response response) {

        RetornoNumero retornoNumero = (RetornoNumero) response.body();

        testeErroActivity.numero = retornoNumero.getNumero();

    }

    @Override
    public void retornoSemSucesso(Response response) {

    }

    @Override
    public void retornoComErro(String message) {

    }

}
