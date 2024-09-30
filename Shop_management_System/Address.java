public class Address{
    private String city;
    private String country;
    Address(String city, String country){
        this.city = city;
        this.country = country;
    }
    public void setCity(String c){
        this.city = c;
    }
    public void setCountry(String c){
        this.country = c;
    }
    public String getCity(){
        return this.city;
    }
    public String getCountry(){
        return this.country;
    }
    @Override
    public String toString(){
        return String.format("\nDIsplaying the Adress of the Shop:City: %s Country: %s\n",getCity(),getCountry());
    }
}
