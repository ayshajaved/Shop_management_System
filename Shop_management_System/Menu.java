import java.util.Scanner;
public class Menu{
    public static void main(String[] args) {
        System.out.println("**************************");
        System.out.println("Welcome to the Shops Menu");
        System.out.println("**************************");
        Scanner sc = new Scanner(System.in);
        try{
            while(true){
                System.out.println("""
                        Enter (1) to Add Shop!
                        Enter (2) to Display Shops!
                        Enter (3) to Update Shop!
                        Enter (4) to Delete Shop/Products!
                        Enter (0) to Exit!
                        \n""");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();
                Shop shop = new Shop();
                switch (choice) 
                {
                    case 1:
                    {   shop.addShop(sc);
                        shop.addProducts(sc);
                        Shop.shops.add(shop);
                        break;
                    }
                    case 2:
                    {   shop.displayShops();
                        break;}
                    case 3:
                        {shop.updateShop(sc);
                        break;}
                    case 4:
                        {
                            shop.deleteShop(sc);
                            break;
                        }
                    case 0:
                        {System.exit(0);
                        System.out.println("Exiting from the Shop management System!");
                        }
                    default:
                        break;
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            sc.close();
        }
    }
}
