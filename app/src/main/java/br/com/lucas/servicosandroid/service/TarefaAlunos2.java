package br.com.lucas.servicosandroid.service;

import java.util.List;

import br.com.lucas.servicosandroid.Teste2Activity;
import br.com.lucas.servicosandroid.TesteActivity;
import br.com.lucas.servicosandroid.model.Aluno;
import br.com.lucas.servicosandroid.retrofit.RetrofitInit;
import br.com.lucas.servicosandroid.retrofit.thread.ITarefaExecutar;
import retrofit2.Call;
import retrofit2.Response;

public class TarefaAlunos2 implements ITarefaExecutar {
    private Teste2Activity teste2Activity;

    public TarefaAlunos2(Teste2Activity teste2Activity) {
        this.teste2Activity = teste2Activity;
    }

    @Override
    public Call getCall() {
        return new RetrofitInit().getRetrofit().create(AlunosService.class).alunos();
    }

    @Override
    public void retornoComSucesso(Response response) {
        List<Aluno> alunos = (List<Aluno>) response.body();


        for(Aluno aluno : alunos) {
            System.out.println(aluno.getNome());
        }


        teste2Activity.carregaLista(alunos);
    }

    @Override
    public void retornoSemSucesso(Response response) {
        System.out.println("SEM SUCESSO ---------------------");
    }

    @Override
    public void retornoComErro(String message) {
        System.out.println("SEM SUCESSO ---------------------");
    }
}
