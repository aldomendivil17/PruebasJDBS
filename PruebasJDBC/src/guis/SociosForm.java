/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package guis;

import daos.ISociosDAO;
import dominio.Socio;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
/**
 *
 * @author lv1822
 */
public class SociosForm extends javax.swing.JFrame {

    private final ISociosDAO sociosDAO;
    
    
    /**
     * Creates new form SociosForm
     */
    public SociosForm(ISociosDAO sociosDAO) {
        initComponents();
        this.sociosDAO = sociosDAO;
        this.cargarTablaSocios();
    }
    private void guardar(){
        String nombre = this.txtNombre.getText();
        String telefono = this.txtTelefono.getText();
        //VALIDACIONES...
        Socio socio = new Socio(nombre, telefono);
        String datosInvalidos = this.validarAgregar(socio);
        if(datosInvalidos == null){
            int sociosAgregados = this.sociosDAO.agregar(socio);
            if(sociosAgregados == 1){
                JOptionPane.showMessageDialog(this, "Socio agregados correctamente",
                        "Información", JOptionPane.INFORMATION_MESSAGE);
                this.cargarTablaSocios();
            } else{
                JOptionPane.showMessageDialog(this, "No se pudo agregar al socio",
                        "Error", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } else{
           JOptionPane.showMessageDialog(this, datosInvalidos, "Error",
                   JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private String validarAgregar(Socio socio){
        if(socio.getNombre() == null || socio.getNombre().isEmpty()){
            return "Nombre es requerido";
        }
        if(socio.getNombre().length()>100){
            return "El nombre es demasiado largo";
        }
        
        if(socio.getTelefono() == null || socio.getTelefono().isEmpty()){
            return "Telefono es requerido";
        }
        
        if(socio.getTelefono().length()>10){
            return "El telefono es demasiado largo";
        }
        return null;
    }
    
    private void cargarTablaSocios(){
        List<Socio> socios = this.sociosDAO.consultarTodos();
        DefaultTableModel modelo = (DefaultTableModel)this.tblSocios.getModel();
        modelo.setRowCount(0);
        for(Socio socio: socios){
            Object[] fila = new Object[3];
            fila[0] = socio.getId();
            fila[1] = socio.getNombre();
            fila[2] = socio.getTelefono();
            modelo.addRow(fila);
        }
    }
    
    private void verDetalles(){
        int indiceFilaSeleccionada = this.tblSocios.getSelectedRow();
        int indiceColumnaId = 0;
        if(indiceFilaSeleccionada == -1){
            JOptionPane.showMessageDialog(this, "Debes seleccionar un socio",
                    "Información", JOptionPane.WARNING_MESSAGE);
            return;
        }
        DefaultTableModel modelo = (DefaultTableModel)this.tblSocios.getModel();
        long idSocio = (Long)modelo.getValueAt(indiceFilaSeleccionada, indiceColumnaId);
        
        Socio socio = new Socio(idSocio);
        
        Socio socioEncontrado = this.sociosDAO.consultarSocio(socio);
//        System.out.println(socioEncontrado.getId()+" "+socioEncontrado.getNombre());
        String id = Long.toString(socioEncontrado.getId());
        JTextField idAgregar = (JTextField)this.txtIDSocio;
        idAgregar.setText(id);
        JTextField nombre = (JTextField)this.txtNombre;
        nombre.setText(socioEncontrado.getNombre());
        JTextField telefono = (JTextField)this.txtTelefono;
        telefono.setText(socioEncontrado.getTelefono());
    }
    
    private void eliminar(){
        int indiceFilaSeleccionada = this.tblSocios.getSelectedRow();
        int indiceColumnaId = 0;
        if(indiceFilaSeleccionada == -1){
            JOptionPane.showMessageDialog(this, "Debes seleccionar un socio",
                    "Información", JOptionPane.WARNING_MESSAGE);
            return;
        }
        DefaultTableModel modelo = (DefaultTableModel)this.tblSocios.getModel();
        long idSocio = (Long)modelo.getValueAt(indiceFilaSeleccionada, indiceColumnaId);
        Socio socio = new Socio(idSocio);
        int socioEliminado = this.sociosDAO.eliminar(socio);
        if(socioEliminado == 1){
                JOptionPane.showMessageDialog(this, "Socio eliminado correctamente",
                        "Información", JOptionPane.INFORMATION_MESSAGE);
                this.cargarTablaSocios();
            } else{
                JOptionPane.showMessageDialog(this, "No se pudo eliminar al socio",
                        "Error", JOptionPane.INFORMATION_MESSAGE);
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

        lblIDSocio = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        txtIDSocio = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        pnlTablaSocios = new javax.swing.JScrollPane();
        tblSocios = new javax.swing.JTable();
        btnVerDetalles = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administración de Socios");

        lblIDSocio.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        lblIDSocio.setText("ID Socio :");

        lblNombre.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        lblNombre.setText("Nombre :");

        lblTelefono.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        lblTelefono.setText("Telefono :");

        txtIDSocio.setEditable(false);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        tblSocios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_Socio", "nombre", "telefono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pnlTablaSocios.setViewportView(tblSocios);

        btnVerDetalles.setText("Ver detalles");
        btnVerDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDetallesActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTelefono)
                            .addComponent(lblNombre)
                            .addComponent(lblIDSocio))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIDSocio)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(btnGuardar)
                        .addGap(58, 58, 58)
                        .addComponent(btnCancelar)))
                .addGap(88, 88, 88)
                .addComponent(pnlTablaSocios, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnVerDetalles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIDSocio)
                            .addComponent(txtIDSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelefono)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnCancelar)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnVerDetalles)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar))
                            .addComponent(pnlTablaSocios, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnVerDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDetallesActionPerformed
        verDetalles();
    }//GEN-LAST:event_btnVerDetallesActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVerDetalles;
    private javax.swing.JLabel lblIDSocio;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JScrollPane pnlTablaSocios;
    private javax.swing.JTable tblSocios;
    private javax.swing.JTextField txtIDSocio;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
