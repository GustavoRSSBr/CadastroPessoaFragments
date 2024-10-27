package br.com.gustavorssbr.exemplofragments.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.gustavorssbr.exemplofragments.model.PessoaFisica;
import br.com.gustavorssbr.exemplofragments.model.PessoaJuridica;

public class OperacaoPF implements IOperacao<PessoaFisica>{
    private List<PessoaFisica> lista;

    public OperacaoPF(){
        this.lista = new ArrayList<>();
    }
    @Override
    public void cadastrar(PessoaFisica pessoaFisica) {

        lista.add(pessoaFisica);

    }

    @Override
    public List<PessoaFisica> listar() {
        return this.lista;
    }
}
