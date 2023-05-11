package evidencia.pkg3.bd;

import evidencia.pkg3.bd.CustomLists.Alumnos.Alumno;
import evidencia.pkg3.bd.CustomLists.Carreras.Carrera;
import evidencia.pkg3.bd.CustomLists.Departamentos.Departamento;
import evidencia.pkg3.bd.CustomLists.Estatus.Estatus;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.event.ChangeEvent;
import org.bson.Document;

/**
 *
 * @author Ricardo
 */
public class HomeFrame extends javax.swing.JFrame {

    /**
     * Creates new form HomeFrame
     */
    Conexion conn;

    public HomeFrame(Conexion conexion) {
        super("Pantalla principal");
        initComponents();

        // Variable para estar conectado con MongoDB
        conn = conexion;

        // Cada vez que cambiamos de Tab actualizamos la información
        tabsPanel.addChangeListener((ChangeEvent e) -> {
            // Cargamos la informacion según la Tab en la que nos encontremos
            switch (tabsPanel.getSelectedIndex()) {
                case 0 -> {// Alumnos
                    // Leemos todos los alumnos que esten en la BD
                    ArrayList<Document> alumnos = conn.getAllStudentData();
                    
                    // Vaciamos la lista para no repetir elementos
                    alumnosList.removeAllItem();
                    
                    // Si tenemos alumnos los pintamos en pantalla
                    if (!alumnos.isEmpty()) {
                        for (Document alumno : alumnos) {
                            String nombre = alumno.getString("nombre") + " " + alumno.getString("apellidos");
                            String carrera = conn.getCareerData(alumno.getObjectId("carrera"));
                            String estatus = conn.getStatusData(alumno.getObjectId("estatus"));
                            alumnosList.addItem(new Alumno(nombre, carrera, estatus));
                        }
                    } else {// Si no, decimos que la lista esta vacia
                    }
                }
                case 1 -> {// Carreras
                    // Leemos todos los alumnos que esten en la BD
                    ArrayList<Document> carerras = conn.getAllCareerData();
                    
                    // Vaciamos la lista para no repetir elementos
                    careerList.removeAllItem();
                    
                    // Si tenemos alumnos los pintamos en pantalla
                    if (!carerras.isEmpty()) {
                        for (Document carrera : carerras) {
                            String career = carrera.getString("carrera");
                            String descripcion = carrera.getString("descripcion");
                            String dept = conn.getDeptData(carrera.getObjectId("departamento"));
                            careerList.addItem(new Carrera(career, descripcion, dept));
                        }
                    } else {// Si no, decimos que la lista esta vacia
                    }
                }
                case 2 -> {// Departamentos
                    // Leemos todos los departamentos que esten en la BD
                    ArrayList<Document> depts = conn.getAllDeptData();
                    
                    deptList.removeAllItem();
                    
                    // Si tenemos departamentos los pintamos en pantalla
                    if (!depts.isEmpty()) {
                        for (Document dept : depts) {
                            deptList.addItem(new Departamento(dept.getString("departamento")));
                        }
                    } else {// Si no, decimos que la lista esta vacia
                    }
                }
                case 3 -> {// Estatus
                    // Leemos todos los departamentos que esten en la BD
                    ArrayList<Document> status = conn.getAllStatusData();
                    
                    estatusList.removeAllItem();
                    
                    // Si tenemos departamentos los pintamos en pantalla
                    if (!status.isEmpty()) {
                        for (Document estatus : status) {
                            estatusList.addItem(new Estatus(estatus.getString("estatus")));
                        }
                    } else {// Si no, decimos que la lista esta vacia
                    }
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabsPanel = new javax.swing.JTabbedPane();
        alumnosPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        alumnosList = new evidencia.pkg3.bd.CustomLists.Alumnos.AlumnosList<>();
        carrerasPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        careerList = new evidencia.pkg3.bd.CustomLists.Carreras.CarrerasList<>();
        departamentosPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        deptList = new evidencia.pkg3.bd.CustomLists.Departamentos.DepartamentosList<>();
        estatusPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        estatusList = new evidencia.pkg3.bd.CustomLists.Estatus.EstatusList<>();
        logoutBtn = new javax.swing.JButton();
        deleteDataBtn = new javax.swing.JButton();
        addDataBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(640, 480));
        setMinimumSize(new java.awt.Dimension(640, 480));

        tabsPanel.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tabsPanel.setFont(new java.awt.Font("Space Grotesk Light", 1, 18)); // NOI18N

        alumnosList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(alumnosList);

        javax.swing.GroupLayout alumnosPanelLayout = new javax.swing.GroupLayout(alumnosPanel);
        alumnosPanel.setLayout(alumnosPanelLayout);
        alumnosPanelLayout.setHorizontalGroup(
            alumnosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alumnosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                .addContainerGap())
        );
        alumnosPanelLayout.setVerticalGroup(
            alumnosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alumnosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabsPanel.addTab("Alumnos", alumnosPanel);

        careerList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(careerList);

        javax.swing.GroupLayout carrerasPanelLayout = new javax.swing.GroupLayout(carrerasPanel);
        carrerasPanel.setLayout(carrerasPanelLayout);
        carrerasPanelLayout.setHorizontalGroup(
            carrerasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carrerasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                .addContainerGap())
        );
        carrerasPanelLayout.setVerticalGroup(
            carrerasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carrerasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabsPanel.addTab("Carreras", carrerasPanel);

        deptList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(deptList);

        javax.swing.GroupLayout departamentosPanelLayout = new javax.swing.GroupLayout(departamentosPanel);
        departamentosPanel.setLayout(departamentosPanelLayout);
        departamentosPanelLayout.setHorizontalGroup(
            departamentosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(departamentosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                .addContainerGap())
        );
        departamentosPanelLayout.setVerticalGroup(
            departamentosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, departamentosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabsPanel.addTab("Departamentos", departamentosPanel);

        jScrollPane4.setViewportView(estatusList);

        javax.swing.GroupLayout estatusPanelLayout = new javax.swing.GroupLayout(estatusPanel);
        estatusPanel.setLayout(estatusPanelLayout);
        estatusPanelLayout.setHorizontalGroup(
            estatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(estatusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                .addContainerGap())
        );
        estatusPanelLayout.setVerticalGroup(
            estatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(estatusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabsPanel.addTab("Estatus", estatusPanel);

        logoutBtn.setFont(new java.awt.Font("Space Grotesk Light", 1, 18)); // NOI18N
        logoutBtn.setText("Cerrar sesión");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        deleteDataBtn.setFont(new java.awt.Font("Space Grotesk Light", 1, 18)); // NOI18N
        deleteDataBtn.setText("Dar de baja");

        addDataBtn.setFont(new java.awt.Font("Space Grotesk Light", 1, 18)); // NOI18N
        addDataBtn.setText("Dar de alta");
        addDataBtn.setToolTipText("");
        addDataBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDataBtnActionPerformed(evt);
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
                        .addComponent(logoutBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                        .addComponent(deleteDataBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addDataBtn))
                    .addComponent(tabsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabsPanel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutBtn)
                    .addComponent(addDataBtn)
                    .addComponent(deleteDataBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Accion general de realizar la desconexión de la aplicacion, volviendo a LoginFrame
    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // Se cierra el frame actual y se desconecta de la base de datos
        this.dispose();
        conn.client.close();

        // Se crea y abre el nuevo Frame
        LoginFrame frm = new LoginFrame();
        frm.pack();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_logoutBtnActionPerformed

    // Acción general de agregar datos a la MongoDB, dependiendo en que tab se este
    private void addDataBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDataBtnActionPerformed
        // Declaración de los posibles casos de Tab donde pueda estar el usuario
        switch (tabsPanel.getSelectedIndex()) {
            case 0 -> {// Alumnos
                AddStudentFrame frm = new AddStudentFrame(conn, this);
                frm.pack();
                frm.setLocationRelativeTo(null);
                frm.setVisible(true);
            }
            case 1 -> {// Carreras
                AddCareerFrame frm = new AddCareerFrame(conn, null, this);
                frm.pack();
                frm.setLocationRelativeTo(null);
                frm.setVisible(true);
            }
            case 2 -> {// Departamentos
                AddDeptFrame deptFrm = new AddDeptFrame(conn, null, this);
                deptFrm.pack();
                deptFrm.setLocationRelativeTo(null);
                deptFrm.setVisible(true);
            }
            case 3 -> {// Estatus
                AddStatusFrame deptFrm = new AddStatusFrame(conn, this);
                deptFrm.pack();
                deptFrm.setLocationRelativeTo(null);
                deptFrm.setVisible(true);
            }
        }
    }//GEN-LAST:event_addDataBtnActionPerformed

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
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeFrame(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDataBtn;
    public evidencia.pkg3.bd.CustomLists.Alumnos.AlumnosList<String> alumnosList;
    private javax.swing.JPanel alumnosPanel;
    public evidencia.pkg3.bd.CustomLists.Carreras.CarrerasList<String> careerList;
    public javax.swing.JPanel carrerasPanel;
    private javax.swing.JButton deleteDataBtn;
    private javax.swing.JPanel departamentosPanel;
    public evidencia.pkg3.bd.CustomLists.Departamentos.DepartamentosList<String> deptList;
    public evidencia.pkg3.bd.CustomLists.Estatus.EstatusList<String> estatusList;
    private javax.swing.JPanel estatusPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JTabbedPane tabsPanel;
    // End of variables declaration//GEN-END:variables
}
