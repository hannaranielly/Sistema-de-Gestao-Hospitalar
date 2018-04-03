/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model.jpaDAO;

import br.edu.ufersa.controlConsult.model.Paciente;
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
public class PacienteJpaControllerNGTest {
    
    public PacienteJpaControllerNGTest() {
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
     * Test of getEntityManager method, of class PacienteJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        PacienteJpaController instance = null;
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class PacienteJpaController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Paciente paciente = null;
        PacienteJpaController instance = null;
        instance.create(paciente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class PacienteJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Paciente paciente = null;
        PacienteJpaController instance = null;
        instance.edit(paciente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class PacienteJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Integer id = null;
        PacienteJpaController instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findPacienteEntities method, of class PacienteJpaController.
     */
    @Test
    public void testFindPacienteEntities_0args() {
        System.out.println("findPacienteEntities");
        PacienteJpaController instance = null;
        List expResult = null;
        List result = instance.findPacienteEntities();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findPacienteEntities method, of class PacienteJpaController.
     */
    @Test
    public void testFindPacienteEntities_int_int() {
        System.out.println("findPacienteEntities");
        int maxResults = 0;
        int firstResult = 0;
        PacienteJpaController instance = null;
        List expResult = null;
        List result = instance.findPacienteEntities(maxResults, firstResult);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findPaciente method, of class PacienteJpaController.
     */
    @Test
    public void testFindPaciente() {
        System.out.println("findPaciente");
        Integer id = null;
        PacienteJpaController instance = null;
        Paciente expResult = null;
        Paciente result = instance.findPaciente(id);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPacienteCount method, of class PacienteJpaController.
     */
    @Test
    public void testGetPacienteCount() {
        System.out.println("getPacienteCount");
        PacienteJpaController instance = null;
        int expResult = 0;
        int result = instance.getPacienteCount();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class PacienteJpaController.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        Paciente paciente = null;
        PacienteJpaController instance = null;
        instance.read(paciente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
