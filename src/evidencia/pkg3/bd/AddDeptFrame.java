package evidencia.pkg3.bd;

import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author Ricardo
 */
public class AddDeptFrame extends javax.swing.JFrame {

    /**
     * Creates new form AddDeptFrame
     */
    Conexion conn;
    AddCareerFrame frm;

    public AddDeptFrame(Conexion conexion, AddCareerFrame frame) {
        initComponents();
        conn = conexion;
        frm = frame;
        deptErrorL.setVisible(false);
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
        jLabel2 = new javax.swing.JLabel();
        deptTF = new javax.swing.JTextField();
        cancelBtn = new javax.swing.JButton();
        addDeptBtn = new javax.swing.JButton();
        deptErrorL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(350, 180));
        setPreferredSize(new java.awt.Dimension(350, 175));

        jLabel1.setFont(new java.awt.Font("Space Grotesk Light", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agregar departamento");

        jLabel2.setFont(new java.awt.Font("Space Grotesk Light", 0, 14)); // NOI18N
        jLabel2.setText("Departamento");

        deptTF.setFont(new java.awt.Font("Space Grotesk Light", 0, 14)); // NOI18N

        cancelBtn.setFont(new java.awt.Font("Space Grotesk Light", 1, 14)); // NOI18N
        cancelBtn.setText("Cancelar");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        addDeptBtn.setFont(new java.awt.Font("Space Grotesk Light", 1, 14)); // NOI18N
        addDeptBtn.setText("Agregar");
        addDeptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDeptBtnActionPerformed(evt);
            }
        });

        deptErrorL.setFont(new java.awt.Font("Space Grotesk Light", 1, 12)); // NOI18N
        deptErrorL.setForeground(new java.awt.Color(255, 0, 0));
        deptErrorL.setText("El departamento ingresado ya existe");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deptTF))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addDeptBtn))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 113, Short.MAX_VALUE)
                        .addComponent(deptErrorL)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(deptTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deptErrorL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn)
                    .addComponent(addDeptBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void addDeptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDeptBtnActionPerformed
        // TODO add your handling code here:
        String dept = deptTF.getText();

        Document departamento = new Document();
        departamento.append("departamento", dept);

        // Comprobar que haya escrito algun valor
        if (!"".equals(dept)) {
            deptErrorL.setVisible(false);
            // Comprobar que el insert se realizo exitosamente
            if (conn.addDeptData(departamento, deptErrorL)) {
                this.dispose();

                ArrayList<Document> depts = conn.getAllDeptData();
                if (!depts.isEmpty()) {
                    frm.addDeptBtn.setText("+");
                    frm.deptCB.addItem(dept);
                    frm.deptCB.setVisible(true);
                }
            }
        } else {
            deptErrorL.setText("Debe escribir el nombre de un departamento");
            deptErrorL.setVisible(true);
        }

    }//GEN-LAST:event_addDeptBtnActionPerformed

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
            java.util.logging.Logger.getLogger(AddDeptFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddDeptFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddDeptFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddDeptFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddDeptFrame(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDeptBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel deptErrorL;
    private javax.swing.JTextField deptTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
