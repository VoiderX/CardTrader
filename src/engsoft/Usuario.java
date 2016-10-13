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
public class Usuario {
    private String Usuario;
   
    public Usuario(String Usuario){
        setUsuario(Usuario);
    }
    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }
}
