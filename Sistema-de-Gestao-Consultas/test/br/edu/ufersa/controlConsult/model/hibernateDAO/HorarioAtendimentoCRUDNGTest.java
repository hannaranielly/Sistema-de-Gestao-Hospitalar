/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model.hibernateDAO;

import br.edu.ufersa.controlConsult.model.HorarioAtendimento;
import java.sql.Time;
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
public class HorarioAtendimentoCRUDNGTest {
    
    public HorarioAtendimentoCRUDNGTest() {
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
     * Test of salvar_atualizar method, of class HorarioAtendimentoCRUD.
     */
    @Test
    public void testSalvar_atualizar() {
        System.out.println("salvar_atualizar");
        HorarioAtendimento horario = null;
        HorarioAtendimentoCRUD instance = new HorarioAtendimentoCRUD();
        instance.salvar_atualizar(horario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of apagar method, of class HorarioAtendimentoCRUD.
     */
    @Test
    public void testApagar() {
        System.out.println("apagar");
        HorarioAtendimento horario = null;
        HorarioAtendimentoCRUD instance = new HorarioAtendimentoCRUD();
        instance.apagar(horario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consulta_repetido_por_id_medico method, of class HorarioAtendimentoCRUD.
     */
    @Test
    public void testConsulta_repetido_por_id_medico() {
        System.out.println("consulta_repetido_por_id_medico");
        Long id = null;
        int dia = 0;
        Time inicio = null;
        Time fim = null;
        HorarioAtendimentoCRUD instance = new HorarioAtendimentoCRUD();
        List expResult = null;
        List result = instance.consulta_repetido_por_id_medico(id, dia, inicio, fim);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consulta_por_id_medico method, of class HorarioAtendimentoCRUD.
     */
    @Test
    public void testConsulta_por_id_medico() {
        System.out.println("consulta_por_id_medico");
        Long id = null;
        HorarioAtendimentoCRUD instance = new HorarioAtendimentoCRUD();
        List expResult = null;
        List result = instance.consulta_por_id_medico(id);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
