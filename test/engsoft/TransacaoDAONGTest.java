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









    @Test
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
    
     @Test
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
    
         @Test
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
    
             @Test
    public void testComprarCarta2() {
        System.out.println("comprarCarta");
         UserConexaoDB instance = new UserConexaoDB();
        instance.setUsuario("fulano1");
        instance.setSenha("123456");
        instance.createCon();
        engsoft.ControleUI.getInstance().setConexaoUser(instance);
        String NickVendedor = "lucasteste";
        String NickComprador = "fulano1";
        int CartaId = 9;
        int Quantidade = 1;
        float Valor = 2.0F;
        String expResult = "Transação efetuada com sucesso!";
        String result = TransacaoDAO.comprarCarta(NickVendedor, NickComprador, CartaId, Quantidade, Valor);
        assertEquals(result, expResult);
    }
    
}