/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 2022122760117
 */
public class PedidoSQ {
   private int idPedidoSQ;
   private int valorTotal;
   private Estadia estadia;

    public PedidoSQ(int idPedidoSQ, int valorTotal, Estadia estadia) {
        this.idPedidoSQ = idPedidoSQ;
        this.valorTotal = valorTotal;
        this.estadia = estadia;
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
