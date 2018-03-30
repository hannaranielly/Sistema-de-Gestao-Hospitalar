package br.edu.ufersa.controlConsult.model.interfaces;

import br.edu.ufersa.controlConsult.model.jpaDAO.exceptions.NonexistentEntityException;
import br.edu.ufersa.controlConsult.model.jpaDAO.exceptions.PreexistingEntityException;

/**
 * Especificação do CRUD (Create, Remove, Update e Delete)
 *
 * @author juan
 */
public interface ICRUD {

    void create() throws PreexistingEntityException;

    void read() throws NonexistentEntityException;

    void update() throws NonexistentEntityException;

    void delete() throws NonexistentEntityException;

}
