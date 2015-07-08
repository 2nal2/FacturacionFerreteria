package ClienteNatural;

import Dao.ClienteDao;
import Dao.Dao;
import Hibernate.HibernateUtil;
import static Hibernate.HibernateUtil.Configurar;
import Methods.ValidacionCedula;
import static Methods.Validaciones.ValidateName;
import Methods.Validator;
import static MetodoComunes.Metodos.LimpiarTabla;
import POJO.Cliente;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.ObjectUtils;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import sun.security.pkcs11.wrapper.Functions;

/**
 *
 * @author martin
 */
public class ClienteNaturalInternal extends javax.swing.JInternalFrame {

    DefaultTableModel dtm = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    Session session;

    boolean Editar = false;
    int Id = -1;

    public ClienteNaturalInternal() {
        initComponents();
        InicializarTabla();
        this.Direccion.setLineWrap(true);
        btnEditar.setEnabled(false);
        lblEstado.setVisible(false);
        Estado.setVisible(false);
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
            String estado = "Inactivo";
            if (cl.isEstado()) {
                estado = "Activo";
            }
            dtm.addRow(new Object[]{cl.getIdcliente(), cl.getPrimerNombre(), cl.getSegundoNombre(), cl.getPrimerApellido(),
                cl.getSegundoApellido(), cl.getCedula(), cl.getDireccion(), cl.getCorreoElectronico(), cl.getTelefono(),
                cl.getDescuentoPorcentual(), estado});
        }
    }

    public void BuscarId(String nombre) {

        LimpiarTabla(dtm);

        for (Cliente i : new ClienteDao().getAll()) {
            if (String.valueOf(i.getIdcliente()).equalsIgnoreCase(nombre)) {
                this.dtm.addRow(new Object[]{i.getIdcliente(), i.getPrimerNombre(), i.getSegundoNombre(), i.getPrimerApellido(), i.getSegundoApellido(), i.getCedula(),
                    i.getDireccion(), i.getCorreoElectronico(), i.getTelefono(), i.getDescuentoPorcentual(), i.isEstado() ? "Activo" : "Inactivo"});
            }
        }
    }

    public void BuscarNombre(String nombre) {

        LimpiarTabla(dtm);

        for (Cliente i : new ClienteDao().getAll()) {
            if (String.valueOf(i.getPrimerNombre()).equalsIgnoreCase(nombre) || i.getPrimerNombre().contains(nombre) || i.getPrimerApellido().endsWith(nombre)
                    || i.getPrimerNombre().startsWith(nombre)) {
                this.dtm.addRow(new Object[]{i.getIdcliente(), i.getPrimerNombre(), i.getSegundoNombre(), i.getPrimerApellido(), i.getSegundoApellido(), i.getCedula(),
                    i.getDireccion(), i.getCorreoElectronico(), i.getTelefono(), i.getDescuentoPorcentual(), i.isEstado() ? "Activo" : "Inactivo"});
            }
        }
    }

    public void BuscarCédula(String nombre) {

        LimpiarTabla(dtm);

        for (Cliente i : new ClienteDao().getAll()) {
            if (String.valueOf(i.getCedula()).equalsIgnoreCase(nombre) || i.getCedula().contains(nombre) || i.getCedula().endsWith(nombre)
                    || i.getCedula().startsWith(nombre)) {
                this.dtm.addRow(new Object[]{i.getIdcliente(), i.getPrimerNombre(), i.getSegundoNombre(), i.getPrimerApellido(), i.getSegundoApellido(), i.getCedula(),
                    i.getDireccion(), i.getCorreoElectronico(), i.getTelefono(), i.getDescuentoPorcentual(), i.isEstado() ? "Activo" : "Inactivo"});
            }
        }
    }

    public void MostrarActivosInactivos(boolean activos) {
        LimpiarTabla(dtm);
        for (Cliente i : new ClienteDao().getAll()) {
            if (i.isEstado() == activos) {
                this.dtm.addRow(new Object[]{i.getIdcliente(), i.getPrimerNombre(), i.getSegundoNombre(), i.getPrimerApellido(), i.getSegundoApellido(), i.getCedula(),
                    i.getDireccion(), i.getCorreoElectronico(), i.getTelefono(), i.getDescuentoPorcentual(), i.isEstado() ? "Activo" : "Inactivo"});
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PrimerNombre = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        Estado = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        PrimerApellido = new javax.swing.JTextField();
        SegundoNombre = new javax.swing.JTextField();
        Telefono = new javax.swing.JTextField();
        SegundoApellido = new javax.swing.JTextField();
        Correo = new javax.swing.JTextField();
        Descuento = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Direccion = new javax.swing.JTextArea();
        Cedula = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        Buscar = new javax.swing.JTextField();
        CbxBuscar = new javax.swing.JComboBox();
        btnMostrar = new javax.swing.JButton();
        CbxMostrar = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        btnImprimir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Clientes Naturales");

        jTabbedPane1.setBackground(new java.awt.Color(242, 241, 240));
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jPanel1.setForeground(new java.awt.Color(254, 254, 254));

        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setText("Primer Nombre:");

        PrimerNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PrimerNombreKeyTyped(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Save 16x16.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(null);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setHideActionText(true);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnGuardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Save 24 x24.png"))); // NOI18N
        btnGuardar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Save 24 x24.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        Estado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activo", "Inactivo" }));

        jLabel2.setForeground(new java.awt.Color(1, 1, 1));
        jLabel2.setText("Segundo Nombre:");

        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setText("Teléfono:");

        jLabel4.setForeground(new java.awt.Color(1, 1, 1));
        jLabel4.setText("Primer Apellido:");

        jLabel5.setForeground(new java.awt.Color(1, 1, 1));
        jLabel5.setText("Correo:");

        jLabel6.setForeground(new java.awt.Color(1, 1, 1));
        jLabel6.setText("Dirección:");

        jLabel7.setForeground(new java.awt.Color(1, 1, 1));
        jLabel7.setText("No. Cédula:");

        jLabel8.setForeground(new java.awt.Color(1, 1, 1));
        jLabel8.setText("Descuento:");

        lblEstado.setForeground(new java.awt.Color(1, 1, 1));
        lblEstado.setText("Estado:");

        PrimerApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PrimerApellidoKeyTyped(evt);
            }
        });

        SegundoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SegundoNombreKeyTyped(evt);
            }
        });

        Telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TelefonoKeyTyped(evt);
            }
        });

        SegundoApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SegundoApellidoKeyTyped(evt);
            }
        });

        Correo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CorreoKeyTyped(evt);
            }
        });

        Descuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DescuentoKeyTyped(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Cancel 32x32.png"))); // NOI18N
        btnCancelar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Cancel 32x32.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(1, 1, 1));
        jLabel10.setText("Segundo Apellido:");

        Direccion.setColumns(20);
        Direccion.setRows(5);
        Direccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DireccionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(Direccion);

        try {
            Cedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-######-####U")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CedulaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10)
                            .addComponent(jLabel7)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SegundoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PrimerApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PrimerNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SegundoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(80, 80, 80)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEstado)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Correo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Descuento, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(PrimerNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(SegundoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(PrimerApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(Descuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(SegundoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstado)
                    .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Registrar Clientes", jPanel1);

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

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/edit.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Edit 32 x 32.png"))); // NOI18N
        btnEditar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Edit 32 x 32.png"))); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(1, 1, 1));
        jLabel9.setText("Tipo de Muestreo:");

        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });
        Buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscarKeyReleased(evt);
            }
        });

        CbxBuscar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Id", "Primer Nombre", "Cédula" }));

        btnMostrar.setText("Aceptar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        CbxMostrar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mostrar Todo", "Mostrar Activos", "Mostrar Inactivos" }));

        jLabel11.setForeground(new java.awt.Color(1, 1, 1));
        jLabel11.setText("Buscar por:");

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Printer.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Printer 32x32.png"))); // NOI18N
        btnImprimir.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Printer 32x32.png"))); // NOI18N
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(CbxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(CbxMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnMostrar)))
                        .addGap(0, 223, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMostrar)
                    .addComponent(CbxMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(CbxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Administrar Clientes", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        String PrNombre, SgNombre, PrApellido,
                SgApellido, DNI, direccion, email, telefono;

        double descuento;

        PrNombre = this.PrimerNombre.getText();
        SgNombre = this.SegundoNombre.getText();
        PrApellido = this.PrimerApellido.getText();
        SgApellido = this.SegundoApellido.getText();
        DNI = this.Cedula.getText();
        direccion = this.Direccion.getText();
        email = this.Correo.getText();
        telefono = this.Telefono.getText();
        descuento = Double.parseDouble(this.Descuento.getText());

        if (!Validator.ValidarEmail(email)) {
            JOptionPane.showInternalMessageDialog(this, "Correo invalido, por favor intente nuevamente", "Ventana de Notificacion", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!new ValidacionCedula().Validacion(DNI)) {

            JOptionPane.showInternalMessageDialog(this, "Por favor ingrese un número de cédula válida", "Ventana de Notificación", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!ValidateName(PrNombre) || !ValidateName(SgNombre) || !ValidateName(PrApellido) || !ValidateName(SgApellido) || !Validator.ValidatePhoneNumber(telefono)) {
            JOptionPane.showInternalMessageDialog(this, "Algún campo tiene información que el sistema no puede procesar", "Ventana de Notificación", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (PrNombre.trim().equals("") || SgNombre.trim().equals("") || PrApellido.trim().equals("")
                || SgApellido.trim().equals("") || DNI.trim().equals("") || direccion.trim().equals("")
                || email.trim().equals("") || telefono.trim().equals("")) {
            JOptionPane.showInternalMessageDialog(this, "Error al ingresar los datos, por favor intente nuevamente", "Ventana de Error", JOptionPane.ERROR_MESSAGE);
        } else {

            Cliente cl = new Cliente();
            cl.setPrimerNombre(PrNombre);
            cl.setSegundoNombre(SgNombre);
            cl.setPrimerApellido(PrApellido);
            cl.setSegundoApellido(SgApellido);
            cl.setCedula(DNI);
            cl.setDireccion(direccion);
            cl.setCorreoElectronico(email);
            cl.setTelefono(telefono);
            cl.setDescuentoPorcentual((float) descuento);

            if (!Editar) {
                cl.setEstado(true);
                long id = new Dao().Guardar(cl);

                if (id == -1) {
                    JOptionPane.showInternalMessageDialog(this, "No se puede guardar \n intente mas tarde, si el problema persiste contactese con el administrador del sistema", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Guardado Exitosamente", "Operacion realizada con exito", JOptionPane.INFORMATION_MESSAGE);
                    Cargar();
                }
            } else {
                cl.setIdcliente(Id);
                if (Estado.getSelectedIndex() == 0) {
                    cl.setEstado(true);
                } else {
                    cl.setEstado(false);
                }

                boolean actualizado = new Dao().Actualizar(cl);
                if (!actualizado) {
                    JOptionPane.showInternalMessageDialog(this, "No se puede actualizar \n intente mas tarde, si el problema persiste contactese con el administrador del sistema", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Actualizado Exitosamente", "Operacion realizada con exito", JOptionPane.INFORMATION_MESSAGE);
                    Id = -1;
                    Estado.setSelectedIndex(0);
                    Editar = false;
                    Estado.setVisible(false);
                    lblEstado.setVisible(false);
                    this.jTabbedPane1.setSelectedIndex(1);
                    Cargar();
                }
            }
        }
        PrimerNombre.setText(null);
        SegundoNombre.setText(null);
        PrimerApellido.setText(null);
        SegundoApellido.setText(null);
        Cedula.setText(null);
        Direccion.setText(null);
        Correo.setText(null);
        Telefono.setText(null);
        Descuento.setText(null);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        PrimerNombre.setText(null);
        SegundoNombre.setText(null);
        PrimerApellido.setText(null);
        SegundoApellido.setText(null);
        Cedula.setText(null);
        Direccion.setText(null);
        Correo.setText(null);
        Telefono.setText(null);
        Descuento.setText(null);

        if (Editar) {
            Id = -1;
            Editar = false;
            this.jTabbedPane1.setSelectedIndex(1);
            this.Estado.setVisible(false);
            lblEstado.setVisible(false);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        int nf = jTable1.getSelectedRow();

        if (nf == -1) {
            JOptionPane.showInternalMessageDialog(this, "Primero debe seleccionar una fila", "Ventana de Notificación", JOptionPane.ERROR_MESSAGE);
            return;
        } else {

            this.Id = Integer.parseInt(dtm.getValueAt(nf, 0).toString());
            this.jTabbedPane1.setSelectedIndex(0);
            this.lblEstado.setVisible(true);
            this.Estado.setVisible(true);
            Cliente cl = new ClienteDao().getById(Id);
            PrimerNombre.setText(cl.getPrimerNombre());
            SegundoNombre.setText(cl.getSegundoNombre());
            PrimerApellido.setText(cl.getPrimerApellido());
            SegundoApellido.setText(cl.getSegundoApellido());
            Cedula.setText(cl.getCedula());
            Direccion.setText(cl.getDireccion());
            Correo.setText(cl.getCorreoElectronico());
            Telefono.setText(cl.getTelefono());
            Descuento.setText(String.valueOf(cl.getDescuentoPorcentual()));
            if (cl.isEstado()) {

                Estado.setSelectedIndex(0);
            } else {
                Estado.setSelectedIndex(1);
            }
            Editar = true;
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        btnEditar.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        if (this.jTabbedPane1.getSelectedIndex() == 0) {
            Cargar();
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void PrimerNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PrimerNombreKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            SegundoNombre.requestFocus();
        }
    }//GEN-LAST:event_PrimerNombreKeyTyped

    private void SegundoNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SegundoNombreKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            PrimerApellido.requestFocus();
        }
    }//GEN-LAST:event_SegundoNombreKeyTyped

    private void PrimerApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PrimerApellidoKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            SegundoApellido.requestFocus();
        }
    }//GEN-LAST:event_PrimerApellidoKeyTyped

    private void SegundoApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SegundoApellidoKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            Cedula.requestFocus();
        }
    }//GEN-LAST:event_SegundoApellidoKeyTyped

    private void CedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CedulaKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            Direccion.requestFocus();
        }
    }//GEN-LAST:event_CedulaKeyTyped

    private void DireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DireccionKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            Correo.requestFocus();
        }
    }//GEN-LAST:event_DireccionKeyTyped

    private void CorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CorreoKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            Telefono.requestFocus();
        }
    }//GEN-LAST:event_CorreoKeyTyped

    private void TelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TelefonoKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            Descuento.requestFocus();
        }

        if (Telefono.getText().length() >= 8) {
            evt.consume();
        }
    }//GEN-LAST:event_TelefonoKeyTyped

    private void BuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarKeyReleased
        this.btnEditar.setEnabled(false);
        String texto = Buscar.getText();
        if (texto.trim().equals("")) {
            this.Cargar();
            return;
        }
        switch (CbxBuscar.getSelectedIndex() + 1) {

            case 1: {
                this.BuscarId(texto);
                break;
            }
            case 2: {
                this.BuscarNombre(texto);
                break;
            }
            case 3: {
                this.BuscarCédula(texto);
                break;
            }
        }
    }//GEN-LAST:event_BuscarKeyReleased

    private void DescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DescuentoKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != '.' || (c == '.' && Descuento.getText().contains("."))) {
            evt.consume();
        }
    }//GEN-LAST:event_DescuentoKeyTyped

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        this.btnEditar.setEnabled(false);
        switch (CbxMostrar.getSelectedIndex() + 1) {
            case 1: {
                this.Cargar();
                break;
            }
            case 2: {
                MostrarActivosInactivos(true);
                break;
            }
            case 3: {
                MostrarActivosInactivos(false);
                break;
            }
        }
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed

//        if (CbxBuscar.getSelectedIndex() == 1) {
//            Query q = session.createQuery("from Cliente where estado = true");
//            q.list();
////        }
        JasperReport report = null;
        Connection con = null;
        SessionFactoryImplementor SFI = null;

        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        SFI = (SessionFactoryImplementor) session.getSessionFactory();

        try {
            con = (Connection) SFI.getConnectionProvider().getConnection();
        } catch (SQLException ex) {
            return;
        }
        try {
            HashMap h = new HashMap();
            h.put("ClienteActivos", true);
            report = (JasperReport) JRLoader.loadObject(this.getClass().getResource("/ClienteNatural/cliente.jasper"));
            JasperPrint print = JasperFillManager.fillReport(report, h, con);
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            viewer.setTitle("Reporte de Clientes Naturales");
            viewer.setVisible(true);
        } catch (JRException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }//GEN-LAST:event_btnImprimirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Buscar;
    private javax.swing.JComboBox CbxBuscar;
    public javax.swing.JComboBox CbxMostrar;
    private javax.swing.JFormattedTextField Cedula;
    private javax.swing.JTextField Correo;
    private javax.swing.JTextField Descuento;
    public javax.swing.JTextArea Direccion;
    private javax.swing.JComboBox Estado;
    private javax.swing.JTextField PrimerApellido;
    private javax.swing.JTextField PrimerNombre;
    private javax.swing.JTextField SegundoApellido;
    private javax.swing.JTextField SegundoNombre;
    private javax.swing.JTextField Telefono;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnMostrar;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblEstado;
    // End of variables declaration//GEN-END:variables
}
