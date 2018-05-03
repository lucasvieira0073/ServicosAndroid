package br.com.lucas.servicosandroid.service;

import android.os.AsyncTask;

import br.com.lucas.servicosandroid.TesteActivity;
import br.com.lucas.servicosandroid.model.Aluno;
import br.com.lucas.servicosandroid.model.Erro;
import br.com.lucas.servicosandroid.retrofit.ErrorBody;
import br.com.lucas.servicosandroid.retrofit.RetrofitInit;
import br.com.lucas.servicosandroid.retrofit.thread.ITarefaExecutar;
import retrofit2.Call;
import retrofit2.Response;

public class TarefaAluno implements ITarefaExecutar {
    private TesteActivity testeActivity;


    public TarefaAluno(TesteActivity testeActivity) {
        this.testeActivity = testeActivity;
    }

    @Override
    public Call<Aluno> getCall() {
        return new RetrofitInit().getRetrofit().create(AlunoService.class).aluno();
    }

    @Override
    public void retornoComSucesso(Response response) {
        //Aluno aluno = (Aluno) response.body();

        //testeActivity.textView.setText(response);

        //System.out.println("Successfull " + response + " ================");
    }

    @Override
    public void retornoSemSucesso(Response response) {
        Erro erro = new ErrorBody<Erro>().getError(response, Erro.class);
        System.out.println("Error " + erro.getNome() + " ================");
    }

    @Override
    public void retornoComErro(String message) {

    }

}
