package com.example.view;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import com.example.controllers.FalhaController;
import com.example.models.Falha;

public class FalhasPanel extends JPanel {
    // Atributos
    private FalhaController falhaController;
    private JTable falhasTable;
    private DefaultTableModel tableModel;
    private JButton btnSalvarAlteracoes;
    private JButton btnCadastrarFalha;

    // Construtor
    public FalhasPanel() {
        super(new BorderLayout());
        falhaController = new FalhaController();

        tableModel = new DefaultTableModel(new Object[]{
            "ID", "Máquina ID", "Data", "Problema", "Prioridade", "Operador"
        }, 0);
        falhasTable = new JTable(tableModel);

        // Preencher a tabela com os dados
        List<Falha> falhas = falhaController.readFalhas();
        for (Falha falha : falhas) {
            tableModel.addRow(new Object[]{
                falha.getId(),
                falha.getMaquinaID(),
                falha.getData(),
                falha.getProblema(),
                falha.getPrioridade(),
                falha.getOperador()
            });
        }
        JScrollPane scrollPane = new JScrollPane(falhasTable);
        this.add(scrollPane, BorderLayout.CENTER);

        // Adicionar os botões
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarFalha = new JButton("Cadastrar Falha");
        btnSalvarAlteracoes = new JButton("Salvar Alterações");
        painelInferior.add(btnCadastrarFalha);
        painelInferior.add(btnSalvarAlteracoes);
        this.add(painelInferior, BorderLayout.SOUTH);

        // Criar as ActionListener para os botões
        // TODO: Adicionar ActionListeners para os botões
    }
}
