package evidencia.pkg3.bd;

import evidencia.pkg3.bd.CustomLists.Carreras.Carrera;
import evidencia.pkg3.bd.CustomLists.Departamentos.Departamento;
import evidencia.pkg3.bd.CustomLists.Estatus.Estatus;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author Ricardo
 */
public class DeleteWKeyFrame extends javax.swing.JFrame {

    /**
     * Creates new form DeleteWKeyFrame
     * @param tab
     * @param home
     */
    Conexion conn;
    int tab;
    HomeFrame home;
    
    public DeleteWKeyFrame(Conexion conexion, int tabIndex, HomeFrame frm) {
        initComponents();
        conn = conexion;
        tab = tabIndex;
        home = frm;
        
        // Ocultamos el error
        errorL.setVisible(false);
        
        // Cambiamos los textos 
        switch (tab) {
            case 1 -> {// Carrera
                titleLabel.setText("Dar de baja carrera");
                collLabel.setText("Carrera");
            }
            case 2 -> {// Departamento
                titleLabel.setText("Dar de baja departamento");
                collLabel.setText("Departamento");
            }
            case 3 -> {//Estatus
                titleLabel.setText("Dar de baja estatus");
                collLabel.setText("Estatus");
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        collLabel = new javax.swing.JLabel();
        keyTF = new javax.swing.JTextField();
        errorL = new javax.swing.JLabel();
        cancelBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(375, 180));
        setPreferredSize(new java.awt.Dimension(400, 175));

        titleLabel.setFont(new java.awt.Font("Space Grotesk Light", 1, 18)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Dar de baja _");

        collLabel.setFont(new java.awt.Font("Space Grotesk Light", 0, 14)); // NOI18N
        collLabel.setText("_");

        keyTF.setFont(new java.awt.Font("Space Grotesk Light", 0, 14)); // NOI18N

        errorL.setFont(new java.awt.Font("Space Grotesk Light", 1, 12)); // NOI18N
        errorL.setForeground(new java.awt.Color(255, 0, 0));
        errorL.setText("El _ ingresado no existe");

        cancelBtn.setFont(new java.awt.Font("Space Grotesk Light", 1, 14)); // NOI18N
        cancelBtn.setText("Cancelar");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        deleteBtn.setFont(new java.awt.Font("Space Grotesk Light", 1, 14)); // NOI18N
        deleteBtn.setText("Dar de baja");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(collLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(keyTF))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteBtn))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 219, Short.MAX_VALUE)
                        .addComponent(errorL)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(collLabel)
                    .addComponent(keyTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn)
                    .addComponent(deleteBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // Obtenemos el valor que se intentara eliminar en el documento
        String key = keyTF.getText();
        
        //Checamos en que tab estamos para asi realizar correctamente la operacion
        switch (tab) {
            case 1 -> {// Carrera
                if (conn.deleteCareerData(key, errorL)) {
                    this.dispose();
                    
                    ArrayList<Document> careers = conn.getAllCareerData();
                    home.careerList.removeAllItem();
                    
                    for (Document carrera : careers) {
                        String career = carrera.getString("carrera");
                        String descripcion = carrera.getString("descripcion");
                        String dept = conn.getDeptData(carrera.getObjectId("departamento"));
                        home.careerList.addItem(new Carrera(career, descripcion, dept));
                    }
                }
            }
            case 2 -> {// Departamento
                if (conn.deleteDeptData(key, errorL)) {
                    this.dispose();
                    
                    ArrayList<Document> depts = conn.getAllDeptData();
                    home.deptList.removeAllItem();
                    
                    for (Document dept : depts) {
                        home.deptList.addItem(new Departamento(dept.getString("estatus")));
                    }
                }
            }
            case 3 -> {//Estatus
                if (conn.deleteStatusData(key, errorL)) {
                    this.dispose();
                    
                    ArrayList<Document> status = conn.getAllStatusData();
                    home.estatusList.removeAllItem();
                    
                    for (Document estatus : status) {
                        home.estatusList.addItem(new Estatus(estatus.getString("estatus")));
                    }
                }
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

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
            java.util.logging.Logger.getLogger(DeleteWKeyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteWKeyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteWKeyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteWKeyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeleteWKeyFrame(null, 0, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel collLabel;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel errorL;
    private javax.swing.JTextField keyTF;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
