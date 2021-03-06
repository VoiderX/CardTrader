/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package engsoft.Fxml.HistoricoCompras;

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
public class HistoricoComprasController implements Initializable {
   ObservableList<engsoft.Transacao> Compras;
   @FXML
   TableView<engsoft.Transacao> Tabela;
   @FXML
   TableColumn<engsoft.Transacao,String> Vendedor;
   @FXML
   TableColumn<engsoft.Transacao,String> Status;
   @FXML
   TableColumn<engsoft.Transacao,Integer> Carta;
   @FXML
   TableColumn<engsoft.Transacao,Integer> Quantidade;
   @FXML
   TableColumn<engsoft.Transacao,Float>  Valor;
   @FXML
   Text mensagem;
   @FXML
   public void retornaMenu(){
      engsoft.ControleUI.getInstance().mostraMenu();
   }
   @FXML
   public void selecionar(){
      engsoft.Transacao aux = Tabela.getSelectionModel().getSelectedItem();
      if(aux != null){
         engsoft.ControleUI.getInstance().setTraBuf(aux);
         engsoft.ControleUI.getInstance().chamaComprarCarta();
         mensagem.setText("");
      }else{
         mensagem.setText("Nenhuma linha selecionada!");
      }
   }
   /**
   * Initializes the controller class.
   */
   @Override
   public void initialize(URL url, ResourceBundle rb) {
      Compras=engsoft.TransacaoDAO.retornaCompras();
      Vendedor.setCellValueFactory(new PropertyValueFactory<>("Vendedor"));
      Status.setCellValueFactory(new PropertyValueFactory<>("Status"));
      Carta.setCellValueFactory(new PropertyValueFactory<>("IdCarta"));
      Quantidade.setCellValueFactory(new PropertyValueFactory<>("Quantidade"));
      Valor.setCellValueFactory(new PropertyValueFactory<>("Valor"));
      Tabela.setItems(Compras);
      mensagem.setText("");
   }

}
