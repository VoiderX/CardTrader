/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engsoft;

/**
 *
 * @author Gabriel
 */
public class Catalogo {
    private String Usuario;
    private int IdCarta;
    private int QuantCatalogo;
    private float Valor;

     public Catalogo(String Usuario, int IdCarta, int QuantCatalogo, float Valor){
         setUsuario(Usuario);
         setIdCarta(IdCarta);
         setQuantCatalogo(QuantCatalogo);
         setValor(Valor);
     }
    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public int getIdCarta() {
        return IdCarta;
    }

    public void setIdCarta(int IdCarta) {
        this.IdCarta = IdCarta;
    }

    public int getQuantCatalogo() {
        return QuantCatalogo;
    }

    public void setQuantCatalogo(int QuantCatalogo) {
        this.QuantCatalogo = QuantCatalogo;
    }

    public float getValor() {
        return Valor;
    }

    public void setValor(float Valor) {
        this.Valor = Valor;
    }
    
}
