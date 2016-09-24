/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft.Fxml.ListaColec;

import engsoft.Carta;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Gabriel
 */
public class ListaColecController implements Initializable { 
    @FXML
    Text quant1;
    @FXML
    Text quant2;
    @FXML
    Text quant3;
    @FXML
    Text valor1;
    @FXML
    Text valor2;
    @FXML
    Text valor3;
    @FXML
    Text desc1;
    @FXML
    Text desc2;
    @FXML
    Text desc3;
    @FXML
    ImageView img1;
    @FXML
    ImageView img2;
    @FXML
    ImageView img3;
    @FXML
    Button next;
    @FXML
    Button previous;
    
    private ArrayList<Carta> list;
    private ArrayList<Text> valor;
    private ArrayList<Text> quant;
    private ArrayList<Text> desc;
    private ArrayList<ImageView> img;
    private int ctrl;
            
    @FXML
    public void voltaMenu(){
        engsoft.ControleUI.getInstance().mostraMenu();
    }  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        init();
        ctrl=0;
        for(int i=0;i<3;i++){
            if(ctrl<list.size()){
                img.get(ctrl%3).setImage(list.get(ctrl).getImg());
                quant.get(ctrl%3).setText(""+list.get(ctrl).getQuant());
                valor.get(ctrl%3).setText(""+list.get(ctrl).getValor());
                desc.get(ctrl%3).setText(list.get(ctrl).getDesc());
                
            }else{
                img.get(i).setImage(null);
                quant.get(i).setText("");
                valor.get(i).setText("");
                desc.get(i).setText("");
            }
            ctrl++;
        }
    }     
    
    public void init(){
        list = getList();
        valor = new ArrayList<>();
        quant = new ArrayList<>();
        desc = new ArrayList<>();
        img = new ArrayList<>();
        valor.add(valor1);
        valor.add(valor2);
        valor.add(valor3);
        quant.add(quant1);
        quant.add(quant2);
        quant.add(quant3);
        desc.add(desc1);
        desc.add(desc2);
        desc.add(desc3);
        img.add(img1);
        img.add(img2);
        img.add(img3);
    }
    
    public ArrayList getList(){
        ResultSet rs= engsoft.ControleUI.getInstance().getConexaoUser().retornaCatalogo();
        ArrayList<Carta> l = new ArrayList<>();
        try {
            while(rs.next()){
                Carta c = new Carta(rs.getInt("CARTA_CATALOGO"),rs.getInt("QUANT_CATALOGO"),rs.getFloat("VALOR_CATALOGO"));
                l.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListaColecController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }
    
    public void next(){
        if(ctrl<list.size()){
            for(int i=0;i<3;i++){
                if(ctrl<list.size()){
                    img.get(ctrl%3).setImage(list.get(ctrl).getImg());
                    quant.get(ctrl%3).setText(""+list.get(ctrl).getQuant());
                    valor.get(ctrl%3).setText(""+list.get(ctrl).getValor());
                    desc.get(ctrl%3).setText(list.get(ctrl).getDesc());
                    
                }else{
                    img.get(i).setImage(null);
                    quant.get(i).setText("");
                    valor.get(i).setText("");
                    desc.get(i).setText("");
                }
                ctrl++;
            }   
        }
    }
    
    public void previous(){
        if(ctrl>3){
            ctrl-=6;
            for(int i=0;i<3;i++){
                if(ctrl<list.size()){
                    img.get(ctrl%3).setImage(list.get(ctrl).getImg());
                    quant.get(ctrl%3).setText(""+list.get(ctrl).getQuant());
                    valor.get(ctrl%3).setText(""+list.get(ctrl).getValor());
                    desc.get(ctrl%3).setText(list.get(ctrl).getDesc());
                    
                }else{
                    img.get(i).setImage(null);
                    quant.get(i).setText("");
                    valor.get(i).setText("");
                    desc.get(i).setText("");
                }
                ctrl++;
            }
        }
    }
}
