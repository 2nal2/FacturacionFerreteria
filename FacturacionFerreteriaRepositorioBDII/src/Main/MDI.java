package Main;

import Cambio.Cambio;
import Categoria.CategoriaInternal;
import ClienteJuridico.ClienteJuridicoInternal;
import ClienteNatural.ClienteNaturalInternal;
import Compra.CompraInternal;
import Empleados.EmpleadoINternal1;
import static MetodoComunes.Metodos.Centrar;
import Producto.InventarioInternal;
import Proveedores.ProveedoresInternal;
import RepresentanteJuridico.RepresentanteInternal;
import Vendedores.VendedoresInternal;
import Venta.AdministrarFactura;
import Venta.FacturaInternal;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Donaldo
 */
public class MDI extends javax.swing.JFrame {

    GraphicsDevice grafica = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    JDesktopPane Escritorio = new ImagenFondo();
    boolean pantallacompleta = false;
    Hora h;
    int IDCajero;
    public boolean Abierto = false;

    public MDI(String Usuario, boolean Administrador, int IDCajero) {
        initComponents();
        this.add(Escritorio);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.Usuario.setText(Usuario + ",@" + (Administrador ? "Administrador" : "Cajero"));
        h = new Hora();
        h.start();
        this.add(BarraEstado);
        this.IDCajero = IDCajero;
        if (!Administrador) {
            Cajero();
        }
    }

    public void Cajero() {
        Inventario.setVisible(false);
        this.Compra.setVisible(false);
        this.Configuraciones.setVisible(false);
        Cliente.setVisible(false);
        this.Categoria.setVisible(false);
        Proveedor.setVisible(false);
        jMenuItem12.setVisible(false);
    }

    public MDI() {
        initComponents();
        this.add(Escritorio);
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
        this.add(BarraEstado);
    }

    public void pasarGarbageCollector() {
        Runtime garbage = Runtime.getRuntime();
        garbage.gc();
    }

    class Hora extends Thread {

        public void run() {
            while (true) {

                Date Hoy = new java.util.Date();
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a     EEEEEE, dd 'de' MMMM 'de' yyyy");
                Fecha.setText(sdf.format(Hoy));
                esperar();
            }
        }

        public void esperar() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MDI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(this.getClass().getResource("/Iconos/IconoInicio.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BarraEstado = new javax.swing.JPanel();
        Usuario = new javax.swing.JLabel();
        Fecha = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Facturacion = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        Inventario = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        Categoria = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        Cliente = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        Compra = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        Proveedor = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        Configuraciones = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        User = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();

        BarraEstado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Usuario.setText("Usuario");

        Fecha.setText("Fecha");

        javax.swing.GroupLayout BarraEstadoLayout = new javax.swing.GroupLayout(BarraEstado);
        BarraEstado.setLayout(BarraEstadoLayout);
        BarraEstadoLayout.setHorizontalGroup(
            BarraEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BarraEstadoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(Usuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 454, Short.MAX_VALUE)
                .addComponent(Fecha)
                .addGap(33, 33, 33))
        );
        BarraEstadoLayout.setVerticalGroup(
            BarraEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BarraEstadoLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(BarraEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Usuario)
                    .addComponent(Fecha))
                .addGap(5, 5, 5))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Sistema de Facturacion e inventario");
        setIconImage(getIconImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Facturacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/CashRegister.png"))); // NOI18N
        Facturacion.setText("Facturacion");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/AgregarF.png"))); // NOI18N
        jMenuItem1.setText("Realizar Factura");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Facturacion.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/AdmF.png"))); // NOI18N
        jMenuItem2.setText("Administrar Facturas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        Facturacion.add(jMenuItem2);

        jMenuBar1.add(Facturacion);

        Inventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/box.png"))); // NOI18N
        Inventario.setText("Inventario");

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Products.png"))); // NOI18N
        jMenuItem9.setText("Inventario");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        Inventario.add(jMenuItem9);

        jMenuBar1.add(Inventario);

        Categoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Tag.png"))); // NOI18N
        Categoria.setText("Categoria");

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Minitag.png"))); // NOI18N
        jMenuItem4.setText("Categoria");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        Categoria.add(jMenuItem4);

        jMenuBar1.add(Categoria);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/1435907113_Manager.png"))); // NOI18N
        jMenu3.setText("Empleado");

        jMenuItem17.setText("Ingresar empleado");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem17);

        jMenuBar1.add(jMenu3);

        Cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Client.png"))); // NOI18N
        Cliente.setText("Cliente");

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/CustomerN.png"))); // NOI18N
        jMenuItem10.setText("Cliente");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        Cliente.add(jMenuItem10);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Company.png"))); // NOI18N
        jMenu1.setText("Cliente juridico");

        jMenuItem14.setText("Cliente juridico");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem14);

        jMenuItem15.setText("Representantes");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem15);

        Cliente.add(jMenu1);

        jMenuBar1.add(Cliente);

        Compra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Shop.png"))); // NOI18N
        Compra.setText("Compra");

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Addshop.png"))); // NOI18N
        jMenuItem5.setText("Realizar Compra");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        Compra.add(jMenuItem5);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/AdmShop.png"))); // NOI18N
        jMenuItem6.setText("Administrar Compra");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        Compra.add(jMenuItem6);

        jMenuBar1.add(Compra);

        Proveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/1436130885_transport-delivery.png"))); // NOI18N
        Proveedor.setText("Proveedores");

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/truck.png"))); // NOI18N
        jMenuItem3.setText("Proveedores");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        Proveedor.add(jMenuItem3);

        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Representant.png"))); // NOI18N
        jMenuItem13.setText("Ejecutivos de venta");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        Proveedor.add(jMenuItem13);

        jMenuBar1.add(Proveedor);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/CambioDinero.png"))); // NOI18N
        jMenu2.setText("Cambio");

        jMenuItem16.setText("Administrador de Cambios");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem16);

        jMenuBar1.add(jMenu2);

        Configuraciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Option.png"))); // NOI18N
        Configuraciones.setText("Configuraciones");

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F11, 0));
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/FullScreen.png"))); // NOI18N
        jMenuItem7.setText("Pantalla completa");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        Configuraciones.add(jMenuItem7);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Preferences.png"))); // NOI18N
        jMenuItem8.setText("Preferencias");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        Configuraciones.add(jMenuItem8);

        jMenuBar1.add(Configuraciones);

        User.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/users.png"))); // NOI18N
        User.setText("Usuario");

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Finish.png"))); // NOI18N
        jMenuItem11.setText("Cerrar sesion");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        User.add(jMenuItem11);

        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/AdmUsers.png"))); // NOI18N
        jMenuItem12.setText("Administrar usuarios");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        User.add(jMenuItem12);

        jMenuBar1.add(Box.createHorizontalGlue());

        jMenuBar1.add(User);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (!this.Abierto) {
            Abierto = true;
            FacturaInternal f = new FacturaInternal(this, 1);
            Centrar(f, Escritorio);
            f.IdEmpleado = 1;
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        AdministrarFactura a = new AdministrarFactura();
        Centrar(a, Escritorio);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        ProveedoresInternal p = new ProveedoresInternal();
        Centrar(p, Escritorio);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        CategoriaInternal c = new CategoriaInternal();
        Centrar(c, Escritorio);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        CompraInternal c = new CompraInternal();
        Centrar(c, Escritorio);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed

    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        if (!pantallacompleta) {
            pantallacompleta = true;
            this.setResizable(false);
            this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
            this.setVisible(true);
            this.toFront();
            this.setAlwaysOnTop(true);
        } else {
            setResizable(true);
            grafica.setFullScreenWindow(null);
            this.setExtendedState(MAXIMIZED_BOTH);
            setVisible(true);
            pantallacompleta = false;
            this.setAlwaysOnTop(false);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed

    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        InventarioInternal i = new InventarioInternal();
        Centrar(i, Escritorio);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        ClienteNaturalInternal cn = new ClienteNaturalInternal();
        Centrar(cn, Escritorio);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this, "Esta seguro que desea cerrar sesion", "Advertencia", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

        if (opcion == 0) {
            this.dispose();
            new Login().setVisible(true);;
        }

    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed

    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        VendedoresInternal v = new VendedoresInternal();
        Centrar(v, Escritorio);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        ClienteJuridicoInternal cj = new ClienteJuridicoInternal();
        Centrar(cj, Escritorio);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        RepresentanteInternal ri = new RepresentanteInternal();
        Centrar(ri, Escritorio);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int opcion = JOptionPane.showConfirmDialog(this, "Esta seguro que desea salir", "Advertencia", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

        if (opcion == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        new Hora().start();
    }//GEN-LAST:event_formWindowOpened

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        Cambio c = new Cambio();
        Centrar(c, Escritorio);// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        EmpleadoINternal1 e = new EmpleadoINternal1();
        Centrar(e, Escritorio);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MDI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarraEstado;
    private javax.swing.JMenu Categoria;
    private javax.swing.JMenu Cliente;
    private javax.swing.JMenu Compra;
    private javax.swing.JMenu Configuraciones;
    private javax.swing.JMenu Facturacion;
    private javax.swing.JLabel Fecha;
    private javax.swing.JMenu Inventario;
    private javax.swing.JMenu Proveedor;
    private javax.swing.JMenu User;
    private javax.swing.JLabel Usuario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables
}
