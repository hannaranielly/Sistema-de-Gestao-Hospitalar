/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model.jpaDAO;

import br.edu.ufersa.controlConsult.model.HorarioAtendimento;
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
public class HorarioAtendimentoJpaControllerNGTest {
    
    public HorarioAtendimentoJpaControllerNGTest() {
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
     * Test of getEntityManager method, of class HorarioAtendimentoJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        HorarioAtendimentoJpaController instance = null;
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class HorarioAtendimentoJpaController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        HorarioAtendimento horarioAtendimento = null;
        HorarioAtendimentoJpaController instance = null;
        instance.create(horarioAtendimento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class HorarioAtendimentoJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        HorarioAtendimento horarioAtendimento = null;
        HorarioAtendimentoJpaController instance = null;
        instance.edit(horarioAtendimento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class HorarioAtendimentoJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Integer id = null;
        HorarioAtendimentoJpaController instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findHorarioAtendimentoEntities method, of class HorarioAtendimentoJpaController.
     */
    @Test
    public void testFindHorarioAtendimentoEntities_0args() {
        System.out.println("findHorarioAtendimentoEntities");
        HorarioAtendimentoJpaController instance = null;
        List expResult = null;
        List result = instance.findHorarioAtendimentoEntities();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findHorarioAtendimentoEntities method, of class HorarioAtendimentoJpaController.
     */
    @Test
    public void testFindHorarioAtendimentoEntities_int_int() {
        System.out.println("findHorarioAtendimentoEntities");
        int maxResults = 0;
        int firstResult = 0;
        HorarioAtendimentoJpaController instance = null;
        List expResult = null;
        List result = instance.findHorarioAtendimentoEntities(maxResults, firstResult);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findHorarioAtendimento method, of class HorarioAtendimentoJpaController.
     */
    @Test
    public void testFindHorarioAtendimento() {
        System.out.println("findHorarioAtendimento");
        Integer id = null;
        HorarioAtendimentoJpaController instance = null;
        HorarioAtendimento expResult = null;
        HorarioAtendimento result = instance.findHorarioAtendimento(id);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHorarioAtendimentoCount method, of class HorarioAtendimentoJpaController.
     */
    @Test
    public void testGetHorarioAtendimentoCount() {
        System.out.println("getHorarioAtendimentoCount");
        HorarioAtendimentoJpaController instance = null;
        int expResult = 0;
        int result = instance.getHorarioAtendimentoCount();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
