/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.sistemaHospitalar.consultas;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import br.edu.ufersa.sistemaHospitalar.consultas.bd.HibernateUtil;
import br.edu.ufersa.sistemaHospitalar.consultas.bd.repositorio.PacienteCRUD;
import br.edu.ufersa.sistemaHospitalar.consultas.entidades.Administrador;
import br.edu.ufersa.sistemaHospitalar.consultas.entidades.Paciente;
import br.edu.ufersa.sistemaHospitalar.consultas.entidades.Pessoa;
import br.edu.ufersa.sistemaHospitalar.consultas.gui.CadPaciente;
import br.edu.ufersa.sistemaHospitalar.consultas.gui.TelaLogin;
import br.edu.ufersa.sistemaHospitalar.consultas.validacao.Criptografia;

/**
 *
 * @author leone
 */
public class SistemaDeGestaoHospitalar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        TelaLogin tela = new TelaLogin();
        tela.setVisible(true);
        tela.setLocationRelativeTo(null);
        
        
     
    }
    
}
