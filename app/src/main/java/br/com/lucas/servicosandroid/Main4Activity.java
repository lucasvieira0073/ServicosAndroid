package br.com.lucas.servicosandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.lucas.servicosandroid.dto.ProdutoRetorno;
import br.com.lucas.servicosandroid.retrofit.APIError;
import br.com.lucas.servicosandroid.retrofit.ErrorUtils;
import br.com.lucas.servicosandroid.retrofit.RetrofitInicializador;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        Call<ProdutoRetorno> call = new RetrofitInicializador().getProdutoService().listar();

        call.enqueue(new Callback<ProdutoRetorno>() {
            @Override
            public void onResponse(Call<ProdutoRetorno> call, Response<ProdutoRetorno> response) {

                if(response.isSuccessful()) {
                    Log.i("onResponse", "Sucesso!");
                    ProdutoRetorno retorno = response.body();

                    System.out.println("Retorno: " + retorno.getId() + "-" + retorno.getDescricao());
                }else{

                    APIError error = ErrorUtils.parseError(response);


                    System.out.println(error.getDescricao());

                }


            }

            @Override
            public void onFailure(Call<ProdutoRetorno> call, Throwable t) {
                Log.e("onFailure", "Falhou " + t.getMessage() );
            }
        });

    }


    //finish chama com toda certeza onDestroy
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
