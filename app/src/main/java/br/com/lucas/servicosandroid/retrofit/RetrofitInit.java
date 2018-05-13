package br.com.lucas.servicosandroid.retrofit;

import java.lang.annotation.Annotation;

import br.com.lucas.servicosandroid.model.Erro;
import br.com.lucas.servicosandroid.service.AlunoService;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

//nome para a classe ServiceGenerator
public class RetrofitInit {

    private final Retrofit retrofit;

    public RetrofitInit() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.25.10:8080/servicosteste/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

}
