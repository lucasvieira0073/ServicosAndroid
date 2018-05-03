package br.com.lucas.servicosandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import br.com.lucas.servicosandroid.service.TarefaAluno;
import br.com.lucas.servicosandroid.retrofit.thread.TarefaService;

public class TesteActivity extends AppCompatActivity {
    public TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);

        textView = (TextView) findViewById(R.id.txtTeste);

        TarefaService tarefa = new TarefaService(TesteActivity.this, new TarefaAluno(TesteActivity.this));
        tarefa.execute();

      /*  tarefa.cancel(true);

        if(tarefa.isCancelled()) {
            System.out.println("FOI CANCELADA MESMO !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
        */

    }
}
