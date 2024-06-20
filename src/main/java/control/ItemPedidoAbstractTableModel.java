/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;




import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.ItemPedido;

 public class ItemPedidoAbstractTableModel extends AbstractTableModel {

    private List<ItemPedido> listaItens = new ArrayList();

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
        String nomesColunas[] = {"Item", "Qtde"};
        
        return nomesColunas[column];
        
    }
    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ItemPedido item = listaItens.get(rowIndex);

        switch (columnIndex) {
            case 0: return item.getChComposta().getItem().getNomeItem();
            case 1: return item.getQtd();
            default: return null;
        }

    }
    
    public ItemPedido getItem (int rowIndex) {
        return listaItens.get(rowIndex);        
    }
    
    public void adicionar (ItemPedido item) {
        listaItens.add(item);
        fireTableRowsInserted( listaItens.size() - 1, listaItens.size() - 1 );
        
    }
    
    public void remover (int indice) {
        listaItens.remove(indice);
        fireTableRowsDeleted( indice, indice );
        
    }
    
    public void setLista(List<ItemPedido> novaLista) {
        if ( novaLista == null) {
            listaItens.clear();
            fireTableRowsDeleted( 0, 0 );
        } else {
            listaItens = novaLista;
            fireTableRowsUpdated(0, listaItens.size() - 1);
        }
        
    }
    
    public List<ItemPedido> getLista() {
        return listaItens;
    }
        
}