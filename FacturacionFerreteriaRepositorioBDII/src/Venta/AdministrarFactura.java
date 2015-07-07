package Venta;

import Dao.Dao;
import Dao.VentaDao;
import static MetodoComunes.Metodos.LimpiarTabla;
import static MetodoComunes.Metodos.Redondear;
import Modelos.Factura;
import POJO.Venta;
import java.beans.PropertyVetoException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ing. Donaldo
 */
public class AdministrarFactura extends javax.swing.JInternalFrame {

    DefaultTableModel dtm = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    int IdCliente;

    /**
     * Creates new form AdministrarFactura
     */
    public AdministrarFactura() {
        initComponents();
        String[] encabezado = {"No. Factura", "Fecha", "Cajero", "Tipo Factura", "Cliente", "Subtotal", "Descuento", "IVA", "Mora", "Total", "Pagado", "Anulado"};
        dtm.setColumnIdentifiers(encabezado);

        jTable1.setModel(dtm);
        Cargar();
        PanelFechas.setVisible(false);
    }

    public void Cargar() {
        for (Factura f : new VentaDao().getFacturas()) {
            AgregarFila(f);
        }
    }
    
    
    public void CargarContado(){
        for (Factura f : new VentaDao().getFacturas()) {
            if(f.getTipoFactura().equals("Contado")){
                AgregarFila(f);
            }  
        }
    }
    
    public void CargarCredito(){
        for (Factura f : new VentaDao().getFacturas()) {
            if(f.getTipoFactura().equals("Credito")){
                AgregarFila(f);
            }  
        }
    }
    
    public void CargarCreditoNoPago(){
        for (Factura f : new VentaDao().getFacturas()) {
            if(f.getTipoFactura().equals("Credito") && f.getEstado().equalsIgnoreCase("no pagado")){
                AgregarFila(f);
            }  
        }
    }
    
    public void CargarAnulado(){
        for (Factura f : new VentaDao().getFacturas()) {
            if(f.isAnulado()){
                AgregarFila(f);
            }  
        }
    }
    
    public void CargarNoAnulado(){
        for (Factura f : new VentaDao().getFacturas()) {
            if(!f.isAnulado()){
                AgregarFila(f);
            }  
        }
    }
    
    ///Busquedas filtradas por fecha
        public void Cargar(String fechainicial, String fechafinal) {
        for (Factura f : new VentaDao().getFacturas(fechainicial,fechafinal)) {
            AgregarFila(f);
        }
    }
    
    
    public void CargarContado(String fechainicial, String fechafinal) {
        for (Factura f : new VentaDao().getFacturas(fechainicial,fechafinal)) {
            if(f.getTipoFactura().equals("Contado")){
                AgregarFila(f);
            }  
        }
    }
    
    public void CargarCredito(String fechainicial, String fechafinal) {
        for (Factura f : new VentaDao().getFacturas(fechainicial,fechafinal)) {
            if(f.getTipoFactura().equals("Credito")){
                AgregarFila(f);
            }  
        }
    }
    
    public void CargarCreditoNoPago(String fechainicial, String fechafinal) {
        for (Factura f : new VentaDao().getFacturas(fechainicial,fechafinal)) {
            if(f.getTipoFactura().equals("Credito") && f.getEstado().equalsIgnoreCase("no pagado")){
                AgregarFila(f);
            }  
        }
    }
    
    public void CargarAnulado(String fechainicial, String fechafinal) {
        for (Factura f : new VentaDao().getFacturas(fechainicial,fechafinal)) {
            if(f.isAnulado()){
                AgregarFila(f);
            }  
        }
    }
    
    public void CargarNoAnulado(String fechainicial, String fechafinal) {
        for (Factura f : new VentaDao().getFacturas(fechainicial,fechafinal)) {
            if(!f.isAnulado()){
                AgregarFila(f);
            }  
        }
    }
    
    /////////////////////
    public void AgregarFila(Factura f){
        if (f.getTipoFactura().equals("Contado")) {
                dtm.addRow(new Object[]{
                    f.getNoFactura(), f.getFecha(), f.getCajero(), f.getTipoFactura(),
                    f.getCliente(), Redondear(f.getSubtotal()),
                    Redondear(f.getDescuento()), Redondear(f.getIVA()),
                    "-", Redondear(f.getTotal()), f.getEstado(), f.isAnulado() ? "Anulado" : "No anulado"
                });
            } else {
                dtm.addRow(new Object[]{
                    f.getNoFactura(), f.getFecha(), f.getCajero(), f.getTipoFactura(),
                    f.getCliente(), Redondear(f.getSubtotal()),
                    Redondear(f.getDescuento()), Redondear(f.getIVA()),
                    Redondear(f.getMora()), Redondear(f.getTotal()), f.getEstado(), f.isAnulado() ? "Anulado" : "No anulado"
                });

            }
    
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Filtro = new javax.swing.JComboBox();
        btnDetalle = new javax.swing.JButton();
        btnAnular = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        PanelFechas = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        FechaInicial = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        FechaFinal = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Administrador de factura");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setToolTipText("Facturas realizadas");
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setOpaque(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        Filtro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todo", "Facturas de contado", "Facturas de credito", "Facturas de credito sin pagar", "Anulado", "No anulado" }));
        Filtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltroActionPerformed(evt);
            }
        });

        btnDetalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Lupa.png"))); // NOI18N
        btnDetalle.setText("Ver Detalle de factura");
        btnDetalle.setEnabled(false);
        btnDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalleActionPerformed(evt);
            }
        });

        btnAnular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/trash.png"))); // NOI18N
        btnAnular.setText("Anular Factura");
        btnAnular.setEnabled(false);
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });

        btnPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Money.png"))); // NOI18N
        btnPagar.setText("Pagar Factura");
        btnPagar.setEnabled(false);
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        jLabel1.setText("Ver");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Printer.png"))); // NOI18N
        jButton5.setText("Abrir Reporte");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel2.setText("de");

        FechaInicial.setToolTipText("Fecha de realizacion de la factura");

        jLabel3.setText("a");

        FechaFinal.setToolTipText("Fecha de realizacion de la factura");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelFechasLayout = new javax.swing.GroupLayout(PanelFechas);
        PanelFechas.setLayout(PanelFechasLayout);
        PanelFechasLayout.setHorizontalGroup(
            PanelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFechasLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        PanelFechasLayout.setVerticalGroup(
            PanelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFechasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(FechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jCheckBox1.setText("Filtrar resultados por fecha");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 319, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDetalle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(PanelFechas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelFechas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(Filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addGap(7, 7, 7)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetalle)
                    .addComponent(btnAnular)
                    .addComponent(btnPagar)
                    .addComponent(jButton5))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed

        int fila = this.jTable1.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showInternalMessageDialog(this, "Seleccione una factura primero", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int seleccion = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular la factura", "Anular", JOptionPane.OK_OPTION);
        if (seleccion == 0) {

            int noFactura = Integer.parseInt(this.dtm.getValueAt(fila, 0).toString());

            Venta v = new VentaDao().getVenta(noFactura);
            if (v.isAnulado()) {
                JOptionPane.showInternalMessageDialog(this, "Esta factura ya ha sido anulada", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            v.setAnulado(true);
            boolean actualizado = new Dao().Actualizar(v);
            if (actualizado) {
                JOptionPane.showInternalMessageDialog(this, "Factura anulada exitosamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                this.Cargar();
            } else {
                JOptionPane.showInternalMessageDialog(this, "No se pudo anular la factura", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_btnAnularActionPerformed

    private void btnDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalleActionPerformed

    }//GEN-LAST:event_btnDetalleActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed

    }//GEN-LAST:event_btnPagarActionPerformed

    private void FiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltroActionPerformed

        if (!this.jCheckBox1.isSelected()) {
            LimpiarTabla(this.dtm);
            switch (this.Filtro.getSelectedIndex() + 1) {
                //Ver todo
                case 1: {
                    Cargar();
                    break;
                }
                //Ver de contado
                case 2: {
                    CargarContado();
                    break;
                }
                //ver de credito
                case 3: {
                    CargarCredito();
                    break;
                }
                //ver de credito sin pagar
                case 4: {
                    this.CargarCreditoNoPago();
                    break;
                }
                //ver Anuladas
                case 5: {
                    CargarAnulado();
                    break;
                }
                //ver no anuladas
                case 6: {
                    CargarNoAnulado();
                    break;
                }

            }

        }
    }//GEN-LAST:event_FiltroActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        try {
            setMaximum(true);
        } catch (PropertyVetoException ex) {

        }
    }//GEN-LAST:event_formInternalFrameOpened

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        this.btnAnular.setEnabled(true);
        this.btnDetalle.setEnabled(true);
        this.btnPagar.setEnabled(true);
        if (evt.getClickCount() == 2) {
            btnDetalleActionPerformed(null);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (this.jCheckBox1.isSelected()) {
            PanelFechas.setVisible(true);
        } else {
            PanelFechas.setVisible(false);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        String fechaInicial;
        String fechaFinal;
        try{
        fechaInicial = formateador.format(this.FechaInicial.getDate());
        fechaFinal = formateador.format(this.FechaFinal.getDate());
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Fechas invalidas, por favor revise que sean fechas validas", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (this.jCheckBox1.isSelected()) {
            LimpiarTabla(this.dtm);
            switch (this.Filtro.getSelectedIndex() + 1) {
                //Ver todo
                case 1: {
                    Cargar(fechaInicial,fechaFinal);
                    break;
                }
                //Ver de contado
                case 2: {
                    CargarContado(fechaInicial,fechaFinal);
                    break;
                }
                //ver de credito
                case 3: {
                    CargarCredito(fechaInicial,fechaFinal);
                    break;
                }
                //ver de credito sin pagar
                case 4: {
                    this.CargarCreditoNoPago(fechaInicial,fechaFinal);
                    break;
                }
                //ver Anuladas
                case 5: {
                    CargarAnulado(fechaInicial,fechaFinal);
                    break;
                }
                //ver no anuladas
                case 6: {
                    CargarNoAnulado(fechaInicial,fechaFinal);
                    break;
                }

            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser FechaFinal;
    private com.toedter.calendar.JDateChooser FechaInicial;
    private javax.swing.JComboBox Filtro;
    private javax.swing.JPanel PanelFechas;
    private javax.swing.JButton btnAnular;
    private javax.swing.JButton btnDetalle;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
