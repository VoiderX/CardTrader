/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import org.postgresql.largeobject.LargeObject;
import org.postgresql.largeobject.LargeObjectManager;

/**
 *
 * @author Gabriel
 */
public class CartaDAO {
    Connection con;  
    
    public CartaDAO(){
        con=ConexaoDB.getCon();
    }
    
    public static Image puxarCarta(int id){
    // All LargeObject API calls must be within a transaction
    Connection con=ConexaoDB.getCon();
    Image im=null;
    try{
    con.setAutoCommit(false);

    // Get the Large Object Manager to perform operations with
    LargeObjectManager lobj = ((org.postgresql.PGConnection)con).getLargeObjectAPI();

    Statement s = con.createStatement();
    ResultSet rs = s.executeQuery("SELECT IMG_CARTA FROM CARTA WHERE ID_CARTA="+id);
        if (rs != null) {
            while(rs.next()){
                long oid=rs.getInt("IMG_CARTA");
                LargeObject obj = lobj.open(oid);
                byte b[]=new byte[obj.size()];
                obj.read(b,0, obj.size());
                ByteArrayInputStream bArray = new ByteArrayInputStream(b);
                BufferedImage imagem = ImageIO.read(bArray);
                im=SwingFXUtils.toFXImage(imagem, null);
                }
            rs.close();
            s.close();
        }
    }catch(SQLException | IOException e){
    }
    return im;
    }
    
    public static ObservableList<Carta> retornaInfoCard(){
       ObservableList<Carta> lista=FXCollections.observableArrayList();
       Connection con=ConexaoDB.getCon();
       Carta c;
      try{
      Statement s=con.createStatement();
      ResultSet rs= s.executeQuery("SELECT ID_CARTA,NOME_CARTA,DESC_CARTA,FABRICANTE.NOME_FABRICANTE FROM CARTA,FABRICANTE"
        +" WHERE FABRICANTE_ID_FABRICANTE=ID_FABRICANTE");
        while(rs.next()){
            c=new Carta(rs.getInt("ID_CARTA"),rs.getString("NOME_CARTA"),rs.getString("DESC_CARTA"),rs.getString("NOME_FABRICANTE"));
            lista.add(c);
        }
        rs.close();
        s.close();
       }
       catch(Exception e){
       }
       return lista;
    }
    
    public static String retornaNomeCard(int IdCarta){
         Connection con=ConexaoDB.getCon();
         String nome="";
        try{
             Statement s=con.createStatement();
             ResultSet rs=s.executeQuery("SELECT NOME_CARTA FROM CARTA WHERE ID_CARTA="+IdCarta);
             while(rs.next()){
             nome=rs.getString("NOME_CARTA");
             }
             rs.close();
             s.close();
        }
        catch(Exception e){
        }
        if(nome.isEmpty()){
            nome="xNull";
        }
        return nome;
    }
    
    public static String retornaDescCard(int IdCarta){
         Connection con=ConexaoDB.getCon();
         String Desc="";
        try{
             Statement s=con.createStatement();
             ResultSet rs=s.executeQuery("SELECT DESC_CARTA FROM CARTA WHERE ID_CARTA="+IdCarta);
             while(rs.next()){
             Desc=rs.getString("DESC_CARTA");
             }
             rs.close();
             s.close();
        }
        catch(Exception e){
        }
        return Desc;
    }
    
    public static ArrayList<Carta> retornaCartas(){
        ArrayList<Carta> list = new ArrayList<>();
        Connection con=ConexaoDB.getCon();
        Carta c;
        try{
            Statement s=con.createStatement();
            ResultSet rs= s.executeQuery("SELECT ID_CARTA,NOME_CARTA,DESC_CARTA,FABRICANTE.NOME_FABRICANTE FROM CARTA,FABRICANTE"
                +" WHERE FABRICANTE_ID_FABRICANTE=ID_FABRICANTE");
            while(rs.next()){
                c=new Carta(rs.getInt("ID_CARTA"),rs.getString("NOME_CARTA"),rs.getString("DESC_CARTA"),rs.getString("NOME_FABRICANTE"));
                list.add(c);
            }
            rs.close();
            s.close();
       }catch(Exception e){
       }
       return(list);
    }
    public static boolean verificaCarta(int idCarta){
        Connection con=ConexaoDB.getCon();
        int cont=0;
        try{
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery("SELECT * FROM CARTA WHERE ID_CARTA="+idCarta);
            while(rs.next()){
                cont++;
            }
            if(cont>0){
                return true;
            }
            rs.close();
            s.close();
        }
        catch(Exception e){
        }
        return false;
    }
}
