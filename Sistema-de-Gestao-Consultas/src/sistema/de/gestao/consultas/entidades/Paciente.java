/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.de.gestao.consultas.entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author leone
 */
@Entity
@Table(name="paciente")
@PrimaryKeyJoinColumn(name="id")
public class Paciente extends Pessoa{
    private String num_sus;

    public Paciente(){
        
    }
    public Paciente(Long id, String nome, String cpf, String rg, Date data_nascimento, String telefone, String cidade, String bairro, String logradouro, String cep, String num_sus) {
        super(id, nome, cpf, rg, data_nascimento, telefone, cidade, bairro, logradouro, cep);
        this.num_sus = num_sus;
    }
    
    public Paciente(String nome, String cpf, String rg, Date data_nascimento, String telefone, String cidade, String bairro, String logradouro, String cep, String num_sus) {
        super(nome, cpf, rg, data_nascimento, telefone, cidade, bairro, logradouro, cep);
        this.num_sus = num_sus;
    }

    public String getNum_sus() {
        return num_sus;
    }

    public void setNum_sus(String num_sus) {
        this.num_sus = num_sus;
    }
    
}
