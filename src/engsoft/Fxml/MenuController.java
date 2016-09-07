/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft.Fxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Gabriel
 */
public class MenuController implements Initializable {    
   
    @FXML 
    public void sair(){//Sai da conta do usuário
        engsoft.ControleUI.getInstance().mostraLogin();
        try{
        engsoft.ControleUI.getInstance().getConexaoUser().fecharConexao();
        }catch(Exception e){
            System.out.println("Erro ao fechar a conexão!");
        }
    }
    @FXML
    public void alteraCad(){//Chama o menu de alteração de cadastro
         engsoft.ControleUI.getInstance().mostraAlterCadastro();         
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
