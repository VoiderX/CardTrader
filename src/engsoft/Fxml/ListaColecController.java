/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft.Fxml;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Gabriel
 */
public class ListaColecController implements Initializable { 
    @FXML
    TextArea Textoteste= new TextArea();
    
    @FXML
    public void voltaMenu(){
        engsoft.ControleUI.getInstance().mostraMenu();
    }  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ResultSet rs= engsoft.ControleUI.getInstance().getConexaoUser().retornaCatalogo();
         try{
            while(rs.next()){
            Textoteste.appendText(
            rs.getInt("CARTA_CATALOGO")+" "+
            rs.getInt("QUANT_CATALOGO")+" "+
            rs.getFloat("VALOR_CATALOGO")+"\n"
            );
            }
        }
       catch(Exception e){
           
       }
    }     
    
}
