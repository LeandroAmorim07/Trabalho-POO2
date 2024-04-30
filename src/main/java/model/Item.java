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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;


/**
 *
 * @author 2022122760117
 */
@Entity
public class Item {
    @Id
    @GeneratedValue (strategy =GenerationType.IDENTITY)
    private int idItem;
    @Column(nullable = false)
    private double valor;
  

    public Item(int idItem, double valor) {
        this.idItem = idItem;
        this.valor = valor;
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
