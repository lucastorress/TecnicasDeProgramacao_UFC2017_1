/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Model.Object.User;

import javax.swing.UIManager;

/**
 *
 * @author Lucas
 */
public class frmPrincipal extends javax.swing.JFrame {
    boolean loggedIn;
    User loggedUser;
    frmTelaLogin frame;

    public frmPrincipal() {
        configuraAparenciaWindows();
        initComponents();
        
        //Login do Usuário
        this.frame = new frmTelaLogin(this); //instancia a TelaLogin assim que iniciar o programa
        frame.setVisible(true);	//define que a interface gráfica será visivel
        painelJanelas.add(frame);
    }
    
    public void setLogin(boolean login) {
        this.loggedIn = true;
    }
    
    public void setLoggedUser(User user) {
        this.loggedUser = user;
    }
    
    public boolean getLogin() {
        return this.loggedIn;
    }
    
    public User getLoggedUser() {
        return this.loggedUser;
    }
    
    public void displayMenu() {
        menuBarra.setEnabled(true);
        menuSistemas.setEnabled(true);
        mnuSingInUserSeller.setEnabled(true);
        mnuClients.setEnabled(true);
        mnuCadastrarLoja.setEnabled(true);
        menuVendas.setEnabled(true);
        mnuNovaVenda.setEnabled(true);
        menuProdutos.setEnabled(true);
        mnuCadastrarProduto.setEnabled(true);
        mnuAlterarProduto.setEnabled(true);
        mnuAdicionarEstoque.setEnabled(true);
        menuTransportadora.setEnabled(true);
        mnuCadastrarTransportadora.setEnabled(true);
        mnuAlterarTransportadora.setEnabled(true);
        menuRelatorios.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelJanelas = new javax.swing.JDesktopPane();
        menuBarra = new javax.swing.JMenuBar();
        menuSistemas = new javax.swing.JMenu();
        mnuSingInUserSeller = new javax.swing.JMenuItem();
        mnuClients = new javax.swing.JMenuItem();
        mnuCadastrarLoja = new javax.swing.JMenuItem();
        menuVendas = new javax.swing.JMenu();
        mnuNovaVenda = new javax.swing.JMenuItem();
        menuProdutos = new javax.swing.JMenu();
        mnuCadastrarProduto = new javax.swing.JMenuItem();
        mnuAlterarProduto = new javax.swing.JMenuItem();
        mnuAdicionarEstoque = new javax.swing.JMenuItem();
        menuTransportadora = new javax.swing.JMenu();
        mnuCadastrarTransportadora = new javax.swing.JMenuItem();
        mnuAlterarTransportadora = new javax.swing.JMenuItem();
        menuRelatorios = new javax.swing.JMenu();
        mnuGerarRelatorio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Vendas");
        setPreferredSize(new java.awt.Dimension(950, 750));

        painelJanelas.setBackground(new java.awt.Color(204, 204, 204));
        painelJanelas.setToolTipText("");
        painelJanelas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout painelJanelasLayout = new javax.swing.GroupLayout(painelJanelas);
        painelJanelas.setLayout(painelJanelasLayout);
        painelJanelasLayout.setHorizontalGroup(
            painelJanelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        painelJanelasLayout.setVerticalGroup(
            painelJanelasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 629, Short.MAX_VALUE)
        );

        menuSistemas.setText("Sistema");
        menuSistemas.setEnabled(false);

        mnuSingInUserSeller.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        mnuSingInUserSeller.setText("Usuário/Vendedor");
        mnuSingInUserSeller.setEnabled(false);
        mnuSingInUserSeller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSingInUserSellerActionPerformed(evt);
            }
        });
        menuSistemas.add(mnuSingInUserSeller);

        mnuClients.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        mnuClients.setText("Clientes");
        mnuClients.setEnabled(false);
        mnuClients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuClientsActionPerformed(evt);
            }
        });
        menuSistemas.add(mnuClients);

        mnuCadastrarLoja.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        mnuCadastrarLoja.setText("Lojas");
        mnuCadastrarLoja.setEnabled(false);
        mnuCadastrarLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCadastrarLojaActionPerformed(evt);
            }
        });
        menuSistemas.add(mnuCadastrarLoja);

        menuBarra.add(menuSistemas);

        menuVendas.setText("Vendas");
        menuVendas.setEnabled(false);

        mnuNovaVenda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        mnuNovaVenda.setText("Nova Venda");
        mnuNovaVenda.setEnabled(false);
        mnuNovaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuNovaVendaActionPerformed(evt);
            }
        });
        menuVendas.add(mnuNovaVenda);

        menuBarra.add(menuVendas);

        menuProdutos.setText("Produtos");
        menuProdutos.setEnabled(false);

        mnuCadastrarProduto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        mnuCadastrarProduto.setText("Cadastrar Produto");
        mnuCadastrarProduto.setEnabled(false);
        mnuCadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCadastrarProdutoActionPerformed(evt);
            }
        });
        menuProdutos.add(mnuCadastrarProduto);

        mnuAlterarProduto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        mnuAlterarProduto.setText("Consultar/Alterar Produto");
        mnuAlterarProduto.setEnabled(false);
        mnuAlterarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAlterarProdutoActionPerformed(evt);
            }
        });
        menuProdutos.add(mnuAlterarProduto);

        mnuAdicionarEstoque.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        mnuAdicionarEstoque.setText("Adicionar ao Estoque");
        mnuAdicionarEstoque.setEnabled(false);
        mnuAdicionarEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAdicionarEstoqueActionPerformed(evt);
            }
        });
        menuProdutos.add(mnuAdicionarEstoque);

        menuBarra.add(menuProdutos);

        menuTransportadora.setText("Transportadora");
        menuTransportadora.setEnabled(false);

        mnuCadastrarTransportadora.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        mnuCadastrarTransportadora.setText("Cadastrar Transportadora");
        mnuCadastrarTransportadora.setEnabled(false);
        mnuCadastrarTransportadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCadastrarTransportadoraActionPerformed(evt);
            }
        });
        menuTransportadora.add(mnuCadastrarTransportadora);

        mnuAlterarTransportadora.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
        mnuAlterarTransportadora.setText("Consultar/Alterar Transportadora");
        mnuAlterarTransportadora.setEnabled(false);
        mnuAlterarTransportadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAlterarTransportadoraActionPerformed(evt);
            }
        });
        menuTransportadora.add(mnuAlterarTransportadora);

        menuBarra.add(menuTransportadora);

        menuRelatorios.setText("Relatórios");
        menuRelatorios.setEnabled(false);

        mnuGerarRelatorio.setText("Gerar Relatórios");
        mnuGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuGerarRelatorioActionPerformed(evt);
            }
        });
        menuRelatorios.add(mnuGerarRelatorio);

        menuBarra.add(menuRelatorios);

        setJMenuBar(menuBarra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelJanelas)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelJanelas)
        );

        getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuSingInUserSellerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSingInUserSellerActionPerformed
        frmUsuarioVendedorPainel disc = new frmUsuarioVendedorPainel(loggedUser); //instancia objeto da classe
        disc.setVisible(true);	//define que a interface gráfica será visivel
        painelJanelas.add(disc);    //adiciona o objeto disc ao container desktop. O form é exibido
    }//GEN-LAST:event_mnuSingInUserSellerActionPerformed

    private void mnuNovaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuNovaVendaActionPerformed
        frmNovaVenda disc = new frmNovaVenda(loggedUser); //instancia objeto da classe
        disc.setVisible(true);	//define que a interface gráfica será visivel
        painelJanelas.add(disc);    //adiciona o objeto disc ao container desktop. O form é exibido
    }//GEN-LAST:event_mnuNovaVendaActionPerformed

    private void mnuClientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuClientsActionPerformed
        frmUsuarioClientePainel disc = new frmUsuarioClientePainel(); //instancia objeto da classe
        disc.setVisible(true);	//define que a interface gráfica será visivel
        painelJanelas.add(disc);    //adiciona o objeto disc ao container desktop. O form é exibido
    }//GEN-LAST:event_mnuClientsActionPerformed

    private void mnuAdicionarEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAdicionarEstoqueActionPerformed
        frmEstoque disc = new frmEstoque(this.loggedUser); //instancia objeto da classe
        disc.setVisible(true);	//define que a interface gráfica será visivel
        painelJanelas.add(disc);    //adiciona o objeto disc ao container desktop. O form é exibido
    }//GEN-LAST:event_mnuAdicionarEstoqueActionPerformed

    private void mnuCadastrarLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCadastrarLojaActionPerformed
        frmLojasPainel disc = new frmLojasPainel(); //instancia objeto da classe
        disc.setVisible(true);	//define que a interface gráfica será visivel
        painelJanelas.add(disc);    //adiciona o objeto disc ao container desktop. O form é exibido
    }//GEN-LAST:event_mnuCadastrarLojaActionPerformed

    private void mnuCadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCadastrarProdutoActionPerformed
        frmProdutoCadastrar disc = new frmProdutoCadastrar(); //instancia objeto da classe
        disc.setVisible(true);	//define que a interface gráfica será visivel
        painelJanelas.add(disc);    //adiciona o objeto disc ao container desktop. O form é exibido
    }//GEN-LAST:event_mnuCadastrarProdutoActionPerformed

    private void mnuAlterarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAlterarProdutoActionPerformed
        frmProdutoConsultar disc = new frmProdutoConsultar(); //instancia objeto da classe
        disc.setVisible(true);	//define que a interface gráfica será visivel
        painelJanelas.add(disc);    //adiciona o objeto disc ao container desktop. O form é exibido
    }//GEN-LAST:event_mnuAlterarProdutoActionPerformed

    private void mnuCadastrarTransportadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCadastrarTransportadoraActionPerformed
        frmTransportadoraCadastrar disc = new frmTransportadoraCadastrar(); //instancia objeto da classe
        disc.setVisible(true);	//define que a interface gráfica será visivel
        painelJanelas.add(disc);    //adiciona o objeto disc ao container desktop. O form é exibido
    }//GEN-LAST:event_mnuCadastrarTransportadoraActionPerformed

    private void mnuAlterarTransportadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAlterarTransportadoraActionPerformed
        frmTransportadoraConsultar disc = new frmTransportadoraConsultar(); //instancia objeto da classe
        disc.setVisible(true);	//define que a interface gráfica será visivel
        painelJanelas.add(disc);    //adiciona o objeto disc ao container desktop. O form é exibido
    }//GEN-LAST:event_mnuAlterarTransportadoraActionPerformed

    private void mnuGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuGerarRelatorioActionPerformed
        frmRelatorios disc = new frmRelatorios();
        disc.setVisible(true);
        painelJanelas.add(disc);
    }//GEN-LAST:event_mnuGerarRelatorioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }
    
    public void configuraAparenciaWindows() {
    try {
      UIManager.setLookAndFeel(
        UIManager.getSystemLookAndFeelClassName());
    } catch(Exception e){
       }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar menuBarra;
    private javax.swing.JMenu menuProdutos;
    private javax.swing.JMenu menuRelatorios;
    private javax.swing.JMenu menuSistemas;
    private javax.swing.JMenu menuTransportadora;
    private javax.swing.JMenu menuVendas;
    private javax.swing.JMenuItem mnuAdicionarEstoque;
    private javax.swing.JMenuItem mnuAlterarProduto;
    private javax.swing.JMenuItem mnuAlterarTransportadora;
    private javax.swing.JMenuItem mnuCadastrarLoja;
    private javax.swing.JMenuItem mnuCadastrarProduto;
    private javax.swing.JMenuItem mnuCadastrarTransportadora;
    private javax.swing.JMenuItem mnuClients;
    private javax.swing.JMenuItem mnuGerarRelatorio;
    private javax.swing.JMenuItem mnuNovaVenda;
    private javax.swing.JMenuItem mnuSingInUserSeller;
    private javax.swing.JDesktopPane painelJanelas;
    // End of variables declaration//GEN-END:variables
}
