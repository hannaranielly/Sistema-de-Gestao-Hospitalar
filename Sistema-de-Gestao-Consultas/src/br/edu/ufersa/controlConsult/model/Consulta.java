/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model;

import br.edu.ufersa.controlConsult.model.interfaces.ICRUD;
import br.edu.ufersa.controlConsult.model.jpaDAO.JpaFactory;
import br.edu.ufersa.controlConsult.model.jpaDAO.ConsultaJpaController;
import br.edu.ufersa.controlConsult.model.jpaDAO.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author juan
 */
@Entity
@Table(name = "consulta")
@NamedQueries({
    @NamedQuery(name = "Consulta.numconsultaMarcado", query = "SELECT COUNT(p.id) FROM Consulta p WHERE p.horario_atendimento = :atendimento AND p.data_agendada = :data")
    , @NamedQuery(name = "Consulta.numconsultapaciente", query = "SELECT COUNT(p.id) FROM Consulta p WHERE p.horario_atendimento = :atendimento AND p.data_agendada = :data AND p.paciente = :paciente")
    , @NamedQuery(name = "Consulta.porAtendimento", query = "SELECT p FROM Consulta p WHERE p.horario_atendimento = :atendimento AND p.data_agendada = :data AND p.data_inicio = null ORDER BY p.data_marcado")
    , @NamedQuery(name = "Consulta.porMedico", query = "SELECT p FROM Consulta p WHERE p.medico = :medico AND p.data_inicio != null")})
public class Consulta implements Serializable, ICRUD {

    public static List<Consulta> findAll() {
        EntityManagerFactory emf = JpaFactory.getInstance();
        ConsultaJpaController instance = new ConsultaJpaController(emf);
        List<Consulta> res_consultas = instance.findConsultaEntities();
        return res_consultas;
    }
    
    public static List<Consulta> findporMedico(Medico m) {
        EntityManagerFactory emf = JpaFactory.getInstance();
        ConsultaJpaController instance = new ConsultaJpaController(emf);
        List<Consulta> res_consultas = instance.findporMedico(m);
        return res_consultas;
    }

    public Date getData_marcado() {
        return data_marcado;
    }

    public void setData_marcado(Date data_marcado) {
        this.data_marcado = data_marcado;
    }

    public HorarioAtendimento getHorario_atendimento() {
        return horario_atendimento;
    }

    public void setHorario_atendimento(HorarioAtendimento horario_atendimento) {
        this.horario_atendimento = horario_atendimento;
    }
    
    public static List<Consulta> findporAtendimento(HorarioAtendimento ha, Date data){
        EntityManagerFactory emf = JpaFactory.getInstance();
         ConsultaJpaController instance = new ConsultaJpaController(emf);
         return instance.findporAtendimento(ha, data);
    }
    
    public static long numconsultaMarcado(HorarioAtendimento ha, Date data){
         EntityManagerFactory emf = JpaFactory.getInstance();
         ConsultaJpaController instance = new ConsultaJpaController(emf);
         return instance.numconsultaMarcado(ha, data);
    }
    
    public static long numconsultapaciente(HorarioAtendimento ha, Date data, Paciente paciente){
         EntityManagerFactory emf = JpaFactory.getInstance();
         ConsultaJpaController instance = new ConsultaJpaController(emf);
         return instance.numconsultapaciente(ha, data, paciente);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "agendada")
    private boolean agendada;

    @Column(name = "data_agendada")
    @Temporal(TemporalType.DATE)
    private Date data_agendada;

    @Column(name = "data_marcado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_marcado;

    @Column(name = "data_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_inicio;

    @Column(name = "data_fim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_fim;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "medico")
    private Medico medico;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "paciente")
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "horario_atendimento")
    private HorarioAtendimento horario_atendimento;

    public Consulta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isAgendada() {
        return agendada;
    }

    public void setAgendada(boolean agendada) {
        this.agendada = agendada;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getData_agendada() {
        return data_agendada;
    }

    public void setData_agendada(Date data_agendada) {
        this.data_agendada = data_agendada;
    }

    @Override
    public void create() {
        EntityManagerFactory emf = JpaFactory.getInstance();
        ConsultaJpaController instance = new ConsultaJpaController(emf);
        instance.create(this);
    }

    @Override
    public void read() throws NonexistentEntityException {
        EntityManagerFactory emf = JpaFactory.getInstance();
        ConsultaJpaController instance = new ConsultaJpaController(emf);
        try {
            instance.read(this);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public void update() throws NonexistentEntityException {
        EntityManagerFactory emf = JpaFactory.getInstance();
        ConsultaJpaController instance = new ConsultaJpaController(emf);
        try {
            instance.edit(this);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete() throws NonexistentEntityException {
        EntityManagerFactory emf = JpaFactory.getInstance();
        ConsultaJpaController instance = new ConsultaJpaController(emf);
        try {
            instance.destroy(this.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

}
