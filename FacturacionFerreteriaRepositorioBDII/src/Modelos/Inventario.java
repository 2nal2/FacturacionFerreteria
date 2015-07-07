package Modelos;

/**
 *
 * @author ingdonaldo
 */
public class Inventario {
    private int IdProducto;
    private String CodigoBarra;
    private String Categoria;
    private String Nombre;
    private float PrecioVenta;
    private float PrecioInventario;
    private String TipoVenta;
    private float CantidadMinima;
    private float CantidadInventario;
    private String Descripcion;
    private boolean Iva;
    private boolean Estado;

    public Inventario(){
    
    }
    
    public Inventario(int IdProducto, String CodigoBarra, String Categoria, 
            String Nombre, float PrecioVenta, float PrecioInventario, 
            String TipoVenta, float CantidadMinima, float CantidadInventario, 
            String Descripcion, boolean Iva, boolean Estado) {
        this.IdProducto = IdProducto;
        this.CodigoBarra = CodigoBarra;
        this.Categoria = Categoria;
        this.Nombre = Nombre;
        this.PrecioVenta = PrecioVenta;
        this.PrecioInventario = PrecioInventario;
        this.TipoVenta = TipoVenta;
        this.CantidadMinima = CantidadMinima;
        this.CantidadInventario = CantidadInventario;
        this.Descripcion = Descripcion;
        this.Iva = Iva;
        this.Estado = Estado;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getCodigoBarra() {
        return CodigoBarra;
    }

    public void setCodigoBarra(String CodigoBarra) {
        this.CodigoBarra = CodigoBarra;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public float getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(float PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }

    public float getPrecioInventario() {
        return PrecioInventario;
    }

    public void setPrecioInventario(float PrecioInventario) {
        this.PrecioInventario = PrecioInventario;
    }

    public String getTipoVenta() {
        return TipoVenta;
    }

    public void setTipoVenta(String TipoVenta) {
        this.TipoVenta = TipoVenta;
    }

    public float getCantidadMinima() {
        return CantidadMinima;
    }

    public void setCantidadMinima(float CantidadMinima) {
        this.CantidadMinima = CantidadMinima;
    }

    public float getCantidadInventario() {
        return CantidadInventario;
    }

    public void setCantidadInventario(float CantidadInventario) {
        this.CantidadInventario = CantidadInventario;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public boolean isIva() {
        return Iva;
    }

    public void setIva(boolean Iva) {
        this.Iva = Iva;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }
    
    
    
    
    
}
