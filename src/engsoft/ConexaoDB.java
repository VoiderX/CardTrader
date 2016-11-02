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
      if(conexao!=null){
         try{
            conexao.close();
         }
         catch(Exception e){
         }
      }
      createCon();
      return conexao;//retorna a conexão
   }

   private static void rollBackBanco(String NickField)throws SQLException{
      Statement s=conexao.createStatement();
      s.executeUpdate("DELETE FROM USUARIO WHERE NICK_USUARIO='"+NickField+"'");
      s.executeUpdate("DROP VIEW IF EXISTS "+NickField+"view");
      s.executeUpdate("DROP VIEW IF EXISTS "+NickField+"catview");
      s.executeUpdate("DROP VIEW IF EXISTS "+NickField+"vendasview");
      s.executeUpdate("DROP VIEW IF EXISTS "+NickField+"comprasview");
      s.executeUpdate("REVOKE ALL PRIVILEGES ON TRANSACAO FROM "+NickField);
      s.executeUpdate("REVOKE ALL PRIVILEGES ON CATALOGO FROM "+NickField);
      s.executeUpdate("DROP USER IF EXISTS "+NickField);
      s.close();
   }
   private static void criaViews(String NickField)throws SQLException{
      Statement s=conexao.createStatement();
      //Cria uma visão da tabela usuario para o usuario com o nome de Userview
      s.executeUpdate("CREATE VIEW "+NickField+"view AS SELECT * FROM USUARIO"
      + " WHERE NICK_USUARIO='"+NickField+"'");
      s.executeUpdate("CREATE VIEW "+NickField+"catview AS SELECT * FROM CATALOGO"
      + " WHERE USUARIO_CATALOGO='"+NickField+"'");
      s.executeUpdate("CREATE VIEW "+NickField+"vendasview AS SELECT * FROM TRANSACAO"
      + " WHERE USUARIO_NICK_VENDEDOR='"+NickField+"'");
      s.executeUpdate("CREATE VIEW "+NickField+"comprasview AS SELECT * FROM TRANSACAO"
      + " WHERE USUARIO_NICK_COMPRADOR='"+NickField+"'");
      s.close();
   }
   private static void concedePermisoes(String NickField)throws SQLException{
      Statement s=conexao.createStatement();
      //Fornece permissão de seleção e atualização na sua própria view
      s.executeUpdate("GRANT SELECT,UPDATE ON "+NickField+"view TO "+NickField);
      s.executeUpdate("GRANT SELECT,INSERT,UPDATE,DELETE ON "+NickField+"catview TO "+NickField);
      s.executeUpdate("GRANT SELECT,INSERT,UPDATE,DELETE ON "+NickField+"vendasview TO "+NickField);
      s.executeUpdate("GRANT SELECT,INSERT,UPDATE,DELETE ON "+NickField+"comprasview TO "+NickField);
      s.executeUpdate("GRANT SELECT,INSERT,UPDATE ON TRANSACAO TO "+NickField);
      s.executeUpdate("GRANT SELECT,UPDATE,DELETE ON CATALOGO TO "+NickField);
      s.close();
   }

   private static void insereUsuario(String NickField,String NomeField,String EndField,String NumField,String EmailField,
   String PaisField,String EstadoField,String CityField)throws SQLException{
      Statement s=conexao.createStatement();
      //Insere os dados na tabela do usuário
      s.executeUpdate("INSERT INTO USUARIO VALUES('"+NickField+"','"+NomeField.toUpperCase()+
      "','"+EndField.toUpperCase()+"','"+NumField+"','"+
      EmailField.toUpperCase()+"','"+
      PaisField+"','"+EstadoField+"','"+CityField+"')");
      s.close();
   }
   private static void criaUsuario(String NickField, String PassField)throws SQLException{
      Statement s=conexao.createStatement();
      //Cria um usuário no banco de dados com a senha fornecida pelo usuário
      s.executeUpdate("CREATE USER "+NickField+" WITH PASSWORD '"+PassField+"'");
      s.close();
   }

   private static boolean checkUser(String NickField)throws SQLException{
      Statement a=conexao.createStatement();
      ResultSet ver= a.executeQuery("SELECT * FROM USUARIO WHERE NICK_USUARIO='"+NickField+"'");
      if(ver.next()){
         ver.close();
         a.close();
         return true;
      }
      ver.close();
      a.close();
      return false;
   }
   private static boolean checkEmail(String EmailField)throws SQLException{
      Statement b=conexao.createStatement();
      ResultSet ver2=b.executeQuery("SELECT * FROM USUARIO WHERE EMAIL_USUARIO='"+EmailField.toUpperCase()+"'");
      if(ver2.next()){
         ver2.close();
         b.close();
         return true;
      }
      ver2.close();
      b.close();
      return false;
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
      }
      return(conexao);
   }


   public String realizaCadastro(String NickField,String NomeField,String EndField,String NumField,String EmailField,
   String PaisField,String EstadoField,String CityField,String PassField){
      String Mensagem="";
      try{
         if(checkUser(NickField)){
            return  "Nome de usuário já  cadastrado!";
         }
         if(checkEmail(EmailField)){
            return  "Email já  cadastrado!";
         }
      }catch(Exception e){
         return "Um erro ocorreu, tente novamente!";
      }
      try{
         insereUsuario(NickField, NomeField, EndField, NumField, EmailField, PaisField, EstadoField, CityField);
         criaUsuario(NickField, PassField);
         criaViews(NickField);
         concedePermisoes(NickField);
         Mensagem=("Usuário Cadastrado com sucesso!");
      }catch(Exception e){
         int j=0;
         do{
            try{
               rollBackBanco(NickField);
               Mensagem="Erro de conexão, tente novamente";
               j++;
            }
            catch(Exception a){
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
         s.close();
      }catch(Exception e){
         System.out.println(e);
         Mensagem=("Usuário não encontrado!");
      }
      return Mensagem;
   }

}
