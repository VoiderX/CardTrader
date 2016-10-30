/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author André Costa Lopes
 */
public class CartaDAOTest {
    
    public CartaDAOTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
    
    //teste vai retornar a string BLASTOISE
    @Test
    public void retornaNomeTest(){
    
        assertEquals("Blastoise",CartaDAO.retornaNomeCard(2));
      
    }
    
    //teste vai ser diferente, pois o nome esta errado
    @Test
    public void retornaNomeTest2(){
    
        assertNotEquals("Blaziken",CartaDAO.retornaNomeCard(2));
      
    }
    
    //carta inexistente
    @Test
    public void retornaNomeTeste3(){
    
        assertNotEquals("",CartaDAO.retornaNomeCard(11));
      
    }
   
    
    //teste vai retornar a descricao de BLASTOISE
    @Test
    public void retornaDescCard1(){
        
        assertEquals("A brutal Pokémon with pressurized water jets on its shell. They are used for high-speed tackles.",CartaDAO.retornaDescCard(2));
        
    }
    
    //Testado com 10 cartas
    @Test
    public void retornaCartasTest1(){

        ArrayList<Carta> list = new ArrayList<Carta>();
        
        list = CartaDAO.retornaCartas();
            
        for(int i=0;i<list.size();i++){
            
        if(i==0){
            assertEquals("Mewtwo",list.get(i).getNome());
        }
        else if(i==1){
             assertEquals("Magneton",list.get(i).getNome());
        }
        else if(i==2){
             assertEquals("Machamp",list.get(i).getNome());
        }
        else if(i==3){
             assertEquals("Hitmonchan",list.get(i).getNome());
        }
        else if(i==4){
             assertEquals("Gyarados",list.get(i).getNome());
        }
        else if(i==5){
             assertEquals("Clefairy",list.get(i).getNome());
        }
        else if(i==6){
             assertEquals("Charizard",list.get(i).getNome());
        }
        else if(i==7){
             assertEquals("Chansey",list.get(i).getNome());
        }
        else if(i==8){
             assertEquals("Blastoise",list.get(i).getNome());
        }
        else if(i==9){
             assertEquals("Alakazam",list.get(i).getNome());
        }
        }
    }    
    
    //Verifica existencia de 10 cartas e 1 falsa
    @Test
    public void verificaCartaTest(){
    
        assertTrue(CartaDAO.verificaCarta(1));
        assertTrue(CartaDAO.verificaCarta(2));
        assertTrue(CartaDAO.verificaCarta(3));
        assertTrue(CartaDAO.verificaCarta(4));
        assertTrue(CartaDAO.verificaCarta(5));
        assertTrue(CartaDAO.verificaCarta(6));
        assertTrue(CartaDAO.verificaCarta(7));
        assertTrue(CartaDAO.verificaCarta(8));
        assertTrue(CartaDAO.verificaCarta(9));
        assertTrue(CartaDAO.verificaCarta(10));
        
        assertFalse(CartaDAO.verificaCarta(11));
    
    }

    @Test
    public void retornaInfoCardTest(){
    
    ObservableList<Carta> lista=FXCollections.observableArrayList();
    
    lista = CartaDAO.retornaInfoCard();
    
    assertEquals("A scientist created this Pokémon after years of horrific gene-splicing and DNA engineering experiments.",lista.get(0).getDesc());
    assertEquals("Formed by several Magnemites linked together. It frequently appears when sunspots flare up.",lista.get(1).getDesc());
    assertEquals("Using its amazing muscles, it throws powerful punches that can knock its victim clear over the horizon.",lista.get(2).getDesc());
    assertEquals("While seeming to do nothing, it fires punches in lightning-fast volleys that are impossible to see.",lista.get(3).getDesc());
    assertEquals("Rarely seen in the wild. Huge and vicious, it is capable of destroying entire cities in a rage.",lista.get(4).getDesc());
    assertEquals("Its magical and cute appeal has many admirers. It is rare and found only in certain areas.",lista.get(5).getDesc());
    assertEquals("Spits fire that is hot enough to melt boulders. Known to unintentionally cause forest fires.",lista.get(6).getDesc());
    assertEquals("A rare and elusive Pokémon that is said to bring happiness to those who manage to catch it.",lista.get(7).getDesc());
    assertEquals("A brutal Pokémon with pressurized water jets on its shell. They are used for high-speed tackles.",lista.get(8).getDesc());
    assertEquals("Its brain can outperform a supercomputer. Its intelligence quotient is said to be 5000.",lista.get(9).getDesc());
        
    }
    
}
