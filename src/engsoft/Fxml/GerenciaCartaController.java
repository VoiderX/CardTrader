/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft.Fxml;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Gabriel
 */
public class GerenciaCartaController implements Initializable {

    @FXML
    ImageView Image1=new ImageView();
    @FXML
    AnchorPane Painel=new  AnchorPane();
    @FXML
    public void sairStage(){
        engsoft.ControleUI.getInstance().saisecondStage();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         File file = new File("D:/Downloads/aguia-real.jpg");
         Image im1= new Image(file.toURI().toString());
         Image1.setImage(im1);
    }    
    
}
