/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proveedores;

import Dao.Dao;
import Dao.ProveedoresDao;
import static Methods.Validator.ValidateRUC;
import static MetodoComunes.Metodos.LimpiarTabla;
import POJO.Proveedores;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author martin
 */
public class ProveedoresInternal extends javax.swing.JInternalFrame {

    DefaultTableModel dtm = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    boolean Editar = false;
    int Id = -1;

    public ProveedoresInternal() {
        initComponents();
        InicializarTabla();
        this.Direccion.setLineWrap(true);
        btnEditar.setEnabled(false);
        lblEstado.setVisible(false);
        Estado.setVisible(false);
    }

    public void InicializarTabla() {
        dtm.addColumn("IDProveedor");
        dtm.addColumn("Nombre");
        dtm.addColumn("RUC");
        dtm.addColumn("Dirección");
        dtm.addColumn("Teléfono");
        dtm.addColumn("Correo Electrónico");
        dtm.addColumn("Estado");
        jTable1.setModel(dtm);
        Cargar();
    }

    public void Cargar() {
        LimpiarTabla(dtm);
        for (Proveedores pr : new ProveedoresDao().getAll()) {
            String estado = "Inactivo";
            if (pr.getEstado()) {
                estado = "Activo";
            }
            dtm.addRow(new Object[]{pr.getIdproveedor(), pr.getNombre(), pr.getRuc(), pr.getDireccion(),
                pr.getTelefono(), pr.getCorreoElectronico(), estado});
        }

    }

    public void BuscarId(String nombre) {
        LimpiarTabla(dtm);
        for (Proveedores pr : new ProveedoresDao().getAll()) {
            if (String.valueOf(pr.getIdproveedor()).equalsIgnoreCase(nombre)) {
                this.dtm.addRow(new Object[]{pr.getIdproveedor(), pr.getNombre(), pr.getRuc(), pr.getDireccion(),
                    pr.getTelefono(), pr.getCorreoElectronico(), pr.getEstado() ? "Activo" : "Inactivo"});
            }
        }
    }

    public void BuscarNombre(String nombre) {
        LimpiarTabla(dtm);
        for (Proveedores pr : new ProveedoresDao().getAll()) {
            if (String.valueOf(pr.getNombre()).equalsIgnoreCase(nombre) || pr.getNombre().contains(nombre) || pr.getNombre().endsWith(nombre) 
                    || pr.getNombre().startsWith(nombre)) {
                this.dtm.addRow(new Object[]{pr.getIdproveedor(), pr.getNombre(), pr.getRuc(), pr.getDireccion(),
                    pr.getTelefono(), pr.getCorreoElectronico(), pr.getEstado() ? "Activo" : "Inactivo"});
            }
        }
    }

    public void BuscarRUC(String nombre) {
        LimpiarTabla(dtm);
        for (Proveedores pr : new ProveedoresDao().getAll()) {
            if (String.valueOf(pr.getRuc()).equalsIgnoreCase(nombre) || pr.getRuc().contains(nombre) || pr.getRuc().endsWith(nombre)
                    || pr.getRuc().startsWith(nombre)) {
                this.dtm.addRow(new Object[]{pr.getIdproveedor(), pr.getNombre(), pr.getRuc(), pr.getDireccion(),
                    pr.getTelefono(), pr.getCorreoElectronico(), pr.getEstado() ? "Activo" : "Inactivo"});
            }
        }
    }

    public void MostrarActivosInactivos (boolean activos) {
        LimpiarTabla(dtm);
        for (Proveedores pr : new ProveedoresDao().getAll()) {
            if(pr.getEstado() == activos) {
                this.dtm.addRow(new Object[]{pr.getIdproveedor(), pr.getNombre(), pr.getRuc(), pr.getDireccion(),
                    pr.getTelefono(), pr.getCorreoElectronico(), pr.getEstado() ? "Activo" : "Inactivo"});
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Nombre = new javax.swing.JTextField();
        Estado = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Direccion = new javax.swing.JTextArea();
        Correo = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        RUC = new javax.swing.JFormattedTextField();
        Telefono = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        Buscar = new javax.swing.JTextField();
        CbxBuscar = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        CbxMostrar = new javax.swing.JComboBox();
        btnMostrar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Proveedores");

        jTabbedPane1.setBackground(new java.awt.Color(65, 146, 141));

        jPanel1.setBackground(new java.awt.Color(65, 146, 141));

        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Nombre Empresa:");

        Estado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activo", "Inactivo" }));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Save 16x16.png"))); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setText("# RUC:");

        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setText("Teléfono:");

        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setText("Dirección:");

        jLabel5.setForeground(new java.awt.Color(254, 254, 254));
        jLabel5.setText("Correo:");

        lblEstado.setForeground(new java.awt.Color(254, 254, 254));
        lblEstado.setText("Estado:");

        Direccion.setColumns(20);
        Direccion.setRows(5);
        jScrollPane1.setViewportView(Direccion);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Cancel.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        try {
            RUC.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#############U")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        RUC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RUCKeyTyped(evt);
            }
        });

        try {
            Telefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(35, 35, 35)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(RUC, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(lblEstado)
                                    .addComponent(jLabel3))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Correo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2)
                        .addGap(55, 55, 55)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(RUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstado))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Registrar Proveedores", jPanel1);

        jPanel2.setBackground(new java.awt.Color(65, 146, 141));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/edit.png"))); // NOI18N
        btnEditar.setText("Actualizar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(65, 146, 141));

        jLabel6.setForeground(new java.awt.Color(242, 241, 240));
        jLabel6.setText("Buscar por:");

        Buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscarKeyReleased(evt);
            }
        });

        CbxBuscar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Id", "Nombre Empresa", "# RUC" }));

        jLabel7.setForeground(new java.awt.Color(242, 241, 240));
        jLabel7.setText("Tipo de Muestreo:");

        CbxMostrar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mostrar Todo", "Mostrar Activos", "Mostrar Inactivos" }));

        btnMostrar.setText("Aceptar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbxMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMostrar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(13, 13, 13)
                        .addComponent(CbxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(251, 251, 251))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(CbxMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMostrar))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(CbxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addGap(25, 25, 25)
                .addComponent(btnEditar)
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("Administrar Proveedores", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String nombre, ruc, direccion, telefono, email;

        nombre = this.Nombre.getText();
        ruc = this.RUC.getText();
        direccion = this.Direccion.getText();
        telefono = this.Telefono.getText();
        email = this.Correo.getText();

        if (nombre.trim().equals("") || ruc.trim().equals("") || direccion.trim().equals("")
                || telefono.trim().equals("") || email.trim().equals("")) {

            JOptionPane.showInternalMessageDialog(this, "Algún campo esta vacío, por favor intente nuevamente", "Ventana de Notificación", JOptionPane.ERROR_MESSAGE);

            return;
        } else {

            Proveedores pr = new Proveedores();
            pr.setNombre(nombre);
            pr.setRuc(ruc);
            pr.setDireccion(direccion);
            pr.setTelefono(telefono);
            pr.setCorreoElectronico(email);

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
                pr.setIdproveedor(Id);
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
                    this.jTabbedPane1.setSelectedIndex(1);
                    Cargar();
                }
            }

            Nombre.setText(null);
            RUC.setText(null);
            Direccion.setText(null);
            Correo.setText(null);
            Telefono.setText(null);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        Nombre.setText(null);
        RUC.setText(null);
        Direccion.setText(null);
        Correo.setText(null);
        Telefono.setText(null);

        if (Editar) {
            Id = -1;
            Editar = false;
            this.jTabbedPane1.setSelectedIndex(1);
            this.Estado.setVisible(false);
            lblEstado.setVisible(false);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        int nf = jTable1.getSelectedRow();

        if (nf == -1) {

            JOptionPane.showInternalMessageDialog(this, "Primero debe seleccionar una fila", "Ventana de Notificación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        this.Id = Integer.parseInt(dtm.getValueAt(nf, 0).toString());
        this.jTabbedPane1.setSelectedIndex(0);
        this.lblEstado.setVisible(true);
        this.Estado.setVisible(true);
        Proveedores pr = new ProveedoresDao().getById(Id);
        Nombre.setText(pr.getNombre());
        RUC.setText(pr.getRuc());
        Direccion.setText(pr.getDireccion());
        Telefono.setText(pr.getTelefono());
        Correo.setText(pr.getCorreoElectronico());

        if (pr.getEstado()) {
            Estado.setSelectedIndex(0);
        } else {
            Estado.setSelectedIndex(1);
        }
        Editar = true;


    }//GEN-LAST:event_btnEditarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        this.btnEditar.setEnabled(true);

    }//GEN-LAST:event_jTable1MouseClicked

    private void RUCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RUCKeyTyped
        String ruc = this.RUC.getText();
        ValidateRUC(ruc);

    }//GEN-LAST:event_RUCKeyTyped

    private void BuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarKeyReleased
        String texto = Buscar.getText();
        if (texto.trim().equals("")) {
            this.Cargar();
            return;
        }
        switch (CbxBuscar.getSelectedIndex() + 1) {

            case 1: {
                this.BuscarId(texto);
                break;
            }
            case 2: {
                this.BuscarNombre(texto);
                break;
            }
            case 3: {
                this.BuscarRUC(texto);
                break;
            }
        }
    }//GEN-LAST:event_BuscarKeyReleased

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        switch (CbxMostrar.getSelectedIndex() + 1) {
            case 1: {
                this.Cargar();
                break;
            }
            case 2: {
                MostrarActivosInactivos(true);
                break;
            }
            case 3: {
                MostrarActivosInactivos(false);
                break;
            }
        }
    }//GEN-LAST:event_btnMostrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Buscar;
    private javax.swing.JComboBox CbxBuscar;
    private javax.swing.JComboBox CbxMostrar;
    private javax.swing.JTextField Correo;
    private javax.swing.JTextArea Direccion;
    private javax.swing.JComboBox Estado;
    private javax.swing.JTextField Nombre;
    private javax.swing.JFormattedTextField RUC;
    private javax.swing.JFormattedTextField Telefono;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblEstado;
    // End of variables declaration//GEN-END:variables
}
