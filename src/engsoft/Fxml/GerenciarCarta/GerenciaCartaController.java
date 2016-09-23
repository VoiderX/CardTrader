/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft.Fxml.GerenciarCarta;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Gabriel
 */
public class GerenciaCartaController implements Initializable {

    @FXML
    ImageView Image1=new ImageView();
    @FXML
    Text Text1=new Text();
    @FXML
    TextArea Desc= new TextArea();
    @FXML
    TextField Valor = new TextField();
    @FXML
    TextField Quantidade = new TextField();
    @FXML
    Text Mensagem = new Text();
    @FXML
    public void sairStage(){
        engsoft.ControleUI.getInstance().saisecondStage();
    }
    @FXML
    public void inserirCarta(){
        try{
        Mensagem.setText(engsoft.ControleUI.getInstance().getConexaoUser().insereCatalogo(engsoft.ControleUI.getInstance().getIdCartaBuf(), 
                Integer.valueOf(Quantidade.getText()), Float.valueOf(Valor.getText())));
        }
        catch(Exception e){
            Mensagem.setText("Digite um valor válido!");
        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Image im1=engsoft.CartaDAO.puxarCarta(engsoft.ControleUI.getInstance().getIdCartaBuf());
         Image1.setImage(im1);
         Text1.setText(engsoft.CartaDAO.retornaNomeCard(engsoft.ControleUI.getInstance().getIdCartaBuf()));
         Desc.appendText(engsoft.CartaDAO.retornaDescCard(engsoft.ControleUI.getInstance().getIdCartaBuf()));
         
         
    }    
    
}
