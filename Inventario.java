package SistemaDeGestionInventario;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Inventario {
    private ArrayList <Producto> productos;
    NumberFormat copFormat = DecimalFormat.getCurrencyInstance(new Locale("es","CO"));
    Scanner sc = new Scanner(System.in);

    public Inventario(){
        productos = new ArrayList<>();
    }

    public void agregarProductos(Producto producto){
        boolean esValido = true;
        for (Producto articulo: productos){
            if(articulo.getId().equalsIgnoreCase(producto.getId())){
                esValido = false;
                break;
            }
        }
        if(esValido){
            productos.add(producto);
            System.out.println("El producto se agragado correctamente.");
        }else{
            System.out.println("No se pudo agragar el producto, el ID del producto es igual a otro existe.");
        }

    }
    public void consultarInventario(){
        for (Producto articulo: productos){
            System.out.println("\n================================== PRODUCTO =============================================");
            System.out.println("ID del producto: "+ articulo.getId());
            System.out.println("Nombre del producto: "+ articulo.getNombre());
            System.out.println("Cantidad del producto: "+ articulo.getCantidad());
            System.out.println("Precio del producto: "+ copFormat.format(articulo.getPrecio()));

        }
        System.out.println("=========================================================");
        System.out.println("El valor total: del inventario: "+ calcularValorTotal());
        System.out.println("=========================================================");

    }
    public void actualizarProducto(String Id){
        for (Producto articulo: productos){
            if(articulo.getId().equalsIgnoreCase(Id)){
                System.out.printf("\nEstas seguro que quieres actualizar(Si/No) -> %s: ",articulo.getNombre());
                String respuesta = sc.nextLine();
                if(respuesta.equalsIgnoreCase("Si")){
                    System.out.println("\nQue deseas actualizar");
                    System.out.println("1. El nombre");
                    System.out.println("2. La cantidad");
                    System.out.println("3. El precio");
                    System.out.println("Escriba la opcion: ");
                    int opcion = sc.nextInt();
                    sc.nextLine();
                    switch (opcion){
                        case 1:
                            System.out.println("Introduce el nombre por el cual quieres cambiarlo: ");
                            String nombre = sc.nextLine();
                            articulo.setNombre(nombre);
                            System.out.println("Nombre actualizado.");
                            break;
                        case 2:
                            System.out.println("Introduce la nueva cantidad : ");
                            int cantidad = sc.nextInt();
                            articulo.setCantidad(cantidad);
                            System.out.println("Cantidad actualizada.");
                            break;
                        case 3:
                            System.out.println("Introduce la nuevo precio: ");
                            double precio = sc.nextDouble();
                            articulo.setPrecio(precio);
                            System.out.println("Precio actualizada");
                            break;
                        default:
                            System.out.println("Esta opción no hace parte del catalogo.");
                            break;
                    }
                }else {
                    System.out.println("Se ha cancelado la actualización");
                    return;
                }

            }
        }
    }
    public void eliminarProducto(String Id){
        boolean existe = false;
        for (int i = 0; i < productos.size(); i++){
            if(productos.get(i).getId().equalsIgnoreCase(Id)){
                existe = true;
                 productos.remove(productos.get(i));
                System.out.println("El producto se a eliminado.");
                return;
            }
        }
        if(!existe){
            System.out.println("Este producto no se encontro en el Inventario.");
        }
    }
    public String calcularValorTotal(){
        double total = 0;
        for (Producto articulo: productos){
            total += (articulo.getCantidad() * articulo.getPrecio());
        }
        return copFormat.format(total);
    }
}
