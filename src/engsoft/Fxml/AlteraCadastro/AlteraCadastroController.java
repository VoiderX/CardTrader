/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package engsoft.Fxml.AlteraCadastro;

import engsoft.Locations;
import engsoft.Valida;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
* FXML Controller class
*
* @author Gabriel
*/
public class AlteraCadastroController implements Initializable {

   @FXML //Inicialização dos elementos
   TextField NickField;
   @FXML
   TextField NomeField;
   @FXML
   TextField EndField;
   @FXML
   TextField DDDField;
   @FXML
   TextField CodCddField;
   @FXML
   TextField NumUsuarioField;
   @FXML
   ChoiceBox <String> PaisField;
   @FXML
   ChoiceBox <String> EstadoField;
   @FXML
   ChoiceBox <String> CityField;
   @FXML
   TextField EmailField;
   @FXML
   Text Mensagem;
   engsoft.Locations Loc;

   private Connection con = null;
   private engsoft.UserConexaoDB conexao =null;


   @Override
   public void initialize(URL url, ResourceBundle rb) {
      Loc=new engsoft.Locations(); //Instancia a classe de localizações
      PaisField.setItems(engsoft.Locations.carregaPais());
      conexao=engsoft.ControleUI.getInstance().getConexaoUser();
      puxarInfo();// Puxa as informações do usuário
      NickField.setDisable(true);
   }
   @FXML
   public void limpaCampos(){
      ObservableList<String> ConjVazio= FXCollections.observableArrayList();//Inicializa o "array"
      EstadoField.setItems(ConjVazio);
      EstadoField.setValue("");
      CityField.setItems(ConjVazio);
      CityField.setValue("");
      Mensagem.setText("");
   }
   public void limpaCidade(){
      ObservableList<String> ConjVazio= FXCollections.observableArrayList();//Inicializa o "array"
      CityField.setItems(ConjVazio);
      CityField.setValue("");
      Mensagem.setText("");
   }
   @FXML
   public void carregaEstados(){
      limpaCidade();
      if(PaisField.getValue()!=null){
         EstadoField.setItems(engsoft.Locations.carregaEstados(PaisField.getValue()));
      }
      else{
         Mensagem.setText("Selecione um país!");
      }
   }

   @FXML
   public void carregaCidades(){
      if(PaisField.getValue()==null){
         Mensagem.setText("Selecione um país!");
      }
      else{
         if((EstadoField.getValue()!=null)&&!(EstadoField.getValue().equals(""))){
            CityField.setItems(engsoft.Locations.CarregaCidades(EstadoField.getValue(), PaisField.getValue()));
         }
         else{
            Mensagem.setText("Selecione um estado!");
         }
      }
   }

   @FXML
   private void retornaMenu(){//Retorna ao menu e limpa os campos;
      NickField.setText("");
      NomeField.setText("");
      EmailField.setText("");
      EndField.setText("");
      PaisField.setValue(null);
      EstadoField.setValue(null);
      CityField.setValue(null);
      engsoft.ControleUI.getInstance().mostraMenu();
   }

   @FXML
   private void puxarInfo(){//Puxa as informações do usuário
      engsoft.Usuario user;
      user = engsoft.ControleUI.getInstance().getConexaoUser().puxarInfo();
      NickField.setText(user.getNickField());
      NomeField.setText(engsoft.Utilidades.firstToUpper(user.getNomeField()));
      EmailField.setText(user.getEmailField());
      EndField.setText(engsoft.Utilidades.firstToUpper(user.getEndField()));
      PaisField.setValue(user.getPaisField());
      carregaEstados();
      EstadoField.setValue(user.getEstadoField());
      CityField.setItems(engsoft.Locations.CarregaCidades(EstadoField.getValue(), PaisField.getValue()));
      CityField.setValue(user.getCityField());
      engsoft.Utilidades.telSplit(user.getNumUsuarioField(), DDDField, CodCddField, NumUsuarioField);

   }

   @FXML
   private void atualizaCadastro() {//Atualiza as informações do usuário
      //Adicionar um if para validar o nome de usuário,nome,senha,endereço,email e numero
      //Email-Validar Formato
      //Outros-definir um número minimo e máximo de caracteres, baseados no banco de dados
      //Lembrete:No banco aumentar o número máximo das caracteres de telefone e definir email como uma
      //chave candidata
      //Converter todos os atributos menos o nick pra maiusculo
      String NumField=(DDDField.getText()+CodCddField.getText()+NumUsuarioField.getText());
      StringBuilder mens = new StringBuilder("");
      if(Valida.validaAltCadastro(NomeField.getText(), EndField.getText(), NumField, EmailField.getText(),((CityField.getValue()==null)?"":CityField.getValue()), mens)){
         Mensagem.setText(conexao.alterarCadastro(NomeField.getText().toUpperCase(),
         NumField, EmailField.getText().toUpperCase(),
         EndField.getText().toUpperCase(),
         PaisField.getValue(), EstadoField.getValue()
         ,CityField.getValue()));
      }else{
         Mensagem.setText(mens.toString());
      }
   }
   @FXML
   public void alterarSenha(){
      engsoft.ControleUI.getInstance().chamaRecPass();
   }
}
