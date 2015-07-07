package Camara;

import Empleados.EmpleadoINternal1;
import MetodoComunes.procesamientoImagenes;
import Producto.ActualizarProductoInternal;
import Producto.InventarioInternal;
import com.googlecode.javacv.FrameGrabber;
import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.VideoInputFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core;
import static com.googlecode.javacv.cpp.opencv_core.cvFlip;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Donaldo Vargas
 */
public class Camara extends javax.swing.JInternalFrame {

    camara camara;
    public int NumeroCamara = 0;
    public opencv_core.IplImage img;
    public FrameGrabber grabber;
    boolean Flag = true;
    BufferedImage imageV;
    ImageIcon icon;
    EmpleadoINternal1 empleado;
    /**
     * Creates new form camara
     *
     * @param foto
     * @param imageV
     */
    ActualizarProductoInternal a;
    InventarioInternal inventario;
    public Camara(ActualizarProductoInternal a) {
        initComponents();
        this.CargarCamara();
        this.a = a;

    }
    
    public Camara(EmpleadoINternal1 empleado){
        initComponents();
        this.CargarCamara();
        this.empleado =empleado;
    }
    
    public Camara(InventarioInternal inventario){
        initComponents();
        this.CargarCamara();
        this.inventario = inventario;
    }

    public static BufferedImage resize(BufferedImage bufferedImage, int newW, int newH) {
        try {
            int w = bufferedImage.getWidth();
            int h = bufferedImage.getHeight();
            BufferedImage bufim = new BufferedImage(newW, newH, bufferedImage.getType());
            Graphics2D g = bufim.createGraphics();
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.drawImage(bufferedImage, 0, 0, newW, newH, 0, 0, w, h, null);
            g.dispose();
            return bufim;
        } catch (NullPointerException n) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelCamara = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        lblPic = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Camara");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/camara.png"))); // NOI18N
        jButton2.setText("Tomar foto");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Iniciar captura");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout PanelCamaraLayout = new javax.swing.GroupLayout(PanelCamara);
        PanelCamara.setLayout(PanelCamaraLayout);
        PanelCamaraLayout.setHorizontalGroup(
            PanelCamaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addGroup(PanelCamaraLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelCamaraLayout.setVerticalGroup(
            PanelCamaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCamaraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCamaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jButton2)
                .addContainerGap())
        );

        lblPic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPic, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addComponent(PanelCamara, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPic, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelCamara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void GuardarMetodoGrabber() {
        try {

            Icon icono = lblPic.getIcon();
            procesamientoImagenes p = new procesamientoImagenes();

            if (this.a != null) {
                icono = p.imageToIcon(p.iconToBufferedImage(icono).getScaledInstance(a.lblFoto1.getWidth(), a.lblFoto1.getHeight(), 0));

                a.image = img.getBufferedImage();
                a.lblFoto1.setIcon(icono);
                a.lblFoto1.setText(null);
            }
            
            
            if (this.empleado != null) {
                icono = p.imageToIcon(p.iconToBufferedImage(icono).getScaledInstance(empleado.lblFoto.getWidth(), empleado.lblFoto.getHeight(), 0));

                empleado.imagempleado = img.getBufferedImage();
                empleado.lblFoto.setIcon(icono);
                empleado.lblFoto.setText(null);
            }
            
             if (this.inventario != null) {
                icono = p.imageToIcon(p.iconToBufferedImage(icono).getScaledInstance(inventario.lblFoto.getWidth(), inventario.lblFoto.getHeight(), 0));

                inventario.image = img.getBufferedImage();
                inventario.lblFoto.setIcon(icono);
                inventario.lblFoto.setText(null);
            }
            
            
            this.CerrarCamara();
            this.dispose();

        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            System.out.println("+ " + e.getCause());
            JOptionPane.showMessageDialog(null, "Error al guardar la foto", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void CerrarCamara() {
        try {
            Flag = false;
            grabber.release();
        } catch (Exception e) {
        }

    }

    public void CargarCamara() {
        jComboBox1.removeAllItems();
        String[] Devices = null;
        try {
            Devices = VideoInputFrameGrabber.getDeviceDescriptions();
        } catch (FrameGrabber.Exception ex) {
            JOptionPane.showMessageDialog(null, "No Se Han Encontrado Cámaras Conectadas", "Cámaras No Encontradas", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (String Dev : Devices) {
            jComboBox1.addItem(Dev);
        }

    }

    public void MetodoGrabber() {
        try {
            grabber = new OpenCVFrameGrabber(NumeroCamara);
            grabber.start();
            while (Flag) {
                img = grabber.grab();
                if (img != null) {
                    cvFlip(img, img, 1);

                }

                icon = new ImageIcon(img.getBufferedImage());
                ImageIcon ic = new ImageIcon(resize(img.getBufferedImage(), 500, 400));
                lblPic.setIcon(ic);
            }//Fin while
        } catch (Exception ex) {
            System.out.println("");
        }

    }

    class camara extends Thread {

        public void run() {
            MetodoGrabber();
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        GuardarMetodoGrabber();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        if (camara != null) {
            CerrarCamara();
            camara.stop();
        }

        Flag = true;

        NumeroCamara = jComboBox1.getSelectedIndex();
        camara = new camara();
        camara.start();
        lblPic.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        if (camara != null) {
            CerrarCamara();
            camara.stop();
        }
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelCamara;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    public javax.swing.JLabel lblPic;
    // End of variables declaration//GEN-END:variables
}
