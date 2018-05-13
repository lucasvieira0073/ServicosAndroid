package br.com.lucas.servicosandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.lucas.servicosandroid.model.Aluno;
import br.com.lucas.servicosandroid.retrofit.thread.TarefaService;
import br.com.lucas.servicosandroid.service.TarefaAlunos;
import br.com.lucas.servicosandroid.service.TarefaAlunos2;

public class Teste2Activity extends AppCompatActivity {
    public TextView textView;
    public ListView listView;

    private Map<Integer, Aluno> alunosMap = new HashMap<>();
    private List<Aluno> listaAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste2);
        textView = (TextView) findViewById(R.id.txtTeste2);
        listView = (ListView) findViewById(R.id.lista2);

        TarefaService tarefa = new TarefaService(Teste2Activity.this,false, new TarefaAlunos2(Teste2Activity.this));
        tarefa.execute();


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

    public void carregaLista(List<Aluno> alunos) {
        AdapterAlunos2 adapter =
                new AdapterAlunos2(alunos, Teste2Activity.this);

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

}
