/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model.jpaDAO;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author juan
 */
public class JpaFactory {

    private static EntityManagerFactory instance;
    private static String persistence_unit = "sistema_postgre";

    public static EntityManagerFactory getInstance() {
        if (instance == null) {
            instance = Persistence.createEntityManagerFactory(persistence_unit);
        }
        return instance;
    }
}
