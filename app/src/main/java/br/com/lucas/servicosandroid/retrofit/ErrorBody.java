package br.com.lucas.servicosandroid.retrofit;

import java.io.IOException;
import java.lang.annotation.Annotation;

import br.com.lucas.servicosandroid.model.Erro;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

public class ErrorBody<T> {

    public T getError(Response response) {
        Converter<ResponseBody, Erro> converter = new RetrofitInit().getRetrofit().responseBodyConverter(Erro.class, new Annotation[0]);
        try {
            return (T) converter.convert(response.errorBody());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
