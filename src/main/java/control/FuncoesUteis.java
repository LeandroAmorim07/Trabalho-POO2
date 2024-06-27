/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Estadia;

/**
 *
 * @author Programe-SE 11
 */
public class FuncoesUteis {

    public static List<Estadia> removerDuplicatas(List<Estadia> lista) {
        // foi preciso adicionar essa funcao pois quando coloca 2 pedido com mesma estadia
        // a lista atualiza com duas estadias apesar de no banco nao atualizar assim
        // entao foi feito essa funcao para tirar todas duplicatas possiveis da mesma estadia
        List<Estadia> listaSemDuplicatas = new ArrayList<>();
        for (Estadia estadia : lista) {
            boolean duplicado = false;
            for (Estadia existente : listaSemDuplicatas) {
                if (estadia.getIdEstadia() == existente.getIdEstadia()) {
                    duplicado = true;
                    break;
                }
            }
            if (!duplicado) {
                listaSemDuplicatas.add(estadia);
            }
        }
        return listaSemDuplicatas;
    }
     private List<Cliente> listaClientes; 
     
    public Cliente obterClientePeloId(String idCliente) {
        for (Cliente cliente : listaClientes) {
            if (idCliente.equals(cliente.getIdCliente())) { 
                return cliente;
            }
        }
        return null; 
    }
}
