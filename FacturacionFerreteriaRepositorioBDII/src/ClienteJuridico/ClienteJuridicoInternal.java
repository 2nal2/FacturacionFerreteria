/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteJuridico;

import Dao.ClienteJuridicoDao;
import Dao.Dao;
import Methods.Validator;
import static MetodoComunes.Metodos.LimpiarTabla;
import POJO.ClienteJuridico;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author martin
 */
public class ClienteJuridicoInternal extends javax.swing.JInternalFrame {

    DefaultTableModel dtm = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    boolean Editar = false;
    int Id = -1;

    public ClienteJuridicoInternal() {
        initComponents();
        InicializarTabla();
        this.Direccion.setLineWrap(true);
        btnEditar.setEnabled(false);
        lblEstado.setVisible(false);
        Estado.setVisible(false);
    }

    public void InicializarTabla() {
        dtm.addColumn("IDClienteJurídico");
        dtm.addColumn("Nombre");
        dtm.addColumn("RUC");
        dtm.addColumn("Dirección");
        dtm.addColumn("Teléfono");
        dtm.addColumn("Correo Electrónico");
        dtm.addColumn("DescuentoPorcentual");
        dtm.addColumn("Estado");
        jTable1.setModel(dtm);
        Cargar();
    }

    public void Cargar() {
        LimpiarTabla(dtm);
        for (ClienteJuridico cj : new ClienteJuridicoDao().getAll()) {
            String estado = "Inactivo";
            if (cj.isEstado()) {
                estado = "Activo";
            }
            dtm.addRow(new Object[]{cj.getIdclienteJuridico(), cj.getNombre(), cj.getRuc(),
                cj.getDireccion(), cj.getTelefono(), cj.getCorreoElectronico(), cj.getDescuentoPorcentual(), estado});
        }
    }

    public void BuscarId(String nombre) {

        LimpiarTabla(dtm);

        for (ClienteJuridico i : new ClienteJuridicoDao().getAll()) {
            if (String.valueOf(i.getIdclienteJuridico()).equalsIgnoreCase(nombre)) {
                this.dtm.addRow(new Object[]{i.getIdclienteJuridico(), i.getNombre(), i.getRuc(),
                    i.getDireccion(), i.getCorreoElectronico(), i.getTelefono(), i.getDescuentoPorcentual(), i.isEstado() ? "Activo" : "Inactivo"});
            }
        }
    }

    public void BuscarNombre(String nombre) {

        LimpiarTabla(dtm);

        for (ClienteJuridico i : new ClienteJuridicoDao().getAll()) {
            if (String.valueOf(i.getNombre()).equalsIgnoreCase(nombre) || i.getNombre().contains(nombre) || i.getNombre().endsWith(nombre)
                    || i.getNombre().startsWith(nombre)) {
                this.dtm.addRow(new Object[]{i.getIdclienteJuridico(), i.getNombre(), i.getRuc(),
                    i.getDireccion(), i.getCorreoElectronico(), i.getTelefono(), i.getDescuentoPorcentual(), i.isEstado() ? "Activo" : "Inactivo"});
            }
        }
    }

    public void BuscarRuc(String nombre) {

        LimpiarTabla(dtm);

        for (ClienteJuridico i : new ClienteJuridicoDao().getAll()) {
            if (String.valueOf(i.getRuc()).equalsIgnoreCase(nombre) || i.getRuc().contains(nombre) || i.getRuc().endsWith(nombre)
                    || i.getRuc().startsWith(nombre)) {
                this.dtm.addRow(new Object[]{i.getIdclienteJuridico(), i.getNombre(), i.getRuc(),
                    i.getDireccion(), i.getCorreoElectronico(), i.getTelefono(), i.getDescuentoPorcentual(), i.isEstado() ? "Activo" : "Inactivo"});
            }
        }
    }

    public void MostrarActivosInactivos(boolean activos) {
        LimpiarTabla(dtm);
        for (ClienteJuridico i : new ClienteJuridicoDao().getAll()) {
            if (i.isEstado() == activos) {
                this.dtm.addRow(new Object[]{i.getIdclienteJuridico(), i.getNombre(), i.getRuc(),
                    i.getDireccion(), i.getCorreoElectronico(), i.getTelefono(), i.getDescuentoPorcentual(), i.isEstado() ? "Activo" : "Inactivo"});
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
        jScrollPane1 = new javax.swing.JScrollPane();
        Direccion = new javax.swing.JTextArea();
        btCancelar = new javax.swing.JButton();
        Estado = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        Correo = new javax.swing.JTextField();
        Telefono = new javax.swing.JTextField();
        Descuento = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        RUC = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        Buscar = new javax.swing.JTextField();
        CbxBuscar = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        CbxMostrar = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Clientes Jurídicos");
        setFocusTraversalPolicyProvider(true);
        setFocusable(false);

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jLabel1.setText("Nombre Empresa:");

        Nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NombreKeyTyped(evt);
            }
        });

        Direccion.setColumns(20);
        Direccion.setRows(5);
        Direccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DireccionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(Direccion);

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Cancel.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.setBorder(null);
        btCancelar.setFocusTraversalPolicyProvider(true);
        btCancelar.setFocusable(false);
        btCancelar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Cancel 32x32.png"))); // NOI18N
        btCancelar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Cancel 32x32.png"))); // NOI18N
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        Estado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activo", "Inactivo" }));

        jLabel2.setText("No. Ruc:");

        jLabel3.setText("Teléfono:");

        jLabel4.setText("Dirección:");

        jLabel5.setText("Correo:");

        jLabel6.setText("Descuento");

        lblEstado.setText("Estado:");

        Correo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CorreoKeyTyped(evt);
            }
        });

        Telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TelefonoKeyTyped(evt);
            }
        });

        Descuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DescuentoKeyTyped(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Save 16x16.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(null);
        btnGuardar.setFocusTraversalPolicyProvider(true);
        btnGuardar.setFocusable(false);
        btnGuardar.setMaximumSize(new java.awt.Dimension(90, 24));
        btnGuardar.setMinimumSize(new java.awt.Dimension(90, 24));
        btnGuardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Save 24 x24.png"))); // NOI18N
        btnGuardar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Save 24 x24.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        try {
            RUC.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("U#############")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        RUC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RUCKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Correo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RUC, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(lblEstado))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Telefono, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(Estado, 0, 200, Short.MAX_VALUE)
                            .addComponent(Descuento)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(RUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(Descuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstado)
                    .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Registrar Nuevo Cliente Jurídico", jPanel1);

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
        btnEditar.setText("Editar");
        btnEditar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Edit 32 x 32.png"))); // NOI18N
        btnEditar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Edit 32 x 32.png"))); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(1, 1, 1));
        jLabel7.setText("Buscar por:");

        Buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscarKeyReleased(evt);
            }
        });

        CbxBuscar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Id", "Nombre Empresa", "# RUC" }));

        jLabel8.setForeground(new java.awt.Color(1, 1, 1));
        jLabel8.setText("Tipo de Muestreo: ");

        CbxMostrar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mostrar Todo", "Mostrar Activos", "Mostrar Inactivos" }));

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CbxMostrar, 0, 165, Short.MAX_VALUE)
                    .addComponent(CbxBuscar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addGap(222, 222, 222))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(CbxMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Administrar Clientes Jurídicos", jPanel2);

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

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        int nf = jTable1.getSelectedRow();

        this.Id = Integer.parseInt(dtm.getValueAt(nf, 0).toString());
        this.jTabbedPane1.setSelectedIndex(0);
        this.lblEstado.setVisible(true);
        this.Estado.setVisible(true);
        ClienteJuridico cj = new ClienteJuridicoDao().getById(Id);
        Nombre.setText(cj.getNombre());
        RUC.setText(cj.getRuc());
        Direccion.setText(cj.getDireccion());
        Telefono.setText(cj.getTelefono());
        Correo.setText(cj.getCorreoElectronico());
        Descuento.setText(String.valueOf(cj.getDescuentoPorcentual()));

        if (cj.isEstado()) {
            Estado.setSelectedIndex(0);
        } else {
            Estado.setSelectedIndex(1);
        }
        Editar = true;
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        /*Cuando es cliente juridico, el número RUC varía, por lo general lleva letra al inicio
         y depende de su giro comercial osea a que se dedica la empresa.
         */

        String nombre, ruc, direccion, telefono, email;
        double desc;

        nombre = this.Nombre.getText();
        ruc = this.RUC.getText();
        direccion = this.Direccion.getText();
        telefono = this.Telefono.getText();
        email = this.Correo.getText();
        desc = Double.parseDouble(Descuento.getText());

        if (!Validator.ValidarEmail(email)) {
            JOptionPane.showInternalMessageDialog(this, "Correo inválido, por favor intente nuevamente", "Ventana de Notificación", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!Validator.ValidatePhoneNumber(telefono)) {
            JOptionPane.showInternalMessageDialog(this, "Número de teléfono no válido", "Ventana de Notificación", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (nombre.trim().equals("") || ruc.trim().equals("") || direccion.trim().equals("")
                || telefono.trim().equals("") || email.trim().equals("")) {
            JOptionPane.showInternalMessageDialog(this, "Por favor, complete los campos para poder registrar", "Ventana de Información", JOptionPane.INFORMATION_MESSAGE);
        } else {

            ClienteJuridico cj = new ClienteJuridico();
            cj.setNombre(nombre);
            cj.setRuc(ruc);
            cj.setDireccion(direccion);
            cj.setTelefono(telefono);
            cj.setCorreoElectronico(email);
            cj.setDescuentoPorcentual((float) desc);

            if (!Editar) {
                cj.setEstado(true);
                long id = new Dao().Guardar(cj);

                if (id == -1) {
                    JOptionPane.showInternalMessageDialog(this, "No se puede guardar \n intente mas tarde, si el problema persiste contactese con el administrador del sistema", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Guardado Exitosamente", "Operacion realizada con exito", JOptionPane.INFORMATION_MESSAGE);
                    Cargar();
                }
            } else {
                cj.setIdclienteJuridico(Id);
                if (Estado.getSelectedIndex() == 0) {
                    cj.setEstado(true);
                } else {
                    cj.setEstado(false);
                }

                boolean actualizado = new Dao().Actualizar(cj);
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
        }

        Nombre.setText(null);
        RUC.setText(null);
        Direccion.setText(null);
        Correo.setText(null);
        Telefono.setText(null);
        Descuento.setText(null);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed

        Nombre.setText(null);
        RUC.setText(null);
        Direccion.setText(null);
        Correo.setText(null);
        Telefono.setText(null);
        Descuento.setText(null);

        if (Editar) {
            Id = -1;
            Editar = false;
            this.jTabbedPane1.setSelectedIndex(1);
            this.Estado.setVisible(false);
            lblEstado.setVisible(false);
        }

    }//GEN-LAST:event_btCancelarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        btnEditar.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged

        if (this.jTabbedPane1.getSelectedIndex() == 0) {
            Cargar();
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

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
                this.BuscarRuc(texto);
                break;
            }
        }
    }//GEN-LAST:event_BuscarKeyReleased

    private void NombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombreKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            RUC.requestFocus();
        }
    }//GEN-LAST:event_NombreKeyTyped

    private void DescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DescuentoKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != '.' || (c == '.' && Descuento.getText().contains("."))) {
            evt.consume();
        }
        
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            btnGuardar.requestFocus();
        }
    }//GEN-LAST:event_DescuentoKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TelefonoKeyTyped
        if (Telefono.getText().length() >= 8) {
            evt.consume();
        }
    }//GEN-LAST:event_TelefonoKeyTyped

    private void RUCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RUCKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_RUCKeyTyped

    private void CorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CorreoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_CorreoKeyTyped

    private void DireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DireccionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_DireccionKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Buscar;
    private javax.swing.JComboBox CbxBuscar;
    private javax.swing.JComboBox CbxMostrar;
    private javax.swing.JTextField Correo;
    private javax.swing.JTextField Descuento;
    private javax.swing.JTextArea Direccion;
    private javax.swing.JComboBox Estado;
    private javax.swing.JTextField Nombre;
    private javax.swing.JFormattedTextField RUC;
    private javax.swing.JTextField Telefono;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
