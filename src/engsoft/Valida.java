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
    public boolean validaLogin(TextField text, PasswordField pass, Text mens){
        if(text.getText().isEmpty()){
            mens.setText("Usuário Vazio");
            return(false);
        }else if(pass.getText().isEmpty()){
            mens.setText("Senha vazia");
            return(false);
        }else{
            return(true);
        }
    }
    
    //Métodos de validação da Recuperação de senhas
    public boolean validaSenha(TextField text, PasswordField pass, Text mens){
        if(text.getText().isEmpty()){
            mens.setText("Usuário Vazio");
            return(false);
        }else if(pass.getText().isEmpty()){
            mens.setText("Senha vazia");
            return(false);
        }else if(pass.getText().length() < 6){
            mens.setText("Senha muito curta");
            return(false);
        }else if(pass.getText().length() > 15){
            mens.setText("Senha muito longa");
            return(false);
        }else{
            return(true);
        }
    }
    
    //Métodos para validar cadastro
    public boolean testaCadastro(TextField nick,TextField nome,TextField end,TextField num,TextField email, ChoiceBox cidade,PasswordField pass,Text mens){
        boolean nickB = validaNick(num, mens);
        boolean nomeB = validaNome(nome, mens);
        boolean endB = validaEnd(end, mens);
        boolean numB = validaNum(num, mens);
        boolean emailB = validaEmail(end, mens);
        boolean cidadeB = validaCidade(cidade, mens);
        boolean passB = validaPass(pass, mens);
        if(nickB || nomeB || endB || numB || emailB || cidadeB || passB){
            return(true);
        }else{
            return(false);
        }
    }
    
    public boolean validaNick(TextField nick,Text mens){
        String pattern = "[a-z][a-z0-9]*";
        Pattern test = Pattern.compile(pattern);
        Matcher matcher = test.matcher(nick.getText());
        if(nick.getText().isEmpty()){
            mens.setText("nickname vazio.");
            return(false);
        }else if(matcher.matches()){
            mens.setText("nickname não pode começar com numeros ou ter caracteres especiais.");
            return(false);
        }else if(nick.getText().length() < 6){
            mens.setText("nickname muito curto.");
            return(false);
        }else if(nick.getText().length() > 25){
            mens.setText("nickname muito longo.");
            return(false);
        }else{
            return(true);
        }
    }
    
    public boolean validaNome(TextField nome,Text mens){
        if(nome.getText().isEmpty()){
            appendText(mens,"Nome vazio.");
            return(false);
        }else if(nome.getText().length() > 50){
            appendText(mens,"Nome muito grande.");
            return(false);
        }else{
            return(true);
        }
    }
    
    public boolean validaNum(TextField num,Text mens){
        String pattern = "(\\(0?[0-9]{2}\\))[0-9]?[0-9]{4}\\-[0-9]{4}";
        Pattern test = Pattern.compile(pattern);
        Matcher matcher = test.matcher(num.getText());
        if(num.getText().isEmpty()){
            appendText(mens,"Telefone vazio.");
            return(false);
        }else if(matcher.matches()){
            appendText(mens,"Telefone não reconhecido.");
            return(false);
        }else{
            return(true);
        }
    }
    
    public boolean validaEmail(TextField email,Text mens){
        String pattern = "([a-zA-Z])(.+)*@(.+)\\.(.+)";
        Pattern test = Pattern.compile(pattern);
        Matcher matcher = test.matcher(email.getText());
        if(email.getText().isEmpty()){
            appendText(mens, "Email vazio.");
            return(false);
        }else if(matcher.matches()){
            appendText(mens,"Email não válido.");
            return(false);
        }else{
            return(true);
        }
    }
    
    
    
    public boolean validaEnd(TextField end,Text mens){
        if(end.getText().isEmpty()){
            appendText(mens,"Endereço vazio.");
            return(false);
        }else if(end.getText().length() > 50){
            appendText(mens,"Endereço muito grande.");
            return(false);
        }else{
            return(true);
        }
    }
    
    public boolean validaCidade(ChoiceBox cidade,Text mens){
        if(cidade.getSelectionModel().isEmpty()){
            appendText(mens, "Selecione país,estado e cidade válidos.");
            return(false);
        }else{
            return(true);
        }
    }
    
    public boolean validaPass(PasswordField pass,Text mens){
        if(pass.getText().isEmpty()){
            appendText(mens,"Senha vazia.");
            return(false);
        }else if(pass.getText().contains(" ")){
            appendText(mens,"Senha não pode conter espaços.");
            return(false);
        }else if(pass.getText().length() < 6){
            appendText(mens,"Senha muito curta.");
            return(false);
        }else if(pass.getText().length() > 20){
            appendText(mens,"Senha muito longa.");
            return(false);
        }else{
            return(true);
        }
    }
    
    private void appendText(Text mens,String text){
        String orig = mens.getText();
        mens.setText(orig+" "+text);
    }
}
