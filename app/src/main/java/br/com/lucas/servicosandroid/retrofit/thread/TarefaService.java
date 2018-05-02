package br.com.lucas.servicosandroid.retrofit.thread;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.io.IOException;
import java.util.concurrent.Callable;

import retrofit2.Call;
import retrofit2.Response;

public class TarefaService implements Callable<Void> {

    private Activity activity;
    private boolean loop;
    private int millis;
    private ProgressBar progressBar;
    private boolean utilizaProgressBar;
    private ITarefaExecutar tarefaExecutar;


    public TarefaService(Activity activity, boolean loop, int millis, ITarefaExecutar tarefaExecutar) {
        this.activity = activity;
        this.loop = loop;
        this.millis = millis;
        this.tarefaExecutar = tarefaExecutar;
        this.utilizaProgressBar = false;
    }

    public TarefaService(Activity activity, boolean loop, int millis, ProgressBar progressBar, ITarefaExecutar tarefaExecutar) {
        this.activity = activity;
        this.loop = loop;
        this.millis = millis;
        this.progressBar = progressBar;
        this.tarefaExecutar = tarefaExecutar;
        this.utilizaProgressBar = true;
    }


    @Override
    public Void call() {
        System.out.println("Executou o calllllllllllllllllllll");
        do {
            System.out.println("Entrou no on Responseeeeeeeee");

            Call call = tarefaExecutar.getCall();
            try {
                Response response = call.execute();

                if (response.isSuccessful()) {
                    tarefaExecutar.retornoComSucesso(response);
                } else {
                    tarefaExecutar.retornoSemSucesso(response);
                }

                if(utilizaProgressBar) {
                    progressBar.setVisibility(View.INVISIBLE);
                    utilizaProgressBar = false;
                }

                Log.i("onResponse", "onResponse: Deuuuuuuuuuuuuuuuuuuuu");
            }catch(IOException e) {
                if (utilizaProgressBar) {
                    progressBar.setVisibility(View.INVISIBLE);
                    utilizaProgressBar = false;
                }

                Log.e("onFalilure", "onFailureeeeeeeeeeeeeee: " + e.getMessage());
                tarefaExecutar.retornoComErro(e.getMessage());
            }

            System.out.println("Esta no fluxo <><><><><><><><><><><><><>");
            if(loop) {
                try {
                    Thread.sleep(millis);
                } catch (InterruptedException e) {
                    System.out.println("Sleep interrompida!");
                }
            }
        }while (loop);

        System.out.println("THREAD CONCLUIDA COM SUCESSO!!!!!!!!!!!!!!!!!!");
        return null;
    }

    public void stop() {
        this.loop = false;
    }

    public void setLoop(boolean loop) {
        this.loop = true;
    }

    public boolean estaRodando() {
        return loop;
    }

}
