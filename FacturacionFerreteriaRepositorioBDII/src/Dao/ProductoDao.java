package Dao;

import Hibernate.HibernateUtil;
import Modelos.Inventario;
import POJO.Categorias;
import POJO.Producto;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ing. Donaldo
 */
public class ProductoDao {

    Session session = null;
    Transaction transaction;

    private void AbrirSession() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    public List<Producto> getAll() {
        List lista = null;
        try {
            AbrirSession();
            Query q = session.createQuery("from Producto");
            lista = q.list();
            session.close();
        } catch (Exception e) {
            session.close();
        }
        return (List<Producto>) lista;
    }

    public Producto getById(int id) {
        try {
            AbrirSession();
            Producto c = (Producto) session.get(Producto.class, id);
            return c;
        } catch (Exception e) {
            Excepcion((HibernateException) e);
            return null;
        } finally {
            session.close();
        }
    }

    public List<Inventario> getInventario() {

        List<Inventario> lista = null;
        try {
            AbrirSession();
            Query q = session.createQuery("select new Modelos.Inventario(p.idproducto, CodigoBarra.idCodigoBarra, c.nombre,\n"
                    + "                             p.nombre,p.precioVenta, p.precioInventario, p.tipoVenta, p.cantidadMinima,\n"
                    + "                               p.cantidadInventario,p.descripcion, p.iva,p.estado) \n"
                    + "    from Categorias as c\n"
                    + "    inner join c.productos as p\n"
                    + "    inner join p.codigoBarras as CodigoBarra");
            lista = q.list();
            List list2 = session.createQuery("select new Modelos.Inventario(p.idproducto, '', c.nombre,\n"
                    + "                             p.nombre,p.precioVenta, p.precioInventario, p.tipoVenta, p.cantidadMinima,\n"
                    + "                               p.cantidadInventario,p.descripcion, p.iva,p.estado) \n"
                    + "    from Categorias as c\n"
                    + "    inner join c.productos as p").list();
            for (Inventario i : (List<Inventario>)list2 ) {
                if(!Repetido(lista,i)){
                    lista.add(i);
                }
                
            }
            session.close();
        } catch (Exception e) {
            session.close();
        }
        return (List<Inventario>) lista;

    }
    
    public boolean Repetido(List<Inventario> l,Inventario i){
        for(Inventario in: l){
            if(in.getIdProducto() == i.getIdProducto()){
                return true;
            }
        }
        
        return false;
    }
    private void Excepcion(HibernateException he) throws HibernateException {
        transaction.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }
}
