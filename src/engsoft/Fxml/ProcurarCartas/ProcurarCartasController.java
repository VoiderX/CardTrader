/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft.Fxml.ProcurarCartas;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Gabriel
 */
public class ProcurarCartasController implements Initializable {
    @FXML
    TextField Usuario;
    @FXML
    TextField Carta;
    @FXML
    ImageView Image1;
    @FXML
    TextArea Text1;
    @FXML
    ImageView Image2;
    @FXML
    TextArea Text2;
    @FXML
    ImageView Image3;
    @FXML
    TextArea Text3;
    @FXML
    ImageView Image4;
    @FXML
    TextArea Text4;
    @FXML   
    ImageView Image5;
    @FXML
    TextArea Text5;
    @FXML
    ImageView Image6;
    @FXML
    TextArea Text6;
    @FXML
    ImageView Image7;
    @FXML
    TextArea Text7;
    @FXML
    ImageView Image8;
    @FXML
    TextArea Text8;
    @FXML
    TextField CartaID;
    
     @FXML
     public void retornaMenu(){
        engsoft.ControleUI.getInstance().mostraMenu();       
     }
     @FXML
     public void listaCartas(){
         engsoft.ControleUI.getInstance().ChamaLista();
     }
     @FXML
     public void listaUsuarios(){
         engsoft.TransacaoDAO.retornaUsuarios();
     }
     @FXML
     public void pesquisar(){
         
     }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CartaID.setText(String.valueOf(engsoft.ControleUI.getInstance().getIdCartaBuf()));
        ArrayList<engsoft.Catalogo> Catalogos = engsoft.TransacaoDAO.buscaCatalogo();
        
        Image1.setImage(engsoft.CartaDAO.puxarCarta(Catalogos.get(0).getIdCarta()));        
        Text1.setText(engsoft.CartaDAO.retornaNomeCard(Catalogos.get(0).getIdCarta())
                +"\n"+Catalogos.get(0).getUsuario()+"\n"+
                Catalogos.get(0).getValor());
        
        Image2.setImage(engsoft.CartaDAO.puxarCarta(Catalogos.get(1).getIdCarta()));        
        Text2.setText(engsoft.CartaDAO.retornaNomeCard(Catalogos.get(1).getIdCarta())
                +"\n"+Catalogos.get(1).getUsuario()+"\n"+
                Catalogos.get(1).getValor());
                
        Image3.setImage(engsoft.CartaDAO.puxarCarta(Catalogos.get(2).getIdCarta()));        
        Text3.setText(engsoft.CartaDAO.retornaNomeCard(Catalogos.get(2).getIdCarta())
                +"\n"+Catalogos.get(2).getUsuario()+"\n"+
                Catalogos.get(2).getValor());
                
        Image4.setImage(engsoft.CartaDAO.puxarCarta(Catalogos.get(3).getIdCarta()));        
        Text4.setText(engsoft.CartaDAO.retornaNomeCard(Catalogos.get(3).getIdCarta())
                +"\n"+Catalogos.get(3).getUsuario()+"\n"+
                Catalogos.get(3).getValor());        
                
        Image5.setImage(engsoft.CartaDAO.puxarCarta(Catalogos.get(4).getIdCarta()));        
        Text5.setText(engsoft.CartaDAO.retornaNomeCard(Catalogos.get(4).getIdCarta())
                +"\n"+Catalogos.get(4).getUsuario()+"\n"+
                Catalogos.get(4).getValor());
                
        Image6.setImage(engsoft.CartaDAO.puxarCarta(Catalogos.get(5).getIdCarta()));        
        Text6.setText(engsoft.CartaDAO.retornaNomeCard(Catalogos.get(5).getIdCarta())
                +"\n"+Catalogos.get(5).getUsuario()+"\n"+
                Catalogos.get(5).getValor());
                
        Image7.setImage(engsoft.CartaDAO.puxarCarta(Catalogos.get(6).getIdCarta()));        
        Text7.setText(engsoft.CartaDAO.retornaNomeCard(Catalogos.get(6).getIdCarta())
                +"\n"+Catalogos.get(6).getUsuario()+"\n"+
                Catalogos.get(6).getValor());
                
        Image8.setImage(engsoft.CartaDAO.puxarCarta(Catalogos.get(7).getIdCarta()));        
        Text8.setText(engsoft.CartaDAO.retornaNomeCard(Catalogos.get(7).getIdCarta())
                +"\n"+Catalogos.get(7).getUsuario()+"\n"+
                Catalogos.get(7).getValor());
    }   
    
}
