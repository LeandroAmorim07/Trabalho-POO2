package control;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Estadia;
import model.Item;
import model.Quarto;
import viewer.CadastrarClientes;

import viewer.CadastrarQuartos;
import viewer.GerenciarEstadia;
import viewer.GerenciarItens;
import viewer.PesquisarClientes;
import viewer.PesquisarEstadia;
import viewer.PesquisarItem;
import viewer.PesquisarQuarto;
import viewer.ServicoDeQuartos;
import viewer.TelaPrincipal;

public class uiManeger {

    private TelaPrincipal frmPrinc = null;
    private CadastrarQuartos cq = null;
    private CadastrarClientes cc = null;
    private GerenciarEstadia rq = null;
    private ServicoDeQuartos sq = null;
    private PesquisarClientes pc = null;
    private PesquisarQuarto pq = null;
    private GerenciarItens cp = null;
    private PesquisarItem pi = null;
    private PesquisarEstadia pe = null;

    // ########  SINGLETON  ####
    private static uiManeger myInstance = new uiManeger();
    private DomainManeger gerDom;

    public static uiManeger getInstance() {
        return myInstance;
    }

    // Construtor PRIVADO
    private uiManeger() {

        try {
            gerDom = new DomainManeger();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(frmPrinc, "Erro de classe. " + ex.getMessage());
            System.exit(0);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(frmPrinc, "Erro de SQL. " + ex.getMessage());
            System.exit(0);
        }

    }

    public class TableUtilidades {

        public static void removerLinhaSelecionada(DefaultTableModel model, JTable table) {
            if (table.getSelectedRowCount() == 1) {
                model.removeRow(table.getSelectedRow());
            } else if (table.getSelectedRowCount() >= 1) {
                JOptionPane.showMessageDialog(null, "Selecione apenas uma linha por vez");
            } else {
                if (table.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Tabela está vazia");
                } else {
                    JOptionPane.showMessageDialog(null, " nenhuma linha está selecionada");
                }
            }
        }
    }

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
    public class JPaneLGradient extends JPanel {

        public static JPanel criarPainelDegrade() {
            return new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2d = (Graphics2D) g.create();

                    int width = getWidth();
                    int height = getHeight();

                    Color cor1 = new Color(135, 135, 180);
                    Color cor2 = new Color(176, 224, 230);

                    GradientPaint gradientPaint = new GradientPaint(0, 0, cor1, width, height, cor2);
                    g2d.setPaint(gradientPaint);
                    g2d.fillRect(0, 0, width, height);

                    g2d.dispose();
                }
            };
        }
    }

    private JDialog abrirJanela(java.awt.Frame parent, JDialog dlg, Class classe) {
        if (dlg == null) {
            try {
                dlg = (JDialog) classe.getConstructor(Frame.class, boolean.class).newInstance(parent, true);
            } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                JOptionPane.showMessageDialog(parent, "Erro ao abrir a janela " + classe.getName());
            }
        }
        dlg.setVisible(true);
        return dlg;
    }

    public void abrirJanelaPrincipal() {
        if (frmPrinc == null) {
            frmPrinc = new TelaPrincipal();
        }
        frmPrinc.setVisible(true);
    }

    public void abrirCadQuarto() {
        cq = (CadastrarQuartos) abrirJanela(frmPrinc, cq, CadastrarQuartos.class);
    }

    public void abrirCadCliente() {
        cc = (CadastrarClientes) abrirJanela(frmPrinc, cc, CadastrarClientes.class);
    }

    public Cliente abrirPesqCliente() {
        pc = (PesquisarClientes) abrirJanela(frmPrinc, pc, PesquisarClientes.class);
        return pc.getCliSelecionado();

    }

    public Quarto abrirPesqQuarto() {
        pq = (PesquisarQuarto) abrirJanela(frmPrinc, pq, PesquisarQuarto.class);
        return pq.getQuartoSelecionado();

    }

    public void abrirResQuartos() {
        rq = (GerenciarEstadia) abrirJanela(frmPrinc, rq, GerenciarEstadia.class);
    }

    public void abrirServQuartos() {
        sq = (ServicoDeQuartos) abrirJanela(frmPrinc, sq, ServicoDeQuartos.class);
    }

    public void abrirGerProd() {
        cp = (GerenciarItens) abrirJanela(frmPrinc, cp, GerenciarItens.class);
    }

    public Item abrirPesqItem() {
        pi = (PesquisarItem) abrirJanela(frmPrinc, pi, PesquisarItem.class);
        return pi.getItemSelecionado();

    }

    public Estadia abrirPesqEstadia() {
        pe = (PesquisarEstadia) abrirJanela(frmPrinc, pe, PesquisarEstadia.class);
        return pe.getEstadiaSelecionado();

    }

    public DomainManeger getDomainManeger() {
        return gerDom;
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("FlatDarkLat".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        TelaPrincipal telaPrincipal = new TelaPrincipal();

        // Cria uma instância da classe uiManeger passando a tela principal como argumento
        uiManeger gerenciador = new uiManeger();

        gerenciador.getInstance().abrirJanelaPrincipal();
    }

}
