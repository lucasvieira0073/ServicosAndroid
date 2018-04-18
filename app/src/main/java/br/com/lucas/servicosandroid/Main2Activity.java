package br.com.lucas.servicosandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.lucas.servicosandroid.listviewpersonalizado.AdapterCursosPersonalizado;
import br.com.lucas.servicosandroid.listviewpersonalizado.Curso;

import static java.security.AccessController.getContext;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        List<Curso> cursos = new ArrayList<>();

        cursos.add(new Curso(1, "Teste1", "3"));
        cursos.add(new Curso(2, "Teste2", "4"));
        cursos.add(new Curso(3, "Teste3", "5"));

        ListView listaDeCursos = (ListView) findViewById(R.id.lista_teste);

        //chamada da implementaçao do android:
        //ArrayAdapter<Curso> adapter = new ArrayAdapter<Curso>(this,
        //android.R.layout.simple_list_item_1, cursos);

        //chamada da nossa implementação
        AdapterCursosPersonalizado adapter =
                new AdapterCursosPersonalizado(cursos, this);

        listaDeCursos.setAdapter(adapter);


       listaDeCursos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Curso curso = (Curso) parent.getItemAtPosition(position);

               Toast.makeText(Main2Activity.this, "Item : " + curso.getNome(), Toast.LENGTH_SHORT).show();
           }
       });
    }
}
