package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.api.ManutencaoAPI;
import com.example.models.Manutencao;

public class ManutencaoController {
    private List<Manutencao> manutencoes;

    public ManutencaoController() {
        this.manutencoes = new ArrayList<>();
    }

    // Método - CRUD
    public void adicionarManutencao(Manutencao manutencao) {
        this.manutencoes.add(manutencao);
    }

    // Método read
    public List<Manutencao> readManutencoes() {
        manutencoes = ManutencaoAPI.getManutencoes(); // Chama o método correto da API
        return manutencoes;
    }

    // Métodos update e delete permanecem os mesmos
    public void updateManutencao(int posicao, Manutencao manutencao) {
        if (posicao >= 0 && posicao < manutencoes.size()) {
            manutencoes.set(posicao, manutencao);
        }
    }

    public void deletarManutencao(int posicao) {
        if (posicao >= 0 && posicao < manutencoes.size()) {
            manutencoes.remove(posicao);
        }
    }

    // Métodos para buscar e verificar a existência permanecem os mesmos
    public Manutencao buscarManutencaoPorId(String id) {
        return manutencoes.stream()
                .filter(manutencao -> manutencao.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public boolean manutencaoExiste(String id) {
        return manutencoes.stream().anyMatch(manutencao -> manutencao.getId().equals(id));
    }
}
