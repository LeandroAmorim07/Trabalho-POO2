package control;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Item;

public class ItemAbstractTableModel extends AbstractTableModel {

    private List<Item> listaItens = new ArrayList<>();

    @Override
    public int getRowCount() {
        return listaItens.size();
    }

    @Override
    public int getColumnCount() {
        // Defina o número de colunas desejado
        return 2;
    }

    // Títulos das colunas
    @Override
    public String getColumnName(int column) {
        String[] nomesColunas = { "Nome do Item", "Valor do Item"};
        return nomesColunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Item item = listaItens.get(rowIndex);

        switch (columnIndex) {
            
            case 0:
                return item.getNomeItem();
            case 1:
                return item.getValor();
            default:
                return null;
        }
    }

    public void adicionar(Item item) {
        listaItens.add(item);
        fireTableRowsInserted(listaItens.size() - 1, listaItens.size() - 1);
    }

    public void remover(int indice) {
        listaItens.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }

    public Item getItem(int linha) {
        return listaItens.get(linha);
    }

    public void setLista(List<Item> novaLista) {
        if (novaLista.isEmpty()) {
            if (!listaItens.isEmpty()) {
                listaItens.clear();
                fireTableRowsDeleted(0, 0);
            }
        } else {
            listaItens = novaLista;
            fireTableRowsInserted(0, listaItens.size() - 1);
        }
    }
}
