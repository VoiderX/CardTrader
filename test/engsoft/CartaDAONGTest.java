/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft;

import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
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
public class CartaDAONGTest {
    
    public CartaDAONGTest() {
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
     * Test of puxarCarta method, of class CartaDAO.
     */
    @Test
    public void testPuxarCarta() {
        System.out.println("puxarCarta");
        int id = 1;
        Image expResult = null;
        Image result = CartaDAO.puxarCarta(id);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of retornaInfoCard method, of class CartaDAO.
     */
    @Test
    public void testRetornaInfoCard() {
        System.out.println("retornaInfoCard");
        ObservableList expResult = null;
        ObservableList result = CartaDAO.retornaInfoCard();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retornaNomeCard method, of class CartaDAO.
     */
    @Test
    public void testRetornaNomeCard() {
        System.out.println("retornaNomeCard");
        int IdCarta = 0;
        String expResult = "";
        String result = CartaDAO.retornaNomeCard(IdCarta);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retornaDescCard method, of class CartaDAO.
     */
    @Test
    public void testRetornaDescCard() {
        System.out.println("retornaDescCard");
        int IdCarta = 0;
        String expResult = "";
        String result = CartaDAO.retornaDescCard(IdCarta);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retornaCartas method, of class CartaDAO.
     */
    @Test
    public void testRetornaCartas() {
        System.out.println("retornaCartas");
        ArrayList expResult = null;
        ArrayList result = CartaDAO.retornaCartas();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
