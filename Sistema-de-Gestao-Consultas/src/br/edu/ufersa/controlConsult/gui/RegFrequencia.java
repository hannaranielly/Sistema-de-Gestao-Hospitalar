/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.gui;

import br.edu.ufersa.controlConsult.model.Frequencia;
import br.edu.ufersa.controlConsult.model.Medico;
import br.edu.ufersa.controlConsult.model.Pessoa;
import br.edu.ufersa.controlConsult.model.Usuario;
import br.edu.ufersa.controlConsult.util.debug.DEBUG_USUARIO;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;
import javax.swing.JOptionPane;

/**
 *
 * @author leone
 */
public class RegFrequencia extends javax.swing.JFrame {

    /**
     * Creates new form AddHorario
     */
    private Medico med;
    private Usuario usuarioAutenticado;

    private void setUsuarioAutenticado(Usuario usuarioAutenticado) {
        this.usuarioAutenticado = usuarioAutenticado;
    }

    public RegFrequencia(Usuario usuarioAutenticado) {
        initComponents();
        this.setUsuarioAutenticado(usuarioAutenticado);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    
    
    private static final int CPF_LABEL_WIDTH = 14;
    private static final int CPF_FIELD_COLUMNS = 20;
    private static final int BUSCAR_BUTTON_MARGIN = 10;
    private static final int NOME_LABEL_WIDTH = 14;
    private static final int NOME_FIELD_COLUMNS = 25;
    private static final int LAST_ENTRADA_LABEL_WIDTH = 14;
    private static final int LAST_ENTRADA_FIELD_COLUMNS = 15;
    private static final int LAST_SAIDA_LABEL_WIDTH = 14;
    private static final int LAST_SAIDA_FIELD_COLUMNS = 15;

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        cpf_jLabel = new javax.swing.JLabel();
        cpf_formattedField = new javax.swing.JFormattedTextField();
        buscar_jButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        nome_jLabel = new javax.swing.JLabel();
        nome_jTextField = new javax.swing.JTextField();
        lastEntrada_jLabel = new javax.swing.JLabel();
        lastEntrada_jTextField = new javax.swing.JTextField();
        lastSaida_jLabel = new javax.swing.JLabel();
        lastSaida_jTextField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        mostrarFrequencia_jButton = new javax.swing.JButton();
        entrada_jButton = new javax.swing.JButton();
        saida_jButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar Frequência");
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        setupPanel2();
        setupPanel3();
        setupPanel1();

        pack();
    }

    private void setupPanel1() {
        jPanel2.setLayout(new java.awt.GridBagLayout());

        cpf_jLabel.setFont(new java.awt.Font("Times New Roman", 1, 14));
        cpf_jLabel.setText("CPF:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, CPF_LABEL_WIDTH, 0, CPF_LABEL_WIDTH);
        jPanel2.add(cpf_jLabel, gridBagConstraints);

        cpf_formattedField.setColumns(CPF_FIELD_COLUMNS);
        try {
            cpf_formattedField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cpf_formattedField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpf_formattedFieldActionPerformed(evt);
            }
        });
        cpf_formattedField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cpf_formattedFieldKeyTyped(evt);
            }
        });
        jPanel2.add(cpf_formattedField, new java.awt.GridBagConstraints());

        buscar_jButton.setText("Selecionar");
        buscar_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_jButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, BUSCAR_BUTTON_MARGIN, 0, BUSCAR_BUTTON_MARGIN);
        jPanel2.add(buscar_jButton, gridBagConstraints);

        getContentPane().add(jPanel2);
    }

    private void setupPanel2() {
        jPanel3.setLayout(new java.awt.GridBagLayout());

        nome_jLabel.setFont(new java.awt.Font("Times New Roman", 1, 14));
        nome_jLabel.setText("Nome:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, NOME_LABEL_WIDTH, 0, NOME_LABEL_WIDTH);
        jPanel3.add(nome_jLabel, gridBagConstraints);

        nome_jTextField.setEditable(false);
        nome_jTextField.setColumns(NOME_FIELD_COLUMNS);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel3.add(nome_jTextField, gridBagConstraints);

        lastEntrada_jLabel.setFont(new java.awt.Font("Times New Roman", 1, 14));
        lastEntrada_jLabel.setText("Última entrada: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, LAST_ENTRADA_LABEL_WIDTH, 0, LAST_ENTRADA_LABEL_WIDTH);
        jPanel3.add(lastEntrada_jLabel, gridBagConstraints);

        lastEntrada_jTextField.setEditable(false);
        lastEntrada_jTextField.setColumns(LAST_ENTRADA_FIELD_COLUMNS);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel3.add(lastEntrada_jTextField, gridBagConstraints);

        lastSaida_jLabel.setFont(new java.awt.Font("Times New Roman", 1, 14));
        lastSaida_jLabel.setText("Última saída: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, LAST_SAIDA_LABEL_WIDTH, 0, LAST_SAIDA_LABEL_WIDTH);
        jPanel3.add(lastSaida_jLabel, gridBagConstraints);

        lastSaida_jTextField.setEditable(false);
        lastSaida_jTextField.setColumns(LAST_SAIDA_FIELD_COLUMNS);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel3.add(lastSaida_jTextField, gridBagConstraints);

        getContentPane().add(jPanel3);
    }

    private void setupPanel3() {
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        mostrarFrequencia_jButton.setText("Mostrar Frequência");
        mostrarFrequencia_jButton.setEnabled(false);
        mostrarFrequencia_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarFrequencia_jButtonActionPerformed(evt);
            }
        });
        jPanel1.add(mostrarFrequencia_jButton);

        entrada_jButton.setText("Registrar Entrada");
        entrada_jButton.setEnabled(false);
        entrada_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrada_jButtonActionPerformed(evt);
            }
        });
        jPanel1.add(entrada_jButton);

        saida_jButton.setText("Registrar Saída");
        saida_jButton.setEnabled(false);
        saida_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saida_jButtonActionPerformed(evt);
            }
        });
        jPanel1.add(saida_jButton);

        getContentPane().add(jPanel1);
    }

    private void buscar_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_jButtonActionPerformed
        buscarPessoa();
    }//GEN-LAST:event_buscar_jButtonActionPerformed

    private void cpf_formattedFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpf_formattedFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpf_formattedFieldActionPerformed

    private void saida_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saida_jButtonActionPerformed
        registrarSaida();
        atualizar();
    }//GEN-LAST:event_saida_jButtonActionPerformed

    private void mostrarFrequencia_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarFrequencia_jButtonActionPerformed
        ListarFrequencia lf = new ListarFrequencia(med);
        lf.setVisible(true);
        lf.setLocationRelativeTo(null);
    }//GEN-LAST:event_mostrarFrequencia_jButtonActionPerformed

    private void cpf_formattedFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpf_formattedFieldKeyTyped
        if (evt.getKeyChar() == '\n') {
            buscar_jButton.doClick();
        }
    }//GEN-LAST:event_cpf_formattedFieldKeyTyped

    private void entrada_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrada_jButtonActionPerformed
        registrarEntrada();
        atualizar();
    }//GEN-LAST:event_entrada_jButtonActionPerformed

    private void buscarPessoa() {
        try {
            med = Pessoa.findByCPF(cpf_formattedField.getText()).getMedico();
            nome_jTextField.setText(med.getPessoa().getNome());
            atualizar();
        } catch (NoResultException ex) {
            Logger.getLogger(RegFrequencia.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Médico não encontrado");
        }
    }

    private void registrarEntrada() {
        Frequencia frequencia = new Frequencia(med, usuarioAutenticado);
        if (med == null) {
            JOptionPane.showMessageDialog(null, "Informe o CPF do médico!");
            return;
        } else {
            Date in_now = new Date(System.currentTimeMillis());
            if (JOptionPane.showConfirmDialog(this,
                    "Registrar entrada em: " + in_now,
                    "Confirmação de Entrada",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                frequencia.setEntrada(in_now);
                try {
                    frequencia.create();
                    limpaFormulario();
                    atualizar();
                } catch (NoResultException ex) {
                    alerta_comportaInesperado();
                }
                JOptionPane.showMessageDialog(this, "Entrada Registrada");
            }
        }
    }

    private void registrarSaida() {
        if (med == null) {
            JOptionPane.showMessageDialog(this, "Informe o CPF do médico!");
            return;
        } else {
            Date out_now = new Date(System.currentTimeMillis());
            if (JOptionPane.showConfirmDialog(this,
                    "Registrar saída em: " + out_now,
                    "Confirmação de Saída",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                try {
                    Frequencia frequencia = med.getListFrequencia().last();
                    frequencia.setSaida(out_now);
                    med.update();
                    limpaFormulario();
                    JOptionPane.showMessageDialog(this, "Saida Registrada");
                } catch (Exception ex) {
                    alerta_comportaInesperado();
                }
            }
        }
    }

    private void alerta_comportaInesperado() {
        JOptionPane.showMessageDialog(this, "Comportamento inesperado.");
    }

    private void atualizar() {
        if (med != null) {
            med.read();
            mostrarFrequencia_jButton.setEnabled(true);
            if (med.getListFrequencia() != null && !med.getListFrequencia().isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date lastEntrada = med.getListFrequencia().last().getEntrada();
                Date lastSaida = med.getListFrequencia().last().getSaida();
                lastEntrada_jTextField.setText(sdf.format(lastEntrada));
                if (lastSaida == null) {
                    entrada_jButton.setEnabled(false);
                    saida_jButton.setEnabled(true);
                } else {
                    lastSaida_jTextField.setText(sdf.format(lastSaida));
                    entrada_jButton.setEnabled(true);
                    saida_jButton.setEnabled(false);
                }

            } else {
                mostrarFrequencia_jButton.setEnabled(true);
                entrada_jButton.setEnabled(true);
                saida_jButton.setEnabled(false);
            }
        } else {
            System.out.println("teste");
            mostrarFrequencia_jButton.setEnabled(false);
            entrada_jButton.setEnabled(false);
            saida_jButton.setEnabled(false);
        }
    }

    private void limpaFormulario() {
        med = null;
        nome_jTextField.setText("");
        cpf_formattedField.setText("");
        lastEntrada_jTextField.setText("");
        lastSaida_jTextField.setText("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegFrequencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegFrequencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegFrequencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegFrequencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegFrequencia(DEBUG_USUARIO.getUsuarioAleatorio()).setVisible(true);
            }
        }
        );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar_jButton;
    private javax.swing.JFormattedTextField cpf_formattedField;
    private javax.swing.JLabel cpf_jLabel;
    private javax.swing.JButton entrada_jButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lastEntrada_jLabel;
    private javax.swing.JTextField lastEntrada_jTextField;
    private javax.swing.JLabel lastSaida_jLabel;
    private javax.swing.JTextField lastSaida_jTextField;
    private javax.swing.JButton mostrarFrequencia_jButton;
    private javax.swing.JLabel nome_jLabel;
    private javax.swing.JTextField nome_jTextField;
    private javax.swing.JButton saida_jButton;
    // End of variables declaration//GEN-END:variables
}
