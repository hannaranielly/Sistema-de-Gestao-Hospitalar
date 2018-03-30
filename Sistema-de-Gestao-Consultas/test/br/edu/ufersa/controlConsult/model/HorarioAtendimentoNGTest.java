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
        HorarioAtendimento instance = new HorarioAtendimento();
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
        HorarioAtendimento instance = new HorarioAtendimento();
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

    /**
     * Test of getId method, of class HorarioAtendimento.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        HorarioAtendimento instance = new HorarioAtendimento();
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
        HorarioAtendimento instance = new HorarioAtendimento();
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
        HorarioAtendimento instance = new HorarioAtendimento();
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
        HorarioAtendimento instance = new HorarioAtendimento();
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
        HorarioAtendimento instance = new HorarioAtendimento();
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
        HorarioAtendimento instance = new HorarioAtendimento();
        instance.setFim(fim);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDiaSemana method, of class HorarioAtendimento.
     */
    @Test
    public void testGetDiaSemana() {
        System.out.println("getDiaSemana");
        HorarioAtendimento instance = new HorarioAtendimento();
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
        HorarioAtendimento instance = new HorarioAtendimento();
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
        HorarioAtendimento instance = new HorarioAtendimento();
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
        HorarioAtendimento instance = new HorarioAtendimento();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByMedicoId method, of class HorarioAtendimento.
     */
    @Test
    public void testFindByMedicoId() {
        System.out.println("findByMedicoId");
        Integer id = null;
        List expResult = null;
        List result = HorarioAtendimento.findByMedicoId(id);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByMedicoId_repetido method, of class HorarioAtendimento.
     */
    @Test
    public void testFindByMedicoId_repetido() {
        System.out.println("findByMedicoId_repetido");
        Integer id = null;
        int dia = 0;
        Time inicio = null;
        Time fim = null;
        List expResult = null;
        List result = HorarioAtendimento.findByMedicoId_repetido(id, dia, inicio, fim);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class HorarioAtendimento.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        HorarioAtendimento instance = new HorarioAtendimento();
        instance.create();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class HorarioAtendimento.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        HorarioAtendimento instance = new HorarioAtendimento();
        instance.read();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class HorarioAtendimento.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        HorarioAtendimento instance = new HorarioAtendimento();
        instance.update();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class HorarioAtendimento.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        HorarioAtendimento instance = new HorarioAtendimento();
        instance.delete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
