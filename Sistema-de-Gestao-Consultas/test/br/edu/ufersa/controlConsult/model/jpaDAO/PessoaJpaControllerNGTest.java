/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model.jpaDAO;

import br.edu.ufersa.controlConsult.model.Pessoa;
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
public class PessoaJpaControllerNGTest {
    
    public PessoaJpaControllerNGTest() {
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
     * Test of getEntityManager method, of class PessoaJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        PessoaJpaController instance = null;
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class PessoaJpaController.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Pessoa pessoa = null;
        PessoaJpaController instance = null;
        instance.create(pessoa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class PessoaJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Pessoa pessoa = null;
        PessoaJpaController instance = null;
        instance.edit(pessoa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class PessoaJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Integer id = null;
        PessoaJpaController instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findPessoaEntities method, of class PessoaJpaController.
     */
    @Test
    public void testFindPessoaEntities_0args() {
        System.out.println("findPessoaEntities");
        PessoaJpaController instance = null;
        List expResult = null;
        List result = instance.findPessoaEntities();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findPessoaEntities method, of class PessoaJpaController.
     */
    @Test
    public void testFindPessoaEntities_int_int() {
        System.out.println("findPessoaEntities");
        int maxResults = 0;
        int firstResult = 0;
        PessoaJpaController instance = null;
        List expResult = null;
        List result = instance.findPessoaEntities(maxResults, firstResult);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findPessoa method, of class PessoaJpaController.
     */
    @Test
    public void testFindPessoa() {
        System.out.println("findPessoa");
        Integer id = null;
        PessoaJpaController instance = null;
        Pessoa expResult = null;
        Pessoa result = instance.findPessoa(id);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPessoaCount method, of class PessoaJpaController.
     */
    @Test
    public void testGetPessoaCount() {
        System.out.println("getPessoaCount");
        PessoaJpaController instance = null;
        int expResult = 0;
        int result = instance.getPessoaCount();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByCPF method, of class PessoaJpaController.
     */
    @Test
    public void testFindByCPF() {
        System.out.println("findByCPF");
        String cpf = "";
        PessoaJpaController instance = null;
        Pessoa expResult = null;
        Pessoa result = instance.findByCPF(cpf);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
