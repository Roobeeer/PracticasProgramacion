package sales;

import shop.ClothingItem;
import shop.Inventory1;

public class SalesRegister {
    // Variables de clase
    private static long totalSalesCount = 0;
    private static double totalSalesAmount = 0.0;

    // Método de clase para procesar una venta
    public static ClothingItem processSale(Inventory1 inventory1, String name, char size) {
        // Busca el producto en el inventario
        ClothingItem item = inventory1.extractItem(name, size);
        if (item == null) {
            System.out.println("El producto '" + name + "' en talla '" + size + "' no está disponible en el inventario.");
            return null;
        }

        // Incrementa el número de artículos vendidos
        totalSalesCount++;
        // Incrementa las ventas totales
        totalSalesAmount += item.getPrice();

        return item;
    }

    // Método de clase para obtener el total de ventas realizadas
    public static long getTotalSalesCount() {
        return totalSalesCount;
    }

    // Método de clase para obtener el monto total de ventas realizadas
    public static double getTotalSalesAmount() {
        return totalSalesAmount;
    }

    // Método de clase para obtener el balance (recuento de ventas y monto total de ventas)
    public static String getBalance() {
        return "Recuento de ventas: " + totalSalesCount + "\nTotal de ventas: " + totalSalesAmount;
    }

    // Método de clase para reiniciar el recuento de productos vendidos
    public static void resetTotalSalesCount() {
        totalSalesCount = 0;
    }

    // Método de clase para reiniciar el monto total de ventas
    public static void resetTotalSalesAmount() {
        totalSalesAmount = 0.0;
    }
}
