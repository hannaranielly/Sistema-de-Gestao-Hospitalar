/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model.jpaDAO;

import br.edu.ufersa.controlConsult.model.Consulta;
import br.edu.ufersa.controlConsult.model.HorarioAtendimento;
import br.edu.ufersa.controlConsult.model.Medico;
import br.edu.ufersa.controlConsult.model.Paciente;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
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
public class ConsultaJpaControllerNGTest {
    
    public ConsultaJpaControllerNGTest() {
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
     * Test of getEntityManager method, of class ConsultaJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        ConsultaJpaController instance = null;
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class ConsultaJpaController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Consulta consulta = null;
        ConsultaJpaController instance = null;
        instance.create(consulta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class ConsultaJpaController.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        Consulta consulta = null;
        ConsultaJpaController instance = null;
        instance.read(consulta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class ConsultaJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Consulta consulta = null;
        ConsultaJpaController instance = null;
        instance.edit(consulta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class ConsultaJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Integer id = null;
        ConsultaJpaController instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findConsultaEntities method, of class ConsultaJpaController.
     */
    @Test
    public void testFindConsultaEntities_0args() {
        System.out.println("findConsultaEntities");
        ConsultaJpaController instance = null;
        List expResult = null;
        List result = instance.findConsultaEntities();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findConsultaEntities method, of class ConsultaJpaController.
     */
    @Test
    public void testFindConsultaEntities_int_int() {
        System.out.println("findConsultaEntities");
        int maxResults = 0;
        int firstResult = 0;
        ConsultaJpaController instance = null;
        List expResult = null;
        List result = instance.findConsultaEntities(maxResults, firstResult);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findConsulta method, of class ConsultaJpaController.
     */
    @Test
    public void testFindConsulta() {
        System.out.println("findConsulta");
        Integer id = null;
        ConsultaJpaController instance = null;
        Consulta expResult = null;
        Consulta result = instance.findConsulta(id);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConsultaCount method, of class ConsultaJpaController.
     */
    @Test
    public void testGetConsultaCount() {
        System.out.println("getConsultaCount");
        ConsultaJpaController instance = null;
        int expResult = 0;
        int result = instance.getConsultaCount();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of numconsultaMarcado method, of class ConsultaJpaController.
     */
    @Test
    public void testNumconsultaMarcado() {
        System.out.println("numconsultaMarcado");
        HorarioAtendimento ha = null;
        Date data = null;
        ConsultaJpaController instance = null;
        long expResult = 0L;
        long result = instance.numconsultaMarcado(ha, data);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of numconsultapaciente method, of class ConsultaJpaController.
     */
    @Test
    public void testNumconsultapaciente() {
        System.out.println("numconsultapaciente");
        HorarioAtendimento ha = null;
        Date data = null;
        Paciente paciente = null;
        ConsultaJpaController instance = null;
        long expResult = 0L;
        long result = instance.numconsultapaciente(ha, data, paciente);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findporAtendimento method, of class ConsultaJpaController.
     */
    @Test
    public void testFindporAtendimento() {
        System.out.println("findporAtendimento");
        HorarioAtendimento ha = null;
        Date data = null;
        ConsultaJpaController instance = null;
        List expResult = null;
        List result = instance.findporAtendimento(ha, data);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findporMedico method, of class ConsultaJpaController.
     */
    @Test
    public void testFindporMedico() {
        System.out.println("findporMedico");
        Medico medico = null;
        ConsultaJpaController instance = null;
        List expResult = null;
        List result = instance.findporMedico(medico);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
