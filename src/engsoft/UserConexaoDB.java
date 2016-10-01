/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft;

import java.sql.*;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
/**
 *
 * @author Gabriel
 */
public class UserConexaoDB {  //Classe para a conexão especifica de um usúario no sistema
    //Se possível passar para singleton
    
private Connection conUser;   
private String usuario;
private String senha;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    public Connection createCon(){       
      
        try{
            String url = "jdbc:postgresql://localhost:5432/trabsoftw";  
            
            Class.forName("org.postgresql.Driver");  
  
            conUser = DriverManager.getConnection(url,usuario,senha); 
            
            
        }
         
            catch(ClassNotFoundException | SQLException e){
                    System.out.println("Erro ao acessar o banco");
        }
        return(conUser);
    }
    public void fecharConexao(){
        try{
        conUser.close();
        }
        catch(Exception e){
            System.out.println("Erro ao encerrar conexão!");
        }
    }
    
    public void puxarInfo(TextField NickField,TextField NomeField,TextField DDDField,TextField
            CodCddField,TextField NumUsuarioField,TextField EmailField,TextField EndField, 
            ChoiceBox<String> PaisField,ChoiceBox<String> EstadoField,ChoiceBox<String> CityField,Text Mensagem){
         try{             
             Statement s = conUser.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
             String sql = "SELECT * FROM "+usuario+"view";
             ResultSet rs = s.executeQuery(sql); //Result set recebe apenas os dados da view do usuário
             rs.first();//Coloca o result set na primeira posição
             NickField.setText(rs.getString("NICK_USUARIO"));//Puxa os dados do banco e exibe para o usuário
             NickField.setDisable(true);
             NomeField.setText(rs.getString("NOME_USUARIO").toLowerCase());
             String NumField;
             NumField=rs.getString("NUM_USUARIO");             
             Utilidades.telSplit(NumField, DDDField, CodCddField, NumUsuarioField);
             EmailField.setText(rs.getString("EMAIL_USUARIO").toLowerCase());
             EndField.setText(rs.getString("ENDERECO_USUARIO").toLowerCase());
             Locations Loc = new Locations();
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
    
    public String alterarCadastro(String NomeField,String NumField,String EmailField,
    String EndField,String PaisField,String EstadoField,String CityField){
        String Mensagem;
          try{
                Statement s=conUser.createStatement();//Passa as querys de alteração de dados
               
                s.executeUpdate("UPDATE "+usuario+"view SET NOME_USUARIO='"+NomeField+"' WHERE NICK_USUARIO='"+
                            usuario+"'");
                s.executeUpdate("UPDATE "+usuario+"view SET NUM_USUARIO='"+NumField+"' WHERE NICK_USUARIO='"+
                            usuario+"'");
                s.executeUpdate("UPDATE "+usuario+"view SET EMAIL_USUARIO='"+EmailField+"' WHERE NICK_USUARIO='"+
                            usuario+"'");
                s.executeUpdate("UPDATE "+usuario+"view SET ENDERECO_USUARIO='"+EndField+"' WHERE NICK_USUARIO='"+
                            usuario+"'");
                s.executeUpdate("UPDATE "+usuario+"view SET(CIDADE_ESTADO_PAIS_NOME_PAIS,CIDADE_ESTADO_NOME_ESTADO,CIDADE_NOME_CIDADE)"
                            +"=('"+PaisField+"','"+EstadoField+"','"+CityField+"')WHERE "+
                             "NICK_USUARIO='"+usuario+"'");
                    //Update de Pais-Estado-Cidade, devem ser realizados todos em uma unica query devido ser uma chave composta        
                Mensagem= "Dados atualizados com sucesso!";
                s.close();      
            }catch(Exception e){//Banco pode lançar exceção chave duplicada ou email duplicado
                //Outras possibilidades devem ser tratadas na interface 
                System.out.println(e);
                Mensagem=  "Nome de usuário ou email já utilizados!";
            }
          return Mensagem;
    }
    
    public ResultSet retornaCatalogo(){
        ResultSet rs=null;
       try{
           Statement s= conUser.createStatement();
           rs=s.executeQuery("SELECT * FROM "+usuario+"catview");
       }
       catch(Exception e){
           e.printStackTrace();
       }
       return rs;
    }
    
    public String insereCatalogo(int IdCarta,int quant,float valor){
        if(quant<1){
            return("Quantidade inválida!");
        }else if(valor<=0.0){
            return("Valor inválido");
        }else{
            
            try{
                Statement s= conUser.createStatement();
                s.executeUpdate("INSERT INTO "+usuario+"catview"+ " VALUES ('"+usuario+"',"+IdCarta+","+quant+","+valor+")");
                return "Item inserido com sucesso!";
            }
           catch(Exception e){
               e.printStackTrace();
               return "Um erro ocorreu!";
           }
       }
    }
    
    public void deletaCatalogo(int IdCarta){
       try{
            Statement s= conUser.createStatement();
            s.executeUpdate("DELETE FROM "+usuario+"catview WHERE CARTA_CATALOGO="+IdCarta);
       }
       catch(Exception e){
           e.printStackTrace();
       }
    }
    
    public void alteraCatalogo(int IdCarta,float valor, int quantidade){
        try{
            Statement s= conUser.createStatement();
            s.executeUpdate("UPDATE "+usuario+"catview SET (USUARIO_CATALOGO,CARTA_CATALOGO,QUANT_CATALOGO,VALOR_CATALOGO)"+
            "=('"+usuario+"',"+IdCarta+","+quantidade+","+valor+")"
                    + " WHERE CARTA_CATALOGO="+IdCarta);
       }
       catch(Exception e){
           e.printStackTrace();
       }
    }
    public ResultSet retornaInfoCarta(int IdCarta){       
        ResultSet rs=null;
        try{
             Statement s=conUser.createStatement();
              rs=s.executeQuery("SELECT * FROM "+usuario+"catview WHERE CARTA_CATALOGO="+IdCarta);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return rs;
        }
    
}
