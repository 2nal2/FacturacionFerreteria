package Dao;

import Hibernate.HibernateUtil;
import POJO.Empleados;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author martin
 */
public class EmpleadoDao {

    Session session = null;
    Transaction transaction;

    private void AbrirSession() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    public long Guardar(Empleados empleado, String pass) {
        int id;
        try {

            boolean usuario = this.CrearUsuario(empleado.getNombreUsuario(), pass);
            if (usuario) {
                System.out.println("pass :" + pass);
                if (empleado.getRolUsuario().equalsIgnoreCase("cajero")) {
                    if (!this.AsignarPermisosCajero(empleado.getNombreUsuario())) {
                        this.EliminarUsuario(empleado.getNombreUsuario());
                    }
                }
                if (empleado.getRolUsuario().equalsIgnoreCase("encargado de venta")) {

                }
                if (empleado.getRolUsuario().equalsIgnoreCase("encargado de bodega")) {

                }
                if (empleado.getRolUsuario().equalsIgnoreCase("administrador")) {
                    if (!this.AsignarPermisosAdministrador(empleado.getNombreUsuario())) {
                        this.EliminarUsuario(empleado.getNombreUsuario());
                    }
                }
                AbrirSession();
                id = (int) session.save(empleado);
                transaction.commit();
            } else {
                return -1;
            }

            if (id == -1) {
                this.EliminarUsuario(empleado.getNombreUsuario());
            }
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
            System.out.println("Causa : " + e.getCause());
            Excepcion((HibernateException) e);
            return -1;
        } finally {
            session.close();
        }
        return id;
    }

    public List<Empleados> getAll() {
        List lista = null;
        try {
            AbrirSession();
            Query q = session.createQuery("from Empleados");
            lista = q.list();
            session.close();
        } catch (Exception e) {
            session.close();
        }
        return (List<Empleados>) lista;
    }

    public Empleados getById(int id) {
        try {
            AbrirSession();
            Empleados pr = (Empleados) session.get(Empleados.class, id);
            return pr;
        } catch (Exception e) {
            Excepcion((HibernateException) e);
            return null;
        } finally {
            session.close();
        }
    }

    public boolean EliminarUsuario(String nombreUsuario) {
        try {
            AbrirSession();
            Query q = session.createSQLQuery("drop user " + nombreUsuario + " ;");
            q.executeUpdate();
            transaction.commit();

        } catch (Exception e) {
            Excepcion((HibernateException) e);
            return false;
        } finally {
            session.close();
        }

        return true;
    }

    public boolean CrearUsuario(String nombreUsuario, String password) {
        try {
            AbrirSession();
            String query = "create User '" + nombreUsuario + "'@'localhost' identified by '" + password + "';";
            System.out.println("" + query);
            Query q = session.createSQLQuery(query);
            q.executeUpdate();
            transaction.commit();

        } catch (Exception e) {
            Excepcion((HibernateException) e);
            return false;
        } finally {
            session.close();
        }

        return true;
    }

    public boolean ExisteUsuario(String nombreUsuario) {
        try {
            AbrirSession();
            Query q = session.createQuery("from Empleados where nombreUsuario =:parametro");
            q.setString("parametro", nombreUsuario);
            if (q.list().size() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            Excepcion((HibernateException) e);
            return true;
        } finally {
            session.close();
        }
    }

    public boolean AsignarPermisosCajero(String usuario) {

        try {
            AbrirSession();
            
            
            String query = "grant select,insert,update on FacturacionFerreteria.Cliente to '"+usuario+"'@'localhost';";
            String query2 ="grant select,insert,update on FacturacionFerreteria.ClienteJuridico to '"+usuario+"'@'localhost';";
            String query3 ="grant select,insert,update on FacturacionFerreteria.RepresentanteClienteJuridico to '"+usuario+"'@'localhost';";
            String query4 ="grant insert,select on FacturacionFerreteria.VentaClienteNatural to '"+usuario+"'@'localhost';";
            String query5 ="grant insert,select on FacturacionFerreteria.VentaClienteJuridico to '"+usuario+"'@'localhost';";
            String query6 ="grant insert,select on FacturacionFerreteria.VentaCredito to '"+usuario+"'@'localhost';";
            String query7 ="grant select on FacturacionFerreteria.Producto to '"+usuario+"'@'localhost';";
            String query8 ="grant select,insert on FacturacionFerreteria.Venta to '"+usuario+"'@'localhost';";
            String query9 = "grant select,insert on FacturacionFerreteria.DetalleFactura to '"+usuario+"'@'localhost';";
            String query10 ="grant select,insert on FacturacionFerreteria.DevolucionVenta to '"+usuario+"'@'localhost';";
            String query11 ="grant insert on FacturacionFerreteria.PagoCredito to '"+usuario+"'@'localhost';";
            String query12 ="grant insert on FacturacionFerreteria.Pagos to '"+usuario+"'@'localhost';";
            String query13 ="grant select on FacturacionFerreteria.Categorias to '"+usuario+"'@'localhost';";
            String query14 ="grant select on FacturacionFerreteria.CodigoBarra to '"+usuario+"'@'localhost';";
            
            Query q = session.createSQLQuery(query);
            q.executeUpdate();
            
            q = session.createSQLQuery(query2);
            q.executeUpdate();
            
            q = session.createSQLQuery(query3);
            q.executeUpdate();
            
            q = session.createSQLQuery(query4);
            q.executeUpdate();
            
            q = session.createSQLQuery(query5);
            q.executeUpdate();
            
            q = session.createSQLQuery(query6);
            q.executeUpdate();
            
            q = session.createSQLQuery(query7);
            q.executeUpdate();
            
            q = session.createSQLQuery(query8);
            q.executeUpdate();
            
            q = session.createSQLQuery(query9);
            q.executeUpdate();
            
            q = session.createSQLQuery(query10);
            q.executeUpdate();
            
            q = session.createSQLQuery(query11);
            q.executeUpdate();
            
            q = session.createSQLQuery(query12);
            q.executeUpdate();
            
            q = session.createSQLQuery(query13);
            q.executeUpdate();
            
            q = session.createSQLQuery(query14);
            q.executeUpdate();
            transaction.commit();

        } catch (Exception e) {
            Excepcion((HibernateException) e);
            return false;
        } finally {
            session.close();
        }

        return true;

    }

    public boolean AsignarPermisosAdministrador(String usuario) {

        try {
            AbrirSession();
            String query = "GRANT ALL ON FacturacionFerreteria.* TO '" + usuario + "'@'localhost';";
            Query q = session.createSQLQuery(query);
            q.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            Excepcion((HibernateException) e);
            return false;
        } finally {
            session.close();
        }

        return true;

    }

    private void Excepcion(HibernateException he) throws HibernateException {
        transaction.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }
}
