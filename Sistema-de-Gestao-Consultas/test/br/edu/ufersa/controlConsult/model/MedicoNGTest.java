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
public class MedicoNGTest {
    
    public MedicoNGTest() {
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
     * Test of setListaHorario method, of class Medico.
     */
    @Test
    public void testSetListaHorario() {
        System.out.println("setListaHorario");
        List<HorarioAtendimento> listaHorario = null;
        Medico instance = new Medico();
        instance.setListaHorario(listaHorario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaHorario method, of class Medico.
     */
    @Test
    public void testGetListaHorario() {
        System.out.println("getListaHorario");
        Medico instance = new Medico();
        List expResult = null;
        List result = instance.getListaHorario();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCargaHoraria method, of class Medico.
     */
    @Test
    public void testSetCargaHoraria() {
        System.out.println("setCargaHoraria");
        int cargaHoraria = 0;
        Medico instance = new Medico();
        instance.setCargaHoraria(cargaHoraria);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCargaHoraria method, of class Medico.
     */
    @Test
    public void testGetCargaHoraria() {
        System.out.println("getCargaHoraria");
        Medico instance = new Medico();
        int expResult = 0;
        int result = instance.getCargaHoraria();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEspecialidade method, of class Medico.
     */
    @Test
    public void testSetEspecialidade() {
        System.out.println("setEspecialidade");
        int especialidade = 0;
        Medico instance = new Medico();
        instance.setEspecialidade(especialidade);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEspecialidade method, of class Medico.
     */
    @Test
    public void testGetEspecialidade() {
        System.out.println("getEspecialidade");
        Medico instance = new Medico();
        int expResult = 0;
        int result = instance.getEspecialidade();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
