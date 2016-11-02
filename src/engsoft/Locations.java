/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

/**
 *
 * @author Gabriel
 */
public class Locations { //Classe para armazenar os métodos de consulta as tabelas de países,estados e cidades
    
    public static ObservableList<String> carregaPais(){
    Connection con=ConexaoDB.getCon();
    ObservableList<String> Paises= FXCollections.observableArrayList();//Inicializa o "array"
    try{
    Statement s = con.createStatement();
    ResultSet rs=s.executeQuery("SELECT * FROM PAIS");//Result set com todos os países
        while(rs.next()){//Loop para adicionr os páises no array
        Paises.add(rs.getString("NOME_PAIS"));
        }
    }
    catch(Exception e){
    }
    return Paises;
    }
    
    public static ObservableList<String> carregaEstados(String PaisField){
        Connection con=ConexaoDB.getCon();
        ObservableList<String> Estados= FXCollections.observableArrayList();//Inicializa o "array"
        if(PaisField!=null){//Verifica se o país foi selecionado
            try{
                Statement s=con.createStatement();//Insere no rs somente os estados dos países selecionados
                ResultSet rs=s.executeQuery("SELECT NOME_ESTADO FROM ESTADO WHERE PAIS_NOME_PAIS='"+ PaisField+"'");
                while(rs.next()){        
                    Estados.add(rs.getString("NOME_ESTADO"));//Idem ao carregaPaíses até o fim do método
                }
            }
            catch(Exception e){
            }
        }
        return Estados;
    }
    
    @FXML
    public static ObservableList<String> CarregaCidades(String EstadoField,String PaisField){//Idem ao carregaEstados
        Connection con=ConexaoDB.getCon();
        ObservableList<String> Cidades= FXCollections.observableArrayList();
        if(EstadoField!=null){
            try{
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery("SELECT NOME_CIDADE FROM CIDADE WHERE ESTADO_NOME_ESTADO='"
                    + EstadoField+"' AND ESTADO_PAIS_NOME_PAIS='"+PaisField+"'");
                while(rs.next()){        
                    Cidades.add(rs.getString("NOME_CIDADE"));
                }
            }
            catch(Exception e){
            }
        }
        return Cidades;
    }
    
}
