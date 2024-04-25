/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;


/**
 *
 * @author 2022122760117
 */
public class Item {
    private int idItem;
    private double valor;
    private List<ItemPedido> itensPedido;

    public Item(int idItem, double valor, List<ItemPedido> itensPedido) {
        this.idItem = idItem;
        this.valor = valor;
        this.itensPedido = itensPedido;
    }

   

    public Item() {
    }

    
    
    
}
