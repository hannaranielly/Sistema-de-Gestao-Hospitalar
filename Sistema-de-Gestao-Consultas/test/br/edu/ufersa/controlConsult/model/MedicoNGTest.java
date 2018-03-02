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
        Medico instance = null;
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
        Medico instance = null;
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
    public void testSetCargaHoraria_int() {
        System.out.println("setCargaHoraria");
        int cargaHoraria = 0;
        Medico instance = null;
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
        Medico instance = null;
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
        Especialidade especialidade = null;
        Medico instance = null;
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
        Medico instance = null;
        Especialidade expResult = null;
        Especialidade result = instance.getEspecialidade();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Medico.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Medico instance = null;
        Integer expResult = null;
        Integer result = instance.getId();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Medico.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Integer id = null;
        Medico instance = null;
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCargaHoraria method, of class Medico.
     */
    @Test
    public void testSetCargaHoraria_Integer() {
        System.out.println("setCargaHoraria");
        Integer cargaHoraria = null;
        Medico instance = null;
        instance.setCargaHoraria(cargaHoraria);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPessoa method, of class Medico.
     */
    @Test
    public void testGetPessoa() {
        System.out.println("getPessoa");
        Medico instance = null;
        Pessoa expResult = null;
        Pessoa result = instance.getPessoa();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPessoa method, of class Medico.
     */
    @Test
    public void testSetPessoa() {
        System.out.println("setPessoa");
        Pessoa pessoa = null;
        Medico instance = null;
        instance.setPessoa(pessoa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Medico.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Medico instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Medico.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Medico instance = null;
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Medico.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Medico instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addListaHorario method, of class Medico.
     */
    @Test
    public void testAddListaHorario() {
        System.out.println("addListaHorario");
        HorarioAtendimento h = null;
        Medico instance = null;
        instance.addListaHorario(h);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
