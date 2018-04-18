package br.com.lucas.servicosandroid.listviewpersonalizado;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.lucas.servicosandroid.R;

public class AdapterCursosPersonalizado extends BaseAdapter{

    private final List<Curso> cursos;
    private final Activity activity;

    public AdapterCursosPersonalizado(List<Curso> cursos, Activity activity) {
        this.cursos = cursos;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return cursos.size();
    }

    @Override
    public Object getItem(int i) {
        return this.cursos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view = activity.getLayoutInflater()
                .inflate(R.layout.activity_main3, viewGroup, false);
        Curso curso = cursos.get(position);

        TextView nome = (TextView) view.findViewById(R.id.main3_t1);
        TextView quantidade = (TextView) view.findViewById(R.id.main3_t2);

        nome.setText(curso.getNome());
        quantidade.setText(curso.getQuant());


        return view;
    }
}
