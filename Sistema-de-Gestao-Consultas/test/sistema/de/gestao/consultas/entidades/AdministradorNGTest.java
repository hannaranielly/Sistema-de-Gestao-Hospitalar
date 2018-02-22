/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.de.gestao.consultas.entidades;

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
public class AdministradorNGTest {
    
    public AdministradorNGTest() {
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
     * Test of validaLogin method, of class Administrador.
     */
    @Test
    public void testValidaLogin() {
        System.out.println("validaLogin");
        Administrador instance = new Administrador();
        boolean expResult = false;
        boolean result = instance.validaLogin();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registraEntrada method, of class Administrador.
     */
    @Test
    public void testRegistraEntrada() {
        System.out.println("registraEntrada");
        String medico = "";
        Date horario = null;
        Administrador instance = new Administrador();
        instance.registraEntrada(medico, horario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registraSaida method, of class Administrador.
     */
    @Test
    public void testRegistraSaida() {
        System.out.println("registraSaida");
        String medico = "";
        Date horario = null;
        Administrador instance = new Administrador();
        instance.registraSaida(medico, horario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agendaConsulta method, of class Administrador.
     */
    @Test
    public void testAgendaConsulta() {
        System.out.println("agendaConsulta");
        String paciente = "";
        Date horarioAtendimento = null;
        Date data = null;
        Administrador instance = new Administrador();
        instance.agendaConsulta(paciente, horarioAtendimento, data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iniciaAtendimento method, of class Administrador.
     */
    @Test
    public void testIniciaAtendimento() {
        System.out.println("iniciaAtendimento");
        Date horarioAtendimento = null;
        Administrador instance = new Administrador();
        instance.iniciaAtendimento(horarioAtendimento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of proximoAtendimento method, of class Administrador.
     */
    @Test
    public void testProximoAtendimento() {
        System.out.println("proximoAtendimento");
        Date horarioAtendimento = null;
        Administrador instance = new Administrador();
        instance.proximoAtendimento(horarioAtendimento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of finalizaAtendimento method, of class Administrador.
     */
    @Test
    public void testFinalizaAtendimento() {
        System.out.println("finalizaAtendimento");
        Date horarioAtendimento = null;
        Administrador instance = new Administrador();
        instance.finalizaAtendimento(horarioAtendimento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificaAtendimento method, of class Administrador.
     */
    @Test
    public void testVerificaAtendimento() {
        System.out.println("verificaAtendimento");
        String medico = "";
        Administrador instance = new Administrador();
        instance.verificaAtendimento(medico);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class Administrador.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        Administrador instance = new Administrador();
        String expResult = "";
        String result = instance.getUser();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUser method, of class Administrador.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        String user = "";
        Administrador instance = new Administrador();
        instance.setUser(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
