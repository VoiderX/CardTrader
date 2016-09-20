/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft.Fxml;

import engsoft.CartaDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Gabriel
 */
public class GerenciaColecController implements Initializable {   
    @FXML
    ImageView Image1=new ImageView();
    @FXML
    ImageView Image2=new ImageView();
    @FXML
    ImageView Image3=new ImageView();
    @FXML
    ImageView Image4=new ImageView();
    @FXML
    ImageView Image5=new ImageView();
    @FXML
    TextField IdCarta=new TextField();
    
    @FXML
    public void retornaMenu(){
        engsoft.ControleUI.getInstance().mostraMenu();
    }
    @FXML
    public void procurarCarta(){
     Image5.setImage(engsoft.CartaDAO.puxarCarta(Integer.valueOf(IdCarta.getText())));
    }
    
    @FXML
    public void clickImage1(){
        engsoft.ControleUI.getInstance().chamaGerenciaCarta();
    }
     @FXML
    public void clickImage2(){
         engsoft.ControleUI.getInstance().chamaGerenciaCarta();
    }
     @FXML
    public void clickImage3(){
         engsoft.ControleUI.getInstance().chamaGerenciaCarta();
    }
     @FXML
    public void clickImage4(){
         engsoft.ControleUI.getInstance().chamaGerenciaCarta();
    }
    @FXML
    public void clickImage5(){
         engsoft.ControleUI.getInstance().chamaGerenciaCarta();
    }
    @FXML
    public void chamaLista(){
        engsoft.ControleUI.getInstance().ChamaLista();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         Image1.setImage(CartaDAO.puxarCarta(1));
         Image2.setImage(CartaDAO.puxarCarta(2));
         Image3.setImage(CartaDAO.puxarCarta(1));
         Image4.setImage(CartaDAO.puxarCarta(2));
    }
}
