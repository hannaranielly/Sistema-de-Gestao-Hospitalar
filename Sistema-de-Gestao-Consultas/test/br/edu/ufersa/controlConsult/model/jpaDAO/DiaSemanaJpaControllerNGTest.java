/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model.jpaDAO;

import br.edu.ufersa.controlConsult.model.DiaSemana;
import java.util.List;
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
public class DiaSemanaJpaControllerNGTest {
    
    public DiaSemanaJpaControllerNGTest() {
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
     * Test of getEntityManager method, of class DiaSemanaJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        DiaSemanaJpaController instance = null;
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class DiaSemanaJpaController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        DiaSemana diaSemana = null;
        DiaSemanaJpaController instance = null;
        instance.create(diaSemana);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class DiaSemanaJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        DiaSemana diaSemana = null;
        DiaSemanaJpaController instance = null;
        instance.edit(diaSemana);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class DiaSemanaJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Integer id = null;
        DiaSemanaJpaController instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findDiaSemanaEntities method, of class DiaSemanaJpaController.
     */
    @Test
    public void testFindDiaSemanaEntities_0args() {
        System.out.println("findDiaSemanaEntities");
        DiaSemanaJpaController instance = null;
        List expResult = null;
        List result = instance.findDiaSemanaEntities();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findDiaSemanaEntities method, of class DiaSemanaJpaController.
     */
    @Test
    public void testFindDiaSemanaEntities_int_int() {
        System.out.println("findDiaSemanaEntities");
        int maxResults = 0;
        int firstResult = 0;
        DiaSemanaJpaController instance = null;
        List expResult = null;
        List result = instance.findDiaSemanaEntities(maxResults, firstResult);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findDiaSemana method, of class DiaSemanaJpaController.
     */
    @Test
    public void testFindDiaSemana() {
        System.out.println("findDiaSemana");
        Integer id = null;
        DiaSemanaJpaController instance = null;
        DiaSemana expResult = null;
        DiaSemana result = instance.findDiaSemana(id);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDiaSemanaCount method, of class DiaSemanaJpaController.
     */
    @Test
    public void testGetDiaSemanaCount() {
        System.out.println("getDiaSemanaCount");
        DiaSemanaJpaController instance = null;
        int expResult = 0;
        int result = instance.getDiaSemanaCount();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
