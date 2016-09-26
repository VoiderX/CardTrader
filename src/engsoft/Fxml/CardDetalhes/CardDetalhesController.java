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
    ResultSet rs;
    
    @FXML
    public void alterar(){
        try{
        engsoft.ControleUI.getInstance().getConexaoUser().alteraCatalogo(
        engsoft.ControleUI.getInstance().getIdCartaBuf(),
        Float.valueOf(Valor.getText()),Integer.valueOf(Quantidade.getText()));
        Mensagem.setText("Item alterado com sucesso!");
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
        // TODO
        engsoft.ControleUI obj = engsoft.ControleUI.getInstance();
        card.setImage(CartaDAO.puxarCarta(obj.getIdCartaBuf()));
        ID.setText(Integer.toString(obj.getIdCartaBuf()));
        name.setText(engsoft.CartaDAO.retornaNomeCard(obj.getIdCartaBuf()));
        desc.setText(engsoft.CartaDAO.retornaDescCard(obj.getIdCartaBuf()));
        try{
            rs= engsoft.ControleUI.getInstance().getConexaoUser().retornaInfoCarta(
            engsoft.ControleUI.getInstance().getIdCartaBuf());
            while(rs.next()){
                Valor.setText(String.valueOf(rs.getFloat("VALOR_CATALOGO")));
                Quantidade.setText(String.valueOf(rs.getInt("QUANT_CATALOGO")));
            }            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    
    }
}