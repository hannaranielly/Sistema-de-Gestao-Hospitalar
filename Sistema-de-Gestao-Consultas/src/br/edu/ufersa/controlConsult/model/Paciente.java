/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model;

import br.edu.ufersa.controlConsult.model.interfaces.ICRUD;
import br.edu.ufersa.controlConsult.model.jpaDAO.JpaFactory;
import br.edu.ufersa.controlConsult.model.jpaDAO.MedicoJpaController;
import br.edu.ufersa.controlConsult.model.jpaDAO.PacienteJpaController;
import br.edu.ufersa.controlConsult.model.jpaDAO.exceptions.NonexistentEntityException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author leone
 */
@Entity
@DiscriminatorColumn(name = "Paciente")
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p")
    , @NamedQuery(name = "Paciente.findById", query = "SELECT p FROM Paciente p WHERE p.id = :id")
    , @NamedQuery(name = "Paciente.findByNome", query = "SELECT p FROM Paciente p WHERE p.nome = :nome")
    , @NamedQuery(name = "Paciente.findByCPF", query = "SELECT p FROM Paciente p WHERE p.cpf = :cpf")})
public class Paciente extends Pessoa implements ICRUD {

    @Column(length = 25, unique = true)
    private String num_sus;

    public Paciente() {
        super();
    }

    public Paciente(Pessoa pessoa, String num_sus) {
        super(pessoa);
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

    public static Paciente findByCPF(String cpf) {
        EntityManagerFactory emf = JpaFactory.getInstance();
        PacienteJpaController instance = new PacienteJpaController(emf);
        return instance.findByCPF(cpf);
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
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete() {
        EntityManagerFactory emf = JpaFactory.getInstance();
        PacienteJpaController instance = new PacienteJpaController(emf);
        try {
            instance.destroy(this.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
