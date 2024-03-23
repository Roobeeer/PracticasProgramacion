package shop1;

public class ClothingItem1 {
    private String name;
    private double price;
    private char size;

    public ClothingItem1(String name, double price, char size){
        this.name = name;
        this.price = price;
        if(size == 'S' || size == 'M' || size == 'L' ){
            this.size = size;
        }else{
            System.out.println("Tamaño no válido. Se asignará S por defecto");
            this.size = 'S';
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public char getSize() {
        return size;
    }

    public void ponSize(char size){
        if(size == 'S'|| size == 'M' || size == 'L') {
            this.size = size;
        }else{
            System.out.println("Tamaño inválido, no se ha modificado");
        }
    }

    @Override
    public String toString(){
        return name+"\t\t"+price+"\t\t\t"+size;
    }
}

class TestClothingItem1{

    public static void checkClass(Class<?> clazz) {
        if(clazz.getName().equals("shop1.ClothingItem1")){
            System.out.println("¡La clase es correcta!");
        }else{
            System.out.println("La clase no es correcta");
        }
    }
    public static void main(String[] args) {
        ClothingItem1 item1 = new ClothingItem1("Camisa", 25.99, 'M');
        if (item1 != null) {
            checkClass(item1.getClass());
            System.out.println(item1);
        }
    }
    }


