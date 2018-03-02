/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model;

import java.sql.Time;
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
public class HorarioAtendimentoNGTest {
    
    public HorarioAtendimentoNGTest() {
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
     * Test of setInicio method, of class HorarioAtendimento.
     */
    @Test
    public void testSetInicio_Time() {
        System.out.println("setInicio");
        Time inicio = null;
        HorarioAtendimento instance = null;
        instance.setInicio(inicio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFim method, of class HorarioAtendimento.
     */
    @Test
    public void testSetFim_Time() {
        System.out.println("setFim");
        Time fim = null;
        HorarioAtendimento instance = null;
        instance.setFim(fim);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class HorarioAtendimento.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        int estado = 0;
        HorarioAtendimento instance = null;
        instance.setEstado(estado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstado method, of class HorarioAtendimento.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        HorarioAtendimento instance = null;
        int expResult = 0;
        int result = instance.getEstado();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUltimaRealizacao method, of class HorarioAtendimento.
     */
    @Test
    public void testSetUltimaRealizacao() {
        System.out.println("setUltimaRealizacao");
        Date ultimaRealizacao = null;
        HorarioAtendimento instance = null;
        instance.setUltimaRealizacao(ultimaRealizacao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUltimaRealizacao method, of class HorarioAtendimento.
     */
    @Test
    public void testGetUltimaRealizacao() {
        System.out.println("getUltimaRealizacao");
        HorarioAtendimento instance = null;
        Date expResult = null;
        Date result = instance.getUltimaRealizacao();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class HorarioAtendimento.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        HorarioAtendimento instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class HorarioAtendimento.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        HorarioAtendimento instance = null;
        Integer expResult = null;
        Integer result = instance.getId();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class HorarioAtendimento.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Integer id = null;
        HorarioAtendimento instance = null;
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInicio method, of class HorarioAtendimento.
     */
    @Test
    public void testGetInicio() {
        System.out.println("getInicio");
        HorarioAtendimento instance = null;
        Date expResult = null;
        Date result = instance.getInicio();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInicio method, of class HorarioAtendimento.
     */
    @Test
    public void testSetInicio_Date() {
        System.out.println("setInicio");
        Date inicio = null;
        HorarioAtendimento instance = null;
        instance.setInicio(inicio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFim method, of class HorarioAtendimento.
     */
    @Test
    public void testGetFim() {
        System.out.println("getFim");
        HorarioAtendimento instance = null;
        Date expResult = null;
        Date result = instance.getFim();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFim method, of class HorarioAtendimento.
     */
    @Test
    public void testSetFim_Date() {
        System.out.println("setFim");
        Date fim = null;
        HorarioAtendimento instance = null;
        instance.setFim(fim);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMedicoList method, of class HorarioAtendimento.
     */
    @Test
    public void testGetMedicoList() {
        System.out.println("getMedicoList");
        HorarioAtendimento instance = null;
        List expResult = null;
        List result = instance.getMedicoList();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMedicoList method, of class HorarioAtendimento.
     */
    @Test
    public void testSetMedicoList() {
        System.out.println("setMedicoList");
        List<Medico> medicoList = null;
        HorarioAtendimento instance = null;
        instance.setMedicoList(medicoList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDiaSemana method, of class HorarioAtendimento.
     */
    @Test
    public void testGetDiaSemana() {
        System.out.println("getDiaSemana");
        HorarioAtendimento instance = null;
        DiaSemana expResult = null;
        DiaSemana result = instance.getDiaSemana();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDiaSemana method, of class HorarioAtendimento.
     */
    @Test
    public void testSetDiaSemana() {
        System.out.println("setDiaSemana");
        DiaSemana diaSemana = null;
        HorarioAtendimento instance = null;
        instance.setDiaSemana(diaSemana);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class HorarioAtendimento.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        HorarioAtendimento instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class HorarioAtendimento.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        HorarioAtendimento instance = null;
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
