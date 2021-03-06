/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
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


     
    @Test(priority = 6)
    public void testAlterarCadastro() {
        System.out.println("alterarCadastro");
        String NomeField = "Lucas B Tsuchiya";
        String EndField = "Avenida padre Paulo broda";
        String NumField = "1922224444";
        String EmailField = "patricia1995@gmail.com";
        String PaisField = "Brasil";
        String EstadoField = "PR";
        String CityField = "Londrina";
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("fulano1");
        instance.setSenha("123456");
        String expResult = "Nome de usuário ou email já utilizados!";
        instance.createCon();
        String result = instance.alterarCadastro(NomeField, NumField, EmailField, EndField, PaisField, EstadoField, CityField);
        assertEquals(result, expResult);     
        instance.fecharConexao();

    }
    @Test(priority = 6)
    public void testAlterarCadastroCerto() {
        System.out.println("alterarCadastro");
        String NomeField = "Lucas B Tsuchiya";
        String EndField = "Avenida padre Paulo broda";
        String NumField = "1922224444";
        String EmailField = "lucasteste156@gmail.com";
        String PaisField = "Brasil";
        String EstadoField = "PR";
        String CityField = "Londrina";
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("fulano1");
        instance.setSenha("123456");
        String expResult = "Dados atualizados com sucesso!";
        instance.createCon();
        String result = instance.alterarCadastro(NomeField, NumField, EmailField, EndField, PaisField, EstadoField, CityField);
        assertEquals(result, expResult);    
        instance.fecharConexao();

    }        

    @Test(priority = 7)
    public void testInsereCatalogo() {
        System.out.println("insereCatalogo1");
        int IdCarta = 1;
        int quant = 0;
        float valor = 0.0F;
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("fulano1");
        instance.setSenha("123456");
        instance.createCon();
        String expResult = "Quantidade inválida!";
        String result = instance.insereCatalogo(IdCarta, quant, valor);
        assertEquals(result, expResult);
        instance.fecharConexao();

    }

        @Test(priority = 7)
    public void testInsereCatalogo1() {
        System.out.println("insereCatalogo2");
        int IdCarta = 999;
        int quant = 9;
        float valor = 0.0F;
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("fulano1");
        instance.setSenha("123456");
        instance.createCon();
        String expResult = "Valor inválido";
        String result = instance.insereCatalogo(IdCarta, quant, valor);
        assertEquals(result, expResult);
         instance.fecharConexao();
    }
    
      @Test(priority = 7)
    public void testInsereCatalogo2() {
        System.out.println("insereCatalogo2");
        int IdCarta = 7;
        int quant = 17;
        float valor = 2.0F;
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("fulano1");
        instance.setSenha("123456");
        instance.createCon();
        String expResult = "Item inserido com sucesso!";
        String result = instance.insereCatalogo(IdCarta, quant, valor);
        assertEquals(result, expResult);
         instance.fecharConexao();
    }
    
    @Test(priority = 7)
    public void testInsereCatalogo3() {
        System.out.println("insereCatalogo2");
        int IdCarta = 8888;
        int quant = 17;
        float valor = 2.0F;
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("fulano1");
        instance.setSenha("123456");
        instance.createCon();
        String expResult = "Um erro ocorreu!";
        String result = instance.insereCatalogo(IdCarta, quant, valor);
        assertEquals(result, expResult);
         instance.fecharConexao();
    }
        @Test(priority = 7)
    public void testInsereCatalogo4() {
        System.out.println("insereCatalogo4");
        int IdCarta = 10;
        int quant = 5;
        float valor = 2.0F;
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("fulano2");
        instance.setSenha("lucas12vinho");
        instance.createCon();
        instance.insereCatalogo(IdCarta, quant, valor);        
        instance.fecharConexao();
    }
    
    @Test(priority = 6)
    public void testDeletaCatalogo() {
        System.out.println("deletaCatalogo");
        int IdCarta = 0;
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("fulano");
        instance.setSenha("123456");
        instance.createCon();
        instance.deletaCatalogo(IdCarta);
         instance.fecharConexao();
    }
    @Test(priority = 6)
    public void testDeletaCatalogo1() {
        System.out.println("deletaCatalogo");
        int IdCarta = 1;
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("fulano1");
        instance.setSenha("123456");
        instance.createCon();
        instance.deletaCatalogo(IdCarta);
         instance.fecharConexao();
    }
    
    @Test(priority = 6)
    public void testAlteraCatalogo() {
        System.out.println("alteraCatalogo");
        int IdCarta = 2;
        float valor = 1.0F;
        int quantidade = 2;
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("fulano1");
        instance.setSenha("123456");
        instance.createCon();
        instance.alteraCatalogo(IdCarta, valor, quantidade);
         instance.fecharConexao();
    }
    
        @Test(priority = 6)
    public void testAlteraCatalogo2() {
        System.out.println("alteraCatalogo");
        int IdCarta = 2;
        float valor = 1.0F;
        int quantidade = 2;
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("fulano12");
        instance.setSenha("123456");
        instance.createCon();
        instance.alteraCatalogo(IdCarta, valor, quantidade);
         instance.fecharConexao();
    }
    
    @Test(priority = 8)
    public void testRetornaInfoCarta() {
        System.out.println("retornaInfoCarta");
        int IdCarta = 10;
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("fulano2");
        instance.setSenha("lucas12vinho");
        instance.createCon();
        instance.retornaInfoCarta(IdCarta);
         instance.fecharConexao();
    }
    
    @Test(priority = 7)
    public void testRetornaInfoCarta2() {
        System.out.println("retornaInfoCarta");
        int IdCarta = 2;
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("fulano12");
        instance.setSenha("123456");
        instance.createCon();
        instance.retornaInfoCarta(IdCarta);
        instance.fecharConexao();
    }
    
    @Test(priority = 7)
    public void testRetornaCatalogo() {
        System.out.println("retornaCatalogo");
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("fulano1");
        instance.setSenha("123456");
        instance.createCon();
        instance.retornaCatalogo();
        instance.fecharConexao();

  
    }
    
    @Test(priority = 6)
    public void testRetornaCatalogo1() {
        System.out.println("retornaCatalogo");
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("fulano1");
        instance.setSenha("123456");
        instance.createCon();
        engsoft.ControleUI.getInstance().setConexaoUser(instance);
        ArrayList<Carta> c=engsoft.ControleUI.getInstance().getConexaoUser().retornaCatalogo();
         instance.fecharConexao();

    }
        @Test(priority = 6)
    public void testRetornaCatalogo2() {
        System.out.println("retornaCatalogo");
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("fulano12131231");
        instance.setSenha("123456");
        instance.createCon();
        engsoft.ControleUI.getInstance().setConexaoUser(instance);
        ArrayList<Carta> c=engsoft.ControleUI.getInstance().getConexaoUser().retornaCatalogo();
         instance.fecharConexao();

    }
    
    @Test(priority = 5)
    public void testPuxarInfo() {
        System.out.println("puxarInfo");
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("fulano1");
        instance.setSenha("123456");
        instance.createCon();
        engsoft.ControleUI.getInstance().setConexaoUser(instance);
        String NickField = "fulano1";
        String NomeField = "lucas tsuchiya";
        String EndField = "avenida padre paulo broda";
        String NumField = "1944443333";
        String EmailField = "patricia55@gmail.com";
        String PaisField = "Brasil";
        String EstadoField = "PR";
        String CityField = "Londrina";
        Usuario user=instance.puxarInfo();
        String NickField1 = user.getNickField();
        String NomeField1 = user.getNomeField();
        String EndField1 =  user.getEndField();
        String NumField1 =  user.getNumUsuarioField();
        String EmailField1 = user.getEmailField();
        String PaisField1 = user.getPaisField();
        String EstadoField1 = user.getEstadoField();
        String CityField1 = user.getCityField();
        assertEquals(NickField,NickField1);
        assertEquals(NomeField,NomeField1);
        assertEquals(EndField,EndField1);
        assertEquals(NumField,NumField1);
        assertEquals(EmailField,EmailField1);
        assertEquals(PaisField,PaisField1);
        assertEquals(EstadoField,EstadoField1);
        assertEquals(CityField,CityField1);
        user.getMensagem();
        user.getUsuario();
        instance.fecharConexao();
    }
        @Test(priority = 6)
    public void testPuxarInfo0() {
        System.out.println("puxarInfo");
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("fulano1");
        instance.setSenha("1234567");
        instance.createCon();
        engsoft.ControleUI.getInstance().setConexaoUser(instance);
        instance.puxarInfo();
        instance.fecharConexao();
        
    }
   
    
    @Test(priority = 6)
    public void testGetUsuario() {
        System.out.println("getUsuario");
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("lucasteste");
        instance.setSenha("12345678");
        instance.createCon();
        String expResult = "lucasteste";
        String result = instance.getUsuario();
        assertEquals(result, expResult);
         instance.fecharConexao();
    }
    
    @Test(priority = 6)
    public void testGetSenha() {
        System.out.println("getSenha");
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("lucasteste");
        instance.setSenha("12345678");
        instance.createCon();
        String expResult = "12345678";
        String result = instance.getSenha();
        assertEquals(result, expResult);
         instance.fecharConexao();
 
    }
    
    @Test(priority = 6)
    public void testRetornaCon() {
        System.out.println("retornaCon");
        UserConexaoDB instance = new UserConexaoDB();
        Connection expResult = null;
        Connection result = instance.retornaCon();
        assertEquals(result, expResult);
         instance.fecharConexao();
    }

  
    @Test(priority = 6)
    public void testFecharConexao() {
        System.out.println("fecharConexao");
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("fulano1");
        instance.setSenha("123456");
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