package br.com.lucas.servicosandroid;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import br.com.lucas.servicosandroid.model.Aluno;

public class AdapterAlunos extends BaseAdapter {

    private final List<Aluno> alunos;
    private final Activity activity;

    public AdapterAlunos(List<Aluno> alunos, Activity activity) {
        this.alunos = alunos;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Object getItem(int i) {
        return alunos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view = activity.getLayoutInflater()
                .inflate(R.layout.lista_aluno, viewGroup, false);
        Aluno aluno = alunos.get(position);

        CheckBox checkBox = (CheckBox) view.findViewById(R.id.lista_aluno_checkbox);
        TextView textView = (TextView) view.findViewById(R.id.lista_aluno_textView);

        checkBox.setVisibility(View.INVISIBLE);
        textView.setText(aluno.getNome());

        return view;
    }
}
