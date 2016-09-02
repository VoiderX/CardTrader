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
        Loc=new engsoft.Locations();
        Loc.carregaPais(PaisField, Mensagem);
        conUser=engsoft.ControleUI.getInstance().getConUser();
        usuario=engsoft.ControleUI.getInstance().getUser();
        puxarInfo();// Puxa as informações do usuário
        
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
      
      try{             
             Statement s = conUser.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
             String sql = "SELECT * FROM "+usuario+"view";
             ResultSet rs = s.executeQuery(sql); //Result set recebe apenas os dados da view do usuário
             rs.first();//Coloca o result set na primeira posição
             NickField.setText(rs.getString("NICK_USUARIO"));//Puxa os dados do banco e exibe para o usuário
             NickField.setDisable(true);
             NomeField.setText(rs.getString("NOME_USUARIO"));
             NumField=rs.getString("NUM_USUARIO");
             
             if(NumField.length()==11){
                if(NumField.subSequence(0,1).equals("0")){
                    DDDField.setText(NumField.substring(0,3));
                    CodCddField.setText(NumField.substring(3,7));
                    NumUsuarioField.setText(NumField.substring(7,11));    
                }else{
                     DDDField.setText(NumField.substring(0,2));
                     CodCddField.setText(NumField.substring(2,7));
                     NumUsuarioField.setText(NumField.substring(7,11));
                }
             }
             
             if(NumField.length()==10){
                     DDDField.setText(NumField.substring(0,2));
                     CodCddField.setText(NumField.substring(2,6));
                     NumUsuarioField.setText(NumField.substring(6,10)); 
             }
             
             if(NumField.length()==12){
                 DDDField.setText(NumField.substring(0,3));
                     CodCddField.setText(NumField.substring(3,8));
                     NumUsuarioField.setText(NumField.substring(8,12));
             }
             
             EmailField.setText(rs.getString("EMAIL_USUARIO"));
             EndField.setText(rs.getString("ENDERECO_USUARIO"));
             Loc.carregaEstados(PaisField, EstadoField, CityField, Mensagem);
             PaisField.setValue(rs.getString("CIDADE_ESTADO_PAIS_NOME_PAIS"));
             Loc.carregaEstados(PaisField, EstadoField, CityField, Mensagem);
             EstadoField.setValue(rs.getString("CIDADE_ESTADO_NOME_ESTADO"));
             Loc.carregaCidades(PaisField, EstadoField, CityField, Mensagem);
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
        String NumField=(DDDField.getText()+CodCddField.getText()+NumUsuarioField.getText());
        if(Valida.validaAltCadastro(NomeField, EndField, NumField, EmailField, CityField, Mensagem)){
            try{
                Statement s=conUser.createStatement();//Passa as querys de alteração de dados
               
                s.executeUpdate("UPDATE "+usuario+"view SET NOME_USUARIO='"+NomeField.getText()+"' WHERE NICK_USUARIO='"+
                            engsoft.ControleUI.getInstance().getUser()+"'");
                s.executeUpdate("UPDATE "+usuario+"view SET NUM_USUARIO='"+NumField+"' WHERE NICK_USUARIO='"+
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
    @FXML
    public void alterarSenha(){
        engsoft.ControleUI.getInstance().chamaRecPass();
    }
}
