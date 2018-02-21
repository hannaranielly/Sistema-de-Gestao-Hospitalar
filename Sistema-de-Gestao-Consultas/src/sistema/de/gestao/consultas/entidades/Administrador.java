/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.de.gestao.consultas.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sistema.de.gestao.consultas.bd.HibernateUtil;

/**
 *
 * @author jeffe
 */
@Entity
@Table(name="administrador")
public class Administrador implements Serializable{
    @Id
    private int id;
    public String senha;
    public String user;  
    
    public Administrador() {
        
    }
    
    public Administrador(String user, String senha){
        this.user = user;
        this.senha = senha;
    }
    
    public boolean validaLogin(){
        if(user.equals("admin")&&senha.equals("admin")){
            return true;
        }
        else{
            return false;
        }
    }
    public void registraEntrada(String medico, Date horario){
        
    }
    public void registraSaida(String medico, Date horario){
        
    }
    public void agendaConsulta(String paciente, Date horarioAtendimento, Date data){
        
    }
    public void iniciaAtendimento(Date horarioAtendimento){
        
    }
    public void proximoAtendimento(Date horarioAtendimento){
        
    }
    public void finalizaAtendimento(Date horarioAtendimento){
        
    }
    public void verificaAtendimento(String medico){
        
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
