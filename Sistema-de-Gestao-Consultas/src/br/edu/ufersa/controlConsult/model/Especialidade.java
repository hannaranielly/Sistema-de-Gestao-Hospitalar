/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model;

import br.edu.ufersa.controlConsult.model.interfaces.ICRUD;
import br.edu.ufersa.controlConsult.model.jpaDAO.EspecialidadeJpaController;
import br.edu.ufersa.controlConsult.model.jpaDAO.JpaFactory;
import br.edu.ufersa.controlConsult.model.jpaDAO.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juan
 */
@Entity
@Table(name = "especialidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especialidade.findAll", query = "SELECT e FROM Especialidade e")
    , @NamedQuery(name = "Especialidade.findById", query = "SELECT e FROM Especialidade e WHERE e.id = :id")
    , @NamedQuery(name = "Especialidade.findByNome", query = "SELECT e FROM Especialidade e WHERE e.nome = :nome")})
public class Especialidade implements ICRUD, Serializable {

    private static final long serialVersionUID = 1L;

    public static List<Especialidade> findAll() {
        EntityManagerFactory emf = JpaFactory.getInstance();
        EspecialidadeJpaController instance = new EspecialidadeJpaController(emf);
        return instance.findEspecialidadeEntities();
    }

    public static List<Especialidade> setupEspecialidades() {
        List<Especialidade> bd_especialidades = Arrays.asList(
                new Especialidade("Acupuntura"),
                new Especialidade("Alergia e imunologia"),
                new Especialidade("Anestesiologia"),
                new Especialidade("Angiologia"),
                new Especialidade("Cancerologia"),
                new Especialidade("Cardiologia"),
                new Especialidade("Cirurgia cardiovascular"),
                new Especialidade("Cirurgia da mão"),
                new Especialidade("Cirurgia de cabeça e pescoço"),
                new Especialidade("Cirurgia do aparelho digestivo"),
                new Especialidade("Cirurgia geral"),
                new Especialidade("Cirurgia pediátrica"),
                new Especialidade("Cirurgia plástica"),
                new Especialidade("Cirurgia torácica"),
                new Especialidade("Cirurgia vascular"),
                new Especialidade("Clínica médica"),
                new Especialidade("Coloproctologia"),
                new Especialidade("Dermatologia"),
                new Especialidade("Endocrinologia e metabologia"),
                new Especialidade("Endoscopia"),
                new Especialidade("Gastroenterologia"),
                new Especialidade("Genética médica "),
                new Especialidade("Geriatria "),
                new Especialidade("Ginecologia e obstetrícia"),
                new Especialidade("Hematologia e hemoterapia"),
                new Especialidade("Homeopatia"),
                new Especialidade("Infectologia"),
                new Especialidade("Mastologia "),
                new Especialidade("Medicina de emergência"),
                new Especialidade("Medicina de família e comunidade"),
                new Especialidade("Medicina do trabalho"),
                new Especialidade("Medicina de tráfego"),
                new Especialidade("Medicina esportiva"),
                new Especialidade("Medicina física e reabilitação"),
                new Especialidade("Medicina intensiva"),
                new Especialidade("Medicina legal e perícia médica"),
                new Especialidade("Medicina nuclear"),
                new Especialidade("Medicina preventiva e social"),
                new Especialidade("Nefrologia"),
                new Especialidade("Neurocirurgia"),
                new Especialidade("Neurologia"),
                new Especialidade("Nutrologia"),
                new Especialidade("Oftalmologia"),
                new Especialidade("Ortopedia e traumatologia"),
                new Especialidade("Otorrinolaringologia"),
                new Especialidade("Patologia"),
                new Especialidade("Patologia clínica/medicina laboratorial"),
                new Especialidade("Pediatria"),
                new Especialidade("Pneumologia"),
                new Especialidade("Psiquiatria"),
                new Especialidade("Radiologia e diagnóstico por imagem"),
                new Especialidade("Radioterapia"),
                new Especialidade("Reumatologia"),
                new Especialidade("Urologia")
        );
        bd_especialidades.forEach(e -> e.create());
        return bd_especialidades;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome", unique = true)
    private String nome;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, mappedBy = "especialidade", fetch = FetchType.EAGER)
    private List<Medico> medicoList;

    public Especialidade() {
    }

    public Especialidade(String nome, List<Medico> medicoList) {
        this.setNome(nome);
        this.setMedicoList(medicoList);
    }

    public Especialidade(String nome) {
        this(nome, null);
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

    @XmlTransient
    public List<Medico> getMedicoList() {
        return medicoList;
    }

    public void setMedicoList(List<Medico> medicoList) {
        this.medicoList = medicoList;
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
        if (!(object instanceof Especialidade)) {
            return false;
        }
        Especialidade other = (Especialidade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getNome();
    }

    public static List<Especialidade> findByName(String name) {
        new UnsupportedOperationException("Unsupported operation."); //TODO To change body of generated methods, choose Tools | Templates.
        return null;
    }

    public static List<Especialidade> findByNome(String nome) {
        EntityManagerFactory emf = JpaFactory.getInstance();
        EspecialidadeJpaController instance = new EspecialidadeJpaController(emf);
        return instance.findByNome(nome);
    }

    @Override
    public void create() {
        EntityManagerFactory emf = JpaFactory.getInstance();
        EspecialidadeJpaController instance = new EspecialidadeJpaController(emf);
        instance.create(this);
    }

    @Override
    public void read() throws NonexistentEntityException {
        EntityManagerFactory emf = JpaFactory.getInstance();
        EspecialidadeJpaController instance = new EspecialidadeJpaController(emf);
        try {
            instance.read(this);

        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Especialidade.class
                    .getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public void update() throws NonexistentEntityException {
        EntityManagerFactory emf = JpaFactory.getInstance();
        EspecialidadeJpaController instance = new EspecialidadeJpaController(emf);
        try {
            instance.edit(this);

        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Especialidade.class
                    .getName()).log(Level.SEVERE, null, ex);
            throw ex;

        } catch (Exception ex) {
            Logger.getLogger(Especialidade.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete() throws NonexistentEntityException {
        EntityManagerFactory emf = JpaFactory.getInstance();
        EspecialidadeJpaController instance = new EspecialidadeJpaController(emf);
        try {
            instance.destroy(this.getId());

        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Especialidade.class
                    .getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
}
