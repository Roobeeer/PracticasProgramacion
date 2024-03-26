package sales1;
import shop1.*;

public class SalesRegister1 {
    private long totalSalesCount;
    private double totalSalesAmount;


    public String processSale(Inventory1 inventory, String name, char size){
       int hayStock = inventory.checkStock(name,size);
       if(hayStock !=0){
           inventory.extractItem(name,size);
           totalSalesCount++;
           totalSalesAmount++;
           return name;

       }else{
           System.out.println("El producto no está en stock");
           System.exit(0);
            return null;
       }
    }

    public long getTotalSalesCount(){
        return totalSalesCount;
    }

    public double getTotalSalesAmount(){
        return totalSalesAmount;
    }

    public long getBalance(){


    }
}
