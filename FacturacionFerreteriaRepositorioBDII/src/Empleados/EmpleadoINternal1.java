/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleados;

import Camara.Camara;
import Dao.Dao;
import Dao.EmpleadoDao;
import Methods.ValidacionCedula;
import Methods.Validaciones;
import static Methods.Validaciones.ValidateName;
import Methods.Validator;
import static MetodoComunes.Metodos.Centrar;
import static MetodoComunes.Metodos.LimpiarTabla;
import MetodoComunes.procesamientoImagenes;
import POJO.Empleados;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author martin
 */
public class EmpleadoINternal1 extends javax.swing.JInternalFrame {

    DefaultTableModel dtm = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public BufferedImage imagempleado;
    boolean Editar = false;
    int Id = -1;
    int Cod;

    public EmpleadoINternal1() {
        initComponents();
        lblEstado.setVisible(false);
        Estado.setVisible(false);
    }

    public void InicializarTabla() {
        dtm.addColumn("IDEmpleado");
        dtm.addColumn("Cédula");
        dtm.addColumn("Foto");
        dtm.addColumn("Primer Nombre");
        dtm.addColumn("Segundo Nombre");
        dtm.addColumn("Primer Apellido");
        dtm.addColumn("Segundo Apellido");
        dtm.addColumn("Dirección");
        dtm.addColumn("Rol de Usuario");
        dtm.addColumn("Estado");
        //jTable1.setModel(dtm);
        Cargar();
    }

    public void Cargar() {
        LimpiarTabla(dtm);
        for (Empleados pr : new EmpleadoDao().getAll()) {
            String estado = "Inactivo";
            if (pr.isEstado()) {
                estado = "Activo";
            }
            dtm.addRow(new Object[]{pr.getIdempleado(), pr.getPrimerNombre(), pr.getSegundoNombre(), pr.getPrimerApellido(),
                pr.getSegundoApellido(), pr.getCedula(), pr.getDireccion(), pr.getRolUsuario(), estado});
        }
    }

    public BufferedImage abrirImagen() {
        BufferedImage bmp = null;
        JFileChooser selector = new JFileChooser();
        selector.setDialogTitle("Seleccione una imagen");
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG & GIF & BMP", "jpg", "gif", "bmp");
        selector.setFileFilter(filtroImagen);
        int flag = selector.showOpenDialog(null);
        if (flag == JFileChooser.APPROVE_OPTION) {
            try {
                File imagenSeleccionada = selector.getSelectedFile();
                bmp = ImageIO.read(imagenSeleccionada);
            } catch (Exception e) {
            }

        }
        return bmp;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        PNombre = new javax.swing.JTextField();
        Rol = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        Direccion = new javax.swing.JTextArea();
        SNombre = new javax.swing.JTextField();
        SApellido = new javax.swing.JTextField();
        PApellido = new javax.swing.JTextField();
        Cedula = new javax.swing.JFormattedTextField();
        lblEstado = new javax.swing.JLabel();
        Estado = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        lblFoto = new javax.swing.JLabel();
        btnCargarFoto = new javax.swing.JButton();
        btnTomarFoto = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Empleados");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Información del Empleado"));

        jLabel1.setText("Primer Nombre:");

        jLabel2.setText("Segundo Nombre:");

        jLabel3.setText("Primer Apellido:");

        jLabel4.setText("Segundo Apellido:");

        jLabel5.setText("Cédula:");

        jLabel6.setText("Dirección:");

        jLabel7.setText("Rol de Usuario:");

        Rol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Cajero" }));

        Direccion.setColumns(20);
        Direccion.setRows(5);
        jScrollPane1.setViewportView(Direccion);

        SApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SApellidoActionPerformed(evt);
            }
        });

        PApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PApellidoActionPerformed(evt);
            }
        });

        try {
            Cedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-######-####U")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblEstado.setText("Estado:");

        Estado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activo", "Inactivo" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(lblEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Rol, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(SNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(PNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(SNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(PApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(SApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(Rol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstado)
                    .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Foto"));

        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setText("No hay fotografía");
        lblFoto.setToolTipText("");
        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 155, 206)));
        lblFoto.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        btnCargarFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/file search.png"))); // NOI18N
        btnCargarFoto.setText("Cargar Foto");
        btnCargarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarFotoActionPerformed(evt);
            }
        });

        btnTomarFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/camara.png"))); // NOI18N
        btnTomarFoto.setText("Tomar Foto");
        btnTomarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTomarFotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(btnCargarFoto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                .addComponent(btnTomarFoto)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCargarFoto)
                    .addComponent(btnTomarFoto))
                .addGap(20, 20, 20))
        );

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Save 16x16.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(35, 35, 35)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PApellidoActionPerformed

    private void btnCargarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarFotoActionPerformed
        imagempleado = this.abrirImagen();
        procesamientoImagenes pi = new procesamientoImagenes();
        int height = lblFoto.getHeight();
        int width = lblFoto.getWidth();
        lblFoto.setIcon((pi.imageToIcon(pi.imageToBufferedImage(imagempleado).getScaledInstance(width, height, 0))));
        lblFoto.setText(null);
    }//GEN-LAST:event_btnCargarFotoActionPerformed

    private void btnTomarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTomarFotoActionPerformed
        Camara c = new Camara(this);
        Centrar(c, this.getDesktopPane());
    }//GEN-LAST:event_btnTomarFotoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        PNombre.setText(null);
        SNombre.setText(null);
        PApellido.setText(null);
        SApellido.setText(null);
        Cedula.setText(null);
        Direccion.setText(null);
        lblFoto.setText("No se ha cargado ninguna imágen");
        lblFoto.setIcon(null);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String pnombre, snombre, papellido, sapellido, dni, rol, direccion;

        pnombre = this.PNombre.getText();
        snombre = this.SNombre.getText();
        papellido = this.PApellido.getText();
        sapellido = this.SApellido.getText();
        dni = this.Cedula.getText();
        direccion = this.Direccion.getText();
        rol = this.Rol.getSelectedItem().toString();

         if (!new ValidacionCedula().Validacion(dni)) {
            JOptionPane.showInternalMessageDialog(this, "Por favor ingrese un número de cédula válida", "Ventana de Notificación", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!ValidateName(pnombre) || !ValidateName(snombre) || !ValidateName(papellido) || !ValidateName(sapellido) || !ValidateName(rol)) {
            JOptionPane.showInternalMessageDialog(this, "Algún campo tiene información que el sistema no puede procesar", "Ventana de Notificación", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (pnombre.trim().equals("") || snombre.trim().equals("") || papellido.trim().equals("")
                || sapellido.trim().equals("") || dni.trim().equals("")) {
            JOptionPane.showInternalMessageDialog(this, "Algún campo está vacío, por favor intente nuevamente", "Ventana de Notificación", JOptionPane.ERROR_MESSAGE);
            return;
        } else {

            Empleados pr = new Empleados();
            pr.setPrimerNombre(pnombre);
            pr.setSegundoNombre(snombre);
            pr.setPrimerApellido(papellido);
            pr.setSegundoNombre(snombre);
            pr.setCedula(dni);
            pr.setDireccion(direccion);
            pr.setRolUsuario(this.Rol.getSelectedItem().toString());
            
            ByteArrayOutputStream os;
            if (imagempleado != null) {

                os = new ByteArrayOutputStream();

                try {
                    ImageIO.write(imagempleado, "jpg", os);
                    os.flush();
                    String base64String = Base64.encode(os.toByteArray());
                    os.close();

                    byte[] bytearray = Base64.decode(base64String);

                    pr.setFoto(bytearray);
                } catch (IOException ex) {
                    return;
                }

            } else {
                JOptionPane.showInternalMessageDialog(this, "Asegurese de haber cargado/tomado una imágen", "Ventana de Notificación", JOptionPane.ERROR_MESSAGE);
                return;
                //System.out.println(" la imagen esta null");
            }

            if (!Editar) {
                pr.setEstado(true);
                long id = new Dao().Guardar(pr);

                if (id == -1) {
                    JOptionPane.showInternalMessageDialog(this, "No se puede guardar \n intente mas tarde, si el problema persiste contactese con el administrador del sistema", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Guardado Exitosamente", "Operacion realizada con exito", JOptionPane.INFORMATION_MESSAGE);
                    Cargar();
                }
            } else {
                pr.setIdempleado(Id);
                if (Estado.getSelectedIndex() == 0) {
                    pr.setEstado(true);
                } else {
                    pr.setEstado(false);
                }

                boolean actualizado = new Dao().Actualizar(pr);
                if (!actualizado) {
                    JOptionPane.showInternalMessageDialog(this, "No se puede actualizar \n intente mas tarde, si el problema persiste contactese con el administrador del sistema", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Actualizado Exitosamente", "Operacion realizada con exito", JOptionPane.INFORMATION_MESSAGE);
                    Id = -1;
                    Estado.setSelectedIndex(0);
                    Editar = false;
                    Estado.setVisible(false);
                    lblEstado.setVisible(false);
                    //this.jTabbedPane1.setSelectedIndex(1);
                    Cargar();
                }
            }
        }
        PNombre.setText(null);
        SNombre.setText(null);
        PApellido.setText(null);
        SApellido.setText(null);
        Cedula.setText(null);
        Direccion.setText(null);
        lblFoto.setText(null);
        lblFoto.setText("foto no ingresada");
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void SApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SApellidoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField Cedula;
    private javax.swing.JTextArea Direccion;
    private javax.swing.JComboBox Estado;
    private javax.swing.JTextField PApellido;
    private javax.swing.JTextField PNombre;
    private javax.swing.JComboBox Rol;
    private javax.swing.JTextField SApellido;
    private javax.swing.JTextField SNombre;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCargarFoto;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnTomarFoto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEstado;
    public javax.swing.JLabel lblFoto;
    // End of variables declaration//GEN-END:variables
}
