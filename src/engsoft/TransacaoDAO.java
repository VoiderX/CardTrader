/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Gabriel
 */
public class TransacaoDAO {
    
    public static ArrayList<Catalogo> buscaCatalogo(){ //Retorna todas cartas a venda
        ArrayList<Catalogo> Catalogos = new ArrayList<>();
        Connection con= engsoft.ControleUI.getInstance().getConexaoUser().retornaCon();
        try{
         Statement s= con.createStatement();
         ResultSet rs= s.executeQuery("SELECT * FROM CATALOGO");
            while(rs.next()){
                 engsoft.Catalogo aux= new Catalogo(rs.getString("USUARIO_CATALOGO"),rs.getInt("CARTA_CATALOGO"),
                 rs.getInt("QUANT_CATALOGO"),rs.getFloat("VALOR_CATALOGO"));
                 Catalogos.add(aux);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return Catalogos;
    }
    
    public static ObservableList<Usuario> retornaUsuarios(){
        ObservableList<Usuario> ListaUsuarios= FXCollections.observableArrayList();
        Usuario aux;
        Connection con= engsoft.ControleUI.getInstance().getConexaoUser().retornaCon();
        try{
         Statement s= con.createStatement();
         ResultSet rs= s.executeQuery("SELECT USUARIO_CATALOGO FROM CATALOGO GROUP BY USUARIO_CATALOGO");
         while(rs.next()){
             aux=new Usuario(rs.getString("USUARIO_CATALOGO"));
             ListaUsuarios.add(aux);
         }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return ListaUsuarios;
    }
}
