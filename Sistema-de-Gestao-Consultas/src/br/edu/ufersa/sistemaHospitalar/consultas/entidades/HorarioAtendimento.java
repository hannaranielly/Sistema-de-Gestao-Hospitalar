/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.sistemaHospitalar.consultas.entidades;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author cassiano
 */
public class HorarioAtendimento {
    
    private int id;
    private Time inicio;
    private Time fim;
    private int estado;
    private Date ultimaRealizacao;
    private DiaDaSemana diaDaSemana;
    
    public HorarioAtendimento (int id, Time inicio, Time fim, 
            int estado, Date ultimaRealizacao, DiaDaSemana diaDaSemana ){
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
    
    public void setDiaDaSemana (DiaDaSemana diaDaSemana){
        this.diaDaSemana = diaDaSemana;
    }
    
    public DiaDaSemana getDiaDaSemana (){
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
