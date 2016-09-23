/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft.Fxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

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
    Text Text1=new Text();
    @FXML
    Text Text2=new Text();
    @FXML
    Text Text3= new Text();
    @FXML
    Text Text4=new Text();
    @FXML
    Text Text5=new Text();
    @FXML
    Text Mensagem = new Text();
    int id1=0;
    int id2=0;
    int id3=0;
    int id4=0;
    int id5=0;
    @FXML
    public void retornaMenu(){
        engsoft.ControleUI.getInstance().mostraMenu();
    }
    @FXML
    public void procurarCarta(){
        try{
     Image5.setImage(engsoft.CartaDAO.puxarCarta(Integer.valueOf(IdCarta.getText())));
     Text5.setText(engsoft.CartaDAO.retornaNomeCard(Integer.valueOf(IdCarta.getText())));
        }
        catch(Exception e){
            Mensagem.setText("Digite um ID Válido");
        }
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
        id5=Integer.valueOf(IdCarta.getText());
        engsoft.ControleUI.getInstance().setIdCartaBuf(id5);
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
         id5=engsoft.ControleUI.getInstance().getIdCartaBuf();
         IdCarta.setText(Integer.toString(id5));
         procurarCarta();         
         Image1.setImage(engsoft.CartaDAO.puxarCarta(1));
         Text1.setText(engsoft.CartaDAO.retornaNomeCard(1));
         
         Image2.setImage(engsoft.CartaDAO.puxarCarta(2));
         Text2.setText(engsoft.CartaDAO.retornaNomeCard(2));
         
         Image3.setImage(engsoft.CartaDAO.puxarCarta(3));
         Text3.setText(engsoft.CartaDAO.retornaNomeCard(3));
         
         Image4.setImage(engsoft.CartaDAO.puxarCarta(2));
         Text4.setText(engsoft.CartaDAO.retornaNomeCard(2));
    }
}
