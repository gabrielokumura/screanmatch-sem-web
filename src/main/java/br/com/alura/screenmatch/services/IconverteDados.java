package br.com.alura.screenmatch.services;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IconverteDados {
    <T> T obterDados(String json, Class<T> classe) throws JsonProcessingException;
}
