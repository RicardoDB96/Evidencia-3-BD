package evidencia.pkg3.bd;

import evidencia.pkg3.bd.CustomLists.Carreras.Carrera;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Ricardo
 */
public class AddCareerFrame extends javax.swing.JFrame {

    /**
     * Creates new form AddCareerFrame
     */
    Conexion conn;

    AddStudentFrame frm;
    HomeFrame home;
    EditStudentFrame edit;

    public AddCareerFrame(Conexion conexion, AddStudentFrame frame, HomeFrame homeFrm, EditStudentFrame editar) {
        initComponents();

        conn = conexion;
        frm = frame;
        home = homeFrm;
        edit = editar;

        ArrayList<Document> depts = conn.getAllDeptData();

        if (!depts.isEmpty()) {
            addDeptBtn.setText("+");
            addDeptBtn.setSize(30, 25);
            deptCB.setVisible(true);
            for (Document dept : depts) {
                deptCB.addItem(dept.getString("departamento"));
            }
        } else {
            addDeptBtn.setText("Agregar departamento");
            addDeptBtn.setSize(276, 25);
            deptCB.setVisible(false);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        carreraTF = new javax.swing.JTextField();
        descripcionTF = new javax.swing.JTextField();
        deptCB = new javax.swing.JComboBox<>();
        cancelBtn = new javax.swing.JButton();
        addCareerBtn = new javax.swing.JButton();
        addDeptBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(395, 200));
        setMinimumSize(new java.awt.Dimension(420, 250));
        setSize(new java.awt.Dimension(395, 200));

        jLabel1.setFont(new java.awt.Font("Space Grotesk Light", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agregar carrera");

        jLabel2.setFont(new java.awt.Font("Space Grotesk Light", 0, 14)); // NOI18N
        jLabel2.setText("Carrera");

        jLabel3.setFont(new java.awt.Font("Space Grotesk Light", 0, 14)); // NOI18N
        jLabel3.setText("Descripción");

        jLabel4.setFont(new java.awt.Font("Space Grotesk Light", 0, 14)); // NOI18N
        jLabel4.setText("Departamento");

        carreraTF.setFont(new java.awt.Font("Space Grotesk Light", 0, 14)); // NOI18N

        descripcionTF.setFont(new java.awt.Font("Space Grotesk Light", 0, 14)); // NOI18N

        deptCB.setFont(new java.awt.Font("Space Grotesk Light", 0, 14)); // NOI18N
        deptCB.setMaximumRowCount(30);
        deptCB.setMaximumSize(null);
        deptCB.setMinimumSize(null);
        deptCB.setPreferredSize(new java.awt.Dimension(235, 25));
        deptCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deptCBActionPerformed(evt);
            }
        });

        cancelBtn.setFont(new java.awt.Font("Space Grotesk Light", 1, 14)); // NOI18N
        cancelBtn.setText("Cancelar");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        addCareerBtn.setFont(new java.awt.Font("Space Grotesk Light", 1, 14)); // NOI18N
        addCareerBtn.setText("Agregar");
        addCareerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCareerBtnActionPerformed(evt);
            }
        });

        addDeptBtn.setFont(new java.awt.Font("Space Grotesk Light", 0, 14)); // NOI18N
        addDeptBtn.setText("+");
        addDeptBtn.setMaximumSize(new java.awt.Dimension(30, 25));
        addDeptBtn.setMinimumSize(null);
        addDeptBtn.setPreferredSize(new java.awt.Dimension(30, 25));
        addDeptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDeptBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                        .addComponent(addCareerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(carreraTF)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(deptCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addDeptBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(descripcionTF))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(carreraTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(descripcionTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(deptCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addDeptBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn)
                    .addComponent(addCareerBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addDeptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDeptBtnActionPerformed
        // TODO add your handling code here:
        AddDeptFrame deptFrm = new AddDeptFrame(conn, this, null);
        deptFrm.pack();
        deptFrm.setLocationRelativeTo(null);
        deptFrm.setVisible(true);
    }//GEN-LAST:event_addDeptBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void addCareerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCareerBtnActionPerformed
        // TODO add your handling code here:
        String carerra = carreraTF.getText();
        String descripcion = descripcionTF.getText();
        ObjectId departamento = conn.getDeptData(deptCB.getItemAt(deptCB.getSelectedIndex()));
        String dept = deptCB.getItemAt(deptCB.getSelectedIndex());

        Document career = new Document();
        career.append("carrera", carerra);
        career.append("descripcion", descripcion);
        career.append("departamento", departamento);

        if (conn.addCareerData(career, null)) {
            this.dispose();

            ArrayList<Document> careers = conn.getAllCareerData();

            //Checamos que tengamos documentos en la lista
            if (!careers.isEmpty()) {
                // Caso que la pantalla anterior sea el AddCareerFrame
                if (frm != null) {
                    frm.addCareerBtn.setText("+");
                    frm.careerCB.addItem(carerra);
                    frm.careerCB.setVisible(true);
                }

                // Caso que la pantalla anterior sea el HomeFrame
                if (home != null) {
                    home.careerList.addItem(new Carrera(carerra, descripcion, dept));
                }
            }
        }
    }//GEN-LAST:event_addCareerBtnActionPerformed

    private void deptCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deptCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deptCBActionPerformed

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
            java.util.logging.Logger.getLogger(AddCareerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCareerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCareerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCareerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCareerFrame(null, null, null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCareerBtn;
    public javax.swing.JButton addDeptBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextField carreraTF;
    public javax.swing.JComboBox<String> deptCB;
    private javax.swing.JTextField descripcionTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
