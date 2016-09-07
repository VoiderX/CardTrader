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

    //Teste validaLogin() funcionando como deveria
    @Test
    public void validaloginVerdade(){
        
        boolean estado;
        StringBuilder mens = new StringBuilder("");
        
        estado = Valida.validaLogin("arch23","dezembro",mens);
        
        //pega o retorno da função
        assertTrue(estado);
        assertTrue(mens.toString().equals(""));
    
    }//end function
    
    //Teste validaLogin() Usuário Vazio.
    @Test
    public void validaloginUsuario(){
        
        boolean estado;
        StringBuilder mens = new StringBuilder("");
        
        estado = Valida.validaLogin("","dezembro",mens);
        
        //pega o retorno da função
        assertFalse(estado);
        assertTrue(mens.toString().equals("Usuário Vazio."));
    
    }//end function
    
    //Teste validaLogin() Senha vazia.
    @Test
    public void validaloginSenha(){
        
        boolean estado;
        StringBuilder mens = new StringBuilder("");
        
        estado = Valida.validaLogin("arch23","",mens);
        
        //pega o retorno da função
        assertFalse(estado);
        assertTrue(mens.toString().equals("Senha vazia."));
    
    }//end function
    
    //Teste validaSenha() funcionando como deveria
    @Test
    public void validasenhaVerdade(){
    
        boolean estado;
        StringBuilder mens = new StringBuilder("");
        
        estado = Valida.validaSenha("arch23","dezembro",mens);
        
        //pega o retorno da função
        assertTrue(estado);
        assertTrue(mens.toString().equals(""));
        
    }//end function
    
    //Teste validaSenha() - 1º if
    @Test
    public void validasenhaUsuarioVazio(){
    
        boolean estado;
        StringBuilder mens = new StringBuilder("");
        
        estado = Valida.validaSenha("","dezembro",mens);
        
        //pega o retorno da função
        assertFalse(estado);
        assertTrue(mens.toString().equals("Usuário Vazio"));
        
    }//end function
    
    //Teste validaSenha() - 2º if
    @Test
    public void validasenhaVazia(){
    
        boolean estado;
        StringBuilder mens = new StringBuilder("");
        
        estado = Valida.validaSenha("arch23","",mens);
        
        //pega o retorno da função
        assertFalse(estado);
        assertTrue(mens.toString().equals(" Senha vazia"));
        
    }//end function
    
    //Teste validaSenha() - 3º if
    @Test
    public void validasenhaMenor(){
    
        boolean estado;
        StringBuilder mens = new StringBuilder("");
        
        estado = Valida.validaSenha("arch23","23454",mens);
        
        //pega o retorno da função
        assertFalse(estado);
        assertTrue(mens.toString().equals(" Senha muito curta"));
        
    }//end function
    
    //Teste validaSenha() - 4º if
    @Test
    public void validasenhaMaior(){
    
        boolean estado;
        StringBuilder mens = new StringBuilder("");
        
        estado = Valida.validaSenha("arch23","23454a36ert23562",mens);
        
        //pega o retorno da função
        assertFalse(estado);
        assertTrue(mens.toString().equals(" Senha muito longa"));
        
    }//end function
   
    //Teste validaNick() - verdadeiro
    @Test
    public void verdadevalidaNick(){
        
        String nick = "arch23";
        boolean estado;
        StringBuilder mens = new StringBuilder("");
        
        estado = Valida.validaNick(nick,mens);
        
        //pega o retorno da função
        assertTrue(estado);
        assertTrue(mens.toString().equals(""));
        
    }//end funcion
    
    //Teste validaNick() - 1º if
    @Test
    public void nickvalidaNick(){
        
        String nick = "";
        boolean estado;
        StringBuilder mens = new StringBuilder("");
        
        estado = Valida.validaNick(nick,mens);
        
        //pega o retorno da função
        assertFalse(estado);
        assertTrue(mens.toString().equals("Nickname vazio."));
        
    }//end function
    
    //teste validaNick() - 2º if - caracteres especiais
    @Test
    public void charactervalidaNick(){
        
        String nick = "arch23)é";
        boolean estado;
        StringBuilder mens = new StringBuilder("");
        
        estado = Valida.validaNick(nick,mens);
        
        //pega o retorno da função
        assertFalse(estado);
        assertTrue(mens.toString().equals("Nickname não pode começar com numeros ou ter caracteres especiais."));
        
    }//end function
    
    //Teste validaNick() - 3º if - nickname curto
    @Test
    public void shortvalidaNick(){
        
        String nick = "arch2";
        boolean estado;
        StringBuilder mens = new StringBuilder("");
        
        estado = Valida.validaNick(nick,mens);
        
        //pega o retorno da função
        assertFalse(estado);
        assertTrue(mens.toString().equals("Nickname muito curto."));
        
    }//end function
    
    @Test
    public void longvalidaNick(){
        
        String nick = "arch231sdfsdfsdfsdfse223573";
        boolean estado;
        StringBuilder mens = new StringBuilder("");
        
        estado = Valida.validaNick(nick,mens);
        
        //pega o retorno da função
        assertFalse(estado);
        assertTrue(mens.toString().equals("nickname muito longo."));
        
    }//end function
    
    @Test
    public void truevalidaNome(){
        
        String nome = "Andre Costa Lopes";
        boolean estado;
        StringBuilder mens = new StringBuilder("");
        
        estado = Valida.validaNome(nome,mens);
        
        //pega o retorno da função
        assertTrue(estado);
        assertTrue(mens.toString().equals(""));
        
    }//end function
    
    
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    
    

}//endclass
