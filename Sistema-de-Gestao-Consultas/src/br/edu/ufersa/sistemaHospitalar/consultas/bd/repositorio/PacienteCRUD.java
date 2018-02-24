/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.sistemaHospitalar.consultas.bd.repositorio;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import br.edu.ufersa.sistemaHospitalar.consultas.bd.HibernateUtil;
import br.edu.ufersa.sistemaHospitalar.consultas.entidades.Paciente;
import br.edu.ufersa.sistemaHospitalar.consultas.entidades.Pessoa;

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
    
    public void apagar(Paciente paciente){
        Session session = sf.openSession();
        try {
            Transaction tx = session.beginTransaction();
            session.delete(paciente);
            tx.commit();
            session.flush();
            session.close();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
    }
    
    public Paciente consulta_por_CPF(String cpf){
        Session session = sf.openSession();
        Query query = session.createSQLQuery("select * from pessoa AS p INNER JOIN paciente AS pa ON p.id =pa.id where p.cpf = ? ").addEntity(Paciente.class);
        query.setString(0, cpf);
        List<Paciente> list =  (List<Paciente>) query.list();
        session.close();
        if(list.isEmpty()){
            return null;
        }else{
            return list.get(0);
        }
        
    }

    
}
