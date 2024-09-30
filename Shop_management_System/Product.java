public class Product{
    private String productName;
    private double productPrice;
    private int productQuantity;
    private String productId;

    //static variable
    private static int counter=0;
    //instance block
    {
        this.productId = String.format("%03d", ++counter);
    }
    public static void setProductCounter(int c){
        counter = c;
    }
    //constructor chaining
    Product(String name, double price, int quantity){
        this.productName = name;
        this.productPrice = price;
        this.productQuantity = quantity;
    }
    Product(String name, double price){
        this(name, price, 0);
    }
    Product(String name){
        this(name, 0.0);
    }
    Product(){
        this("Default name");
    }
    public void setProductName(String name){
        this.productName = name;
    }
    public void setProductPrice(double p){
        this.productPrice = p;
    }
    public void setProductQuantity(int q){
        this.productQuantity = q;
    }
    public String getProductName(){
        return this.productName;
    }
    public double getProductPrice(){
        return this.productPrice;
    }
    public int getProductQuantity(){
        return this.productQuantity;
    }
    public String getProductId(){
        return this.productId;
    }
    @Override
    public String toString(){
        return String.format("Detail of the product is:ID: %s\nName: %s\tPrice: %f\tQuantity: %d",getProductId(),getProductName(),getProductPrice(),getProductQuantity());
    }
    // @Override
    // public boolean equals(Object o){
    //     if(this == o){
    //         return true;
    //     }
    //     else if(o ==null || getClass() != o.getClass()){
    //         return false;
    //     }
    //     else{
    //         Product temp = (Product)o;
    //         return this.getProductId().equals(temp.getProductId());
    //     }

    // }
}
