/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author 2022122760117
 */
@Entity
public class Estadia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstadia;
    private Date checkin;
    private Date checkOut;
    private double valortotalSQ;
    private double valorTotalEstadia;
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idQuarto")
    private Quarto quarto;

    @OneToMany(mappedBy = "estadia", fetch = FetchType.EAGER)
    private List<PedidoSQ> pedido;

    public List<PedidoSQ> getPedido() {
        return pedido;
    }

    public void setPedido(List<PedidoSQ> pedido) {
        this.pedido = pedido;
    }

    public Estadia(Date checkin, Date checkOut, double valortotalSQ, double valorTotalEstadia, Cliente cliente, Quarto quarto) {
        this.checkin = checkin;
        this.checkOut = checkOut;
        this.valortotalSQ = valortotalSQ;
        this.valorTotalEstadia = valorTotalEstadia;
        this.cliente = cliente;
        this.quarto = quarto;
    }

    public Estadia(int idEstadia, Date checkin, Date checkOut, double valortotalSQ, double valorTotalEstadia, Cliente cliente, Quarto quarto) {
        this.idEstadia = idEstadia;
        this.checkin = checkin;
        this.checkOut = checkOut;
        this.valortotalSQ = valortotalSQ;
        this.valorTotalEstadia = valorTotalEstadia;
        this.cliente = cliente;
        this.quarto = quarto;
    }

    public Estadia() {
    }

    public int getIdEstadia() {
        return idEstadia;
    }

    public void setIdEstadia(int idEstadia) {
        this.idEstadia = idEstadia;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public double getValortotalSQ() {
        return valortotalSQ;
    }

    public void setValortotalSQ(double valortotalSQ) {
        this.valortotalSQ = valortotalSQ;
    }

    public double getValorTotalEstadia() {
        return valorTotalEstadia;
    }

    public void setValorTotalEstadia(double valorTotalEstadia) {
        this.valorTotalEstadia = valorTotalEstadia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public void calcularValor() {

        valortotalSQ = 0.0;

        if (pedido != null) {

            for (PedidoSQ item : pedido) {
                double preco = item.getValorTotal();
                valortotalSQ += preco;
            }
        } else {
            System.out.println("A lista de pedidos está vazia ou não inicializada.");
        }

        // Exibindo o valor total calculado
        System.out.println("======================valortotal eh " + valortotalSQ);
    }

}
