/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft.Fxml.ComprarCarta;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Gabriel
 */
public class ComprarCartaController implements Initializable {
    @FXML
    ImageView Imagem;
    @FXML
    Text TextTotal;
    @FXML
    Text TextVendedor;
    @FXML
    Text TextValor;
    @FXML
    Text TextNomeCarta;
    @FXML
    TextField Quantidade;
    @FXML
    TextField Valor;
    @FXML
    Text Mensagem;
    @FXML
    Button Pago;
    @FXML
    Button Recebido;
    @FXML
    Button Calcular;
    @FXML
    Button Comprar;
    @FXML
    TextField Estado;
    @FXML
    Label EstadoMsg;
    @FXML
    Label ValorLabel;
    @FXML
    Label TotalLabel;
    @FXML
    public void cancelar(){
       engsoft.ControleUI.getInstance().saisecondStage();
    }
    @FXML
    public void comprar(){
      Mensagem.setText(engsoft.TransacaoDAO.comprarCarta(TextVendedor.getText(), engsoft.ControleUI.getInstance().getConexaoUser().getUsuario()
               , engsoft.ControleUI.getInstance().getCatalogoBuf().getIdCarta()
               , Integer.valueOf(Quantidade.getText()),
               Float.valueOf(TextValor.getText())*Integer.valueOf(Quantidade.getText())));
      if(Mensagem.getText().equals("Transação efetuada com sucesso!")){
      TextTotal.setText(String.valueOf(Integer.valueOf(TextTotal.getText())-Integer.valueOf(Quantidade.getText())));
      }
      engsoft.ControleUI.getInstance().chamaProcuraCarta();
      engsoft.ControleUI.getInstance().arrastarSecondStage();
    }
    @FXML
    public void calcular(){
        Valor.setText(String.valueOf(Float.valueOf(TextValor.getText())*Integer.valueOf(Quantidade.getText())));
    }
    @FXML
    public void marcarPago(){
       Mensagem.setText(engsoft.TransacaoDAO.marcarPago(
                engsoft.ControleUI.getInstance().getTraBuf().getVendedor(),
                engsoft.ControleUI.getInstance().getTraBuf().getComprador(),
                engsoft.ControleUI.getInstance().getTraBuf().getIdCarta(),
                engsoft.ControleUI.getInstance().getTraBuf().getValor()));
       if(Mensagem.getText().equals("Alteração Efetuada com Sucesso!")){
           Estado.setText("Pago");
       }
       engsoft.ControleUI.getInstance().chamaHistoricoVendas();
       engsoft.ControleUI.getInstance().arrastarSecondStage();
    }
    @FXML
    public void marcarRecebido(){
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        if(engsoft.ControleUI.getInstance().verificaMainStage().equals("Procura")){
        Imagem.setImage(engsoft.CartaDAO.puxarCarta(engsoft.ControleUI.getInstance().getCatalogoBuf().getIdCarta()));
        TextTotal.setText(String.valueOf(engsoft.ControleUI.getInstance().getCatalogoBuf().getQuantCatalogo()));
        TextVendedor.setText(engsoft.ControleUI.getInstance().getCatalogoBuf().getUsuario());
        TextValor.setText(String.valueOf(engsoft.ControleUI.getInstance().getCatalogoBuf().getValor()));
        TextNomeCarta.setText(engsoft.CartaDAO.retornaNomeCard(engsoft.ControleUI.getInstance().getCatalogoBuf().getIdCarta()));
            Pago.setDisable(true);
            Recebido.setDisable(true);
            EstadoMsg.setDisable(true);
            Valor.setEditable(false);
            Pago.setVisible(false);
            Recebido.setVisible(false);
            EstadoMsg.setVisible(false);
            Estado.setVisible((false));
        }
        else if(engsoft.ControleUI.getInstance().verificaMainStage().equals("Historico Vendas")){
            Comprar.setDisable(true);
            Comprar.setVisible(false);
            Calcular.setDisable(true);
            Calcular.setVisible(false);
            Recebido.setDisable(true);
            Recebido.setVisible(false);
            ValorLabel.setVisible(false);
            TotalLabel.setVisible(false);
            
            Imagem.setImage(engsoft.CartaDAO.puxarCarta(engsoft.ControleUI.getInstance().getTraBuf().getIdCarta()));
            TextVendedor.setText(engsoft.ControleUI.getInstance().getTraBuf().getVendedor());
            Quantidade.setText(String.valueOf(engsoft.ControleUI.getInstance().getTraBuf().getQuantidade()));
            Valor.setText(String.valueOf(engsoft.ControleUI.getInstance().getTraBuf().getValor()));
            TextNomeCarta.setText(engsoft.CartaDAO.retornaNomeCard(engsoft.ControleUI.getInstance().getTraBuf().getIdCarta()));
            Estado.setText(engsoft.ControleUI.getInstance().getTraBuf().getStatus());
        }
    }    
    
}
