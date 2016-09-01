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
 * @author noda2
 */
public class CreateUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ControleUI.getInstance().start(primaryStage);
                
    }
    
}
