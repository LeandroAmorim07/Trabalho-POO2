/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import viewer.TelaPrincipal;


public class uiManeger {
    private TelaPrincipal frmPrinc;

    public uiManeger(TelaPrincipal frmPrinc) {
        this.frmPrinc = frmPrinc;
    }
    
    
    public void abrirJanelaPrincipal() {
    frmPrinc.setVisible(true);
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
    uiManeger gerenciador = new uiManeger(telaPrincipal);
    
    gerenciador.abrirJanelaPrincipal();
    }
    

}
