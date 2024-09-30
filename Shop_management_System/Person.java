public class Person{
    private String name;
    private String email;
    Person(String name,String email){
        this.name = name;
        this.email = email;
    }
    Person(String name){
        this(name, "Default email");
    }
    Person(){
        this("Default name", "Default email");
    }
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
    @Override
    public String toString(){
        return String.format("The Owner of the company is: %s Contact: %s",getName(),getEmail());
    }
}
