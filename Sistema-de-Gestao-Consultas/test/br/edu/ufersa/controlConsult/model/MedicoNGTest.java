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
    public void testSetCargaHoraria_int() {
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
        Especialidade especialidade = null;
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
        Especialidade expResult = null;
        Especialidade result = instance.getEspecialidade();
        assertEquals(result, expResult);
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
        Medico instance = new Medico();
        instance.setCargaHoraria(cargaHoraria);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Medico.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Medico instance = new Medico();
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
        Medico instance = new Medico();
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
        Medico instance = new Medico();
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
        Medico instance = new Medico();
        instance.addListaHorario(h);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class Medico.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Medico instance = new Medico();
        instance.create();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class Medico.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        Medico instance = new Medico();
        instance.read();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Medico.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Medico instance = new Medico();
        instance.update();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class Medico.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Medico instance = new Medico();
        instance.delete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Medico.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Medico instance = new Medico();
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
        Medico instance = new Medico();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPessoa method, of class Medico.
     */
    @Test
    public void testGetPessoa() {
        System.out.println("getPessoa");
        Medico instance = new Medico();
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
        Medico instance = new Medico();
        instance.setPessoa(pessoa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCrm method, of class Medico.
     */
    @Test
    public void testGetCrm() {
        System.out.println("getCrm");
        Medico instance = new Medico();
        String expResult = "";
        String result = instance.getCrm();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCrm method, of class Medico.
     */
    @Test
    public void testSetCrm() {
        System.out.println("setCrm");
        String crm = "";
        Medico instance = new Medico();
        instance.setCrm(crm);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isConflitoHorarios method, of class Medico.
     */
    @Test
    public void testIsConflitoHorarios() {
        System.out.println("isConflitoHorarios");
        HorarioAtendimento h = null;
        Medico instance = new Medico();
        boolean expResult = false;
        boolean result = instance.isConflitoHorarios(h);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
