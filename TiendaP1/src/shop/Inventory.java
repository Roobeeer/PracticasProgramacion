package shop;

public class Inventory {

    private static final int MAX_SIZE = 10;
    private ClothingItem[] items;
    private int itemLength;

    public Inventory(){
        this.items = new ClothingItem[MAX_SIZE];
        this.itemLength = 0;

    }

    public int dameItemCount(){
        return itemLength;
    }

    public void añadirItem(ClothingItem newItem){
        if(itemLength<MAX_SIZE){
            items[itemLength] = newItem;
            itemLength++;
        }else{
            System.out.println("Demasiadas cosas en el inventario, elimina algo");
        }
    }


    public int checkStock(String name, char size){
        int count = 0;
        for(int i= 0;i<itemLength;i++){
            ClothingItem currentItem = items[i];
            if(currentItem != null && currentItem.getName().equals(name) && currentItem.getSize()==size){
                count++;
            }
        }
        return count;
    }

    public void eliminarItem(String name, char size){
        int stockContador = checkStock(name,size);
        if(stockContador>0){
            for(int i = 0;i<itemLength;i++){
                ClothingItem currentItem = items[i];
                if(currentItem !=null && currentItem.getName().equals(name) && currentItem.getSize()==size){
                    for(int j = i;j<itemLength-1;j++){
                        items[j] = items[j+1];
                    }
                    items[itemLength-1] = null;
                    itemLength--;
                    break;
                }
            }
        }else{
            System.out.println("No hay stock");
        }

    }
    public ClothingItem extractItem(String name, char size) {
        int stockCount = checkStock(name, size);
        if (stockCount > 0) {
            for (int i = 0; i < itemLength; i++) {
                ClothingItem currentItem = items[i];
                if (currentItem != null && currentItem.getName().equals(name) && currentItem.getSize() == size) {
                    eliminarItem(name,size);  // Eliminar la prenda del stock
                    return currentItem;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Inventario:\n");
        result.append("Cantidad de prendas en stock: ").append(itemLength).append("\n");
        result.append("Capacidad máxima del inventario: ").append(MAX_SIZE).append("\n");
        result.append("Items en el inventario:\n");

        for (int i = 0; i < itemLength; i++) {
            result.append("\t").append(items[i]).append("\n");
        }

        return result.toString();
    }

    }
