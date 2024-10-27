package br.com.gustavorssbr.exemplofragments.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.gustavorssbr.exemplofragments.model.PessoaFisica;
import br.com.gustavorssbr.exemplofragments.model.PessoaJuridica;

public class OperacaoPJ implements IOperacao<PessoaJuridica>{

    private List<PessoaJuridica> lista;

    public OperacaoPJ(){
        this.lista = new ArrayList<>();
    }

    @Override
    public void cadastrar(PessoaJuridica pessoaJuridica) {

    }

    @Override
    public List<PessoaJuridica> listar() {
        return this.lista;
    }
}
