/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model.jpaDAO;

import br.edu.ufersa.controlConsult.model.Consulta;
import br.edu.ufersa.controlConsult.model.HorarioAtendimento;
import br.edu.ufersa.controlConsult.model.Medico;
import br.edu.ufersa.controlConsult.model.Paciente;
import br.edu.ufersa.controlConsult.model.jpaDAO.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author juan
 */
public class ConsultaJpaController implements Serializable {

    public ConsultaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Consulta consulta) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(consulta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void read(Consulta consulta) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.refresh(consulta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Consulta consulta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            consulta = em.merge(consulta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = consulta.getId();
                if (findConsulta(id) == null) {
                    throw new NonexistentEntityException("The consulta with id " + id + " no longer exists.");
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
            Consulta consulta;
            try {
                consulta = em.getReference(Consulta.class, id);
                consulta.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The consulta with id " + id + " no longer exists.", enfe);
            }
            em.remove(consulta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Consulta> findConsultaEntities() {
        return findConsultaEntities(true, -1, -1);
    }

    public List<Consulta> findConsultaEntities(int maxResults, int firstResult) {
        return findConsultaEntities(false, maxResults, firstResult);
    }

    private List<Consulta> findConsultaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Consulta.class));
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

    public Consulta findConsulta(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Consulta.class, id);
        } finally {
            em.close();
        }
    }

    public int getConsultaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Consulta> rt = cq.from(Consulta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public long numconsultaMarcado(HorarioAtendimento ha, Date data) {
        long num = 0;
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createNamedQuery("Consulta.numconsultaMarcado");
            q.setParameter("atendimento", ha);
            q.setParameter("data", data);
            if (q.getSingleResult() != null) {
                num = (long) q.getSingleResult();
            }

        } finally {
            if (em != null) {
                em.close();
            }
        }
        return num;
    }

    public long numconsultapaciente(HorarioAtendimento ha, Date data, Paciente paciente) {
        long num = 0;
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createNamedQuery("Consulta.numconsultapaciente");
            q.setParameter("atendimento", ha);
            q.setParameter("data", data);
            q.setParameter("paciente", paciente);
            if (q.getSingleResult() != null) {
                num = (long) q.getSingleResult();
            }

        } finally {
            if (em != null) {
                em.close();
            }
        }
        return num;
    }

    public List<Consulta> findporAtendimento(HorarioAtendimento ha, Date data) throws NoResultException {
        List<Consulta> consultas = null;
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createNamedQuery("Consulta.porAtendimento");
            q.setParameter("atendimento", ha);
            q.setParameter("data", data);
            consultas = q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return consultas;
    }

    public List<Consulta> findporMedico(Medico medico) throws NoResultException {
        List<Consulta> consultas = null;
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createNamedQuery("Consulta.porMedico");
            q.setParameter("medico", medico);
            consultas = q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return consultas;
    }

}
