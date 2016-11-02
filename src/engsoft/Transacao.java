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
public class Transacao {
   private String Vendedor;
   private String Comprador;
   private String Status;
   private int IdCarta;
   private int Quantidade;
   private float Valor;

   public Transacao(String Vendedor,String Comprador,String Status, int IdCarta,int Quantidade,Float Valor){
      setVendedor(Vendedor);
      setComprador(Comprador);
      setStatus(Status);
      setIdCarta(IdCarta);
      setQuantidade(Quantidade);
      setValor(Valor);
   }
   public String getVendedor() {
      return Vendedor;
   }

   public void setVendedor(String Vendedor) {
      this.Vendedor = Vendedor;
   }

   public String getComprador() {
      return Comprador;
   }

   public void setComprador(String Comprador) {
      this.Comprador = Comprador;
   }

   public String getStatus() {
      return Status;
   }

   public void setStatus(String Status) {
      this.Status = Status;
   }

   public int getIdCarta() {
      return IdCarta;
   }

   public void setIdCarta(int IdCarta) {
      this.IdCarta = IdCarta;
   }

   public int getQuantidade() {
      return Quantidade;
   }

   public void setQuantidade(int Quantidade) {
      this.Quantidade = Quantidade;
   }

   public float getValor() {
      return Valor;
   }

   public void setValor(float Valor) {
      this.Valor = Valor;
   }

}
