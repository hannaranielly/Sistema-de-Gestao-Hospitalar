/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model.hibernateDAO;

import br.edu.ufersa.controlConsult.model.Medico;
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
public class MedicoCRUDNGTest {
    
    public MedicoCRUDNGTest() {
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
     * Test of salvar_atualizar method, of class MedicoCRUD.
     */
    @Test
    public void testSalvar_atualizar() {
        System.out.println("salvar_atualizar");
        Medico medico = null;
        MedicoCRUD instance = new MedicoCRUD();
        instance.salvar_atualizar(medico);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of apagar method, of class MedicoCRUD.
     */
    @Test
    public void testApagar() {
        System.out.println("apagar");
        Medico medico = null;
        MedicoCRUD instance = new MedicoCRUD();
        instance.apagar(medico);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consulta_por_CPF method, of class MedicoCRUD.
     */
    @Test
    public void testConsulta_por_CPF() {
        System.out.println("consulta_por_CPF");
        String cpf = "";
        MedicoCRUD instance = new MedicoCRUD();
        Medico expResult = null;
        Medico result = instance.consulta_por_CPF(cpf);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
