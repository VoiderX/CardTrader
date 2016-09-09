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
 * @author noda2
 */
public class ValidaNGTest {
    
    public ValidaNGTest() {
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
     * Teste de método validaLogin, da classe Valida.
     */
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
    
    @Test 
    public void emptyValidaNome(){
        String nome = "";
        StringBuilder msg = new StringBuilder("");
        boolean retorno;
        retorno = Valida.validaNome(nome, msg);
        assertFalse(retorno);
        assertTrue(msg.toString().equals(" Nome vazio."));       
    }
    
    @Test 
    public void longValidaNome(){
        String nome = "FernandaDeboraMariaArianeNataliaCamilaSandaMariluciaViviane";
        StringBuilder msg = new StringBuilder("");
        boolean retorno;
        retorno = Valida.validaNome(nome, msg);
        assertFalse(retorno);
        assertTrue(msg.toString().equals(" Nome muito grande."));
            
    }

    @Test 
    public void normalValidaNum(){
        String num = "4399022422";
        StringBuilder msg = new StringBuilder("");
        boolean retorno;
        retorno = Valida.validaNum(num, msg);
        assertTrue(retorno);
        assertTrue(msg.toString().equals(""));       
    }
    
    @Test 
    public void emptyValidaNum(){
        String num = "";
        StringBuilder msg = new StringBuilder("");
        boolean retorno;
        retorno = Valida.validaNum(num, msg);
        assertFalse(retorno);
        assertTrue(msg.toString().equals(" Telefone vazio."));       
    }
    
    @Test 
    public void anormalValidaNum(){
        String num = "019995979234574032033333";
        StringBuilder msg = new StringBuilder("");
        boolean retorno;
        retorno = Valida.validaNum(num, msg);
        assertFalse(retorno);
        assertTrue(msg.toString().equals(" Telefone não reconhecido."));       
    }    
    
    @Test 
    public void normalValidaEmail(){
        String email = "asdfg@gmail.com";
        StringBuilder msg = new StringBuilder("");
        boolean retorno;
        retorno = Valida.validaEmail(email, msg);
        assertTrue(retorno);
        assertTrue(msg.toString().equals(""));       
    }
    @Test
        public void emptyValidaEmail(){
        String email = "";
        StringBuilder msg = new StringBuilder("");
        boolean retorno;
        retorno = Valida.validaEmail(email, msg);
        assertFalse(retorno);
        assertTrue(msg.toString().equals(" Email vazio."));       
    }
    
    @Test 
    public void anormalValidaEmail(){
        String email = "@_www";
        StringBuilder msg = new StringBuilder("");
        boolean retorno;
        retorno = Valida.validaEmail(email, msg);
        assertFalse(retorno);
        assertTrue(msg.toString().equals(" Email não válido."));       
    } 
    
    @Test 
    public void normalValidaEnd(){
        String end = "Avenida da Rua numero 789 Bairro da Rua";
        StringBuilder msg = new StringBuilder("");
        boolean retorno;
        retorno = Valida.validaEnd(end, msg);
        assertTrue(retorno);
        assertTrue(msg.toString().equals(""));       
    }
    
        @Test
        public void emptyValidaEnd(){
            String end = "";
            StringBuilder msg = new StringBuilder("");
            boolean retorno;
            retorno = Valida.validaEnd(end, msg);
            assertFalse(retorno);
            assertTrue(msg.toString().equals(" Endereço vazio."));       
    }
    
    @Test 
    public void longValidaEnd(){
        String end = "CarolinaLiviaFernandaDeboraMariaArianeNataliaCamilaSandaMariluciaViviane";
        StringBuilder msg = new StringBuilder("");
        boolean retorno;
        retorno = Valida.validaEnd(end, msg);
        assertFalse(retorno);
        assertTrue(msg.toString().equals(" Endereço muito grande."));
    }
    
     @Test 
    public void normalValidaCidade(){
        String cidade = "Lucas do Rio Verde";
        StringBuilder msg = new StringBuilder("");
        boolean retorno;
        retorno = Valida.validaCidade(cidade, msg);
        assertTrue(retorno);
        assertTrue(msg.toString().equals(""));       
    }
    
    @Test 
    public void normalValidaPass(){
        String pass = "123456";
        StringBuilder msg = new StringBuilder("");
        boolean retorno;
        retorno = Valida.validaPass(pass, msg);
        assertTrue(retorno);
        assertTrue(msg.toString().equals(""));       
    }
    
     @Test 
    public void menorValidaPass(){
        String pass = "1234";
        StringBuilder msg = new StringBuilder("");
        boolean retorno;
        retorno = Valida.validaPass(pass, msg);
        assertFalse(retorno);
        assertTrue(msg.toString().equals(" Senha muito curta."));       
    }
    
    @Test 
    public void maiorValidaPass(){
        String pass = "LarissaNathalia12345678";
        StringBuilder msg = new StringBuilder("");
        boolean retorno;
        retorno = Valida.validaPass(pass, msg);
        assertFalse(retorno);
        assertTrue(msg.toString().equals(" Senha muito longa."));     
    }
    
    @Test 
    public void spaceValidaPass(){
        String pass = " ";
        StringBuilder msg = new StringBuilder("");
        boolean retorno;
        retorno = Valida.validaPass(pass, msg);
        assertFalse(retorno);
        assertTrue(msg.toString().equals(" Senha não pode conter espaços."));     
    }
    
}
