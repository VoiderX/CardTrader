/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft.Fxml;

import engsoft.Valida;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    TextField NickField=new TextField();
    @FXML
    TextField NomeField=new TextField();
    @FXML
    TextField EndField=new TextField();
    @FXML
    TextField NumField=new TextField();
    @FXML
    TextField EmailField=new TextField();
    @FXML
    ChoiceBox PaisField=new ChoiceBox();
    @FXML
    ChoiceBox EstadoField= new ChoiceBox();
    @FXML
    ChoiceBox CityField=new ChoiceBox();
    @FXML
    PasswordField PassField=new PasswordField();
    @FXML 
    Text Mensagem= new Text();
    engsoft.Locations Loc;
    
    @FXML
    public void retornaLogin(){ //Retorna para a tela de login
        engsoft.ControleUI.getInstance().mostraLogin(); //Instanciado através da classe singleton
             NickField.setText("");
             PassField.setText("");
             NomeField.setText("");
             NumField.setText("");
             EmailField.setText("");
             EndField.setText("");
             PaisField.setValue(null);
             EstadoField.setValue(null);
             CityField.setValue(null);
             Mensagem.setText("");
    }    
   
    
    @FXML
    public void limpaCampos(){
        Loc.limpaCampos(EstadoField, CityField);
    }
    
    @FXML
    public void carregaEstados(){
        Loc.carregaEstados(PaisField, EstadoField, CityField, Mensagem);
    }
    
    @FXML
    public void carregaCidades(){
        Loc.carregaCidades(PaisField, EstadoField, CityField, Mensagem);
    }
   
    
    
    @FXML
    public void realizaCadastro(){
        //Adicionar um if para validar o nome de usuário,nome,senha,endereço,email e numero
        //Email-Validar Formato
        //Outros-definir um número minimo e máximo de caracteres, baseados no banco de dados
        //Lembrete:No banco aumentar o número máximo das caracteres de telefone e definir email como uma
        //chave candidata
        //Converter todos os atributos menos o nick pra maiusculo
        if(Valida.validaCadastro(NickField, NomeField, EndField, NumField, EmailField, CityField, PassField, Mensagem)){
            try{
                Statement s=con.createStatement(); //Inicia o statement
                
                   //Insere os dados na tabela do usuário
                s.executeUpdate("INSERT INTO USUARIO VALUES('"+NickField.getText()+"','"+NomeField.getText().toUpperCase()+
                        "','"+EndField.getText().toUpperCase()+"','"+NumField.getText()+"','"+
                        EmailField.getText().toUpperCase()+"','"+
                        PaisField.getValue()+"','"+EstadoField.getValue()+"','"+CityField.getValue()+"')");
                        Mensagem.setText("Usuário Cadastrado com sucesso!");
                
                //Cria um usuário no banco de dados com a senha fornecida pelo usuário   
                s.executeUpdate("CREATE USER "+NickField.getText()+" WITH PASSWORD '"+PassField.getText()+"'");

                //Cria uma visão da tabela usuario para o usuario com o nome de Userview            
                s.executeUpdate("CREATE VIEW "+NickField.getText()+"view AS SELECT * FROM USUARIO"
                                + " WHERE NICK_USUARIO='"+NickField.getText()+"'");        

                   //Fornece permissão de seleção e atualização na sua própria view
                s.executeUpdate("GRANT SELECT,UPDATE ON "+NickField.getText()+"view TO "+NickField.getText());                     

                s.close();//Encerra o statement(declaração);           

            }catch(Exception e){//Caso haja um email ou usuario com o mesmo nome o banco irá retornar uma exceção
                Mensagem.setText("Nome de usuário ou email já cadastrados!");
                System.out.println(e);           
            }
        }
    }
    
    private Connection con = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        con = engsoft.ConexaoDB.getCon(); //Necessário utilizar a conexão base para realização do cadastro
        Loc= new engsoft.Locations();
        Loc.carregaPais(PaisField, Mensagem);
        
    }    
    
}
