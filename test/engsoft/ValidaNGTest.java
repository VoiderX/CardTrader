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
    public void validaLoginVerdade(){
        
        boolean estado;
        StringBuilder mens = new StringBuilder("");
        
        estado = Valida.validaLogin("arch23","dezembro",mens);
        
        //pega o retorno da função
        assertTrue(estado);
        assertTrue(mens.toString().equals(""));
    
    }//end function
    
    //Teste validaLogin() Usuário Vazio.
    @Test
    public void validaLoginUsuario(){
        
        boolean estado;
        StringBuilder mens = new StringBuilder("");
        
        estado = Valida.validaLogin("","dezembro",mens);
        
        //pega o retorno da função
        assertFalse(estado);
        assertTrue(mens.toString().equals("Usuário Vazio."));
    
    }//end function
    
    //Teste validaLogin() Senha vazia.
    @Test
    public void validaLoginSenha(){
        
        boolean estado;
        StringBuilder mens = new StringBuilder("");
        
        estado = Valida.validaLogin("arch23","",mens);
        
        //pega o retorno da função
        assertFalse(estado);
        assertTrue(mens.toString().equals("Senha vazia."));
    
    }//end function
    
    //Teste validaSenha() funcionando como deveria
    @Test
    public void validaSenhaVerdade(){
    
        boolean estado;
        StringBuilder mens = new StringBuilder("");
        
        estado = Valida.validaSenha("arch23","dezembro",mens);
        
        //pega o retorno da função
        assertTrue(estado);
        assertTrue(mens.toString().equals(""));
        
    }//end function
    
    //Teste validaSenha() - 1º if
    @Test
    public void validaSenhaUsuarioVazio(){
    
        boolean estado;
        StringBuilder mens = new StringBuilder("");
        
        estado = Valida.validaSenha("","dezembro",mens);
        
        //pega o retorno da função
        assertFalse(estado);
        assertTrue(mens.toString().equals("Usuário Vazio"));
        
    }//end function
    
    //Teste validaSenha() - 2º if
    @Test
    public void validaSenhaVazia(){
    
        boolean estado;
        StringBuilder mens = new StringBuilder("");
        
        estado = Valida.validaSenha("arch23","",mens);
        
        //pega o retorno da função
        assertFalse(estado);
        assertTrue(mens.toString().equals(" Senha vazia"));
        
    }//end function
    
    //Teste validaSenha() - 3º if
    @Test
    public void validaSenhaMenor(){
    
        boolean estado;
        StringBuilder mens = new StringBuilder("");
        
        estado = Valida.validaSenha("arch23","23454",mens);
        
        //pega o retorno da função
        assertFalse(estado);
        assertTrue(mens.toString().equals(" Senha muito curta"));
        
    }//end function
    
    //Teste validaSenha() - 4º if
    @Test
    public void validaSenhaMaior(){
    
        boolean estado;
        StringBuilder mens = new StringBuilder("");
        
        estado = Valida.validaSenha("arch23","23454a36ert23562",mens);
        
        //pega o retorno da função
        assertFalse(estado);
        assertTrue(mens.toString().equals(" Senha muito longa"));
        
    }//end function
   
    //Teste validaNick() - verdadeiro
    @Test
    public void verdadeValidaNick(){
        
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
    public void nickValidaNick(){
        
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
    public void characterValidaNick(){
        
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
    public void shortValidaNick(){
        
        String nick = "arch2";
        boolean estado;
        StringBuilder mens = new StringBuilder("");
        
        estado = Valida.validaNick(nick,mens);
        
        //pega o retorno da função
        assertFalse(estado);
        assertTrue(mens.toString().equals("Nickname muito curto."));
        
    }//end function
    
    @Test
    public void longValidaNick(){
        
        String nick = "arch231sdfsdfsdfsdfse223573";
        boolean estado;
        StringBuilder mens = new StringBuilder("");
        
        estado = Valida.validaNick(nick,mens);
        
        //pega o retorno da função
        assertFalse(estado);
        assertTrue(mens.toString().equals("nickname muito longo."));
        
    }//end function
    
    @Test
    public void trueValidaNome(){
        
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
    public void emptyValidaCidade(){
        String cidade = "";
        StringBuilder msg = new StringBuilder("");
        boolean retorno;
        retorno = Valida.validaCidade(cidade, msg);
        assertFalse(retorno);
        assertTrue(msg.toString().equals(" Selecione país,estado e cidade válidos."));  
    }
    
    @Test
    public void emptyValidaPass(){
        String pass = "";
        StringBuilder msg = new StringBuilder("");
        boolean retorno;
        retorno = Valida.validaPass(pass, msg);
        assertFalse(retorno);
        assertTrue(msg.toString().equals(" Senha vazia.")); 
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
    
    @Test
    public void validaValidaCadastro(){
        StringBuilder mens = new StringBuilder("");
        boolean retorno = Valida.validaCadastro("arch23","Vinicius Noda","Endereço hue","4396045728","noda.23@hotmail.com","Cornélio","huehue",mens);
        assertTrue(retorno);
        assertTrue(mens.toString().equals(""));
    }
    
    @Test
    public void falseNickValidaCadastro(){
        StringBuilder mens = new StringBuilder("");
        boolean retorno = Valida.validaCadastro("","Vinicius Noda","Endereço hue","4396045728","noda.23@hotmail.com","Cornélio","huehue",mens);
        assertFalse(retorno);
        assertTrue(mens.toString().equals("Nickname vazio."));
    }
    
    @Test
    public void falseNomeValidaCadastro(){
        StringBuilder mens = new StringBuilder("");
        boolean retorno = Valida.validaCadastro("arch23","","Endereço hue","4396045728","noda.23@hotmail.com","Cornélio","huehue",mens);
        assertFalse(retorno);
        assertTrue(mens.toString().equals(" Nome vazio."));
    }
    
    @Test
    public void falseEndValidaCadastro(){
        StringBuilder mens = new StringBuilder("");
        boolean retorno = Valida.validaCadastro("arch23","Vinicius Noda","","4396045728","noda.23@hotmail.com","Cornélio","huehue",mens);
        assertFalse(retorno);
        assertTrue(mens.toString().equals(" Endereço vazio."));
    }
    
    @Test
    public void falseNumValidaCadastro(){
        StringBuilder mens = new StringBuilder("");
        boolean retorno = Valida.validaCadastro("arch23","Vinicius Noda","Endereço Hue","","noda.23@hotmail.com","Cornélio","huehue",mens);
        assertFalse(retorno);
        assertTrue(mens.toString().equals(" Telefone vazio."));
    }
    
    @Test
    public void falseEmailValidaCadastro(){
        StringBuilder mens = new StringBuilder("");
        boolean retorno = Valida.validaCadastro("arch23","Vinicius Noda","Endereço Hue","4396045728","","Cornélio","huehue",mens);
        assertFalse(retorno);
        assertTrue(mens.toString().equals(" Email vazio."));
    }
    
    @Test
    public void falseCidadeValidaCadastro(){
        StringBuilder mens = new StringBuilder("");
        boolean retorno = Valida.validaCadastro("arch23","Vinicius Noda","Endereço Hue","4396045728","noda.23@hotmail.com","","huehue",mens);
        assertFalse(retorno);
        assertTrue(mens.toString().equals(" Selecione país,estado e cidade válidos."));
    }
    
    @Test
    public void falsePassValidaCadastro(){
        StringBuilder mens = new StringBuilder("");
        boolean retorno = Valida.validaCadastro("arch23","Vinicius Noda","Endereço Hue","4396045728","noda.23@hotmail.com","Cornélio","",mens);
        assertFalse(retorno);
        assertTrue(mens.toString().equals(" Senha vazia."));
    }
    
    @Test void validaValidaAlterarCadastro(){
        StringBuilder mens = new StringBuilder("");
        boolean retorno = Valida.validaAltCadastro("Vinicius Noda","Endereço hue","4396045728","noda.23@hotmail.com","Cornélio",mens);
        assertTrue(retorno);
        assertTrue(mens.toString().equals(""));
    }
    
    @Test
    public void falseNomeAltValidaCadastro(){
        StringBuilder mens = new StringBuilder("");
        boolean retorno = Valida.validaAltCadastro("","Endereço hue","4396045728","noda.23@hotmail.com","Cornélio",mens);
        assertFalse(retorno);
        assertTrue(mens.toString().equals(" Nome vazio."));
    }
    
    @Test
    public void falseEndAltValidaCadastro(){
        StringBuilder mens = new StringBuilder("");
        boolean retorno = Valida.validaAltCadastro("Vinicius Noda","","4396045728","noda.23@hotmail.com","Cornélio",mens);
        assertFalse(retorno);
        assertTrue(mens.toString().equals(" Endereço vazio."));
    }
    
    @Test
    public void falseNumAltValidaCadastro(){
        StringBuilder mens = new StringBuilder("");
        boolean retorno = Valida.validaAltCadastro("Vinicius Noda","Endereço hue","","noda.23@hotmail.com","Cornélio",mens);
        assertFalse(retorno);
        assertTrue(mens.toString().equals(" Telefone vazio."));
    }
    
    @Test
    public void falseEmailAltValidaCadastro(){
        StringBuilder mens = new StringBuilder("");
        boolean retorno = Valida.validaAltCadastro("Vinicius Noda","Endereço hue","4396045728","","Cornélio",mens);
        assertFalse(retorno);
        assertTrue(mens.toString().equals(" Email vazio."));
    }
    
    @Test
    public void falseCidadeAltValidaCadastro(){
        StringBuilder mens = new StringBuilder("");
        boolean retorno = Valida.validaAltCadastro("Vinicius Noda","Endereço hue","4396045728","noda.23@hotmail.com","",mens);
        assertFalse(retorno);
        assertTrue(mens.toString().equals(" Selecione país,estado e cidade válidos."));
    }
    
    @Test
    public void validaCons(){
        Valida obj = new Valida();
    }
}
