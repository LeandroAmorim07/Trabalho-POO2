/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Cliente {
    @Id
    @GeneratedValue (strategy =GenerationType.IDENTITY)
    private int idCliente;
    
    @Column(nullable = false)
    private String nomeCliente;
     @Column(nullable = false)
    private int telefoneCliente;
     @Column(nullable = false)
    private String email;
     @Column(nullable = false, unique=true)
    private String cpf;

     
     
     
     
     
     
     
    public Cliente(int idCliente, String nomeCliente, int telefoneCliente, String email, String cpf) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.telefoneCliente = telefoneCliente;
        this.email = email;
        this.cpf = cpf;
    }

    public Cliente() {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(int telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
}
