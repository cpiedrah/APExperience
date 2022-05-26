package experience.ap.employee;

public class Employee {
    private final String name;
    private final String phoneNumber;


    public Employee(){
        name = "";
        phoneNumber="";
    }

    public Employee(String n, String pN){
        name = n;
        phoneNumber = pN;
    }

    public String getName(){
        return name;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

}
