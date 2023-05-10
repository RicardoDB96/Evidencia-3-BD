package evidencia.pkg3.bd;

import com.mongodb.client.MongoDatabase;
import evidencia.pkg3.bd.Alumnos.Item;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Ricardo
 */
public class AlumnosFrame extends javax.swing.JFrame {

    /**
     * Creates new form AlumnosFrae
     * @param conn
     */
    
    Conexion conn;
    
    public AlumnosFrame(Conexion conexion) {
        super("Alumnos");
        initComponents();
        conn = conexion;
        
        conn.getAllStudentData();
        
        alumnosList.addItem(new Item("Ricardo"));
        alumnosList.addItem(new Item("Diego"));
        alumnosList.addItem(new Item("Marco"));      
        alumnosList.addItem(new Item("Cesar"));    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoutBtn = new javax.swing.JButton();
        studentLabel = new javax.swing.JLabel();
        addStudentBtn = new javax.swing.JButton();
        addCareerBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        alumnosList = new evidencia.pkg3.bd.Alumnos.AlumnosList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        logoutBtn.setFont(new java.awt.Font("Space Grotesk Light", 1, 18)); // NOI18N
        logoutBtn.setText("Cerrar sesión");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        studentLabel.setFont(new java.awt.Font("Space Grotesk Light", 1, 18)); // NOI18N
        studentLabel.setText("Alumnos");

        addStudentBtn.setFont(new java.awt.Font("Space Grotesk Light", 1, 18)); // NOI18N
        addStudentBtn.setText("Agregar alumno");
        addStudentBtn.setToolTipText("");
        addStudentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentBtnActionPerformed(evt);
            }
        });

        addCareerBtn.setFont(new java.awt.Font("Space Grotesk Light", 1, 18)); // NOI18N
        addCareerBtn.setText("Agregar carrera");
        addCareerBtn.setToolTipText("");
        addCareerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCareerBtnActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(alumnosList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logoutBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                        .addComponent(addStudentBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addCareerBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(studentLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(studentLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutBtn)
                    .addComponent(addStudentBtn)
                    .addComponent(addCareerBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void addStudentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentBtnActionPerformed
        // TODO add your handling code here:
        AddStudentFrame frm = new AddStudentFrame(conn);
        frm.pack();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_addStudentBtnActionPerformed

    private void addCareerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCareerBtnActionPerformed
        // TODO add your handling code here:
        AddCareerFrame frm = new AddCareerFrame(conn, null);
        frm.pack();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_addCareerBtnActionPerformed

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
            java.util.logging.Logger.getLogger(AlumnosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlumnosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlumnosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlumnosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlumnosFrame(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCareerBtn;
    private javax.swing.JButton addStudentBtn;
    private evidencia.pkg3.bd.Alumnos.AlumnosList<String> alumnosList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JLabel studentLabel;
    // End of variables declaration//GEN-END:variables
}
