/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model;

import java.util.Date;
import java.util.List;
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
public class FrequenciaNGTest {
    
    public FrequenciaNGTest() {
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
     * Test of checkin method, of class Frequencia.
     */
    @Test
    public void testCheckin() {
        System.out.println("checkin");
        Frequencia instance = new Frequencia();
        instance.checkin();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkout method, of class Frequencia.
     */
    @Test
    public void testCheckout() {
        System.out.println("checkout");
        Frequencia instance = new Frequencia();
        instance.checkout();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of porMedico method, of class Frequencia.
     */
    @Test
    public void testPorMedico() {
        System.out.println("porMedico");
        Medico medico = null;
        List expResult = null;
        List result = Frequencia.porMedico(medico);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Frequencia.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Frequencia instance = new Frequencia();
        Integer expResult = null;
        Integer result = instance.getId();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Frequencia.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Integer id = null;
        Frequencia instance = new Frequencia();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMedico method, of class Frequencia.
     */
    @Test
    public void testGetMedico() {
        System.out.println("getMedico");
        Frequencia instance = new Frequencia();
        Medico expResult = null;
        Medico result = instance.getMedico();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMedico method, of class Frequencia.
     */
    @Test
    public void testSetMedico() {
        System.out.println("setMedico");
        Medico medico = null;
        Frequencia instance = new Frequencia();
        instance.setMedico(medico);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEntrada method, of class Frequencia.
     */
    @Test
    public void testGetEntrada() {
        System.out.println("getEntrada");
        Frequencia instance = new Frequencia();
        Date expResult = null;
        Date result = instance.getEntrada();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEntrada method, of class Frequencia.
     */
    @Test
    public void testSetEntrada() {
        System.out.println("setEntrada");
        Date entrada = null;
        Frequencia instance = new Frequencia();
        instance.setEntrada(entrada);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSaida method, of class Frequencia.
     */
    @Test
    public void testGetSaida() {
        System.out.println("getSaida");
        Frequencia instance = new Frequencia();
        Date expResult = null;
        Date result = instance.getSaida();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSaida method, of class Frequencia.
     */
    @Test
    public void testSetSaida() {
        System.out.println("setSaida");
        Date saida = null;
        Frequencia instance = new Frequencia();
        instance.setSaida(saida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsuario method, of class Frequencia.
     */
    @Test
    public void testGetUsuario() {
        System.out.println("getUsuario");
        Frequencia instance = new Frequencia();
        Usuario expResult = null;
        Usuario result = instance.getUsuario();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsuario method, of class Frequencia.
     */
    @Test
    public void testSetUsuario() {
        System.out.println("setUsuario");
        Usuario usuario = null;
        Frequencia instance = new Frequencia();
        instance.setUsuario(usuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData_entrada method, of class Frequencia.
     */
    @Test
    public void testGetData_entrada() {
        System.out.println("getData_entrada");
        Frequencia instance = new Frequencia();
        Date expResult = null;
        Date result = instance.getData_entrada();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setData_entrada method, of class Frequencia.
     */
    @Test
    public void testSetData_entrada() {
        System.out.println("setData_entrada");
        Date data_entrada = null;
        Frequencia instance = new Frequencia();
        instance.setData_entrada(data_entrada);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData_saida method, of class Frequencia.
     */
    @Test
    public void testGetData_saida() {
        System.out.println("getData_saida");
        Frequencia instance = new Frequencia();
        Date expResult = null;
        Date result = instance.getData_saida();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setData_saida method, of class Frequencia.
     */
    @Test
    public void testSetData_saida() {
        System.out.println("setData_saida");
        Date data_saida = null;
        Frequencia instance = new Frequencia();
        instance.setData_saida(data_saida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class Frequencia.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Frequencia instance = new Frequencia();
        instance.create();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class Frequencia.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        Frequencia instance = new Frequencia();
        instance.read();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Frequencia.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Frequencia instance = new Frequencia();
        instance.update();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class Frequencia.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Frequencia instance = new Frequencia();
        instance.delete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class Frequencia.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Frequencia f = null;
        Frequencia instance = new Frequencia();
        int expResult = 0;
        int result = instance.compareTo(f);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
