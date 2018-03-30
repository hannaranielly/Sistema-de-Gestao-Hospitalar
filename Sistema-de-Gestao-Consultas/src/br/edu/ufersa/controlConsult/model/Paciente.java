/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model;

import br.edu.ufersa.controlConsult.model.interfaces.ICRUD;
import br.edu.ufersa.controlConsult.model.jpaDAO.JpaFactory;
import br.edu.ufersa.controlConsult.model.jpaDAO.PacienteJpaController;
import br.edu.ufersa.controlConsult.model.jpaDAO.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author leone
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p")
    , @NamedQuery(name = "Paciente.findById", query = "SELECT p FROM Paciente p WHERE p.id = :id")})
public class Paciente implements ICRUD, Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "paciente")
    private Pessoa pessoa;

    @Column(length = 25, unique = true)
    private String num_sus;

    public Paciente() {
    }

    public Paciente(String num_sus) {
        this.setNum_sus(num_sus);
    }

    public String getNum_sus() {
        return num_sus;
    }

    public void setNum_sus(String num_sus) {
        this.num_sus = num_sus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ufersa.controlConsult.model.Paciente[ id=" + this.getId() + " ]";
    }

    @Override
    public void create() {
        EntityManagerFactory emf = JpaFactory.getInstance();
        PacienteJpaController instance = new PacienteJpaController(emf);
        instance.create(this);
    }

    @Override
    public void read() throws NonexistentEntityException {
        EntityManagerFactory emf = JpaFactory.getInstance();
        PacienteJpaController instance = new PacienteJpaController(emf);
        try {
            instance.read(this);

        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Paciente.class
                    .getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public void update() {
        EntityManagerFactory emf = JpaFactory.getInstance();
        PacienteJpaController instance = new PacienteJpaController(emf);
        try {
            instance.edit(this);

        } catch (Exception ex) {
            Logger.getLogger(Paciente.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete() {
        EntityManagerFactory emf = JpaFactory.getInstance();
        PacienteJpaController instance = new PacienteJpaController(emf);
        try {
            instance.destroy(this.getId());

        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Paciente.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}
