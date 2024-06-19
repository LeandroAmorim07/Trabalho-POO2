/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;



import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


/**
 *
 * @author 2022122760117
 */

@Entity
public class ItemPedido {
   
    
    @EmbeddedId
    private ItemPedidoPK chComposta;

   
    private int qtd;
 

    
     public ItemPedido(Item item, PedidoSQ pedidosq, int qtd) {
        this.qtd = qtd;
        this.chComposta = new ItemPedidoPK(pedidosq, item);
        
    }
    public ItemPedidoPK getChComposta() {
        return chComposta;
    }

    public ItemPedido() {
    }

    public void setChComposta(ItemPedidoPK chComposta) {
        this.chComposta = chComposta;
    }

  

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    
}


   
    
    

    

