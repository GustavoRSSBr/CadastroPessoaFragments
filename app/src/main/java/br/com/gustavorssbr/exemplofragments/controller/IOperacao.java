package br.com.gustavorssbr.exemplofragments.controller;

import java.util.List;

public interface IOperacao<T> {
   void cadastrar(T t);

   List<T> listar();

}
