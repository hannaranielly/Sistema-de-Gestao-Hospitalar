/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model;

import br.edu.ufersa.controlConsult.model.interfaces.ICRUD;
import br.edu.ufersa.controlConsult.model.jpaDAO.HorarioAtendimentoJpaController;
import br.edu.ufersa.controlConsult.model.jpaDAO.JpaFactory;
import br.edu.ufersa.controlConsult.model.jpaDAO.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author cassiano
 */
@Entity
@Table(name = "horario_atendimento")
public class HorarioAtendimento implements Serializable, ICRUD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "inicio")
    @Temporal(TemporalType.TIME)
    private Date inicio;
    @Basic(optional = false)
    @Column(name = "fim")
    @Temporal(TemporalType.TIME)
    private Date fim;
    @ManyToMany(mappedBy = "listaHorario", fetch = FetchType.EAGER)
    private List<Medico> medicoList;
    @JoinColumn(name = "dia_semana", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DiaSemana diaSemana;

    private int estado; //TODO
    private Date ultimaRealizacao; // TODO

    public HorarioAtendimento() {
    }

    public HorarioAtendimento(int id, Time inicio, Time fim,
            int estado, DiaSemana diaSemana) {
        this.setId(id);
        this.setInicio(inicio);
        this.setFim(fim);
        this.setEstado(estado);
        this.setUltimaRealizacao(ultimaRealizacao);
        this.setDiaSemana(diaSemana);
    }

    public HorarioAtendimento(Time inicio, Time fim,
            int estado, DiaSemana diaSemana) {
        this(-1, inicio, fim, estado, diaSemana);
    }

    public void setInicio(Time inicio) {
        this.inicio = inicio;
    }

    public void setFim(Time fim) {
        this.fim = fim;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }

    public void setUltimaRealizacao(Date ultimaRealizacao) {
        this.ultimaRealizacao = ultimaRealizacao;
    }

    public Date getUltimaRealizacao() {
        return ultimaRealizacao;
    }

    @Override
    public String toString() {
        return "Inicio: " + this.getInicio() + "\n"
                + "Fim: " + this.getFim() + "\n"
                + "Estado: " + this.getEstado() + "\n"
                + "Ultima realização: " + this.getUltimaRealizacao() + "\n"
                + "Dia da semana: " + this.getDiaSemana() + "\n";
    }

    public HorarioAtendimento(Integer id) {
        this.id = id;
    }

    public HorarioAtendimento(Integer id, Date inicio, Date fim) {
        this.id = id;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

//    @XmlTransient
//    public List<Medico> getMedicoList() {
//        return medicoList;
//    }
//
//    public void setMedicoList(List<Medico> medicoList) {
//        this.medicoList = medicoList;
//    }
    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiaSemana diaSemana) {
        this.diaSemana = diaSemana;
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
        if (!(object instanceof HorarioAtendimento)) {
            return false;
        }
        HorarioAtendimento other = (HorarioAtendimento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public static List<HorarioAtendimento> findByMedicoId(Integer id) {
        //        Session session = horarioAtendimentoCRUD.sf.openSession();
        //        Query query = session.createSQLQuery("select * from horario_atendimento AS h where h.medico_id = ?").addEntity(HorarioAtendimento.class);
        //        query.setInteger(0, id);
        //        List<HorarioAtendimento> list = (List<HorarioAtendimento>) query.list();
        //        session.close();
        //        return list;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static List<HorarioAtendimento> findByMedicoId_repetido(Integer id, int dia, Time inicio, Time fim) {
//        Session session = horarioAtendimentoCRUD.sf.openSession();
//        Query query = session.createSQLQuery("select * from horario_atendimento AS h where h.medico_id = ? and h.diaDaSemana=? and(? between h.inicio and h.fim or h.inicio between ? and ?)").addEntity(HorarioAtendimento.class);
//        query.setLong(0, id);
//        query.setInteger(1, dia);
//        query.setTime(2, inicio);
//        query.setTime(3, inicio);
//        query.setTime(4, fim);
//        List<HorarioAtendimento> list = (List<HorarioAtendimento>) query.list();
//        session.close();
//        return list;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create() {
        EntityManagerFactory emf = JpaFactory.getInstance();
        HorarioAtendimentoJpaController instance = new HorarioAtendimentoJpaController(emf);
        instance.create(this);
    }

    @Override
    public void read() throws NonexistentEntityException {
        EntityManagerFactory emf = JpaFactory.getInstance();
        HorarioAtendimentoJpaController instance = new HorarioAtendimentoJpaController(emf);
        try {
            instance.read(this);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(HorarioAtendimento.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public void update() {
        EntityManagerFactory emf = JpaFactory.getInstance();
        HorarioAtendimentoJpaController instance = new HorarioAtendimentoJpaController(emf);
        try {
            instance.edit(this);
        } catch (Exception ex) {
            Logger.getLogger(HorarioAtendimento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete() {
        EntityManagerFactory emf = JpaFactory.getInstance();
        HorarioAtendimentoJpaController instance = new HorarioAtendimentoJpaController(emf);
        try {
            instance.destroy(this.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(HorarioAtendimento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
