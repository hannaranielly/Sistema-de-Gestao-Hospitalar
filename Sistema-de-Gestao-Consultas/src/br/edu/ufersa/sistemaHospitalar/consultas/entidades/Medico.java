/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.sistemaHospitalar.consultas.entidades;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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
public class Medico extends Pessoa implements ICRUD {
    @OneToMany(mappedBy = "medico", targetEntity = HorarioAtendimento.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<HorarioAtendimento> listaHorario;
    @Column
    private int cargaHoraria;
    private int especialidade;
    public Medico(){
        
    }
    public Medico (Pessoa pessoa, List<HorarioAtendimento>  listaHorario, 
            int cargaHoraria, int especialidade){
        super(pessoa);
        this.setListaHorario(listaHorario);
        this.setCargaHoraria(cargaHoraria);
        this.setEspecialidade(especialidade);
    }
    
    @Override
    public void create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
    public void setListaHorario (List<HorarioAtendimento> listaHorario){
        this.listaHorario = listaHorario;
    }
    
    public List<HorarioAtendimento>  getListaHorario (){
        return listaHorario;
    }
    
    public void setCargaHoraria (int cargaHoraria){
        if(cargaHoraria <= 60 && cargaHoraria > 0){
            this.cargaHoraria = cargaHoraria;
        }
    }
    
    public int getCargaHoraria (){
        return cargaHoraria;
    }
    
    public void setEspecialidade (int especialidade){
        this.especialidade = especialidade;
    }
    
    public int getEspecialidade (){
        return especialidade;
    }
    
}
