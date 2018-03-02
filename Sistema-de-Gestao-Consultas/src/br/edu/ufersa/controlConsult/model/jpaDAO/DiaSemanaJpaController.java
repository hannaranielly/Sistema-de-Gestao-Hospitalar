/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model.jpaDAO;

import br.edu.ufersa.controlConsult.model.DiaSemana;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.edu.ufersa.controlConsult.model.HorarioAtendimento;
import br.edu.ufersa.controlConsult.model.jpaDAO.exceptions.IllegalOrphanException;
import br.edu.ufersa.controlConsult.model.jpaDAO.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author juan
 */
public class DiaSemanaJpaController implements Serializable {

    public DiaSemanaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DiaSemana diaSemana) {
        if (diaSemana.getHorarioAtendimentoList() == null) {
            diaSemana.setHorarioAtendimentoList(new ArrayList<HorarioAtendimento>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<HorarioAtendimento> attachedHorarioAtendimentoList = new ArrayList<HorarioAtendimento>();
            for (HorarioAtendimento horarioAtendimentoListHorarioAtendimentoToAttach : diaSemana.getHorarioAtendimentoList()) {
                horarioAtendimentoListHorarioAtendimentoToAttach = em.getReference(horarioAtendimentoListHorarioAtendimentoToAttach.getClass(), horarioAtendimentoListHorarioAtendimentoToAttach.getId());
                attachedHorarioAtendimentoList.add(horarioAtendimentoListHorarioAtendimentoToAttach);
            }
            diaSemana.setHorarioAtendimentoList(attachedHorarioAtendimentoList);
            em.persist(diaSemana);
            for (HorarioAtendimento horarioAtendimentoListHorarioAtendimento : diaSemana.getHorarioAtendimentoList()) {
                DiaSemana oldDiaSemanaOfHorarioAtendimentoListHorarioAtendimento = horarioAtendimentoListHorarioAtendimento.getDiaSemana();
                horarioAtendimentoListHorarioAtendimento.setDiaSemana(diaSemana);
                horarioAtendimentoListHorarioAtendimento = em.merge(horarioAtendimentoListHorarioAtendimento);
                if (oldDiaSemanaOfHorarioAtendimentoListHorarioAtendimento != null) {
                    oldDiaSemanaOfHorarioAtendimentoListHorarioAtendimento.getHorarioAtendimentoList().remove(horarioAtendimentoListHorarioAtendimento);
                    oldDiaSemanaOfHorarioAtendimentoListHorarioAtendimento = em.merge(oldDiaSemanaOfHorarioAtendimentoListHorarioAtendimento);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DiaSemana diaSemana) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DiaSemana persistentDiaSemana = em.find(DiaSemana.class, diaSemana.getId());
            List<HorarioAtendimento> horarioAtendimentoListOld = persistentDiaSemana.getHorarioAtendimentoList();
            List<HorarioAtendimento> horarioAtendimentoListNew = diaSemana.getHorarioAtendimentoList();
            List<String> illegalOrphanMessages = null;
            for (HorarioAtendimento horarioAtendimentoListOldHorarioAtendimento : horarioAtendimentoListOld) {
                if (!horarioAtendimentoListNew.contains(horarioAtendimentoListOldHorarioAtendimento)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain HorarioAtendimento " + horarioAtendimentoListOldHorarioAtendimento + " since its diaSemana field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<HorarioAtendimento> attachedHorarioAtendimentoListNew = new ArrayList<HorarioAtendimento>();
            for (HorarioAtendimento horarioAtendimentoListNewHorarioAtendimentoToAttach : horarioAtendimentoListNew) {
                horarioAtendimentoListNewHorarioAtendimentoToAttach = em.getReference(horarioAtendimentoListNewHorarioAtendimentoToAttach.getClass(), horarioAtendimentoListNewHorarioAtendimentoToAttach.getId());
                attachedHorarioAtendimentoListNew.add(horarioAtendimentoListNewHorarioAtendimentoToAttach);
            }
            horarioAtendimentoListNew = attachedHorarioAtendimentoListNew;
            diaSemana.setHorarioAtendimentoList(horarioAtendimentoListNew);
            diaSemana = em.merge(diaSemana);
            for (HorarioAtendimento horarioAtendimentoListNewHorarioAtendimento : horarioAtendimentoListNew) {
                if (!horarioAtendimentoListOld.contains(horarioAtendimentoListNewHorarioAtendimento)) {
                    DiaSemana oldDiaSemanaOfHorarioAtendimentoListNewHorarioAtendimento = horarioAtendimentoListNewHorarioAtendimento.getDiaSemana();
                    horarioAtendimentoListNewHorarioAtendimento.setDiaSemana(diaSemana);
                    horarioAtendimentoListNewHorarioAtendimento = em.merge(horarioAtendimentoListNewHorarioAtendimento);
                    if (oldDiaSemanaOfHorarioAtendimentoListNewHorarioAtendimento != null && !oldDiaSemanaOfHorarioAtendimentoListNewHorarioAtendimento.equals(diaSemana)) {
                        oldDiaSemanaOfHorarioAtendimentoListNewHorarioAtendimento.getHorarioAtendimentoList().remove(horarioAtendimentoListNewHorarioAtendimento);
                        oldDiaSemanaOfHorarioAtendimentoListNewHorarioAtendimento = em.merge(oldDiaSemanaOfHorarioAtendimentoListNewHorarioAtendimento);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = diaSemana.getId();
                if (findDiaSemana(id) == null) {
                    throw new NonexistentEntityException("The diaSemana with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DiaSemana diaSemana;
            try {
                diaSemana = em.getReference(DiaSemana.class, id);
                diaSemana.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The diaSemana with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<HorarioAtendimento> horarioAtendimentoListOrphanCheck = diaSemana.getHorarioAtendimentoList();
            for (HorarioAtendimento horarioAtendimentoListOrphanCheckHorarioAtendimento : horarioAtendimentoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This DiaSemana (" + diaSemana + ") cannot be destroyed since the HorarioAtendimento " + horarioAtendimentoListOrphanCheckHorarioAtendimento + " in its horarioAtendimentoList field has a non-nullable diaSemana field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(diaSemana);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DiaSemana> findDiaSemanaEntities() {
        return findDiaSemanaEntities(true, -1, -1);
    }

    public List<DiaSemana> findDiaSemanaEntities(int maxResults, int firstResult) {
        return findDiaSemanaEntities(false, maxResults, firstResult);
    }

    private List<DiaSemana> findDiaSemanaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DiaSemana.class));
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

    public DiaSemana findDiaSemana(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DiaSemana.class, id);
        } finally {
            em.close();
        }
    }

    public int getDiaSemanaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DiaSemana> rt = cq.from(DiaSemana.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
