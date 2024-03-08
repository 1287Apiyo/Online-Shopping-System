import java.util.Date;

public class Accounts implements Comparable{

//Variables
    static int nextAccNO =10; //class variable
    int accNo;
    String owner;
    City city;
    char gender;
    double balance;
    Date openDate;



    //let us now create the constructor
    public Accounts(){

    }


//constructors
    public Accounts(String owner, City city, char gender) {
        accNo=nextAccNO;
        nextAccNO +=10;
        this.owner = owner;
        this.city = city;
        this.gender = gender;
        balance=0.0;
        openDate=null;  //System.currentDate();


    }


    public Accounts(int accNo, String owner, City city, char gender, double balance) {
        this.accNo = accNo;
        this.owner = owner;
        this.city = city;
        this.gender = gender;
        setBalance(balance);
    }
    //setters
    public void setBalance(double b) {
        balance = b> 0.0 ? b: 0.0;
    }
//toString()
    @Override
    public String toString() {
        return accNo + " "+  owner +" " +city.cityName + " "
              + gender + " " + balance;

    }
//compare to method
    @Override
    public int compareTo(Object o) {
        return this.owner.compareTo(((Accounts)o).owner);
    }
    //adding two methods
    //deposit method
    public void deposit(double amount){
        if (amount>0){
            setBalance(balance+amount);
        }
    }

    //withdraw method
    public double withdraw(double amount){
        if (amount>0){
            if (amount<balance){
                setBalance(balance-amount);
            }
            else {
                amount=balance;
                setBalance(0.0);
            }
            return amount;
        }
        return 0.0;
    }
}
