package shop;

public class ClothingItem {
    private String name;
    private double price;
    private char size;

    public ClothingItem(String name, double price, char size){
        this.name = name;
        this.price = price;
    if(size == 'S' || size == 'M' || size == 'L' ){
        this.size = size;
    }else{
        System.out.println("Tamaño no válido. Se asignará S por defecto");
        this.size = 'S';
    }
    }


    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public char getSize(){
        return size;
    }
    public void setSize(char size){
        if(size == 'S'|| size == 'M' || size == 'L') {
            this.size = size;
        }else{
            System.out.println("Tamaño inválido, no se ha visto modificado");
        }
    }

    @Override
    public String toString(){
        return "ClothingItem = name: "+name+"  ||  price: "+price+"  ||  size: "+size;
    }
}

class TestClothingItem{
    public static void checkClass(Class<?> clazz) {
        if(clazz.getName().equals("shop.ClothingItem")){
            System.out.println("¡La clase es correcta!");
        }else{
            System.out.println("La clase no es correcta");
        }
    }


    public static void main(String[] args) {
        ClothingItem item1 = new ClothingItem("Camisa",25.99,'M');

        if(item1 != null){
            checkClass(item1.getClass());
            System.out.println(item1);
        }

    }
}
