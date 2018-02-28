/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model;

import java.sql.Time;
import java.util.Date;
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
     * Test of getMedico method, of class HorarioAtendimento.
     */
    @Test
    public void testGetMedico() {
        System.out.println("getMedico");
        HorarioAtendimento instance = new HorarioAtendimento();
        Medico expResult = null;
        Medico result = instance.getMedico();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMedico method, of class HorarioAtendimento.
     */
    @Test
    public void testSetMedico() {
        System.out.println("setMedico");
        Medico medico = null;
        HorarioAtendimento instance = new HorarioAtendimento();
        instance.setMedico(medico);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class HorarioAtendimento.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        HorarioAtendimento instance = new HorarioAtendimento();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class HorarioAtendimento.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        HorarioAtendimento instance = new HorarioAtendimento();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInicio method, of class HorarioAtendimento.
     */
    @Test
    public void testSetInicio() {
        System.out.println("setInicio");
        Time inicio = null;
        HorarioAtendimento instance = new HorarioAtendimento();
        instance.setInicio(inicio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInicio method, of class HorarioAtendimento.
     */
    @Test
    public void testGetInicio() {
        System.out.println("getInicio");
        HorarioAtendimento instance = new HorarioAtendimento();
        Time expResult = null;
        Time result = instance.getInicio();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFim method, of class HorarioAtendimento.
     */
    @Test
    public void testSetFim() {
        System.out.println("setFim");
        Time fim = null;
        HorarioAtendimento instance = new HorarioAtendimento();
        instance.setFim(fim);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFim method, of class HorarioAtendimento.
     */
    @Test
    public void testGetFim() {
        System.out.println("getFim");
        HorarioAtendimento instance = new HorarioAtendimento();
        Time expResult = null;
        Time result = instance.getFim();
        assertEquals(result, expResult);
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
        HorarioAtendimento instance = new HorarioAtendimento();
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
        HorarioAtendimento instance = new HorarioAtendimento();
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
        HorarioAtendimento instance = new HorarioAtendimento();
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
        HorarioAtendimento instance = new HorarioAtendimento();
        Date expResult = null;
        Date result = instance.getUltimaRealizacao();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDiaDaSemana method, of class HorarioAtendimento.
     */
    @Test
    public void testSetDiaDaSemana() {
        System.out.println("setDiaDaSemana");
        int diaDaSemana = 0;
        HorarioAtendimento instance = new HorarioAtendimento();
        instance.setDiaDaSemana(diaDaSemana);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDiaDaSemana method, of class HorarioAtendimento.
     */
    @Test
    public void testGetDiaDaSemana() {
        System.out.println("getDiaDaSemana");
        HorarioAtendimento instance = new HorarioAtendimento();
        int expResult = 0;
        int result = instance.getDiaDaSemana();
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
        HorarioAtendimento instance = new HorarioAtendimento();
        String expResult = "";
        String result = instance.toString();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
