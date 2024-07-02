/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package viewer;

import control.uiManeger;



public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        setSize(1000,800);
        setLocation(500,100);
            }
    




    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btServicoQuarto = new javax.swing.JButton();
        btGerenciarQuartos = new javax.swing.JButton();
        btGerenciarCliente = new javax.swing.JButton();
        btReserva = new javax.swing.JButton();
        btProduto = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 800));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 51, 102,80));
        jPanel2.setOpaque(false);

        btServicoQuarto.setBackground(new java.awt.Color(249,249,241));
        btServicoQuarto.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btServicoQuarto.setForeground(new java.awt.Color(71, 111, 85));
        btServicoQuarto.setText("Gerenciar Serviço de Quarto");
        btServicoQuarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btServicoQuartoActionPerformed(evt);
            }
        });

        btGerenciarQuartos.setBackground(new java.awt.Color(249, 249, 241));
        btGerenciarQuartos.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btGerenciarQuartos.setForeground(new java.awt.Color(71, 111, 85));
        btGerenciarQuartos.setText("Gerenciar Quartos");
        btGerenciarQuartos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGerenciarQuartosActionPerformed(evt);
            }
        });

        btGerenciarCliente.setBackground(new java.awt.Color(249, 249, 241));
        btGerenciarCliente.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btGerenciarCliente.setForeground(new java.awt.Color(71, 111, 85));
        btGerenciarCliente.setText("Gerenciar Clientes");
        btGerenciarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGerenciarClienteActionPerformed(evt);
            }
        });

        btReserva.setBackground(new java.awt.Color(249, 249, 241));
        btReserva.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btReserva.setForeground(new java.awt.Color(71, 111, 85));
        btReserva.setText("Gerenciar Estadia");
        btReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReservaActionPerformed(evt);
            }
        });

        btProduto.setBackground(new java.awt.Color(249,249,241));
        btProduto.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btProduto.setForeground(new java.awt.Color(71, 111, 85));
        btProduto.setText("Gerenciar Produtos");
        btProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btGerenciarQuartos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btGerenciarCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btReserva, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btServicoQuarto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btGerenciarQuartos, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btGerenciarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btServicoQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 250, 650));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/_8d79d9c7-7bb0-41d8-8bec-4f3af2d6b24c.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/telaFundoSistema_out.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(500, 300));
        jLabel1.setMinimumSize(new java.awt.Dimension(500, 300));
        jLabel1.setPreferredSize(new java.awt.Dimension(500, 300));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-120, -310, 2890, 1520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btGerenciarQuartosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGerenciarQuartosActionPerformed
       uiManeger.getInstance().abrirCadQuarto();
    }//GEN-LAST:event_btGerenciarQuartosActionPerformed

    private void btReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReservaActionPerformed
      uiManeger.getInstance().abrirResQuartos();
    }//GEN-LAST:event_btReservaActionPerformed

    private void btGerenciarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGerenciarClienteActionPerformed
        uiManeger.getInstance().abrirCadCliente();
    }//GEN-LAST:event_btGerenciarClienteActionPerformed

    private void btServicoQuartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btServicoQuartoActionPerformed
        uiManeger.getInstance().abrirServQuartos();
    }//GEN-LAST:event_btServicoQuartoActionPerformed

    private void btProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProdutoActionPerformed
        uiManeger.getInstance().abrirGerProd();
    }//GEN-LAST:event_btProdutoActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btGerenciarCliente;
    private javax.swing.JButton btGerenciarQuartos;
    private javax.swing.JButton btProduto;
    private javax.swing.JButton btReserva;
    private javax.swing.JButton btServicoQuarto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
