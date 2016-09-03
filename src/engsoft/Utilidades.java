/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft;

/**
 *
 * @author noda2
 */
public final class Utilidades {
    public static String firstToUpper(String text){
        text = text.toLowerCase();
        String[] textS = text.split(" ");
        text = "";
        String temp;
        for(int i=0;i<textS.length;i++){
            temp = textS[i];
            for(int j=0;j<temp.length();j++){
                if(j==0){
                    //Precisava pegar a primeira letra apenas
                    temp = temp.toUpperCase();

                }
            }
            text+=temp+" ";
        }
        return(text);
    }
}
