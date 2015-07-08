/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Dao.Dao;
import Dao.EmpleadoDao;
import Dao.VentaDao;
import Hibernate.Conexion;
import Hibernate.HibernateUtil;
import Modelos.Factura;
import java.math.BigDecimal;
import javax.swing.JOptionPane;

/**
 *
 * @author ingdonaldo
 */
public class NewClass {
    public static void main(String[] args) throws Throwable {
        Conexion.setUser("root");
        Conexion.setPass("12345");
        HibernateUtil.Configurar();
////        new Dao().Prueba();
////        try{
////        Integer.parseInt("1");
////        BigDecimal m;
////        m = BigDecimal.valueOf(1.0);
////        }catch(NumberFormatException nf){
////            System.out.println("hubo un error");
////        }
//
//        for (Factura f : new VentaDao().getFacturas("2015-07-01","2015-07-08")) {
//            System.out.println("id "+f.getNoFactura());
//        }
        
//        System.out.println("La pass es segura : "+isGoodPassword("Nintendop2"));
        
        new EmpleadoDao().CrearUsuario("Reymundo", "12345");
    }
    
    
    public static boolean isGoodPassword(String pas1) {

        if (pas1.matches("[A-Za-z][0-9]{10}")) {
            char clave;
            byte contLetra = 0, conNumero = 0;
            String pas2;
            for (int  i = 0; i <= pas1.length(); i++) {
                clave = pas1.charAt(i);
                pas2 = String.valueOf(clave);
                if (pas2.matches("[a-zA-Z]")) {
                    contLetra++;
                    System.out.println(contLetra);
                } else if (pas2.matches("[0-9]")) {
                    conNumero++;
                    System.out.println(conNumero);
                }
            }
            if (contLetra == conNumero) {
                //JOptionPane.showInternalMessageDialog(this, "Tu contraseña tiene un nivel alto de complejidiad");
                return true;
            } else if (conNumero == 0) {
               // JOptionPane.showInternalMessageDialog(this, "Para tener una contraseña mas confiable por favor introduce un numero como mínimo.");
                return false;
            } else if (conNumero == 2 && contLetra <= 3) {
                //JOptionPane.showInternalMessageDialog(this, "la contraseña necesita mas de 7 digitos entre numeros y letras");
                return false;
            }
        } else {
            //JOptionPane.showInternalMessageDialog(this, "La contraseña no puede tener caracteres especiales como %-&-$.");
            return false;
        }
        
        return true;
    }
}
