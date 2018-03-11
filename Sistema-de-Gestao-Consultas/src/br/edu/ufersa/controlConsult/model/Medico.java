/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model;

import br.edu.ufersa.controlConsult.model.interfaces.ICRUD;
import br.edu.ufersa.controlConsult.model.jpaDAO.JpaFactory;
import br.edu.ufersa.controlConsult.model.jpaDAO.MedicoJpaController;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author cassiano
 */
@Entity
@DiscriminatorColumn(name = "Medico")
public class Medico extends Pessoa implements ICRUD {

    @Column(name = "carga_horaria")
    private Integer cargaHoraria;

    @JoinColumn(name = "especialidade", referencedColumnName = "id")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private Especialidade especialidade;

    @ManyToMany
    @JoinTable(name = "medico_horario", joinColumns = {
        @JoinColumn(name = "medico", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "horario", referencedColumnName = "id")})
    private List<HorarioAtendimento> listaHorario = new ArrayList<HorarioAtendimento>();

    public Medico(Pessoa pessoa, Integer cargaHoraria, Especialidade especialidade) {
        super(pessoa);
        this.setCargaHoraria(cargaHoraria);
        this.setEspecialidade(especialidade);
    }

    public Medico() {
        super();
    }

    public void setListaHorario(List<HorarioAtendimento> listaHorario) {
        this.listaHorario = listaHorario;
    }

    public List<HorarioAtendimento> getListaHorario() {
        return listaHorario;
    }

    public void setCargaHoraria(int cargaHoraria) {
        if (cargaHoraria <= 60 && cargaHoraria > 0) {
            this.cargaHoraria = cargaHoraria;
        }
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
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
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ufersa.controlConsult.model.Medico[ id=" + this.getId() + " ]";
    }

    public void addListaHorario(HorarioAtendimento h) {
        if (this.listaHorario == null) {
            this.listaHorario = new ArrayList<HorarioAtendimento>();
        }
        this.listaHorario.add(h);
    }

    public void apagar() {
        //TODO
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

    public static Medico consulta_por_CPF(String cpf) {
        //TODO
//        Session session = medicoCRUD.sf.openSession(); 
//        Query query = session.createSQLQuery("select * from pessoa AS p INNER JOIN medico AS me ON p.id =me.id where p.cpf = ? ").addEntity(Medico.class);
//        query.setString(0, cpf);
//        List<Medico> list = (List<Medico>) query.list();
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
//        Session session = medicoCRUD.sf.openSession();
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

    @Override
    public void create() {
        EntityManagerFactory emf = JpaFactory.getInstance();
        MedicoJpaController instance = new MedicoJpaController(emf);
        instance.create(this);
    }

    @Override
    public void read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
