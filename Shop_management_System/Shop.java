import java.util.Scanner;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;
public class Shop{
    static List<Shop> shops = new ArrayList<>();
    private String shopName;
    private Person owner;
    private Address shopAddress;
    private String shopTimings;
    private Product[] products = new Product[100];
    private int productcounter = 0;
public void setShopName(String name){
    this.shopName = name;
}
public void setShopTimings(String t){
    this.shopTimings = t;
}
public String getShopName(){
    return this.shopName;
}
public String getShopTimings(){
    return this.shopTimings;
}
public void setPerson(Person p){
    this.owner = p;
}
public void setAddress(Address a){
    this.shopAddress = a;
}
public Person getPerson(){
    return this.owner;
}
public Address getAddress(){
    return this.shopAddress;
}
public int getProductCounter(){
    return this.productcounter;
}
public void displayShops() {
    System.out.println("\nDisplaying all the shops!\n");
    for (int i = 0; i < shops.size(); i++) {
        Shop currentShop = shops.get(i);
        System.out.println("\nShop " + (i + 1) + ": " + currentShop.getShopName() + " having " + currentShop.getProductCounter() + " products!\n");
        // Displaying the person and address
        System.out.println("*********************************");
        System.out.println(currentShop.getPerson().toString());
        System.out.println("*********************************");
        System.out.println(currentShop.getAddress().toString());
        System.out.println("*********************************");
        System.out.println("Timings of the shop: "+currentShop.getShopTimings()+"\n");
        System.out.println("*********************************");
        for (int j = 0; j < currentShop.getProductCounter(); j++) {
            if(currentShop.products[j]!= null){
            System.out.println(currentShop.products[j].toString());
        }
        else{
            System.out.println("The Product at index "+j+"is deleted!");
        }
    }
    }
}
public void addProducts(Scanner sc){
    System.out.println("\nAdding Products");
    while(true){
        System.out.println("""
                            Enter Your choice!
                              (1)Enter products
                              (2)Exit
                        """);
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
            System.out.print("Enter product name: ");
            String pname = sc.nextLine();
            System.out.print("Enter product Price: ");
            double price = sc.nextDouble();
            sc.nextLine();
            System.out.print("Enter product Quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();
            products[productcounter++] = new Product(pname, price, quantity);
            System.out.println("Products added!");
            Product.setProductCounter(0);
            break;
            case 2:
return;            default:
            System.out.println("Enter valid choice!");
            break;
                        }
}
}
public void addShop(Scanner sc){
    System.out.print("Enter Shop Name:");
    String shop_name = sc.nextLine();
    setShopName(shop_name);
    System.out.print("Enter Shop owner:");
    String shop_owner = sc.nextLine();
    System.out.print("Enter Owner's email: ");
    String owner_email = sc.nextLine();
    setPerson(new Person(shop_owner, owner_email));
    System.err.println("\nAdding Shop Address");
    System.out.print("Enter city: ");
    String shop_city = sc.nextLine();
    System.out.print("Enter country: ");
    String shop_country = sc.nextLine();
    setAddress(new Address(shop_city, shop_country));
    System.out.print("Enter timings of the shop:");
    String shop_timings = sc.nextLine();
    setShopTimings(shop_timings);
}
public Shop shopMatching(Scanner sc){
    System.out.print("Enter name of the shop: ");
    String update_name = sc.nextLine();
    for (int i = 0; i < shops.size(); i++) {
        Shop currentShop = shops.get(i);
        if(currentShop.getShopName().equals(update_name)){
            System.out.println("Shop found!");
            return currentShop;
        }
    }
    return null;
}
public int productIdMatching(Shop currentShop, Scanner sc){
    System.out.println("Enter product Id: ");
    String update_Id=sc.nextLine();
        for(int j = 0; j<currentShop.products.length; j++){
            if(currentShop.products[j].getProductId().equals(update_Id)){
                System.out.println("ID matched!");
                return j;
            }
        }
        return -1;

    }
public void updateShop(Scanner sc){
    Shop currentShop = shopMatching(sc);
            if(currentShop != null){
            int j = productIdMatching(currentShop, sc);
            if(j != -1){
                    System.out.println("""
                            Enter your choice:
                            (1) to update price
                            (2) to update Quantity
                            """);
                            int choice = sc.nextInt();
                            sc.nextLine();
                            switch (choice) {
                                case 1:{
                                    System.out.print("Enter updated Price(old price is: "+currentShop.products[j].getProductPrice()+": ");
                                    double updated_price = sc.nextDouble();
                                    sc.nextLine();
                                    currentShop.products[j].setProductPrice(updated_price);
                                    System.out.println("Price is updated.New Price is: "+currentShop.products[j].getProductPrice());
                                    break;}
                                case 2:
                                {
                                    System.out.print("Enter updated Quantity(old quantity is: "+currentShop.products[j].getProductQuantity()+": ");
                                    int updated_q = sc.nextInt();
                                    sc.nextLine();
                                    currentShop.products[j].setProductQuantity(updated_q);
                                    System.out.println("Quantity is updated!\nNew Quantity is: "+currentShop.products[j].getProductQuantity());
                                    break;
                                }
                                default:{
                                    System.out.println("Enter valid choice!!");                        
                                    break;}
                                }  
                            }
                        
                else{
                    System.out.println("ID don't match!");
                }
            }
            else{
                System.out.println("Shop not found!");
            }    
            }


public void deleteShop(Scanner sc){
                Shop current = shopMatching(sc);
                System.out.println("""
                                    Enter your choice:
                                    (1) Delete Shop
                                    (2) Delete Product
                                    """);
                                    int choice = sc.nextInt();
                                    sc.nextLine();
                                    switch (choice) {
                                        case 1:
                                            {int x = shops.indexOf(current);
                                            shops.remove(x);
                                            System.out.println("Shop deleted successfully!");
                                            displayShops();
                                            break;}
                                        case 2:{
                                        int id_ = productIdMatching(current, sc);
                                            if(id_ !=-1){
                                                System.out.println("Id matched!");
                                                current.products[id_] = null;
                                                System.out.println("Product of Id deleted");
                                                displayShops();
                                                break;
                                            }
                                            else{
                                                System.out.println("Id don't match!");
                                                break;
                                            }
                                        }
                                        default:
                                            break;                       
                                        }
}

}

