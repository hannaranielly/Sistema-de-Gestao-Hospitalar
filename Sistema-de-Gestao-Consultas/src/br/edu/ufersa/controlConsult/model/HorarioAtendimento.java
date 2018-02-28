/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author cassiano
 */
@Entity
@Table(name = "horario_atendimento")
public class HorarioAtendimento implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private Time inicio;
    private Time fim;
    private int estado;
    private Date ultimaRealizacao;
    private int diaDaSemana;
    @ManyToOne
    @JoinColumn(name="medico_id")
    private Medico medico;

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
    public HorarioAtendimento (int id, Time inicio, Time fim, 
            int estado, Date ultimaRealizacao, int diaDaSemana ){
        this.setId(id);
        this.setInicio(inicio);
        this.setFim(fim);
        this.setEstado(estado);
        this.setUltimaRealizacao(ultimaRealizacao);
        this.setDiaDaSemana(diaDaSemana);
    }
    
    public HorarioAtendimento (){
        
    }
    
    public void setId (int id){
        this.id = id;
    }
    
    public int getId (){
        return id;
    }
    
    public void setInicio (Time inicio){
        this.inicio = inicio;
    }
    
    public Time getInicio (){
        return inicio;
    }
    
    public void setFim (Time fim){
        this.fim = fim;
    }
    
    public Time getFim (){
        return fim;
    }
    
    public void setEstado (int estado){
        this.estado = estado;
    }
    
    public int getEstado (){
        return estado;
    }
    
    public void setUltimaRealizacao (Date ultimaRealizacao){
        this.ultimaRealizacao = ultimaRealizacao;
    }
    
    public Date getUltimaRealizacao (){
        return ultimaRealizacao;
    }
    
    public void setDiaDaSemana (int diaDaSemana){
        this.diaDaSemana = diaDaSemana;
    }
    
    public int getDiaDaSemana (){
        return diaDaSemana;
    }
    
    @Override
    public String toString (){
        return "Inicio: " + inicio + "\n" 
                + "Fim: " + fim + "\n" 
                + "Estado: " + estado + "\n"
                + "Ultima realização: " + ultimaRealizacao + "\n"
                + "Dia da semana: " + diaDaSemana + "\n";
    }
    
}
