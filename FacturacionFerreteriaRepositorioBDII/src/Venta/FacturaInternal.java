package Venta;

import Dao.CodigoBarraDao;
import Dao.Dao;
import Dao.ProductoDao;
import Dao.VentaDao;
import Main.MDI;
import static Methods.Validator.Redondear;
import static MetodoComunes.Metodos.Centrar;
import POJO.Cliente;
import POJO.ContratoCredito;
import POJO.DetalleFactura;
import POJO.Empleados;
import POJO.Pagos;
import POJO.Producto;
import POJO.RepresentanteClienteJuridico;
import POJO.Venta;
import POJO.VentaClienteJuridico;
import POJO.VentaClienteNatural;
import POJO.VentaCredito;
import Pago.Pago;
import Producto.SeleccionInventarioInternal;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.beans.PropertyVetoException;
import java.util.List;

/**
 *
 * @author Ing. Donaldo
 */
public class FacturaInternal extends javax.swing.JInternalFrame {

    DefaultTableModel dtm = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public int IdClienteNatural = -1;
    public int IdClienteJuridico = -1;
    public int IdEmpleado = -1;
    public int IdProducto = -1;
    public Venta v = null;
    MDI mdi;

    public FacturaInternal(MDI mdi , int IdEmpleado) {

        initComponents();
        this.IdEmpleado = IdEmpleado;
        this.mdi = mdi;
        pack();
        inicializar();
    }

    public FacturaInternal() {
        initComponents();
        pack();
        inicializar();
    }

    public void inicializar() {
        Fecha.setEnabled(false);
        Fecha.setDate(new Date());
        String encabezado[] = {"Codigo", "Descripcion", "Cantidad", "Bonificacion", "Precio unit", "Subtotal", "Descuento", "IVA", "Total"};
        dtm.setColumnIdentifiers(encabezado);
        Detalles.setModel(dtm);
        Subt.setEditable(false);
        Total.setEditable(false);
        Iva.setEditable(false);
        Desc.setEditable(false);
        Bonificacion.setEnabled(false);
        this.btnEliminarProducto.setEnabled(false);
        Cant.setTransferHandler(null);
        Cod.setTransferHandler(null);
        Bonificacion.setTransferHandler(null);
        Cliente.setTransferHandler(null);
        panelContratoCredito.setVisible(false);
        this.btnCancelarProducto.setEnabled(false);
        txtTasa.setTransferHandler(null);
        FechaVencimiento.setTransferHandler(null);
        
    }

    public String getFechaActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        return formateador.format(ahora);
    }

    public double CalcSubt() {
        double subt = 0;
        for (int i = 0; i < Detalles.getRowCount(); i++) {
            subt = subt + Double.parseDouble(String.valueOf(Detalles.getValueAt(i, 5)));
        }
        return subt;
    }

    public float CalcDesc() {
        float d = 0;
        if (Descuento.getSelectedItem().equals("0%")) {
        }
        if (Descuento.getSelectedItem().equals("5%")) {
            d = (float) 0.05;
        }
        if (Descuento.getSelectedItem().equals("15%")) {
            d = (float) 0.15;
        }
        if (Descuento.getSelectedItem().equals("30%")) {
            d = (float) 0.3;
        }
        return d;
    }

    public double CalcIva() {
        double Iva = 0;
        if (this.ExcentoIVA.isSelected()) {
            return 0;
        }
        for (int i = 0; i < Detalles.getRowCount(); i++) {
            Iva = Iva + Double.parseDouble(String.valueOf(Detalles.getValueAt(i, 7)));
        }
        return Iva;
    }

    public double CalcTot() {
        float tot = 0;
        for (int i = 0; i < Detalles.getRowCount(); i++) {
            tot += Double.parseDouble(String.valueOf(Detalles.getValueAt(i, 8)));
        }
        return tot;
    }

    public float CalcTotDesc() {
        float descuento = 0;
        for (int i = 0; i < Detalles.getRowCount(); i++) {
            descuento += Double.parseDouble(String.valueOf(Detalles.getValueAt(i, 6)));
        }
        return descuento;

    }

    public void ActualizarEstado() {
        Iva.setText(String.valueOf(Redondear((float) CalcIva())));
        Subt.setText(String.valueOf(Redondear((float) CalcSubt())));
        Total.setText(String.valueOf(Redondear((float) CalcTot())));
        Desc.setText(String.valueOf(Redondear(CalcTotDesc())));
    }

    public void Limpiar(DefaultTableModel dt) {
        int cont = dt.getRowCount();
        for (int i = cont - 1; i >= 0; i--) {
            dt.removeRow(i);
        }
        ActualizarEstado();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Izquierda = new javax.swing.JPanel();
        lblEmpresa = new javax.swing.JLabel();
        lblRuc = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnBuscarCliente = new javax.swing.JButton();
        TipoFactura = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        Cliente = new javax.swing.JTextField();
        Fecha = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        btnIniciarFacturacion = new javax.swing.JButton();
        panelContratoCredito = new javax.swing.JPanel();
        FechaVencimiento = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtTasa = new javax.swing.JTextField();
        Centro = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Cod = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Cant = new javax.swing.JTextField();
        btnBuscarProducto = new javax.swing.JButton();
        Bonificacion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnCancelarProducto = new javax.swing.JButton();
        Inferior = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Detalles = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnAnular = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        Subt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Iva = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Total = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Descuento = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        Desc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        ExcentoIVA = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Facturacion");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
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

        Izquierda.setBackground(new java.awt.Color(65, 146, 141));
        Izquierda.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informaicion General", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(254, 254, 254))); // NOI18N
        Izquierda.setForeground(new java.awt.Color(254, 254, 254));

        lblEmpresa.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        lblEmpresa.setForeground(new java.awt.Color(254, 254, 254));
        lblEmpresa.setText("Empresa");

        lblRuc.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        lblRuc.setForeground(new java.awt.Color(254, 254, 254));
        lblRuc.setText("RUC : 0011024560009Q");

        jLabel13.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(254, 254, 254));
        jLabel13.setText("Cliente");

        btnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Lupa.png"))); // NOI18N
        btnBuscarCliente.setToolTipText("Buscar un cliente para la factura");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        TipoFactura.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione tipo", "Contado", "Credito" }));
        TipoFactura.setToolTipText("Seleccion del tipo de factura a realizar");
        TipoFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoFacturaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(254, 254, 254));
        jLabel5.setText("Tipo de Factura: ");

        Cliente.setEditable(false);
        Cliente.setToolTipText("Cliente seleccionado para la factura");

        Fecha.setToolTipText("Fecha de realizacion de la factura");

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Fecha");

        btnIniciarFacturacion.setText("Aceptar");
        btnIniciarFacturacion.setToolTipText("Aceptacion de condiciones de factura");
        btnIniciarFacturacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarFacturacionActionPerformed(evt);
            }
        });

        panelContratoCredito.setBackground(new java.awt.Color(65, 146, 141));
        panelContratoCredito.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contrato de credito", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(254, 254, 254))); // NOI18N
        panelContratoCredito.setForeground(new java.awt.Color(254, 254, 254));

        FechaVencimiento.setToolTipText("Fecha tope para la realizacion del pago de la factura");

        jLabel12.setFont(new java.awt.Font("Cantarell", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(254, 254, 254));
        jLabel12.setText("Fecha Final de pago");

        jLabel14.setFont(new java.awt.Font("Cantarell", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(254, 254, 254));
        jLabel14.setText("Tasa de interes");

        txtTasa.setToolTipText("Tasa de interes aplicada en caso de mora");
        txtTasa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTasaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelContratoCreditoLayout = new javax.swing.GroupLayout(panelContratoCredito);
        panelContratoCredito.setLayout(panelContratoCreditoLayout);
        panelContratoCreditoLayout.setHorizontalGroup(
            panelContratoCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContratoCreditoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContratoCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12))
                .addGap(30, 30, 30)
                .addGroup(panelContratoCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTasa, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                    .addComponent(FechaVencimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );
        panelContratoCreditoLayout.setVerticalGroup(
            panelContratoCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContratoCreditoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(panelContratoCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel12)
                    .addComponent(FechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(panelContratoCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel14)
                    .addComponent(txtTasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout IzquierdaLayout = new javax.swing.GroupLayout(Izquierda);
        Izquierda.setLayout(IzquierdaLayout);
        IzquierdaLayout.setHorizontalGroup(
            IzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IzquierdaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(IzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(lblEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(IzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TipoFactura, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Cliente, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(IzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblRuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(IzquierdaLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(IzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnIniciarFacturacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Fecha, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(panelContratoCredito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        IzquierdaLayout.setVerticalGroup(
            IzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IzquierdaLayout.createSequentialGroup()
                .addGroup(IzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(IzquierdaLayout.createSequentialGroup()
                        .addGroup(IzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRuc)
                            .addComponent(lblEmpresa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(IzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(IzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addGroup(IzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TipoFactura, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.CENTER)))
                        .addGap(24, 24, 24)
                        .addGroup(IzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel13)
                            .addComponent(Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnIniciarFacturacion)))
                    .addComponent(panelContratoCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(Izquierda);

        Centro.setBackground(new java.awt.Color(65, 146, 141));
        Centro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(254, 254, 254))); // NOI18N
        Centro.setForeground(new java.awt.Color(254, 254, 254));

        jLabel2.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setText("Codigo");

        Cod.setToolTipText("Codigo o nombre de producto a vender");
        Cod.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CodFocusLost(evt);
            }
        });
        Cod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodActionPerformed(evt);
            }
        });
        Cod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CodKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CodKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setText("Cantidad: ");

        Cant.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CantFocusLost(evt);
            }
        });
        Cant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CantKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CantKeyPressed(evt);
            }
        });

        btnBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Lupa.png"))); // NOI18N
        btnBuscarProducto.setToolTipText("Buscar un producto");
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        Bonificacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BonificacionFocusLost(evt);
            }
        });
        Bonificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BonificacionKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BonificacionKeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(254, 254, 254));
        jLabel11.setText("Bonificacion");

        btnCancelarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/1435735624_delete.png"))); // NOI18N
        btnCancelarProducto.setToolTipText("Eliminar la seleccion del producto a vender");
        btnCancelarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CentroLayout = new javax.swing.GroupLayout(Centro);
        Centro.setLayout(CentroLayout);
        CentroLayout.setHorizontalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CentroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cod, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnCancelarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(Cant, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Bonificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );
        CentroLayout.setVerticalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CentroLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Cant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(Bonificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(12, 12, 12))
        );

        getContentPane().add(Centro);

        Detalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Detalles.getTableHeader().setReorderingAllowed(false);
        Detalles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DetallesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Detalles);

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/add.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("Agrega un producto a la tabla");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnAnular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/trash.png"))); // NOI18N
        btnAnular.setText("Anular");
        btnAnular.setToolTipText("Anula toda la factura");
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });

        btnEliminarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Cancel.png"))); // NOI18N
        btnEliminarProducto.setText("Eliminar producto");
        btnEliminarProducto.setToolTipText("Elimina un producto selecionado de la tabla");
        btnEliminarProducto.setEnabled(false);
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Save 16x16.png"))); // NOI18N
        btnGuardar.setText("Aceptar");
        btnGuardar.setToolTipText("Guardar e imprimir factura");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel8.setText("Subtotal:");

        jLabel6.setText("IVA:");

        jLabel7.setText("Total:");

        jLabel9.setText("Descuento: ");

        Descuento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0%", "5%", "15%", "30%" }));
        Descuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescuentoActionPerformed(evt);
            }
        });

        jLabel10.setText("Descuento:");

        jLabel4.setText("Observaciones : ");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        ExcentoIVA.setText("Excento IVA");
        ExcentoIVA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcentoIVAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout InferiorLayout = new javax.swing.GroupLayout(Inferior);
        Inferior.setLayout(InferiorLayout);
        InferiorLayout.setHorizontalGroup(
            InferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InferiorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(InferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(InferiorLayout.createSequentialGroup()
                        .addComponent(ExcentoIVA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(10, 10, 10)
                        .addComponent(Subt, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addGap(10, 10, 10)
                        .addComponent(Desc, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(10, 10, 10)
                        .addComponent(Iva, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7)
                        .addGap(10, 10, 10)
                        .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1)
                    .addGroup(InferiorLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(10, 10, 10)
                        .addComponent(Descuento, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 478, Short.MAX_VALUE)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, InferiorLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        InferiorLayout.setVerticalGroup(
            InferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Descuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addGroup(InferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGuardar)
                        .addComponent(btnAnular)
                        .addComponent(btnEliminarProducto)
                        .addComponent(btnAgregar)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(InferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8)
                    .addComponent(Subt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(Desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(Iva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExcentoIVA)
                    .addComponent(jLabel7)
                    .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        getContentPane().add(Inferior);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CodFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CodFocusLost

    }//GEN-LAST:event_CodFocusLost

    private void CodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CodKeyTyped

    }//GEN-LAST:event_CodKeyTyped

    private void CantFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CantFocusLost

    }//GEN-LAST:event_CantFocusLost

    private void CantKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CantKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            CantFocusLost(null);
            btnAgregarActionPerformed(null);
        }
    }//GEN-LAST:event_CantKeyPressed

    private void CantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CantKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c) && c != '.' || (c == '.' && Cant.getText().contains("."))) {
            evt.consume();
        }
    }//GEN-LAST:event_CantKeyTyped

    public int IndiceRepetido(String codigo) {

        for (int i = 0; i < Detalles.getRowCount(); i++) {
            if (codigo.equals(Detalles.getValueAt(i, 0))) {
                return i;
            }
        }

        return -1;
    }

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Producto p;
        if (IdProducto == -1) {
            p = new CodigoBarraDao().getProducto(this.Cod.getText());

            if (p == null) {
                JOptionPane.showInternalMessageDialog(this, "El codigo de producto ingresado no existe", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            p = new ProductoDao().getById(IdProducto);
            if (p == null) {
                JOptionPane.showInternalMessageDialog(this, "El producto no esta registrado o no existe", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        if (Bonificacion.getText().trim().equals("")) {
            Bonificacion.setText("0");
        }

        if (Cant.getText().trim().equals("")) {
            JOptionPane.showInternalMessageDialog(this, "No ha ingresado la cantidad a vender", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Validacion de Cantidad
        float cant = 0;
        float bonificacion = 0;
        try {
            cant = Float.parseFloat(Cant.getText());
            bonificacion = Float.parseFloat(Bonificacion.getText());
        } catch (NumberFormatException nf) {
            JOptionPane.showInternalMessageDialog(this, "cantidadades y/o bonificaciones invalidas", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (p.getTipoVenta().equalsIgnoreCase("unidad")) {
            if (cant - (int) cant != 0.0) {
                JOptionPane.showInternalMessageDialog(this, "Las cantidades para este producto no pueden ser decimales", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (bonificacion - (int) bonificacion != 0.0) {
                JOptionPane.showInternalMessageDialog(this, "Las bonificaciones para este producto no pueden ser decimales", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        if (cant == 0 && bonificacion == 0) {
            JOptionPane.showInternalMessageDialog(this, "No ha ingresado ninguna cantidad mayor que cero", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int indice = IndiceRepetido(String.valueOf(p.getIdproducto()));
        if (indice != -1) {

            float stock = p.getCantidadInventario();
            if ((Double.parseDouble(String.valueOf(Detalles.getValueAt(indice, 2)))) + cant + bonificacion + (Double.parseDouble(String.valueOf(Detalles.getValueAt(indice, 3))))
                    > p.getCantidadInventario() - p.getCantidadMinima()) {
                JOptionPane.showMessageDialog(this, "Error de procesamiento\nintenta ingresar cantidades mayores a las existentes"
                        + "\n(Debe dejar " + stock + " en Stock)", "Error", JOptionPane.ERROR_MESSAGE);

            } else {
                float Subtotal = Float.parseFloat(this.Detalles.getValueAt(indice, 5).toString());
                float DescuentoMonetario = Float.parseFloat(this.Detalles.getValueAt(indice, 6).toString());
                int DescuentoP = (int) ((DescuentoMonetario / Subtotal) * 100);

                float CantidadTotal = Float.parseFloat(Detalles.getValueAt(indice, 2).toString()) + cant;
                float BonificacionTotal = Float.parseFloat(Detalles.getValueAt(indice, 3).toString()) + bonificacion;
                float SubtotalActual = Redondear(p.getPrecioVenta() * CantidadTotal);
                float DescuentoActual = Redondear(SubtotalActual * ((float) DescuentoP / 100));

                Detalles.setValueAt(CantidadTotal, indice, 2);
                Detalles.setValueAt(BonificacionTotal, indice, 3);
                Detalles.setValueAt(p.getPrecioVenta(), indice, 4);
                Detalles.setValueAt(SubtotalActual, indice, 5);
                Detalles.setValueAt(DescuentoActual, indice, 6);

                if (p.isIva()) {
                    Detalles.setValueAt(Redondear((SubtotalActual - DescuentoActual) * (float) 0.15), indice, 7);
                    Detalles.setValueAt(Redondear((SubtotalActual - DescuentoActual) * (float) 1.15), indice, 8);
                } else {
                    Detalles.setValueAt(0, indice, 7);
                    Detalles.setValueAt(SubtotalActual - DescuentoActual, indice, 8);
                }

            }
            LimpiarAgregar();
            return;
        }

        if (cant + bonificacion > p.getCantidadInventario() - p.getCantidadMinima()) {
            Cant.setText("");
            Cant.requestFocus();
            JOptionPane.showInternalMessageDialog(this, "Esta tratando de ingresar cantidades mayores a las existentes(Debe dejar " + p.getCantidadMinima() + " en stock)\nCantidades Existentes: " + p.getCantidadInventario(), "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String fila[] = new String[9];
        fila[0] = String.valueOf(p.getIdproducto());

        fila[1] = p.getNombre();
        fila[2] = String.valueOf(cant);
        fila[3] = String.valueOf(bonificacion);
        fila[4] = String.valueOf(p.getPrecioVenta());
        fila[5] = String.valueOf(Redondear(cant * p.getPrecioVenta()));
        fila[6] = String.valueOf(Redondear(Redondear(cant * p.getPrecioVenta() * this.CalcDesc())));
        if (p.isIva()) {
            fila[7] = String.valueOf(Redondear(((Float.parseFloat(fila[5])) - Float.parseFloat(fila[6])) * (float) 0.15));
            fila[8] = String.valueOf(Redondear(((Float.parseFloat(fila[5])) - Float.parseFloat(fila[6])) * (float) 1.15));
        } else {
            fila[7] = String.valueOf(Redondear(0));
            fila[8] = String.valueOf(Redondear((Float.parseFloat(fila[5])) - Float.parseFloat(fila[6])));
        }
        dtm.addRow(fila);
        LimpiarAgregar();
        Cod.requestFocus();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        Anular();
    }//GEN-LAST:event_btnAnularActionPerformed

    public void Anular() {
        Limpiar(dtm);
        TipoFactura.setEnabled(true);
        Cant.setEnabled(false);
        Cod.setEnabled(false);
        Descuento.setEnabled(false);
        btnBuscarProducto.setEnabled(false);
        this.Cliente.setText("");
        this.IdClienteJuridico = -1;
        this.IdClienteNatural = -1;
        this.Bonificacion.setEnabled(false);
        this.btnCancelarProducto.setEnabled(false);
        FechaVencimiento.setEnabled(true);
        txtTasa.setEnabled(true);
    }

    public void LimpiarAgregar() {
        Cod.setText("");
        Cant.setText("");
        ActualizarEstado();
        Cod.setEditable(true);
        Bonificacion.setText("");
        btnEliminarProducto.setEnabled(false);
        this.btnCancelarProducto.setEnabled(false);

    }

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        if (Detalles.getSelectedRow() != -1) {
            dtm.removeRow(Detalles.getSelectedRow());
            ActualizarEstado();
        } else {
            JOptionPane.showInternalMessageDialog(this, "Selecione un producto primero", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (this.dtm.getRowCount() == 0) {
            JOptionPane.showInternalMessageDialog(this, "La factura esta vacia", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (this.TipoFactura.getSelectedIndex() == 1) {
            Pago p = new Pago(this, Float.parseFloat(this.Total.getText()));
            Centrar(p, this.getDesktopPane());
        }
        if (this.TipoFactura.getSelectedIndex() == 2) {
            boolean guardado = this.GuardarFactura();
            if (guardado == false) {
                System.out.println("no se guardo");
                v = null;
                return;
            }
            this.Anular();
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void DescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescuentoActionPerformed
        ActualizarEstado();
    }//GEN-LAST:event_DescuentoActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        EleccionCliente e = new EleccionCliente(this);
        Centrar(e, this.getDesktopPane());
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void CodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CodKeyReleased
//        Cod.setText(Cod.getText().toUpperCase());
    }//GEN-LAST:event_CodKeyReleased

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        Cod.setEnabled(false);
        Cant.setEnabled(false);
        Descuento.setEnabled(false);
        btnBuscarProducto.setEnabled(false);
        try {
            setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(FacturaInternal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnIniciarFacturacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarFacturacionActionPerformed

        if (this.TipoFactura.getSelectedIndex() == 0) {
            JOptionPane.showInternalMessageDialog(this, "Debe Seleccionar un tipo de factura", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (this.TipoFactura.getSelectedIndex() == 1) {
            Cod.setEnabled(true);
            Cant.setEnabled(true);
            Descuento.setEnabled(true);
            TipoFactura.setEnabled(false);
            btnBuscarProducto.setEnabled(true);
            Bonificacion.setEnabled(true);
        }
        if (this.TipoFactura.getSelectedIndex() == 2) {
            if (this.IdClienteJuridico == -1 && this.IdClienteNatural == -1) {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un cliente para facturas a credito", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Bonificacion.setEnabled(true);
            Cod.setEnabled(true);
            Cant.setEnabled(true);
            Descuento.setEnabled(false);
            TipoFactura.setEnabled(false);
            btnBuscarProducto.setEnabled(true);
        }
        
        
        Date fechaVencimiento = null;
        if (this.TipoFactura.getSelectedIndex() == 2) {
            try {
                Float.parseFloat(txtTasa.getText());
            } catch (NumberFormatException nf) {
                JOptionPane.showInternalMessageDialog(this, "La tasa digitada es invalida", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                fechaVencimiento = this.FechaVencimiento.getDate();
            } catch (Exception e) {
                JOptionPane.showInternalMessageDialog(this, "La fecha digitada es invalida", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (fechaVencimiento == null) {
                JOptionPane.showInternalMessageDialog(this, "La fecha digitada es invalida", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (fechaVencimiento.getTime() <= new Date().getTime()) {
                JOptionPane.showInternalMessageDialog(this, "La fecha de vencimiento no puede ser igual o menor a la fecha actual", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        FechaVencimiento.setEnabled(false);
        txtTasa.setEnabled(false);

        Cod.requestFocus();

    }//GEN-LAST:event_btnIniciarFacturacionActionPerformed

    private void BonificacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BonificacionFocusLost

    }//GEN-LAST:event_BonificacionFocusLost

    private void BonificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BonificacionKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c) && c != '.' || (c == '.' && Bonificacion.getText().contains("."))) {
            evt.consume();
        }
    }//GEN-LAST:event_BonificacionKeyTyped

    private void BonificacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BonificacionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            CantFocusLost(null);
            btnAgregarActionPerformed(null);
        }
    }//GEN-LAST:event_BonificacionKeyPressed

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        SeleccionInventarioInternal s = new SeleccionInventarioInternal(this);
        Centrar(s, getDesktopPane());
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void CodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodActionPerformed

    }//GEN-LAST:event_CodActionPerformed

    private void DetallesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DetallesMouseClicked
        btnEliminarProducto.setEnabled(true);
    }//GEN-LAST:event_DetallesMouseClicked

    private void TipoFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoFacturaActionPerformed
        if (this.TipoFactura.getSelectedIndex() == 2) {
            panelContratoCredito.setVisible(true);
        } else {
            panelContratoCredito.setVisible(false);
        }
    }//GEN-LAST:event_TipoFacturaActionPerformed

    private void btnCancelarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarProductoActionPerformed
        this.IdProducto = -1;
        this.Cod.setText(null);
        this.Cod.setEditable(true);
        this.btnCancelarProducto.setEnabled(false);
    }//GEN-LAST:event_btnCancelarProductoActionPerformed

    private void ExcentoIVAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcentoIVAActionPerformed
        this.ActualizarIVA();
    }//GEN-LAST:event_ExcentoIVAActionPerformed

    private void txtTasaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTasaKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c) && c != '.' || (c == '.' && Cant.getText().contains("."))) {
            evt.consume();
        }        
    }//GEN-LAST:event_txtTasaKeyTyped

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        mdi.Abierto = false;
    }//GEN-LAST:event_formInternalFrameClosing

    public void ActualizarIVA() {
        for (int i = 0; i < this.Detalles.getRowCount(); i++) {
            int Id = Integer.parseInt((String) Detalles.getValueAt(i, 0));
            Producto p = new ProductoDao().getById(Id);

            if (this.ExcentoIVA.isSelected()) {

                Detalles.setValueAt(0, i, 7);
                Detalles.setValueAt(Detalles.getValueAt(i, 5), i, 8);

            } else {
                if (p.isIva()) {
                    float SubtotalActual = Float.parseFloat((String) Detalles.getValueAt(i, 5));
                    float DescuentoActual = Float.parseFloat((String) Detalles.getValueAt(i, 6));
                    Detalles.setValueAt(Redondear((SubtotalActual - DescuentoActual) * (float) 0.15), i, 7);
                    Detalles.setValueAt(Redondear((SubtotalActual - DescuentoActual) * (float) 1.15), i, 8);
                }
            }

        }
        this.ActualizarEstado();

    }

    public boolean GuardarFactura() {
        Venta venta = new Venta();
        Float tasa = (float) 0;
        Date fechaVencimiento = null;
        if (this.TipoFactura.getSelectedIndex() == 2) {
            try {
                tasa = Float.parseFloat(txtTasa.getText());
            } catch (NumberFormatException nf) {
                JOptionPane.showInternalMessageDialog(this, "La tasa digitada es invalida", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            try {
                fechaVencimiento = this.FechaVencimiento.getDate();
            } catch (Exception e) {
                JOptionPane.showInternalMessageDialog(this, "La fecha digitada es invalida", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            if (fechaVencimiento == null) {
                JOptionPane.showInternalMessageDialog(this, "La fecha digitada es invalida", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            if (fechaVencimiento.getTime() <= new Date().getTime()) {
                JOptionPane.showInternalMessageDialog(this, "La fecha de vencimiento no puede ser igual o menor a la fecha actual", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        Empleados e = new Dao().getByIdEmpleado(this.IdEmpleado);

        if (e == null) {
            System.out.println("no existe empleado para facturar");
            return false;
        }
        venta.setEmpleados(e);
        venta.setFechaVenta(new Date());
        venta.setTipoFactura(this.TipoFactura.getSelectedItem().toString());
        venta.setExcentoIva(false);
        if (this.jTextArea1.getText().trim().equals("")) {
            venta.setObservaciones("No hubieron observaciones");
        } else {
            venta.setObservaciones(this.jTextArea1.getText());
        }

        venta.setAnulado(false);

        if (this.TipoFactura.getSelectedIndex() == 2) {
            venta.setEstado("No pagado");
        } else {
            venta.setEstado("Pagado");
        }

        int id = (int) new Dao().Guardar(venta);

        if (id == -1) {
            JOptionPane.showInternalMessageDialog(this, "No se puede guardar \n intente mas tarde, si el problema persiste contactese con el administrador del sistema", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        Venta v = new VentaDao().getVenta(id);

        if (this.IdClienteJuridico != -1) {
            RepresentanteClienteJuridico c = new Dao().getByIdClienteJuridico(this.IdClienteJuridico);
            VentaClienteJuridico vn = new VentaClienteJuridico();
            vn.setRepresentanteClienteJuridico(c);
            vn.setVenta(v);
            int idcn = (int) new Dao().Guardar(vn);
            if (idcn == -1) {
                JOptionPane.showInternalMessageDialog(this, "No se puede guardar \n intente mas tarde, si el problema persiste contactese con el administrador del sistema", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        if (this.IdClienteNatural != -1) {
            Cliente c = new Dao().getByIdClienteNatural(this.IdClienteNatural);
            VentaClienteNatural vn = new VentaClienteNatural();
            vn.setCliente(c);
            vn.setVenta(v);
            int idcn = (int) new Dao().Guardar(vn);
            if (idcn == -1) {
                JOptionPane.showInternalMessageDialog(this, "No se puede guardar \n intente mas tarde, si el problema persiste contactese con el administrador del sistema", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        for (int i = 0; i < this.Detalles.getRowCount(); i++) {
            DetalleFactura d = new DetalleFactura();

            d.setVenta(v);
            d.setProducto(new ProductoDao().getById(Integer.parseInt(this.Detalles.getValueAt(i, 0).toString())));
            d.setCantidadProducto(Float.parseFloat(this.Detalles.getValueAt(i, 2).toString()));
            d.setBonificacion(Float.parseFloat(this.Detalles.getValueAt(i, 3).toString()));
            d.setPrecioUnitario(Float.parseFloat(this.Detalles.getValueAt(i, 4).toString()));
            d.setDescuento(Float.parseFloat(this.Detalles.getValueAt(i, 6).toString()));
            d.setIva(Float.parseFloat(this.Detalles.getValueAt(i, 7).toString()));

            int idd = (int) new Dao().Guardar(d);
            if (idd == -1) {
                JOptionPane.showInternalMessageDialog(this, "No se puede guardar \n intente mas tarde, si el problema persiste contactese con el administrador del sistema", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        if (this.TipoFactura.getSelectedIndex() == 2) {
            ContratoCredito c = new ContratoCredito();
            c.setVenta(v);
            c.setFechaVencimiento(fechaVencimiento);
            c.setTasaInteres(tasa);
            
            int i = (int) new Dao().Guardar(c);

            if (i == -1) {
                JOptionPane.showInternalMessageDialog(this, "No se pudo guardar", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
            VentaCredito ventacredito = new VentaCredito();
            ventacredito.setVenta(v);
            ventacredito.setMora(0);
            
            i = (int) new Dao().Guardar(ventacredito);

            if (i == -1) {
                JOptionPane.showInternalMessageDialog(this, "No se pudo guardar", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        this.v = v;
        
        JOptionPane.showInternalMessageDialog(this, "Guardado Exitosamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("se guardo perfectamente");
        return true;
    }

    public boolean GuardarPago(Venta v, List<Pagos> lista) {
        for (Pagos p : lista) {
            p.setFechaPago(new Date());
            p.setVenta(v);
            int id = (int)new Dao().Guardar(p);
            if (id == -1) {
                v.setAnulado(true);
                new Dao().Actualizar(v);
                return false;
            }
        }

        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Bonificacion;
    private javax.swing.JTextField Cant;
    private javax.swing.JPanel Centro;
    public javax.swing.JTextField Cliente;
    public javax.swing.JTextField Cod;
    private javax.swing.JTextField Desc;
    private javax.swing.JComboBox Descuento;
    private javax.swing.JTable Detalles;
    private javax.swing.JCheckBox ExcentoIVA;
    private com.toedter.calendar.JDateChooser Fecha;
    private com.toedter.calendar.JDateChooser FechaVencimiento;
    private javax.swing.JPanel Inferior;
    private javax.swing.JTextField Iva;
    private javax.swing.JPanel Izquierda;
    private javax.swing.JTextField Subt;
    private javax.swing.JComboBox TipoFactura;
    private javax.swing.JTextField Total;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAnular;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarProducto;
    public javax.swing.JButton btnCancelarProducto;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnIniciarFacturacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblEmpresa;
    private javax.swing.JLabel lblRuc;
    private javax.swing.JPanel panelContratoCredito;
    private javax.swing.JTextField txtTasa;
    // End of variables declaration//GEN-END:variables
}
