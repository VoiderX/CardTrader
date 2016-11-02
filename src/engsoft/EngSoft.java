/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package engsoft;

import javafx.application.Application;
import javafx.stage.Stage;


/**
*
* @author Gabriel
*/
public class EngSoft extends Application{

   public static void main(String[] args) {
      EngSoft.launch(args);
   }

   @Override
   public void start(Stage primaryStage) throws Exception {
      ControleUI.getInstance().start(primaryStage); //Chama a inicialização da classe de controle
   }

}
