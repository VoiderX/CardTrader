/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft.Fxml.ProcurarCartas;

import engsoft.CartaDAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Gabriel
 */
public class ProcurarCartasController implements Initializable {
    @FXML
    Text mensagem;
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
    TextField Usuario;
    
    @FXML
    Pane pane0;
    @FXML
    Pane pane1;
    @FXML
    Pane pane2;
    @FXML
    Pane pane3;
    @FXML
    Pane pane4;
    @FXML
    Pane pane5;
    @FXML
    Pane pane6;
    @FXML
    Pane pane7;
    @FXML
    Button previous;
    @FXML
    Button next;
    
    ArrayList<engsoft.Catalogo> Catalogos;
    ArrayList<Integer> Id= new ArrayList<>();
    ArrayList<ImageView> image = new ArrayList<>();
    ArrayList<TextArea> text = new ArrayList<>();
    ArrayList<Pane> pane = new ArrayList<>();
    int ctrl;
    @FXML
    public void clickImage1(){
        engsoft.ControleUI.getInstance().setCatalogoBuf(Catalogos.get(Id.get(0)));
        engsoft.ControleUI.getInstance().chamaComprarCarta();
    }
    @FXML
    public void clickImage2(){
        engsoft.ControleUI.getInstance().setCatalogoBuf(Catalogos.get(Id.get(1)));
        engsoft.ControleUI.getInstance().chamaComprarCarta();
    }
    @FXML
    public void clickImage3(){
        engsoft.ControleUI.getInstance().setCatalogoBuf(Catalogos.get(Id.get(2)));
        engsoft.ControleUI.getInstance().chamaComprarCarta();
    }
    @FXML
    public void clickImage4(){
        engsoft.ControleUI.getInstance().setCatalogoBuf(Catalogos.get(Id.get(3)));
        engsoft.ControleUI.getInstance().chamaComprarCarta();
    }
    @FXML
    public void clickImage5(){
        engsoft.ControleUI.getInstance().setCatalogoBuf(Catalogos.get(Id.get(4)));
        engsoft.ControleUI.getInstance().chamaComprarCarta();
    }
    @FXML
    public void clickImage6(){
        engsoft.ControleUI.getInstance().setCatalogoBuf(Catalogos.get(Id.get(5)));
        engsoft.ControleUI.getInstance().chamaComprarCarta();
    }
    @FXML
    public void clickImage7(){
        engsoft.ControleUI.getInstance().setCatalogoBuf(Catalogos.get(Id.get(6)));
        engsoft.ControleUI.getInstance().chamaComprarCarta();
    }
    @FXML
    public void clickImage8(){
        engsoft.ControleUI.getInstance().setCatalogoBuf(Catalogos.get(Id.get(7)));
        engsoft.ControleUI.getInstance().chamaComprarCarta();
    }
    
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
         engsoft.ControleUI.getInstance().chamaListarUsuario();
     }
     
     @FXML
     public void pesquisar(){
        boolean carta,user;
        user = Usuario.getText().length() != 0;
        carta = CartaID.getText().length() !=0;
        if(user && carta){
            pesquisaUserCard(); 
        }else if(user && !carta){
            pesquisaUser();
        }else if(!user && carta){
            pesquisaCard();
        }else{
            Catalogos = engsoft.TransacaoDAO.buscaCatalogo();
            mensagem.setText("");
        }
        ctrl=0;
        showCards();
     }
     
    public void pesquisaUserCard(){
        try{
            int cartaId = Integer.valueOf(CartaID.getText());
            if(engsoft.TransacaoDAO.verificaUsuarios(Usuario.getText()) && CartaDAO.verificaCarta(cartaId)){
                if(Integer.valueOf(CartaID.getText())>0){
                    Catalogos = engsoft.TransacaoDAO.buscaCatalogo(Usuario.getText(),cartaId);
                    if(Catalogos.isEmpty()){
                        mensagem.setText("Nenhuma carta encontrada deste usuário.");
                    }
                }else{
                    mensagem.setText("Digite um ID maior que 0!");
                }
            }else{
                mensagem.setText("Usuário ou carta não existente.");
            }
        }catch(Exception e){
            mensagem.setText("Digite um número válido!");
        }
    }
    
    public void pesquisaUser(){
        if(engsoft.TransacaoDAO.verificaUsuarios(Usuario.getText())){
            Catalogos = engsoft.TransacaoDAO.buscaCatalogo(Usuario.getText());
            if(Catalogos.isEmpty()){
                mensagem.setText("Nenhuma carta deste usuário.");
            }
        }else{
            mensagem.setText("Usuário não existente.");
        }
    }
    
    public void pesquisaCard(){
        try{
            int cartaId = Integer.valueOf(CartaID.getText());
            if(engsoft.CartaDAO.verificaCarta(cartaId)){
                if(Integer.valueOf(CartaID.getText())>0){
                        Catalogos = engsoft.TransacaoDAO.buscaCatalogo(cartaId);
                        if(Catalogos.isEmpty()){
                            mensagem.setText("Nenhuma carta encontrada!");
                        }
                }else{
                    mensagem.setText("Digite um ID maior que 0!");
                }
            }else{
                mensagem.setText("Carta não existente.");
            }
        }catch(Exception e){
            mensagem.setText("Digite um número válido!");
        }
    }
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CartaID.setText(String.valueOf(engsoft.ControleUI.getInstance().getIdCartaBuf()));
        Usuario.setText(engsoft.ControleUI.getInstance().getUserBuf());
        Catalogos = engsoft.TransacaoDAO.buscaCatalogo();
        
        
        if(!Catalogos.isEmpty()){
            showCards();
        }else{
            mensagem.setText("Não há cartas a venda.");
        }
    }
    
    public void inicializaArrays(){
        image.add(Image1);
        image.add(Image2);
        image.add(Image3);
        image.add(Image4);
        image.add(Image5);
        image.add(Image6);
        image.add(Image7);
        image.add(Image8);
        text.add(Text1);
        text.add(Text2);
        text.add(Text3);
        text.add(Text4);
        text.add(Text5);
        text.add(Text6);
        text.add(Text7);
        text.add(Text8);
        pane.add(pane0);
        pane.add(pane1);
        pane.add(pane2);
        pane.add(pane3);
        pane.add(pane4);
        pane.add(pane5);
        pane.add(pane6);
        pane.add(pane7);
    }
    
    @FXML
    public void next(){ //puxa as proximas cartas 
        showCards();
    }
    
    @FXML
    public void previous(){
        ctrl-=16;
        showCards();
    }
    
    public void showCards(){
        int j=0,l=ctrl;
        Id.clear();
        for(int i=l;i<l+8;i++){
            if(i<Catalogos.size()){
                pane.get(j).setVisible(true);
                image.get(j).setImage(engsoft.CartaDAO.puxarCarta(Catalogos.get(i).getIdCarta()));        
                text.get(j).setText(engsoft.CartaDAO.retornaNomeCard(Catalogos.get(i).getIdCarta())
                        +"\n"+Catalogos.get(i).getUsuario()+"\n"+
                        Catalogos.get(i).getValor());
                Id.add(i);
            }else{
                pane.get(j).setVisible(false);
            }
            j++;
            ctrl++;
        }
        if(ctrl<Catalogos.size()){
            next.setDisable(false);
        }else{
            next.setDisable(true);
        }
        if(ctrl<=8){
            previous.setDisable(true);
        }else{
            previous.setDisable(false);
        }
    }
}
