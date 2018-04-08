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
import br.edu.ufersa.controlConsult.model.Medico;
import br.edu.ufersa.controlConsult.model.Paciente;
import br.edu.ufersa.controlConsult.model.Pessoa;
import br.edu.ufersa.controlConsult.model.jpaDAO.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

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

    public void create(Pessoa pessoa) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(pessoa);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pessoa pessoa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            pessoa = em.merge(pessoa);
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

    public void destroy(Integer id) throws NonexistentEntityException {
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
            Medico medico = pessoa.getMedico();
            if (medico != null) {
                medico.setPessoa(null);
                medico = em.merge(medico);
            }
            Paciente paciente = pessoa.getPaciente();
            if (paciente != null) {
                paciente.setPessoa(null);
                paciente = em.merge(paciente);
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

    public Pessoa findByCPF(String cpf) throws NoResultException {
        Pessoa pessoa = null;
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createNamedQuery("Pessoa.findByCPF");
            q.setParameter("cpf", cpf);
            pessoa = (Pessoa) q.getSingleResult();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return pessoa;
    }

    public List<Pessoa> findByNome(String nome) throws NoResultException {
        List<Pessoa> pessoas = null;
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createNamedQuery("Pessoa.findByNome");
            q.setParameter("nome", "%" + nome + "%");
            pessoas = q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return pessoas;
    }

    public List<Pessoa> findByMedicoNome(String nome) throws NoResultException {
        List<Pessoa> pessoas = null;
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createNamedQuery("Pessoa.findMedicosByNome");
            q.setParameter("nome", "%" + nome + "%");
            pessoas = q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return pessoas;
    }

    public List<Pessoa> findByPacienteNome(String nome) throws NoResultException {
        List<Pessoa> pessoas = null;
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createNamedQuery("Pessoa.findPacientesByNome");
            q.setParameter("nome", "%" + nome + "%");
            pessoas = q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return pessoas;
    }

    public List<Pessoa> findMedicos() throws NoResultException {
        List<Pessoa> pessoas = null;
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createNamedQuery("Pessoa.medico");
            pessoas = q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return pessoas;
    }

}
