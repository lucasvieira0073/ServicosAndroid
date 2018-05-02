package br.com.lucas.servicosandroid;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Inicializacao {

    public static ExecutorService threadPool;

    public Inicializacao() {
        threadPool = Executors.newCachedThreadPool();
    }
}
