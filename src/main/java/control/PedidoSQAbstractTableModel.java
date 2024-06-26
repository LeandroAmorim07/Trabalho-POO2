/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.PedidoSQ;




public class PedidoSQAbstractTableModel extends AbstractTableModel {
     private List<PedidoSQ> listaItens = new ArrayList();

    @Override
    public int getRowCount() {
        return listaItens.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }
        

    // Títulos das colunas
    @Override
    public String getColumnName(int column) {
        String nomesColunas[] = {"IdPedido","Valor Total"};        
        return nomesColunas[column];        
    }
    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PedidoSQ item = listaItens.get(rowIndex);

        switch (columnIndex) {
            case 0: return item.getIdPedidoSQ();
            case 1: return item.getValorTotal();
           
         
            
            default: return null;
        }

    }
    
    public void adicionar (PedidoSQ item) {
        listaItens.add(item);
        fireTableRowsInserted( listaItens.size() - 1, listaItens.size() - 1 );
        
    }
    
    public void remover (int indice) {
        listaItens.remove(indice);
        fireTableRowsDeleted( indice, indice );
        
    }

    public PedidoSQ getPedido(int linha) {
        return listaItens.get(linha);
    }
    
    public void setLista(List<PedidoSQ> novaLista) {
        
        if ( novaLista.isEmpty()) {
            if ( !listaItens.isEmpty() ) {
                listaItens.clear();
                fireTableRowsDeleted(0,0);
            }
        } else {
            listaItens = novaLista;
            fireTableRowsInserted( 0, listaItens.size() - 1);
        }
                
    }
}
