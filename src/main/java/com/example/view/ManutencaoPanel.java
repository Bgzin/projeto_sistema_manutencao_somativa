package com.example.view;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import com.example.controllers.ManutencaoController;
import com.example.models.Manutencao;

public class ManutencaoPanel extends JPanel {
    // Atributos
    private ManutencaoController manutencaoController;
    private JTable manutencaoTable;
    private DefaultTableModel tableModel;
    private JButton btnSalvarAlteracoes;
    private JButton btnCadastrarManutencao;

    // Construtor
    public ManutencaoPanel() {
        super(new BorderLayout());
        manutencaoController = new ManutencaoController();

        tableModel = new DefaultTableModel(new Object[]{
            "ID", "Máquina ID", "Data", "Tipo", "Peças Trocadas", "Tempo de Parada", "Técnico ID", "Observações"
        }, 0);
        manutencaoTable = new JTable(tableModel);

        // Preencher a tabela com os dados
        List<Manutencao> manutencoes = manutencaoController.readManutencoes();
        for (Manutencao manutencao : manutencoes) {
            tableModel.addRow(new Object[]{
                manutencao.getId(),
                manutencao.getMaquinaID(),
                manutencao.getData(),
                manutencao.getTipo(),
                manutencao.getPecasTrocadas(),
                manutencao.getTempoDeParada(),
                manutencao.getTecnicoID(),
                manutencao.getObservacoes()
            });
        }
        JScrollPane scrollPane = new JScrollPane(manutencaoTable);
        this.add(scrollPane, BorderLayout.CENTER);

        // Adicionar os botões
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarManutencao = new JButton("Cadastrar Manutenção");
        btnSalvarAlteracoes = new JButton("Salvar Alterações");
        painelInferior.add(btnCadastrarManutencao);
        painelInferior.add(btnSalvarAlteracoes);
        this.add(painelInferior, BorderLayout.SOUTH);

        // Criar as ActionListener para os botões
        // TODO: Adicionar ActionListeners para os botões
    }
}
