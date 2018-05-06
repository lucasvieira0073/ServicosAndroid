package br.com.lucas.servicosandroid.retrofit.thread;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.Callable;

import retrofit2.Call;
import retrofit2.Response;

public class TarefaService extends AsyncTask<Void, Integer, Integer> {//entrada doInBack     //entrada onProgress   //saida doback e entrada do postExec

    private Activity activity;
    private ITarefaExecutar tarefaExecutar;
    boolean loop;

    private Response responseResult;
    private String messageResult;
    private String stringResult;

    public TarefaService(Activity activity, boolean loop, ITarefaExecutar tarefaExecutar) {
        this.activity = activity;
        this.loop = loop;
        this.tarefaExecutar = tarefaExecutar;
    }

    //nao faz parte dos icones em generics
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }



    @Override
    protected Integer doInBackground(Void... voids) {

        do {
            Call call = tarefaExecutar.getCall();
            try {
                Response response = call.execute();

                if (response.isSuccessful()) {
                    responseResult = response;
                    publishProgress(1);
                } else {
                    responseResult = response;
                    //onPostExecute(2);
                }




            } catch (Exception e) {
                messageResult = e.getMessage();
                //onPostExecute(3);
            }

            if(loop) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    System.out.println("FOI BRUTALMENTE INTERROMPIDO");
                }
            }

        }while(loop);
        return 4;

    }

    //executado sempre que chamado publicProgress
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        switch (values[0]) {
            case 1 :
                tarefaExecutar.retornoComSucesso(responseResult);
                break;
            case 2 :
                tarefaExecutar.retornoSemSucesso(responseResult);
                break;
            case 3 :
                tarefaExecutar.retornoComErro(messageResult);
                break;
            default:
                break;
        }

    }

    //executado uma unica vez no final do doInBackGround
    @Override
    protected void onPostExecute(Integer tipo) {


    }

    public void stop() {
        this.loop = false;
        this.cancel(true);
    }

    public boolean isRunning() {
        return loop;
    }


}
