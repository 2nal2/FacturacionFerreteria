package Categoria;

import Dao.CategoriaDao;
import Dao.Dao;
import static MetodoComunes.Metodos.Centrar;
import static MetodoComunes.Metodos.LimpiarTabla;
import POJO.Categorias;
import Producto.InventarioInternal;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ing. Donaldo
 */
public class CategoriaInternal extends javax.swing.JInternalFrame {

    DefaultTableModel dtm = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    boolean Editar = false;
    int Id = -1;

    public CategoriaInternal() {
        initComponents();
        this.Descripcion.setLineWrap(true);
        InicializarTabla();
        btnEditar.setEnabled(false);
        btnProductos.setEnabled(false);
        Estado.setVisible(false);
        lblEstado.setVisible(false);
    }

    public void InicializarTabla() {
        dtm.addColumn("IDCategoria");
        dtm.addColumn("Nombre Categoria");
        dtm.addColumn("Descripcion");
        dtm.addColumn("Estado");
        jTable1.setModel(dtm);
        Cargar();
    }

    public void Cargar() {
        LimpiarTabla(dtm);
        for (Categorias c : new CategoriaDao().getAll()) {
            String estado = "Inactivo";
            if (c.isEstado()) {
                estado = "Activo";
            }
            dtm.addRow(new Object[]{c.getIdcategoria(), c.getNombre(), c.getDescripcion(), estado});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Nombre = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Descripcion = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        lblEstado = new javax.swing.JLabel();
        Estado = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Categoria");

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jLabel2.setText("Descripcion de categoria");

        jLabel3.setText("Nombre de Categoria");

        Descripcion.setColumns(20);
        Descripcion.setRows(5);
        jScrollPane2.setViewportView(Descripcion);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Save 16x16.png"))); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblEstado.setText("Estado");

        Estado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activo", "Inactivo" }));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Cancel.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel2))
                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("Registrar Categoria", jPanel1);

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
        jScrollPane1.setViewportView(jTable1);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/edit.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Lupa.png"))); // NOI18N
        btnProductos.setText("Ver productos");
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnProductos))
                .addGap(13, 13, 13))
        );

        jTabbedPane1.addTab("Administrar Categorias", jPanel2);

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

        String nombre, descripcion;

        nombre = this.Nombre.getText();
        descripcion = this.Descripcion.getText();
        if (nombre.trim().equals("")) {
            JOptionPane.showInternalMessageDialog(this, "Por favor Ingrese el nombre de la categoria", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (descripcion.trim().equals("")) {
            JOptionPane.showInternalMessageDialog(this, "Por favor Ingrese la descripcion de la categoria", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Categorias c = new Categorias();
        c.setNombre(nombre);
        c.setDescripcion(descripcion);
        if (!Editar) {
            c.setEstado(true);
            long id = new Dao().Guardar(c);
            if (id == -1) {
                JOptionPane.showInternalMessageDialog(this, "No se puede guardar \n intente mas tarde, si el problema persiste contactese con el administrador del sistema", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showInternalMessageDialog(this, "Guardado Exitosamente", "Operacion realizada con exito", JOptionPane.INFORMATION_MESSAGE);
                Cargar();
            }
        } else {
            c.setIdcategoria(Id);
            if (Estado.getSelectedIndex() == 0) {
                c.setEstado(true);
            } else {
                c.setEstado(false);
            }
            boolean actualizado = new Dao().Actualizar(c);
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

        this.Descripcion.setText(null);
        this.Nombre.setText(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int nf = jTable1.getSelectedRow();

        this.Id = Integer.parseInt(dtm.getValueAt(nf, 0).toString());
        this.jTabbedPane1.setSelectedIndex(0);
        this.lblEstado.setVisible(true);
        this.Estado.setVisible(true);
        Categorias c = new CategoriaDao().getById(Id);
        Nombre.setText(c.getNombre());
        Descripcion.setText(c.getDescripcion());
        if (c.isEstado()) {
            Estado.setSelectedIndex(0);
        } else {
            Estado.setSelectedIndex(1);
        }
        Editar = true;
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        int nf = jTable1.getSelectedRow();

        String nombre = this.jTable1.getValueAt(nf, 1).toString();
        InventarioInternal i = new InventarioInternal(nombre);
        Centrar(i, this.getDesktopPane());
    }//GEN-LAST:event_btnProductosActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked

    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        btnEditar.setEnabled(true);
        btnProductos.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        if (this.jTabbedPane1.getSelectedIndex() == 0) {
            Cargar();

        }
        btnEditar.setEnabled(false);
        btnProductos.setEnabled(false);
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Nombre.setText(null);
        Descripcion.setText(null);
        if (Editar) {
            Id = -1;
            Editar = false;
            this.jTabbedPane1.setSelectedIndex(1);
            this.Estado.setVisible(false);
            lblEstado.setVisible(false);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Descripcion;
    private javax.swing.JComboBox Estado;
    private javax.swing.JTextField Nombre;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblEstado;
    // End of variables declaration//GEN-END:variables
}
