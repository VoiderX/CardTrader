/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package engsoft.Fxml.Cadastro;

import engsoft.Valida;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;

/**
* FXML Controller class
*
* @author Gabriel
*/
public class CadastroController implements Initializable {

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
   String NumField;
   @FXML
   TextField EmailField;
   @FXML
   ChoiceBox<String> PaisField;
   @FXML
   ChoiceBox<String> EstadoField;
   @FXML
   ChoiceBox<String> CityField;
   @FXML
   PasswordField PassField;
   @FXML
   Text Mensagem;
   engsoft.Locations Loc;
   engsoft.ConexaoDB conexao;
   @FXML
   public void retornaLogin(){ //Retorna para a tela de login
      engsoft.ControleUI.getInstance().mostraLogin(); //Instanciado através da classe singleton
      NickField.setText("");
      PassField.setText("");
      NomeField.setText("");
      EmailField.setText("");
      EndField.setText("");
      PaisField.setValue(null);
      EstadoField.setValue(null);
      CityField.setValue(null);
      Mensagem.setText("");
      DDDField.setText("");
      CodCddField.setText("");
      NumUsuarioField.setText("");
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
   public void realizaCadastro(){
      //Adicionar um if para validar o nome de usuário,nome,senha,endereço,email e numero
      //Email-Validar Formato
      //Outros-definir um número minimo e máximo de caracteres, baseados no banco de dados
      //Lembrete:No banco aumentar o número máximo das caracteres de telefone e definir email como uma
      //chave candidata
      //Converter todos os atributos menos o nick pra maiusculo
      NumField=(DDDField.getText()+CodCddField.getText()+NumUsuarioField.getText());  //Cooncatena os dados do telefone
      StringBuilder mens = new StringBuilder("");
      if(Valida.validaCadastro(NickField.getText(), NomeField.getText(), EndField.getText(), NumField, EmailField.getText(), ((CityField.getValue()==null)?"":CityField.getValue()), PassField.getText(), mens)){

         Mensagem.setText(conexao.realizaCadastro(NickField.getText(),NomeField.getText(),
         EndField.getText(),NumField,EmailField.getText(),PaisField.getValue()
         ,EstadoField.getValue()
         ,CityField.getValue(),PassField.getText()));
      }else{
         Mensagem.setText(mens.toString());
      }
   }


   @Override
   public void initialize(URL url, ResourceBundle rb) {
      conexao = new engsoft.ConexaoDB(); //Necessário utilizar a conexão base para realização do cadastro
      Loc= new engsoft.Locations();
      PaisField.setItems(engsoft.Locations.carregaPais());
   }

}
