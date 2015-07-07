package Pago;

import Dao.CambioDao;
import POJO.Cambio;
import POJO.Pagos;
import Venta.FacturaInternal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ingdonaldo
 */
public class Pago extends javax.swing.JInternalFrame {

    /**
     * Creates new form Pago
     */
    float TotalPagar;
    FacturaInternal factura;

    public Pago(FacturaInternal factura, float TotalPagar) {
        initComponents();
        this.factura = factura;
        this.TotalPagar = TotalPagar;
        this.Total.setText(String.valueOf(TotalPagar));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Total = new javax.swing.JTextField();
        Cordoba = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblPago = new javax.swing.JLabel();
        lblPago1 = new javax.swing.JLabel();
        Dollar = new javax.swing.JTextField();
        lblPago2 = new javax.swing.JLabel();
        Tarjeta = new javax.swing.JTextField();
        CambioDollar = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Pago de Factura");
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

        Total.setEditable(false);

        Cordoba.setText("0");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos2/Money.png"))); // NOI18N
        jButton1.setText("Pagar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Total a pagar");

        lblPago.setText("Pago Cordobas");

        lblPago1.setText("Pago Dolares");

        Dollar.setText("0");

        lblPago2.setText("Pago tarjeta");

        Tarjeta.setText("0");

        CambioDollar.setText("Cambio del dollar :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(CambioDollar)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblPago1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                .addComponent(lblPago, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                .addComponent(lblPago2, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(36, 36, 36)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Total, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Dollar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Cordoba, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Tarjeta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(CambioDollar)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cordoba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPago))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Dollar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPago1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPago2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        float cordoba, dollar, tarjeta;

        try {
            cordoba = Float.parseFloat(Cordoba.getText());
            dollar = Float.parseFloat(Dollar.getText());
            tarjeta = Float.parseFloat(Tarjeta.getText());

        } catch (NumberFormatException nf) {
            JOptionPane.showInternalMessageDialog(this, "Error en las cantidades ingresadas", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cambio c = new CambioDao().getLastCambio();

        float CordobaEquivalente = dollar * c.getCambioDollar();
        if (CordobaEquivalente + cordoba + tarjeta < TotalPagar) {
            JOptionPane.showInternalMessageDialog(this, "El pago que registra no cubre la deuda", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            float Vuelto = CordobaEquivalente + cordoba + tarjeta - TotalPagar;
            boolean Guardado = factura.GuardarFactura();
            if (Guardado) {
                List<Pagos> lista = new ArrayList<>();
                if (cordoba > 0) {
                    Pagos p = new Pagos();
                    p.setCambio(c);
                    p.setMetodoPago("Efectivo");
                    p.setMoneda("Cordoba");
                    p.setMonto(cordoba);
                    lista.add(p);
                }
                if (dollar > 0) {
                    Pagos p = new Pagos();
                    p.setCambio(c);
                    p.setMetodoPago("Efectivo");
                    p.setMoneda("Dollar");
                    p.setMonto(cordoba);
                    lista.add(p);
                }
                if (cordoba > 0) {
                    Pagos p = new Pagos();
                    p.setCambio(c);
                    p.setMetodoPago("Tarjeta");
                    p.setMoneda("Cordoba");
                    p.setMonto(tarjeta);
                    lista.add(p);
                }
                boolean pagado = factura.GuardarPago(factura.v, lista);
                if (!pagado) {
                    JOptionPane.showInternalMessageDialog(this, "No se pudo realizar la venta", "Error", JOptionPane.ERROR_MESSAGE);
                }
                JOptionPane.showInternalMessageDialog(this, "Pago registrado exitosamente \nvuelto :" + Vuelto, "Informacion", JOptionPane.INFORMATION_MESSAGE);
                factura.Anular();
                this.dispose();
            } else {
                JOptionPane.showInternalMessageDialog(this, "No se pudo realizar la venta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        Cambio c = new CambioDao().getLastCambio();
        if (c == null) {
            JOptionPane.showInternalMessageDialog(this, "No hay registro de cambio para el dollar, porfavor registre uno primero", "Error", JOptionPane.ERROR_MESSAGE);
            this.dispose();
            return;
        }
        this.CambioDollar.setText("Cambio del dollar : " + c.getCambioDollar());
    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CambioDollar;
    private javax.swing.JTextField Cordoba;
    private javax.swing.JTextField Dollar;
    private javax.swing.JTextField Tarjeta;
    private javax.swing.JTextField Total;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblPago;
    private javax.swing.JLabel lblPago1;
    private javax.swing.JLabel lblPago2;
    // End of variables declaration//GEN-END:variables
}
