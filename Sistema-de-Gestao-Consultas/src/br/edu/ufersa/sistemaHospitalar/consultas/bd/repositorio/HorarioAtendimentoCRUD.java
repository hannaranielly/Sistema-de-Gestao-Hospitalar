/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.sistemaHospitalar.consultas.bd.repositorio;

import br.edu.ufersa.sistemaHospitalar.consultas.bd.HibernateUtil;
import br.edu.ufersa.sistemaHospitalar.consultas.entidades.HorarioAtendimento;
import br.edu.ufersa.sistemaHospitalar.consultas.entidades.Medico;
import java.sql.Time;
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
public class HorarioAtendimentoCRUD {
         private SessionFactory sf;
    public HorarioAtendimentoCRUD(){
        sf = HibernateUtil.getSessionFactory();
    }
    
    public void salvar_atualizar(HorarioAtendimento horario){
        Session session = sf.openSession();
        try {
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(horario);
            tx.commit();
            session.flush();
            session.close();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
    }
    
    public void apagar(HorarioAtendimento horario){
        Session session = sf.openSession();
        try {
            Transaction tx = session.beginTransaction();
            session.delete(horario);
            tx.commit();
            session.flush();
            session.close();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
    }
    
    public List<HorarioAtendimento> consulta_por_id_medico(int id, Time inicio, Time fim){
        Session session = sf.openSession();
        Query query = session.createSQLQuery("select * from horario_atendimento AS h where h.medico_id = ? and (max(?,h.inicio) <= min(?,h.fim))").addEntity(HorarioAtendimento.class);
        query.setInteger(0, id);
        query.setDate(1, inicio);
        query.setDate(2, fim);
        List<HorarioAtendimento> list =  (List<HorarioAtendimento>) query.list();
        session.close();
        if(list.isEmpty()){
            return null;
        }else{
            return list;
        }
        
    }
}
