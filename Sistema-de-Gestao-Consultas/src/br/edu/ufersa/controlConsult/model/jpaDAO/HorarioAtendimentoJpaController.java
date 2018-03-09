/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model.jpaDAO;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.edu.ufersa.controlConsult.model.DiaSemana;
import br.edu.ufersa.controlConsult.model.HorarioAtendimento;
import br.edu.ufersa.controlConsult.model.jpaDAO.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author juan
 */
public class HorarioAtendimentoJpaController implements Serializable {

    public HorarioAtendimentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(HorarioAtendimento horarioAtendimento) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DiaSemana diaSemana = horarioAtendimento.getDiaSemana();
            if (diaSemana != null) {
                diaSemana = em.getReference(diaSemana.getClass(), diaSemana.getId());
                horarioAtendimento.setDiaSemana(diaSemana);
            }
            em.persist(horarioAtendimento);
            if (diaSemana != null) {
                diaSemana.getHorarioAtendimentoList().add(horarioAtendimento);
                diaSemana = em.merge(diaSemana);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(HorarioAtendimento horarioAtendimento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            HorarioAtendimento persistentHorarioAtendimento = em.find(HorarioAtendimento.class, horarioAtendimento.getId());
            DiaSemana diaSemanaOld = persistentHorarioAtendimento.getDiaSemana();
            DiaSemana diaSemanaNew = horarioAtendimento.getDiaSemana();
            if (diaSemanaNew != null) {
                diaSemanaNew = em.getReference(diaSemanaNew.getClass(), diaSemanaNew.getId());
                horarioAtendimento.setDiaSemana(diaSemanaNew);
            }
            horarioAtendimento = em.merge(horarioAtendimento);
            if (diaSemanaOld != null && !diaSemanaOld.equals(diaSemanaNew)) {
                diaSemanaOld.getHorarioAtendimentoList().remove(horarioAtendimento);
                diaSemanaOld = em.merge(diaSemanaOld);
            }
            if (diaSemanaNew != null && !diaSemanaNew.equals(diaSemanaOld)) {
                diaSemanaNew.getHorarioAtendimentoList().add(horarioAtendimento);
                diaSemanaNew = em.merge(diaSemanaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = horarioAtendimento.getId();
                if (findHorarioAtendimento(id) == null) {
                    throw new NonexistentEntityException("The horarioAtendimento with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            HorarioAtendimento horarioAtendimento;
            try {
                horarioAtendimento = em.getReference(HorarioAtendimento.class, id);
                horarioAtendimento.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The horarioAtendimento with id " + id + " no longer exists.", enfe);
            }
            DiaSemana diaSemana = horarioAtendimento.getDiaSemana();
            if (diaSemana != null) {
                diaSemana.getHorarioAtendimentoList().remove(horarioAtendimento);
                diaSemana = em.merge(diaSemana);
            }
            em.remove(horarioAtendimento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<HorarioAtendimento> findHorarioAtendimentoEntities() {
        return findHorarioAtendimentoEntities(true, -1, -1);
    }

    public List<HorarioAtendimento> findHorarioAtendimentoEntities(int maxResults, int firstResult) {
        return findHorarioAtendimentoEntities(false, maxResults, firstResult);
    }

    private List<HorarioAtendimento> findHorarioAtendimentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(HorarioAtendimento.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public HorarioAtendimento findHorarioAtendimento(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(HorarioAtendimento.class, id);
        } finally {
            em.close();
        }
    }

    public int getHorarioAtendimentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<HorarioAtendimento> rt = cq.from(HorarioAtendimento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
