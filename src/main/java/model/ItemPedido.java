/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 *
 * @author 2022122760117
 */

@Entity
public class ItemPedido {
    @Id
    private int idItemPedido;
    private int qtdHamb;
    private int qtdXburguer;
    private int qtdOreo;
    private int qtdRuffles;
    private int qtdCoca;
    private int qtdPepsi;
    private int qtdDelValle;
    private int qtdChampanhe;
    
    @ManyToOne
    @JoinColumn(name="idPedidoSQ")
    private PedidoSQ pedidosq;
    
    @ManyToOne
    @JoinColumn(name="idItem")
    private Item item;

    
    
    public PedidoSQ getPedidosq() {
        return pedidosq;
    }

    public Item getItem() {
        return item;
    }

    public ItemPedido(int idPedido, int qtdHamb, int qtdXburguer, int qtdOreo, int qtdRuffles, int qtdCoca, int qtdPepsi, int qtdDelValle, int qtdChampanhe, PedidoSQ pedidosq, Item item) {
        this.idItemPedido = idPedido;
        this.qtdHamb = qtdHamb;
        this.qtdXburguer = qtdXburguer;
        this.qtdOreo = qtdOreo;
        this.qtdRuffles = qtdRuffles;
        this.qtdCoca = qtdCoca;
        this.qtdPepsi = qtdPepsi;
        this.qtdDelValle = qtdDelValle;
        this.qtdChampanhe = qtdChampanhe;
        this.pedidosq = pedidosq;
        this.item = item;
    }

    

    public ItemPedido() {
    }

    public int getIdPedido() {
        return idItemPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idItemPedido = idPedido;
    }

    public int getQtdHamb() {
        return qtdHamb;
    }

    public void setQtdHamb(int qtdHamb) {
        this.qtdHamb = qtdHamb;
    }

    public int getQtdXburguer() {
        return qtdXburguer;
    }

    public void setQtdXburguer(int qtdXburguer) {
        this.qtdXburguer = qtdXburguer;
    }

    public int getQtdOreo() {
        return qtdOreo;
    }

    public void setQtdOreo(int qtdOreo) {
        this.qtdOreo = qtdOreo;
    }

    public int getQtdRuffles() {
        return qtdRuffles;
    }

    public void setQtdRuffles(int qtdRuffles) {
        this.qtdRuffles = qtdRuffles;
    }

    public int getQtdCoca() {
        return qtdCoca;
    }

    public void setQtdCoca(int qtdCoca) {
        this.qtdCoca = qtdCoca;
    }

    public int getQtdPepsi() {
        return qtdPepsi;
    }

    public void setQtdPepsi(int qtdPepsi) {
        this.qtdPepsi = qtdPepsi;
    }

    public int getQtdDelValle() {
        return qtdDelValle;
    }

    public void setQtdDelValle(int qtdDelValle) {
        this.qtdDelValle = qtdDelValle;
    }

    public int getQtdChampanhe() {
        return qtdChampanhe;
    }

    public void setQtdChampanhe(int qtdChampanhe) {
        this.qtdChampanhe = qtdChampanhe;
    }
    

    
}
