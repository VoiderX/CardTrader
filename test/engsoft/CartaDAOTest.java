/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author André Costa Lopes
 */
public class CartaDAOTest {
    
    public CartaDAOTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

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
    
    //teste vai retornar a string BLASTOISE
    @Test
    public void retornaNomeTest(){
    
        assertEquals("Blastoise",CartaDAO.retornaNomeCard(2));
      
    }
    
    //teste vai ser diferente, pois o nome esta errado
    @Test
    public void retornaNomeTest2(){
    
        assertNotEquals("Blaziken",CartaDAO.retornaNomeCard(2));
      
    }
    
    //carta inexistente
    @Test
    public void retornaNomeTeste3(){
    
        assertNotEquals("",CartaDAO.retornaNomeCard(11));
      
    }
   
    
    //teste vai retornar a descricao de BLASTOISE
    @Test
    public void retornaDescCard1(){
        
        assertEquals("A brutal Pokémon with pressurized water jets on its shell. They are used for high-speed tackles.",CartaDAO.retornaDescCard(2));
        
    }
    
    

}
