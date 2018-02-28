/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model.hibernateDAO;

import br.edu.ufersa.controlConsult.model.Paciente;
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
public class PacienteCRUDNGTest {
    
    public PacienteCRUDNGTest() {
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
     * Test of salvar_atualizar method, of class PacienteCRUD.
     */
    @Test
    public void testSalvar_atualizar() {
        System.out.println("salvar_atualizar");
        Paciente paciente = null;
        PacienteCRUD instance = new PacienteCRUD();
        instance.salvar_atualizar(paciente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of apagar method, of class PacienteCRUD.
     */
    @Test
    public void testApagar() {
        System.out.println("apagar");
        Paciente paciente = null;
        PacienteCRUD instance = new PacienteCRUD();
        instance.apagar(paciente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consulta_por_CPF method, of class PacienteCRUD.
     */
    @Test
    public void testConsulta_por_CPF() {
        System.out.println("consulta_por_CPF");
        String cpf = "";
        PacienteCRUD instance = new PacienteCRUD();
        Paciente expResult = null;
        Paciente result = instance.consulta_por_CPF(cpf);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
