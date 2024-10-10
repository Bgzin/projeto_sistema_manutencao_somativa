package com.example.api;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.models.Manutencao;

public class ManutencaoAPI {
    public static List<Manutencao> getManutencoes() {
        String json = ApiConnection.getData("historicoManutencao");
        List<Manutencao> manutencoes = new ArrayList<>();

        if (json != null) {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Manutencao manutencao = new Manutencao(
                    jsonObject.getString("id"),
                    jsonObject.getLong("maquinaId"),
                    LocalDate.parse(jsonObject.getString("data")),
                    jsonObject.getString("tipo"),
                    jsonObject.getString("pecasTrocadas"),
                    jsonObject.getLong("tempoDeParada"),
                    jsonObject.getString("tecnicoId"),  // Correção aqui
                    jsonObject.getString("observacoes")
                );
                manutencoes.add(manutencao);
            }
        }
        return manutencoes;
    }

    public static List<Manutencao> getManutencao() {
        // TODO: Implementar se necessário
        throw new UnsupportedOperationException("Unimplemented method 'getManutencao'");
    }
}
