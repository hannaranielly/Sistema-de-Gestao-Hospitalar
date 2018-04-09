/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model;

import br.edu.ufersa.controlConsult.model.interfaces.ICRUD;
import br.edu.ufersa.controlConsult.model.jpaDAO.FrequenciaJpaController;
import br.edu.ufersa.controlConsult.model.jpaDAO.JpaFactory;
import br.edu.ufersa.controlConsult.model.jpaDAO.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author juan
 */
@Entity
@Table(name = "frequencia")
public class Frequencia implements Serializable, ICRUD, Comparable<Frequencia> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_entrada", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_entrada;

    @Column(name = "data_saida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_saida;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "usuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "medico")
    private Medico medico;

    public Frequencia() {
    }
    
    public Frequencia(Medico medico) {
        this.setMedico(medico);
    }

    public Frequencia(Medico medico, Usuario usuario) {
        this.setMedico(medico);
        this.setUsuario(usuario);
    }

    public void checkin() {
        Date entrada = new Date(System.currentTimeMillis());
        this.setData_entrada(entrada);
    }

    public void checkout() {
        Date saida = new Date(System.currentTimeMillis());
        this.setData_saida(saida);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Date getEntrada() {
        return data_entrada;
    }

    public void setEntrada(Date entrada) {
        this.data_entrada = entrada;
    }

    public Date getSaida() {
        return data_saida;
    }

    public void setSaida(Date saida) {
        this.data_saida = saida;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    public Date getData_saida() {
        return data_saida;
    }

    public void setData_saida(Date data_saida) {
        this.data_saida = data_saida;
    }

    @Override
    public void create() {
        EntityManagerFactory emf = JpaFactory.getInstance();
        FrequenciaJpaController instance = new FrequenciaJpaController(emf);
        instance.create(this);
    }

    @Override
    public void read() throws NonexistentEntityException {
        EntityManagerFactory emf = JpaFactory.getInstance();
        FrequenciaJpaController instance = new FrequenciaJpaController(emf);
        try {
            instance.read(this);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Frequencia.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public void update() throws NonexistentEntityException {
        EntityManagerFactory emf = JpaFactory.getInstance();
        FrequenciaJpaController instance = new FrequenciaJpaController(emf);
        try {
            instance.edit(this);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Frequencia.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(Frequencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete() throws NonexistentEntityException {
        EntityManagerFactory emf = JpaFactory.getInstance();
        FrequenciaJpaController instance = new FrequenciaJpaController(emf);
        try {
            instance.destroy(this.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Frequencia.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public int compareTo(Frequencia f) {
        return Long.compare(this.getId(), f.getId());
    }

}
