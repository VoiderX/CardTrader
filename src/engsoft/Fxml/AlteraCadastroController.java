/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft.Fxml;

import engsoft.Utilidades;
import engsoft.Valida;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Gabriel
 */
public class AlteraCadastroController implements Initializable {
    
    @FXML //Inicialização dos elementos
    TextField NickField=new TextField();
    @FXML
    TextField NomeField=new TextField();
    @FXML
    TextField EndField=new TextField();
    @FXML
    TextField DDDField=new TextField();
    @FXML
    TextField CodCddField=new TextField();
    @FXML
    TextField NumUsuarioField=new TextField();
    String NumField;
    @FXML
    ChoiceBox PaisField=new ChoiceBox();
    @FXML
    ChoiceBox EstadoField=new ChoiceBox();
    @FXML
    ChoiceBox CityField=new ChoiceBox();
    @FXML
    TextField EmailField=new TextField();
    @FXML
    Text Mensagem=new Text();
    engsoft.Locations Loc;  
    
    private Connection con = null;
    private engsoft.UserConexaoDB conexao =null;    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Loc=new engsoft.Locations(); //Instancia a classe de localizações
        Loc.carregaPais(PaisField, Mensagem); //Carrega os países ao incicializar a interface
        conexao=engsoft.ControleUI.getInstance().getConexaoUser();
        puxarInfo();// Puxa as informações do usuário       
    } 
    @FXML    
    public void limpaCampos(){
          Loc.limpaCampos(EstadoField, CityField);//Chama o método de limpar os campos
        }
    
    
    @FXML
    public void carregaEstados(){
        Loc.carregaEstados(PaisField, EstadoField, CityField, Mensagem); //Método para carregar o estados
    }
    
    @FXML
    public void carregaCidades(){
        Loc.carregaCidades(PaisField, EstadoField, CityField, Mensagem);//Método para carregar as cidades        
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
      conexao.puxarInfo(NickField, NomeField, DDDField, CodCddField, NumUsuarioField, EmailField, 
              EndField, PaisField, EstadoField, CityField, Mensagem);
              Utilidades.firstToUpper(NomeField);
              Utilidades.firstToUpper(EndField);
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
        if(Valida.validaAltCadastro(NomeField.getText(), EndField.getText(), NumField, EmailField.getText(),((CityField.getValue()==null)?"":CityField.getValue().toString()), mens)){           
          Mensagem.setText(conexao.alterarCadastro(NomeField.getText().toUpperCase(),
                  NumField, EmailField.getText().toUpperCase(),
                  EndField.getText().toUpperCase(),
                  PaisField.getValue().toString(), EstadoField.getValue().toString()
                  ,CityField.getValue().toString()));                  
        }else{
            Mensagem.setText(mens.toString());
        }      
    }
    @FXML
    public void alterarSenha(){
        engsoft.ControleUI.getInstance().chamaRecPass();
    }
}
