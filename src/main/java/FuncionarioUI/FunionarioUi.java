package FuncionarioUI;

import funcionario.Funcionario;
import funcionarioDB.FuncionarioDAO;
import funcionarioDB.FuncionarioMapDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class FunionarioUi extends JFrame {
    private JTextField idText;
    private JTextField nomeText;
    private JButton inserirButton;
    private JButton alterarButton;
    private JButton consultarButton;
    private JButton deletarButton;

    private JTable funcionariosTable;

    private JPanel MainPanel;
    private JButton listarTodosButton;

    public FunionarioUi() {
        FuncionarioDAO dao = new FuncionarioMapDAO();

        setContentPane(MainPanel);
        setTitle("CRUD DE FUNCIONARIO");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 480);
        setLocationRelativeTo(null);
        setVisible(true);

       DefaultTableModel tableModel = new DefaultTableModel();
       tableModel.addColumn("Id");
       tableModel.addColumn("Nome");

       /*
       tableModel.addRow(new Object[]{1, "1"});
       tableModel.addRow(new Object[]{2, "2"});
       tableModel.addRow(new Object[]{3, "3"});

       funcionariosTable.setModel(tableModel);

        */

        inserirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dao.inserir(new Funcionario(Integer.parseInt(idText.getText()), nomeText.getText()));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(FunionarioUi.this, ex.getMessage());
                }
            }
        });
        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tableModel.setRowCount(0);
                    Funcionario f = dao.consultar(Integer.parseInt(idText.getText()));
                    tableModel.addRow(new Object[]{f.getId(), f.getNome()});
                    funcionariosTable.setModel(tableModel);
                    /*
                    JOptionPane.showMessageDialog(FunionarioUi.this,
                            dao.consultar(Integer.parseInt(idText.getText())).getNome()); */
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(FunionarioUi.this, ex.getMessage());
                }
            }
        });
        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dao.alterar(new Funcionario(Integer.parseInt(idText.getText()), nomeText.getText()));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(FunionarioUi.this, ex.getMessage());
                }
            }
        });
        deletarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dao.deletar(Integer.parseInt(idText.getText()));
            }
        });

        listarTodosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.setRowCount(0);

                for (Funcionario f : dao.listarTodos()) {
                    try {
                        tableModel.addRow(new Object[]{f.getId(), f.getNome()});
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }

                funcionariosTable.setModel(tableModel);
            }
        });
    }

    public static void main(String[] args) {
        new FunionarioUi();
    }
}
