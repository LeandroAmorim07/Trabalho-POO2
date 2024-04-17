/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import viewer.CadastrarClientes;

import viewer.CadastrarQuartos;
import viewer.GerenciarEstadia;
import viewer.ServicoDeQuartos;
import viewer.TelaPrincipal;




    
    public class uiManeger {
    private TelaPrincipal frmPrinc = null;
    private CadastrarQuartos cq = null;
    private CadastrarClientes cc=null;
    private GerenciarEstadia rq=null;
    private ServicoDeQuartos sq=null;
    
   

    // ########  SINGLETON  ####
    private static uiManeger myInstance = new uiManeger();
     
    public static uiManeger getInstance() {
        return myInstance;       
    }
    
    
public class TableUtilidades{
    public static void removerLinhaSelecionada(DefaultTableModel model, JTable table) {
        if (table.getSelectedRowCount() == 1) {
            model.removeRow(table.getSelectedRow());
        }
        else if (table.getSelectedRowCount() >= 1){
            JOptionPane.showMessageDialog(null, "Selecione apenas uma linha por vez");
        }
        else {
            if (table.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Tabela está vazia");
            }
            
            else {
                JOptionPane.showMessageDialog(null, " nenhuma linha está selecionada");
            }
        }
    }
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
        if (dlg == null){     
            try {
                dlg = (JDialog) classe.getConstructor(Frame.class, boolean.class).newInstance(parent,true);
            } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                JOptionPane.showMessageDialog(parent, "Erro ao abrir a janela " + classe.getName() );
            } 
        }        
        dlg.setVisible(true); 
        return dlg;
    }
     
     
     
     
     
     
     
    public void abrirJanelaPrincipal() {
     if ( frmPrinc == null ) {
            frmPrinc = new TelaPrincipal();
        }
        frmPrinc.setVisible(true);
}
     public void abrirCadQuarto() {
        cq = (CadastrarQuartos) abrirJanela(frmPrinc, cq, CadastrarQuartos.class  );
    }
     
     public void abrirCadCliente(){
        cc = (CadastrarClientes) abrirJanela(frmPrinc, cc, CadastrarClientes.class  );
     }
     
     
      public void abrirResQuartos(){
        rq = (GerenciarEstadia) abrirJanela(frmPrinc, rq, GerenciarEstadia.class  );
     }
      
       public void abrirServQuartos(){
        sq = (ServicoDeQuartos) abrirJanela(frmPrinc, sq, ServicoDeQuartos.class  );
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
