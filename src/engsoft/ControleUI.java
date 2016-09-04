/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Gabriel
 */
public final class ControleUI{

   
    private ControleUI(){};
   
    
    UserConexaoDB conexao;
    public void setConexaoUser(engsoft.UserConexaoDB conexao){
        this.conexao=conexao;
    }
    
    public engsoft.UserConexaoDB getConexaoUser(){
        return conexao;
    }
    
    private static ControleUI INSTANCE = null;
    
    public static ControleUI getInstance(){
        return((INSTANCE == null)?INSTANCE = new ControleUI():INSTANCE);
    }
    
    public void start(Stage primaryStage) throws Exception {//Chama a parimeira tela
        mainStage = primaryStage;
        initUI();
    }    
    
    private static Parent LoginFXML; //Classes parent para manipulação do Fxml
    private static Parent CadastroFXML;
    private static Parent MenuFXML;
    private static Parent AlteraCadastroFXML;
    private static Parent RecSenhaFXML;
    
    private static Scene LoginScene;
    private static Scene CadastroScene;
    private static Scene MenuScene;
    private static Scene AlteraScene;
    private static Scene RecSenhaScene;
    
    private static Stage mainStage;
    
    
    
    private void initUI(){ //Metódo inicializador 
        mainStage.centerOnScreen();
        mainStage.setTitle("CardTrader 2016");
        
        try {
            LoginFXML = FXMLLoader.load(getClass().getResource("Fxml/Login.fxml")); //Carrega o arquivo FXML na classe pai
            CadastroFXML=FXMLLoader.load(getClass().getResource("Fxml/Cadastro.fxml"));
            MenuFXML=FXMLLoader.load(getClass().getResource("Fxml/Menu.fxml"));
            RecSenhaFXML=FXMLLoader.load(getClass().getResource("Fxml/RecuperaSenha.fxml"));
            
        } catch (IOException ex) {
            //fazer algo para mostrar erro
            System.out.println("Erro" + ex);
        }
        LoginScene = new Scene(LoginFXML); //Transforma a classe parent em um objeto do tipo Scene
        CadastroScene=new Scene(CadastroFXML);
        MenuScene=new Scene(MenuFXML);
        RecSenhaScene=new Scene(RecSenhaFXML);
        mostraLogin();
    }
   
    public void mostraLogin(){ //Método para chamar o login
        mainStage.setScene(LoginScene);
        mainStage.show();    
    }
    
    public void mostraCadastro(){//Método para chamar a tela de cadastro
        mainStage.setScene(CadastroScene);
        mainStage.show();
    }
    public void mostraMenu(){ //Método para chamar o menu
        mainStage.setScene(MenuScene);
        mainStage.show();
    }
    public void mostraAlterCadastro(){ //Método para chamar a tela de alteração de cadastro
        //Objetos são inicializados nele devido a necessidade de puxar informações sobre a conexão do usúario
        try{
        AlteraCadastroFXML=FXMLLoader.load(getClass().getResource("Fxml/AlteraCadastro.fxml"));
        }catch(Exception e){
            System.out.println(e);
        }
        AlteraScene=new Scene(AlteraCadastroFXML);
        mainStage.setScene(AlteraScene);
        mainStage.show();
        
    }
    
    public void chamaRecPass(){
        mainStage.setScene(RecSenhaScene);
        mainStage.show();
    }    
    
}
