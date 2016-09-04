/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author noda2
 */
public final class Valida {
    
    //Métodos de validação da login
    public static boolean validaLogin(String text, String pass,StringBuilder mens){
        mens.setLength(0);
        boolean ctrl=true;
        if(text.isEmpty()){
            mens.append("Usuário Vazio.");
            ctrl = false;
        }
        if(pass.isEmpty()){
            mens.append(" Senha vazia.");
            ctrl = false;
        }
        return(ctrl);
    }
    
    //Métodos de validação da Recuperação de senhas
    public static boolean validaSenha(String text, String pass, StringBuilder mens){
        mens.setLength(0);
        boolean ctrl = true;
        if(text.isEmpty()){
            mens.append("Usuário Vazio");
            ctrl = false;
        }
        if(pass.isEmpty()){
            mens.append(" Senha vazia");
            ctrl = false;
        }else if(pass.length() < 6){
            mens.append(" Senha muito curta");
            ctrl = false;
        }else if(pass.length() > 15){
            mens.append(" Senha muito longa");
            ctrl = false;
        }
        return(ctrl);
    }
    
    //Métodos para validar cadastro
    public static boolean validaCadastro(String nick,String nome,String end,String num,String email, String cidade,String pass,StringBuilder mens){
        mens.setLength(0);
        boolean nickB = validaNick(nick, mens);
        boolean nomeB = validaNome(nome, mens);
        boolean endB = validaEnd(end, mens);
        boolean numB = validaNum(num, mens);
        boolean emailB = validaEmail(email, mens);
        boolean cidadeB = validaCidade(cidade, mens);
        boolean passB = validaPass(pass, mens);
        return(nickB && nomeB && endB && numB && emailB && cidadeB && passB);
    }
    
    public static boolean validaAltCadastro(String nome,String end,String num,String email,String cidade,StringBuilder mens){
        mens.setLength(0);
        boolean nomeB = validaNome(nome, mens);
        boolean endB = validaEnd(end, mens);
        boolean numB = validaNum(num, mens);
        boolean emailB = validaEmail(email, mens);
        boolean cidadeB = validaCidade(cidade, mens);
        return(nomeB && endB && numB && emailB && cidadeB);
    }
    
    public static boolean validaNick(String nick,StringBuilder mens){
        String pattern = "[a-z][a-z0-9]*";
        Pattern test = Pattern.compile(pattern);
        Matcher matcher = test.matcher(nick);
        if(nick.isEmpty()){
            mens.append("Nickname vazio.");
            return(false);
        }else if(!matcher.matches()){
            mens.append("Nickname não pode começar com numeros ou ter caracteres especiais.");
            return(false);
        }else 
        if(nick.length() < 6){
            mens.append("Nickname muito curto.");
            return(false);
        }else
        if(nick.length() > 25){
            mens.append("nickname muito longo.");
            return(false);
        }else{
            return(true);
        }
    }
    
    public static boolean validaNome(String nome,StringBuilder mens){
        if(nome.isEmpty()){
            mens.append(" Nome vazio.");
            return(false);
        }else if(nome.length() > 50){
            mens.append(" Nome muito grande.");
            return(false);
        }else{
            return(true);
        }
    }
    
    public static boolean validaNum(String num,StringBuilder mens){
        String pattern = "0?[0-9]{2}[0-9]?[0-9]{4}[0-9]{4}";
        Pattern test = Pattern.compile(pattern);
        Matcher matcher = test.matcher(num);
        if(num.isEmpty()){
            mens.append(" Telefone vazio.");
            return(false);
        }else if(!matcher.matches()){
            mens.append(" Telefone não reconhecido.");
            return(false);
        }else{
            return(true);
        }
    }
    
    public static boolean validaEmail(String email,StringBuilder mens){
        String pattern = "([a-zA-Z])(.)*@(.+)\\.(.+)";
        Pattern test = Pattern.compile(pattern);
        Matcher matcher = test.matcher(email);
        if(email.isEmpty()){
            mens.append(" Email vazio.");
            return(false);
        }else if(!matcher.matches()){
            mens.append(" Email não válido.");
            return(false);
        }else{
            return(true);
        }
    }
    
    public static boolean validaEnd(String end,StringBuilder mens){
        if(end.isEmpty()){
            mens.append(" Endereço vazio.");
            return(false);
        }else if(end.length() > 50){
            mens.append(" Endereço muito grande.");
            return(false);
        }else{
            return(true);
        }
    }
    
    public static boolean validaCidade(String cidade,StringBuilder mens){
        if(cidade.isEmpty()){
            mens.append(" Selecione país,estado e cidade válidos.");
            return(false);
        }else{
            return(true);
        }
    }
    
    public static boolean validaPass(String pass,StringBuilder mens){
        if(pass.isEmpty()){
            mens.append(" Senha vazia.");
            return(false);
        }else if(pass.contains(" ")){
            mens.append(" Senha não pode conter espaços.");
            return(false);
        }else if(pass.length() < 6){
            mens.append(" Senha muito curta.");
            return(false);
        }else if(pass.length() > 20){
            mens.append(" Senha muito longa.");
            return(false);
        }else{
            return(true);
        }
    }
    
    
}
