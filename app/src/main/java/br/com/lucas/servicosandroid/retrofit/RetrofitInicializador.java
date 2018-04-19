package br.com.lucas.servicosandroid.retrofit;

import br.com.lucas.servicosandroid.service.AlunoService;
import br.com.lucas.servicosandroid.service.ProdutoService;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

//nome para a classe ServiceGenerator
public class RetrofitInicializador extends CreateServices{

    private static Retrofit retrofit;

    public RetrofitInicializador() {
        retrofit = new Retrofit.Builder().baseUrl("http://192.168.25.10:8080/servicosteste/produtos/")
                .addConverterFactory(JacksonConverterFactory.create()).build();
    }

    public static Retrofit getRetrofit() {
        return retrofit;
    }

}
