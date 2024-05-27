/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.List;
import model.Cliente;

/**
 *
 * @author Programe-SE 11
 */
public class FuncoesUteis {
     private List<Cliente> listaClientes; // Supondo que você tenha uma lista de clientes

    // Construtor e outros métodos da classe

    // Método para obter um cliente pelo ID
    public Cliente obterClientePeloId(String idCliente) {
        for (Cliente cliente : listaClientes) {
            if (idCliente.equals(cliente.getIdCliente())) { // Supondo que o ID do cliente seja uma String
                return cliente;
            }
        }
        return null; // Retorna null se nenhum cliente for encontrado com o ID especificado
    }
}
