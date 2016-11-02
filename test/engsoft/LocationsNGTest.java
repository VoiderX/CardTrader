/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft;

import javafx.collections.ObservableList;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Gabriel
 */
public class LocationsNGTest {
    
    public LocationsNGTest() {
    }

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

    /**
     * Teste de método carregaPais, da classe Locations.
     */
    @Test
    public void testCarregaPais() {
        System.out.println("carregaPais");
        ObservableList result = Locations.carregaPais();
    }

    /**
     * Teste de método carregaEstados, da classe Locations.
     */
    @Test
    public void testCarregaEstados() {
        System.out.println("carregaEstados");
        String PaisField = "";
        ObservableList result = Locations.carregaEstados(PaisField);
    }

    /**
     * Teste de método CarregaCidades, da classe Locations.
     */
    @Test
    public void testCarregaCidades() {
        System.out.println("CarregaCidades");
        String EstadoField = "";
        String PaisField = "";
        ObservableList result = Locations.CarregaCidades(EstadoField, PaisField);
    }    
    @Test
    public void testCarregaEstados1() {
        System.out.println("carregaEstados");
        String PaisField = "Brasil";
        ObservableList result = Locations.carregaEstados(PaisField);
    }
    @Test
    public void testCarregaEstados2() {
        System.out.println("carregaEstados");
        String PaisField = null;
        ObservableList result = Locations.carregaEstados(PaisField);
    }
    @Test
    public void testCarregaCidades1() {
        System.out.println("CarregaCidades");
        String EstadoField = "PR";
        String PaisField = "Brasil";
        ObservableList result = Locations.CarregaCidades(EstadoField, PaisField);
    }
    @Test
    public void testCarregaCidades2(){
        Locations loc=new Locations();
        System.out.println("CarregaCidades");
        String EstadoField = null;
        String PaisField = null;
        ObservableList result = Locations.CarregaCidades(EstadoField, PaisField);
    }
}
