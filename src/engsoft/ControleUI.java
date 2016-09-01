/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft;

import java.io.IOException;
import java.sql.Connection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Gabriel
 */
public final class ControleUI{

    public static Scene getLoginScene() {//Metodos para controle de comunicação de interfaces
        return LoginScene;
    }

    public static Scene getCadastroScene() {
        return CadastroScene;
    }

    public static Scene getMenuScene() {
        return MenuScene;
    }

    public static Scene getAlteraScene() {
        return AlteraScene;
    }
    private String user;

    private ControleUI(){};
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    Connection conUser;

    public void setConUser(Connection conUser) {
        this.conUser = conUser;
    }

    public Connection getConUser() {
        return conUser;
    }
    
    
     private static ControleUI INSTANCE = null;
    
    public static ControleUI getInstance(){
        return((INSTANCE == null)?INSTANCE = new ControleUI():INSTANCE);
    }
    
    public void start(Stage primaryStage) throws Exception {
        mainStage = primaryStage;
        initUI();
    }    
    
    private static Parent LoginFXML;
    private static Parent CadastroFXML;
    private static Parent MenuFXML;
    private static Parent AlteraCadastroFXML;
    
    private static Scene LoginScene;
    private static Scene CadastroScene;
    private static Scene MenuScene;
    private static Scene AlteraScene;
    
    private static Stage mainStage;
    
    
    
    private void initUI(){
        mainStage.centerOnScreen();
        mainStage.setTitle("Sistema de Cartas");
        
        try {
            LoginFXML = FXMLLoader.load(getClass().getResource("Fxml/Login.fxml"));
            CadastroFXML=FXMLLoader.load(getClass().getResource("Fxml/Cadastro.fxml"));
            MenuFXML=FXMLLoader.load(getClass().getResource("Fxml/Menu.fxml"));            
            
        } catch (IOException ex) {
            //fazer algo para mostrar erro
            System.out.println("Erro" + ex);
        }
        LoginScene = new Scene(LoginFXML);
        CadastroScene=new Scene(CadastroFXML);
        MenuScene=new Scene(MenuFXML);
        
        mostraLogin();
    }
   
    public void mostraLogin(){
        mainStage.setScene(LoginScene);
        mainStage.show();    
    }
    
    public void mostraCadastro(){
        mainStage.setScene(CadastroScene);
        mainStage.show();
    }
    public void mostraMenu(){
        mainStage.setScene(MenuScene);
        mainStage.show();
    }
    public void mostraAlterCadastro(){
        try{
        AlteraCadastroFXML=FXMLLoader.load(getClass().getResource("Fxml/AlteraCadastro.fxml"));
        }catch(Exception e){
            System.out.println(e);
        }
        AlteraScene=new Scene(AlteraCadastroFXML);
        mainStage.setScene(AlteraScene);
        mainStage.show();
        
    }
    
    
}
