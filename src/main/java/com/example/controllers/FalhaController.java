package com.example.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.api.FalhaAPI;
import com.example.models.Falha;

public class FalhaController {
    private List<Falha> falhas;

    public FalhaController() {
        this.falhas = new ArrayList<>();
    }

    // Método - CRUD
    public void adicionarFalha(Falha falha) {
        this.falhas.add(falha);
    }

    // Método read
    public List<Falha> readFalhas() {
        falhas = FalhaAPI.getFalhas(); // Supondo que exista uma API para obter falhas
        return falhas;
    }

    // Método update
    public void updateFalha(int posicao, Falha falha) {
        if (posicao >= 0 && posicao < falhas.size()) {
            falhas.set(posicao, falha);
        }
    }

    // Método delete
    public void deletarFalha(int posicao) {
        if (posicao >= 0 && posicao < falhas.size()) {
            falhas.remove(posicao);
        }
    }

    // Método para buscar uma falha por ID
    public Falha buscarFalhaPorId(String id) {
        return falhas.stream()
                .filter(falha -> falha.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Método para listar falhas por prioridade
    public List<Falha> listarFalhasPorPrioridade(String prioridade) {
        return falhas.stream()
                .filter(falha -> falha.getPrioridade().equalsIgnoreCase(prioridade))
                .collect(Collectors.toList());
    }

    // Método para verificar se uma falha existe
    public boolean falhaExiste(String id) {
        return falhas.stream().anyMatch(falha -> falha.getId().equals(id));
    }
}
