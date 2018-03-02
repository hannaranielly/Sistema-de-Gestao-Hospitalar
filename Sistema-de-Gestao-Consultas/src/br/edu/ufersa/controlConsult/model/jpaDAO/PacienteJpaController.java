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
import br.edu.ufersa.controlConsult.model.Pessoa;
import br.edu.ufersa.controlConsult.model.Paciente;
import br.edu.ufersa.controlConsult.model.Medico;
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
public class PacienteJpaController implements Serializable {

    public PacienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Paciente paciente) throws IllegalOrphanException {
        List<String> illegalOrphanMessages = null;
        Pessoa pessoaOrphanCheck = paciente.getPessoa();
        if (pessoaOrphanCheck != null) {
            Paciente oldPacienteOfPessoa = pessoaOrphanCheck.getPaciente();
            if (oldPacienteOfPessoa != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Pessoa " + pessoaOrphanCheck + " already has an item of type Paciente whose pessoa column cannot be null. Please make another selection for the pessoa field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pessoa pessoa = paciente.getPessoa();
            if (pessoa != null) {
                pessoa = em.getReference(pessoa.getClass(), pessoa.getId());
                paciente.setPessoa(pessoa);
            }
            Paciente pacienteRel = paciente.getPaciente();
            if (pacienteRel != null) {
                pacienteRel = em.getReference(pacienteRel.getClass(), pacienteRel.getId());
                paciente.setPaciente(pacienteRel);
            }
            Medico medico = paciente.getMedico();
            if (medico != null) {
                medico = em.getReference(medico.getClass(), medico.getId());
                paciente.setMedico(medico);
            }
            em.persist(paciente);
            if (pessoa != null) {
                pessoa.setPaciente(paciente);
                pessoa = em.merge(pessoa);
            }
            if (pacienteRel != null) {
                br.edu.ufersa.controlConsult.model.Pessoa oldPessoaOfPacienteRel = pacienteRel.getPessoa();
                if (oldPessoaOfPacienteRel != null) {
                    oldPessoaOfPacienteRel.setPaciente(null);
                    oldPessoaOfPacienteRel = em.merge(oldPessoaOfPacienteRel);
                }
                pacienteRel.setPessoa(paciente);
                pacienteRel = em.merge(pacienteRel);
            }
            if (medico != null) {
                br.edu.ufersa.controlConsult.model.Pessoa oldPessoaOfMedico = medico.getPessoa();
                if (oldPessoaOfMedico != null) {
                    oldPessoaOfMedico.setMedico(null);
                    oldPessoaOfMedico = em.merge(oldPessoaOfMedico);
                }
                medico.setPessoa(paciente);
                medico = em.merge(medico);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Paciente paciente) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente persistentPaciente = em.find(Paciente.class, paciente.getId());
            Pessoa pessoaOld = persistentPaciente.getPessoa();
            Pessoa pessoaNew = paciente.getPessoa();
            Paciente pacienteRelOld = persistentPaciente.getPaciente();
            Paciente pacienteRelNew = paciente.getPaciente();
            Medico medicoOld = persistentPaciente.getMedico();
            Medico medicoNew = paciente.getMedico();
            List<String> illegalOrphanMessages = null;
            if (pessoaNew != null && !pessoaNew.equals(pessoaOld)) {
                Paciente oldPacienteOfPessoa = pessoaNew.getPaciente();
                if (oldPacienteOfPessoa != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Pessoa " + pessoaNew + " already has an item of type Paciente whose pessoa column cannot be null. Please make another selection for the pessoa field.");
                }
            }
            if (pacienteRelOld != null && !pacienteRelOld.equals(pacienteRelNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Paciente " + pacienteRelOld + " since its pessoa field is not nullable.");
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
            if (pessoaNew != null) {
                pessoaNew = em.getReference(pessoaNew.getClass(), pessoaNew.getId());
                paciente.setPessoa(pessoaNew);
            }
            if (pacienteRelNew != null) {
                pacienteRelNew = em.getReference(pacienteRelNew.getClass(), pacienteRelNew.getId());
                paciente.setPaciente(pacienteRelNew);
            }
            if (medicoNew != null) {
                medicoNew = em.getReference(medicoNew.getClass(), medicoNew.getId());
                paciente.setMedico(medicoNew);
            }
            paciente = em.merge(paciente);
            if (pessoaOld != null && !pessoaOld.equals(pessoaNew)) {
                pessoaOld.setPaciente(null);
                pessoaOld = em.merge(pessoaOld);
            }
            if (pessoaNew != null && !pessoaNew.equals(pessoaOld)) {
                pessoaNew.setPaciente(paciente);
                pessoaNew = em.merge(pessoaNew);
            }
            if (pacienteRelNew != null && !pacienteRelNew.equals(pacienteRelOld)) {
                br.edu.ufersa.controlConsult.model.Pessoa oldPessoaOfPacienteRel = pacienteRelNew.getPessoa();
                if (oldPessoaOfPacienteRel != null) {
                    oldPessoaOfPacienteRel.setPaciente(null);
                    oldPessoaOfPacienteRel = em.merge(oldPessoaOfPacienteRel);
                }
                pacienteRelNew.setPessoa(paciente);
                pacienteRelNew = em.merge(pacienteRelNew);
            }
            if (medicoNew != null && !medicoNew.equals(medicoOld)) {
                br.edu.ufersa.controlConsult.model.Pessoa oldPessoaOfMedico = medicoNew.getPessoa();
                if (oldPessoaOfMedico != null) {
                    oldPessoaOfMedico.setMedico(null);
                    oldPessoaOfMedico = em.merge(oldPessoaOfMedico);
                }
                medicoNew.setPessoa(paciente);
                medicoNew = em.merge(medicoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = paciente.getId();
                if (findPaciente(id) == null) {
                    throw new NonexistentEntityException("The paciente with id " + id + " no longer exists.");
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
            Paciente paciente;
            try {
                paciente = em.getReference(Paciente.class, id);
                paciente.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paciente with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Paciente pacienteOrphanCheck = paciente.getPaciente();
            if (pacienteOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Paciente (" + paciente + ") cannot be destroyed since the Paciente " + pacienteOrphanCheck + " in its paciente field has a non-nullable pessoa field.");
            }
            Medico medicoOrphanCheck = paciente.getMedico();
            if (medicoOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Paciente (" + paciente + ") cannot be destroyed since the Medico " + medicoOrphanCheck + " in its medico field has a non-nullable pessoa field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Pessoa pessoa = paciente.getPessoa();
            if (pessoa != null) {
                pessoa.setPaciente(null);
                pessoa = em.merge(pessoa);
            }
            em.remove(paciente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Paciente> findPacienteEntities() {
        return findPacienteEntities(true, -1, -1);
    }

    public List<Paciente> findPacienteEntities(int maxResults, int firstResult) {
        return findPacienteEntities(false, maxResults, firstResult);
    }

    private List<Paciente> findPacienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Paciente.class));
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

    public Paciente findPaciente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paciente.class, id);
        } finally {
            em.close();
        }
    }

    public int getPacienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Paciente> rt = cq.from(Paciente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
