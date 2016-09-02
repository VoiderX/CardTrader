/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft.Fxml;

import engsoft.Valida;
import java.net.URL;
import java.sql.Statement;
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
    
    @FXML
    public void alteraSenha(){
        if(Valida.validaSenha(NickField, PassField, Mensagem)){
            try{
                Statement s=engsoft.ConexaoDB.getCon().createStatement();
                //Validar a senha digitada pelo usuário
                s.executeUpdate("ALTER USER "+NickField.getText()+ " WITH PASSWORD '"+PassField.getText()+"'");
                Mensagem.setText("Alteração executada com sucesso!");
            }catch(Exception e){
                System.out.println(e);
                Mensagem.setText("Usuário não encontrado!");
            }
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
    }    
    
}
