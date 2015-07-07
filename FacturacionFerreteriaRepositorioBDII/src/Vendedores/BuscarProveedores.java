/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vendedores;

import Dao.ProveedoresDao;
import static MetodoComunes.Metodos.LimpiarTabla;
import POJO.Proveedores;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author martin
 */
public class BuscarProveedores extends javax.swing.JInternalFrame {

    DefaultTableModel dtm = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    boolean Editar = false;
    int Id;
    
    VendedoresInternal pr;
    
    public BuscarProveedores( VendedoresInternal pr) {
        initComponents();
        this.pr = pr;
        InicializarTabla();
        CargarProveedores();
        btnAceptar.setEnabled(false);
    }

    public void InicializarTabla() {
        dtm.addColumn("IDProveedor");
        dtm.addColumn("Nombre");
        dtm.addColumn("RUC");
        dtm.addColumn("Dirección");
        dtm.addColumn("Teléfono");
        dtm.addColumn("Correo Electrónico");
        dtm.addColumn("Estado");
        TablaProveedores.setModel(dtm);
//        CargarProveedores();
    }

    public void CargarProveedores() {

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProveedores = new javax.swing.JTable();
        btnAceptar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Proveedores");

        TablaProveedores.setAutoCreateRowSorter(true);
        TablaProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaProveedores.getTableHeader().setReorderingAllowed(false);
        TablaProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaProveedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaProveedores);

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/check.png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnAceptar)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        
        int filas = TablaProveedores.getSelectedRow();
        if (filas == -1) {
        
            JOptionPane.showInternalMessageDialog(this, "Primero debe seleccionar una fila de la tabla,", "Ventana de Notificación", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
        
            String nombrempresa, ruc;
            
            Id = Integer.parseInt(TablaProveedores.getValueAt(filas, 0).toString());
            pr.Id = Id;
            nombrempresa = TablaProveedores.getValueAt(filas, 1).toString();
            ruc = TablaProveedores.getValueAt(filas, 2).toString();
            pr.NombreEmpresa.setText(nombrempresa);
            pr.RUC.setText(ruc);
            this.dispose();
        }
        //pr.btnBuscar.setEnabled(false);
        pr.NombreEmpresa.setEditable(false);
        pr.RUC.setEditable(false);
        //pr.Id = Integer.parseInt((String)TablaProveedores.getValueAt(filas, 0));
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void TablaProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProveedoresMouseClicked
        this.btnAceptar.setEnabled(true);
    }//GEN-LAST:event_TablaProveedoresMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaProveedores;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
