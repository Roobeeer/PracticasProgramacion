package app;
import sales.SalesRegister;
import shop.ClothingItem;
import shop.Inventory1;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 2. Inicialización del inventario
        Inventory1 inventory1 = new Inventory1(100);

        // 3. COMPRUEBA que los diferentes métodos que hay añadido a la clase Inventory
        // funcionan correctamente ANTES DE CONTINUAR

        // 1. Comprueba que puedes añadir varias prendas al inventario
        inventory1.añadirItem((new ClothingItem("Camisa", 29.99, 'M')));
        inventory1.añadirItem(new ClothingItem("Pantalón", 39.99, 'L'));
        inventory1.añadirItem(new ClothingItem("Jersey", 49.99, 'S'));

        // 2. Comprueba que puedes comprobar el stock de una prenda
        int stockCamisa = inventory1.checkStock("Camisa", 'M');
        System.out.println("Stock de Camisa (M): " + stockCamisa);

        // 3. Comprueba que puedes eliminar una prenda y el inventario se encuentra en un estado consistente
        inventory1.eliminarItem("Jersey", 'S');
        System.out.println("Inventario después de eliminar Jersey (S):\n" + inventory1);

        // 4. Comprueba que, sí imprime el inventario de manera directa por consola,
        // se invoca su método toString de manera implícita y se muestra el inventario en formato tabular
        System.out.println("Inventario actual:\n" + inventory1);

        // 5. Comprueba que extractItem obtiene el artículo y es eliminado del stock
        ClothingItem item = inventory1.extractItem("Pantalón", 'L');
        System.out.println("Artículo extraído: " + item);
        System.out.println("Inventario después de extraer Pantalón (L):\n" + inventory1);

        // 6. Fija un MAX_ITEM y comprueba que no supera el límite del stock
        final int MAX_ITEM = 100;
        if (inventory1.checkStock("Camiseta",'M') <= MAX_ITEM) {
            System.out.println("El inventario no supera el límite máximo de stock.");
        } else {
            System.out.println("El inventario supera el límite máximo de stock.");
        }

        // Verificar con la herramienta de test que todo es correcto
        // Comprueba que la clase Main está en el paquete 'app'
        if (inventory1 != null) {
            ClothingItem.checkClass(inventory1.getClass());
        }
    }
}


class Main2 {
    private static Scanner scanner;

    public static void main(String[] args) {
        // Inicialización del inventario y el Scanner
        Inventory1 inventory1 = new Inventory1();
        scanner = new Scanner(System.in);

        // Bucle principal del menú interactivo
        int opcion;
        do {
            // Mostrar menú y obtener la opción seleccionada por el usuario
            opcion = mostrarMenu();

            // Manejar la opción seleccionada
            switch (opcion) {
                case 1:
                    opcionAgregarItem(inventory1);
                    break;
                case 2:
                    opcionListarInventario(inventory1);
                    break;
                case 3:
                    opcionVenderPrenda(inventory1);
                    break;
                case 4:
                    opcionMostrarVentas();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 5);

        // Cerrar el Scanner al salir del programa
        scanner.close();
    }

    // Método para mostrar el menú y obtener la opción seleccionada por el usuario
    private static int mostrarMenu() {
        System.out.println("----- MENÚ -----");
        System.out.println("1. Agregar un artículo al inventario");
        System.out.println("2. Listar inventario");
        System.out.println("3. Vender prenda");
        System.out.println("4. Mostrar ventas realizadas");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    // Método para la opción 1: Agregar un artículo al inventario
    private static void opcionAgregarItem(Inventory1 inventory1) {
        scanner.nextLine(); // Consumir el salto de línea pendiente
        System.out.println("Ingrese el nombre del artículo:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el precio del artículo:");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea pendiente
        System.out.println("Ingrese la talla del artículo (S, M, L):");
        char talla = scanner.nextLine().charAt(0);

        ClothingItem nuevoItem = new ClothingItem(nombre, precio, talla);
        inventory1.añadirItem(nuevoItem);
        System.out.println("¡Artículo agregado al inventario!");
    }

    // Método para la opción 2: Listar inventario
    private static void opcionListarInventario(Inventory1 inventory1) {
        System.out.println("----- INVENTARIO -----");
        System.out.println(inventory1);
    }

    // Método para la opción 3: Vender prenda
    private static void opcionVenderPrenda(Inventory1 inventory1) {
        scanner.nextLine(); // Consumir el salto de línea pendiente
        System.out.println("Ingrese el nombre del artículo a vender:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la talla del artículo a vender:");
        char talla = scanner.nextLine().charAt(0);

        ClothingItem itemVendido = SalesRegister.processSale(inventory1, nombre, talla);
        if (itemVendido != null) {
            System.out.println("¡Venta realizada! Se vendió: " + itemVendido);
        } else {
            System.out.println("La venta no se pudo realizar.");
        }
    }

    // Método para la opción 4: Mostrar ventas realizadas
    private static void opcionMostrarVentas() {
        System.out.println("----- VENTAS REALIZADAS -----");
        System.out.println("Total de ventas realizadas: " + SalesRegister.getTotalSalesCount());
        System.out.println("Monto total de ventas: " + SalesRegister.getTotalSalesAmount());
    }
}

