package app1;
import shop1.ClothingItem1;
import shop1.Inventory1;

public class Main1 {
    public static void main(String[] args) {
    Inventory1 inventario1 = new Inventory1(100);
    ClothingItem1 item1 = new ClothingItem1("Bufanda",34,'L');
    ClothingItem1 item2 = new ClothingItem1("Guantes",4,'S');
    ClothingItem1 item3 = new ClothingItem1("Pantalon",24,'M');
    inventario1.addItem(item1);
    inventario1.addItem(item2);
    inventario1.addItem(item3);


    int stockCount = inventario1.checkStock("Bufanda",'L');
        System.out.println(inventario1.toString());

        inventario1.removeItem("Guantes",'S');
        System.out.println(inventario1.toString());

        inventario1.extractItem("Bufanda",'L');
        System.out.println(inventario1.toString());





    }
}
