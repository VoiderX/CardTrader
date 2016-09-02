/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft.Fxml;



import engsoft.ControleUI;
import engsoft.UserConexaoDB;
import engsoft.Valida;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Gabriel
 */
public class LoginController implements Initializable {   
    @FXML
    TextField NickField=new TextField();
    @FXML
    PasswordField PassField= new PasswordField();
    @FXML
    Text Mensagem=new Text();
    /**
     * Initializes the controller class.
     */
    @FXML
    public void sair(){
        try{
        engsoft.ConexaoDB.getCon().close();//Encerra a conexão base
        }catch(Exception e){
            System.out.println("Erro ao sair!");
        }
        System.exit(0);
    }
        
   @FXML
    public void setLogin(){
        Connection con;
        //Colocar um if antes para verificar se o campo do nome de usuário e o campo da senha
        //não estão vazios, dessa forma evitando um acesso desnecessário ao banco   
        //Para exibir a mensagem para o  usuário basta chamar Mensagem.setText("texto");
        if(Valida.validaLogin(NickField, PassField, Mensagem)){
            try{
              engsoft.UserConexaoDB conUser = new engsoft.UserConexaoDB();//Cria a conexão do usuário
              conUser.setUsuario(NickField.getText().toLowerCase());//Passa o nome e senha como parametro
              conUser.setSenha(PassField.getText());
              engsoft.ControleUI.getInstance().setUser(NickField.getText());//Passa o nome do usuario
              //para a classe de controle
              con=conUser.createCon();
              engsoft.ControleUI.getInstance().setConUser(con);//Passa a conexão do usuário para a classe de
              //controle
              if(con==null){//Caso o login falhe
                  Mensagem.setText("Senha incorreta ou usuário não cadastrado!");
              }else{//caso de certo
              engsoft.ControleUI.getInstance().mostraMenu();//Exibe o menu
                Mensagem.setText("");//Limpa os campos
                NickField.setText("");
                PassField.setText("");
              }
            }
            catch(Exception e){
            System.out.println("Erro:"+ e); 
            }
        }
    }
    @FXML
    public void chamaCadastro(){//Chama a tela de cadastro
       engsoft.ControleUI.getInstance().mostraCadastro();
    }
    @FXML
    public void chamaRecSenha(){
        engsoft.ControleUI.getInstance().chamaRecPass();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Mensagem.wrappingWidthProperty();//Permite o campo de texto se expandir
    }    
    
}
