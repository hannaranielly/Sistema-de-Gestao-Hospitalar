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

    public JpaFactory() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sistema-postgre_heroku");
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
        new JpaFactory();
    }
}
