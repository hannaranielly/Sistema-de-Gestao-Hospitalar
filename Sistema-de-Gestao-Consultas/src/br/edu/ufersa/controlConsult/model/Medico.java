/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author cassiano
 */
@Entity
@Table(name = "medico")
@PrimaryKeyJoinColumn(name = "id")
public class Medico extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "carga_horaria")
    private Integer cargaHoraria;
    @JoinColumn(name = "especialidade", referencedColumnName = "id")
    @ManyToOne
    private Especialidade especialidade;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Pessoa pessoa;
    @OneToMany(mappedBy = "medico", targetEntity = HorarioAtendimento.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<HorarioAtendimento> listaHorario;

    public Medico(Pessoa pessoa, List<HorarioAtendimento> listaHorario,
            Integer cargaHoraria, Especialidade especialidade) {
        super(pessoa);
        this.setListaHorario(listaHorario);
        this.setCargaHoraria(cargaHoraria);
        this.setEspecialidade(especialidade);
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
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
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ufersa.controlConsult.model.Medico[ id=" + id + " ]";
    }

}
