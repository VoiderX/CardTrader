/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft.Fxml.ListaUsuarios;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Gabriel
 */
public class ListaUsuariosController implements Initializable {
    @FXML
    TableView<engsoft.Usuario> Tabela;
    @FXML
    TableColumn<engsoft.Usuario,String> ColunaUsuario;
    @FXML
    Text Mensagem;
    
    @FXML
    public void cancelar(){
        engsoft.ControleUI.getInstance().saisecondStage();
    }
    @FXML
    public void selecionar(){
        try{
        engsoft.Usuario c=(engsoft.Usuario)Tabela.getSelectionModel().getSelectedItem();
        engsoft.ControleUI.getInstance().setUserBuf(c.getUsuario());
        engsoft.ControleUI.getInstance().chamaProcuraCarta();
        engsoft.ControleUI.getInstance().saisecondStage();
        }
        catch(Exception e){
            Mensagem.setText("Selecione um Usuário!!!");
        }
        
    }    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList <engsoft.Usuario> Usuarios=engsoft.TransacaoDAO.retornaUsuarios();
        ColunaUsuario.setCellValueFactory(new PropertyValueFactory<>("Usuario"));
        Tabela.setItems(Usuarios);
        Tabela.getSortOrder().add(ColunaUsuario);
    }      
    
}
