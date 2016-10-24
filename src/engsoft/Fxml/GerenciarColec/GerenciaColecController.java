/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft.Fxml.GerenciarColec;

import engsoft.Carta;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
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
    ImageView Image1;
    @FXML
    ImageView Image2;
    @FXML
    ImageView Image3;
    @FXML
    ImageView Image4;
    @FXML
    ImageView Image5;
    @FXML
    TextField IdCarta;
    @FXML
    Text Text1;
    @FXML
    Text Text2;
    @FXML
    Text Text3;
    @FXML
    Text Text4;
    @FXML
    Text Text5;
    @FXML
    Text Mensagem;
    
    int id1=0,id2=0,id3=0,id4=0,id5=0;

    ArrayList<ImageView> imagem;
    ArrayList<Text> text;
    ArrayList<Integer> id;
    
    @FXML
    public void retornaMenu(){
        engsoft.ControleUI.getInstance().saisecondStage();
        engsoft.ControleUI.getInstance().mostraMenu();
    }
    @FXML
    public void procurarCarta(){
        try{
            if(Integer.valueOf(IdCarta.getText())>0){
                try{
                    if(!engsoft.CartaDAO.retornaNomeCard(Integer.valueOf(IdCarta.getText())).equals("xNull")){
                        imagem.get(4).setImage(engsoft.CartaDAO.puxarCarta(Integer.valueOf(IdCarta.getText())));
                        text.get(4).setText(engsoft.CartaDAO.retornaNomeCard(Integer.valueOf(IdCarta.getText())));
                        engsoft.ControleUI.getInstance().setIdCartaBuf(id.get(4));
                        imagem.get(4).setCursor(Cursor.HAND);
                        Mensagem.setText("");
                    }else{
                        Mensagem.setText("ID indisponível!");
                        imagem.get(4).setCursor(Cursor.DEFAULT);
                        imagem.get(4).setImage(engsoft.CartaDAO.puxarCarta(0));
                        text.get(4).setText("");
                    }
                }catch(Exception e){
                    Mensagem.setText("Digite um ID válido!");
                    imagem.get(4).setCursor(Cursor.DEFAULT);
                    imagem.get(4).setImage(engsoft.CartaDAO.puxarCarta(0));
                    text.get(4).setText(engsoft.CartaDAO.retornaNomeCard(0));
                }
            }else{
                imagem.get(4).setImage(null);
                imagem.get(4).setCursor(Cursor.DEFAULT);
                text.get(4).setText("Digite um ID maior que zero!");
            }
        }catch(Exception e){
            imagem.get(4).setImage(engsoft.CartaDAO.puxarCarta(0));
            imagem.get(4).setCursor(Cursor.DEFAULT);
            text.get(4).setText("");
            Mensagem.setText("Digite um ID válido!");
        }
    }

    public void clickImage(Event e){
        if(e.getSource()==imagem.get(0)){
            engsoft.ControleUI.getInstance().setIdCartaBuf(id.get(0));
            engsoft.ControleUI.getInstance().chamaGerenciaCarta();
        }else if(e.getSource()==imagem.get(1)){
            engsoft.ControleUI.getInstance().setIdCartaBuf(id.get(1));
            engsoft.ControleUI.getInstance().chamaGerenciaCarta();
        }else if(e.getSource()==imagem.get(2)){
            engsoft.ControleUI.getInstance().setIdCartaBuf(id.get(2));
            engsoft.ControleUI.getInstance().chamaGerenciaCarta();
        }else if(e.getSource()==imagem.get(3)){
            engsoft.ControleUI.getInstance().setIdCartaBuf(id.get(3));
            engsoft.ControleUI.getInstance().chamaGerenciaCarta();
        }else if(e.getSource()==imagem.get(4)){
            try{
            if(!engsoft.CartaDAO.retornaNomeCard(Integer.valueOf(IdCarta.getText())).equals("xNull")){
                    try{
                        id.set(4,Integer.valueOf(IdCarta.getText()));
                        engsoft.ControleUI.getInstance().setIdCartaBuf(id.get(4));
                        engsoft.ControleUI.getInstance().chamaGerenciaCarta();
                        Mensagem.setText("");
                    }
                    catch(Exception ex){
                        Mensagem.setText("Digite um ID válido!");
                        Image5.setImage(engsoft.CartaDAO.puxarCarta(0));
                        Text5.setText("");
                    }
            }
            else{
            Text5.setText("");
            Mensagem.setText("");
             }
            }
            catch(Exception ex){
                Image5.setImage(engsoft.CartaDAO.puxarCarta(0));
                Text5.setText("");
            }
        }else{
            System.out.println("WTF");
        }
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
        id = new ArrayList<>();
        imagem = new ArrayList<>();
        text = new ArrayList<>();
        id.add(id1);
        id.add(id2);
        id.add(id3);
        id.add(id4);
        id.add(id5);
        imagem.add(Image1);
        imagem.add(Image2);
        imagem.add(Image3);
        imagem.add(Image4);
        imagem.add(Image5);
        text.add(Text1);
        text.add(Text2);
        text.add(Text3);
        text.add(Text4);
        text.add(Text5);
        
        id.set(4,engsoft.ControleUI.getInstance().getIdCartaBuf());
        IdCarta.setText(Integer.toString(id.get(4)));
        procurarCarta();

        ArrayList<Carta> lista = engsoft.CartaDAO.retornaCartas();
        int ctrl=0;
        for(int i=lista.size();i>(lista.size()-4);i--){
            id.set(ctrl,i);
            imagem.get(ctrl).setImage(engsoft.CartaDAO.puxarCarta(id.get(ctrl)));
            text.get(ctrl).setText(engsoft.CartaDAO.retornaNomeCard(id.get(ctrl)));
            ctrl++;
        }
    }
}
