package br.com.lucas.servicosandroid.retrofit.thread;

import retrofit2.Call;
import retrofit2.Response;

public interface ITarefaExecutar {
    Call getCall();
    void retornoComSucesso(Response response);
    void retornoSemSucesso(Response response);
    void retornoComErro(String message);

}
