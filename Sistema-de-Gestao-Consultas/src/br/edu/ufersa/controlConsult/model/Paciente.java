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

    public void apagar() {
        //TODO
//        Session session = pacienteCRUD.sf.openSession();
//        try {
//            Transaction tx = session.beginTransaction();
//            session.delete(this);
//            tx.commit();
//            session.flush();
//            session.close();
//        } catch (HibernateException ex) {
//            ex.printStackTrace();
//        }
    }

    public static Paciente consulta_por_CPF(String cpf) {
        //TODO
//        Session session = pacienteCRUD.sf.openSession();
//        Query query = session.createSQLQuery("select * from pessoa AS p INNER JOIN paciente AS pa ON p.id =pa.id where p.cpf = ? ").addEntity(Paciente.class);
//        query.setString(0, cpf);
//        List<Paciente> list = (List<Paciente>) query.list();
//        session.close();
//        if (list.isEmpty()) {
//            return null;
//        } else {
//            return list.get(0);
//        }
        return null;
    }

    public void salvar_atualizar() {
        //TODO
//        Session session = pacienteCRUD.sf.openSession();
//        try {
//            Transaction tx = session.beginTransaction();
//            session.saveOrUpdate(this);
//            tx.commit();
//            session.flush();
//            session.close();
//        } catch (HibernateException ex) {
//            ex.printStackTrace();
//        }
    }

}
