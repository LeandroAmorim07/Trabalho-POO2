/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class PedidoSQ {
    @Id
    @GeneratedValue (strategy =GenerationType.IDENTITY)
   private int idPedidoSQ;
   private double valorTotal;
   
   @ManyToOne
   @JoinColumn (name="idEstadia")
   private Estadia estadia;
  @OneToMany ( mappedBy = "chComposta.pedido" , fetch = FetchType.EAGER, cascade = CascadeType.ALL )
    private List<ItemPedido> itemPedidos;

   
   
  
   
   

    public PedidoSQ(int idPedidoSQ, double valorTotal, Estadia estadia, List<ItemPedido> itemPedido) {
        this.idPedidoSQ = idPedidoSQ;
        this.valorTotal = valorTotal;
        this.estadia = estadia;
        this.itemPedidos = itemPedido;
    }

    public PedidoSQ(double valorTotal, Estadia estadia, List<ItemPedido> itemPedidos) {
        this.valorTotal = valorTotal;
        this.estadia = estadia;
        this.itemPedidos = itemPedidos;
    }

    public List<ItemPedido> getItemPedido() {
        return itemPedidos;
    }

    @Override
    public String toString() {
        return "PedidoSQ{" + "itemPedidos=" + itemPedidos + '}';
    }



    
    public double getValorTotal() {
        return valorTotal;
    }

   
   
  

  
  


    public PedidoSQ() {
    }

    public int getIdPedidoSQ() {
        return idPedidoSQ;
    }

    public void setIdPedidoSQ(int idPedidoSQ) {
        this.idPedidoSQ = idPedidoSQ;
    }

 

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Estadia getEstadia() {
        return estadia;
    }

    public void setEstadia(Estadia estadia) {
        this.estadia = estadia;
    }
   
   public double calcularValor() {
        valorTotal = (double) 0.0;
        
        for( ItemPedido item : itemPedidos ) {
            double preco = item.getItem().getValor();
            int qtde = item.getQtd();
            valorTotal = valorTotal + qtde * preco;
            
            item.setPedido(this);
        }
        return valorTotal;
    }
    
}
