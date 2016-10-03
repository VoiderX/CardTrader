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
        String NomeField = "Lucas B Tsuchiya";
        String EndField = "Avenida padre Paulo broda";
        String NumField = "19";
        String EmailField = "patricia123@gmail.com";
        String PaisField = "Brasil";
        String EstadoField = "PR";
        String CityField = "Londrina";
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("celularoi");
        instance.setSenha("123456");
        String expResult = "Nome de usuário ou email já utilizados!";
        instance.createCon();
        String result = instance.alterarCadastro(NomeField, NumField, EmailField, EndField, PaisField, EstadoField, CityField);
        assertEquals(result, expResult);        
    }
 @Test
    public void testAlterarCadastroCerto() {
        System.out.println("alterarCadastro");
        String NomeField = "Lucas B Tsuchiya";
        String EndField = "Avenida padre Paulo broda";
        String NumField = "19";
        String EmailField = "patricia1234@gmail.com";
        String PaisField = "Brasil";
        String EstadoField = "PR";
        String CityField = "Londrina";
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("celularoi");
        instance.setSenha("123456");
        String expResult = "Dados atualizados com sucesso!";
        instance.createCon();
        String result = instance.alterarCadastro(NomeField, NumField, EmailField, EndField, PaisField, EstadoField, CityField);
        assertEquals(result, expResult);        
    }        

    @Test
    public void testInsereCatalogo() {
        System.out.println("insereCatalogo1");
        int IdCarta = 1;
        int quant = 0;
        float valor = 0.0F;
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("celularoi");
        instance.setSenha("123456");
        instance.createCon();
        String expResult = "Quantidade inválida!";
        String result = instance.insereCatalogo(IdCarta, quant, valor);
        assertEquals(result, expResult);
    }

        @Test
    public void testInsereCatalogo1() {
        System.out.println("insereCatalogo2");
        int IdCarta = 999;
        int quant = 9;
        float valor = 0.0F;
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("celularoi");
        instance.setSenha("123456");
        instance.createCon();
        String expResult = "Valor inválido";
        String result = instance.insereCatalogo(IdCarta, quant, valor);
        assertEquals(result, expResult);
    }
    
}
