/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vendedores;

import Dao.Dao;
import Dao.ProveedoresDao;
import Dao.VendedoresDao;
import Methods.ValidacionCedula;
import static Methods.Validaciones.ValidateName;
import static MetodoComunes.Metodos.Centrar;
import static MetodoComunes.Metodos.LimpiarTabla;
import Modelos.VendedoresP;
import POJO.Vendedores;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author martin
 */
public class VendedoresInternal extends javax.swing.JInternalFrame {

    DefaultTableModel dtm = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    boolean Editar = false;
    public int Id = -1;

    public VendedoresInternal() {
        initComponents();
        InicializarTabla();
        Cargar();
        btnEditar.setEnabled(false);
        btnEditar.setEnabled(false);
        lblEstado.setVisible(false);
        Estado.setVisible(false);

    }

    public void InicializarTabla() {
        dtm.addColumn("IDVendedor");
        dtm.addColumn("Nombre Empresa");
        dtm.addColumn("# RUC");
        dtm.addColumn("Cedula");
        dtm.addColumn("Primer Nombre");
        dtm.addColumn("Segundo Nombre");
        dtm.addColumn("Primer Apellido");
        dtm.addColumn("Segundo Apellido");
        dtm.addColumn("Estado");
        jTable1.setModel(dtm);
        Cargar();
    }

    public void Cargar() {
        LimpiarTabla(dtm);
        for (VendedoresP ve : new VendedoresDao().getProveedores()) {
            String estado = "Inactivo";
            if (ve.isEstado()) {
                estado = "Activo";
            }
            dtm.addRow(new Object[]{ve.getIdVendedor(), ve.getNombre(), ve.getRuc(), ve.getCedula(), ve.getPrimerNombre(),
                ve.getSegundoNombre(), ve.getPrimerApellido(), ve.getSegundoApellido(), estado});

        }
    }

    public void BuscarId(String nombre) {
        LimpiarTabla(dtm);
        for (VendedoresP ve : new VendedoresDao().getProveedores()) {

            if (String.valueOf(ve.getIdVendedor()).equalsIgnoreCase(nombre)) {
                this.dtm.addRow(new Object[]{ve.getIdVendedor(), ve.getNombre(), ve.getRuc(), ve.getCedula(), ve.getPrimerNombre(),
                    ve.getSegundoNombre(), ve.getPrimerApellido(), ve.getSegundoApellido(), ve.isEstado() ? "Activo" : "Inactivo"});
            }
        }
    }

    public void BuscarNombre(String nombre) {
        LimpiarTabla(dtm);
        for (VendedoresP ve : new VendedoresDao().getProveedores()) {

            if (String.valueOf(ve.getNombre()).equalsIgnoreCase(nombre) || ve.getNombre().contains(nombre) || ve.getNombre().endsWith(nombre)
                    || ve.getNombre().startsWith(nombre)) {
                this.dtm.addRow(new Object[]{ve.getIdVendedor(), ve.getNombre(), ve.getRuc(), ve.getCedula(), ve.getPrimerNombre(),
                    ve.getSegundoNombre(), ve.getPrimerApellido(), ve.getSegundoApellido(), ve.isEstado() ? "Activo" : "Inactivo"});
            }
        }
    }

    public void BuscarCédula(String nombre) {
        LimpiarTabla(dtm);
        for (VendedoresP ve : new VendedoresDao().getProveedores()) {

            if (String.valueOf(ve.getCedula()).equalsIgnoreCase(nombre) || ve.getCedula().contains(nombre) || ve.getCedula().endsWith(nombre)
                    || ve.getCedula().startsWith(nombre)) {
                this.dtm.addRow(new Object[]{ve.getIdVendedor(), ve.getNombre(), ve.getRuc(), ve.getCedula(), ve.getPrimerNombre(),
                    ve.getSegundoNombre(), ve.getPrimerApellido(), ve.getSegundoApellido(), ve.isEstado() ? "Activo" : "Inactivo"});
            }
        }
    }

    public void BuscarActivosInactivos(boolean activos) {
        LimpiarTabla(dtm);
        for (VendedoresP ve : new VendedoresDao().getProveedores()) {

            if (ve.isEstado() == activos) {
                this.dtm.addRow(new Object[]{ve.getIdVendedor(), ve.getNombre(), ve.getRuc(), ve.getCedula(), ve.getPrimerNombre(),
                    ve.getSegundoNombre(), ve.getPrimerApellido(), ve.getSegundoApellido(), ve.isEstado() ? "Activo" : "Inactivo"});
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        PNombre = new javax.swing.JTextField();
        Cedula = new javax.swing.JFormattedTextField();
        SNombre = new javax.swing.JTextField();
        Estado = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        PApellido = new javax.swing.JTextField();
        SApellido = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        NombreEmpresa = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        RUC = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        Buscar = new javax.swing.JTextField();
        CbxBuscar = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        CbxActividades = new javax.swing.JComboBox();
        btnMostrar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Vendedores");

        jTabbedPane1.setBackground(new java.awt.Color(242, 241, 240));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información del Vendedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 3, 12), new java.awt.Color(76, 76, 76))); // NOI18N

        jLabel3.setText("Segundo Nombre:");

        jLabel6.setText("Primer Nombre:");

        jLabel7.setText("Cédula:");

        lblEstado.setText("Estado:");

        PNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PNombreKeyTyped(evt);
            }
        });

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

        SNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SNombreKeyTyped(evt);
            }
        });

        Estado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activo", "Inactivo" }));

        jLabel4.setText("Primer Apellido");

        jLabel5.setText("Segundo Apellido:");

        PApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PApellidoKeyTyped(evt);
            }
        });

        SApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SApellidoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEstado)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(44, 44, 44)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(PNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(SNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(PApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(SApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(44, 44, 44)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstado)
                    .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información de Proveedores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 3, 12), new java.awt.Color(76, 76, 76))); // NOI18N

        jLabel1.setText("Nombre de la Empresa:");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Lupa.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btnBuscarKeyTyped(evt);
            }
        });

        jLabel2.setText("# RUC:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RUC, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(btnBuscar)
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(NombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(RUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Cancel 32x32.png"))); // NOI18N
        btnCancelar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Cancel 32x32.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Save 16x16.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Save 24 x24.png"))); // NOI18N
        btnGuardar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Save 24 x24.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Registrar Ejecutivos de Ventas", jPanel1);

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
        jScrollPane1.setViewportView(jTable1);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/edit.png"))); // NOI18N
        btnEditar.setText("Actualizar");
        btnEditar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Edit 32 x 32.png"))); // NOI18N
        btnEditar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Edit 32 x 32.png"))); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jLabel8.setText("Buscar por:");

        Buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscarKeyReleased(evt);
            }
        });

        CbxBuscar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Id", "Nombre Empresa", "Cédula" }));

        jLabel9.setText("Tipo de Muestreo:");

        CbxActividades.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mostrar Todo", "Mostrar Activos", "Mostrar Inactivos" }));

        btnMostrar.setText("Aceptar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbxActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMostrar)
                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(283, 283, 283))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(CbxActividades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMostrar))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 792, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                .addGap(25, 25, 25)
                .addComponent(btnEditar)
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("Administrar Ejecutivos de Ventas", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        String pnombre, snombre, apellido, sapellido, nombrempresa, ruc, DNI;
        //int idproveedor =0;
        pnombre = this.PNombre.getText();
        snombre = this.SNombre.getText();
        apellido = this.PApellido.getText();
        sapellido = this.SApellido.getText();
        nombrempresa = this.NombreEmpresa.getText();
        ruc = this.RUC.getText();
        DNI = this.Cedula.getText();

        if (!new ValidacionCedula().Validacion(DNI)) {

            JOptionPane.showInternalMessageDialog(this, "Por favor ingrese un número de cédula válida", "Ventana de Notificación", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!ValidateName(pnombre) || !ValidateName(snombre) || !ValidateName(apellido) || !ValidateName(sapellido)) {

            JOptionPane.showInternalMessageDialog(this, "Algún campo tiene información que el sistema no puede procesar", "Ventana de Notificación", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (pnombre.trim().equals("") || snombre.trim().equals("") || apellido.trim().equals("")
                || sapellido.trim().equals("") || nombrempresa.trim().equals("") || ruc.trim().equals("")
                || DNI.trim().equals("")) {

            JOptionPane.showInternalMessageDialog(this, "Algún campo quedó vacío, por favor intente nuevamente", "Ventana de Notificación", JOptionPane.ERROR_MESSAGE);
            return;
        } else {

            Vendedores ve = new Vendedores();
            ve.setCedula(DNI);
            ve.setProveedores(new ProveedoresDao().getById(Id));
            ve.setPrimerNombre(pnombre);
            ve.setSegundoNombre(snombre);
            ve.setPrimerApellido(apellido);
            ve.setSegundoApellido(sapellido);

            if (!Editar) {
                ve.setEstado(true);
                long id = new Dao().Guardar(ve);

                if (id == -1) {
                    JOptionPane.showInternalMessageDialog(this, "No se puede guardar \n intente mas tarde, si el problema persiste contactese con el administrador del sistema", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Guardado Exitosamente", "Operacion realizada con exito", JOptionPane.INFORMATION_MESSAGE);
                    Cargar();
                }
            } else {
                ve.setIdVendedor(Id);
                if (Estado.getSelectedIndex() == 0) {
                    ve.setEstado(true);
                } else {
                    ve.setEstado(false);
                }

                boolean actualizado = new Dao().Actualizar(ve);
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

            /*  REPORTE MÓDULO CLIENTE, REPRESENTATE, EMPLEADO, PROVEEDORES, VENDEDORES
             Realize by Anonymous II
             Hice cambios en TODOS los clientes (Natural y Juridico), Proveedores, RepresentanteJuridico,
             y Vendedores. Todos buscan! Pero solo por ID no se porque no me buscan por los otros parámetros,
             si le das una chekeada al code seria bueno, si no pues, lo vemos mañana eso. Acordate que modificamos
             los DAO, el de VendedoresDao y RepresentanteDao, en el package MODELOS agregue RepresentanteCJ y VendedoresP
             También en el paquete Methods, agregue 3 clases de validacion (ValidacionCedula. Validaciones, Validator)
             es obvio el motivo por el cual las agregue :v y eso es todo shele :v
             */
        }
        NombreEmpresa.setText(null);
        PNombre.setText(null);
        PApellido.setText(null);
        SApellido.setText(null);
        SNombre.setText(null);
        Cedula.setText(null);
        RUC.setText(null);

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        NombreEmpresa.setText(null);
        PNombre.setText(null);
        PApellido.setText(null);
        SApellido.setText(null);
        SNombre.setText(null);
        Cedula.setText(null);
        RUC.setText(null);
        if (Editar) {
            Id = -1;
            Editar = false;
            this.jTabbedPane1.setSelectedIndex(1);
            this.Estado.setVisible(false);
            lblEstado.setVisible(false);
        }

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        BuscarProveedores bp = new BuscarProveedores(this);
        Centrar(bp, this.getDesktopPane());

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        int nf = jTable1.getSelectedRow();
        this.btnBuscar.setVisible(false);
        this.Id = Integer.parseInt(dtm.getValueAt(nf, 0).toString());
        this.NombreEmpresa.setText(dtm.getValueAt(nf, 1).toString());
        this.RUC.setText(dtm.getValueAt(nf, 2).toString());
        this.jTabbedPane1.setSelectedIndex(0);
        this.lblEstado.setVisible(true);
        this.Estado.setVisible(true);

        if (nf == -1) {

            JOptionPane.showInternalMessageDialog(this, "Primero debe seleccionar una fila", "Ventana de Notificación", JOptionPane.ERROR_MESSAGE);
            return;

        } else {

            Vendedores cj = new VendedoresDao().getById(Id);
//            NombreEmpresa.setText(new VendedoresDao().getNombreVendedores(cj.getIdVendedor()));
//            RUC.setText(new VendedoresDao().getNombreVendedores(cj.getIdVendedor()));
////            NombreEmpresa.setText(cj.getProveedores().getNombre());
//            RUC.setText(cj.getProveedores().getRuc());
            PNombre.setText(cj.getPrimerNombre());
            SNombre.setText(cj.getSegundoNombre());
            PApellido.setText(cj.getPrimerApellido());
            SApellido.setText(cj.getSegundoApellido());
            Cedula.setText(cj.getCedula());

            if (cj.isEstado()) {
                Estado.setSelectedIndex(0);
            } else {
                Estado.setSelectedIndex(1);
            }
            Editar = true;
        }
        NombreEmpresa.setEditable(false);
        RUC.setEditable(false);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        btnEditar.setEnabled(true);

    }//GEN-LAST:event_jTable1MouseClicked

    private void BuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarKeyReleased
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

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        switch (CbxActividades.getSelectedIndex() + 1) {
            case 1: {
                this.Cargar();
                break;
            }
            case 2: {
                BuscarActivosInactivos(true);
                break;
            }
            case 3: {
                BuscarActivosInactivos(false);
                break;
            }
        }
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void PNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PNombreKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            SNombre.requestFocus();
        }
    }//GEN-LAST:event_PNombreKeyTyped

    private void SNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SNombreKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
              PApellido.requestFocus();
        }
    }//GEN-LAST:event_SNombreKeyTyped

    private void CedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CedulaKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            btnBuscar.requestFocus();
        }
    }//GEN-LAST:event_CedulaKeyTyped

    private void PApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PApellidoKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            SApellido.requestFocus();
        }
    }//GEN-LAST:event_PApellidoKeyTyped

    private void SApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SApellidoKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            Cedula.requestFocus();
        }
    }//GEN-LAST:event_SApellidoKeyTyped

    private void btnBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            btnGuardar.requestFocus();
        }
    }//GEN-LAST:event_btnBuscarKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Buscar;
    private javax.swing.JComboBox CbxActividades;
    private javax.swing.JComboBox CbxBuscar;
    private javax.swing.JFormattedTextField Cedula;
    private javax.swing.JComboBox Estado;
    public javax.swing.JTextField NombreEmpresa;
    private javax.swing.JTextField PApellido;
    private javax.swing.JTextField PNombre;
    public javax.swing.JTextField RUC;
    private javax.swing.JTextField SApellido;
    private javax.swing.JTextField SNombre;
    public javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblEstado;
    // End of variables declaration//GEN-END:variables
}
