/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model;

import br.edu.ufersa.controlConsult.model.jpaDAO.JpaFactory;
import br.edu.ufersa.controlConsult.model.jpaDAO.PacienteJpaController;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author leone
 */
@Entity
@DiscriminatorColumn(name = "Paciente")
public class Paciente extends Pessoa {

    private String num_sus;

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

}
