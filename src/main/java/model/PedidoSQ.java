/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 *
 * @author 2022122760117
 */
@Entity
public class PedidoSQ {
    @Id
   private int idPedidoSQ;
   private int valorTotal;
   @Transient
   private Estadia estadia;
   @ManyToOne
   @JoinColumn(name="idItemPedido")
   private ItemPedido itemPedido;

    public PedidoSQ(int idPedidoSQ, int valorTotal, Estadia estadia, ItemPedido itemPedido) {
        this.idPedidoSQ = idPedidoSQ;
        this.valorTotal = valorTotal;
        this.estadia = estadia;
        this.itemPedido = itemPedido;
    }

    public ItemPedido getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(ItemPedido itemPedido) {
        this.itemPedido = itemPedido;
    }
   


    public PedidoSQ() {
    }

    public int getIdPedidoSQ() {
        return idPedidoSQ;
    }

    public void setIdPedidoSQ(int idPedidoSQ) {
        this.idPedidoSQ = idPedidoSQ;
    }

    public int getValorTotal() {
        return valorTotal;
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
