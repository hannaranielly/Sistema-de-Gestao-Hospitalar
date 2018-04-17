/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model.jpaDAO;

import br.edu.ufersa.controlConsult.model.Frequencia;
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
public class FrequenciaJpaControllerNGTest {
    
    public FrequenciaJpaControllerNGTest() {
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
     * Test of getEntityManager method, of class FrequenciaJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        FrequenciaJpaController instance = null;
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class FrequenciaJpaController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Frequencia frequencia = null;
        FrequenciaJpaController instance = null;
        instance.create(frequencia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class FrequenciaJpaController.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        Frequencia frequencia = null;
        FrequenciaJpaController instance = null;
        instance.read(frequencia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class FrequenciaJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Frequencia frequencia = null;
        FrequenciaJpaController instance = null;
        instance.edit(frequencia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class FrequenciaJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Integer id = null;
        FrequenciaJpaController instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findFrequenciaEntities method, of class FrequenciaJpaController.
     */
    @Test
    public void testFindFrequenciaEntities_0args() {
        System.out.println("findFrequenciaEntities");
        FrequenciaJpaController instance = null;
        List expResult = null;
        List result = instance.findFrequenciaEntities();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findFrequenciaEntities method, of class FrequenciaJpaController.
     */
    @Test
    public void testFindFrequenciaEntities_int_int() {
        System.out.println("findFrequenciaEntities");
        int maxResults = 0;
        int firstResult = 0;
        FrequenciaJpaController instance = null;
        List expResult = null;
        List result = instance.findFrequenciaEntities(maxResults, firstResult);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findFrequencia method, of class FrequenciaJpaController.
     */
    @Test
    public void testFindFrequencia() {
        System.out.println("findFrequencia");
        Integer id = null;
        FrequenciaJpaController instance = null;
        Frequencia expResult = null;
        Frequencia result = instance.findFrequencia(id);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFrequenciaCount method, of class FrequenciaJpaController.
     */
    @Test
    public void testGetFrequenciaCount() {
        System.out.println("getFrequenciaCount");
        FrequenciaJpaController instance = null;
        int expResult = 0;
        int result = instance.getFrequenciaCount();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findPorMedico method, of class FrequenciaJpaController.
     */
    @Test
    public void testFindPorMedico() {
        System.out.println("findPorMedico");
        Medico medico = null;
        FrequenciaJpaController instance = null;
        List expResult = null;
        List result = instance.findPorMedico(medico);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
