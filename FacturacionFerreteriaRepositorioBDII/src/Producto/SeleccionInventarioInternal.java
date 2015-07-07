/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Producto;

import Compra.CompraInternal;
import Dao.ProductoDao;
import static MetodoComunes.Metodos.LimpiarTabla;
import Modelos.Inventario;
import Venta.FacturaInternal;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ingdonaldo
 */
public class SeleccionInventarioInternal extends javax.swing.JInternalFrame {
    DefaultTableModel tabla = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    /**
     * Creates new form SeleccionInventarioInternal
     */
    FacturaInternal factura;
    CompraInternal compra;
    public SeleccionInventarioInternal(FacturaInternal factura) {
        initComponents();
        this.factura = factura;
        InicializarTabla();
        CargarTabla();
    }
    
    
    public SeleccionInventarioInternal(CompraInternal compra){
        initComponents();
        this.compra = compra;
        InicializarTabla();
        CargarTabla();
    }

    
    public void InicializarTabla() {
        String encab[] = {"Id", "Codigo Barra", "Categoria", "Nombre", "Precio Venta", "Precio Inventario", "Tipo Venta", "Cantidad minima", "Cantidad Inventario", "Descripcion", "IVA", "Estado"};
        tabla.setColumnIdentifiers(encab);
        Datos.setModel(tabla);
    }
    
    
    public void CargarTabla() {

        LimpiarTabla(tabla);

        for (Inventario i : new ProductoDao().getInventario()) {
            this.tabla.addRow(new Object[]{i.getIdProducto(), i.getCodigoBarra(), i.getCategoria(), i.getNombre(), i.getPrecioVenta(), i.getPrecioInventario(),
                i.getTipoVenta(), i.getCantidadMinima(), i.getCantidadInventario(), i.getDescripcion(), i.isIva() ? "Incluye IVA" : "No Incluye IVA", i.isEstado() ? "Activo" : "Inactivo"});
        }
    }

    public void BuscarNombre(String nombre) {

        LimpiarTabla(tabla);

        for (Inventario i : new ProductoDao().getInventario()) {
            if (i.getNombre().equalsIgnoreCase(nombre)||i.getNombre().contains(nombre)||i.getNombre().endsWith(nombre)
                    ||i.getNombre().startsWith(nombre)) {
                this.tabla.addRow(new Object[]{i.getIdProducto(), i.getCodigoBarra(), i.getCategoria(), i.getNombre(), i.getPrecioVenta(), i.getPrecioInventario(),
                    i.getTipoVenta(), i.getCantidadMinima(), i.getCantidadInventario(), i.getDescripcion(), i.isIva() ? "Incluye IVA" : "No Incluye IVA", i.isEstado() ? "Activo" : "Inactivo"});
            }
        }
    }

    public void BuscarCategoria(String nombre) {

        LimpiarTabla(tabla);

        for (Inventario i : new ProductoDao().getInventario()) {
            if (i.getCategoria().equalsIgnoreCase(nombre)||i.getCategoria().contains(nombre)||i.getCategoria().endsWith(nombre)
                    ||i.getCategoria().startsWith(nombre)) {
                this.tabla.addRow(new Object[]{i.getIdProducto(), i.getCodigoBarra(), i.getCategoria(), i.getNombre(), i.getPrecioVenta(), i.getPrecioInventario(),
                    i.getTipoVenta(), i.getCantidadMinima(), i.getCantidadInventario(), i.getDescripcion(), i.isIva() ? "Incluye IVA" : "No Incluye IVA", i.isEstado() ? "Activo" : "Inactivo"});
            }
        }
    }
    
    public void BuscarCodigoBarra(String nombre) {

        LimpiarTabla(tabla);

        for (Inventario i : new ProductoDao().getInventario()) {
            if (i.getCodigoBarra().equalsIgnoreCase(nombre)) {
                this.tabla.addRow(new Object[]{i.getIdProducto(), i.getCodigoBarra(), i.getCategoria(), i.getNombre(), i.getPrecioVenta(), i.getPrecioInventario(),
                    i.getTipoVenta(), i.getCantidadMinima(), i.getCantidadInventario(), i.getDescripcion(), i.isIva() ? "Incluye IVA" : "No Incluye IVA", i.isEstado() ? "Activo" : "Inactivo"});
            }
        }
    }
    
    public void BuscarId(String nombre) {

        LimpiarTabla(tabla);

        for (Inventario i : new ProductoDao().getInventario()) {
            if (String.valueOf(i.getIdProducto()).equalsIgnoreCase(nombre)) {
                this.tabla.addRow(new Object[]{i.getIdProducto(), i.getCodigoBarra(), i.getCategoria(), i.getNombre(), i.getPrecioVenta(), i.getPrecioInventario(),
                    i.getTipoVenta(), i.getCantidadMinima(), i.getCantidadInventario(), i.getDescripcion(), i.isIva() ? "Incluye IVA" : "No Incluye IVA", i.isEstado() ? "Activo" : "Inactivo"});
            }
        }
    }
    
    public void MostrarActivosInactivos(boolean activos) {

        LimpiarTabla(tabla);

        for (Inventario i : new ProductoDao().getInventario()) {
            if (i.isEstado()==activos) {
                this.tabla.addRow(new Object[]{i.getIdProducto(), i.getCodigoBarra(), i.getCategoria(), i.getNombre(), i.getPrecioVenta(), i.getPrecioInventario(),
                    i.getTipoVenta(), i.getCantidadMinima(), i.getCantidadInventario(), i.getDescripcion(), i.isIva() ? "Incluye IVA" : "No Incluye IVA", i.isEstado() ? "Activo" : "Inactivo"});
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AdmProductos = new javax.swing.JPanel();
        Buscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Datos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        TipoBusqueda = new javax.swing.JComboBox();
        btnEditar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Busque de producto");

        AdmProductos.setBackground(new java.awt.Color(65, 146, 141));
        AdmProductos.setPreferredSize(new java.awt.Dimension(400, 300));

        Buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscarKeyReleased(evt);
            }
        });

        Datos.setAutoCreateRowSorter(true);
        Datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Datos.getTableHeader().setReorderingAllowed(false);
        Datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Datos);

        jLabel5.setText("Buscar por");

        TipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "Codigo Barra", "Id", "Categoria" }));

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/check.png"))); // NOI18N
        btnEditar.setText("Seleccionar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AdmProductosLayout = new javax.swing.GroupLayout(AdmProductos);
        AdmProductos.setLayout(AdmProductosLayout);
        AdmProductosLayout.setHorizontalGroup(
            AdmProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdmProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AdmProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(AdmProductosLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        AdmProductosLayout.setVerticalGroup(
            AdmProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdmProductosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(AdmProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(TipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AdmProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AdmProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarKeyReleased
        btnEditar.setEnabled(false);
        String texto = Buscar.getText();
        if(texto.trim().equals("")){
            this.CargarTabla();
            return;
        }
        switch (TipoBusqueda.getSelectedIndex() + 1) {

            case 1: {
                this.BuscarNombre(texto);
                break;
            }
            case 2: {
                this.BuscarCodigoBarra(texto);
                break;
            }
            case 3: {
                this.BuscarId(texto);
                break;
            }
            case 4: {
                this.BuscarCategoria(texto);
                break;
            }

        }
    }//GEN-LAST:event_BuscarKeyReleased

    private void DatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DatosMouseClicked
        btnEditar.setEnabled(true);
    }//GEN-LAST:event_DatosMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int fila  =  this.Datos.getSelectedRow();

        
        if(fila == -1){
            JOptionPane.showInternalMessageDialog(this, "Seleccione un producto primero" , "Error" , JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(factura !=null){
        factura.IdProducto =  Integer.parseInt(Datos.getValueAt(fila, 0).toString());
        factura.btnCancelarProducto.setEnabled(true);
        factura.Cod.setText((String)this.tabla.getValueAt(fila, 3));
        factura.Cod.setEditable(false);
        this.dispose();
        }
        if(compra != null){
        compra.IDProducto =  Integer.parseInt(Datos.getValueAt(fila, 0).toString());
        compra.btnCancelarProducto.setEnabled(true);
        compra.Producto.setText((String)this.tabla.getValueAt(fila, 3));
        compra.Producto.setEditable(false);
        this.dispose();
        
        }
    }//GEN-LAST:event_btnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AdmProductos;
    private javax.swing.JTextField Buscar;
    private javax.swing.JTable Datos;
    private javax.swing.JComboBox TipoBusqueda;
    private javax.swing.JButton btnEditar;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
