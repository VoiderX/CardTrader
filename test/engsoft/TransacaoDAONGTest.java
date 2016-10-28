/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft;

import java.sql.Connection;
import java.util.ArrayList;
import javafx.collections.ObservableList;
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
public class TransacaoDAONGTest {
    
    public TransacaoDAONGTest() {
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

    @Test(priority = 8)
    public void testComprarCarta() {
        System.out.println("comprarCarta");
         UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("fulsano1");
        instance.setSenha("123456");
        instance.createCon();
        engsoft.ControleUI.getInstance().setConexaoUser(instance);
        String NickVendedor = "fulano1";
        String NickComprador = "fulano1";
        int CartaId = 10;
        int Quantidade = 99;
        float Valor = 2.0F;
        String expResult = "Erro ao realizar transação!";
        String result = TransacaoDAO.comprarCarta(NickVendedor, NickComprador, CartaId, Quantidade, Valor);
        assertEquals(result, expResult);
    }
    
     @Test(priority = 8)
    public void testComprarCarta0() {
        System.out.println("comprarCarta");
         UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("fulano1");
        instance.setSenha("123456");
        instance.createCon();
        engsoft.ControleUI.getInstance().setConexaoUser(instance);
        String NickVendedor = "fulano1";
        String NickComprador = "fulano1";
        int CartaId = 7;
        int Quantidade = 2;
        float Valor = 2.0F;
        String expResult = "Você não pode comprar de você mesmo!";
        String result = TransacaoDAO.comprarCarta(NickVendedor, NickComprador, CartaId, Quantidade, Valor);
        assertEquals(result, expResult);
    }
    
         @Test(priority = 8)
    public void testComprarCarta1() {
        System.out.println("comprarCarta");
         UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("fulano1");
        instance.setSenha("123456");
        instance.createCon();
        engsoft.ControleUI.getInstance().setConexaoUser(instance);
        String NickVendedor = "fulano1";
        String NickComprador = "fulano2";
        int CartaId = 87;
        int Quantidade = 2;
        float Valor = 2.0F;
        String expResult = "Valor ou Quantidade Inválidos!";
        String result = TransacaoDAO.comprarCarta(NickVendedor, NickComprador, CartaId, Quantidade, Valor);
        assertEquals(result, expResult);
    }
    
             @Test(priority = 8)
    public void testComprarCarta2() {
        System.out.println("comprarCarta");
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("fulano1");
        instance.setSenha("123456");
        instance.createCon();
        engsoft.ControleUI.getInstance().setConexaoUser(instance);
        String NickVendedor = "fulano1";
        String NickComprador = "fulano2";
        int CartaId = 7;
        int Quantidade = 1;
        float Valor = 2.0F;
        String expResult = "Transação efetuada com sucesso!";
        String result = TransacaoDAO.comprarCarta(NickVendedor, NickComprador, CartaId, Quantidade, Valor);
        assertEquals(result, expResult);
    }
    
        @Test(priority = 7)
        public void testVerificaUsuarios() {
        System.out.println("verificaUsuarios");
         UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("fulano1");
        instance.setSenha("123456");
        instance.createCon();
        engsoft.ControleUI.getInstance().setConexaoUser(instance);
        String User = "fulano1";
        boolean expResult = true;
        boolean result = TransacaoDAO.verificaUsuarios(User);
        assertEquals(result, expResult);
    }
        
        @Test(priority = 7)
        public void testVerificaUsuarios0() {
        System.out.println("verificaUsuarios");
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("fulano2");
        instance.setSenha("lucas12vinho");
        instance.createCon();
        engsoft.ControleUI.getInstance().setConexaoUser(instance);
        String User = "fulano2";
        boolean expResult = false;
        boolean result = TransacaoDAO.verificaUsuarios(User);
        assertEquals(result, expResult);
    }
        
        @Test(priority = 7)
        public void testVerificaUsuarios1() {
        System.out.println("verificaUsuarios");
         UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("fulano1");
        instance.setSenha("123f456");
        instance.createCon();
        engsoft.ControleUI.getInstance().setConexaoUser(instance);
        String User = "fulano1";
        TransacaoDAO.verificaUsuarios(User);
    }
        
    @Test(priority = 7)
    public void testMarcarRecebido() {
        System.out.println("marcarRecebido");
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("fulano2");
        instance.setSenha("lucas12vinho");
        instance.createCon();
        engsoft.ControleUI.getInstance().setConexaoUser(instance);
        String Vendedor = "";
        String Comprador = "";
        int IdCarta = 0;
        float Valor = 0.0F;
        TransacaoDAO.marcarRecebido(Vendedor, Comprador, IdCarta, Valor);
    }
    
     @Test(priority = 7)
    public void testMarcarRecebido0() {
        System.out.println("marcarRecebido");
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("fulano2");
        instance.setSenha("lucas1ee2vinho");
        instance.createCon();
        engsoft.ControleUI.getInstance().setConexaoUser(instance);
        String Vendedor = "";
        String Comprador = "";
        int IdCarta = 0;
        float Valor = 0.0F;
        TransacaoDAO.marcarRecebido(Vendedor, Comprador, IdCarta, Valor);
    }
    
    @Test(priority = 7)
    public void testMarcarPago() {
        System.out.println("marcarPago");
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("fulano2");
        instance.setSenha("lucas12vinho");
        instance.createCon();
        engsoft.ControleUI.getInstance().setConexaoUser(instance);
        String Vendedor = "fulano1";
        String Comprador = "fulado2";
        int IdCarta = 7;
        float Valor = 2.0F;
        String expResult = "Alteração Efetuada com Sucesso!";
        String result = TransacaoDAO.marcarPago(Vendedor, Comprador, IdCarta, Valor);
        assertEquals(result, expResult);
    }
    
    @Test(priority = 7)
    public void testMarcarPago0() {
        System.out.println("marcarPago");
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("fulano2");
        instance.setSenha("luca3s12vinho");
        instance.createCon();
        engsoft.ControleUI.getInstance().setConexaoUser(instance);
        String Vendedor = "fulano1";
        String Comprador = "fulado2";
        int IdCarta = 7;
        float Valor = 2.0F;
        TransacaoDAO.marcarPago(Vendedor, Comprador, IdCarta, Valor);
    } 
    
    @Test(priority = 7)
    public void testRetornaVendas() {
        System.out.println("retornaVendas");
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("fulano2");
        instance.setSenha("lucas12vinho");
        instance.createCon();
        engsoft.ControleUI.getInstance().setConexaoUser(instance);
        TransacaoDAO.retornaVendas();  
    }
    
    @Test(priority = 7)
    public void testRetornaVendas0() {
        System.out.println("retornaVendas");
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("fulano2");
        instance.setSenha("luca3s12vinho");
        instance.createCon();
        engsoft.ControleUI.getInstance().setConexaoUser(instance);
        TransacaoDAO.retornaVendas();  
    }
    
    @Test(priority = 7)
    public void testRetornaVendas1() {
        System.out.println("retornaVendas");
        UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("fulano");
        instance.setSenha("lucas12vinho");
        instance.createCon();
        engsoft.ControleUI.getInstance().setConexaoUser(instance);
        TransacaoDAO.retornaVendas();  
    }
}