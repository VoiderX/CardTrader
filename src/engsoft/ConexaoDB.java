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
public  class ConexaoDB {//Classe de conexão primária com o banco de dados, feita em singleton
    
    private static Connection conexao = null;
    public ConexaoDB(){}    
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
    
    public String realizaCadastro(String NickField,String NomeField,String EndField,String NumField,String EmailField,
    String PaisField,String EstadoField,String CityField,String PassField){
        String Mensagem="";
        conexao=createCon();
        try{
            Statement a=conexao.createStatement();
           ResultSet ver= a.executeQuery("SELECT * FROM USUARIO WHERE NICK_USUARIO='"+NickField+"'");
           while(ver.next()){
              if(ver.getString("NICK_USUARIO").equals(NickField));
              return  "Nome de usuário ou email já  cadastrado!";
           }
        }catch(Exception e){
           return "Um erro ocorreu, tente novamente!";
        }
         try{
                Statement s=conexao.createStatement(); //Inicia o statement
                
                   //Insere os dados na tabela do usuário
                s.executeUpdate("INSERT INTO USUARIO VALUES('"+NickField+"','"+NomeField.toUpperCase()+
                        "','"+EndField.toUpperCase()+"','"+NumField+"','"+
                        EmailField.toUpperCase()+"','"+
                        PaisField+"','"+EstadoField+"','"+CityField+"')");
                        Mensagem=("Usuário Cadastrado com sucesso!");
                
                //Cria um usuário no banco de dados com a senha fornecida pelo usuário   
                s.executeUpdate("CREATE USER "+NickField+" WITH PASSWORD '"+PassField+"'");

                //Cria uma visão da tabela usuario para o usuario com o nome de Userview            
                s.executeUpdate("CREATE VIEW "+NickField+"view AS SELECT * FROM USUARIO"
                                + " WHERE NICK_USUARIO='"+NickField+"'"); 
                s.executeUpdate("CREATE VIEW "+NickField+"catview AS SELECT * FROM CATALOGO"
                                + " WHERE USUARIO_CATALOGO='"+NickField+"'"); 

                   //Fornece permissão de seleção e atualização na sua própria view
                s.executeUpdate("GRANT SELECT,UPDATE ON "+NickField+"view TO "+NickField);
                s.executeUpdate("GRANT SELECT,INSERT,UPDATE,DELETE ON "+NickField+"catview TO "+NickField);
                s.close();//Encerra o statement(declaração);         

            }catch(Exception e){//Caso haja uma falha de conexão
                int j=0;
                do{
                try{
                Statement s=conexao.createStatement();
                s.executeUpdate("DELETE FROM USUARIO WHERE NICK_USUARIO='"+NickField+"'");
                s.executeUpdate("DROP VIEW IF EXISTS "+NickField+"view");
                s.executeUpdate("DROP VIEW IF EXISTS "+NickField+"catview");
                s.executeUpdate("DROP USER IF EXISTS "+NickField);
                System.out.println(e);
                Mensagem="Erro de conexão, tente novamente";
                j++;
                }
                catch(Exception a){
                    System.out.println(a);
                    j++;
                    }
                }while(j<20);
            }
         return Mensagem;    
    }
    
    public String altSenha(String NickField,String PassField){
        String Mensagem;
         try{
                Statement s=engsoft.ConexaoDB.getCon().createStatement();
                //Validar a senha digitada pelo usuário
                s.executeUpdate("ALTER USER "+NickField+ " WITH PASSWORD '"+PassField+"'");
                Mensagem=("Alteração executada com sucesso!");
            }catch(Exception e){
                System.out.println(e);
                Mensagem=("Usuário não encontrado!");
            }
            return Mensagem;
    } 
  
}
