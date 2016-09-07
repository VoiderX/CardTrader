/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft.Fxml;

import engsoft.Valida;
import java.net.URL;
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
public class RecuperaSenhaController implements Initializable {
    
    @FXML
    Text Mensagem= new Text();
    @FXML
    TextField NickField=new TextField();
    @FXML
    PasswordField PassField=new PasswordField();
    engsoft.ConexaoDB conexao;
    
    @FXML
    public void alteraSenha(){
        StringBuilder mens = new StringBuilder("");
        if(Valida.validaSenha(NickField.getText(), PassField.getText(), mens)){
           Mensagem.setText(conexao.altSenha(NickField.getText(), PassField.getText()));
        }else{
            Mensagem.setText(mens.toString());
        }
    }
    
    @FXML
    public void retornaLogin(){
        NickField.setText("");
        PassField.setText("");
        Mensagem.setText("");
        engsoft.ControleUI.getInstance().mostraLogin();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conexao=new engsoft.ConexaoDB();
    }    
    
}
