/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RepresentanteJuridico;

import Dao.ClienteJuridicoDao;
import static MetodoComunes.Metodos.LimpiarTabla;
import POJO.ClienteJuridico;
import javax.persistence.criteria.CriteriaBuilder;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author martin
 */
public class BuscarCliente extends javax.swing.JInternalFrame {

    DefaultTableModel dtm = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    RepresentanteInternal ri;

    boolean Editar = false;
    int Id ;

    public BuscarCliente(RepresentanteInternal ri) {
        initComponents();
        TablaCliente();
        CargarCliente();
        this.ri = ri;
    }

    public void TablaCliente() {
        dtm.addColumn("IDClienteJurídico");
        dtm.addColumn("Nombre");
        dtm.addColumn("RUC");
        dtm.addColumn("Dirección");
        dtm.addColumn("Teléfono");
        dtm.addColumn("Correo Electrónico");
        dtm.addColumn("DescuentoPorcentual");
        dtm.addColumn("Fax");
        dtm.addColumn("Estado");
        TablaCliente.setModel(dtm);
    }

    public void CargarCliente() {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaCliente = new javax.swing.JTable();
        btnAceptar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Buscar Cliente Jurídico");

        TablaCliente.setAutoCreateRowSorter(true);
        TablaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaCliente.getTableHeader().setReorderingAllowed(false);
        TablaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaCliente);

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
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(496, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        int fila = TablaCliente.getSelectedRow();

        if (fila == -1) {

            JOptionPane.showInternalMessageDialog(this, "Por favor primero seleccione una fila", "Ventana de Informacion", JOptionPane.ERROR_MESSAGE);
            return;
        } else {

            String nombre;
            Id = Integer.parseInt(TablaCliente.getValueAt(fila, 0).toString());
            ri.Id = Id;
           // id = TablaCliente.getValueAt(fila, 0).toString();
            nombre = TablaCliente.getValueAt(fila, 1).toString();
            ri.NombreCliente.setText(nombre);
            //ri.IdCliente.setText(id);
            this.dispose();
        }
        ri.NombreCliente.setEditable(false);
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void TablaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaClienteMouseClicked
        
        btnAceptar.setEnabled(true);
        
    }//GEN-LAST:event_TablaClienteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TablaCliente;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
