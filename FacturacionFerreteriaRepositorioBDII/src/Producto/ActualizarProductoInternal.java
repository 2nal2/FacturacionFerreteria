package Producto;

import Camara.Camara;
import Dao.CategoriaDao;
import Dao.CodigoBarraDao;
import Dao.Dao;
import Dao.ProductoDao;
import static Methods.Validator.isInt;
import static MetodoComunes.Metodos.Centrar;
import MetodoComunes.procesamientoImagenes;
import POJO.Categorias;
import POJO.CodigoBarra;
import POJO.Producto;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Ing. Donaldo
 */
public class ActualizarProductoInternal extends javax.swing.JInternalFrame {

    public ActualizarProductoInternal() {
        initComponents();
    }

    int Cod;
    InventarioInternal inv;
    public BufferedImage image;

    public ActualizarProductoInternal(int Cod, InventarioInternal inv) {
        this.Cod = Cod;
        this.inv = inv;
        initComponents();
        CargarCategorias();
        Descripcion.setLineWrap(true);
        try {
            Cargar(Cod);
        } catch (IOException ex) {
            Logger.getLogger(ActualizarProductoInternal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void CargarCategorias() {
        this.Categoria.removeAllItems();
        for (Categorias c : new CategoriaDao().getAllActive()) {
            this.Categoria.addItem(c.getNombre());
        }
    }

    public void Cargar(int Cod) throws IOException {
        Categoria.setSelectedItem(new CategoriaDao().getByProducto(Cod).getNombre());
        CodigoBarra c = new CodigoBarraDao().getById(Cod);
        Producto p = new ProductoDao().getById(Cod);
        this.Nombre.setText(p.getNombre());
        this.Descripcion.setText(p.getDescripcion());
        this.Stock.setText(String.valueOf(p.getCantidadMinima()));
        this.CodigoBarra.setText(c.getIdCodigoBarra());
        this.IVA.setSelected(p.isIva());
        this.Estado.setSelectedItem(p.isEstado() ? "Activo" : "Inactivo");
        this.PrecioInventario.setText(String.valueOf(p.getPrecioInventario()));
        this.PrecioVenta.setText(String.valueOf(p.getPrecioVenta()));
        this.TipoVenta.setSelectedItem(p.getTipoVenta());
        if (p.getFoto() != null) {

            BufferedImage imag = ImageIO.read(new ByteArrayInputStream(p.getFoto()));
            procesamientoImagenes pi = new procesamientoImagenes();
            this.image = imag;
            this.lblFoto1.setIcon((pi.imageToIcon(pi.imageToBufferedImage(imag).getScaledInstance(450, 329, 0))));
            this.lblFoto1.setText(null);
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

        EditarProducto = new javax.swing.JPanel();
        Registrar = new javax.swing.JButton();
        Nombre = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Categoria = new javax.swing.JComboBox();
        Stock = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Descripcion = new javax.swing.JTextArea();
        PrecioVenta = new javax.swing.JTextField();
        PrecioInventario = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TipoVenta = new javax.swing.JComboBox();
        Estado = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        IVA = new javax.swing.JCheckBox();
        CodigoBarra = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblFoto1 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Actualizar producto");
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

        Registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Save 16x16.png"))); // NOI18N
        Registrar.setText("Guardar");
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });

        jLabel10.setText("Nombre de producto");

        jLabel13.setText("Categoria");

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

        jLabel14.setText("Stock minimo");

        jLabel15.setText("Descripcion");

        Descripcion.setColumns(20);
        Descripcion.setRows(5);
        jScrollPane2.setViewportView(Descripcion);

        PrecioVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PrecioVentaKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PrecioVentaKeyReleased(evt);
            }
        });

        jLabel19.setText("Precio en inventario");

        jLabel1.setText("Precio de venta");

        jLabel2.setText("Tipo de venta");

        TipoVenta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Unidad", "Libra", "Metro Cuadrado", "Metro" }));

        Estado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activo", "Inactivo" }));

        jLabel4.setText("Estado");

        IVA.setText("Incluye IVA");

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

        jLabel9.setText("Codigo de Barra");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Foto del producto"));

        lblFoto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto1.setText("Foto no ingresada");
        lblFoto1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jButton6.setText("Cargar Imagen");
        jButton6.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Tomar Foto");
        jButton7.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblFoto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFoto1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout EditarProductoLayout = new javax.swing.GroupLayout(EditarProducto);
        EditarProducto.setLayout(EditarProductoLayout);
        EditarProductoLayout.setHorizontalGroup(
            EditarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditarProductoLayout.createSequentialGroup()
                .addGroup(EditarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(EditarProductoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(EditarProductoLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(EditarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(EditarProductoLayout.createSequentialGroup()
                                .addGroup(EditarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IVA, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addGroup(EditarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2)
                                    .addGroup(EditarProductoLayout.createSequentialGroup()
                                        .addGroup(EditarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TipoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Stock, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 584, Short.MAX_VALUE))
                                    .addGroup(EditarProductoLayout.createSequentialGroup()
                                        .addGroup(EditarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(PrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(PrecioInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(EditarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(Categoria, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(CodigoBarra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)))
                                        .addGap(24, 24, 24)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, EditarProductoLayout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 787, Short.MAX_VALUE)))))
                .addGap(40, 40, 40))
        );
        EditarProductoLayout.setVerticalGroup(
            EditarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditarProductoLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(EditarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EditarProductoLayout.createSequentialGroup()
                        .addGroup(EditarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(EditarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CodigoBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(15, 15, 15)
                        .addGroup(EditarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(15, 15, 15)
                        .addGroup(EditarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(PrecioInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(EditarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(15, 15, 15)
                        .addGroup(EditarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(15, 15, 15)
                        .addGroup(EditarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TipoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(15, 15, 15)
                        .addGroup(EditarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(15, 15, 15)
                        .addComponent(IVA))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(EditarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Registrar)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(EditarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(EditarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActionPerformed
        float Stock;
        float PrecioVenta;

        try {
            Stock = Float.parseFloat(this.Stock.getText());
            PrecioVenta = Float.parseFloat(this.PrecioVenta.getText());
        } catch (NumberFormatException nf) {
            JOptionPane.showInternalMessageDialog(this, "Caracteres invalidos");
            return;
        }

        String nombre = this.Nombre.getText();
        String descripcion = this.Descripcion.getText();

        if (nombre.trim().equals("")) {
            JOptionPane.showInternalMessageDialog(this, "Por favor Ingrese el nombre de la categoria", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (descripcion.trim().equals("")) {
            JOptionPane.showInternalMessageDialog(this, "Por favor Ingrese la descripcion de la categoria", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (this.TipoVenta.getSelectedIndex() == 0) {
            if ((Stock - (int) Stock) != 0.0) {
                JOptionPane.showInternalMessageDialog(this, "La cantidad no puede ser decimal porque el tipo de venta seleccionado es la 'unidad'", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        Producto p = new ProductoDao().getById(Cod);
        Categorias c = new CategoriaDao().getByName(this.Categoria.getSelectedItem().toString());

        p.setCategorias(c);
        p.setCantidadMinima(Stock);
        p.setTipoVenta(this.TipoVenta.getSelectedItem().toString());
        if (Estado.getSelectedIndex() == 0) {
            p.setEstado(true);
        } else {
            p.setEstado(false);
        }
        p.setNombre(nombre);
        p.setDescripcion(descripcion);
        p.setIva(this.IVA.isSelected());
        p.setPrecioVenta(PrecioVenta);

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
        else{
            System.out.println(" la imagen esta null");
        }

        boolean actualizar = new Dao().Actualizar(p);

        if (!actualizar) {
            JOptionPane.showInternalMessageDialog(this, "No se puede guardar \n intente mas tarde, si el problema persiste contactese con el administrador del sistema", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showInternalMessageDialog(this, "Guardado Exitosamente", "Operacion realizada con exito", JOptionPane.INFORMATION_MESSAGE);
        }

        if (CodigoBarra.getText().trim().equals("")) {

        } else {
            CodigoBarra b = new CodigoBarraDao().getById(Cod);
            if (b.getIdCodigoBarra() == null) {
                 b.setIdCodigoBarra(this.CodigoBarra.getText());
                 b.setProducto(p);
                 new Dao().Guardar(b);
            } else {
                String cod = b.getIdCodigoBarra();
                b.setIdCodigoBarra(this.CodigoBarra.getText());
                new CodigoBarraDao().Actualizar(b, cod);
            }
        }
        this.dispose();
    }//GEN-LAST:event_RegistrarActionPerformed

    private void StockFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_StockFocusLost

    }//GEN-LAST:event_StockFocusLost

    private void StockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_StockKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c) && c != '.' || (c == '.' && Stock.getText().contains("."))) {
            evt.consume();
        }
    }//GEN-LAST:event_StockKeyTyped

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

    }//GEN-LAST:event_formInternalFrameOpened

    private void CodigoBarraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CodigoBarraFocusLost

    }//GEN-LAST:event_CodigoBarraFocusLost

    private void CodigoBarraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodigoBarraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodigoBarraActionPerformed

    private void CodigoBarraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CodigoBarraKeyTyped

    }//GEN-LAST:event_CodigoBarraKeyTyped

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        image = this.abrirImagen();
        procesamientoImagenes pi = new procesamientoImagenes();
        int height = lblFoto1.getHeight();
        int width = lblFoto1.getWidth();
        lblFoto1.setIcon((pi.imageToIcon(pi.imageToBufferedImage(image).getScaledInstance(width, height, 0))));
        lblFoto1.setText(null);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void PrecioVentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PrecioVentaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_PrecioVentaKeyReleased

    private void PrecioVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PrecioVentaKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c) && c != '.' || (c == '.' && PrecioVenta.getText().contains("."))) {
            evt.consume();
        }
    }//GEN-LAST:event_PrecioVentaKeyTyped

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Camara c = new Camara(this);
        Centrar(c, this.getDesktopPane());
    }//GEN-LAST:event_jButton7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Categoria;
    private javax.swing.JTextField CodigoBarra;
    private javax.swing.JTextArea Descripcion;
    private javax.swing.JPanel EditarProducto;
    private javax.swing.JComboBox Estado;
    private javax.swing.JCheckBox IVA;
    private javax.swing.JTextField Nombre;
    private javax.swing.JTextField PrecioInventario;
    private javax.swing.JTextField PrecioVenta;
    private javax.swing.JButton Registrar;
    private javax.swing.JTextField Stock;
    private javax.swing.JComboBox TipoVenta;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel lblFoto1;
    // End of variables declaration//GEN-END:variables
}
