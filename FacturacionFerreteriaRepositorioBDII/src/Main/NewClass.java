/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Dao.Dao;
import Dao.VentaDao;
import Hibernate.Conexion;
import Hibernate.HibernateUtil;
import Modelos.Factura;
import java.math.BigDecimal;

/**
 *
 * @author ingdonaldo
 */
public class NewClass {
    public static void main(String[] args) throws Throwable {
        Conexion.setUser("root");
        Conexion.setPass("12345");
        HibernateUtil.Configurar();
//        new Dao().Prueba();
//        try{
//        Integer.parseInt("1");
//        BigDecimal m;
//        m = BigDecimal.valueOf(1.0);
//        }catch(NumberFormatException nf){
//            System.out.println("hubo un error");
//        }

        for (Factura f : new VentaDao().getFacturas("2015-07-01","2015-07-08")) {
            System.out.println("id "+f.getNoFactura());
        }
    }
}
