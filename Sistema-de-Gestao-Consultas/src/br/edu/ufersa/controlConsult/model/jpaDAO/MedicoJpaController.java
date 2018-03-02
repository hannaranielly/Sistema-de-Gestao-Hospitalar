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
public class MedicoJpaController implements Serializable {

    public MedicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Medico medico) throws IllegalOrphanException {
        List<String> illegalOrphanMessages = null;
        Pessoa pessoaOrphanCheck = medico.getPessoa();
        if (pessoaOrphanCheck != null) {
            Medico oldMedicoOfPessoa = pessoaOrphanCheck.getMedico();
            if (oldMedicoOfPessoa != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Pessoa " + pessoaOrphanCheck + " already has an item of type Medico whose pessoa column cannot be null. Please make another selection for the pessoa field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Especialidade especialidade = medico.getEspecialidade();
            if (especialidade != null) {
                especialidade = em.getReference(especialidade.getClass(), especialidade.getId());
                medico.setEspecialidade(especialidade);
            }
            Pessoa pessoa = medico.getPessoa();
            if (pessoa != null) {
                pessoa = em.getReference(pessoa.getClass(), pessoa.getId());
                medico.setPessoa(pessoa);
            }
            Paciente paciente = medico.getPaciente();
            if (paciente != null) {
                paciente = em.getReference(paciente.getClass(), paciente.getId());
                medico.setPaciente(paciente);
            }
            Medico medicoRel = medico.getMedico();
            if (medicoRel != null) {
                medicoRel = em.getReference(medicoRel.getClass(), medicoRel.getId());
                medico.setMedico(medicoRel);
            }
            em.persist(medico);
            if (especialidade != null) {
                especialidade.getMedicoList().add(medico);
                especialidade = em.merge(especialidade);
            }
            if (pessoa != null) {
                pessoa.setMedico(medico);
                pessoa = em.merge(pessoa);
            }
            if (paciente != null) {
                br.edu.ufersa.controlConsult.model.Pessoa oldPessoaOfPaciente = paciente.getPessoa();
                if (oldPessoaOfPaciente != null) {
                    oldPessoaOfPaciente.setPaciente(null);
                    oldPessoaOfPaciente = em.merge(oldPessoaOfPaciente);
                }
                paciente.setPessoa(medico);
                paciente = em.merge(paciente);
            }
            if (medicoRel != null) {
                br.edu.ufersa.controlConsult.model.Pessoa oldPessoaOfMedicoRel = medicoRel.getPessoa();
                if (oldPessoaOfMedicoRel != null) {
                    oldPessoaOfMedicoRel.setMedico(null);
                    oldPessoaOfMedicoRel = em.merge(oldPessoaOfMedicoRel);
                }
                medicoRel.setPessoa(medico);
                medicoRel = em.merge(medicoRel);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Medico medico) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Medico persistentMedico = em.find(Medico.class, medico.getId());
            Especialidade especialidadeOld = persistentMedico.getEspecialidade();
            Especialidade especialidadeNew = medico.getEspecialidade();
            Pessoa pessoaOld = persistentMedico.getPessoa();
            Pessoa pessoaNew = medico.getPessoa();
            Paciente pacienteOld = persistentMedico.getPaciente();
            Paciente pacienteNew = medico.getPaciente();
            Medico medicoRelOld = persistentMedico.getMedico();
            Medico medicoRelNew = medico.getMedico();
            List<String> illegalOrphanMessages = null;
            if (pessoaNew != null && !pessoaNew.equals(pessoaOld)) {
                Medico oldMedicoOfPessoa = pessoaNew.getMedico();
                if (oldMedicoOfPessoa != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Pessoa " + pessoaNew + " already has an item of type Medico whose pessoa column cannot be null. Please make another selection for the pessoa field.");
                }
            }
            if (pacienteOld != null && !pacienteOld.equals(pacienteNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Paciente " + pacienteOld + " since its pessoa field is not nullable.");
            }
            if (medicoRelOld != null && !medicoRelOld.equals(medicoRelNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Medico " + medicoRelOld + " since its pessoa field is not nullable.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (especialidadeNew != null) {
                especialidadeNew = em.getReference(especialidadeNew.getClass(), especialidadeNew.getId());
                medico.setEspecialidade(especialidadeNew);
            }
            if (pessoaNew != null) {
                pessoaNew = em.getReference(pessoaNew.getClass(), pessoaNew.getId());
                medico.setPessoa(pessoaNew);
            }
            if (pacienteNew != null) {
                pacienteNew = em.getReference(pacienteNew.getClass(), pacienteNew.getId());
                medico.setPaciente(pacienteNew);
            }
            if (medicoRelNew != null) {
                medicoRelNew = em.getReference(medicoRelNew.getClass(), medicoRelNew.getId());
                medico.setMedico(medicoRelNew);
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
            if (pessoaOld != null && !pessoaOld.equals(pessoaNew)) {
                pessoaOld.setMedico(null);
                pessoaOld = em.merge(pessoaOld);
            }
            if (pessoaNew != null && !pessoaNew.equals(pessoaOld)) {
                pessoaNew.setMedico(medico);
                pessoaNew = em.merge(pessoaNew);
            }
            if (pacienteNew != null && !pacienteNew.equals(pacienteOld)) {
                br.edu.ufersa.controlConsult.model.Pessoa oldPessoaOfPaciente = pacienteNew.getPessoa();
                if (oldPessoaOfPaciente != null) {
                    oldPessoaOfPaciente.setPaciente(null);
                    oldPessoaOfPaciente = em.merge(oldPessoaOfPaciente);
                }
                pacienteNew.setPessoa(medico);
                pacienteNew = em.merge(pacienteNew);
            }
            if (medicoRelNew != null && !medicoRelNew.equals(medicoRelOld)) {
                br.edu.ufersa.controlConsult.model.Pessoa oldPessoaOfMedicoRel = medicoRelNew.getPessoa();
                if (oldPessoaOfMedicoRel != null) {
                    oldPessoaOfMedicoRel.setMedico(null);
                    oldPessoaOfMedicoRel = em.merge(oldPessoaOfMedicoRel);
                }
                medicoRelNew.setPessoa(medico);
                medicoRelNew = em.merge(medicoRelNew);
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

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
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
            List<String> illegalOrphanMessages = null;
            Paciente pacienteOrphanCheck = medico.getPaciente();
            if (pacienteOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Medico (" + medico + ") cannot be destroyed since the Paciente " + pacienteOrphanCheck + " in its paciente field has a non-nullable pessoa field.");
            }
            Medico medicoOrphanCheck = medico.getMedico();
            if (medicoOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Medico (" + medico + ") cannot be destroyed since the Medico " + medicoOrphanCheck + " in its medico field has a non-nullable pessoa field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Especialidade especialidade = medico.getEspecialidade();
            if (especialidade != null) {
                especialidade.getMedicoList().remove(medico);
                especialidade = em.merge(especialidade);
            }
            Pessoa pessoa = medico.getPessoa();
            if (pessoa != null) {
                pessoa.setMedico(null);
                pessoa = em.merge(pessoa);
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
    
}
