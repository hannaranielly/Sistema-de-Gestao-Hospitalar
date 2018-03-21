/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model;

import br.edu.ufersa.controlConsult.model.interfaces.ICRUD;
import br.edu.ufersa.controlConsult.model.jpaDAO.JpaFactory;
import br.edu.ufersa.controlConsult.model.jpaDAO.MedicoJpaController;
import br.edu.ufersa.controlConsult.model.jpaDAO.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author cassiano
 */
@Entity
@DiscriminatorValue("Medico")
@NamedQueries({
    @NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m")
    , @NamedQuery(name = "Medico.findById", query = "SELECT m FROM Medico m WHERE m.id = :id")
    , @NamedQuery(name = "Medico.findByNome", query = "SELECT m FROM Medico m WHERE m.nome = :nome")
    , @NamedQuery(name = "Medico.findByCPF", query = "SELECT m FROM Medico m WHERE m.cpf = :cpf")})

public class Medico extends Pessoa implements ICRUD {

    @Column(name = "carga_horaria")
    private Integer cargaHoraria;

    @JoinColumn(name = "especialidade", referencedColumnName = "id")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private Especialidade especialidade;

    @ManyToMany(fetch = FetchType.EAGER)
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

    /**
     * Pesquisa no banco de dados a primeira entidade Médico com o CPF.
     *
     * @param cpf Cadastro de Pessoa Física.
     * @return O médico com portar o cpf.
     */
    public static Medico findByCPF(String cpf) {
        EntityManagerFactory emf = JpaFactory.getInstance();
        MedicoJpaController instance = new MedicoJpaController(emf);
        return instance.findByCPF(cpf);
    }

    @Override
    public void create() {
        EntityManagerFactory emf = JpaFactory.getInstance();
        MedicoJpaController instance = new MedicoJpaController(emf);
        instance.create(this);
    }

    @Override
    public void read() throws EntityNotFoundException {
        EntityManagerFactory emf = JpaFactory.getInstance();
        MedicoJpaController instance = new MedicoJpaController(emf);
        try {
            instance.read(this);
        } catch (EntityNotFoundException ex) {
            Logger.getLogger(Medico.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public void update() {
        EntityManagerFactory emf = JpaFactory.getInstance();
        MedicoJpaController instance = new MedicoJpaController(emf);
        try {
            instance.edit(this);
        } catch (Exception ex) {
            Logger.getLogger(Medico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete() {
        EntityManagerFactory emf = JpaFactory.getInstance();
        MedicoJpaController instance = new MedicoJpaController(emf);
        try {
            instance.destroy(this.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Medico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
