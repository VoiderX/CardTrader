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
    private String NickField;
    private String NomeField;
    private String NumUsuarioField;
    private String EmailField;
    private String EndField;
    private String PaisField;
    private String EstadoField;
    private String CityField;
    private String Mensagem;
   
    public Usuario(String Usuario){
        setUsuario(Usuario);
    }
    public Usuario(){
        
    }
    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getNickField() {
        return NickField;
    }

    public void setNickField(String NickField) {
        this.NickField = NickField;
    }

    public String getNomeField() {
        return NomeField;
    }

    public void setNomeField(String NomeField) {
        this.NomeField = NomeField;
    }

    public String getNumUsuarioField() {
        return NumUsuarioField;
    }

    public void setNumUsuarioField(String NumUsuarioField) {
        this.NumUsuarioField = NumUsuarioField;
    }

    public String getEmailField() {
        return EmailField;
    }

    public void setEmailField(String EmailField) {
        this.EmailField = EmailField;
    }

    public String getEndField() {
        return EndField;
    }

    public void setEndField(String EndField) {
        this.EndField = EndField;
    }

    public String getPaisField() {
        return PaisField;
    }

    public void setPaisField(String PaisField) {
        this.PaisField = PaisField;
    }

    public String getEstadoField() {
        return EstadoField;
    }

    public void setEstadoField(String EstadoField) {
        this.EstadoField = EstadoField;
    }

    public String getCityField() {
        return CityField;
    }

    public void setCityField(String CityField) {
        this.CityField = CityField;
    }

    public String getMensagem() {
        return Mensagem;
    }

    public void setMensagem(String Mensagem) {
        this.Mensagem = Mensagem;
    }
    
    
}
