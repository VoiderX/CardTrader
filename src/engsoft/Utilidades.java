/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package engsoft;

import javafx.scene.control.TextField;

/**
*
* @author noda2
*/
public final class Utilidades {
   public static String firstToUpper(String AnyField){
      char NomeFieldChar[];

      NomeFieldChar=AnyField.toCharArray();
      NomeFieldChar[0]=Character.toUpperCase(NomeFieldChar[0]);

      for(int i=0;i<NomeFieldChar.length-1;i++){
         if(String.valueOf(NomeFieldChar[i]).equals(" ")){
            NomeFieldChar[i+1]=Character.toUpperCase(NomeFieldChar[i+1]);
         }
      }
      return String.valueOf(NomeFieldChar);
   }

   public static void telSplit(String NumField,TextField DDDField,TextField CodCddField,TextField NumUsuarioField){
      if(NumField.length()==10){
         DDDField.setText(NumField.substring(0,2));
         CodCddField.setText(NumField.substring(2,6));
         NumUsuarioField.setText(NumField.substring(6,10));
      }
      if(NumField.length()==11){ //Trata a exibição do telefone de acordo com os casos possíveis na validação
         if(NumField.subSequence(0,1).equals("0")){
            DDDField.setText(NumField.substring(0,3));
            CodCddField.setText(NumField.substring(3,7));
            NumUsuarioField.setText(NumField.substring(7,11));
         }else{
            DDDField.setText(NumField.substring(0,2));
            CodCddField.setText(NumField.substring(2,7));
            NumUsuarioField.setText(NumField.substring(7,11));
         }
      }
      if(NumField.length()==12){
         DDDField.setText(NumField.substring(0,3));
         CodCddField.setText(NumField.substring(3,8));
         NumUsuarioField.setText(NumField.substring(8,12));
      }
   }
}
