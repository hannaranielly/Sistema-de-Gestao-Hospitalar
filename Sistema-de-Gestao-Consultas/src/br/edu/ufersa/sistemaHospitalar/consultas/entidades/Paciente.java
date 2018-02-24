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
 * @author leone
 */
@Entity
@Table(name = "paciente")
@PrimaryKeyJoinColumn(name = "id")
public class Paciente extends Pessoa implements ICRUD {

    private String num_sus;

    public Paciente(Pessoa pessoa, String num_sus) {
        super(pessoa);
        this.setNum_sus(num_sus);
    }
    public Paciente(){
        
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

    //* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    //* * * * * * * * * * * Getters and Setters * * * * * * * * * * * * * * * *
    //* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    public String getNum_sus() {
        return num_sus;
    }

    public void setNum_sus(String num_sus) {
        this.num_sus = num_sus;
    }

}
