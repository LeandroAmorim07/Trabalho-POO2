/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Cliente {
    @Id
    @GeneratedValue (strategy =GenerationType.IDENTITY)
    private int idCliente;
    
    @Column(nullable = false, length = 40)
    private String nomeCliente;
     @Column(nullable = false)
    private int telefoneCliente;
     @Column(nullable = false, length = 60)
    private String email;
     @Column(nullable = false, unique=true, length=60)
    private String cpf;
     @OneToMany
     @JoinColumn (name="idEstadia")
    private List<Estadia> estadia;
//com id
    public Cliente(int idCliente, String nomeCliente, int telefoneCliente, String email, String cpf, List<Estadia> estadia) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.telefoneCliente = telefoneCliente;
        this.email = email;
        this.cpf = cpf;
        this.estadia = estadia;
    }
//sem id
    public Cliente(String nomeCliente, int telefoneCliente, String email, String cpf, List<Estadia> estadia) {
        this.nomeCliente = nomeCliente;
        this.telefoneCliente = telefoneCliente;
        this.email = email;
        this.cpf = cpf;
        this.estadia = estadia;
    }

    public List<Estadia> getEstadia() {
        return estadia;
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
