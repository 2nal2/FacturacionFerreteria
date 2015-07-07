/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venta;

import Dao.ClienteDao;
import static MetodoComunes.Metodos.LimpiarTabla;
import POJO.Cliente;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ingdonaldo
 */
public class SeleccionClienteInternal extends javax.swing.JInternalFrame {

    DefaultTableModel dtm = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    /**
     * Creates new form SeleccionClienteInteranl
     */
    FacturaInternal f;

    public SeleccionClienteInternal(FacturaInternal f) {
        initComponents();
        this.f = f;
        InicializarTabla();
        Cargar();
    }

    public void InicializarTabla() {
        dtm.addColumn("IDCliente");
        dtm.addColumn("Primer Nombre");
        dtm.addColumn("Segundo Nombre");
        dtm.addColumn("Primer Apellido");
        dtm.addColumn("Segundo Apellido");
        dtm.addColumn("Cedula");
        dtm.addColumn("Direccion");
        dtm.addColumn("Correo Electronico");
        dtm.addColumn("Telefono");
        dtm.addColumn("DescuentoPorcentual");
        dtm.addColumn("Estado");
        jTable1.setModel(dtm);
    }

    public void Cargar() {
        LimpiarTabla(dtm);
        for (Cliente cl : new ClienteDao().getAll()) {
            String estado;
            if (cl.isEstado()) {
                estado = "Activo";
                dtm.addRow(new Object[]{cl.getIdcliente(), cl.getPrimerNombre(), cl.getSegundoNombre(), cl.getPrimerApellido(),
                    cl.getSegundoApellido(), cl.getCedula(), cl.getDireccion(), cl.getCorreoElectronico(), cl.getTelefono(),
                    cl.getDescuentoPorcentual(), estado});
            }

        }
    }

    public void BuscarNombre(String texto) {
        LimpiarTabla(dtm);
        texto = texto.toLowerCase();
        for (Cliente cl : new ClienteDao().getAll()) {
            String estado;
            String NombreCliente = cl.getPrimerNombre() + " " + cl.getSegundoNombre() + " " + cl.getPrimerApellido() + " " + cl.getSegundoApellido();
            NombreCliente = NombreCliente.toLowerCase();
            if ((NombreCliente.startsWith(texto) || NombreCliente.contains(texto) || NombreCliente.endsWith(texto) || NombreCliente.equalsIgnoreCase(texto)) && cl.isEstado()) {
                estado = "Activo";
                dtm.addRow(new Object[]{cl.getIdcliente(), cl.getPrimerNombre(), cl.getSegundoNombre(), cl.getPrimerApellido(),
                    cl.getSegundoApellido(), cl.getCedula(), cl.getDireccion(), cl.getCorreoElectronico(), cl.getTelefono(),
                    cl.getDescuentoPorcentual(), estado});
            }

        }
    }

    public void BuscarCedula(String texto) {
        LimpiarTabla(dtm);
        texto = texto.toLowerCase();
        for (Cliente cl : new ClienteDao().getAll()) {
            String estado;
            String NombreCliente = cl.getCedula();
            NombreCliente = NombreCliente.toLowerCase();
            if ((NombreCliente.startsWith(texto) || NombreCliente.equalsIgnoreCase(texto)) && cl.isEstado()) {
                estado = "Activo";
                dtm.addRow(new Object[]{cl.getIdcliente(), cl.getPrimerNombre(), cl.getSegundoNombre(), cl.getPrimerApellido(),
                    cl.getSegundoApellido(), cl.getCedula(), cl.getDireccion(), cl.getCorreoElectronico(), cl.getTelefono(),
                    cl.getDescuentoPorcentual(), estado});
            }

        }
    }

    public void BuscarTelefono(String texto) {
        LimpiarTabla(dtm);
        texto = texto.toLowerCase();
        for (Cliente cl : new ClienteDao().getAll()) {
            String estado;
            String NombreCliente = cl.getTelefono();
            NombreCliente = NombreCliente.toLowerCase();
            if ((NombreCliente.startsWith(texto) || NombreCliente.equalsIgnoreCase(texto)) && cl.isEstado()) {
                estado = "Activo";
                dtm.addRow(new Object[]{cl.getIdcliente(), cl.getPrimerNombre(), cl.getSegundoNombre(), cl.getPrimerApellido(),
                    cl.getSegundoApellido(), cl.getCedula(), cl.getDireccion(), cl.getCorreoElectronico(), cl.getTelefono(),
                    cl.getDescuentoPorcentual(), estado});
            }

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        TipoBusqueda = new javax.swing.JComboBox();
        Buscar = new javax.swing.JTextField();
        btnSeleccionar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Seleccion de Cliente para la factura");

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

        jLabel5.setText("Buscar por");

        TipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombres", "Cedula", "Telefono" }));

        Buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscarKeyReleased(evt);
            }
        });

        btnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/check.png"))); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.setEnabled(false);
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(TipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        btnSeleccionar.setEnabled(true);
        if(evt.getClickCount() == 2){
            btnSeleccionarActionPerformed(null);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void BuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarKeyReleased
        btnSeleccionar.setEnabled(false);
        String texto = Buscar.getText();
        if (texto.trim().equals("")) {
            this.Cargar();
            return;
        }
        switch (TipoBusqueda.getSelectedIndex() + 1) {

            case 1: {
                this.BuscarNombre(texto);
                break;
            }

            case 2: {
                this.BuscarCedula(texto);
                break;
            }
            case 3: {
                this.BuscarTelefono(texto);
                break;
            }

        }
    }//GEN-LAST:event_BuscarKeyReleased

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        int fila = this.jTable1.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showInternalMessageDialog(this, "Seleccione un cliente primero", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        f.IdClienteNatural = Integer.parseInt(dtm.getValueAt(fila, 0).toString());
        f.Cliente.setText((String) this.dtm.getValueAt(fila, 1) + " " + (String) this.dtm.getValueAt(fila, 3));
        f.IdClienteJuridico = -1;
        this.dispose();
    }//GEN-LAST:event_btnSeleccionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Buscar;
    private javax.swing.JComboBox TipoBusqueda;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
