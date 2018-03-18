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
import br.edu.ufersa.controlConsult.model.Especialidade;
import br.edu.ufersa.controlConsult.model.Medico;
import br.edu.ufersa.controlConsult.model.jpaDAO.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author juan
 */
public class MedicoJpaController implements Serializable {

    public MedicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Medico medico) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Especialidade especialidade = medico.getEspecialidade();
            if (especialidade != null && em.contains(especialidade)) {
                especialidade = em.getReference(especialidade.getClass(), especialidade.getId());
                medico.setEspecialidade(especialidade);
            }
            em.persist(medico);
            if (especialidade != null && especialidade.getMedicoList() != null) {
                especialidade.getMedicoList().add(medico);
                especialidade = em.merge(especialidade);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void read(Medico medico) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            if (!em.contains(medico)) {
                throw new NonexistentEntityException("Entidade médico não existe.");
            }
            em.getTransaction().begin();
            em.refresh(medico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Medico medico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Medico persistentMedico = em.find(Medico.class, medico.getId());
            Especialidade especialidadeOld = persistentMedico.getEspecialidade();
            Especialidade especialidadeNew = medico.getEspecialidade();
            if (especialidadeNew != null) {
                especialidadeNew = em.getReference(especialidadeNew.getClass(), especialidadeNew.getId());
                medico.setEspecialidade(especialidadeNew);
            }
            medico = em.merge(medico);
            if (especialidadeOld != null && !especialidadeOld.equals(especialidadeNew)) {
                especialidadeOld.getMedicoList().remove(medico);
                especialidadeOld = em.merge(especialidadeOld);
            }
            if (especialidadeNew != null && !especialidadeNew.equals(especialidadeOld)) {
                especialidadeNew.getMedicoList().add(medico);
                especialidadeNew = em.merge(especialidadeNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = medico.getId();
                if (findMedico(id) == null) {
                    throw new NonexistentEntityException("The medico with id " + id + " no longer exists.");
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
            Medico medico;
            try {
                medico = em.getReference(Medico.class, id);
                medico.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The medico with id " + id + " no longer exists.", enfe);
            }
            Especialidade especialidade = medico.getEspecialidade();
            if (especialidade != null) {
                especialidade.getMedicoList().remove(medico);
                especialidade = em.merge(especialidade);
            }
            em.remove(medico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Medico> findMedicoEntities() {
        return findMedicoEntities(true, -1, -1);
    }

    public List<Medico> findMedicoEntities(int maxResults, int firstResult) {
        return findMedicoEntities(false, maxResults, firstResult);
    }

    private List<Medico> findMedicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Medico.class));
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

    public Medico findMedico(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Medico.class, id);
        } finally {
            em.close();
        }
    }

    public int getMedicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Medico> rt = cq.from(Medico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public Medico findByCPF(String cpf) {
        Medico medico = null;
        EntityManager em = null;
        try {
            em.getTransaction().begin();
            Query q = em.createNamedQuery("Medico.findByCPF");
            q.setParameter(0, cpf);
            medico = (Medico) q.getSingleResult();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return medico;
    }
}
