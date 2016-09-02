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
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;

/**
 *
 * @author Gabriel
 */
public class Locations {
        Connection con;
        ObservableList ConjVazio=FXCollections.observableArrayList();
    public Locations(){
        con=ConexaoDB.getCon();
    }
    
     public void limpaCampos(ChoiceBox EstadoField, ChoiceBox CityField){
        //Função para  limpar os campos
        EstadoField.setValue(ConjVazio); //Limpa o valor atual
        CityField.setValue(ConjVazio);
        EstadoField.setItems(ConjVazio);//Limpa o vetor de items
        CityField.setItems(ConjVazio);        
        }
    
    public void carregaPais(ChoiceBox PaisField, Text Mensagem){
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
    
    public void carregaEstados(ChoiceBox PaisField,ChoiceBox EstadoField,ChoiceBox CityField, Text Mensagem){
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
            limpaCampos(EstadoField,CityField);
            Mensagem.setText("Selecione um país!");
        }
    }
    
    @FXML
    public void carregaCidades(ChoiceBox PaisField,ChoiceBox EstadoField,ChoiceBox CityField,Text Mensagem){//Idem ao carregaEstados
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
            limpaCampos(EstadoField,CityField);
            Mensagem.setText("Selecione um estado!");
        }
    }
    
}
