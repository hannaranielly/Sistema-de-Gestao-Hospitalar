/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.gui;

import br.edu.ufersa.controlConsult.model.Especialidade;
import br.edu.ufersa.controlConsult.model.Medico;
import br.edu.ufersa.controlConsult.model.Paciente;
import br.edu.ufersa.controlConsult.model.Pessoa;
import br.edu.ufersa.controlConsult.model.jpaDAO.exceptions.PreexistingEntityException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 * @author Juan Carlos
 */
public class FormPessoa extends javax.swing.JFrame {

    /**
     * Este método determina qual contexto a janela irá apresentar ao usuário.
     *
     * @param tipoDeContexto O tipo de contexto que o sistema irá definir.
     *
     * @see TipoContextoEnum
     */
    private void setTipoContexto(TipoContextoEnum tipoDeContexto) {
        this.tipoDeContexto = tipoDeContexto;
    }

    private void setTipoPessoa(TipoPessoaEnum tipoPessoa) {
        this.tipoDePessoa = tipoPessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    /**
     * De acordo com o contexto setado em
     * {@link #setTipoContexto(TipoContextoEnum)}, ele irá alterar o layout da
     * janela para o contexto salvo em {@link #tipoDeContexto}.
     *
     */
    public void atualizarContextoJanela() {
        // Ajustes na interface de acordo com cada contexto.
        switch (tipoDeContexto) {
            case CADASTRAR:
                busca_jPanel.setVisible(false);
                delete_jToggleButton.setVisible(false);
                submit_jButton.setText("Cadastrar");
                break;
            case ATUALIZAR:
                submit_jButton.setText("Atualizar");
                delete_jToggleButton.setVisible(true);
                busca_jPanel.setVisible(true);
                if (pessoa != null) {
                    pessoa_jPanel.setVisible(true);
                    switch (tipoDePessoa) {
                        case MEDICO:
                            medico_jPanel.setVisible(true);
                            paciente_jPanel.setVisible(false);
                            break;
                        case PACIENTE:
                            medico_jPanel.setVisible(false);
                            paciente_jPanel.setVisible(true);
                            break;
                        default:
                            medico_jPanel.setVisible(true);
                            paciente_jPanel.setVisible(true);
                            break;
                    }
                } else {
                    pessoa_jPanel.setVisible(false);
                    medico_jPanel.setVisible(false);
                    paciente_jPanel.setVisible(false);
                    botoes_jPanel.setVisible(false);
                }
                break;
            default:
        }
        switch (tipoDePessoa) {
            case MEDICO:
                paciente_jPanel.setVisible(false);
                loadEspecialidades();
                break;
            case PACIENTE:
                medico_jPanel.setVisible(false);
                break;
        }
    }

    /**
     * Preenche todos os formulários baseado nas informações extraídas da pessoa
     * armazenada em {@link #pessoa}.
     */
    public void preencherFormularioPessoa() {
        nome_textField.setText(pessoa.getNome());
        cpf_textField.setText(pessoa.getCpf());
        rg_textField.setText(pessoa.getRg());
        email_textField.setText(pessoa.getEmail());
        if (pessoa.getSexo() == 'm') {
            masculino_radioButton.setSelected(true);
        } else {
            feminino_radioButton.setSelected(true);
        }
        nascimento_DateField.setDate(pessoa.getDataDeNascimento());
        telefone_formattedField.setText(pessoa.getTelefone());
        logradouro_textField.setText(pessoa.getLogradouro());
        int numCasa = 0; //TODO
        bairroField.setText(pessoa.getBairro());
        cidadeField.setText(pessoa.getCidade());
        estado_textField.setText(pessoa.getEstado());
        cep_formattedField.setText(pessoa.getCep());
        switch (tipoDePessoa) {
            case MEDICO:
                preencheFormularioMedico(pessoa);
                break;
            case PACIENTE:
                preencheFormularioPaciente(pessoa);
                break;
        }

    }

    private Map<String, Especialidade> especialidesMap = new HashMap<>();

    private void preencheFormularioMedico(Pessoa pessoa) {
        crm_jTextField.setText(pessoa.getMedico().getCrm());
        chField.setText(String.valueOf(pessoa.getMedico().getCargaHoraria()));
        loadEspecialidades();
        espField_jComboBox.getModel().setSelectedItem(pessoa.getMedico().getEspecialidade().getNome());
    }

    private void preencheFormularioPaciente(Pessoa pessoa) {
        sus_formattedtField.setText(pessoa.getPaciente().getNum_sus());
    }

    /**
     * Limpa todos os formulários da janela.
     *
     * @since v0.2
     */
    private void limpaFormulario() {
        nome_textField.setText("");
        cpf_textField.setText("");
        rg_textField.setText("");
        email_textField.setText("");
        masculino_radioButton.setSelected(false);
        feminino_radioButton.setSelected(false);
        nascimento_DateField.setDate(new Date());
        telefone_formattedField.setText("");
        logradouro_textField.setText("");
        int numCasa = 0; //TODO
        bairroField.setText("");
        cidadeField.setText("");
        estado_textField.setText("");
        cep_formattedField.setText("");
        sus_formattedtField.setText("");
        chField.setText("");
        crm_jTextField.setText("");
    }

    private Especialidade extrairEspecialidade() { //TODO
        Especialidade especialidade = especialidesMap.get(espField_jComboBox.getModel().getSelectedItem());
        return especialidade;
    }

    private void loadEspecialidades() {
        List<Especialidade> bd_especialidades = Especialidade.findAll();
        if (bd_especialidades.isEmpty()) { // Default Especialidades
            bd_especialidades = Arrays.asList(
                    new Especialidade("Clínico Geral"),
                    new Especialidade("Pediatra")
            );
        }
        bd_especialidades.forEach(especialidade -> especialidesMap.put(especialidade.getNome(), especialidade));
        Set<String> keys = especialidesMap.keySet();
        String[] keys_string = keys.toArray(new String[keys.size()]);
        Arrays.sort(keys_string);
        ComboBoxModel<String> model = new DefaultComboBoxModel<String>(keys_string);
        espField_jComboBox.setModel(model);
    }

    public static enum TipoPessoaEnum {
        AMBOS, PACIENTE, MEDICO;
    }

    public static enum UF_Enum {
        AC("Acre"), AL("Alagoas"), AP("Amapá"), AM("Amazonas"), BA("Bahia"), CE("Ceará"), DF("Distrito Federal"), ES(
                "Espírito Santo"), GO("Goiás"), MA("Maranhão"), MT("Mato Grosso"), MS("Mato Grosso do Sul"), MG(
                "Minas Gerais"), PA("Pará"), PB("Paraíba"), PR("Paraná"), PE("Pernambuco"), PI("Piauí"), RJ(
                "Rio de Janeiro"), RN("Rio Grande do Norte"), RS("Rio Grande do Sul"), RO(
                "Rondônia"), RR("Roraima"), SC(
                "Santa Catarina"), SP("São Paulo"), SE("Sergipe"), TO("Tocantins");
        private String name;

        private UF_Enum(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }

    public static enum TipoContextoEnum {
        /**
         * Inserir pessoa no sistema
         */
        CADASTRAR,
        /**
         * Atualizar pessoa no sistema.
         */
        ATUALIZAR;
    }

    /**
     * O tipo de pessoa que o formulário da janela irá processar.
     */
    private TipoPessoaEnum tipoDePessoa;
    /**
     * O tipo de contexto que a janela irá apresentar.
     *
     * @see #setTipoContexto(FormPessoa.TipoContextoEnum)
     */
    private TipoContextoEnum tipoDeContexto;

    private Pessoa pessoa; // Pessoa para alteração. Valida somente se o contexto for para alteração.

    /**
     * Creates new form FormPessoa
     */
    public FormPessoa(TipoContextoEnum tipoContexto, TipoPessoaEnum tipoPessoa) {
        this.setTipoContexto(tipoContexto);
        this.setTipoPessoa(tipoPessoa);
        initComponents();
        atualizarContextoJanela();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        sexo_buttonGroup = new javax.swing.ButtonGroup();
        formulario_jPanel = new javax.swing.JPanel();
        busca_jPanel = new javax.swing.JPanel();
        BuscaCpf_textField = new javax.swing.JFormattedTextField();
        search_jButton = new javax.swing.JButton();
        pessoa_jPanel = new javax.swing.JPanel();
        nome_jLabel = new javax.swing.JLabel();
        nome_textField = new javax.swing.JTextField();
        rg_textField = new javax.swing.JTextField();
        logradouro_jLabel = new javax.swing.JLabel();
        logradouro_textField = new javax.swing.JTextField();
        cep_jLabel = new javax.swing.JLabel();
        cep_formattedField = new javax.swing.JFormattedTextField();
        nascimento_jLabel = new javax.swing.JLabel();
        nascimento_DateField = new com.toedter.calendar.JDateChooser();
        rg_jLabel = new javax.swing.JLabel();
        cpf_jLabel = new javax.swing.JLabel();
        cpf_textField = new javax.swing.JFormattedTextField();
        telefone_formattedField = new javax.swing.JFormattedTextField();
        bairro_jLabel = new javax.swing.JLabel();
        bairroField = new javax.swing.JTextField();
        cidade_jLabel = new javax.swing.JLabel();
        cidadeField = new javax.swing.JTextField();
        telefone_jLabel = new javax.swing.JLabel();
        masculino_radioButton = new javax.swing.JRadioButton();
        feminino_radioButton = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        email_jLabel = new javax.swing.JLabel();
        email_textField = new javax.swing.JTextField();
        estado_jLabel = new javax.swing.JLabel();
        estado_textField = new javax.swing.JTextField();
        medico_jPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        chField = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        espField_jComboBox = new javax.swing.JComboBox<>();
        crm_jLabel = new javax.swing.JLabel();
        crm_jTextField = new javax.swing.JTextField();
        paciente_jPanel = new javax.swing.JPanel();
        sus_jLabel = new javax.swing.JLabel();
        sus_formattedtField = new javax.swing.JFormattedTextField();
        botoes_jPanel = new javax.swing.JPanel();
        submit_jButton = new javax.swing.JButton();
        delete_jToggleButton = new javax.swing.JToggleButton();
        cancel_jButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        formulario_jPanel.setLayout(new javax.swing.BoxLayout(formulario_jPanel, javax.swing.BoxLayout.Y_AXIS));

        busca_jPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Busca"));
        busca_jPanel.setLayout(new java.awt.GridBagLayout());

        try {
            BuscaCpf_textField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        BuscaCpf_textField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscaCpf_textFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 57;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        busca_jPanel.add(BuscaCpf_textField, gridBagConstraints);

        search_jButton.setText("Buscar");
        search_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_jButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        busca_jPanel.add(search_jButton, gridBagConstraints);

        formulario_jPanel.add(busca_jPanel);

        pessoa_jPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Pessoa"));
        java.awt.GridBagLayout pessoa_jPanelLayout = new java.awt.GridBagLayout();
        pessoa_jPanelLayout.columnWidths = new int[] {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0};
        pessoa_jPanelLayout.rowHeights = new int[] {0, 1, 0, 1, 0, 1, 0, 1, 0};
        pessoa_jPanel.setLayout(pessoa_jPanelLayout);

        nome_jLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nome_jLabel.setText("Nome:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        pessoa_jPanel.add(nome_jLabel, gridBagConstraints);

        nome_textField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nome_textFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        pessoa_jPanel.add(nome_textField, gridBagConstraints);

        rg_textField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rg_textFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 112;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        pessoa_jPanel.add(rg_textField, gridBagConstraints);

        logradouro_jLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        logradouro_jLabel.setText("Logradouro: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        pessoa_jPanel.add(logradouro_jLabel, gridBagConstraints);

        logradouro_textField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logradouro_textFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        pessoa_jPanel.add(logradouro_textField, gridBagConstraints);

        cep_jLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cep_jLabel.setText("CEP:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        pessoa_jPanel.add(cep_jLabel, gridBagConstraints);

        try {
            cep_formattedField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cep_formattedField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cep_formattedFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 90;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        pessoa_jPanel.add(cep_formattedField, gridBagConstraints);

        nascimento_jLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nascimento_jLabel.setText("Nascimento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 16;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        pessoa_jPanel.add(nascimento_jLabel, gridBagConstraints);

        nascimento_DateField.setMinimumSize(new java.awt.Dimension(120, 20));
        nascimento_DateField.setPreferredSize(new java.awt.Dimension(120, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 18;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        pessoa_jPanel.add(nascimento_DateField, gridBagConstraints);

        rg_jLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rg_jLabel.setText("RG:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        pessoa_jPanel.add(rg_jLabel, gridBagConstraints);

        cpf_jLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cpf_jLabel.setText("CPF:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        pessoa_jPanel.add(cpf_jLabel, gridBagConstraints);

        try {
            cpf_textField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cpf_textField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpf_textFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        pessoa_jPanel.add(cpf_textField, gridBagConstraints);

        try {
            telefone_formattedField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        telefone_formattedField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefone_formattedFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        pessoa_jPanel.add(telefone_formattedField, gridBagConstraints);

        bairro_jLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bairro_jLabel.setText("Bairro:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        pessoa_jPanel.add(bairro_jLabel, gridBagConstraints);

        bairroField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bairroFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        pessoa_jPanel.add(bairroField, gridBagConstraints);

        cidade_jLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cidade_jLabel.setText("Cidade:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        pessoa_jPanel.add(cidade_jLabel, gridBagConstraints);

        cidadeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cidadeFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        pessoa_jPanel.add(cidadeField, gridBagConstraints);

        telefone_jLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        telefone_jLabel.setText("Telefone:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        pessoa_jPanel.add(telefone_jLabel, gridBagConstraints);

        sexo_buttonGroup.add(masculino_radioButton);
        masculino_radioButton.setSelected(true);
        masculino_radioButton.setText("Masculino");
        masculino_radioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masculino_radioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 16;
        gridBagConstraints.gridy = 0;
        pessoa_jPanel.add(masculino_radioButton, gridBagConstraints);

        sexo_buttonGroup.add(feminino_radioButton);
        feminino_radioButton.setText("Feminino");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 18;
        gridBagConstraints.gridy = 0;
        pessoa_jPanel.add(feminino_radioButton, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Sexo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        pessoa_jPanel.add(jLabel1, gridBagConstraints);

        email_jLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        email_jLabel.setText("E-mail:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        pessoa_jPanel.add(email_jLabel, gridBagConstraints);

        email_textField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                email_textFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        pessoa_jPanel.add(email_textField, gridBagConstraints);

        estado_jLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        estado_jLabel.setText("Estado:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        pessoa_jPanel.add(estado_jLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        pessoa_jPanel.add(estado_textField, gridBagConstraints);

        formulario_jPanel.add(pessoa_jPanel);

        medico_jPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Médico"));
        medico_jPanel.setLayout(new java.awt.GridBagLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Carga Horária:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        medico_jPanel.add(jLabel4, gridBagConstraints);

        try {
            chField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        chField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 75;
        medico_jPanel.add(chField, gridBagConstraints);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Especialidade:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        medico_jPanel.add(jLabel11, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        medico_jPanel.add(espField_jComboBox, gridBagConstraints);

        crm_jLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        crm_jLabel.setText("CRM:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        medico_jPanel.add(crm_jLabel, gridBagConstraints);

        crm_jTextField.setColumns(6);
        crm_jTextField.setMinimumSize(new java.awt.Dimension(90, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        medico_jPanel.add(crm_jTextField, gridBagConstraints);

        formulario_jPanel.add(medico_jPanel);

        paciente_jPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Paciente"));
        paciente_jPanel.setLayout(new java.awt.GridBagLayout());

        sus_jLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sus_jLabel.setText("Número de Registro SUS:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        paciente_jPanel.add(sus_jLabel, gridBagConstraints);

        sus_formattedtField.setColumns(12);
        try {
            sus_formattedtField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("### #### #### ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        sus_formattedtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sus_formattedtFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        paciente_jPanel.add(sus_formattedtField, gridBagConstraints);

        formulario_jPanel.add(paciente_jPanel);

        getContentPane().add(formulario_jPanel, java.awt.BorderLayout.CENTER);

        submit_jButton.setText("Cadastrar ou Alterar");
        submit_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_jButtonActionPerformed(evt);
            }
        });
        botoes_jPanel.add(submit_jButton);

        delete_jToggleButton.setText("Remover");
        delete_jToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_jToggleButtonActionPerformed(evt);
            }
        });
        botoes_jPanel.add(delete_jToggleButton);

        cancel_jButton.setText("Cancelar");
        cancel_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_jButtonActionPerformed(evt);
            }
        });
        botoes_jPanel.add(cancel_jButton);

        getContentPane().add(botoes_jPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nome_textFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nome_textFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nome_textFieldActionPerformed

    private void cpf_textFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpf_textFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpf_textFieldActionPerformed

    private void rg_textFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rg_textFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rg_textFieldActionPerformed

    private void telefone_formattedFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefone_formattedFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefone_formattedFieldActionPerformed

    private void logradouro_textFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logradouro_textFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logradouro_textFieldActionPerformed

    private void bairroFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bairroFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bairroFieldActionPerformed

    private void cidadeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cidadeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cidadeFieldActionPerformed

    private void cep_formattedFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cep_formattedFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cep_formattedFieldActionPerformed

    private void submit_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_jButtonActionPerformed
        switch (tipoDeContexto) {
            case CADASTRAR:
                cadastrar();
                break;
            case ATUALIZAR:
                atualizar(pessoa);
                break;
            default:
        }

    }//GEN-LAST:event_submit_jButtonActionPerformed
    /**
     * Extrai informações do formulário para criar uma instância de pessoa.
     *
     * @see Pessoa
     */
    private Pessoa preenchePessoaFormulario() throws IllegalArgumentException {
        String nome = nome_textField.getText();
        String cpf = cpf_textField.getText();
        String rg = rg_textField.getText();
        String email = email_textField.getText();
        char sexo = masculino_radioButton.isSelected() ? 'm' : 'f';
        Date data_nascimento = nascimento_DateField.getDate();
        String telefone = telefone_formattedField.getText();
        String logradouro = logradouro_textField.getText();
        int numCasa = 0; //TODO
        String bairro = bairroField.getText();
        String cidade = cidadeField.getText();
        String estado = estado_textField.getText();
        String cep = cep_formattedField.getText();
        Pessoa pessoa = new Pessoa(nome, cpf, rg, email, sexo, data_nascimento, telefone, logradouro, numCasa, bairro, cidade, estado, cep);
        return pessoa;
    }

    /**
     * Extrai informações do formulário para atribuir uma instância de médico à
     * pessoa.
     *
     * @param pessoa A pessoa que irá receber a atribuição.
     *
     * @see Medico
     */
    private void setMedicoFormulario(Pessoa pessoa) {
        String crm = crm_jTextField.getText();
        int cargaHoraria;
        if (chField.getText() == null || chField.getText().equals("  ")) {
            cargaHoraria = 0;
        } else {
            cargaHoraria = Integer.parseInt(chField.getText());
        }
        Especialidade especialidade = especialidesMap.get(espField_jComboBox.getSelectedItem());
        Medico m = new Medico(crm, cargaHoraria, especialidade);
        m.setPessoa(pessoa);
        pessoa.setMedico(m);
    }

    /**
     * Extrai informações do formulário para atribuir uma instância de paciente
     * à pessoa.
     *
     * @param pessoa A pessoa que irá receber a atribuição.
     *
     * @see Paciente
     */
    private void setPacienteFormulario(Pessoa pessoa) {
        Paciente p = new Paciente(sus_formattedtField.getText());
        pessoa.setPaciente(p);
    }

    /**
     * Checa se os campos referidos à pessoa tem as informações obrigatórias.
     *
     * @see Pessoa
     */
    private boolean checarCampoObrigatorio() {
        return !cpf_textField.getText().isEmpty() && !nome_textField.getText().isEmpty() && !rg_textField.getText().isEmpty() && nascimento_DateField.getDate() != null;
    }

    /**
     * Fluxo de instruções para execução do processo de cadastro de uma pessoa.
     * Dependendo do contexto, será a ela atribuida uma entidade Médico ou
     * Paciente.
     */
    private void cadastrar() {
        if (checarCampoObrigatorio()) {
            Pessoa p = preenchePessoaFormulario();

            if (tipoDePessoa == TipoPessoaEnum.MEDICO) {
                setMedicoFormulario(p);
            } else if (tipoDePessoa == TipoPessoaEnum.PACIENTE) {
                setPacienteFormulario(p);
            }
            try {
                p.create();
                limpaFormulario();
                JOptionPane.showMessageDialog(this, tipoDePessoa + " armazenado com sucesso.");
            } catch (PreexistingEntityException ex) {
                JOptionPane.showMessageDialog(this, "O " + tipoDePessoa + " já encontra-se cadastrado.");
                Logger.getLogger(FormPessoa.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Comportamento inesperado.");
                ex.printStackTrace();
                Logger.getLogger(FormPessoa.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Informe os campos obrigattórios nome, CPF,\n"
                    + "RG e data de nascimento");
        }
    }

    /**
     * Fluxo de instruções para execução do processo de atualização das
     * informações de uma pessoa. Dependendo do contexto, a atualização será
     * feita à Médico ou Pessoa.
     */
    private void atualizar(Pessoa pessoa) {
        if (pessoa == null) {
            throw new NullPointerException();
        }
        updatePessoaTemp(pessoa);
        try {
            pessoa.update();
            limpaFormulario();
            JOptionPane.showMessageDialog(this, tipoDePessoa + " atualizado com sucesso.");
        } catch (Exception ex) {
            Logger.getLogger(FormPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Extrai todas as informações do formulário para atribuir a pessoa que está
     * sujeito à atualização.
     */
    private void updatePessoaTemp(Pessoa pessoa) {
        // TODO: atualizar Pessoa
        String nome = nome_textField.getText();
        pessoa.setNome(nome);
        String cpf = cpf_textField.getText();
        pessoa.setCpf(cpf);
        String rg = rg_textField.getText();
        pessoa.setRg(rg);
        String email = email_textField.getText();
        pessoa.setEmail(email);
        char sexo = masculino_radioButton.isSelected() ? 'm' : 'f';
        pessoa.setSexo(sexo);
        Date data_nascimento = nascimento_DateField.getDate();
        pessoa.setDataDeNascimento(data_nascimento);
        String telefone = telefone_formattedField.getText();
        pessoa.setTelefone(telefone);
        String logradouro = logradouro_textField.getText();
        pessoa.setLogradouro(logradouro);
        int numCasa = 0; //TODO
        pessoa.setNumCasa(numCasa);
        String bairro = bairroField.getText();
        pessoa.setBairro(bairro);
        String cidade = cidadeField.getText();
        pessoa.setCidade(cidade);
        String estado = estado_textField.getText();
        pessoa.setEstado(estado);
        String cep = cep_formattedField.getText();
        pessoa.setCep(cep);
        if (tipoDePessoa == tipoDePessoa.MEDICO) {
            updatePessoaTemp_Medico();
        } else if (tipoDePessoa == tipoDePessoa.PACIENTE) {
            updatePessoaTemp_Paciente();
        }

    }

    private void updatePessoaTemp_Medico() throws NullPointerException {
        if (pessoa.getMedico() == null) {
            throw new NullPointerException();
        }
        int cargaHoraria;
        if (chField.getText() == null || chField.getText().equals("  ")) {
            cargaHoraria = 0;
        } else {
            cargaHoraria = Integer.parseInt(chField.getText());
        }
        pessoa.getMedico().setCargaHoraria(cargaHoraria);
        Especialidade especialidade = extrairEspecialidade();
        pessoa.getMedico().setEspecialidade(especialidade);
    }

    private void updatePessoaTemp_Paciente() throws NullPointerException {
        if (pessoa.getPaciente() == null) {
            throw new NullPointerException();
        }
        String num_sus = sus_formattedtField.getText();
        pessoa.getPaciente().setNum_sus(num_sus);
    }
    private void sus_formattedtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sus_formattedtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sus_formattedtFieldActionPerformed

    private void cancel_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_jButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cancel_jButtonActionPerformed

    private void chFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chFieldActionPerformed

    private void search_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_jButtonActionPerformed

        try {
            limpaFormulario();
            pessoa = Pessoa.findByCPF(BuscaCpf_textField.getText());
            preencherFormularioPessoa();
            botoes_jPanel.setVisible(true);
        } catch (NoResultException ex) {
            JOptionPane.showMessageDialog(null, "Ninguém encontrado.");
        } finally {
            atualizarContextoJanela();
        }
    }//GEN-LAST:event_search_jButtonActionPerformed

    private void masculino_radioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masculino_radioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_masculino_radioButtonActionPerformed

    private void email_textFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_email_textFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_email_textFieldActionPerformed

    private void BuscaCpf_textFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscaCpf_textFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscaCpf_textFieldActionPerformed

    private void delete_jToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_jToggleButtonActionPerformed
        if (pessoa != null) {
            int reply = JOptionPane.showConfirmDialog(null, "Deseja Realmente apagar a pessoa " + pessoa.getNome() + "?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if(reply == JOptionPane.YES_OPTION){
                pessoa.delete();
                limpaFormulario();
                pessoa = null;
                atualizarContextoJanela();
            }            
        }
    }//GEN-LAST:event_delete_jToggleButtonActionPerformed

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
            java.util.logging.Logger.getLogger(FormPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPessoa(
                        TipoContextoEnum.CADASTRAR,
                        TipoPessoaEnum.MEDICO
                ).setVisible(true);
            }
        });
    }

    private void updateFrameAction() {
        // TODO Auto-generated method stub
//        SearchPerson.getInstance(this);
    }

    private FormPessoa.UF_Enum getUF(String uf) {
        // TODO Auto-generated method stub

        FormPessoa.UF_Enum[] values = FormPessoa.UF_Enum.values();
        for (FormPessoa.UF_Enum f : values) {
            if (f.getName().equals(uf)) {
                return f;
            }
        }
        return null;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField BuscaCpf_textField;
    private javax.swing.JTextField bairroField;
    private javax.swing.JLabel bairro_jLabel;
    private javax.swing.JPanel botoes_jPanel;
    private javax.swing.JPanel busca_jPanel;
    private javax.swing.JButton cancel_jButton;
    private javax.swing.JFormattedTextField cep_formattedField;
    private javax.swing.JLabel cep_jLabel;
    private javax.swing.JFormattedTextField chField;
    private javax.swing.JTextField cidadeField;
    private javax.swing.JLabel cidade_jLabel;
    private javax.swing.JLabel cpf_jLabel;
    private javax.swing.JFormattedTextField cpf_textField;
    private javax.swing.JLabel crm_jLabel;
    private javax.swing.JTextField crm_jTextField;
    private javax.swing.JToggleButton delete_jToggleButton;
    private javax.swing.JLabel email_jLabel;
    private javax.swing.JTextField email_textField;
    private javax.swing.JComboBox<String> espField_jComboBox;
    private javax.swing.JLabel estado_jLabel;
    private javax.swing.JTextField estado_textField;
    private javax.swing.JRadioButton feminino_radioButton;
    private javax.swing.JPanel formulario_jPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel logradouro_jLabel;
    private javax.swing.JTextField logradouro_textField;
    private javax.swing.JRadioButton masculino_radioButton;
    private javax.swing.JPanel medico_jPanel;
    private com.toedter.calendar.JDateChooser nascimento_DateField;
    private javax.swing.JLabel nascimento_jLabel;
    private javax.swing.JLabel nome_jLabel;
    private javax.swing.JTextField nome_textField;
    private javax.swing.JPanel paciente_jPanel;
    private javax.swing.JPanel pessoa_jPanel;
    private javax.swing.JLabel rg_jLabel;
    private javax.swing.JTextField rg_textField;
    private javax.swing.JButton search_jButton;
    private javax.swing.ButtonGroup sexo_buttonGroup;
    private javax.swing.JButton submit_jButton;
    private javax.swing.JFormattedTextField sus_formattedtField;
    private javax.swing.JLabel sus_jLabel;
    private javax.swing.JFormattedTextField telefone_formattedField;
    private javax.swing.JLabel telefone_jLabel;
    // End of variables declaration//GEN-END:variables
}
