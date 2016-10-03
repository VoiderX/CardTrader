/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft;

import java.sql.Connection;
import java.sql.ResultSet;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
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
public class UserConexaoDBNGTest {
    
    public UserConexaoDBNGTest() {
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

     */
   



     
    @Test
    public void testAlterarCadastro() {
        System.out.println("alterarCadastro");
        String NickField = "celular";
        String NomeField = "Lucas B Tsuchiya";
        String EndField = "Avenida padre Paulo broda";
        String NumField = "19";
        String EmailField = "patricia1@gmail.com";
        String PaisField = "Brasil";
        String EstadoField = "PR";
        String CityField = "Londrina";
        UserConexaoDB instance = new UserConexaoDB();
        String expResult = "Nome de usuário ou email já utilizados!";
        String result = instance.alterarCadastro(NomeField, NumField, EmailField, EndField, PaisField, EstadoField, CityField);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.

    }

    
    



    @Test
    public void testInsereCatalogo() {
        System.out.println("insereCatalogo");
        int IdCarta = 0;
        int quant = 0;
        float valor = 0.0F;
        UserConexaoDB instance = new UserConexaoDB();
        String expResult = "Quantidade inválida!";
        String result = instance.insereCatalogo(IdCarta, quant, valor);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
    }

        @Test
    public void testInsereCatalogo1() {
        System.out.println("insereCatalogo");
        int IdCarta = 999;
        int quant = 9;
        float valor = 0.0F;
        UserConexaoDB instance = new UserConexaoDB();
        String expResult = "Valor inválido";
        String result = instance.insereCatalogo(IdCarta, quant, valor);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
    }

        @Test
    public void testInsereCatalogo2() {
        System.out.println("insereCatalogo");
        int IdCarta = 875;
        int quant = 7;
        float valor = 3.7F;
        UserConexaoDB instance = new UserConexaoDB();
        String expResult = "Um erro ocorreu!";
        String result = instance.insereCatalogo(IdCarta, quant, valor);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
    }



    
}
