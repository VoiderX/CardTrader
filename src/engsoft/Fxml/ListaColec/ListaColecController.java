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
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
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
    ImageView img1;
    @FXML
    ImageView img2;
    @FXML
    ImageView img3;
    @FXML
    Button next;
    @FXML
    Button previous;
    @FXML
    Pane pane1;
    @FXML
    Pane pane2;
    @FXML
    Pane pane3;
    @FXML
    Text warning;
    
    private ArrayList<Carta> list;
    private ArrayList<Text> valor;
    private ArrayList<Text> quant;
    private ArrayList<ImageView> img;
    private ArrayList<Pane> pane;
    private ArrayList<Integer> id;
    private int ctrl,id0,id1,id2;
            
    @FXML
    public void voltaMenu(){
        engsoft.ControleUI.getInstance().saisecondStage();
        engsoft.ControleUI.getInstance().mostraMenu();
    }  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        init();
        ctrl=0;
        if(list.size()!=0){
            warning.setVisible(false);
        }
        for(int i=0;i<3;i++){
            if(ctrl<list.size()){
                id.set(i, Integer.valueOf(list.get(ctrl).getID()));
                pane.get(i).setVisible(true);
                img.get(ctrl%3).setImage(list.get(ctrl).getImg());
                quant.get(ctrl%3).setText(""+list.get(ctrl).getQuant());
                valor.get(ctrl%3).setText(""+list.get(ctrl).getValor());
                
            }else{
                pane.get(i).setVisible(false);
                img.get(i).setImage(null);
                quant.get(i).setText("");
                valor.get(i).setText("");
            }
            ctrl++;
        }
        previous.setDisable(true);
        if(list.size()<4){
            next.setDisable(true);
        }
    }     
    
    public void init(){
        list = getList();
        valor = new ArrayList<>();
        quant = new ArrayList<>();
        img = new ArrayList<>();
        pane = new ArrayList<>();
        id = new ArrayList<>();
        valor.add(valor1);
        valor.add(valor2);
        valor.add(valor3);
        quant.add(quant1);
        quant.add(quant2);
        quant.add(quant3);
        img.add(img1);
        img.add(img2);
        img.add(img3);
        pane.add(pane1);
        pane.add(pane2);
        pane.add(pane3);
        id.add(id0);
        id.add(id1);
        id.add(id2);
    }
    
    public ArrayList<Carta> getList(){
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
                    id.set(i, Integer.valueOf(list.get(ctrl).getID()));
                    pane.get(i).setVisible(true);
                    img.get(ctrl%3).setImage(list.get(ctrl).getImg());
                    quant.get(ctrl%3).setText(""+list.get(ctrl).getQuant());
                    valor.get(ctrl%3).setText(""+list.get(ctrl).getValor());
                }else{
                    pane.get(i).setVisible(false);
                    img.get(i).setImage(null);
                    quant.get(i).setText("");
                    valor.get(i).setText("");
                }
                ctrl++;
            }   
        }
        if(ctrl>=list.size()){
            next.setDisable(true);
        }
        if(ctrl>3){
            previous.setDisable(false);
        }
    }
    
    public void previous(){
        if(ctrl>3){
            ctrl-=6;
            for(int i=0;i<3;i++){
                if(ctrl<list.size()){
                    id.set(i, Integer.valueOf(list.get(ctrl).getID()));
                    pane.get(i).setVisible(true);
                    img.get(ctrl%3).setImage(list.get(ctrl).getImg());
                    quant.get(ctrl%3).setText(""+list.get(ctrl).getQuant());
                    valor.get(ctrl%3).setText(""+list.get(ctrl).getValor());
                }else{
                    pane.get(i).setVisible(false);
                    img.get(i).setImage(null);
                    quant.get(i).setText("");
                    valor.get(i).setText("");
                }
                ctrl++;
            }
        }
        if(ctrl<list.size()){
            next.setDisable(false);
        }
        if(ctrl<=3){
            previous.setDisable(true);
        }
    }
    
    public void clickImage(Event e){
        if(e.getSource() == img1){
            engsoft.ControleUI.getInstance().setIdCartaBuf(id.get(0));
            engsoft.ControleUI.getInstance().ChamaCardDetalhes();
        }else if(e.getSource() == img2){
            engsoft.ControleUI.getInstance().setIdCartaBuf(id.get(1));
            engsoft.ControleUI.getInstance().ChamaCardDetalhes();
        }else{
            engsoft.ControleUI.getInstance().setIdCartaBuf(id.get(2));
            engsoft.ControleUI.getInstance().ChamaCardDetalhes();
        }
    }
}
