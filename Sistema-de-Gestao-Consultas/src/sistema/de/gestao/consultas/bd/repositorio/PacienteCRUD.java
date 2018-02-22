/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.de.gestao.consultas.bd.repositorio;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sistema.de.gestao.consultas.bd.HibernateUtil;
import sistema.de.gestao.consultas.entidades.Paciente;

/**
 *
 * @author leone
 */
public class PacienteCRUD {
    private SessionFactory sf;
    public PacienteCRUD(){
        sf = HibernateUtil.getSessionFactory();
    }
    
    public void salvar_atualizar(Paciente paciente){
        Session session = sf.openSession();
        try {
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(paciente);
            tx.commit();
            session.flush();
            session.close();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
    }
    
}
