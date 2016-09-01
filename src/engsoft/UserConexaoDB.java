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
public class UserConexaoDB { 
    
private Connection conexao;   
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
  
            conexao = DriverManager.getConnection(url,usuario,senha); 
            
            
        }
         
            catch(ClassNotFoundException | SQLException e){
                    System.out.println("Erro ao acessar o banco");
        }
        return(conexao);
    }
}
