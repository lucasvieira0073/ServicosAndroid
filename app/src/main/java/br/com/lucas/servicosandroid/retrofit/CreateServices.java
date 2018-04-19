package br.com.lucas.servicosandroid.retrofit;

import br.com.lucas.servicosandroid.service.AlunoService;
import br.com.lucas.servicosandroid.service.ProdutoService;

class CreateServices {

    public AlunoService getAlunoService() {
        return RetrofitInicializador.getRetrofit().create(AlunoService.class);
    }

    public ProdutoService getProdutoService() {
        return RetrofitInicializador.getRetrofit().create(ProdutoService.class);
    }

}
