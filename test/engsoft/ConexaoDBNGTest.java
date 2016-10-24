/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft;

import java.sql.Connection;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Lucas B. Tsuchiya
 */
public class ConexaoDBNGTest {
    
    public ConexaoDBNGTest() {
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
     * Test of getCon method, of class ConexaoDB.
     */


    /**
     * Test of realizaCadastro method, of class ConexaoDB.
     */
    @Test(priority = 3)
    public void testxAltSenha() {
        System.out.println("altSenha");
        String NickField = "fulano1";
        String PassField = "123456";
        ConexaoDB instance = new ConexaoDB();
        String expResult = "Alteração executada com sucesso!";
        String result = instance.altSenha(NickField, PassField);
        assertEquals(result, expResult);
    }
    
    @Test(priority = 1)
    public void testRealizaCadastroCerto() {
        System.out.println("realizaCadastro");
        String NickField = "fulano1";
        String NomeField = "Lucas Tsuchiya";
        String EndField = "Avenida padre Paulo broda";
        String NumField = "19";
        String EmailField = "patricia55@gmail.com";
        String PaisField = "Brasil";
        String EstadoField = "PR";
        String CityField = "Londrina";
        String PassField = "lucas12vinho";
        ConexaoDB instance = new ConexaoDB();
        String expResult = "Usuário Cadastrado com sucesso!";
        String result = instance.realizaCadastro(NickField, NomeField, EndField, NumField, EmailField, PaisField, EstadoField, CityField, PassField);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail
    }
    @Test(priority = 1)
     public void testRealizaCadastroCerto2() {
        System.out.println("realizaCadastro");
        String NickField = "fulano2";
        String NomeField = "Lucas Tsuchiya";
        String EndField = "Avenida padre Paulo broda";
        String NumField = "19";
        String EmailField = "patricia123@gmail.com";
        String PaisField = "Brasil";
        String EstadoField = "PR";
        String CityField = "Londrina";
        String PassField = "lucas12vinho";
        ConexaoDB instance = new ConexaoDB();
        String expResult = "Usuário Cadastrado com sucesso!";
        String result = instance.realizaCadastro(NickField, NomeField, EndField, NumField, EmailField, PaisField, EstadoField, CityField, PassField);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail
    }
    
        @Test(priority = 2)
    public void testRealizaCadastroRepetido() {
        System.out.println("realizaCadastro");
        String NickField = "fulano1";
        String NomeField = "Lucas Tsuchiya";
        String EndField = "Avenida padre Paulo broda";
        String NumField = "19";
        String EmailField = "patricia123@gmail.com";
        String PaisField = "Brasil";
        String EstadoField = "PR";
        String CityField = "Londrina";
        String PassField = "lucas12vinho";
        ConexaoDB instance = new ConexaoDB();
        String expResult = "Nome de usuário já  cadastrado!";
        String result = instance.realizaCadastro(NickField, NomeField, EndField, NumField, EmailField, PaisField, EstadoField, CityField, PassField);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail
    } 
    
        @Test
    public void testAltSenhanencotrado() {
        System.out.println("altSenha");
        String NickField = "celulartelefone";
        String PassField = "lucasvinho";
        ConexaoDB instance = new ConexaoDB();
        String expResult = "Usuário não encontrado!";
        String result = instance.altSenha(NickField, PassField);
        assertEquals(result, expResult);
    }      
}
