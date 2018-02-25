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
class DiaDaSemana {
    
    private int id;
    private String nome;
    
    public DiaDaSemana (int id, String nome){
        this.setId(id);
        this.setNome(nome);
    }
    
    public void setId (int id){
        this.id = id;
    }
    
    public int getId (){
        return id;
    }
    
    public void setNome (String nome){
        if("Domingo".equals(nome) || "Segunda".equals(nome) ||
                "Terça".equals(nome) || "quarta".equals(nome) || 
                "quinta".equals(nome) || "sexta".equals(nome) ||
                "sábado".equals(nome)){
            this.nome = nome;
        }
    }
    
    public String getNome (){
        return nome;
    }
    
    @Override
    public String toString (){
        return "Dia: " + nome + "\n";
    }
    
}
