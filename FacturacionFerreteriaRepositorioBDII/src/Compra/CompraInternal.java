package Compra;

import Dao.CodigoBarraDao;
import Dao.CompraDao;
import Dao.Dao;
import Dao.EmpleadoDao;
import Dao.ProductoDao;
import Dao.VendedoresDao;
import static MetodoComunes.Metodos.Centrar;
import static MetodoComunes.Metodos.LimpiarTabla;
import static MetodoComunes.Metodos.Redondear;
import POJO.Compra;
import POJO.DetalleCompra;
import POJO.Producto;
import Producto.SeleccionInventarioInternal;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;

/**
 *
 * @author Ing. Donaldo
 */
public class CompraInternal extends javax.swing.JInternalFrame {

    public int IDProveedor = -1, IDProducto = -1, IDVendedor = 1;
    public int IdEmpleado = 1;
    DefaultTableModel dtm;

    public CompraInternal() {
        initComponents();
        this.dtm = (DefaultTableModel) (jTable1.getModel());
    }

    public void ActualizarTotal() {
        double total = 0;
        for (int i = 0; i < dtm.getRowCount(); i++) {
            total += Double.parseDouble(dtm.getValueAt(i, 9).toString());
        }
        Total.setText(String.valueOf(Redondear(total)));
    }

    public int IndiceRepetidoCodigo(int Codigo) {
        for (int i = 0; i < dtm.getRowCount(); i++) {
            if (Integer.parseInt(dtm.getValueAt(i, 0).toString()) == Codigo) {
                return i;
            }
        }
        return -1;
    }

    public boolean isDouble(String numero) {
        if (numero.contains(".")) {
            return true;
        } else {
            return false;
        }
    }

    public String getFechaActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        return formateador.format(ahora);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Superior = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        txtVendedor = new javax.swing.JTextField();
        btnAceptarCondicioens = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        TipoPago = new javax.swing.JComboBox();
        Fecha = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Proveedor = new javax.swing.JTextField();
        NumeroFactura = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        FechaCompra = new com.toedter.calendar.JDateChooser();
        Medio = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnBuscarProducto = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Cantidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Bonificacion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        PrecioUnitario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Descuento = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Producto = new javax.swing.JTextField();
        btnCancelarProducto = new javax.swing.JButton();
        Inferior = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnAnular = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        Total = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Compra");
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
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        Superior.setBackground(new java.awt.Color(65, 146, 141));
        Superior.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informacion inicial", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(254, 254, 254))); // NOI18N

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Lupa.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnAceptarCondicioens.setText("Aceptar");
        btnAceptarCondicioens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarCondicioensActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Proveedor");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Lupa.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setText("Tipo Compra");

        TipoPago.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Contado", "Credito" }));
        TipoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoPagoActionPerformed(evt);
            }
        });

        Fecha.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        Fecha.setForeground(new java.awt.Color(254, 254, 254));
        Fecha.setText("Fecha");

        jLabel10.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(254, 254, 254));
        jLabel10.setText("No. Factura");

        NumeroFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NumeroFacturaKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NumeroFacturaKeyReleased(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(254, 254, 254));
        jLabel11.setText("Ejecutivo de venta");

        javax.swing.GroupLayout SuperiorLayout = new javax.swing.GroupLayout(Superior);
        Superior.setLayout(SuperiorLayout);
        SuperiorLayout.setHorizontalGroup(
            SuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SuperiorLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(SuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(SuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(SuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FechaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(SuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAceptarCondicioens, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        SuperiorLayout.setVerticalGroup(
            SuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SuperiorLayout.createSequentialGroup()
                .addGroup(SuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SuperiorLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(SuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(SuperiorLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(SuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(Fecha)))
                            .addComponent(FechaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(SuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(Proveedor, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(SuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtVendedor)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(SuperiorLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(btnAceptarCondicioens))
                    .addGroup(SuperiorLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel11))
                    .addGroup(SuperiorLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel10))
                    .addGroup(SuperiorLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(NumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        getContentPane().add(Superior);

        Medio.setBackground(new java.awt.Color(65, 146, 141));
        Medio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informacion inicial", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(254, 254, 254))); // NOI18N
        Medio.setForeground(new java.awt.Color(254, 254, 254));

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setText("Producto");

        btnBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Lupa.png"))); // NOI18N
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setText("Cantidad");

        Cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CantidadKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(254, 254, 254));
        jLabel5.setText("Bonificacion");

        Bonificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BonificacionKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setText("Precio Unitario");

        PrecioUnitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PrecioUnitarioKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(254, 254, 254));
        jLabel7.setText("Descuento");

        Descuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DescuentoKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(254, 254, 254));
        jLabel8.setText("%");

        btnCancelarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/1435735624_delete.png"))); // NOI18N
        btnCancelarProducto.setToolTipText("Eliminar la seleccion del producto a vender");
        btnCancelarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MedioLayout = new javax.swing.GroupLayout(Medio);
        Medio.setLayout(MedioLayout);
        MedioLayout.setHorizontalGroup(
            MedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MedioLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(MedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(MedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MedioLayout.createSequentialGroup()
                        .addComponent(Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(btnCancelarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(MedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(MedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MedioLayout.createSequentialGroup()
                        .addComponent(Descuento, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addGroup(MedioLayout.createSequentialGroup()
                        .addComponent(PrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Bonificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        MedioLayout.setVerticalGroup(
            MedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MedioLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(MedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MedioLayout.createSequentialGroup()
                        .addGroup(MedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Producto)
                            .addComponent(btnCancelarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(7, 7, 7)
                        .addGroup(MedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(MedioLayout.createSequentialGroup()
                        .addGroup(MedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(Bonificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGroup(MedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MedioLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel7))
                            .addGroup(MedioLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(MedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Descuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)))))
                    .addGroup(MedioLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3)))
                .addGap(10, 10, 10))
        );

        getContentPane().add(Medio);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Producto", "Nombre Producto", "Cantidad", "Bonificacion (unidades)", "Precio Unitario", "Subtotal", "Descuento (%)", "Descuento", "IVA", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Save 16x16.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnAnular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/trash.png"))); // NOI18N
        btnAnular.setText("Anular");
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });

        jLabel9.setText("Total");

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/add.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Cancel.png"))); // NOI18N
        btnEliminarProducto.setText("Eliminar Producto");
        btnEliminarProducto.setEnabled(false);
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout InferiorLayout = new javax.swing.GroupLayout(Inferior);
        Inferior.setLayout(InferiorLayout);
        InferiorLayout.setHorizontalGroup(
            InferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InferiorLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1098, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InferiorLayout.createSequentialGroup()
                .addContainerGap(504, Short.MAX_VALUE)
                .addGroup(InferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(InferiorLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(InferiorLayout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        InferiorLayout.setVerticalGroup(
            InferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnEliminarProducto)
                    .addComponent(btnAnular)
                    .addComponent(btnGuardar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap())
        );

        getContentPane().add(Inferior);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        SeleccionInventarioInternal s = new SeleccionInventarioInternal(this);
        Centrar(s, getDesktopPane());
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        BuscarProveedores b = new BuscarProveedores(this);
        Centrar(b, getDesktopPane());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String NoFactura = this.NumeroFactura.getText();
        Date fecha;
        String moneda = "";

        if (IDVendedor == -1) {
            JOptionPane.showInternalMessageDialog(this, "No ha seleccionado a ningun proveedor", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (dtm.getRowCount() == 0) {
            JOptionPane.showInternalMessageDialog(this, "No ha realizado ninguna compra", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (NoFactura.trim().equals("")) {
            JOptionPane.showInternalMessageDialog(this, "Numero de factura invalido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            fecha = this.FechaCompra.getDate();
        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(this, "La fecha digitada es invalida", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (fecha == null) {
            JOptionPane.showInternalMessageDialog(this, "La fecha digitada es invalida", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (fecha.getTime() > new Date().getTime()) {
            JOptionPane.showInternalMessageDialog(this, "La fecha de compra no puede ser mayor a la fecha actual", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Compra c = new Compra();
        c.setVendedores(new VendedoresDao().getById(this.IDVendedor));
        c.setEmpleados(new EmpleadoDao().getById(this.IdEmpleado));
        c.setTipoFactura(this.TipoPago.getSelectedItem().toString());
        c.setNoFactura(NoFactura);
        c.setFechaCompra(fecha);
        c.setMoneda(moneda);
        if (this.TipoPago.getSelectedIndex() == 1) {
            c.setPagado(true);
        } else {
            c.setPagado(false);
        }
        c.setAnulado(false);

        int id = (int) new Dao().Guardar(c);

        if (id == -1) {
            JOptionPane.showInternalMessageDialog(this, "No se puede guardar \n intente mas tarde, si el problema persiste contactese con el administrador del sistema", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Compra compra = new CompraDao().getById(id);

        for (int i = 0; i < dtm.getRowCount(); i++) {
            int idproducto = Integer.parseInt( this.jTable1.getValueAt(i, 0).toString());
            float cantidad = Float.parseFloat(this.jTable1.getValueAt(i, 2).toString());
            float bonificacion = Float.parseFloat(this.jTable1.getValueAt(i, 3).toString());
            float precio = Float.parseFloat(this.jTable1.getValueAt(i, 4).toString());
            float descuento = Float.parseFloat(this.jTable1.getValueAt(i, 6).toString());
            float iva = Float.parseFloat(this.jTable1.getValueAt(i, 8).toString());
            
            DetalleCompra dc = new DetalleCompra();
            dc.setCompra(compra);
            dc.setProducto(new ProductoDao().getById(idproducto));
            dc.setCantidadProducto(cantidad);
            dc.setBonificacion(bonificacion);
            dc.setPrecioUnitario(precio);
            dc.setDescuento(descuento);
            dc.setIva(iva);

            int iddetalle = (int) new Dao().Guardar(dc);

            if (iddetalle == -1) {
                JOptionPane.showInternalMessageDialog(this, "No se puede guardar \n intente mas tarde, si el problema persiste contactese con el administrador del sistema", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        btnAnularActionPerformed(null);
        JOptionPane.showInternalMessageDialog(this, "Compra guardada exitosamente", "informacion" , JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        Producto p;
        if (IDProducto == -1) {
            p = new CodigoBarraDao().getProducto(this.Producto.getText());

            if (p == null) {
                JOptionPane.showInternalMessageDialog(this, "El codigo de producto ingresado no existe", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            p = new ProductoDao().getById(IDProducto);
            if (p == null) {
                JOptionPane.showInternalMessageDialog(this, "El producto no esta registrado o no existe", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        if (Bonificacion.getText().trim().equals("")) {
            Bonificacion.setText("0");
        }

        if (Cantidad.getText().trim().equals("")) {
            JOptionPane.showInternalMessageDialog(this, "No ha ingresado la cantidad a vender", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (Descuento.getText().equals("")) {
            JOptionPane.showInternalMessageDialog(this, "No ha ingresado el descuento", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (Double.parseDouble(Descuento.getText()) > 100) {
            JOptionPane.showInternalMessageDialog(this, "El descuento no puede ser mayor al 100%", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (Bonificacion.getText().equals("")) {
            JOptionPane.showInternalMessageDialog(this, "No ha ingresado las bonificaciones", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (Cantidad.getText().equals("")) {
            JOptionPane.showInternalMessageDialog(this, "No ha ingresado las Cantidades", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (PrecioUnitario.getText().equals("")) {
            JOptionPane.showInternalMessageDialog(this, "No ha ingresado el precio unitario", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double cantidad;
        double bonificacion;
        double descuento;
        double preciounitario;
        try {
            cantidad = Double.parseDouble(Cantidad.getText());
            bonificacion = Double.parseDouble(Bonificacion.getText());
            descuento = Double.parseDouble(Descuento.getText()) / 100;
            preciounitario = Double.parseDouble(PrecioUnitario.getText());
        } catch (NumberFormatException nf) {
            JOptionPane.showInternalMessageDialog(this, "Tiene Caracteres invalidos o campos vacios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!p.getTipoVenta().equals("unidad")) {
            if (cantidad - (int) cantidad != 0.0) {
                JOptionPane.showInternalMessageDialog(this, "Las cantidades para este producto no pueden ser decimales", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (isDouble(Bonificacion.getText())) {
                JOptionPane.showInternalMessageDialog(this, "Las bonificaciones para este producto no pueden ser decimales", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        int indice = IndiceRepetidoCodigo(IDProducto);
        if (indice != -1) {
            double preciotabla = Double.parseDouble(dtm.getValueAt(indice, 4).toString());
            double desc = Double.parseDouble(dtm.getValueAt(indice, 6).toString());
            if (preciounitario == preciotabla && descuento * 100 == desc) {
                double NCantidad = Double.parseDouble(dtm.getValueAt(indice, 2).toString()) + cantidad;
                double NBonificacion = Double.parseDouble(dtm.getValueAt(indice, 3).toString()) + bonificacion;
                double NIVA;
                double NSubt;
                double NDescM;
                double NTotal;

                NSubt = NCantidad * preciotabla;
                NDescM = NSubt * (desc / 100);
                NIVA = 0.15 * (NSubt - NDescM);
                NTotal = NSubt - NDescM + NIVA;

                dtm.setValueAt(NCantidad, indice, 2);
                dtm.setValueAt(NBonificacion, indice, 3);
                dtm.setValueAt(Redondear(NSubt), indice, 5);
                dtm.setValueAt(Redondear(NDescM), indice, 7);
                dtm.setValueAt(Redondear(NIVA), indice, 8);
                dtm.setValueAt(Redondear(NTotal), indice, 9);
                ActualizarTotal();
                IDProducto = -1;
                Producto.setText(null);
                Cantidad.setText(null);
                Bonificacion.setText(null);
                PrecioUnitario.setText(null);
                Descuento.setText(null);
                this.btnEliminarProducto.setEnabled(false);
                return;
            }
        }

        //buscar el producto a ingresar
        double subtotal = cantidad * preciounitario;
        double descuentoM = subtotal * descuento;
        double iva;
        double total;
        if (p.isIva()) {
            iva = (subtotal - descuentoM) * 0.15;
            total = subtotal - descuentoM + iva;
        } else {
            iva = 0;
            total = subtotal - descuentoM;
        }
        dtm.addRow(new Object[]{IDProducto, p.getNombre(), cantidad, bonificacion, preciounitario, Redondear(subtotal), descuento * 100, Redondear(descuentoM), Redondear(iva), Redondear(total)});
        ActualizarTotal();
        IDProducto = -1;
        Producto.setText(null);
        Cantidad.setText(null);
        Bonificacion.setText(null);
        PrecioUnitario.setText(null);
        Descuento.setText(null);
        this.btnEliminarProducto.setEnabled(false);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        int indice = jTable1.getSelectedRow();
        if (indice != -1) {
            dtm.removeRow(indice);
            ActualizarTotal();
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un producto de la tabla", "Advertencia", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (IDProveedor == -1) {
            JOptionPane.showInternalMessageDialog(this, "No ha seleccionado ningun proveedor", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        BuscarVendedor b = new BuscarVendedor(this);
        Centrar(b, this.getDesktopPane());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void TipoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoPagoActionPerformed

    }//GEN-LAST:event_TipoPagoActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        FechaCompra.setDate(new Date());
        txtVendedor.setEditable(false);
        Proveedor.setEditable(false);
        
        Producto.setEnabled(false);
        Cantidad.setEnabled(false);
        btnBuscarProducto.setEnabled(false);
        Bonificacion.setEnabled(false);
        Descuento.setEnabled(false);
        PrecioUnitario.setEnabled(false);
        this.btnGuardar.setEnabled(false);
        this.btnCancelarProducto.setEnabled(false);
        this.btnAgregar.setEnabled(false);
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnAceptarCondicioensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarCondicioensActionPerformed
        if (IDProveedor == -1) {
            JOptionPane.showInternalMessageDialog(this, "No ha seleccionado el proveedor", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (IDVendedor == -1) {
            JOptionPane.showInternalMessageDialog(this, "No ha seleccionado al vendedor", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (NumeroFactura.getText().trim().equals("")) {
            JOptionPane.showInternalMessageDialog(this, "No ha ingresado el numero de factura", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (TipoPago.getSelectedIndex() == 0) {
            JOptionPane.showInternalMessageDialog(this, "No ha seleccionado el tipo de compra", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

           // Conectar("Compras.dat");
//            for (POJOCompra c : new CompraDaoImp().EncontrarTodos()) {
//                if (c.getNumeroFactura().equals(NumeroFactura.getText().trim()) && IDProveedor == c.getIdProveedor()) {
//                    JOptionPane.showInternalMessageDialog(this, "El numero de factura ingresado ya ha sido usado", "Error", JOptionPane.ERROR_MESSAGE);
//                    return;
//                }
//            }
        Producto.setEnabled(true);
        Cantidad.setEnabled(true);
        Bonificacion.setEnabled(true);
        Descuento.setEnabled(true);
        PrecioUnitario.setEnabled(true);

        Proveedor.setEnabled(false);
        txtVendedor.setEnabled(false);
        NumeroFactura.setEnabled(false);
        TipoPago.setEnabled(false);
        btnBuscarProducto.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnAgregar.setEnabled(true);
    }//GEN-LAST:event_btnAceptarCondicioensActionPerformed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        formInternalFrameOpened(null);
        Producto.setEnabled(false);
        Cantidad.setEnabled(false);
        Bonificacion.setEnabled(false);
        Descuento.setEnabled(false);
        PrecioUnitario.setEnabled(false);

        Proveedor.setEnabled(true);
        txtVendedor.setEnabled(true);
        NumeroFactura.setEnabled(true);
        TipoPago.setEnabled(true);
        btnBuscarProducto.setEnabled(false);

        Producto.setText(null);
        Cantidad.setText(null);
        Bonificacion.setText(null);
        Descuento.setText(null);
        PrecioUnitario.setText(null);
        Proveedor.setText(null);
        txtVendedor.setText(null);
        NumeroFactura.setText(null);
        TipoPago.setSelectedIndex(0);
        IDProducto = -1;
        IDProveedor = -1;
        this.btnCancelarProducto.setEnabled(false);
        this.btnBuscarProducto.setEnabled(false);
        //IDRepresentante = -1;

        LimpiarTabla(dtm);
        this.ActualizarTotal();
    }//GEN-LAST:event_btnAnularActionPerformed

    private void CantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CantidadKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && !(c == '.' && !Cantidad.getText().contains("."))) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_CantidadKeyTyped

    private void BonificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BonificacionKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && !(c == '.' && !Bonificacion.getText().contains("."))) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_BonificacionKeyTyped

    private void PrecioUnitarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PrecioUnitarioKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && !(c == '.' && !PrecioUnitario.getText().contains("."))) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_PrecioUnitarioKeyTyped

    private void DescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DescuentoKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && !(c == '.' && !Descuento.getText().contains("."))) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_DescuentoKeyTyped

    private void NumeroFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NumeroFacturaKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && !Character.isAlphabetic(c)) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_NumeroFacturaKeyTyped

    private void NumeroFacturaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NumeroFacturaKeyReleased
        NumeroFactura.setText(NumeroFactura.getText().toUpperCase());
    }//GEN-LAST:event_NumeroFacturaKeyReleased

    private void btnCancelarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarProductoActionPerformed
        this.IDProducto = -1;
        this.Producto.setText(null);
        this.Producto.setEnabled(true);
        this.btnCancelarProducto.setEnabled(false);
    }//GEN-LAST:event_btnCancelarProductoActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        this.btnEliminarProducto.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Bonificacion;
    private javax.swing.JTextField Cantidad;
    private javax.swing.JTextField Descuento;
    private javax.swing.JLabel Fecha;
    private com.toedter.calendar.JDateChooser FechaCompra;
    private javax.swing.JPanel Inferior;
    private javax.swing.JPanel Medio;
    private javax.swing.JTextField NumeroFactura;
    private javax.swing.JTextField PrecioUnitario;
    public javax.swing.JTextField Producto;
    public javax.swing.JTextField Proveedor;
    private javax.swing.JPanel Superior;
    private javax.swing.JComboBox TipoPago;
    private javax.swing.JTextField Total;
    private javax.swing.JButton btnAceptarCondicioens;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAnular;
    private javax.swing.JButton btnBuscarProducto;
    public javax.swing.JButton btnCancelarProducto;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public javax.swing.JTextField txtVendedor;
    // End of variables declaration//GEN-END:variables
}
