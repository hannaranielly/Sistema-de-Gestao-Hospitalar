/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model;

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
public class PessoaNGTest {
    
    public PessoaNGTest() {
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
     * Test of getId method, of class Pessoa.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Pessoa instance = new Pessoa();
        Integer expResult = null;
        Integer result = instance.getId();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Pessoa.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Integer id = null;
        Pessoa instance = new Pessoa();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNome method, of class Pessoa.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Pessoa instance = new Pessoa();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNome method, of class Pessoa.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        Pessoa instance = new Pessoa();
        instance.setNome(nome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCpf method, of class Pessoa.
     */
    @Test
    public void testGetCpf() {
        System.out.println("getCpf");
        Pessoa instance = new Pessoa();
        String expResult = "";
        String result = instance.getCpf();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCpf method, of class Pessoa.
     */
    @Test
    public void testSetCpf() {
        System.out.println("setCpf");
        String cpf = "";
        Pessoa instance = new Pessoa();
        instance.setCpf(cpf);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRg method, of class Pessoa.
     */
    @Test
    public void testGetRg() {
        System.out.println("getRg");
        Pessoa instance = new Pessoa();
        String expResult = "";
        String result = instance.getRg();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRg method, of class Pessoa.
     */
    @Test
    public void testSetRg() {
        System.out.println("setRg");
        String rg = "";
        Pessoa instance = new Pessoa();
        instance.setRg(rg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTelefone method, of class Pessoa.
     */
    @Test
    public void testGetTelefone() {
        System.out.println("getTelefone");
        Pessoa instance = new Pessoa();
        String expResult = "";
        String result = instance.getTelefone();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTelefone method, of class Pessoa.
     */
    @Test
    public void testSetTelefone() {
        System.out.println("setTelefone");
        String telefone = "";
        Pessoa instance = new Pessoa();
        instance.setTelefone(telefone);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCidade method, of class Pessoa.
     */
    @Test
    public void testGetCidade() {
        System.out.println("getCidade");
        Pessoa instance = new Pessoa();
        String expResult = "";
        String result = instance.getCidade();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCidade method, of class Pessoa.
     */
    @Test
    public void testSetCidade() {
        System.out.println("setCidade");
        String cidade = "";
        Pessoa instance = new Pessoa();
        instance.setCidade(cidade);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBairro method, of class Pessoa.
     */
    @Test
    public void testGetBairro() {
        System.out.println("getBairro");
        Pessoa instance = new Pessoa();
        String expResult = "";
        String result = instance.getBairro();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBairro method, of class Pessoa.
     */
    @Test
    public void testSetBairro() {
        System.out.println("setBairro");
        String bairro = "";
        Pessoa instance = new Pessoa();
        instance.setBairro(bairro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLogradouro method, of class Pessoa.
     */
    @Test
    public void testGetLogradouro() {
        System.out.println("getLogradouro");
        Pessoa instance = new Pessoa();
        String expResult = "";
        String result = instance.getLogradouro();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLogradouro method, of class Pessoa.
     */
    @Test
    public void testSetLogradouro() {
        System.out.println("setLogradouro");
        String logradouro = "";
        Pessoa instance = new Pessoa();
        instance.setLogradouro(logradouro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCep method, of class Pessoa.
     */
    @Test
    public void testGetCep() {
        System.out.println("getCep");
        Pessoa instance = new Pessoa();
        String expResult = "";
        String result = instance.getCep();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCep method, of class Pessoa.
     */
    @Test
    public void testSetCep() {
        System.out.println("setCep");
        String cep = "";
        Pessoa instance = new Pessoa();
        instance.setCep(cep);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataDeNascimento method, of class Pessoa.
     */
    @Test
    public void testGetDataDeNascimento() {
        System.out.println("getDataDeNascimento");
        Pessoa instance = new Pessoa();
        Date expResult = null;
        Date result = instance.getDataDeNascimento();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDataDeNascimento method, of class Pessoa.
     */
    @Test
    public void testSetDataDeNascimento() {
        System.out.println("setDataDeNascimento");
        Date dataDeNascimento = null;
        Pessoa instance = new Pessoa();
        instance.setDataDeNascimento(dataDeNascimento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSexo method, of class Pessoa.
     */
    @Test
    public void testGetSexo() {
        System.out.println("getSexo");
        Pessoa instance = new Pessoa();
        Character expResult = null;
        Character result = instance.getSexo();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSexo method, of class Pessoa.
     */
    @Test
    public void testSetSexo() {
        System.out.println("setSexo");
        Character sexo = null;
        Pessoa instance = new Pessoa();
        instance.setSexo(sexo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class Pessoa.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Pessoa instance = new Pessoa();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class Pessoa.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Pessoa instance = new Pessoa();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumCasa method, of class Pessoa.
     */
    @Test
    public void testGetNumCasa() {
        System.out.println("getNumCasa");
        Pessoa instance = new Pessoa();
        int expResult = 0;
        int result = instance.getNumCasa();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumCasa method, of class Pessoa.
     */
    @Test
    public void testSetNumCasa() {
        System.out.println("setNumCasa");
        int numCasa = 0;
        Pessoa instance = new Pessoa();
        instance.setNumCasa(numCasa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstado method, of class Pessoa.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        Pessoa instance = new Pessoa();
        String expResult = "";
        String result = instance.getEstado();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class Pessoa.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        String estado = "";
        Pessoa instance = new Pessoa();
        instance.setEstado(estado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Pessoa.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Pessoa instance = new Pessoa();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Pessoa.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Pessoa instance = new Pessoa();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Pessoa.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Pessoa instance = new Pessoa();
        String expResult = "";
        String result = instance.toString();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
