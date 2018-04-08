/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model;

import br.edu.ufersa.controlConsult.model.interfaces.ICRUD;
import br.edu.ufersa.controlConsult.model.jpaDAO.JpaFactory;
import br.edu.ufersa.controlConsult.model.jpaDAO.PessoaJpaController;
import br.edu.ufersa.controlConsult.model.jpaDAO.exceptions.NonexistentEntityException;
import br.edu.ufersa.controlConsult.model.jpaDAO.exceptions.PreexistingEntityException;
import br.edu.ufersa.controlConsult.model.validacao.Cpf_Util;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NoResultException;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author leone
 */
@Entity
@Table(name = "pessoa")
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT m FROM Pessoa m")
    , @NamedQuery(name = "Pessoa.findById", query = "SELECT m FROM Pessoa m WHERE m.id = :id")
    , @NamedQuery(name = "Pessoa.findByNome", query = "SELECT m FROM Pessoa m WHERE lower(m.nome) LIKE lower(:nome)")
    , @NamedQuery(name = "Pessoa.findByCPF", query = "SELECT m FROM Pessoa m WHERE m.cpf = :cpf")
    , @NamedQuery(name = "Pessoa.medico", query = "SELECT m FROM Pessoa m WHERE m.medico!=null")})
public class Pessoa implements Serializable, ICRUD {

    public static List<Pessoa> findAll() {
        EntityManagerFactory emf = JpaFactory.getInstance();
        PessoaJpaController instance = new PessoaJpaController(emf);
        return instance.findPessoaEntities();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome", length = 150)
    private String nome;
    @Column(name = "data_de_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataDeNascimento;
    @Column(name = "sexo")
    private Character sexo;
    @Column(name = "email", length = 75)
    private String email;
    @Column(name = "bairro", length = 75)
    private String bairro;
    @Column(name = "num_casa")
    private Integer numCasa;
    @Column(name = "logradouro", length = 75)
    private String logradouro;
    @Column(name = "cep", length = 15)
    private String cep;
    @Column(name = "telefone", length = 15)
    private String telefone;
    @Basic(optional = false)
    @Column(name = "cpf", unique = true, length = 20)
    private String cpf;
    @Column(name = "rg", unique = true, length = 20)
    private String rg;
    @Column(name = "estado", length = 50)
    private String estado;
    @Column(name = "cidade", length = 50)
    private String cidade;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "medico")
    private Medico medico;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "paciente")
    private Paciente paciente;

    protected Pessoa() {
    }

    /**
     * Construtor completo
     *
     * @throws IllegalArgumentException se algum atributo for inválido.
     */
    public Pessoa(Integer id, String nome, String cpf, String rg, String email,
            char sexo, Date dataDeNascimento, String telefone, String logradouro,
            Integer numCasa, String bairro, String cidade, String estado, String cep) throws IllegalArgumentException {
        this.setId(id);
        this.setNome(nome);
        this.setCpf(cpf);
        this.setRg(rg);
        this.setEmail(email);
        this.setSexo(sexo);
        this.setDataDeNascimento(dataDeNascimento);
        this.setTelefone(telefone);
        this.setLogradouro(logradouro);
        this.setNumCasa(numCasa);
        this.setBairro(bairro);
        this.setCidade(cidade);
        this.setEstado(estado);
        this.setCep(cep);
    }

    /**
     * Construtor sem id na assinatura.
     */
    public Pessoa(String nome, String cpf, String rg, String email,
            char sexo, Date dataDeNascimento, String telefone, String logradouro,
            int numCasa, String bairro, String cidade, String estado, String cep) throws IllegalArgumentException {
        this(null, nome, cpf, rg, email, sexo, dataDeNascimento, telefone, logradouro,
                numCasa, bairro, cidade, estado, cep);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public void setCpf(String cpf) throws IllegalArgumentException {
        if (!Cpf_Util.isCPF(cpf.replaceAll("[.-]", ""))) {
            throw new IllegalArgumentException("CPF inválido.");
        }
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
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

    public Pessoa(Integer id) {
        this.id = id;
    }

    public Pessoa(Integer id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(int numCasa) {
        this.numCasa = numCasa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[id=" + id + "]"
                + " Nome: " + this.nome + " CPF: " + this.cpf;
    }

    /**
     * Pesquisa no banco de dados a primeira entidade Médico com o CPF.
     *
     * @param cpf Cadastro de Pessoa Física.
     * @return O médico com portar o cpf.
     */
    public static Pessoa findByCPF(String cpf) throws NoResultException {
        EntityManagerFactory emf = JpaFactory.getInstance();
        PessoaJpaController instance = new PessoaJpaController(emf);
        return instance.findByCPF(cpf);
    }
    
    public static List<Pessoa> findByNome(String nome) throws NoResultException {
        EntityManagerFactory emf = JpaFactory.getInstance();
        PessoaJpaController instance = new PessoaJpaController(emf);
        return instance.findByNome(nome);
    }
    
    public static List<Pessoa> findMedicos() throws NoResultException {
        EntityManagerFactory emf = JpaFactory.getInstance();
        PessoaJpaController instance = new PessoaJpaController(emf);
        return instance.findMedicos();
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Medico getMedico() {
        return this.medico;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Paciente getPaciente() {
        return this.paciente;
    }

    @Override
    public void create() throws PreexistingEntityException, Exception {
        try {
            if (Pessoa.findByCPF(this.getCpf()) != null) {
                throw new PreexistingEntityException("CPF já registrado.");
            }
        } catch (NoResultException e) {
        }
        EntityManagerFactory emf = JpaFactory.getInstance();
        PessoaJpaController instance = new PessoaJpaController(emf);
        try {
            instance.create(this);
        } catch (Exception ex) {
            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public void read() throws EntityNotFoundException {
//        EntityManagerFactory emf = JpaFactory.getInstance();
//        PessoaJpaController instance = new PessoaJpaController(emf);
//        try {
//            instance.read(this);
//        } catch (EntityNotFoundException ex) {
//            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
//            throw ex;
//        }
    }

    @Override
    public void update() {
        EntityManagerFactory emf = JpaFactory.getInstance();
        PessoaJpaController instance = new PessoaJpaController(emf);
        try {
            instance.edit(this);
        } catch (Exception ex) {
            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete() {
        EntityManagerFactory emf = JpaFactory.getInstance();
        PessoaJpaController instance = new PessoaJpaController(emf);
        try {
            instance.destroy(this.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
