/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model.jpaDAO;

import br.edu.ufersa.controlConsult.model.Medico;
import br.edu.ufersa.controlConsult.model.Questionario;
import java.io.Serializable;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author leone
 */
public class QuestionarioJpaController implements Serializable{
     public QuestionarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Questionario questionario) throws EntityExistsException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(questionario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public double mediaQ(Medico medico, String num){
        double media = 0;
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createQuery("SELECT AVG(m.q"+ num +") FROM Questionario m WHERE m.medico = :medico");
            q.setParameter("medico", medico);
            media = (double) q.getSingleResult();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return media;
    }
    
}
