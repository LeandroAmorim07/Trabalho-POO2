/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class PedidoSQ {
    @Id
   private int idPedidoSQ;
   private double valorTotal;
   @ManyToOne
   @JoinColumn (name="idEstadia")
   private Estadia estadia;
   @OneToMany
   @JoinColumn(name="idItemPedido")
   private  List <ItemPedido> itemPedido;

    public PedidoSQ(int idPedidoSQ, int valorTotal, Estadia estadia, List<ItemPedido> itemPedido) {
        this.idPedidoSQ = idPedidoSQ;
        this.valorTotal = valorTotal;
        this.estadia = estadia;
        this.itemPedido = itemPedido;
    }

    public List<ItemPedido> getItemPedido() {
        return itemPedido;
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
   
   
    
}
