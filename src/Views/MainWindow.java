/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Main.Controller;
import Decode.DuplicatedElement;
import Decode.Tree;
import File.ReadFile;
import File.WriteFile;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import objectssockets.Server;

/**
 *
 * @author andre
 */
public class MainWindow extends javax.swing.JFrame {

    private ReadFile read = new ReadFile();
    private static final int MAX_CHAR = 468;
    private Tree tree = new Tree();
    private Server server;

    public MainWindow() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        fChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        createKeyBt = new javax.swing.JButton();
        loadKeyBt = new javax.swing.JButton();
        exitBt = new javax.swing.JButton();
        connectBt = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("MainWindow");
        setBackground(new java.awt.Color(238, 100, 100));
        setForeground(new java.awt.Color(102, 0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel2.setText("Citara chat");

        createKeyBt.setBackground(new java.awt.Color(153, 113, 203));
        createKeyBt.setForeground(new java.awt.Color(255, 255, 255));
        createKeyBt.setText("Generar llave");
        createKeyBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createKeyBtActionPerformed(evt);
            }
        });

        loadKeyBt.setBackground(new java.awt.Color(153, 113, 203));
        loadKeyBt.setForeground(new java.awt.Color(255, 255, 255));
        loadKeyBt.setText("Cargar llave");
        loadKeyBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadKeyBtActionPerformed(evt);
            }
        });

        exitBt.setBackground(new java.awt.Color(153, 113, 203));
        exitBt.setForeground(new java.awt.Color(255, 255, 255));
        exitBt.setText("Salir");
        exitBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtActionPerformed(evt);
            }
        });

        connectBt.setBackground(new java.awt.Color(153, 113, 203));
        connectBt.setForeground(new java.awt.Color(255, 255, 255));
        connectBt.setText("Conectar");
        connectBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(connectBt, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(173, 183, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(createKeyBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadKeyBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exitBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(203, 203, 203))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(createKeyBt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loadKeyBt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitBt)
                    .addComponent(connectBt))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitBtActionPerformed

    private void connectBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectBtActionPerformed
        try {
            Controller controller = new Controller();
            server = new Server(controller);
            server.runServer();
            this.dispose();
            controller.initializeChat(server, this, true, tree);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_connectBtActionPerformed

    private void createKeyBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createKeyBtActionPerformed
        createKey();
    }//GEN-LAST:event_createKeyBtActionPerformed

    private void loadKeyBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadKeyBtActionPerformed
        fChooser1.setCurrentDirectory(new java.io.File("."));
        int returnVal = fChooser1.showOpenDialog(this);
        fChooser1.setAcceptAllFileFilterUsed(false);
        if (returnVal == fChooser1.APPROVE_OPTION) {
            File file = fChooser1.getSelectedFile();
            readFromTheFile(file);
        } else {
            System.out.println("File access cancelled by user.");
        }

    }//GEN-LAST:event_loadKeyBtActionPerformed

    public void readFromTheFile(File file) {
        try {
            read.open(file);
            readTree();
            read.close();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void readTree() throws IOException, ClassNotFoundException {

        tree = read.readTree();
    }

    public void createKey() {
        try {
            tree.createDictionaryAndTree();
            tree.writeInTheFile(new WriteFile());
        } catch (DuplicatedElement | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connectBt;
    private javax.swing.JButton createKeyBt;
    private javax.swing.JButton exitBt;
    private javax.swing.JFileChooser fChooser1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JButton loadKeyBt;
    // End of variables declaration//GEN-END:variables
}
