/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft.Fxml;

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
public class ListaCartasController implements Initializable {
    @FXML
    TableView Tabela=new TableView();
    @FXML
    TableColumn ColunaID=new TableColumn();
    @FXML
    TableColumn ColunaNome=new TableColumn();
    @FXML
    TableColumn ColunaFabr=new TableColumn();
    @FXML
    TableColumn ColunaDesc=new TableColumn();
    @FXML
    Text Mensagem=new Text();
    public void cancelar(){
        engsoft.ControleUI.getInstance().saisecondStage();
    }
    public void selecionaCarta(){
        try{
            engsoft.Carta c=(engsoft.Carta)Tabela.getSelectionModel().getSelectedItem(); 
            engsoft.ControleUI.getInstance().setIdCartaBuf(Integer.valueOf(c.getID()));
            engsoft.ControleUI.getInstance().chamaGerenciarColec();
            engsoft.ControleUI.getInstance().saisecondStage();
        }
        catch(Exception e){
           Mensagem.setText("Selecione uma carta!");
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList ListaCard=engsoft.CartaDAO.retornaInfoCard();
        ColunaNome.setCellValueFactory(new PropertyValueFactory<engsoft.Carta,String>("Nome"));
        ColunaFabr.setCellValueFactory(new PropertyValueFactory<engsoft.Carta,String>("Fabricante"));
        ColunaDesc.setCellValueFactory(new PropertyValueFactory<engsoft.Carta,String>("Desc"));
        ColunaID.setCellValueFactory(new PropertyValueFactory<engsoft.Carta,String>("ID"));
        Tabela.setItems(ListaCard);        
        Tabela.getSortOrder().add(ColunaID);
        
    }    
    
}
