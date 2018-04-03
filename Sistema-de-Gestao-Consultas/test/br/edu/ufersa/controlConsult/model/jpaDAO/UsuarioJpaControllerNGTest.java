/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model.jpaDAO;

import br.edu.ufersa.controlConsult.model.Usuario;
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
public class UsuarioJpaControllerNGTest {
    
    public UsuarioJpaControllerNGTest() {
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
     * Test of getEntityManager method, of class UsuarioJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        UsuarioJpaController instance = null;
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class UsuarioJpaController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Usuario usuario = null;
        UsuarioJpaController instance = null;
        instance.create(usuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class UsuarioJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Usuario usuario = null;
        UsuarioJpaController instance = null;
        instance.edit(usuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class UsuarioJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Integer id = null;
        UsuarioJpaController instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findUsuarioEntities method, of class UsuarioJpaController.
     */
    @Test
    public void testFindUsuarioEntities_0args() {
        System.out.println("findUsuarioEntities");
        UsuarioJpaController instance = null;
        List expResult = null;
        List result = instance.findUsuarioEntities();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findUsuarioEntities method, of class UsuarioJpaController.
     */
    @Test
    public void testFindUsuarioEntities_int_int() {
        System.out.println("findUsuarioEntities");
        int maxResults = 0;
        int firstResult = 0;
        UsuarioJpaController instance = null;
        List expResult = null;
        List result = instance.findUsuarioEntities(maxResults, firstResult);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findUsuario method, of class UsuarioJpaController.
     */
    @Test
    public void testFindUsuario() {
        System.out.println("findUsuario");
        Integer id = null;
        UsuarioJpaController instance = null;
        Usuario expResult = null;
        Usuario result = instance.findUsuario(id);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsuarioCount method, of class UsuarioJpaController.
     */
    @Test
    public void testGetUsuarioCount() {
        System.out.println("getUsuarioCount");
        UsuarioJpaController instance = null;
        int expResult = 0;
        int result = instance.getUsuarioCount();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class UsuarioJpaController.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        Usuario aThis = null;
        UsuarioJpaController instance = null;
        boolean expResult = false;
        boolean result = instance.login(aThis);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class UsuarioJpaController.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        Usuario usuario = null;
        UsuarioJpaController instance = null;
        instance.read(usuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
