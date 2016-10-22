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
        String EmailField = "lucasteste1@gmail.com";
        String PaisField = "Brasil";
        String EstadoField = "PR";
        String CityField = "Londrina";
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("lucasteste");
        instance.setSenha("12345678");
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
    
            @Test
    public void testInsereCatalogo2() {
        System.out.println("insereCatalogo2");
        int IdCarta = 7;
        int quant = 17;
        float valor = 2.0F;
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("lucasteste");
        instance.setSenha("12345678");
        instance.createCon();
        String expResult = "Item inserido com sucesso!";
        String result = instance.insereCatalogo(IdCarta, quant, valor);
        assertEquals(result, expResult);
    }
    
    @Test
    public void testInsereCatalogo3() {
        System.out.println("insereCatalogo2");
        int IdCarta = 8888;
        int quant = 17;
        float valor = 2.0F;
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("lucasteste");
        instance.setSenha("12345678");
        instance.createCon();
        String expResult = "Um erro ocorreu!";
        String result = instance.insereCatalogo(IdCarta, quant, valor);
        assertEquals(result, expResult);
    }
    
    @Test
    public void testDeletaCatalogo() {
        System.out.println("deletaCatalogo");
        int IdCarta = 0;
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("lucasteste");
        instance.setSenha("12345678");
        instance.createCon();
        instance.deletaCatalogo(IdCarta);
    }
    @Test
    public void testDeletaCatalogo1() {
        System.out.println("deletaCatalogo");
        int IdCarta = 1;
        UserConexaoDB instance = new UserConexaoDB();
        instance.deletaCatalogo(IdCarta);
    }
    
    @Test
    public void testAlteraCatalogo() {
        System.out.println("alteraCatalogo");
        int IdCarta = 2;
        float valor = 1.0F;
        int quantidade = 2;
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("lucasteste");
        instance.setSenha("12345678");
        instance.createCon();
        instance.alteraCatalogo(IdCarta, valor, quantidade);
    }
    
        @Test
    public void testAlteraCatalogo2() {
        System.out.println("alteraCatalogo");
        int IdCarta = 2;
        float valor = 1.0F;
        int quantidade = 2;
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("lucastte");
        instance.setSenha("12345678");
        instance.createCon();
        instance.alteraCatalogo(IdCarta, valor, quantidade);
    }
    
    @Test
    public void testRetornaInfoCarta() {
        System.out.println("retornaInfoCarta");
        int IdCarta = 0;
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("lucastte");
        instance.setSenha("12345678");
        ResultSet expResult = null;
        ResultSet result = instance.retornaInfoCarta(IdCarta);
        assertEquals(result, expResult);
    }
    
    @Test
    public void testRetornaInfoCarta2() {
        System.out.println("retornaInfoCarta");
        int IdCarta = 2;
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("lucasteste");
        instance.setSenha("12345678");
        instance.createCon();
        ResultSet expResult = null;
        ResultSet result = instance.retornaInfoCarta(IdCarta);
        assertEquals(result, expResult);
    }
    
    @Test
    public void testRetornaCatalogo() {
        System.out.println("retornaCatalogo");
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("lucasteste");
        instance.setSenha("12345678");
        instance.createCon();
        instance.retornaCatalogo();
      
        // TODO review the generated test code and remove the default call to fail.
  
    }
    
    @Test
    public void testRetornaCatalogo1() {
        System.out.println("retornaCatalogo");
        UserConexaoDB instance = new UserConexaoDB();
        ResultSet expResult = null;
        ResultSet result = instance.retornaCatalogo();
        instance.setUsuario("lucasteste");
        instance.setSenha("12345678");
        instance.createCon();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.

    }
    
    @Test
    public void testPuxarInfo() {
        System.out.println("puxarInfo");
        TextField NickField = null;
        TextField NomeField = null;
        TextField DDDField = null;
        TextField CodCddField = null;
        TextField NumUsuarioField = null;
        TextField EmailField = null;
        TextField EndField = null;
        ChoiceBox<String> PaisField = null;
        ChoiceBox<String> EstadoField = null;
        ChoiceBox<String> CityField = null;
        Text Mensagem = null;
        UserConexaoDB instance = new UserConexaoDB();
        instance.puxarInfo(NickField, NomeField, DDDField, CodCddField, NumUsuarioField, EmailField, EndField, PaisField, EstadoField, CityField, Mensagem);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testGetUsuario() {
        System.out.println("getUsuario");
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("lucasteste");
        instance.setSenha("12345678");
        instance.createCon();
        String expResult = "lucasteste";
        String result = instance.getUsuario();
        assertEquals(result, expResult);
    }
    
    @Test
    public void testGetSenha() {
        System.out.println("getSenha");
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("lucasteste");
        instance.setSenha("12345678");
        instance.createCon();
        String expResult = "";
        String result = instance.getSenha();
        assertEquals(result, expResult);
 
    }
    
    @Test
    public void testRetornaCon() {
        System.out.println("retornaCon");
        UserConexaoDB instance = new UserConexaoDB();
        Connection expResult = null;
        Connection result = instance.retornaCon();
        assertEquals(result, expResult);
    }

    /**
     * Test of fecharConexao method, of class UserConexaoDB.
     */
    @Test
    public void testFecharConexao() {
        System.out.println("fecharConexao");
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("lucasteste");
        instance.setSenha("12345678");
        instance.createCon();
        instance.fecharConexao();
    }

    @Test
    public void testFecharConexao0() {
        System.out.println("fecharConexao");
        UserConexaoDB instance = new UserConexaoDB();
        instance.fecharConexao();
    }
}