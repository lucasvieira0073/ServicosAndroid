package br.com.lucas.servicosandroid.teste;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.lucas.servicosandroid.TesteActivity;
import br.com.lucas.servicosandroid.model.Aluno;
import br.com.lucas.servicosandroid.retrofit.RetrofitInit;
import br.com.lucas.servicosandroid.retrofit.thread.ITarefaExecutar;
import br.com.lucas.servicosandroid.service.AlunosService;
import retrofit2.Call;
import retrofit2.Response;

public class TarefaTeste implements ITarefaExecutar {

    @Override
    public Call getCall() {
        return new RetrofitInit().getRetrofit().create(TesteService.class).alunos();
    }

    @Override
    public void retornoComSucesso(Response response) {
        System.out.println(" EXECUTADO COM SUCESSO ====================");
    }

    @Override
    public void retornoSemSucesso(Response response) {
        System.out.println("======================================== " + ErroUtil.convert(response).get(0).getNome() + " ========================================");

        System.out.println("SEM SUCESSO ---------------------");
    }


    @Override
    public void retornoComErro(String message) {

        System.out.println("SEM SUCESSO ---------------------");
    }
}
