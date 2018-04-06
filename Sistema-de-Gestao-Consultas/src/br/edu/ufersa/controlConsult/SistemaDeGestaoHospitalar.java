/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult;

import br.edu.ufersa.controlConsult.gui.TelaLogin;
import br.edu.ufersa.controlConsult.model.HorarioAtendimento;
import br.edu.ufersa.controlConsult.model.jpaDAO.JpaFactory;
import java.util.List;

/**
 *
 * @author leone
 */
public class SistemaDeGestaoHospitalar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        load();
        TelaLogin tela = new TelaLogin();
        tela.setVisible(true);
        tela.setLocationRelativeTo(null);
    }

    private static void load() {
        JpaFactory.getInstance(); // Inicia Conexão com o banco de dados.
    }

}
