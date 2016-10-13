/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft;

import javafx.scene.image.Image;

/**
 *
 * @author Gabriel
 */
public class Carta {
    private Integer ID;
    private String Nome;
    private String Fabricante;
    private String desc;
    private int quant;
    private float valor;
    private Image img;
    
    public Carta(Integer ID,String Nome,String Desc,String Fabricante){
        setID(ID);
        setNome(Nome);
        setFabricante(Fabricante);
        setDesc(Desc);
    }

    public Carta(Integer ID, int quant, float valor) {
        this.ID = ID;
        this.quant = quant;
        this.valor = valor;
        CartaDAO obj = new CartaDAO();
        this.img = obj.puxarCarta(ID);
    }

    public int getQuant() {
        return quant;
    }

    public float getValor() {
        return valor;
    }

    public Image getImg() {
        return img;
    }
    
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getFabricante() {
        return Fabricante;
    }

    public void setFabricante(String Fabricante) {
        this.Fabricante = Fabricante;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    
    
}
