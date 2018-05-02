package br.com.lucas.servicosandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.concurrent.Future;

import br.com.lucas.servicosandroid.service.TarefaAluno;
import br.com.lucas.servicosandroid.retrofit.thread.TarefaService;

public class TesteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);

        new Inicializacao();

        TarefaService service = new TarefaService(this, true, 5000, new TarefaAluno());

        Inicializacao.threadPool.submit(service);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        service.stop();

        if(!service.estaRodando()) {
            service.setLoop(true);
            Inicializacao.threadPool.submit(service);
        }


    }
}
