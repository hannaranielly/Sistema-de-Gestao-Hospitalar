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
public class UsuarioNGTest {
    
    public UsuarioNGTest() {
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
     * Test of findAll method, of class Usuario.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        List expResult = null;
        List result = Usuario.findAll();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Usuario.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Usuario instance = new Usuario();
        Integer expResult = null;
        Integer result = instance.getId();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Usuario.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Integer id = null;
        Usuario instance = new Usuario();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsername method, of class Usuario.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Usuario instance = new Usuario();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsername method, of class Usuario.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        Usuario instance = new Usuario();
        instance.setUsername(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class Usuario.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Usuario instance = new Usuario();
        char[] expResult = null;
        char[] result = instance.getPassword();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pega_Banco method, of class Usuario.
     */
    @Test
    public void testPega_Banco() {
        System.out.println("pega_Banco");
        Usuario usuario = null;
        Usuario expResult = null;
        Usuario result = Usuario.pega_Banco(usuario);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class Usuario.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        char[] password_raw = null;
        Usuario instance = new Usuario();
        instance.setPassword(password_raw);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class Usuario.
     */
    @Test
    public void testLogin() throws Exception {
        System.out.println("login");
        Usuario instance = new Usuario();
        Usuario expResult = null;
        Usuario result = instance.login();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registraEntrada method, of class Usuario.
     */
    @Test
    public void testRegistraEntrada() {
        System.out.println("registraEntrada");
        String medico = "";
        Date horario = null;
        Usuario instance = new Usuario();
        instance.registraEntrada(medico, horario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registraSaida method, of class Usuario.
     */
    @Test
    public void testRegistraSaida() {
        System.out.println("registraSaida");
        String medico = "";
        Date horario = null;
        Usuario instance = new Usuario();
        instance.registraSaida(medico, horario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agendaConsulta method, of class Usuario.
     */
    @Test
    public void testAgendaConsulta() {
        System.out.println("agendaConsulta");
        String paciente = "";
        Date horarioAtendimento = null;
        Date data = null;
        Usuario instance = new Usuario();
        instance.agendaConsulta(paciente, horarioAtendimento, data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iniciaAtendimento method, of class Usuario.
     */
    @Test
    public void testIniciaAtendimento() {
        System.out.println("iniciaAtendimento");
        Date horarioAtendimento = null;
        Usuario instance = new Usuario();
        instance.iniciaAtendimento(horarioAtendimento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of proximoAtendimento method, of class Usuario.
     */
    @Test
    public void testProximoAtendimento() {
        System.out.println("proximoAtendimento");
        Date horarioAtendimento = null;
        Usuario instance = new Usuario();
        instance.proximoAtendimento(horarioAtendimento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of finalizaAtendimento method, of class Usuario.
     */
    @Test
    public void testFinalizaAtendimento() {
        System.out.println("finalizaAtendimento");
        Date horarioAtendimento = null;
        Usuario instance = new Usuario();
        instance.finalizaAtendimento(horarioAtendimento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificaAtendimento method, of class Usuario.
     */
    @Test
    public void testVerificaAtendimento() {
        System.out.println("verificaAtendimento");
        String medico = "";
        Usuario instance = new Usuario();
        instance.verificaAtendimento(medico);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Usuario.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Usuario instance = new Usuario();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Usuario.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Usuario instance = new Usuario();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Usuario.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Usuario instance = new Usuario();
        String expResult = "";
        String result = instance.toString();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class Usuario.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Usuario instance = new Usuario();
        instance.create();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class Usuario.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        Usuario instance = new Usuario();
        instance.read();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Usuario.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Usuario instance = new Usuario();
        instance.update();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class Usuario.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Usuario instance = new Usuario();
        instance.delete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
