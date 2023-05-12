package evidencia.pkg3.bd;

import evidencia.pkg3.bd.CustomLists.Alumnos.Alumno;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Ricardo
 */
public class StudentInfoFrame extends javax.swing.JFrame {

    /**
     * Creates new form StudentInfoFrame
     * @param id
     */
    
    ObjectId id;
    Conexion conn;
    Document student;
    HomeFrame home;
    
    public StudentInfoFrame(ObjectId ID, Conexion conexion, HomeFrame frm) {
        initComponents();
        id = ID;
        conn = conexion;
        home = frm;
        
        student = conn.getStudentData(id);
        
        // Poner la información obligatoria del Alumno en las etiquetas
        studentName.setText(student.getString("nombre"));
        studentLN.setText(student.getString("apellidos"));
        studentBirth.setText(new Fechas().formatLocalDate(student.getString("fechaNacimiento")).toString());
        studentCareer.setText(conn.getCareerData(student.getObjectId("carrera")));
        studentStatus.setText(conn.getStatusData(student.getObjectId("estatus")));
        
        // Poner la información optativa del alumno en las etiquetas
        
        String correo = student.getString("email");
        if (!"".equals(correo)) {
            studentEmail.setText(correo);
            email.setVisible(true);
            studentEmail.setVisible(true);
        } else {
            email.setVisible(false);
            studentEmail.setVisible(false);
        }
        
        
        String telefono = student.getString("telefono");
        System.out.println(!"".equals(telefono));
        if (!"".equals(telefono)) {
            studentPhone.setText(telefono);
            phone.setVisible(true);
            studentPhone.setVisible(true);
        } else {
            phone.setVisible(false);
            studentPhone.setVisible(false);
        }
        
        
        
        String direccion = student.getString("direccion");
        if (!"".equals(direccion)) {
            studentAddress.setText(direccion);
            address.setVisible(true);
            studentAddress.setVisible(true);
        } else {
            address.setVisible(false);
            studentAddress.setVisible(false);
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
        studentName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        studentLN = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        studentBirth = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        studentCareer = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        studentStatus = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        studentEmail = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        studentAddress = new javax.swing.JLabel();
        studentPhone = new javax.swing.JLabel();
        phone = new javax.swing.JLabel();
        cancelBtn = new javax.swing.JButton();
        deleteStudentBtn = new javax.swing.JButton();
        editStudentBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Space Grotesk Light", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Información del alumno");

        jLabel2.setFont(new java.awt.Font("Space Grotesk Light", 1, 16)); // NOI18N
        jLabel2.setText("Nombre");

        studentName.setFont(new java.awt.Font("Space Grotesk Light", 0, 14)); // NOI18N
        studentName.setText("Nombre del alumno");

        jLabel4.setFont(new java.awt.Font("Space Grotesk Light", 1, 16)); // NOI18N
        jLabel4.setText("Apellidos");

        studentLN.setFont(new java.awt.Font("Space Grotesk Light", 0, 14)); // NOI18N
        studentLN.setText("Apellidos del alumno");

        jLabel6.setFont(new java.awt.Font("Space Grotesk Light", 1, 16)); // NOI18N
        jLabel6.setText("Fecha de nacimiento");

        studentBirth.setFont(new java.awt.Font("Space Grotesk Light", 0, 14)); // NOI18N
        studentBirth.setText("Fecha de nacimiento del alumno");

        email.setFont(new java.awt.Font("Space Grotesk Light", 1, 16)); // NOI18N
        email.setText("Email");

        studentCareer.setFont(new java.awt.Font("Space Grotesk Light", 0, 14)); // NOI18N
        studentCareer.setText("Carrera del alumno");

        jLabel10.setFont(new java.awt.Font("Space Grotesk Light", 1, 16)); // NOI18N
        jLabel10.setText("Carrera");

        studentStatus.setFont(new java.awt.Font("Space Grotesk Light", 0, 14)); // NOI18N
        studentStatus.setText("Estatus del alumno");

        jLabel12.setFont(new java.awt.Font("Space Grotesk Light", 1, 16)); // NOI18N
        jLabel12.setText("Estatus");

        studentEmail.setFont(new java.awt.Font("Space Grotesk Light", 0, 14)); // NOI18N
        studentEmail.setText("Email del alumno");

        address.setFont(new java.awt.Font("Space Grotesk Light", 1, 16)); // NOI18N
        address.setText("Dirección");

        studentAddress.setFont(new java.awt.Font("Space Grotesk Light", 0, 14)); // NOI18N
        studentAddress.setText("Dirección del alumno");

        studentPhone.setFont(new java.awt.Font("Space Grotesk Light", 0, 14)); // NOI18N
        studentPhone.setText("Telefono del alumno");

        phone.setFont(new java.awt.Font("Space Grotesk Light", 1, 16)); // NOI18N
        phone.setText("Teléfono");

        cancelBtn.setFont(new java.awt.Font("Space Grotesk Light", 1, 14)); // NOI18N
        cancelBtn.setText("Cancelar");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        deleteStudentBtn.setFont(new java.awt.Font("Space Grotesk Light", 1, 14)); // NOI18N
        deleteStudentBtn.setText("Dar de baja");
        deleteStudentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteStudentBtnActionPerformed(evt);
            }
        });

        editStudentBtn.setFont(new java.awt.Font("Space Grotesk Light", 1, 14)); // NOI18N
        editStudentBtn.setText("Modificar");
        editStudentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editStudentBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studentName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studentLN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studentBirth, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studentCareer, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studentStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studentEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(address, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studentPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(phone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studentAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteStudentBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editStudentBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentLN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentBirth)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentCareer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(email)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(phone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentPhone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(address)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentAddress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn)
                    .addComponent(editStudentBtn)
                    .addComponent(deleteStudentBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteStudentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteStudentBtnActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showOptionDialog(null, "¿Deseas dar de baja al alumno?", "COnfirmación de baja",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

        if (option == JOptionPane.YES_OPTION) {
            // Se borra el alumno
            if (conn.deleteStudentData(id)) {
                this.dispose();
                
                ArrayList<Document> students = conn.getAllStudentData();
                System.out.println(home);
                if (!students.isEmpty() && home != null) {
                    if (home != null) {
                        home.alumnosList.removeAllItem();
                    
                        for (Document alumno : students) {
                            ObjectId stundetId = alumno.getObjectId("_id");
                            String nombre = alumno.getString("nombre");
                            String apellidos = alumno.getString("apellidos");
                            String career = conn.getCareerData(alumno.getObjectId("carrera"));
                            String status = conn.getStatusData(alumno.getObjectId("estatus"));
                            home.alumnosList.addItem(new Alumno(stundetId, conn, home, nombre, apellidos, new Date(), career, status));
                        }
                    }
                } else {
                    home.alumnosList.removeAllItem();
                }
            }
        } else {
            // Opcion no
            System.out.println("Se cancelo la baja del alumno");
        }
        
    }//GEN-LAST:event_deleteStudentBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void editStudentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editStudentBtnActionPerformed
        // TODO add your handling code here:
        EditStudentFrame frm = new EditStudentFrame(id, conn, home, this);
        frm.pack();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_editStudentBtnActionPerformed

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
            java.util.logging.Logger.getLogger(StudentInfoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentInfoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentInfoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentInfoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentInfoFrame(null, null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel address;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton deleteStudentBtn;
    private javax.swing.JButton editStudentBtn;
    public javax.swing.JLabel email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    public javax.swing.JLabel phone;
    public javax.swing.JLabel studentAddress;
    public javax.swing.JLabel studentBirth;
    public javax.swing.JLabel studentCareer;
    public javax.swing.JLabel studentEmail;
    public javax.swing.JLabel studentLN;
    public javax.swing.JLabel studentName;
    public javax.swing.JLabel studentPhone;
    public javax.swing.JLabel studentStatus;
    // End of variables declaration//GEN-END:variables
}
