package br.com.lucas.servicosandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

import br.com.lucas.servicosandroid.dto.AlunoSync;
import br.com.lucas.servicosandroid.model.Aluno;
import br.com.lucas.servicosandroid.retrofit.RetrofitInicializador;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executaTudo();
            }
        });

    }



    public void executaTudo() {

        Aluno aluno = new Aluno("Lucas", "Rua teste", "9999999", "www.site.com", 10.0, 0, 0);


       /* Call call = new RetrofitInicializador().getAlunoService().insere(aluno);

        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Log.i("onResponse", "requisição com sucesso ");
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e("onFailure", "requisição com falha");
            }
        }); */


       //lembrando que esse metodo enqueue é assincrona , oque vier depois pode ser executado antes
        Call<AlunoSync> call = new RetrofitInicializador().getAlunoService().lista();
        call.enqueue(new Callback<AlunoSync>() {
            @Override
            //Call tras as informações da requisição e o response o json
            public void onResponse(Call<AlunoSync> call, Response<AlunoSync> response) {
                AlunoSync alunoSync = response.body();

                List<Aluno> alunos = alunoSync.getAlunos();

                for(Aluno aluno : alunos) {
                    System.out.println(aluno.getNome());
                }


            }

            @Override
            public void onFailure(Call<AlunoSync> call, Throwable t) {
                Log.e("onFailure chamado", t.getMessage() );
            }
        });

        System.out.println("opa");
    }
}
