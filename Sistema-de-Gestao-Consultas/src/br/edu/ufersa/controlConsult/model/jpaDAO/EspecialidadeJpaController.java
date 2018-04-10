/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model.jpaDAO;

import br.edu.ufersa.controlConsult.model.Especialidade;
import br.edu.ufersa.controlConsult.model.Medico;
import br.edu.ufersa.controlConsult.model.jpaDAO.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author juan
 */
public class EspecialidadeJpaController implements Serializable {

    public EspecialidadeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Especialidade especialidade) throws EntityExistsException {
        if (especialidade.getMedicoList() == null) {
            especialidade.setMedicoList(new ArrayList<Medico>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Medico> attachedMedicoList = new ArrayList<Medico>();
            for (Medico medicoListMedicoToAttach : especialidade.getMedicoList()) {
                medicoListMedicoToAttach = em.getReference(medicoListMedicoToAttach.getClass(), medicoListMedicoToAttach.getId());
                attachedMedicoList.add(medicoListMedicoToAttach);
            }
            especialidade.setMedicoList(attachedMedicoList);
            em.persist(especialidade);
            for (Medico medicoListMedico : especialidade.getMedicoList()) {
                Especialidade oldEspecialidadeOfMedicoListMedico = medicoListMedico.getEspecialidade();
                medicoListMedico.setEspecialidade(especialidade);
                medicoListMedico = em.merge(medicoListMedico);
                if (oldEspecialidadeOfMedicoListMedico != null) {
                    oldEspecialidadeOfMedicoListMedico.getMedicoList().remove(medicoListMedico);
                    oldEspecialidadeOfMedicoListMedico = em.merge(oldEspecialidadeOfMedicoListMedico);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void read(Especialidade especialidade) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.refresh(especialidade);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Especialidade especialidade) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Especialidade persistentEspecialidade = em.find(Especialidade.class, especialidade.getId());
            List<Medico> medicoListOld = persistentEspecialidade.getMedicoList();
            List<Medico> medicoListNew = especialidade.getMedicoList();
            List<Medico> attachedMedicoListNew = new ArrayList<Medico>();
            for (Medico medicoListNewMedicoToAttach : medicoListNew) {
                medicoListNewMedicoToAttach = em.getReference(medicoListNewMedicoToAttach.getClass(), medicoListNewMedicoToAttach.getId());
                attachedMedicoListNew.add(medicoListNewMedicoToAttach);
            }
            medicoListNew = attachedMedicoListNew;
            especialidade.setMedicoList(medicoListNew);
            especialidade = em.merge(especialidade);
            for (Medico medicoListOldMedico : medicoListOld) {
                if (!medicoListNew.contains(medicoListOldMedico)) {
                    medicoListOldMedico.setEspecialidade(null);
                    medicoListOldMedico = em.merge(medicoListOldMedico);
                }
            }
            for (Medico medicoListNewMedico : medicoListNew) {
                if (!medicoListOld.contains(medicoListNewMedico)) {
                    Especialidade oldEspecialidadeOfMedicoListNewMedico = medicoListNewMedico.getEspecialidade();
                    medicoListNewMedico.setEspecialidade(especialidade);
                    medicoListNewMedico = em.merge(medicoListNewMedico);
                    if (oldEspecialidadeOfMedicoListNewMedico != null && !oldEspecialidadeOfMedicoListNewMedico.equals(especialidade)) {
                        oldEspecialidadeOfMedicoListNewMedico.getMedicoList().remove(medicoListNewMedico);
                        oldEspecialidadeOfMedicoListNewMedico = em.merge(oldEspecialidadeOfMedicoListNewMedico);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = especialidade.getId();
                if (findEspecialidade(id) == null) {
                    throw new NonexistentEntityException("The especialidade with id " + id + " no longer exists.");
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
            Especialidade especialidade;
            try {
                especialidade = em.getReference(Especialidade.class, id);
                especialidade.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The especialidade with id " + id + " no longer exists.", enfe);
            }
            List<Medico> medicoList = especialidade.getMedicoList();
            for (Medico medicoListMedico : medicoList) {
                medicoListMedico.setEspecialidade(null);
                medicoListMedico = em.merge(medicoListMedico);
            }
            em.remove(especialidade);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Especialidade> findEspecialidadeEntities() {
        return findEspecialidadeEntities(true, -1, -1);
    }

    public List<Especialidade> findEspecialidadeEntities(int maxResults, int firstResult) {
        return findEspecialidadeEntities(false, maxResults, firstResult);
    }

    private List<Especialidade> findEspecialidadeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Especialidade.class));
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

    public Especialidade findEspecialidade(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Especialidade.class, id);
        } finally {
            em.close();
        }
    }

    public int getEspecialidadeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Especialidade> rt = cq.from(Especialidade.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<Especialidade> findByNome(String nome) {
        List<Especialidade> especialidadeList = new ArrayList<Especialidade>();
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createNamedQuery("Especialidade.findByNome");
            q.setParameter("nome", nome);
            especialidadeList.addAll(q.getResultList());
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return especialidadeList;
    }

}
