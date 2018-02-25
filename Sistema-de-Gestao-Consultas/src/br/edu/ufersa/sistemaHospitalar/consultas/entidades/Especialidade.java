/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.sistemaHospitalar.consultas.entidades;

/**
 *
 * @author cassiano
 */
public class Especialidade {
    
    private int id;
    
    private String nome;
    
    public Especialidade (int id, String nome){
        this.id = id;
        this.nome = nome;
    }
    
    public Especialidade (int id){
        this.setId(id);
        this.setNome("Clínico Geral");
    }
    
    public void setId (int id){
        this.id = id;
    }
    
    public int getId (){
        return id;
    }
    
    public void setNome (String nome){
        this.nome = nome;
    }
    
    public String getNome (){
        return nome;
    }
    
    @Override
    public String toString (){
        return "Especialidade: " + nome + "\n";
    }
    
}
