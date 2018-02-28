/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author leone
 */
@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Long id;
    @Column
    private String nome;
    @Column(unique = true)
    private String cpf;
    @Column
    private String rg;
    @Column
    private Date data_nascimento;
    @Column
    private String telefone;
    @Column
    private String cidade;
    @Column
    private String bairro;
    @Column
    private String logradouro;
    @Column
    private String cep;

    public Pessoa(){
        
    }
    
    protected Pessoa(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(), pessoa.getCpf(), pessoa.getRg(),
                pessoa.getData_nascimento(), pessoa.getTelefone(), pessoa.getCidade(),
                pessoa.getBairro(), pessoa.getLogradouro(),
                pessoa.getCep());
    }

    public Pessoa(Long id, String nome, String cpf, String rg,
            Date data_nascimento, String telefone, String cidade, String bairro,
            String logradouro, String cep) {
        this.setId(id);
        this.setNome(nome);
        this.setCpf(cpf);
        this.setRg(rg);
        this.setData_nascimento(data_nascimento);
        this.setTelefone(telefone);
        this.setCidade(cidade);
        this.setBairro(bairro);
        this.setLogradouro(logradouro);
        this.setCep(cep);
    }

    public Pessoa(String nome, String cpf, String rg,
            Date data_nascimento, String telefone,
            String cidade, String bairro,
            String logradouro, String cep) {
        this(null, nome, cpf, rg, data_nascimento, telefone, cidade, bairro, logradouro, cep);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

}
