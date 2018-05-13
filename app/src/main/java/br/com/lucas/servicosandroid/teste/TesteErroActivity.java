package br.com.lucas.servicosandroid.teste;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.lucas.servicosandroid.R;
import br.com.lucas.servicosandroid.retrofit.thread.TarefaService;

public class TesteErroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste_erro);


        new TarefaService(this, false, new TarefaTeste()).execute();



        //System.out.println("funcionou ================================");




    }
}
