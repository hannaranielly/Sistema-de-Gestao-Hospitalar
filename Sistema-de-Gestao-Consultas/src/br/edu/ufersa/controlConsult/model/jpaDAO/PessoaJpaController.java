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
import br.edu.ufersa.controlConsult.model.Paciente;
import br.edu.ufersa.controlConsult.model.Medico;
import br.edu.ufersa.controlConsult.model.Pessoa;
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
public class PessoaJpaController implements Serializable {

    public PessoaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pessoa pessoa) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente paciente = pessoa.getPaciente();
            if (paciente != null) {
                paciente = em.getReference(paciente.getClass(), paciente.getId());
                pessoa.setPaciente(paciente);
            }
            Medico medico = pessoa.getMedico();
            if (medico != null) {
                medico = em.getReference(medico.getClass(), medico.getId());
                pessoa.setMedico(medico);
            }
            em.persist(pessoa);
            if (paciente != null) {
                Pessoa oldPessoaOfPaciente = paciente.getPessoa();
                if (oldPessoaOfPaciente != null) {
                    oldPessoaOfPaciente.setPaciente(null);
                    oldPessoaOfPaciente = em.merge(oldPessoaOfPaciente);
                }
                paciente.setPessoa(pessoa);
                paciente = em.merge(paciente);
            }
            if (medico != null) {
                Pessoa oldPessoaOfMedico = medico.getPessoa();
                if (oldPessoaOfMedico != null) {
                    oldPessoaOfMedico.setMedico(null);
                    oldPessoaOfMedico = em.merge(oldPessoaOfMedico);
                }
                medico.setPessoa(pessoa);
                medico = em.merge(medico);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pessoa pessoa) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pessoa persistentPessoa = em.find(Pessoa.class, pessoa.getId());
            Paciente pacienteOld = persistentPessoa.getPaciente();
            Paciente pacienteNew = pessoa.getPaciente();
            Medico medicoOld = persistentPessoa.getMedico();
            Medico medicoNew = pessoa.getMedico();
            List<String> illegalOrphanMessages = null;
            if (pacienteOld != null && !pacienteOld.equals(pacienteNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Paciente " + pacienteOld + " since its pessoa field is not nullable.");
            }
            if (medicoOld != null && !medicoOld.equals(medicoNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Medico " + medicoOld + " since its pessoa field is not nullable.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (pacienteNew != null) {
                pacienteNew = em.getReference(pacienteNew.getClass(), pacienteNew.getId());
                pessoa.setPaciente(pacienteNew);
            }
            if (medicoNew != null) {
                medicoNew = em.getReference(medicoNew.getClass(), medicoNew.getId());
                pessoa.setMedico(medicoNew);
            }
            pessoa = em.merge(pessoa);
            if (pacienteNew != null && !pacienteNew.equals(pacienteOld)) {
                Pessoa oldPessoaOfPaciente = pacienteNew.getPessoa();
                if (oldPessoaOfPaciente != null) {
                    oldPessoaOfPaciente.setPaciente(null);
                    oldPessoaOfPaciente = em.merge(oldPessoaOfPaciente);
                }
                pacienteNew.setPessoa(pessoa);
                pacienteNew = em.merge(pacienteNew);
            }
            if (medicoNew != null && !medicoNew.equals(medicoOld)) {
                Pessoa oldPessoaOfMedico = medicoNew.getPessoa();
                if (oldPessoaOfMedico != null) {
                    oldPessoaOfMedico.setMedico(null);
                    oldPessoaOfMedico = em.merge(oldPessoaOfMedico);
                }
                medicoNew.setPessoa(pessoa);
                medicoNew = em.merge(medicoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = pessoa.getId();
                if (findPessoa(id) == null) {
                    throw new NonexistentEntityException("The pessoa with id " + id + " no longer exists.");
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
            Pessoa pessoa;
            try {
                pessoa = em.getReference(Pessoa.class, id);
                pessoa.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pessoa with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Paciente pacienteOrphanCheck = pessoa.getPaciente();
            if (pacienteOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pessoa (" + pessoa + ") cannot be destroyed since the Paciente " + pacienteOrphanCheck + " in its paciente field has a non-nullable pessoa field.");
            }
            Medico medicoOrphanCheck = pessoa.getMedico();
            if (medicoOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pessoa (" + pessoa + ") cannot be destroyed since the Medico " + medicoOrphanCheck + " in its medico field has a non-nullable pessoa field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(pessoa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pessoa> findPessoaEntities() {
        return findPessoaEntities(true, -1, -1);
    }

    public List<Pessoa> findPessoaEntities(int maxResults, int firstResult) {
        return findPessoaEntities(false, maxResults, firstResult);
    }

    private List<Pessoa> findPessoaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pessoa.class));
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

    public Pessoa findPessoa(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pessoa.class, id);
        } finally {
            em.close();
        }
    }

    public int getPessoaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pessoa> rt = cq.from(Pessoa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
