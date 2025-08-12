package SistemaDeGestionInventario;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Inventario miInventario = new Inventario();
        int opcion;
        try {
            do{
                System.out.println("\n================= MENU ==============");
                System.out.println("1. Agregar Productos\n2. Consultar productos\n3. Actualizar productos\n4. Eliminar productos\n5. Salir");
                System.out.println("Introduce un opción: ");
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion){
                    case 1:
                        System.out.println("Ingrese el Id: ");
                        String id = sc.nextLine();
                        System.out.println("Ingrese el nombre: ");
                        String nombre = sc.nextLine();
                        System.out.println("Ingrese la cantidad: ");
                        int cantidad = sc.nextInt();
                        System.out.println("Ingrese el precio: ");
                        double precio = sc.nextDouble();
                        Producto miProducto = new Producto(id,nombre,cantidad,precio);
                        miInventario.agregarProductos(miProducto);
                        break;

                    case 2:
                        miInventario.consultarInventario();
                        break;

                    case 3:
                        System.out.println("Introduce el Id del producto que quieres actualizar: ");
                        id = sc.nextLine();
                        miInventario.actualizarProducto(id);
                        break;

                    case 4:
                        System.out.println("Introduce el Id del producto que quieres eliminar: ");
                        id = sc.nextLine();
                        miInventario.eliminarProducto(id);
                        break;

                    case 5:
                        System.out.println("Ha terminado sesión.");
                        break;

                    default:
                        System.out.println("Esta opción no existe, intente de nuevo.");
                        break;

                }

            }while (opcion != 5);

        }catch (IllegalArgumentException e){
        System.out.println(e.getMessage());
        }
    }
}
