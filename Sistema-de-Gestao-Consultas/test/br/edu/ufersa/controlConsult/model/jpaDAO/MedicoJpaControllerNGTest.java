/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model.jpaDAO;

import br.edu.ufersa.controlConsult.model.Medico;
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
public class MedicoJpaControllerNGTest {
    
    public MedicoJpaControllerNGTest() {
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
     * Test of getEntityManager method, of class MedicoJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        MedicoJpaController instance = null;
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class MedicoJpaController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Medico medico = null;
        MedicoJpaController instance = null;
        instance.create(medico);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class MedicoJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Medico medico = null;
        MedicoJpaController instance = null;
        instance.edit(medico);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class MedicoJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Integer id = null;
        MedicoJpaController instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findMedicoEntities method, of class MedicoJpaController.
     */
    @Test
    public void testFindMedicoEntities_0args() {
        System.out.println("findMedicoEntities");
        MedicoJpaController instance = null;
        List expResult = null;
        List result = instance.findMedicoEntities();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findMedicoEntities method, of class MedicoJpaController.
     */
    @Test
    public void testFindMedicoEntities_int_int() {
        System.out.println("findMedicoEntities");
        int maxResults = 0;
        int firstResult = 0;
        MedicoJpaController instance = null;
        List expResult = null;
        List result = instance.findMedicoEntities(maxResults, firstResult);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findMedico method, of class MedicoJpaController.
     */
    @Test
    public void testFindMedico() {
        System.out.println("findMedico");
        Integer id = null;
        MedicoJpaController instance = null;
        Medico expResult = null;
        Medico result = instance.findMedico(id);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMedicoCount method, of class MedicoJpaController.
     */
    @Test
    public void testGetMedicoCount() {
        System.out.println("getMedicoCount");
        MedicoJpaController instance = null;
        int expResult = 0;
        int result = instance.getMedicoCount();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
