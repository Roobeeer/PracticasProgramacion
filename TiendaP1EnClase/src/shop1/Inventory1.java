package shop1;

public class Inventory1 {
    private static final int MAX_SIZE = 10;

    private ClothingItem1[] items;

    private int itemLength;

    public Inventory1(int MAX_SIZE) {
        this.items = new ClothingItem1[MAX_SIZE];
        this.itemLength = 0;
    }

    public int getItemCount() {
        return itemLength;
    }

    public void addItem(ClothingItem1 newItem) {
        if (itemLength < MAX_SIZE) {
            items[itemLength] = newItem;
            itemLength++;
        } else {
            System.out.println("Prenda no añadida, supera el valor del inventario");
        }
    }

    public int checkStock(String name, char size){
        int count = 0;
        for(int i = 0;i<itemLength;i++) {
            if(items[i].getName().equals(name) && items[i].getSize() == size){
                count++;
            }
        }
        return count;
    }

    public void removeItem(String name, char size){
        for(int i = 0;i<itemLength;i++){
            if(items[i].getName().equals(name) && items[i].getSize() == size){
                for(int j = i;j<itemLength-1;j++){
                    items[j] = items[j+1];
                }
                items[itemLength-1] = null;
                itemLength--;
                System.out.println("Prenda borrada");
                return;
            }
        }
        System.out.println("La prenda no esta en el inventario");
    }


    public ClothingItem1 extractItem(String name, char size){
        for(int i = 0;i<itemLength;i++){
            if(items[i].getName().equals(name) && items[i].getSize() == size){
                ClothingItem1 extractedItem = items[i];
                removeItem(name,size);
                return extractedItem;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        StringBuilder inventoryString = new StringBuilder();
        inventoryString.append("Inventario: => ").append("itemLength=").append(itemLength).append(", MAX_SIZE=").append(MAX_SIZE).append("\n");
        inventoryString.append("Nombre").append("\t\t").append("Precio").append("\t\t   ").append("Talla").append("\n");
        inventoryString.append("-------------------------------------\n");
        for(int i = 0;i<itemLength;i++){
            inventoryString.append(items[i].toString()).append("\n");
        }
        return inventoryString.toString();
    }
    public static void main(String[] args) {
        // Ejemplo de uso
        Inventory1 inventory = new Inventory1(10);

        // Añadir algunas prendas al inventario
        ClothingItem1 item1 = new ClothingItem1("Camisas", 25.99, 'M');
        ClothingItem1 item2 = new ClothingItem1("Pantalón", 39.99, 'L');
        ClothingItem1 item3 = new ClothingItem1("Camisa", 25.99, 'S');

        inventory.addItem(item1);
        inventory.addItem(item2);
        inventory.addItem(item3);

        // Imprimir el inventario en consola
        System.out.println(inventory);
    }
}


