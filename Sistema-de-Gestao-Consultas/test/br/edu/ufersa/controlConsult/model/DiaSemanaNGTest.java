/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model;

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
public class DiaSemanaNGTest {
    
    public DiaSemanaNGTest() {
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
     * Test of getId method, of class DiaSemana.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        DiaSemana instance = null;
        Integer expResult = null;
        Integer result = instance.getId();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class DiaSemana.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Integer id = null;
        DiaSemana instance = null;
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNome method, of class DiaSemana.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        DiaSemana instance = null;
        String expResult = "";
        String result = instance.getNome();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNome method, of class DiaSemana.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        DiaSemana instance = null;
        instance.setNome(nome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHorarioAtendimentoList method, of class DiaSemana.
     */
    @Test
    public void testGetHorarioAtendimentoList() {
        System.out.println("getHorarioAtendimentoList");
        DiaSemana instance = null;
        List expResult = null;
        List result = instance.getHorarioAtendimentoList();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHorarioAtendimentoList method, of class DiaSemana.
     */
    @Test
    public void testSetHorarioAtendimentoList() {
        System.out.println("setHorarioAtendimentoList");
        List<HorarioAtendimento> horarioAtendimentoList = null;
        DiaSemana instance = null;
        instance.setHorarioAtendimentoList(horarioAtendimentoList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class DiaSemana.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        DiaSemana instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class DiaSemana.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        DiaSemana instance = null;
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class DiaSemana.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        DiaSemana instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
