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
public class ConexaoDB {//Classe de conexão primária com o banco de dados, feita em singleton
    
    private static Connection conexao = null;
    private ConexaoDB(){}    
    public static Connection getCon(){
        return((conexao==null)?createCon():conexao);//retorna a conexão
    }
    
    private static Connection createCon(){
            
        try{
            String url = "jdbc:postgresql://localhost:5432/trabsoftw";//Local do banco 
            String usuario = "postgres";  //Usuario
            String senha = "2509";  //Senha
  
            Class.forName("org.postgresql.Driver");//Driver de conexão   
  
            conexao = DriverManager.getConnection(url, usuario, senha); //Realização da conexão 
            
        }
         
            catch(ClassNotFoundException | SQLException e){
                    System.out.println("Erro ao acessar o banco");
        }
        return(conexao);
    }
}
