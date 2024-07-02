package model;


import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Embeddable
public class ItemPedidoPK implements Serializable {
    
    @ManyToOne
    @JoinColumn ( name = "idPedidoSQ" )
    private PedidoSQ pedido;
    
    @ManyToOne
    @JoinColumn ( name = "idItem" )
    private Item item;  

    public ItemPedidoPK() {
    }

    public ItemPedidoPK(PedidoSQ pedido, Item item) {
        this.pedido = pedido;
        this.item = item;
    }

    public PedidoSQ getPedido() {
        return pedido;
    }

    public void setPedido(PedidoSQ pedido) {
        this.pedido = pedido;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    
    
}