package Testes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import engsoft.Valida;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author André Costa Lopes
 */
public class testeValida {
    
    public testeValida() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    //Teste funcionando como deveria
    @Test
    public void validaloginVerdade(){
        
        boolean estado;
        StringBuilder mens = new StringBuilder("");
        
        estado = Valida.validaLogin("arch23","dezembro",mens);
        
        //pega o retorno da função
        assertEquals(true,estado);
        assertTrue(mens.toString().equals(""));
    
    }//end function
    
    @Test
    public void validaloginUsuario(){
        
        boolean estado;
        StringBuilder mens = new StringBuilder("");
        
        estado = Valida.validaLogin("","dezembro",mens);
        
        //pega o retorno da função
        assertEquals(false,estado);
        assertTrue(mens.toString().equals("Usuário Vazio."));
    
    }//end function
    
    @Test
    public void validaloginSenha(){
        
        boolean estado;
        StringBuilder mens = new StringBuilder("");
        
        estado = Valida.validaLogin("arch23","",mens);
        
        //pega o retorno da função
        assertEquals(false,estado);
        assertTrue(mens.toString().equals(" Senha vazia."));
    
    }//end function
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void teste(){
        
        
    }//endfunction

}//endclass
