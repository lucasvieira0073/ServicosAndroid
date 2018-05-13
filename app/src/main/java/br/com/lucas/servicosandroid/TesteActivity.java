package br.com.lucas.servicosandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.lucas.servicosandroid.model.Aluno;
import br.com.lucas.servicosandroid.service.TarefaAluno;
import br.com.lucas.servicosandroid.retrofit.thread.TarefaService;
import br.com.lucas.servicosandroid.service.TarefaAlunos;

public class TesteActivity extends AppCompatActivity {
    public TextView textView;
    public ListView listView;
    private TarefaService tarefa;
    private Map<Integer, Aluno> alunosMap = new HashMap<>();
    private List<Aluno> listaAlunos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);

        textView = (TextView) findViewById(R.id.txtTeste);
        listView = (ListView) findViewById(R.id.lista);


        Button btn = (Button) findViewById(R.id.botao);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TesteActivity.this, Teste2Activity.class);
                startActivity(intent);
            }
        });


        iniciaTarefa();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                System.out.println("click");
                CheckBox checkBox = (CheckBox) view.findViewById(R.id.lista_aluno_checkbox);

                if(checkBox.isChecked()) {
                    checkBox.setChecked(false);
                    checkBox.setVisibility(View.INVISIBLE);
                    Aluno aluno = (Aluno) parent.getItemAtPosition(position);
                    alunosMap.remove(aluno.getId());
                }else{
                    checkBox.setChecked(true);
                    checkBox.setVisibility(View.VISIBLE);
                    Aluno aluno = (Aluno)parent.getItemAtPosition(position);
                    alunosMap.put(aluno.getId(), aluno);
                }



                listarLista();

            }
        });

    }

    private void iniciaTarefa() {
        tarefa = new TarefaService(TesteActivity.this,false, new TarefaAlunos(TesteActivity.this));
        tarefa.execute();
    }

    public void carregaLista(List<Aluno> alunos) {
        AdapterAlunos adapter =
                new AdapterAlunos(alunos, TesteActivity.this);

        listView.setAdapter(adapter);
    }


    public void listarLista() {

        System.out.println("  ======= Fazem parte da lista de alunos, os alunos abaixo: ========");


        //opcao com MAP  codigo ok
       /*for(Aluno aluno : alunosMap.values()) {
            System.out.println("ID: " + aluno.getId() + ", nome: " +aluno.getNome());
        }*/

        listaAlunos = new ArrayList<Aluno>(alunosMap.values());

        for(Aluno aluno : listaAlunos) {
            System.out.println("ID: " + aluno.getId() + ", nome: " +aluno.getNome());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(!tarefa.isRunning()) {
            iniciaTarefa();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(tarefa.isRunning()) {
            tarefa.stop();
        }
    }

    @Override
    public void finish() {
        super.finish();

        if(tarefa.isRunning()) {
            tarefa.stop();
        }
    }
}
