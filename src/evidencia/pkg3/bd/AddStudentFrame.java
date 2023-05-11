package evidencia.pkg3.bd;

import evidencia.pkg3.bd.CustomLists.Alumnos.Alumno;
import java.util.ArrayList;
import java.util.Date;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Ricardo
 */
public class AddStudentFrame extends javax.swing.JFrame {

    /**
     * Creates new form AddFrame
     */
    Conexion conn;
    HomeFrame frm;

    public AddStudentFrame(Conexion conexion, HomeFrame frame) {
        initComponents();

        conn = conexion;
        frm = frame;
        ArrayList<Document> carreras = conn.getAllCareerData();

        if (!carreras.isEmpty()) {
            addCareerBtn.setText("+");
            addCareerBtn.setSize(30, 25);
            careerCB.setVisible(true);
            for (Document carrera : carreras) {
                careerCB.addItem(carrera.getString("carrera"));
            }
        } else {
            addCareerBtn.setText("Agregar carrera");
            addCareerBtn.setSize(270, 25);
            careerCB.setVisible(false);
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cancelBtn = new javax.swing.JButton();
        addStudentBtn = new javax.swing.JButton();
        studentNameTF = new javax.swing.JTextField();
        studentLNTF = new javax.swing.JTextField();
        statusCB = new javax.swing.JComboBox<>();
        birthDP = new com.github.lgooddatepicker.components.DatePicker();
        careerCB = new javax.swing.JComboBox<>();
        addCareerBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(380, 265));
        setMinimumSize(new java.awt.Dimension(400, 325));
        setSize(new java.awt.Dimension(380, 265));

        jLabel1.setFont(new java.awt.Font("Space Grotesk Light", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agregar estudiante");

        jLabel2.setFont(new java.awt.Font("Space Grotesk Light", 0, 14)); // NOI18N
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Space Grotesk Light", 0, 14)); // NOI18N
        jLabel3.setText("Apellidos");

        jLabel4.setFont(new java.awt.Font("Space Grotesk Light", 0, 14)); // NOI18N
        jLabel4.setText("Fecha de nacimiento");

        jLabel5.setFont(new java.awt.Font("Space Grotesk Light", 0, 14)); // NOI18N
        jLabel5.setText("Carrera");

        jLabel6.setFont(new java.awt.Font("Space Grotesk Light", 0, 14)); // NOI18N
        jLabel6.setText("Estatus");

        cancelBtn.setFont(new java.awt.Font("Space Grotesk Light", 1, 14)); // NOI18N
        cancelBtn.setText("Cancelar");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        addStudentBtn.setFont(new java.awt.Font("Space Grotesk Light", 1, 14)); // NOI18N
        addStudentBtn.setText("Agregar");
        addStudentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentBtnActionPerformed(evt);
            }
        });

        studentNameTF.setFont(new java.awt.Font("Space Grotesk Light", 0, 14)); // NOI18N

        studentLNTF.setFont(new java.awt.Font("Space Grotesk Light", 0, 14)); // NOI18N

        statusCB.setFont(new java.awt.Font("Space Grotesk Light", 0, 14)); // NOI18N
        statusCB.setMaximumRowCount(2);
        statusCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inscrito", "No Inscrito" }));

        birthDP.setFont(new java.awt.Font("Space Grotesk Light", 0, 14)); // NOI18N

        careerCB.setMaximumRowCount(30);
        careerCB.setFont(new java.awt.Font("Space Grotesk Light", 0, 14)); // NOI18N
        careerCB.setMaximumSize(null);
        careerCB.setMinimumSize(null);
        careerCB.setPreferredSize(null);

        addCareerBtn.setText("+");
        addCareerBtn.setFont(new java.awt.Font("Space Grotesk Light", 0, 14)); // NOI18N
        addCareerBtn.setMaximumSize(null);
        addCareerBtn.setMinimumSize(null);
        addCareerBtn.setPreferredSize(new java.awt.Dimension(30, 25));
        addCareerBtn.setRolloverEnabled(false);
        addCareerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCareerBtnActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(birthDP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(studentNameTF, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(studentLNTF, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(statusCB, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(6, 6, 6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(careerCB, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addCareerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                                .addContainerGap())))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addStudentBtn)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(studentNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(studentLNTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(birthDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(careerCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addCareerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(statusCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn)
                    .addComponent(addStudentBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void addCareerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCareerBtnActionPerformed
        // TODO add your handling code here:
        AddCareerFrame deptFrm = new AddCareerFrame(conn, this);
        deptFrm.pack();
        deptFrm.setLocationRelativeTo(null);
        deptFrm.setVisible(true);
    }//GEN-LAST:event_addCareerBtnActionPerformed

    private void addStudentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentBtnActionPerformed
        // TODO add your handling code here:
        String nombre = studentNameTF.getText();
        String apellidos = studentLNTF.getText();
        ObjectId carrera = conn.getIdCareerData(careerCB.getItemAt(careerCB.getSelectedIndex()));
        Date fechaNacimiento = new Fechas().formatDate(birthDP.getDate().toString());
        ObjectId estatus = conn.getIdStatusData(statusCB.getItemAt(statusCB.getSelectedIndex()));

        if (fechaNacimiento != null) {
            Document student = new Document();
            student.append("nombre", nombre);
            student.append("apellidos", apellidos);
            student.append("carrera", carrera);
            student.append("fechaNacimiento", fechaNacimiento);
            student.append("estatus", estatus);

            if (conn.addStudentData(student, null)) {
                this.dispose();

                ArrayList<Document> careers = conn.getAllCareerData();
                if (!careers.isEmpty() && frm != null) {
                    frm.alumnosList.addItem(new Alumno(nombre + " " + apellidos, careerCB.getItemAt(careerCB.getSelectedIndex()), statusCB.getItemAt(statusCB.getSelectedIndex())));
                }
            }
        }
    }//GEN-LAST:event_addStudentBtnActionPerformed

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
            java.util.logging.Logger.getLogger(AddStudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddStudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddStudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddStudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddStudentFrame(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton addCareerBtn;
    private javax.swing.JButton addStudentBtn;
    private com.github.lgooddatepicker.components.DatePicker birthDP;
    private javax.swing.JButton cancelBtn;
    public javax.swing.JComboBox<String> careerCB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox<String> statusCB;
    private javax.swing.JTextField studentLNTF;
    private javax.swing.JTextField studentNameTF;
    // End of variables declaration//GEN-END:variables
}
