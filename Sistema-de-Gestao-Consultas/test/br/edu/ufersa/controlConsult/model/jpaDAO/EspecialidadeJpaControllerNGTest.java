/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model.jpaDAO;

import br.edu.ufersa.controlConsult.model.Especialidade;
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
public class EspecialidadeJpaControllerNGTest {
    
    public EspecialidadeJpaControllerNGTest() {
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
     * Test of getEntityManager method, of class EspecialidadeJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        EspecialidadeJpaController instance = null;
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class EspecialidadeJpaController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Especialidade especialidade = null;
        EspecialidadeJpaController instance = null;
        instance.create(especialidade);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class EspecialidadeJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Especialidade especialidade = null;
        EspecialidadeJpaController instance = null;
        instance.edit(especialidade);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class EspecialidadeJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Integer id = null;
        EspecialidadeJpaController instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findEspecialidadeEntities method, of class EspecialidadeJpaController.
     */
    @Test
    public void testFindEspecialidadeEntities_0args() {
        System.out.println("findEspecialidadeEntities");
        EspecialidadeJpaController instance = null;
        List expResult = null;
        List result = instance.findEspecialidadeEntities();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findEspecialidadeEntities method, of class EspecialidadeJpaController.
     */
    @Test
    public void testFindEspecialidadeEntities_int_int() {
        System.out.println("findEspecialidadeEntities");
        int maxResults = 0;
        int firstResult = 0;
        EspecialidadeJpaController instance = null;
        List expResult = null;
        List result = instance.findEspecialidadeEntities(maxResults, firstResult);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findEspecialidade method, of class EspecialidadeJpaController.
     */
    @Test
    public void testFindEspecialidade() {
        System.out.println("findEspecialidade");
        Integer id = null;
        EspecialidadeJpaController instance = null;
        Especialidade expResult = null;
        Especialidade result = instance.findEspecialidade(id);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEspecialidadeCount method, of class EspecialidadeJpaController.
     */
    @Test
    public void testGetEspecialidadeCount() {
        System.out.println("getEspecialidadeCount");
        EspecialidadeJpaController instance = null;
        int expResult = 0;
        int result = instance.getEspecialidadeCount();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
