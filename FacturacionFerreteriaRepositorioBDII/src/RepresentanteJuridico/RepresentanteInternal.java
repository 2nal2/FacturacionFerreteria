/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RepresentanteJuridico;

import Dao.ClienteJuridicoDao;
import Dao.Dao;
import Dao.RepresentanteDao;
import Methods.ValidacionCedula;
import static Methods.Validaciones.ValidateName;
import Methods.Validator;
import static MetodoComunes.Metodos.Centrar;
import static MetodoComunes.Metodos.LimpiarTabla;
import Modelos.RepresentanteCJ;
import POJO.RepresentanteClienteJuridico;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author martin
 */
public class RepresentanteInternal extends javax.swing.JInternalFrame {

    //BuscarCliente bc;
    DefaultTableModel dtm = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    boolean Editar = false;
    public int Id = -1;

    public RepresentanteInternal() {
        initComponents();
        InicializarTabla();
        Cargar();
        this.Direccion.setLineWrap(true);
        btnEditar.setEnabled(false);
        lblEstado.setVisible(false);
        Estado.setVisible(false);
    }

    public void InicializarTabla() {
        dtm.addColumn("IDRepresentante");
        dtm.addColumn("Nombre Representante");
        dtm.addColumn("# RUC");
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
//        Cargar();
    }

    public void Cargar() {
        LimpiarTabla(dtm);
        for (RepresentanteCJ rcj : new RepresentanteDao().getRepresentanteCJ()) {
            String estado = "Inactivo";
            if (rcj.isEstado()) {
                estado = "Activo";
            }
            dtm.addRow(new Object[]{rcj.getIdRepresentante(), rcj.getNombreEmpresa(), rcj.getRUC(), rcj.getPrimerNombre(),
                rcj.getSegundoNombre(), rcj.getPrimerApellido(), rcj.getSegundoApellido(), rcj.getCedula(),
                rcj.getDireccion(), rcj.getCorreoElectronico(), rcj.getTelefono(), estado});
        }
    }

    public void BuscarId(String nombre) {
        LimpiarTabla(dtm);
        for (RepresentanteCJ pr : new RepresentanteDao().getRepresentanteCJ()) {
            if (String.valueOf(pr.getIdRepresentante()).equalsIgnoreCase(nombre)) {
                this.dtm.addRow(new Object[]{pr.getIdRepresentante(), pr.getNombreEmpresa(), pr.getRUC(), pr.getDireccion(),
                    pr.getTelefono(), pr.getCorreoElectronico(), pr.getPrimerNombre(), pr.getSegundoNombre(), pr.getPrimerApellido(),
                    pr.getSegundoApellido(), pr.getCedula(), pr.isEstado() ? "Activo" : "Inactivo"});
            }
        }
    }

    public void BuscarNombre(String nombre) {
        LimpiarTabla(dtm);
        for (RepresentanteCJ pr : new RepresentanteDao().getRepresentanteCJ()) {
            if (String.valueOf(pr.getNombreEmpresa()).equalsIgnoreCase(nombre) || pr.getNombreEmpresa().contains(nombre) || pr.getNombreEmpresa().endsWith(nombre)
                    || pr.getNombreEmpresa().startsWith(nombre)) {
                this.dtm.addRow(new Object[]{pr.getIdRepresentante(), pr.getNombreEmpresa(), pr.getRUC(), pr.getDireccion(),
                    pr.getTelefono(), pr.getCorreoElectronico(), pr.getPrimerNombre(), pr.getSegundoNombre(), pr.getPrimerApellido(),
                    pr.getSegundoApellido(), pr.getCedula(), pr.isEstado() ? "Activo" : "Inactivo"});
            }
        }
    }

    public void BuscarCedula(String nombre) {
        LimpiarTabla(dtm);
        for (RepresentanteCJ pr : new RepresentanteDao().getRepresentanteCJ()) {
            if (String.valueOf(pr.getCedula()).equalsIgnoreCase(nombre) || pr.getCedula().contains(nombre) || pr.getCedula().endsWith(nombre) 
                    || pr.getCedula().startsWith(nombre)) {
                this.dtm.addRow(new Object[]{pr.getIdRepresentante(), pr.getNombreEmpresa(), pr.getRUC(), pr.getDireccion(),
                    pr.getTelefono(), pr.getCorreoElectronico(), pr.getPrimerNombre(), pr.getSegundoNombre(), pr.getPrimerApellido(),
                    pr.getSegundoApellido(), pr.getCedula(), pr.isEstado() ? "Activo" : "Inactivo"});
            }
        }
    }
    
    public void MostrarActivosInactivos (boolean activos) {
        LimpiarTabla(dtm);
        for (RepresentanteCJ pr : new RepresentanteDao().getRepresentanteCJ()) {
            if (pr.isEstado() == activos) {
                this.dtm.addRow(new Object[]{pr.getIdRepresentante(), pr.getNombreEmpresa(), pr.getRUC(), pr.getDireccion(),
                    pr.getTelefono(), pr.getCorreoElectronico(), pr.getPrimerNombre(), pr.getSegundoNombre(), pr.getPrimerApellido(),
                    pr.getSegundoApellido(), pr.getCedula(), pr.isEstado() ? "Activo" : "Inactivo"});
            }
        }
    }
    /*Eso es otra cosa, a veces cuesta que me muestre los datos en ,perame ya se yo la cage*/
//    public void CargarCliente() {
//        LimpiarTabla(dtm);
//
//        for (ClienteJuridico cj : new ClienteJuridicoDao().getAll()) {
//            String estado = "Inactivo";
//            if (cj.isEstado()) {
//                estado = "Activo";
//            }
//            dtm.addRow(new Object[]{cj.getIdclienteJuridico(), cj.getNombre(), cj.getRuc(),
//                cj.getDireccion(), cj.getTelefono(), cj.getCorreoElectronico(), cj.getDescuentoPorcentual(),
//                cj.getFax(), estado});
//        }
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblEmpresa = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        NombreCliente = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        PrimerNombre = new javax.swing.JTextField();
        SegundoNombre = new javax.swing.JTextField();
        PrimerApellido = new javax.swing.JTextField();
        SegundoApellido = new javax.swing.JTextField();
        Telefono = new javax.swing.JTextField();
        Correo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Direccion = new javax.swing.JTextArea();
        Estado = new javax.swing.JComboBox();
        btnCancelar = new javax.swing.JButton();
        btnGuadar = new javax.swing.JButton();
        Cedula = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        Buscar = new javax.swing.JTextField();
        CbxBuscar = new javax.swing.JComboBox();
        CbxMostrar = new javax.swing.JComboBox();
        BtnMostrar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Representantes de Clientes Jurídicos");

        jTabbedPane1.setBackground(new java.awt.Color(65, 146, 141));

        lblEmpresa.setBackground(new java.awt.Color(254, 254, 254));
        lblEmpresa.setForeground(new java.awt.Color(1, 1, 1));
        lblEmpresa.setText("Nombre Empresa:");

        jLabel2.setBackground(new java.awt.Color(254, 254, 254));
        jLabel2.setForeground(new java.awt.Color(1, 1, 1));
        jLabel2.setText("Segundo Nombre:");

        jLabel3.setBackground(new java.awt.Color(254, 254, 254));
        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setText("Primer Nombre:");

        jLabel4.setBackground(new java.awt.Color(254, 254, 254));
        jLabel4.setForeground(new java.awt.Color(1, 1, 1));
        jLabel4.setText("Segundo Apellido:");

        jLabel5.setBackground(new java.awt.Color(254, 254, 254));
        jLabel5.setForeground(new java.awt.Color(1, 1, 1));
        jLabel5.setText("Primer Apellido:");

        jLabel6.setForeground(new java.awt.Color(1, 1, 1));
        jLabel6.setText("Dirección:");

        jLabel7.setForeground(new java.awt.Color(1, 1, 1));
        jLabel7.setText("Correo:");

        jLabel8.setBackground(new java.awt.Color(254, 254, 254));
        jLabel8.setForeground(new java.awt.Color(1, 1, 1));
        jLabel8.setText("Cédula:");

        jLabel9.setForeground(new java.awt.Color(1, 1, 1));
        jLabel9.setText("Teléfono:");

        lblEstado.setForeground(new java.awt.Color(1, 1, 1));
        lblEstado.setText("Estado:");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Lupa.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        PrimerApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrimerApellidoActionPerformed(evt);
            }
        });

        SegundoApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SegundoApellidoActionPerformed(evt);
            }
        });

        Telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelefonoActionPerformed(evt);
            }
        });

        Direccion.setColumns(20);
        Direccion.setRows(5);
        jScrollPane1.setViewportView(Direccion);

        Estado.setEditable(true);
        Estado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activo", "Inactivo" }));

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuadar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Save 16x16.png"))); // NOI18N
        btnGuadar.setText("Guardar");
        btnGuadar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuadarActionPerformed(evt);
            }
        });

        try {
            Cedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-######-####U")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(lblEmpresa)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(NombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnBuscar))
                                    .addComponent(PrimerNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SegundoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PrimerApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SegundoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9)
                                    .addComponent(lblEstado)
                                    .addComponent(jLabel8))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Telefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Correo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Estado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Cedula, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 16, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnGuadar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblEmpresa)
                                .addComponent(NombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(PrimerNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(SegundoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(PrimerApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(SegundoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEstado)
                            .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuadar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Registrar Representantes", jPanel1);

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
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(1, 1, 1));
        jLabel10.setText("Buscar por:");

        Buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscarKeyReleased(evt);
            }
        });

        CbxBuscar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Id", "Nombre Empresa", "Cédula" }));

        CbxMostrar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mostrar Todo", "Mostrar Activos", "Mostrar Inactivos" }));

        BtnMostrar.setText("Aceptar");
        BtnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMostrarActionPerformed(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(1, 1, 1));
        jLabel11.setText("Tipo de Muestreo:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CbxMostrar, 0, 155, Short.MAX_VALUE)
                    .addComponent(CbxBuscar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnMostrar)
                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CbxMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnMostrar)
                    .addComponent(jLabel11))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(btnEditar)
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("Administrar Representantes", jPanel2);

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

    private void TelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TelefonoActionPerformed

    private void PrimerApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrimerApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrimerApellidoActionPerformed

    private void SegundoApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SegundoApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SegundoApellidoActionPerformed

    private void btnGuadarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuadarActionPerformed

        String nombrecliente, PrNombre, SgNombre, PrApellido, SgApellido, DNI,
                direccion, correo, telefono;
//        int idcliente = Integer.parseInt(IdCliente.getText());

        nombrecliente = this.NombreCliente.getText();
        PrNombre = this.PrimerNombre.getText();
        SgNombre = this.SegundoNombre.getText();
        PrApellido = this.PrimerApellido.getText();
        SgApellido = this.SegundoApellido.getText();
        DNI = this.Cedula.getText();
        direccion = this.Direccion.getText();
        correo = this.Correo.getText();
        telefono = this.Telefono.getText();

        if (!new ValidacionCedula().Validacion(DNI)) {
            JOptionPane.showInternalMessageDialog(this, "Número de Cédula no válido,", "Ventana de Notificaciṕn", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!ValidateName(PrNombre) || !ValidateName(SgNombre) || !ValidateName(PrApellido) || !ValidateName(SgApellido) || !Validator.ValidatePhoneNumber(telefono)) {

            JOptionPane.showInternalMessageDialog(this, "Algún campo tiene información que el sistema no puede procesar", "Ventana de Notificación", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (nombrecliente.trim().equals("") || PrNombre.trim().equals("") || SgNombre.trim().equals("")
                || PrApellido.trim().equals("") || SgApellido.trim().equals("") || DNI.trim().equals("")
                || direccion.trim().equals("") || correo.trim().equals("") || telefono.trim().equals("")) {
            JOptionPane.showInternalMessageDialog(this, "Por favor no deje campos vacíos, intentelode nuevo", "Ventana de Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else {
            RepresentanteClienteJuridico rcj = new RepresentanteClienteJuridico();
            rcj.setClienteJuridico(new ClienteJuridicoDao().getById(Id));
            rcj.setPrimerNombre(PrNombre);
            rcj.setSegundoNombre(SgNombre);
            rcj.setPrimerApellido(PrApellido);
            rcj.setSegundoApellido(SgApellido);
            rcj.setCedula(DNI);
            rcj.setDireccion(direccion);
            rcj.setCorreoElectronico(correo);
            rcj.setTelefono(telefono);

            if (!Editar) {
                rcj.setEstado(true);
                long id = new Dao().Guardar(rcj);

                if (id == -1) {
                    JOptionPane.showInternalMessageDialog(this, "No se puede guardar \n intente mas tarde, si el problema persiste contactese con el administrador del sistema", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Guardado Exitosamente", "Operacion realizada con exito", JOptionPane.INFORMATION_MESSAGE);
                    Cargar();
                }
            } else {
                rcj.setIdrepresentante(Id);
                if (Estado.getSelectedIndex() == 0) {
                    rcj.setEstado(true);
                } else {
                    rcj.setEstado(false);
                }

                boolean actualizado = new Dao().Actualizar(rcj);
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
        NombreCliente.setText(null);
        PrimerNombre.setText(null);
        PrimerApellido.setText(null);
        SegundoApellido.setText(null);
        SegundoNombre.setText(null);
        Direccion.setText(null);
        Correo.setText(null);
        Telefono.setText(null);
        Cedula.setText(null);

    }//GEN-LAST:event_btnGuadarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        BuscarCliente bcl = new BuscarCliente(this);
        Centrar(bcl, this.getDesktopPane());
//        CargarCliente();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        NombreCliente.setText(null);
        PrimerNombre.setText(null);
        PrimerApellido.setText(null);
        SegundoApellido.setText(null);
        SegundoNombre.setText(null);
        Direccion.setText(null);
        Correo.setText(null);
        Telefono.setText(null);
        Cedula.setText(null);
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
        this.lblEmpresa.setVisible(false);
        this.NombreCliente.setVisible(false);
        this.btnBuscar.setVisible(false);
        this.Id = Integer.parseInt(dtm.getValueAt(nf, 0).toString());
        this.jTabbedPane1.setSelectedIndex(0);
        this.lblEstado.setVisible(true);
        this.Estado.setVisible(true);

        if (nf == -1) {

            JOptionPane.showInternalMessageDialog(this, "Primero debe seleccionar una fila", "Ventana de Notificación", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            //String ruc;
            RepresentanteClienteJuridico cj = new RepresentanteDao().getById(Id);
            NombreCliente.setText(new RepresentanteDao().getNombreClinteJuridico(cj.getIdrepresentante()));
            PrimerNombre.setText(cj.getPrimerNombre());
            SegundoNombre.setText(cj.getSegundoNombre());
            PrimerApellido.setText(cj.getPrimerApellido());
            SegundoApellido.setText(cj.getSegundoApellido());
            Cedula.setText(cj.getCedula());
            Direccion.setText(cj.getDireccion());
            Telefono.setText(cj.getTelefono());
            Correo.setText(cj.getCorreoElectronico());

            if (cj.isEstado()) {
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
                this.BuscarCedula(texto);
                break;
            }
        }
    }//GEN-LAST:event_BuscarKeyReleased

    private void BtnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMostrarActionPerformed
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
    }//GEN-LAST:event_BtnMostrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnMostrar;
    private javax.swing.JTextField Buscar;
    private javax.swing.JComboBox CbxBuscar;
    private javax.swing.JComboBox CbxMostrar;
    private javax.swing.JFormattedTextField Cedula;
    private javax.swing.JTextField Correo;
    private javax.swing.JTextArea Direccion;
    private javax.swing.JComboBox Estado;
    public javax.swing.JTextField NombreCliente;
    private javax.swing.JTextField PrimerApellido;
    private javax.swing.JTextField PrimerNombre;
    private javax.swing.JTextField SegundoApellido;
    private javax.swing.JTextField SegundoNombre;
    private javax.swing.JTextField Telefono;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuadar;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblEmpresa;
    private javax.swing.JLabel lblEstado;
    // End of variables declaration//GEN-END:variables
}
