/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package engsoft;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
*
* @author Gabriel
*/
public final class ControleUI{


   private ControleUI(){};


   UserConexaoDB conexao;
   public void setConexaoUser(engsoft.UserConexaoDB conexao){
      this.conexao=conexao;
   }

   public engsoft.UserConexaoDB getConexaoUser(){
      return conexao;
   }
   int idCartaBuf;

   public int getIdCartaBuf() {
      return idCartaBuf;
   }

   public void setIdCartaBuf(int idCartaBuf) {
      this.idCartaBuf = idCartaBuf;
   }

   Transacao TraBuf;

   public Transacao getTraBuf() {
      return TraBuf;
   }

   public void setTraBuf(Transacao TraBuf) {
      this.TraBuf = TraBuf;
   }


   String UserBuf="";

   public String getUserBuf() {
      return UserBuf;
   }

   public void setUserBuf(String UserBuf) {
      this.UserBuf = UserBuf;
   }
   Catalogo CatalogoBuf;

   public Catalogo getCatalogoBuf() {
      return CatalogoBuf;
   }

   public void setCatalogoBuf(Catalogo CatalogoBuf) {
      this.CatalogoBuf = CatalogoBuf;
   }


   private static ControleUI INSTANCE = null;

   public static ControleUI getInstance(){
      return((INSTANCE == null)?INSTANCE = new ControleUI():INSTANCE);
   }

   public void start(Stage primaryStage) throws Exception {//Chama a parimeira tela
      mainStage = primaryStage;
      initUI();
   }

   private static Parent LoginFXML; //Classes parent para manipulação do Fxml
   private static Parent CadastroFXML;
   private static Parent MenuFXML;
   private static Parent AlteraCadastroFXML;
   private static Parent RecSenhaFXML;
   private static Parent GerenciaColecFXML;
   private static Parent ListaColecFXML;
   private static Parent GerenciaCartaFXML;
   private static Parent ListaCartasFXML;
   private static Parent CardDetalhesFXML;
   private static Parent ProcuraCartasFXML;
   private static Parent HistoricoFXML;
   private static Parent ListaUsuarioFXML;
   private static Parent ComprarCartaFXML;

   private static Scene LoginScene;
   private static Scene CadastroScene;
   private static Scene MenuScene;
   private static Scene AlteraScene;
   private static Scene RecSenhaScene;
   private static Scene GerenciaColecScene;
   private static Scene ListaColecScene;
   private static Scene GerenciaCartaScene;
   private static Scene ListaCartasScene;
   private static Scene CardDetalhesScene;
   private static Scene ProcuraCartasScene;
   private static Scene HistoricoScene;
   private static Scene ListaUsuarioScene;
   private static Scene ComprarCartaScene;

   private static Stage mainStage;
   private static Stage secondStage;

   private static String stagein;

   private void initUI(){ //Metódo inicializador
      mainStage.centerOnScreen();
      mainStage.setTitle("CardTrader 2016");
      secondStage= new Stage();

      try {
         LoginFXML = FXMLLoader.load(getClass().getResource("Fxml/Login/Login.fxml")); //Carrega o arquivo FXML na classe pai
         CadastroFXML=FXMLLoader.load(getClass().getResource("Fxml/Cadastro/Cadastro.fxml"));
         MenuFXML=FXMLLoader.load(getClass().getResource("Fxml/Menu/Menu.fxml"));
         RecSenhaFXML=FXMLLoader.load(getClass().getResource("Fxml/RecuperaSenha/RecuperaSenha.fxml"));

      } catch (IOException ex) {
         //fazer algo para mostrar erro
         System.out.println("Erro" + ex);
      }
      LoginScene = new Scene(LoginFXML); //Transforma a classe parent em um objeto do tipo Scene
      CadastroScene=new Scene(CadastroFXML);
      MenuScene=new Scene(MenuFXML);
      RecSenhaScene=new Scene(RecSenhaFXML);
      mostraLogin();
   }

   public void mostraLogin(){ //Método para chamar o login
      mainStage.setScene(LoginScene);
      mainStage.show();
   }

   public void mostraCadastro(){//Método para chamar a tela de cadastro
      mainStage.setScene(CadastroScene);
      mainStage.show();
   }
   public void mostraMenu(){ //Método para chamar o menu
      mainStage.setScene(MenuScene);
      mainStage.show();
   }
   public void mostraAlterCadastro(){ //Método para chamar a tela de alteração de cadastro
      //Objetos são inicializados nele devido a necessidade de puxar informações sobre a conexão do usúario
      try{
         AlteraCadastroFXML=FXMLLoader.load(getClass().getResource("Fxml/AlteraCadastro/AlteraCadastro.fxml"));
      }catch(Exception e){
         System.out.println(e);
      }
      AlteraScene=new Scene(AlteraCadastroFXML);
      mainStage.setScene(AlteraScene);
      mainStage.show();

   }

   public void chamaRecPass(){
      mainStage.setScene(RecSenhaScene);
      mainStage.show();
   }

   public void chamaGerenciarColec(){
      try{
         GerenciaColecFXML=FXMLLoader.load(getClass().getResource("Fxml/GerenciarColec/GerenciaColec.fxml"));
      }
      catch(Exception e){
         e.printStackTrace();
      }
      GerenciaColecScene=new Scene(GerenciaColecFXML);
      mainStage.setScene(GerenciaColecScene);
      stagein="Gerencia";
      mainStage.show();
   }

   public void chamaListaColec(){
      try{
         ListaColecFXML=FXMLLoader.load(getClass().getResource("Fxml/ListaColec/ListaColec.fxml"));
      }
      catch(Exception e){
      }
      ListaColecScene=new Scene(ListaColecFXML);
      mainStage.setScene(ListaColecScene);
      mainStage.show();
   }

   public void chamaGerenciaCarta(){
      try{
         GerenciaCartaFXML=FXMLLoader.load(getClass().getResource("Fxml/GerenciarCarta/GerenciaCarta.fxml"));
      }
      catch(Exception e){
      }
      GerenciaCartaScene=new Scene(GerenciaCartaFXML);
      secondStage.setScene(GerenciaCartaScene);
      secondStage.setTitle("Gerenciamento de Carta");
      secondStage.show();
   }

   public void ChamaLista(){
      try{
         ListaCartasFXML=FXMLLoader.load(getClass().getResource("Fxml/ListaCartas/ListaCartas.fxml"));
      }
      catch(Exception e){
      }
      ListaCartasScene=new Scene(ListaCartasFXML);
      secondStage.setTitle("Seleção de Carta");
      secondStage.setScene(ListaCartasScene);
      secondStage.show();

   }
   public void saisecondStage(){
      secondStage.close();
   }

   public void ChamaCardDetalhes(){
      try{
         CardDetalhesFXML=FXMLLoader.load(getClass().getResource("Fxml/CardDetalhes/CardDetalhes.fxml"));
      }catch(Exception e){
      }
      CardDetalhesScene=new Scene(CardDetalhesFXML);
      secondStage.setScene(CardDetalhesScene);
      secondStage.setTitle("Detalhes");
      secondStage.show();
   }

   public void chamaProcuraCarta(){
      try{
         ProcuraCartasFXML=FXMLLoader.load(getClass().getResource("Fxml/ProcurarCartas/ProcurarCartas.fxml"));
      }catch(Exception e){
      }
      ProcuraCartasScene=new Scene(ProcuraCartasFXML);
      stagein="Procura";
      mainStage.setScene(ProcuraCartasScene);
   }
   public void chamaHistoricoCompras(){
      try{
         HistoricoFXML=FXMLLoader.load(getClass().getResource("Fxml/HistoricoCompras/HistoricoCompras.fxml"));
      }catch(Exception e){
      }
      stagein="Historico Compras";
      HistoricoScene=new Scene(HistoricoFXML);
      mainStage.setScene(HistoricoScene);
   }
   public void chamaHistoricoVendas(){
      try{
         HistoricoFXML=FXMLLoader.load(getClass().getResource("Fxml/HistoricoVendas/HistoricoVendas.fxml"));
      }catch(Exception e){
      }
      stagein="Historico Vendas";
      HistoricoScene=new Scene(HistoricoFXML);
      mainStage.setScene(HistoricoScene);
   }
   public void chamaListarUsuario(){
      try{
         ListaUsuarioFXML=FXMLLoader.load(getClass().getResource("Fxml/ListaUsuarios/ListaUsuarios.fxml"));
      }catch(Exception e){
      }
      ListaUsuarioScene=new Scene(ListaUsuarioFXML);
      secondStage.setScene(ListaUsuarioScene);
      secondStage.show();
   }
   public void chamaComprarCarta(){
      try{
         ComprarCartaFXML=FXMLLoader.load(getClass().getResource("Fxml/ComprarCarta/ComprarCarta.fxml"));
      }catch(Exception e){
      }
      ComprarCartaScene=new Scene(ComprarCartaFXML);
      secondStage.setScene(ComprarCartaScene);
      secondStage.setTitle("Comprar carta");
      secondStage.show();
   }
   public void arrastarSecondStage(){
      secondStage.toFront();
   }
   public String verificaMainStage(){
      return stagein;
   }
}
