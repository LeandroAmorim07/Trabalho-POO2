package control;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import model.Quarto;

/**
 * Table model for Quarto.
 */
public class QuartoAbstractTableModel extends AbstractTableModel {

    private List<Quarto> listaItens = new ArrayList<>();

    @Override
    public int getRowCount() {
        return listaItens.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    // Títulos das colunas
    @Override
    public String getColumnName(int column) {
        String nomesColunas[] = {"Número do Quarto", "Tipo do Quarto", "Cama", "Preço Diária"};
        return nomesColunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Quarto item = listaItens.get(rowIndex);

        switch (columnIndex) {
            case 0: return item.getNumQuarto();
            case 1: return item.getTipoQuarto();
            case 2: return item.getCama();
            case 3: return item.getValorDiaria();
            default: return null;
        }
    }

    public void adicionar(Quarto item) {
        listaItens.add(item);
        fireTableRowsInserted(listaItens.size() - 1, listaItens.size() - 1);
    }

    public void remover(int indice) {
        listaItens.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }

    public Quarto getQuarto(int linha) {
        return listaItens.get(linha);
    }

    public void setLista(List<Quarto> novaLista) {
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
