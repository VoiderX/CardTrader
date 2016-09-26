/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft.Fxml.GerenciarCarta;


import java.net.URL;
import java.sql.ResultSet;
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
    ResultSet rs;
    @FXML
    public void sairStage(){
        engsoft.ControleUI.getInstance().saisecondStage();
    }
    @FXML
    public void inserirCarta(){
        try{
         rs=engsoft.ControleUI.getInstance().getConexaoUser().retornaInfoCarta(
         engsoft.ControleUI.getInstance().getIdCartaBuf());
        if(!rs.next()){
            Mensagem.setText(engsoft.ControleUI.getInstance().getConexaoUser().insereCatalogo(engsoft.ControleUI.getInstance().getIdCartaBuf(), 
                Integer.valueOf(Quantidade.getText()), Float.valueOf(Valor.getText())));
        }
        else{
            engsoft.ControleUI.getInstance().getConexaoUser().alteraCatalogo(
            engsoft.ControleUI.getInstance().getIdCartaBuf(),
            Float.valueOf(Valor.getText()),Integer.valueOf(Quantidade.getText()));
            Mensagem.setText("Item alterado com sucesso!");
        }
        
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
         rs=engsoft.ControleUI.getInstance().getConexaoUser().retornaInfoCarta(
         engsoft.ControleUI.getInstance().getIdCartaBuf());
         try{
            while(rs.next()){
                Valor.setText(String.valueOf(rs.getFloat("VALOR_CATALOGO")));
                Quantidade.setText(String.valueOf(rs.getInt("QUANT_CATALOGO")));
            }
         }
         catch(Exception e){
             e.printStackTrace();
         }
         Image im1=engsoft.CartaDAO.puxarCarta(engsoft.ControleUI.getInstance().getIdCartaBuf());
         Image1.setImage(im1);
         Text1.setText(engsoft.CartaDAO.retornaNomeCard(engsoft.ControleUI.getInstance().getIdCartaBuf()));
         Desc.appendText(engsoft.CartaDAO.retornaDescCard(engsoft.ControleUI.getInstance().getIdCartaBuf()));
    }    
    
}
