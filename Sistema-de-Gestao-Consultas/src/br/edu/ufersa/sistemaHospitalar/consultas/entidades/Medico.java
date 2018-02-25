/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.sistemaHospitalar.consultas.entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author cassiano
 */
public class Medico extends Pessoa implements ICRUD {
    
    private HorarioAtendimento[] listaHorario;
    private int cargaHoraria;
    private Especialidade especialidade;
    
    public Medico (Pessoa pessoa, HorarioAtendimento[] listaHorario, 
            int cargaHoraria, Especialidade especialidade){
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
    
    public void setListaHorario (HorarioAtendimento[] listaHorario){
        this.listaHorario = listaHorario;
    }
    
    public HorarioAtendimento[] getListaHorario (){
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
    
    public void setEspecialidade (Especialidade especialidade){
        this.especialidade = especialidade;
    }
    
    public Especialidade getEspecialidade (){
        return especialidade;
    }
    
}
