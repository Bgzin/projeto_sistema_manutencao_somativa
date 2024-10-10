package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.api.TecnicoAPI;
import com.example.models.Tecnico;

public class TecnicoController {
    private List<Tecnico> tecnicos;

    public TecnicoController() {
        this.tecnicos = new ArrayList<>();
    }

    // Método - CRUD
    public void adicionarTecnico(Tecnico tecnico) {
        this.tecnicos.add(tecnico);
    }

    // Método read
    public List<Tecnico> readTecnicos() {
        tecnicos = TecnicoAPI.getTecnicos(); // Usa a API existente para obter técnicos
        return tecnicos;
    }

    // Método update
    public void updateTecnico(int posicao, Tecnico tecnico) {
        if (posicao >= 0 && posicao < tecnicos.size()) {
            tecnicos.set(posicao, tecnico);
        }
    }

    // Método delete
    public void deletarTecnico(int posicao) {
        if (posicao >= 0 && posicao < tecnicos.size()) {
            tecnicos.remove(posicao);
        }
    }

    // Método para buscar um técnico por ID
    public Tecnico buscarTecnicoPorId(String id) {
        return tecnicos.stream()
                .filter(tecnico -> tecnico.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Método para verificar se um técnico existe
    public boolean tecnicoExiste(String id) {
        return tecnicos.stream().anyMatch(tecnico -> tecnico.getId().equals(id));
    }
}
