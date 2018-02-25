/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.sistemaHospitalar.consultas.bd.repositorio;

import br.edu.ufersa.sistemaHospitalar.consultas.bd.HibernateUtil;
import br.edu.ufersa.sistemaHospitalar.consultas.entidades.Medico;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author leone
 */
public class MedicoCRUD {
     private SessionFactory sf;
    public MedicoCRUD(){
        sf = HibernateUtil.getSessionFactory();
    }
    
    public void salvar_atualizar(Medico medico){
        Session session = sf.openSession();
        try {
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(medico);
            tx.commit();
            session.flush();
            session.close();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
    }
    
    public void apagar(Medico medico){
        Session session = sf.openSession();
        try {
            Transaction tx = session.beginTransaction();
            session.delete(medico);
            tx.commit();
            session.flush();
            session.close();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
    }
    
    public Medico consulta_por_CPF(String cpf){
        Session session = sf.openSession();
        Query query = session.createSQLQuery("select * from pessoa AS p INNER JOIN medico AS me ON p.id =me.id where p.cpf = ? ").addEntity(Medico.class);
        query.setString(0, cpf);
        List<Medico> list =  (List<Medico>) query.list();
        session.close();
        if(list.isEmpty()){
            return null;
        }else{
            return list.get(0);
        }
        
    }
}
