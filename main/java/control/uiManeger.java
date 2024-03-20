/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.Frame;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import viewer.CadastrarQuartoss;
import viewer.TelaPrincipal;




    
    public class uiManeger {
    private TelaPrincipal frmPrinc = null;
    private CadastrarQuartoss cq = null;
    
   

    // ########  SINGLETON  ####
    private static uiManeger myInstance = new uiManeger();
     
    public static uiManeger getInstance() {
        return myInstance;       
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
        cq = (CadastrarQuartoss) abrirJanela(frmPrinc, cq, CadastrarQuartoss.class  );
    }
     
     public void abrirCadCliente(){
         
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
