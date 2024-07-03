/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



/**
 *
 * @author 2022122760117
 */
@Entity
public class Item {
    @Id
    @GeneratedValue (strategy =GenerationType.IDENTITY)
    private int idItem;
   @Column(nullable = false, length = 40)
   private String NomeItem;
   
    @Column(nullable = false)
    private double valor;
    
    
    @OneToMany ( mappedBy = "chComposta.item" , fetch = FetchType.EAGER )
    private List<ItemPedido> itens;

    public Item(int idItem, String NomeItem, double valor) {
        this.idItem = idItem;
        this.NomeItem = NomeItem;
        this.valor = valor;
    }

    public Item(String NomeItem, double valor) {
        this.NomeItem = NomeItem;
        this.valor = valor;
    }

    public String getNomeItem() {
        return NomeItem;
    }

    public void setNomeItem(String NomeItem) {
        this.NomeItem = NomeItem;
    }

    @Override
    public String toString() {
        return NomeItem ;
    }
  
    

  
    

  
  

   

   

 

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    

   

   

    public Item() {
    }

    
    
    
}
