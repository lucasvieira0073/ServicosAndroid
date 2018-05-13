package br.com.lucas.servicosandroid.retrofit.thread;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
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
    AlertDialog alertDialog;

    private Response responseResult;
    private String messageResult;
    private String stringResult;

    public TarefaService(Activity activity, boolean loop, ITarefaExecutar tarefaExecutar) {
        this.activity = activity;
        this.loop = loop;
        this.tarefaExecutar = tarefaExecutar;
    }

    public void criaProgressBar() {
        //ProgressBar progressBar = new ProgressBar(activity);

    }

    //nao faz parte dos icones em generics
    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Teste");
        builder.setMessage("Mensagem teste");
        builder.setPositiveButton("ok", null);
        builder.setCancelable(false);

        alertDialog = builder.create();
    }


    //teste com tratamento de falta de conexao
    //teste de progressbar dinamica



    @Override
    protected Integer doInBackground(Void... voids) {

        if(this.loop) {
            executarTarefaLoop();
        }else{
            executarTarefa();
        }



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
            case 4 :
                exibeProgressDialog();
                break;
            default:
                break;
        }

    }

    //executado uma unica vez no final do doInBackGround
    @Override
    protected void onPostExecute(Integer tipo) {


    }

    public void exibeProgressDialog() {
        alertDialog.show();
    }

    public void stop() {
        this.loop = false;
        this.cancel(true);
    }

    public boolean isRunning() {
        return loop;
    }

    public void executarTarefa() {

        boolean conexao = true;

        Call call = tarefaExecutar.getCall();
        try {
            Response response = call.execute();

            if (response.isSuccessful()) {
                responseResult = response;
                publishProgress(4);
            } else {
                responseResult = response;
                publishProgress(2);
            }

        } catch (Exception e) {
            conexao = false;
        }


        if(!conexao) {
            publishProgress(5);
            System.out.println("======= começando a executar nova tentativa");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executarTarefa();
        }

    }


    public void executarTarefaLoop() {
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
    }


}
