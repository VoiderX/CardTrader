/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
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
public class UtilidadesNGTest {
    
    public UtilidadesNGTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    //funcionando normal com uma string
    @Test
    public void testFirstToUpper(){
        
        String test = "";
        
        test = Utilidades.firstToUpper("teste");
        
        assertEquals("Teste", test);
        
    }
    
    //Normal com mais de uma string
    @Test
    public void testFirstToUpper2(){
        
        String test = "";
        
        test = Utilidades.firstToUpper("teste teste");
        
        System.out.println(test);
        assertEquals("Teste Teste", test);
        
    }
    
    //Como a função firstToUpper é utilizada somente para mostrar os dados do banco de dados e os dados inseridos
    //são verificados por expressões regulares casos do tipo teste 1teste não retornarão resultado esperado (Teste 1Teste).
    //Normal com mais de uma string
    @Test
    public void testFirstToUpper3(){
        
        String test = "";
        
        test = Utilidades.firstToUpper("teste 1teste");
        
        System.out.println(test);
        assertNotEquals("Teste 1Teste", test);
        
    }
    
    @Test
    public void testFirstToUpper4(){
        
        String test = "";
        
        test = Utilidades.firstToUpper("1teste");
        
        System.out.println(test);
        assertNotEquals("1Teste", test);
        
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
}
    
   