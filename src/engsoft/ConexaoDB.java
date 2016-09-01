/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft;

import java.sql.*;

/**
 *
 * @author Gabriel
 */
public class ConexaoDB {
    
    private static Connection conexao = null;
    private ConexaoDB(){}    
    public static Connection getCon(){
        return((conexao==null)?createCon():conexao);
    }
    
    private static Connection createCon(){
            
        try{
            String url = "jdbc:postgresql://localhost:5432/trabsoftw";  
            String usuario = "postgres";  
            String senha = "0000";  
  
            Class.forName("org.postgresql.Driver");  
  
            conexao = DriverManager.getConnection(url, usuario, senha); 
            
        }
         
            catch(ClassNotFoundException | SQLException e){
                    System.out.println("Erro ao acessar o banco");
        }
        return(conexao);
    }
}
