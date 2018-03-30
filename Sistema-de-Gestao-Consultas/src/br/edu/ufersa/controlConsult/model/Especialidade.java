/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model;

import br.edu.ufersa.controlConsult.model.jpaDAO.EspecialidadeJpaController;
import br.edu.ufersa.controlConsult.model.jpaDAO.JpaFactory;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juan
 */
@Entity
@Table(name = "especialidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especialidade.findAll", query = "SELECT e FROM Especialidade e")
    , @NamedQuery(name = "Especialidade.findById", query = "SELECT e FROM Especialidade e WHERE e.id = :id")
    , @NamedQuery(name = "Especialidade.findByNome", query = "SELECT e FROM Especialidade e WHERE e.nome = :nome")})
public class Especialidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome", unique = true)
    private String nome;
    @OneToMany(mappedBy = "especialidade", fetch = FetchType.EAGER)
    private List<Medico> medicoList;

    public Especialidade() {
    }

    public Especialidade(String nome, List<Medico> medicoList) {
        this.setNome(nome);
        this.setMedicoList(medicoList);
    }

    public Especialidade(String nome) {
        this(nome, null);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<Medico> getMedicoList() {
        return medicoList;
    }

    public void setMedicoList(List<Medico> medicoList) {
        this.medicoList = medicoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especialidade)) {
            return false;
        }
        Especialidade other = (Especialidade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ufersa.controlConsult.model.jpaDAO.Especialidade[ id=" + id + " ]";
    }

    public static List<Especialidade> findByName(String name) {
        new UnsupportedOperationException("Unsupported operation."); //TODO To change body of generated methods, choose Tools | Templates.
        return null;
    }

    public static List<Especialidade> findByNome(String nome) {
        EntityManagerFactory emf = JpaFactory.getInstance();
        EspecialidadeJpaController instance = new EspecialidadeJpaController(emf);
        return instance.findByNome(nome);
    }
}
