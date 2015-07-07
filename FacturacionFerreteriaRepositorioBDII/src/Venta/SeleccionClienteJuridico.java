package Venta;

import Dao.RepresentanteDao;
import static MetodoComunes.Metodos.LimpiarTabla;
import Modelos.RepresentanteCJ;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ingdonaldo
 */
public class SeleccionClienteJuridico extends javax.swing.JInternalFrame {

    DefaultTableModel dtm = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    /**
     * Creates new form SeleccionClienteJuridico
     */
    public void InicializarTabla() {
        dtm.addColumn("IDRepresentante");
        dtm.addColumn("Nombre Representante");
        dtm.addColumn("Primer Nombre");
        dtm.addColumn("Segundo Nombre");
        dtm.addColumn("Primer Apellido");
        dtm.addColumn("Segundo Apellido");
        dtm.addColumn("Cedula");
        dtm.addColumn("Direccion");
        dtm.addColumn("Correo");
        dtm.addColumn("Telefono");
        dtm.addColumn("Estado");
        jTable1.setModel(dtm);
    }
    FacturaInternal f;

    public SeleccionClienteJuridico(FacturaInternal f) {
        initComponents();
        this.f = f;
        InicializarTabla();
        Cargar();
    }

    public void Cargar() {
        LimpiarTabla(dtm);
        for (RepresentanteCJ rcj : new RepresentanteDao().getRepresentanteCJ()) {
            String estado = "Inactivo";
            if (rcj.isEstado()) {
                estado = "Activo";
            }
            dtm.addRow(new Object[]{rcj.getIdRepresentante(), rcj.getNombreEmpresa(), rcj.getPrimerNombre(),
                rcj.getSegundoNombre(), rcj.getPrimerApellido(), rcj.getSegundoApellido(), rcj.getCedula(),
                rcj.getDireccion(), rcj.getCorreoElectronico(), rcj.getTelefono(), estado});
        }
    }

    public void BuscarId(String texto) {
        LimpiarTabla(dtm);
        for (RepresentanteCJ rcj : new RepresentanteDao().getRepresentanteCJ()) {
            String estado = "Inactivo";
            if (rcj.isEstado()) {
                estado = "Activo";
            }
            if (rcj.isEstado() && String.valueOf(rcj.getIdRepresentante()).equals(texto)) {
                dtm.addRow(new Object[]{rcj.getIdRepresentante(), rcj.getNombreEmpresa(), rcj.getPrimerNombre(),
                    rcj.getSegundoNombre(), rcj.getPrimerApellido(), rcj.getSegundoApellido(), rcj.getCedula(),
                    rcj.getDireccion(), rcj.getCorreoElectronico(), rcj.getTelefono(), estado});
            }
        }
    }

    public void BuscarCedula(String texto) {
        LimpiarTabla(dtm);
        for (RepresentanteCJ rcj : new RepresentanteDao().getRepresentanteCJ()) {
            String estado = "Inactivo";
            if (rcj.isEstado()) {
                estado = "Activo";
            }

            if ((rcj.getCedula().equalsIgnoreCase(texto) || rcj.getCedula().startsWith(texto)) && rcj.isEstado()) {
                dtm.addRow(new Object[]{rcj.getIdRepresentante(), rcj.getNombreEmpresa(), rcj.getPrimerNombre(),
                    rcj.getSegundoNombre(), rcj.getPrimerApellido(), rcj.getSegundoApellido(), rcj.getCedula(),
                    rcj.getDireccion(), rcj.getCorreoElectronico(), rcj.getTelefono(), estado});
            }
        }

    }

    public void BuscarNombre(String texto) {
        LimpiarTabla(dtm);
        texto = texto.toLowerCase();
        for (RepresentanteCJ rcj : new RepresentanteDao().getRepresentanteCJ()) {
            String estado = "Inactivo";
            if (rcj.isEstado()) {
                estado = "Activo";
            }
            String NombreCliente = rcj.getPrimerNombre() + " " + rcj.getSegundoNombre() + " " + rcj.getPrimerApellido() + " " + rcj.getSegundoApellido();
            NombreCliente = NombreCliente.toLowerCase();
            if ((NombreCliente.startsWith(texto) || NombreCliente.contains(texto) || NombreCliente.endsWith(texto) || NombreCliente.equalsIgnoreCase(texto)) && rcj.isEstado()) {
                dtm.addRow(new Object[]{rcj.getIdRepresentante(), rcj.getNombreEmpresa(), rcj.getPrimerNombre(),
                    rcj.getSegundoNombre(), rcj.getPrimerApellido(), rcj.getSegundoApellido(), rcj.getCedula(),
                    rcj.getDireccion(), rcj.getCorreoElectronico(), rcj.getTelefono(), estado});
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Buscar = new javax.swing.JTextField();
        CbxBuscar = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Seleccion de cliente juridico");

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        Buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscarKeyReleased(evt);
            }
        });

        CbxBuscar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cédula", "Nombre", "Id", " " }));

        jLabel10.setForeground(new java.awt.Color(1, 1, 1));
        jLabel10.setText("Buscar por");

        btnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/check.png"))); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.setToolTipText("Seleccionar al cliente al que se le va a facturar");
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
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarKeyReleased

        btnSeleccionar.setEnabled(false);
        String texto = Buscar.getText();
        LimpiarTabla(dtm);
        if (texto.trim().equals("")) {
            Cargar();
            return;
        }

        switch (this.CbxBuscar.getSelectedIndex() + 1) {

            case 1: {
                BuscarCedula(texto);
                break;
            }

            case 2: {

                BuscarNombre(texto);
                break;
            }

            case 3: {
                BuscarId(texto);
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

        f.IdClienteJuridico = Integer.parseInt(dtm.getValueAt(fila, 0).toString());
        f.Cliente.setText((String) this.dtm.getValueAt(fila, 2) + " " + (String) this.dtm.getValueAt(fila, 4));
        f.IdClienteNatural = -1;
        this.dispose();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        btnSeleccionar.setEnabled(true);
        if(evt.getClickCount() ==2){
            btnSeleccionarActionPerformed(null);
        }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Buscar;
    private javax.swing.JComboBox CbxBuscar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
