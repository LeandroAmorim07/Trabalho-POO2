package control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Estadia;


public class EstadiaAbstractTableModel extends AbstractTableModel {

    private List<Estadia> listaEstadias = new ArrayList<>();

    
    @Override
    public int getRowCount() {
        return listaEstadias.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    // Títulos das colunas
    @Override
    public String getColumnName(int column) {
        String[] nomesColunas = {"IdCliente", "Número do Quarto", "Check-in", "Check-out", "Valor Total Diaria"};
        return nomesColunas[column];
    }

    @Override

    public Object getValueAt(int rowIndex, int columnIndex) {
        Estadia estadia = listaEstadias.get(rowIndex);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return switch (columnIndex) {
            case 0 ->
                estadia.getCliente().getIdCliente();
            case 1 ->
                estadia.getQuarto().getNumQuarto();
            case 2 ->
                dateFormat.format(estadia.getCheckin());
            case 3 ->
                dateFormat.format(estadia.getCheckOut());
            case 4 ->
                estadia.getValorTotalEstadia();
            default ->
                null;
        };
    }

    public void adicionar(Estadia estadia) {
        listaEstadias.add(estadia);
        fireTableRowsInserted(listaEstadias.size() - 1, listaEstadias.size() - 1);
    }

    public void remover(int indice) {
        listaEstadias.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }

    public Estadia getEstadia(int linha) {
        return listaEstadias.get(linha);
    }

    public List<Estadia> getListaEstadias() {
        return listaEstadias;
    }
    
    

    public void setLista(List<Estadia> novaLista) {

        if (novaLista.isEmpty()) {
            if (!listaEstadias.isEmpty()) {
                listaEstadias.clear();
                fireTableRowsDeleted(0, 0);
            }
        } else {
            listaEstadias = novaLista;
            fireTableRowsInserted(0, listaEstadias.size() - 1);
        }

    }
}
