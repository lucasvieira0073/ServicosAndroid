package br.com.lucas.servicosandroid.teste;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.lucas.servicosandroid.R;
import br.com.lucas.servicosandroid.retrofit.thread.TarefaService;
import br.com.lucas.servicosandroid.service.chamadasimples.TarefaNumero;

public class TesteErroActivity extends AppCompatActivity {
    public int numero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste_erro);

        processa();

    }

    public void processa() {

        new TarefaService(this, false, new TarefaNumero(this)).execute();
        new TarefaService(this, false, new TarefaTeste(this)).execute();

    }

}
