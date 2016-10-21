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
     public static ArrayList<Catalogo> buscaCatalogo(String Usuario){ //Retorna todas cartas a venda de um usuario
        ArrayList<Catalogo> Catalogos = new ArrayList<>();
        Connection con= engsoft.ControleUI.getInstance().getConexaoUser().retornaCon();
        try{
         Statement s= con.createStatement();
         ResultSet rs= s.executeQuery("SELECT * FROM CATALOGO WHERE USUARIO_CATALOGO='"+Usuario+"'");
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
          public static ArrayList<Catalogo> buscaCatalogo(int IdCarta){ //Retorna todas as cartas a venda com este ID
        ArrayList<Catalogo> Catalogos = new ArrayList<>();
        Connection con= engsoft.ControleUI.getInstance().getConexaoUser().retornaCon();
        try{
         Statement s= con.createStatement();
         ResultSet rs= s.executeQuery("SELECT * FROM CATALOGO WHERE CARTA_CATALOGO="+IdCarta);
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
     public static ArrayList<Catalogo> buscaCatalogo(String Usuario,int IdCarta){ //Retorna a carta a venda de um usuário
        ArrayList<Catalogo> Catalogos = new ArrayList<>();
        Connection con= engsoft.ControleUI.getInstance().getConexaoUser().retornaCon();
        try{
         Statement s= con.createStatement();
         ResultSet rs= s.executeQuery("SELECT * FROM CATALOGO WHERE USUARIO_CATALOGO='"+Usuario+"'"
                 + " AND CARTA_CATALOGO="+IdCarta);
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
    public static boolean verificaUsuarios(String User){
         Connection con= engsoft.ControleUI.getInstance().getConexaoUser().retornaCon();
         int cont=0;
        try{
         Statement s= con.createStatement();
         ResultSet rs= s.executeQuery("SELECT USUARIO_CATALOGO FROM CATALOGO WHERE USUARIO_CATALOGO='"+User+"'");
         while(rs.next()){
             cont++;
         }
         if(cont>0){
             return true;
         }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static String comprarCarta(String NickVendedor, String NickComprador,int CartaId,int Quantidade,float Valor){
        String Mensagem="";
        Connection conn=engsoft.ControleUI.getInstance().getConexaoUser().retornaCon();
        int QuantResult=0;
        float ValorResult=0;
        try{
            Statement s= conn.createStatement();
            ResultSet rs=s.executeQuery("SELECT QUANT_CATALOGO,VALOR_CATALOGO FROM CATALOGO WHERE "
                    + "USUARIO_CATALOGO='"+NickVendedor+"' AND  CARTA_CATALOGO="+CartaId);
            while(rs.next()){
                QuantResult=rs.getInt("QUANT_CATALOGO");
                ValorResult=rs.getFloat("VALOR_CATALOGO");
                
            }
                if(NickVendedor.equals(NickComprador)){
                    return "Você não pode comprar de você mesmo!";
                }
                if(Quantidade>QuantResult || (Valor/Quantidade)!=ValorResult){
                    return "Valor ou Quantidade Inválidos!";
                }                
            s.executeUpdate("UPDATE CATALOGO SET QUANT_CATALOGO="+(QuantResult-Quantidade)+" WHERE USUARIO_CATALOGO='"
                     +NickVendedor+"' AND CARTA_CATALOGO="+CartaId);
            if(QuantResult-Quantidade==0){
                s.executeUpdate("DELETE FROM CATALOGO WHERE USUARIO_CATALOGO='"
                    +NickVendedor+"' AND CARTA_CATALOGO="+CartaId);
            }
            s.executeUpdate("INSERT INTO TRANSACAO VALUES('"+NickVendedor+"','"+NickComprador+"','"
                   +"AGUARD PAG',"+CartaId+","+Quantidade+","+Valor+")");
            return "Transação efetuada com sucesso!";
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return "Erro ao realizar transação!";
    }
    public static ObservableList<Transacao> retornaCompras(){
        Connection conn= engsoft.ControleUI.getInstance().getConexaoUser().retornaCon();
        ObservableList<Transacao> Compras=FXCollections.observableArrayList();
        try{
            Statement s=conn.createStatement();
            ResultSet rs=s.executeQuery("SELECT * FROM "+engsoft.ControleUI.getInstance().getConexaoUser().getUsuario()
                    +"comprasview");
            while(rs.next()){
                engsoft.Transacao aux= new Transacao(rs.getString("USUARIO_NICK_VENDEDOR"),
                rs.getString("USUARIO_NICK_COMPRADOR"),rs.getString("STATUS_TRANSACAO"),
                rs.getInt("CARTA_ID_CARTA"),rs.getInt("QUANTIDADE_TRANSACAO"),rs.getFloat("VALORCARTA_TRANSACAO"));
                Compras.add(aux);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return Compras;
    }
    
    public static ObservableList<Transacao> retornaVendas(){
        Connection conn= engsoft.ControleUI.getInstance().getConexaoUser().retornaCon();
        ObservableList<Transacao> Vendas=FXCollections.observableArrayList();
        try{
            Statement s=conn.createStatement();
            ResultSet rs=s.executeQuery("SELECT * FROM "+engsoft.ControleUI.getInstance().getConexaoUser().getUsuario()
                    +"vendasview");
            while(rs.next()){
                engsoft.Transacao aux= new Transacao(rs.getString("USUARIO_NICK_VENDEDOR"),
                rs.getString("USUARIO_NICK_COMPRADOR"),rs.getString("STATUS_TRANSACAO"),
                rs.getInt("CARTA_ID_CARTA"),rs.getInt("QUANTIDADE_TRANSACAO"),rs.getFloat("VALORCARTA_TRANSACAO"));
                Vendas.add(aux);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return Vendas;       
    }
    public static String marcarPago(String Vendedor, String Comprador,int IdCarta,float Valor){
        Connection conn=engsoft.ControleUI.getInstance().getConexaoUser().retornaCon();
        try{
            Statement s= conn.createStatement();
            s.executeUpdate("UPDATE TRANSACAO SET STATUS_TRANSACAO='PAGO' WHERE USUARIO_NICK_VENDEDOR='"+Vendedor+"'"
            +" AND USUARIO_NICK_COMPRADOR='"+Comprador+"' AND CARTA_ID_CARTA="+IdCarta+" AND VALORCARTA_TRANSACAO="+Valor);
            return "Alteração Efetuada com Sucesso!";
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return "Erro ao alterar";
    }
    public static String marcarRecebido(String Vendedor, String Comprador,int IdCarta,float Valor){
                Connection conn=engsoft.ControleUI.getInstance().getConexaoUser().retornaCon();
        try{
            Statement s= conn.createStatement();
            s.executeUpdate("UPDATE TRANSACAO SET STATUS_TRANSACAO='RECEBIDO' WHERE USUARIO_NICK_VENDEDOR='"+Vendedor+"'"
            +" AND USUARIO_NICK_COMPRADOR='"+Comprador+"' AND CARTA_ID_CARTA="+IdCarta+" AND VALORCARTA_TRANSACAO="+Valor);
            return "Alteração Efetuada com Sucesso!";
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return "Erro ao alterar";
    }
}
