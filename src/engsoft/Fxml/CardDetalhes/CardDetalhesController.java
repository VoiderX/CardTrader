/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft.Fxml.CardDetalhes;

import engsoft.CartaDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    }    
    
}
