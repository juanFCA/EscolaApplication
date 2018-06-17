/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author juan
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnArquivo = new javax.swing.JMenu();
        mniSair = new javax.swing.JMenuItem();
        mnTurma = new javax.swing.JMenu();
        mniCadasTur = new javax.swing.JMenuItem();
        mniRelTur = new javax.swing.JMenuItem();
        mnAluno = new javax.swing.JMenu();
        mniCadasAlu = new javax.swing.JMenuItem();
        mniRelAlu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Escola DJJL");

        mnArquivo.setText("Arquivo");

        mniSair.setText("Sair");
        mniSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSairActionPerformed(evt);
            }
        });
        mnArquivo.add(mniSair);

        jMenuBar1.add(mnArquivo);

        mnTurma.setText("Turma");

        mniCadasTur.setText("Cadastro");
        mniCadasTur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCadasTurActionPerformed(evt);
            }
        });
        mnTurma.add(mniCadasTur);

        mniRelTur.setText("Relatorio");
        mnTurma.add(mniRelTur);

        jMenuBar1.add(mnTurma);

        mnAluno.setText("Aluno");

        mniCadasAlu.setText("Cadastro");
        mniCadasAlu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCadasAluActionPerformed(evt);
            }
        });
        mnAluno.add(mniCadasAlu);

        mniRelAlu.setText("Relatorio");
        mnAluno.add(mniRelAlu);

        jMenuBar1.add(mnAluno);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSairActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_mniSairActionPerformed

    private void mniCadasTurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCadasTurActionPerformed
        // TODO add your handling code here:
        Turma turma = new Turma();
        this.desktopPane.add(turma);
        turma.setVisible(true);
        turma.setPosicao();
    }//GEN-LAST:event_mniCadasTurActionPerformed

    private void mniCadasAluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCadasAluActionPerformed
        // TODO add your handling code here:
        Aluno aluno = new Aluno();
        this.desktopPane.add(aluno);
        aluno.setVisible(true);
        aluno.setPosicao();
    }//GEN-LAST:event_mniCadasAluActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mnAluno;
    private javax.swing.JMenu mnArquivo;
    private javax.swing.JMenu mnTurma;
    private javax.swing.JMenuItem mniCadasAlu;
    private javax.swing.JMenuItem mniCadasTur;
    private javax.swing.JMenuItem mniRelAlu;
    private javax.swing.JMenuItem mniRelTur;
    private javax.swing.JMenuItem mniSair;
    // End of variables declaration//GEN-END:variables
}
