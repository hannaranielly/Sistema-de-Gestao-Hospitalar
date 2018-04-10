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
public class ConsultaNGTest {
    
    public ConsultaNGTest() {
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
     * Test of findAll method, of class Consulta.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        List expResult = null;
        List result = Consulta.findAll();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findporMedico method, of class Consulta.
     */
    @Test
    public void testFindporMedico() {
        System.out.println("findporMedico");
        Medico m = null;
        List expResult = null;
        List result = Consulta.findporMedico(m);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData_marcado method, of class Consulta.
     */
    @Test
    public void testGetData_marcado() {
        System.out.println("getData_marcado");
        Consulta instance = new Consulta();
        Date expResult = null;
        Date result = instance.getData_marcado();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setData_marcado method, of class Consulta.
     */
    @Test
    public void testSetData_marcado() {
        System.out.println("setData_marcado");
        Date data_marcado = null;
        Consulta instance = new Consulta();
        instance.setData_marcado(data_marcado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHorario_atendimento method, of class Consulta.
     */
    @Test
    public void testGetHorario_atendimento() {
        System.out.println("getHorario_atendimento");
        Consulta instance = new Consulta();
        HorarioAtendimento expResult = null;
        HorarioAtendimento result = instance.getHorario_atendimento();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHorario_atendimento method, of class Consulta.
     */
    @Test
    public void testSetHorario_atendimento() {
        System.out.println("setHorario_atendimento");
        HorarioAtendimento horario_atendimento = null;
        Consulta instance = new Consulta();
        instance.setHorario_atendimento(horario_atendimento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findporAtendimento method, of class Consulta.
     */
    @Test
    public void testFindporAtendimento() {
        System.out.println("findporAtendimento");
        HorarioAtendimento ha = null;
        Date data = null;
        List expResult = null;
        List result = Consulta.findporAtendimento(ha, data);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of numconsultaMarcado method, of class Consulta.
     */
    @Test
    public void testNumconsultaMarcado() {
        System.out.println("numconsultaMarcado");
        HorarioAtendimento ha = null;
        Date data = null;
        long expResult = 0L;
        long result = Consulta.numconsultaMarcado(ha, data);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of numconsultapaciente method, of class Consulta.
     */
    @Test
    public void testNumconsultapaciente() {
        System.out.println("numconsultapaciente");
        HorarioAtendimento ha = null;
        Date data = null;
        Paciente paciente = null;
        long expResult = 0L;
        long result = Consulta.numconsultapaciente(ha, data, paciente);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Consulta.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Consulta instance = new Consulta();
        Integer expResult = null;
        Integer result = instance.getId();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Consulta.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Integer id = null;
        Consulta instance = new Consulta();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAgendada method, of class Consulta.
     */
    @Test
    public void testIsAgendada() {
        System.out.println("isAgendada");
        Consulta instance = new Consulta();
        boolean expResult = false;
        boolean result = instance.isAgendada();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAgendada method, of class Consulta.
     */
    @Test
    public void testSetAgendada() {
        System.out.println("setAgendada");
        boolean agendada = false;
        Consulta instance = new Consulta();
        instance.setAgendada(agendada);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData_inicio method, of class Consulta.
     */
    @Test
    public void testGetData_inicio() {
        System.out.println("getData_inicio");
        Consulta instance = new Consulta();
        Date expResult = null;
        Date result = instance.getData_inicio();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setData_inicio method, of class Consulta.
     */
    @Test
    public void testSetData_inicio() {
        System.out.println("setData_inicio");
        Date data_inicio = null;
        Consulta instance = new Consulta();
        instance.setData_inicio(data_inicio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData_fim method, of class Consulta.
     */
    @Test
    public void testGetData_fim() {
        System.out.println("getData_fim");
        Consulta instance = new Consulta();
        Date expResult = null;
        Date result = instance.getData_fim();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setData_fim method, of class Consulta.
     */
    @Test
    public void testSetData_fim() {
        System.out.println("setData_fim");
        Date data_fim = null;
        Consulta instance = new Consulta();
        instance.setData_fim(data_fim);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMedico method, of class Consulta.
     */
    @Test
    public void testGetMedico() {
        System.out.println("getMedico");
        Consulta instance = new Consulta();
        Medico expResult = null;
        Medico result = instance.getMedico();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMedico method, of class Consulta.
     */
    @Test
    public void testSetMedico() {
        System.out.println("setMedico");
        Medico medico = null;
        Consulta instance = new Consulta();
        instance.setMedico(medico);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPaciente method, of class Consulta.
     */
    @Test
    public void testGetPaciente() {
        System.out.println("getPaciente");
        Consulta instance = new Consulta();
        Paciente expResult = null;
        Paciente result = instance.getPaciente();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPaciente method, of class Consulta.
     */
    @Test
    public void testSetPaciente() {
        System.out.println("setPaciente");
        Paciente paciente = null;
        Consulta instance = new Consulta();
        instance.setPaciente(paciente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData_agendada method, of class Consulta.
     */
    @Test
    public void testGetData_agendada() {
        System.out.println("getData_agendada");
        Consulta instance = new Consulta();
        Date expResult = null;
        Date result = instance.getData_agendada();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setData_agendada method, of class Consulta.
     */
    @Test
    public void testSetData_agendada() {
        System.out.println("setData_agendada");
        Date data_agendada = null;
        Consulta instance = new Consulta();
        instance.setData_agendada(data_agendada);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class Consulta.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Consulta instance = new Consulta();
        instance.create();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class Consulta.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        Consulta instance = new Consulta();
        instance.read();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Consulta.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Consulta instance = new Consulta();
        instance.update();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class Consulta.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Consulta instance = new Consulta();
        instance.delete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
