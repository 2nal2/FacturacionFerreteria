package Producto;

import Camara.Camara;
import Dao.CategoriaDao;
import Dao.Dao;
import Dao.ProductoDao;
import static Methods.Validator.isInt;
import static MetodoComunes.Metodos.Centrar;
import static MetodoComunes.Metodos.LimpiarTabla;
import MetodoComunes.procesamientoImagenes;
import Modelos.Inventario;
import POJO.Categorias;
import POJO.CodigoBarra;
import POJO.Producto;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ing. Donaldo
 */
public class InventarioInternal extends javax.swing.JInternalFrame {

    DefaultTableModel tabla = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public BufferedImage image;

    public InventarioInternal() {
        initComponents();
        InicializarTabla();
        CargarCategorias();
        Stock.setTransferHandler(null);
        this.jSplitPane1.setLeftComponent(this.Opciones);
        this.jSplitPane1.setRightComponent(this.RegistroProd);

        jTable2.getColumn("ID").setMaxWidth(0);
        jTable2.getColumn("ID").setMinWidth(0);
        jTable2.getColumn("ID").setPreferredWidth(0);
        CargarTabla();
        btnEditar.setEnabled(false);
    }
    
    public InventarioInternal(String NombreCategoria){
        initComponents();
        InicializarTabla();
        BuscarCategoria(NombreCategoria);
        Stock.setTransferHandler(null);
        this.jSplitPane1.setLeftComponent(this.Opciones);
        this.jSplitPane1.setRightComponent(this.AdmProductos);

        jTable2.getColumn("ID").setMaxWidth(0);
        jTable2.getColumn("ID").setMinWidth(0);
        jTable2.getColumn("ID").setPreferredWidth(0);
        CargarTabla();
        btnEditar.setEnabled(false);
    }

    public void CargarCategorias() {
        this.Categoria.removeAllItems();
        for (Categorias c : new CategoriaDao().getAllActive()) {
            this.Categoria.addItem(c.getNombre());
        }
    }

    public void InicializarTabla() {
        String encab[] = {"Id", "Codigo Barra", "Categoria", "Nombre", "Precio Venta", "Precio Inventario", "Tipo Venta", "Cantidad minima", "Cantidad Inventario", "Descripcion", "IVA", "Estado"};
        tabla.setColumnIdentifiers(encab);
        Datos.setModel(tabla);
        Descripcion.setLineWrap(true);
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

    public BufferedImage abrirImagen() {
        BufferedImage bmp = null;
        JFileChooser selector = new JFileChooser();
        selector.setDialogTitle("Seleccione una imagen");
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG & GIF & BMP", "jpg", "gif", "bmp");
        selector.setFileFilter(filtroImagen);
        int flag = selector.showOpenDialog(null);
        if (flag == JFileChooser.APPROVE_OPTION) {
            try {
                File imagenSeleccionada = selector.getSelectedFile();
                bmp = ImageIO.read(imagenSeleccionada);
            } catch (Exception e) {
            }

        }
        return bmp;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Opciones = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        AdmProductos = new javax.swing.JPanel();
        Actividades = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        Buscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Datos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        TipoBusqueda = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        RegistroProd = new javax.swing.JPanel();
        Registrar = new javax.swing.JButton();
        Nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Categoria = new javax.swing.JComboBox();
        Stock = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Descripcion = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        TipoVenta = new javax.swing.JComboBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        CodigoBarra = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lblFoto = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();

        Opciones.setBackground(new java.awt.Color(65, 146, 141));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Registrar Producto");
        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Administrar Productos");
        jButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout OpcionesLayout = new javax.swing.GroupLayout(Opciones);
        Opciones.setLayout(OpcionesLayout);
        OpcionesLayout.setHorizontalGroup(
            OpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OpcionesLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        OpcionesLayout.setVerticalGroup(
            OpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OpcionesLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(OpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        AdmProductos.setPreferredSize(new java.awt.Dimension(400, 300));

        Actividades.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mostrar todo", "Mostrar Activos", "Mostrar Inactivos" }));

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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

        jLabel5.setText("Mostrar");

        TipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "Codigo Barra", "Id", "Categoria" }));

        jLabel12.setText("Buscar");

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/edit.png"))); // NOI18N
        btnEditar.setText("Actualizar informacion");
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
                        .addGroup(AdmProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                        .addGroup(AdmProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AdmProductosLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(Actividades, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(AdmProductosLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(TipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        AdmProductosLayout.setVerticalGroup(
            AdmProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdmProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AdmProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel5)
                    .addComponent(Actividades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AdmProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar)
                    .addComponent(jLabel12))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addContainerGap())
        );

        Registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Save 16x16.png"))); // NOI18N
        Registrar.setText("Registrar Producto");
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre de producto");

        jLabel6.setText("Categoria");

        Stock.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                StockFocusLost(evt);
            }
        });
        Stock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                StockKeyTyped(evt);
            }
        });

        jLabel7.setText("Stock Minimo");

        jLabel8.setText("Descripcion");

        Descripcion.setColumns(20);
        Descripcion.setRows(5);
        jScrollPane2.setViewportView(Descripcion);

        jLabel4.setText("Tipo de venta");

        TipoVenta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Unidad", "Libra", "Metro Cuadrado", "Metro" }));

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Incluye IVA");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Codigo de Barra");

        CodigoBarra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CodigoBarraFocusLost(evt);
            }
        });
        CodigoBarra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodigoBarraActionPerformed(evt);
            }
        });
        CodigoBarra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CodigoBarraKeyTyped(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Foto del producto"));

        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setText("Foto no ingresada");
        lblFoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jButton4.setText("Cargar Imagen");
        jButton4.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Tomar Foto");
        jButton5.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Cancel.png"))); // NOI18N
        jButton6.setText("Cancelar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RegistroProdLayout = new javax.swing.GroupLayout(RegistroProd);
        RegistroProd.setLayout(RegistroProdLayout);
        RegistroProdLayout.setHorizontalGroup(
            RegistroProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegistroProdLayout.createSequentialGroup()
                .addGroup(RegistroProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(RegistroProdLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Registrar))
                    .addGroup(RegistroProdLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(RegistroProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(RegistroProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBox1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(RegistroProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(RegistroProdLayout.createSequentialGroup()
                                .addGroup(RegistroProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Categoria, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Nombre, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CodigoBarra)
                                    .addComponent(Stock)
                                    .addComponent(TipoVenta, 0, 224, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(20, 20, 20))
        );
        RegistroProdLayout.setVerticalGroup(
            RegistroProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistroProdLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(RegistroProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegistroProdLayout.createSequentialGroup()
                        .addGroup(RegistroProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(RegistroProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(15, 15, 15)
                        .addGroup(RegistroProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CodigoBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(15, 15, 15)
                        .addGroup(RegistroProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(15, 15, 15)
                        .addGroup(RegistroProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(TipoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addComponent(jCheckBox1))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(RegistroProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegistroProdLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 37, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(RegistroProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Registrar)
                    .addComponent(jButton6))
                .addGap(16, 16, 16))
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre Proveedor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable2);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Inventario");
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

        jSplitPane1.setDividerSize(10);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setToolTipText("");
        jSplitPane1.setAutoscrolls(true);
        jSplitPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.jSplitPane1.setRightComponent(this.RegistroProd);
        Nombre.requestFocus();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.jSplitPane1.setRightComponent(this.AdmProductos);
        setResizable(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        btnEditar.setEnabled(false);
        switch (Actividades.getSelectedIndex() + 1) {
            case 1: {
                this.CargarTabla();
                break;
            }
            case 2:{
                MostrarActivosInactivos(true);
               break;
            }
            case 3:{
                MostrarActivosInactivos(false);
               break;
            }

        }
//---------------------------------------------------------------------------------------------------------------------------
    }//GEN-LAST:event_jButton1ActionPerformed

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

    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActionPerformed
        //Registrar el producto

        float CantidadMinima;
        String nombre, descripcion;
        try {
            CantidadMinima = Float.parseFloat(Stock.getText());
        } catch (NumberFormatException nf) {
            JOptionPane.showInternalMessageDialog(this, "Por favor Ingrese una Stock Minimo valido(solo se aceptan cantidades numericas)", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        nombre = this.Nombre.getText();
        descripcion = this.Descripcion.getText();

        if (nombre.trim().equals("")) {
            JOptionPane.showInternalMessageDialog(this, "Por favor Ingrese el nombre del producto", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (descripcion.trim().equals("")) {
            JOptionPane.showInternalMessageDialog(this, "Por favor Ingrese la descripcion del producto", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(this.TipoVenta.getSelectedIndex() == 0){
            if((CantidadMinima - (int)CantidadMinima) != 0.0){
                JOptionPane.showInternalMessageDialog(this, "La cantidad no puede ser decimal porque el tipo de venta seleccionado es la 'unidad'", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        Producto p = new Producto();
        Categorias c = new CategoriaDao().getByName(this.Categoria.getSelectedItem().toString());
        CodigoBarra b = new CodigoBarra();

        p.setCategorias(c);
        p.setFoto(null);
        p.setCantidadMinima(CantidadMinima);
        p.setTipoVenta(this.TipoVenta.getSelectedItem().toString());
        p.setEstado(true);
        p.setNombre(nombre);
        p.setDescripcion(descripcion);
        p.setIva(this.jCheckBox1.isSelected());
        p.setPrecioInventario(0);
        p.setPrecioVenta(0);
        p.setCantidadInventario(0);

        //procesamiento de la imagen
        ByteArrayOutputStream os;
        if (image != null) {

            os = new ByteArrayOutputStream();

            try {
                ImageIO.write(image, "jpg", os);
                os.flush();
                String base64String = Base64.encode(os.toByteArray());
                os.close();

                byte[] bytearray = Base64.decode(base64String);

                p.setFoto(bytearray);
            } catch (IOException ex) {
                return;
            }

        }

        int id = (int) new Dao().Guardar(p);

        if (id == -1) {
            JOptionPane.showInternalMessageDialog(this, "No se puede guardar \n intente mas tarde, si el problema persiste contactese con el administrador del sistema", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showInternalMessageDialog(this, "Guardado Exitosamente", "Operacion realizada con exito", JOptionPane.INFORMATION_MESSAGE);
        }

        if (CodigoBarra.getText().trim().equals("")) {

        } else {
            b.setIdCodigoBarra(this.CodigoBarra.getText());
            b.setProducto(new ProductoDao().getById(id));
            new Dao().Guardar(b);
        }
        CargarCategorias();
        Nombre.setText(null);
        Descripcion.setText(null);
        this.Stock.setText(null);
        this.Descripcion.setText(null);
        lblFoto.setText("Foto no ingresada");
        lblFoto.setIcon(null);
        this.jCheckBox1.setSelected(true);
        this.TipoVenta.setSelectedIndex(0);
        this.CodigoBarra.setText(null);
    }//GEN-LAST:event_RegistrarActionPerformed

    private void StockFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_StockFocusLost

    }//GEN-LAST:event_StockFocusLost

    private void StockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_StockKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c) && c != '.' || (c == '.' && Stock.getText().contains("."))) {
            evt.consume();
        }
    }//GEN-LAST:event_StockKeyTyped

    private void CodigoBarraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CodigoBarraFocusLost

    }//GEN-LAST:event_CodigoBarraFocusLost

    private void CodigoBarraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CodigoBarraKeyTyped

    }//GEN-LAST:event_CodigoBarraKeyTyped

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        this.pack();
    }//GEN-LAST:event_formInternalFrameOpened

    private void CodigoBarraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodigoBarraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodigoBarraActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        image = this.abrirImagen();
        procesamientoImagenes pi = new procesamientoImagenes();
        int height = lblFoto.getHeight();
        int width = lblFoto.getWidth();
        lblFoto.setIcon((pi.imageToIcon(pi.imageToBufferedImage(image).getScaledInstance(width, height, 0))));
        lblFoto.setText(null);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        CargarCategorias();
        Nombre.setText(null);
        Descripcion.setText(null);
        this.Stock.setText(null);
        this.Descripcion.setText(null);
        lblFoto.setText("Foto no ingresada");
        lblFoto.setIcon(null);
        this.jCheckBox1.setSelected(true);
        this.TipoVenta.setSelectedIndex(0);
        this.CodigoBarra.setText(null);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int fila  =  this.Datos.getSelectedRow();
        
        int id =  Integer.parseInt(Datos.getValueAt(fila, 0).toString());
        
        ActualizarProductoInternal a = new ActualizarProductoInternal(id, this);
        
        Centrar(a, this.getDesktopPane());
    }//GEN-LAST:event_btnEditarActionPerformed

    private void DatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DatosMouseClicked
        btnEditar.setEnabled(true);
    }//GEN-LAST:event_DatosMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Camara c = new Camara(this);
        Centrar(c, this.getDesktopPane());
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Actividades;
    private javax.swing.JPanel AdmProductos;
    private javax.swing.JTextField Buscar;
    private javax.swing.JComboBox Categoria;
    private javax.swing.JTextField CodigoBarra;
    private javax.swing.JTable Datos;
    private javax.swing.JTextArea Descripcion;
    private javax.swing.JTextField Nombre;
    private javax.swing.JPanel Opciones;
    private javax.swing.JButton Registrar;
    private javax.swing.JPanel RegistroProd;
    private javax.swing.JTextField Stock;
    private javax.swing.JComboBox TipoBusqueda;
    private javax.swing.JComboBox TipoVenta;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable2;
    public javax.swing.JLabel lblFoto;
    // End of variables declaration//GEN-END:variables
}
