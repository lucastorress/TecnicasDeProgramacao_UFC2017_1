package Interface;

import Model.Logic.ReportLogic.*;
import javax.swing.JOptionPane;

public class frmRelatorios extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmRelatorios
     */
    public frmRelatorios() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        checkBoxRegister = new javax.swing.JCheckBox();
        checkBoxClients = new javax.swing.JCheckBox();
        checkBoxSellers = new javax.swing.JCheckBox();
        checkBoxSales = new javax.swing.JCheckBox();
        checkBoxStorage = new javax.swing.JCheckBox();
        btnGerarRelatorio = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Gerar Relatório");

        jLabel1.setText("Gerar relatório:");

        checkBoxRegister.setText("Caixa");

        checkBoxClients.setText("Clientes");

        checkBoxSellers.setText("Vendedores");

        checkBoxSales.setText("Vendas");

        checkBoxStorage.setText("Estoque");

        btnGerarRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/print.png"))); // NOI18N
        btnGerarRelatorio.setText("Gerar Relatório");
        btnGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkBoxClients)
                            .addComponent(checkBoxRegister)
                            .addComponent(checkBoxSellers))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkBoxSales)
                            .addComponent(checkBoxStorage)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnGerarRelatorio)))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkBoxRegister)
                    .addComponent(checkBoxSales))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkBoxClients)
                    .addComponent(checkBoxStorage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkBoxSellers)
                .addGap(18, 18, 18)
                .addComponent(btnGerarRelatorio)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarRelatorioActionPerformed
        try {
            if(checkBoxClients.isSelected()) {
                ReportClients report = new ReportClients();
                report.draw();
            }
            if(checkBoxRegister.isSelected()) {
                ReportRegisterFlux report = new ReportRegisterFlux();
                report.draw();
            }
            if(checkBoxSales.isSelected()) {
                ReportDailySales report = new ReportDailySales();
                report.draw();
            }
            if(checkBoxSellers.isSelected()) {
                ReportSellers report = new ReportSellers();
                report.draw();
            }     
            if(checkBoxStorage.isSelected()) {
                ReportInventory report = new ReportInventory();
                report.draw();
            }
        } catch(Exception exception) {
            exibirMensagem("Erro na criação do relatório.");
        }
    }//GEN-LAST:event_btnGerarRelatorioActionPerformed

    public void exibirMensagem(String str){
        JOptionPane.showMessageDialog(null, str);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerarRelatorio;
    private javax.swing.JCheckBox checkBoxClients;
    private javax.swing.JCheckBox checkBoxRegister;
    private javax.swing.JCheckBox checkBoxSales;
    private javax.swing.JCheckBox checkBoxSellers;
    private javax.swing.JCheckBox checkBoxStorage;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}