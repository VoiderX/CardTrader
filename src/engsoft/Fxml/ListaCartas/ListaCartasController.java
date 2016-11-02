/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package engsoft.Fxml.ListaCartas;

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
   TableView<engsoft.Carta> Tabela;
   @FXML
   TableColumn<engsoft.Carta,Integer> ColunaID;
   @FXML
   TableColumn<engsoft.Carta,String> ColunaNome;
   @FXML
   TableColumn<engsoft.Carta,String> ColunaFabr;
   @FXML
   TableColumn<engsoft.Carta,String> ColunaDesc;
   @FXML
   Text Mensagem;
   public void cancelar(){
      engsoft.ControleUI.getInstance().saisecondStage();
   }
   public void selecionaCarta(){
      try{
         engsoft.Carta c=(engsoft.Carta)Tabela.getSelectionModel().getSelectedItem();
         engsoft.ControleUI.getInstance().setIdCartaBuf(c.getID());
         if(engsoft.ControleUI.getInstance().verificaMainStage().equals("Gerencia")){
            engsoft.ControleUI.getInstance().chamaGerenciarColec();
         }
         else if(engsoft.ControleUI.getInstance().verificaMainStage().equals("Procura")){
            engsoft.ControleUI.getInstance().chamaProcuraCarta();
         }
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
      ObservableList<engsoft.Carta> ListaCard=engsoft.CartaDAO.retornaInfoCard();
      ColunaNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
      ColunaFabr.setCellValueFactory(new PropertyValueFactory<>("Fabricante"));
      ColunaDesc.setCellValueFactory(new PropertyValueFactory<>("Desc"));
      ColunaID.setCellValueFactory(new PropertyValueFactory<>("ID"));
      Tabela.setItems(ListaCard);
      Tabela.getSortOrder().add(ColunaID);

   }

}
