package SistemaDeGestionInventario;

public class Producto {
    private String Id;
    private String nombre;
    private int cantidad;
    private double precio;


    public Producto(String Id,String nombre, int cantidad, double precio){
        if(Id == null || Id.trim().isEmpty()){
            throw new IllegalArgumentException("Debe de contener un ID del producto valido.");
        }
        this.Id = Id;
        this.setNombre(nombre);
        this.setCantidad(cantidad);
        this.setPrecio(precio);
    }

    public String getId(){
        return Id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("Debe de contener un nombre el producto.");
        }else {
            this.nombre = nombre;
        }
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if(cantidad <= 0){
            throw new IllegalArgumentException("Debe de tener una cantidad valida mayor a 0 ");
        }else{
            this.cantidad = cantidad;
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if(precio <= 0){
            throw new IllegalArgumentException("Debe de tener un precio mayor a 0 ");
        }else{
            this.precio = precio;
        }
    }
}
