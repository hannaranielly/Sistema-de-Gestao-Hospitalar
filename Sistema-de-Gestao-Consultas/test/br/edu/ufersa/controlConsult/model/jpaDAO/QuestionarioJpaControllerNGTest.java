/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model.jpaDAO;

import br.edu.ufersa.controlConsult.model.Medico;
import br.edu.ufersa.controlConsult.model.Questionario;
import javax.persistence.EntityManager;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author juan
 */
public class QuestionarioJpaControllerNGTest {
    
    public QuestionarioJpaControllerNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of getEntityManager method, of class QuestionarioJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        QuestionarioJpaController instance = null;
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class QuestionarioJpaController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Questionario questionario = null;
        QuestionarioJpaController instance = null;
        instance.create(questionario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mediaQ method, of class QuestionarioJpaController.
     */
    @Test
    public void testMediaQ() {
        System.out.println("mediaQ");
        Medico medico = null;
        String num = "";
        QuestionarioJpaController instance = null;
        double expResult = 0.0;
        double result = instance.mediaQ(medico, num);
        assertEquals(result, expResult, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
