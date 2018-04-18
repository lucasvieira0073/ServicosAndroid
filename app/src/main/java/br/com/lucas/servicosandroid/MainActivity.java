package br.com.lucas.servicosandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import br.com.lucas.servicosandroid.dto.AlunoSync;
import br.com.lucas.servicosandroid.model.Aluno;
import br.com.lucas.servicosandroid.model.Opcao;
import br.com.lucas.servicosandroid.retrofit.RetrofitInicializador;
import okhttp3.Headers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(this);


        /**
         *
         * outra coisa , considear que o response quando sucesso e retorna vazio
         * ele pode retornar corpo quando não sucesso (porem com a concexão estabelecida)
         * assim, crie uma classe genérica para receber esses dados de conexão com bad response
         */



        List<Opcao> alunos = new ArrayList<>();

        //lembrar de colocar public no construtor da classe opção
        alunos.add(new Opcao("Teste1"));
        alunos.add(new Opcao("Teste2"));
        alunos.add(new Opcao("Teste3"));


        ListView listaAlunos = (ListView) findViewById(R.id.lista_alunos);//alt + enter faz o import

        //convertendo Strings em Views   atenção para o contexto
        ArrayAdapter<Opcao> adapter = new ArrayAdapter<Opcao>(MainActivity.this, android.R.layout.simple_expandable_list_item_1, alunos);

        //vincula a lista com o adapter
        listaAlunos.setAdapter(adapter);



    }


    public void carregaLista() {

    }



    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.button :
                executaTudo();
                break;
        }

    }



    public void executaTudo() {

        Aluno aluno = new Aluno("Lucas", "Rua teste", "9999999", "www.site.com", 10.0, 0, 0);

        //funcionando , só esta comentado para não precisar criar outro botão
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

                /**
                 * Caso os parametros recebidos possam ser diferentes, basta somente ter certeza que todos os
                 * parametros estejam na classe de sync, mesmo que em algumas requisições todos os parametros não
                 * sejam recebidos
                 */

               // List<Aluno> alunos = alunoSync.getAlunos();


               // ListView listaAlunos = (ListView) findViewById(R.id.lista_alunos);//alt + enter faz o import

                //convertendo Strings em Views
               // ArrayAdapter<Aluno> adapter = new ArrayAdapter<Aluno>(MainActivity.this, android.R.layout.simple_expandable_list_item_1, alunos);

                //vincula a lista com o adapter
                //listaAlunos.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<AlunoSync> call, Throwable t) {
                Log.e("onFailure chamado", t.getMessage() );
            }
        });

        System.out.println("opa");
    }
}
