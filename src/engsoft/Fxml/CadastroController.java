/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft.Fxml;

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
    
    @FXML
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

  
    /**
     * Initializes the controller class.
     */
      
    @FXML
    public void retornaLogin(){
        engsoft.ControleUI.getInstance().mostraLogin();
             NickField.setText("");
             PassField.setText("");
             NomeField.setText("");
             NumField.setText("");
             EmailField.setText("");
             EndField.setText("");
             PaisField.setValue(null);
             EstadoField.setValue(null);
             CityField.setValue(null);  
    }
    
    @FXML
    public void carregaPais(){
        ObservableList Paises= FXCollections.observableArrayList();  
        try{
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery("SELECT * FROM PAIS");
        while(rs.next()){        
    Paises.add(rs.getString("NOME_PAIS"));
    }
    }
    catch(Exception e){
        System.out.println(e);
    }
    PaisField.setItems(Paises);  
    Mensagem.setText("");
    EstadoField.setValue(null);
    CityField.setValue(null);
    }
    
    @FXML
    public void carregaEstados(){
        ObservableList Estados= FXCollections.observableArrayList();
        if(PaisField.getValue()!=null){ 
    try{
        Statement s=con.createStatement();
        ResultSet rs=s.executeQuery("SELECT NOME_ESTADO FROM ESTADO WHERE PAIS_NOME_PAIS='"+ PaisField.getValue()+"'");
    while(rs.next()){        
        Estados.add(rs.getString("NOME_ESTADO"));
    }
    }
    catch(Exception e){
        System.out.println(e);
    }
    EstadoField.setItems(Estados);
    CityField.setValue(null);
    Mensagem.setText("");
        }
        else{
            Mensagem.setText("Selecione um país!");
        }
    }
    
    @FXML
    public void carregaCidades(){
         ObservableList Cidades= FXCollections.observableArrayList();
        if(EstadoField.getValue()!=null){ 
    try{
        Statement s=con.createStatement();
        ResultSet rs=s.executeQuery("SELECT NOME_CIDADE FROM CIDADE WHERE ESTADO_NOME_ESTADO='"+ EstadoField.getValue()+"'");
    while(rs.next()){        
        Cidades.add(rs.getString("NOME_CIDADE"));
    }
    }
    catch(Exception e){
        System.out.println(e);
    }
    CityField.setItems(Cidades);
        }
        else{
            Mensagem.setText("Selecione um estado!");
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
        try{
        Statement s=con.createStatement();
        s.executeUpdate("INSERT INTO USUARIO VALUES('"+NickField.getText()+"','"+NomeField.getText()+
                "','"+EndField.getText()+"','"+NumField.getText()+"','"+"1','"+
                EmailField.getText()+"','"+
                EstadoField.getValue()+"','"+CityField.getValue()+"','"+PaisField.getValue()+"')");
                Mensagem.setText("Usuário Cadastrado com sucesso!");
                s.executeUpdate("CREATE USER "+NickField.getText()+" WITH PASSWORD '"+PassField.getText()+"'");
                s.executeUpdate("CREATE VIEW "+NickField.getText()+"view AS SELECT * FROM USUARIO"
                        + " WHERE NICK_USUARIO='"+NickField.getText()+"'");
                s.executeUpdate("GRANT ALL ON "+NickField.getText()+"view TO "+NickField.getText());
                s.executeUpdate("REVOKE INSERT ON "+NickField.getText()+"view FROM "+
                        NickField.getText());
                s.close();              
                 
    }
        catch(Exception e){
            Mensagem.setText("Nome de usuário ou email já cadastrados!");
            System.out.println(e);
           
        }
    }
    
    private Connection con = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        con = engsoft.ConexaoDB.getCon();
        carregaPais();
    }    
    
}
