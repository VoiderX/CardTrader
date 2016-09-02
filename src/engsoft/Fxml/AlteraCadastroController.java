/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft.Fxml;

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
    TextField NumField=new TextField();
    @FXML
    ChoiceBox PaisField=new ChoiceBox();
    @FXML
    ChoiceBox EstadoField=new ChoiceBox();
    @FXML
    ChoiceBox CityField=new ChoiceBox();
    @FXML
    PasswordField PassField=new PasswordField();
    @FXML
    TextField EmailField=new TextField();
    @FXML
    Text Mensagem=new Text();
    ObservableList ConjVazio= FXCollections.observableArrayList();

    private Connection con = null;
    private Connection conUser=null;
    String usuario;
    public void setConUser(Connection conUser){ //Método para settar a conexão do usúario nesta interface
        this.conUser=conUser;
    }
    /**
     * Initializes the controller class
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        con = engsoft.ConexaoDB.getCon();//Utiliza a conexão root para puxar os países,estados e cidades
        conUser=engsoft.ControleUI.getInstance().getConUser();//Recebe a conexão do usuário
        usuario= engsoft.ControleUI.getInstance().getUser();//Recebe o usuário da classe de controle
        carregaPais();//Carrega os países
        puxarInfo();// Puxa as informações do usuário
        
    } 
    @FXML
    
    public void limpaCampos(){
        //Função para  limpar os campos
        EstadoField.setValue(ConjVazio); //Limpa o valor atual
        CityField.setValue(ConjVazio);
        EstadoField.setItems(ConjVazio);//Limpa o vetor de items
        CityField.setItems(ConjVazio);        
        }
    
     @FXML
    public void carregaPais(){
    ObservableList Paises= FXCollections.observableArrayList();//Inicializa o "array"
    try{
    Statement s = con.createStatement();
    ResultSet rs=s.executeQuery("SELECT * FROM PAIS");//Result set com todos os países
    while(rs.next()){//Loop para adicionr os páises no array
    Paises.add(rs.getString("NOME_PAIS"));
    }
    }
    catch(Exception e){
        System.out.println(e);
    }
    PaisField.setItems(Paises);//Adiciona os países na choice box  
    Mensagem.setText("");//Limpa os campos            
    }
    
    @FXML
    public void carregaEstados(){
        ObservableList Estados= FXCollections.observableArrayList();//Inicializa o "array"
        if(PaisField.getValue()!=null){//Verifica se o país foi selecionado
    try{
        Statement s=con.createStatement();//Insere no rs somente os estados dos países selecionados
        ResultSet rs=s.executeQuery("SELECT NOME_ESTADO FROM ESTADO WHERE PAIS_NOME_PAIS='"+ PaisField.getValue()+"'");
    while(rs.next()){        
        Estados.add(rs.getString("NOME_ESTADO"));//Idem ao carregaPaíses até o fim do método
    }
    }
    catch(Exception e){
        System.out.println(e);
    }
    EstadoField.setItems(Estados);
    CityField.setValue(null);
    Mensagem.setText("");
    EstadoField.show();
        }
        else{
            limpaCampos();
            Mensagem.setText("Selecione um país!");
        }
    }
    
    @FXML
    public void carregaCidades(){//Idem ao carregaEstados
         ObservableList Cidades= FXCollections.observableArrayList();
        if(EstadoField.getValue()!=null){
           
    try{
        Statement s=con.createStatement();
        ResultSet rs=s.executeQuery("SELECT NOME_CIDADE FROM CIDADE WHERE ESTADO_NOME_ESTADO='"
                + EstadoField.getValue()+"' AND ESTADO_PAIS_NOME_PAIS='"+PaisField.getValue()+"'");
    while(rs.next()){        
        Cidades.add(rs.getString("NOME_CIDADE"));
    }
    }
    catch(Exception e){
        System.out.println(e);
    }
    CityField.setItems(Cidades);
    CityField.show();
        }
        else{//Limpeza de campos caso não haja um estado selecionado
            limpaCampos();
            Mensagem.setText("Selecione um estado!");
        }
    }
   

    @FXML
    private void retornaMenu(){//Retorna ao menu e limpa os campos;    
             NickField.setText("");
             PassField.setText("");
             NomeField.setText("");
             NumField.setText("");
             EmailField.setText("");
             EndField.setText("");
             PaisField.setValue(null);
             EstadoField.setValue(null);
             CityField.setValue(null);     
    engsoft.ControleUI.getInstance().mostraMenu();
    }
    
    @FXML
    private void puxarInfo(){//Puxa as informações do usuário
      
      try{             
             Statement s = conUser.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
             String sql = "SELECT * FROM "+usuario+"view";
             ResultSet rs = s.executeQuery(sql); //Result set recebe apenas os dados da view do usuário
             rs.first();//Coloca o result set na primeira posição
             NickField.setText(rs.getString("NICK_USUARIO"));//Puxa os dados do banco e exibe para o usuário
             NickField.setDisable(true);
             NomeField.setText(rs.getString("NOME_USUARIO"));
             NumField.setText(rs.getString("NUM_USUARIO"));
             EmailField.setText(rs.getString("EMAIL_USUARIO"));
             EndField.setText(rs.getString("ENDERECO_USUARIO"));
             carregaPais();
             PaisField.setValue(rs.getString("CIDADE_ESTADO_PAIS_NOME_PAIS"));
             carregaEstados();
             EstadoField.setValue(rs.getString("CIDADE_ESTADO_NOME_ESTADO"));
             carregaCidades();
             CityField.setValue(rs.getString("CIDADE_NOME_CIDADE"));
             rs.first();
             rs.close();//Fecha o result set
             s.close(); //Fecha o statement     
             Mensagem.setText("Dados carregados com sucesso!");
             
     }
      catch(Exception e){
          System.out.println(e);
          Mensagem.setText("Erro ao carregar dados!");
      }
    }
    
    @FXML
    private void atualizaCadastro() {//Atualiza as informações do usuário
        //Adicionar um if para validar o nome de usuário,nome,senha,endereço,email e numero
        //Email-Validar Formato
        //Outros-definir um número minimo e máximo de caracteres, baseados no banco de dados
        //Lembrete:No banco aumentar o número máximo das caracteres de telefone e definir email como uma
        //chave candidata
        //Converter todos os atributos menos o nick pra maiusculo
        if(Valida.validaAltCadastro(NomeField, EndField, NumField, EmailField, CityField, Mensagem)){
            try{
                Statement s=conUser.createStatement();//Passa as querys de alteração de dados
                if(!PassField.getText().isEmpty()){
                    s.executeUpdate("ALTER USER "+usuario+" WITH PASSWORD '"+PassField.getText()+"'");
                }
                s.executeUpdate("UPDATE "+usuario+"view SET NOME_USUARIO='"+NomeField.getText()+"' WHERE NICK_USUARIO='"+
                            engsoft.ControleUI.getInstance().getUser()+"'");
                s.executeUpdate("UPDATE "+usuario+"view SET NUM_USUARIO='"+NumField.getText()+"' WHERE NICK_USUARIO='"+
                            engsoft.ControleUI.getInstance().getUser()+"'");
                s.executeUpdate("UPDATE "+usuario+"view SET EMAIL_USUARIO='"+EmailField.getText()+"' WHERE NICK_USUARIO='"+
                            engsoft.ControleUI.getInstance().getUser()+"'");
                s.executeUpdate("UPDATE "+usuario+"view SET ENDERECO_USUARIO='"+EndField.getText()+"' WHERE NICK_USUARIO='"+
                            engsoft.ControleUI.getInstance().getUser()+"'");
                s.executeUpdate("UPDATE "+usuario+"view SET(CIDADE_ESTADO_PAIS_NOME_PAIS,CIDADE_ESTADO_NOME_ESTADO,CIDADE_NOME_CIDADE)"
                            +"=('"+PaisField.getValue()+"','"+EstadoField.getValue()+"','"+CityField.getValue()+"')WHERE "+
                             "NICK_USUARIO='"+engsoft.ControleUI.getInstance().getUser()+"'");
                    //Update de Pais-Estado-Cidade, devem ser realizados todos em uma unica query devido ser uma chave composta        
                Mensagem.setText("Dados atualizados com sucesso!");
                s.close();      
            }catch(Exception e){//Banco pode lançar exceção chave duplicada ou email duplicado
                //Outras possibilidades devem ser tratadas na interface 
                System.out.println(e);
                Mensagem.setText("Nome de usuário ou email já utilizados!");
            }
        }
    }
}
