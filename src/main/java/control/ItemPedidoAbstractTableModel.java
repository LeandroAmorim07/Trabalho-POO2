
package control;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.ItemPedido;


public class ItemPedidoAbstractTableModel extends AbstractTableModel {

    private List<ItemPedido> listaItens = new ArrayList<>();

    @Override
    public int getRowCount() {
        return listaItens.size();
    }

    @Override
    public int getColumnCount() {
        return 11;
    }

    // Títulos das colunas
    @Override
    public String getColumnName(int column) {
        String nomesColunas[] = {"Cliente", "Num Quarto", "Hambúrguer", "X-Burguer", "Biscoito", "Ruffles", "Coca", "Pepsi", "Suco", "Champanhe", "Extras"};
        return nomesColunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ItemPedido item = listaItens.get(rowIndex);
        switch (columnIndex) {
            case 0: return item.getPedidosq().getEstadia().getCliente();
            case 1: return item.getPedidosq().getEstadia().getQuarto();
            case 2: return item.getQtdHamb();
            case 3: return item.getQtdXburguer();
            case 4: return item.getQtdOreo();
            case 5: return item.getQtdRuffles();
            case 6: return item.getQtdCoca();
            case 7: return item.getQtdPepsi();
            case 8: return item.getQtdDelValle();
            case 9: return item.getQtdChampanhe();
            case 10: return item.getExtras();
            default: return null;
        }
    }

    public void adicionar(ItemPedido item) {
        listaItens.add(item);
        fireTableRowsInserted(listaItens.size() - 1, listaItens.size() - 1);
    }

    public void remover(int indice) {
        listaItens.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }

    public ItemPedido getServicoQuarto(int linha) {
        return listaItens.get(linha);
    }

    public void setLista(List<ItemPedido> novaLista) {
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
