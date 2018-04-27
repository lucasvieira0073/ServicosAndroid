package br.com.lucas.servicosandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.IOException;
import java.lang.annotation.Annotation;

import br.com.lucas.servicosandroid.model.Aluno;
import br.com.lucas.servicosandroid.model.Erro;
import br.com.lucas.servicosandroid.retrofit.ErrorBody;
import br.com.lucas.servicosandroid.retrofit.RetrofitInit;
import br.com.lucas.servicosandroid.service.AlunoService;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TesteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);




        //Call<Aluno> call = new RetrofitInit().getAlunoService().aluno();
        Call<Aluno> call = new RetrofitInit().getRetrofit().create(AlunoService.class).aluno();
        call.enqueue(new Callback<Aluno>() {
            @Override
            public void onResponse(Call<Aluno> call, Response<Aluno> response) {
                if(response.isSuccessful()) {
                    Aluno aluno = response.body();

                    System.out.println("Sucefull " + aluno.getNome() + "=====================");

                }else{

                    Erro erro = new ErrorBody<Erro>().getError(response, Erro.class);
                    System.out.println(erro.getNome());






                   /* Converter<ResponseBody, Erro> converter = new RetrofitInit().getRetrofit().responseBodyConverter(Erro.class, new Annotation[0]);
                    try {
                        Erro erro = converter.convert(response.errorBody());
                        System.out.println("Error body " + erro.getNome() + "==========================");
                    } catch (IOException e) {
                        e.printStackTrace();
                    } */

                }
            }

            @Override
            public void onFailure(Call<Aluno> call, Throwable t) {
                Log.e("onFailure", "Falhou aqui " + t.getMessage());
            }
        });
    }
}
