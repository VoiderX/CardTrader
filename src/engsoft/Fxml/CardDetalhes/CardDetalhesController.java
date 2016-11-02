/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package engsoft.Fxml.CardDetalhes;

import engsoft.CartaDAO;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
* FXML Controller class
*
* @author noda2
*/
public class CardDetalhesController implements Initializable {

   @FXML
   ImageView card;
   @FXML
   Text ID;
   @FXML
   Text name;
   @FXML
   Text desc;
   @FXML
   TextField Valor;
   @FXML
   TextField Quantidade;
   @FXML
   Text Mensagem;
   engsoft.Catalogo c;

   @FXML
   public void alterar(){
      float valor;
      int quant;

      try{
         valor = Float.valueOf(Valor.getText());
         quant = Integer.valueOf(Quantidade.getText());
         if(valor>0.0 && quant>0){
            engsoft.ControleUI.getInstance().getConexaoUser().alteraCatalogo(
            engsoft.ControleUI.getInstance().getIdCartaBuf(),
            valor,quant);
            Mensagem.setText("Item alterado com sucesso!");
            engsoft.ControleUI.getInstance().chamaListaColec();
            engsoft.ControleUI.getInstance().arrastarSecondStage();
         }else{
            Mensagem.setText("Valor inválido!");
         }
      }
      catch(Exception e){
         Mensagem.setText("Entre com valores válidos!");
      }

   }
   @FXML
   public void remover(){
      try{
         engsoft.ControleUI.getInstance().getConexaoUser().deletaCatalogo(
         engsoft.ControleUI.getInstance().getIdCartaBuf());

         Mensagem.setText("Item removido com sucesso!");
         engsoft.ControleUI.getInstance().chamaListaColec();
         engsoft.ControleUI.getInstance().arrastarSecondStage();
      }
      catch(Exception e){
         Mensagem.setText("Erro ao remover item!");
      }

   }

   /**
   * Initializes the controller class.
   */
   @Override
   public void initialize(URL url, ResourceBundle rb) {
      engsoft.ControleUI obj = engsoft.ControleUI.getInstance();
      card.setImage(CartaDAO.puxarCarta(obj.getIdCartaBuf()));
      ID.setText(Integer.toString(obj.getIdCartaBuf()));
      name.setText(engsoft.CartaDAO.retornaNomeCard(obj.getIdCartaBuf()));
      desc.setText(engsoft.CartaDAO.retornaDescCard(obj.getIdCartaBuf()));
      try{
         c= engsoft.ControleUI.getInstance().getConexaoUser().retornaInfoCarta(
         engsoft.ControleUI.getInstance().getIdCartaBuf());
         if(c!=null){
            Valor.setText(String.valueOf(c.getValor()));
            Quantidade.setText(String.valueOf(c.getQuantCatalogo()));
         }
      }
      catch(Exception e){
      }

   }
}
