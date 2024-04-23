/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 2022122760117
 */
public class Quarto {
    private int numQuarto;
    private String tipoQuarto;
    private String cama;
    private double valorDiaria;

    public Quarto(int numQuarto, String tipoQuarto, String cama, double valorDiaria) {
        this.numQuarto = numQuarto;
        this.tipoQuarto = tipoQuarto;
        this.cama = cama;
        this.valorDiaria = valorDiaria;
    }

    public int getNumQuarto() {
        return numQuarto;
    }

    public void setNumQuarto(int numQuarto) {
        this.numQuarto = numQuarto;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(String tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public String getCama() {
        return cama;
    }

    public void setCama(String cama) {
        this.cama = cama;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
    
    
    
}
