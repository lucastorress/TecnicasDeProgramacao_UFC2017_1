/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Model.Logic.NewSaleLogic;
import Model.Object.Product;
import Model.Logic.ProductLogic;
import Model.Object.User;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucas
 */
public class frmNovaVenda extends javax.swing.JInternalFrame {
    NewSaleLogic salectr;
    User user;
    /**
     * Creates new form frmNovaVenda
     */
    public frmNovaVenda(User user) {
        initComponents();
        this.user = user;
        salectr = new NewSaleLogic();
        salectr.products = new HashMap<>();

        /*
        try {
            frmPrincipal parent = (frmPrincipal) SwingUtilities.getWindowAncestor(this);
            txtSellerName.setText(parent.getLoggedUser().getName());
            } catch (Exception e){
                exibirMensagem("Erro ao solicitar o vendedor." + e.getMessage());
            } this.revalidate();*/

        txtSellerName.setText(user.getName());
        this.revalidate();
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textArea1 = new java.awt.TextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtSellerName = new javax.swing.JTextField();
        txtClientCPF = new javax.swing.JFormattedTextField();
        checkCarrier = new javax.swing.JCheckBox();
        txtItemAmount = new javax.swing.JSpinner();
        txtProductID = new javax.swing.JTextField();
        txtCredit = new javax.swing.JTextField();
        txtSaleValue = new javax.swing.JTextField();
        txtDiscount = new javax.swing.JTextField();
        txtPayable = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAddItem = new javax.swing.JButton();
        btnCancelItem = new javax.swing.JButton();
        btnCancelSale = new javax.swing.JButton();
        btnFinishSale = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Nova Venda");

        jLabel1.setText("Vendedor:");

        jLabel2.setText("Cliente/CPF:");

        jLabel4.setText("X");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Valor Total:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Descontos:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("A pagar:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Crédito:");

        jLabel9.setText("Transportadora:");

        txtSellerName.setEditable(false);

        try {
            txtClientCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtItemAmount.setModel(new javax.swing.SpinnerNumberModel());
        txtItemAmount.setToolTipText("");

        txtProductID.setText("Código de Barras do Produto");
        txtProductID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductIDActionPerformed(evt);
            }
        });

        txtCredit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtSaleValue.setEditable(false);
        txtSaleValue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtDiscount.setEditable(false);
        txtDiscount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtPayable.setEditable(false);
        txtPayable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPayable.setToolTipText("");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Produto", "Qtd.", "Valor Ind.", "Valor Tot."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        btnAddItem.setText("Adicionar Item");
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });

        btnCancelItem.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnCancelItem.setForeground(new java.awt.Color(204, 0, 51));
        btnCancelItem.setText("Cancelar Item");
        btnCancelItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelItemActionPerformed(evt);
            }
        });

        btnCancelSale.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnCancelSale.setForeground(new java.awt.Color(204, 0, 51));
        btnCancelSale.setText("Cancelar Venda");
        btnCancelSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelSaleActionPerformed(evt);
            }
        });

        btnFinishSale.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnFinishSale.setForeground(new java.awt.Color(0, 204, 0));
        btnFinishSale.setText("Fechar Venda");
        btnFinishSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishSaleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSellerName, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtItemAmount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtClientCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(checkCarrier))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtProductID, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCredit)
                    .addComponent(jSeparator3)
                    .addComponent(txtSaleValue)
                    .addComponent(jSeparator1)
                    .addComponent(txtDiscount)
                    .addComponent(jSeparator2)
                    .addComponent(txtPayable)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnAddItem, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCancelItem)
                .addGap(18, 18, 18)
                .addComponent(btnCancelSale)
                .addGap(18, 18, 18)
                .addComponent(btnFinishSale)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSellerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(checkCarrier)
                    .addComponent(jLabel9)
                    .addComponent(txtClientCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtItemAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtProductID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddItem))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCredit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSaleValue, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPayable, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelItem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinishSale, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelSale, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelSaleActionPerformed
        this.salectr.cancelSale();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for(int i = jTable1.getRowCount(); i > 0; i--) {
            model.removeRow(0);
        }
        txtSaleValue.setText(String.format("R$ %,.2f", salectr.getTotal()));
        txtPayable.setText(String.format("R$ %,.2f", salectr.getTotal()));
        this.revalidate();
    }//GEN-LAST:event_btnCancelSaleActionPerformed

    private void btnCancelItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelItemActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            ProductLogic logic = new ProductLogic();
            int row = jTable1.getSelectedRow();
            if(row >= 0) {
                String codebar = (String) model.getValueAt(row, 0);
                salectr.deleteProduct(codebar);
                model.removeRow(row);
                txtSaleValue.setText(String.format("R$ %,.2f", salectr.getTotal()));
                txtPayable.setText(String.format("R$ %,.2f", salectr.getTotal()));
                System.out.println(salectr.getTotal());
            }
        } catch(Exception exception) {
            exibirMensagem("Erro no cancelamento!");
        }
        this.revalidate();
    }//GEN-LAST:event_btnCancelItemActionPerformed

    private void btnFinishSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishSaleActionPerformed
        int id = this.user.getUserId();
        System.out.println(user.getName());
        System.out.println(user.getUserId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        try {
            this.salectr.finishSale(txtClientCPF.getText(), id, checkCarrier.isSelected());
            exibirMensagem("Venda completada com sucesso.");
        } catch (Exception ex) {
            exibirMensagem("Não foi possível concluir a venda.\n" + ex.getMessage());
        }
        btnCancelSaleActionPerformed(null);
    }//GEN-LAST:event_btnFinishSaleActionPerformed

    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemActionPerformed
        ProductLogic logic = new ProductLogic();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        try {
            if(((int) txtItemAmount.getValue()) <= 0) {
                exibirMensagem("Quantidade impossível!");
            } else {
                Product product = logic.searchCodebar(txtProductID.getText());
                salectr.addProduct((int) txtItemAmount.getValue(), product);
                txtSaleValue.setText(String.format("R$ %,.2f", salectr.getTotal()));
                txtPayable.setText(String.format("R$ %,.2f", salectr.getTotal()));
                Object[] array = new Object[5];
                array[0] = product.getBarcode();
                array[1] = product.getName();
                array[2] = (int) txtItemAmount.getValue();
                array[3] = String.format("R$ %,.2f", product.getPrice());
                array[4] = String.format("R$ %,.2f", ((int) txtItemAmount.getValue()) * product.getPrice());
                model.addRow(array);
                jTable1.setModel(model);
                jTable1.revalidate();
            }
        } catch(Exception exception) {
            exibirMensagem("Não foi possível adicionar o item à compra.\n" + exception.getMessage());
        }
        this.revalidate();
    }//GEN-LAST:event_btnAddItemActionPerformed

    private void txtProductIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductIDActionPerformed

    public void exibirMensagem(String str){
        JOptionPane.showMessageDialog(null, str);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnCancelItem;
    private javax.swing.JButton btnCancelSale;
    private javax.swing.JButton btnFinishSale;
    private javax.swing.JCheckBox checkCarrier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    private java.awt.TextArea textArea1;
    private javax.swing.JFormattedTextField txtClientCPF;
    private javax.swing.JTextField txtCredit;
    private javax.swing.JTextField txtDiscount;
    private javax.swing.JSpinner txtItemAmount;
    private javax.swing.JTextField txtPayable;
    private javax.swing.JTextField txtProductID;
    private javax.swing.JTextField txtSaleValue;
    private javax.swing.JTextField txtSellerName;
    // End of variables declaration//GEN-END:variables
}
