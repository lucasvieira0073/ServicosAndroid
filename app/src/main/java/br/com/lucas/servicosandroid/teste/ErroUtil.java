package br.com.lucas.servicosandroid.teste;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class ErroUtil {

    public static List<Erro> convert(Response response) {
        List<Erro> erros = new ArrayList<>();
        JsonParser parser = new JsonParser();
        JsonElement mJson = null;

        try {

            mJson = parser.parse(response.errorBody().string());
            Gson gson = new Gson();

            Erro[] errosArray = gson.fromJson(mJson, Erro[].class);

            for(int i = 0; i < errosArray.length; i++) {
                erros.add(errosArray[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return erros;
    }

}
