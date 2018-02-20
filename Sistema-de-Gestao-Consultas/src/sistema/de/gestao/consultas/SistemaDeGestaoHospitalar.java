/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.de.gestao.consultas;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sistema.de.gestao.consultas.bd.HibernateUtil;
import sistema.de.gestao.consultas.entidades.Paciente;
import sistema.de.gestao.consultas.entidades.Pessoa;
import sistema.de.gestao.consultas.gui.telaLogin;

/**
 *
 * @author leone
 */
public class SistemaDeGestaoHospitalar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Paciente p = new Paciente();
        p.setNome("Francisco Leonésio Carneiro Duarte");
        p.setBairro("Centro");
        p.setBairro("Centro");
        p.setNum_sus("123456");
        //p.setId(1l);
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(p);
        
        tx.commit();
        session.flush();
        session.close();
        sf.close();
        telaLogin tela = new telaLogin();
        tela.setVisible(true);
    }
    
}
