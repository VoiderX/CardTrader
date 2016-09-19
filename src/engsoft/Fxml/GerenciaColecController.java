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
    public void retornaMenu(){
        engsoft.ControleUI.getInstance().mostraMenu();
    }
    @FXML
    public void procurarCarta(){
        File file1 = new File("D:/Downloads/aaa.jpg");
        Image im2= new Image(file1.toURI().toString());
        Image5.setImage(im2);
       
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         File file = new File("D:/Downloads/aaa.jpg");
         Image im1= new Image(file.toURI().toString());
         Image1.setImage(im1);
         Image2.setImage(im1);
         Image3.setImage(im1);
         Image4.setImage(im1);
    }
}
