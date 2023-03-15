
package cse110miniproject;

abstract public class Employee implements Runnable {
    private int employeeId;
    private String Firstname;
    private String Lastname;
    private String mobileNo;
    private String emailNo;
    private String address;
    private int attendance;
    private Account acc;
    private Login log;
    public int getemployeeId(){
        return employeeId;
    }
    public String getFirstname(){
        return Firstname;
    }
    public String getLastname(){
        return Lastname;
    }
    public String getmobileno(){
        return mobileNo;
    }
    public String getemailNo(){
        return emailNo;
    }
    public String getaddress(){
        return address;
    }
    public int getattendance(){
        return attendance;
    }
    public Account getacc(){
         return acc;
     }
    public Login getlog(){
        return log;
    }
    public Employee(){
        
    }
    public Employee(int loginId,String employeeType,int employeeId,String Firstname,String Lastname,String mobileNo,
            String emailNo,
            String address,int attendance,
    int accountid,int passcode){
        log = new Login(loginId,employeeType);
        this.employeeId=employeeId;
        this.Firstname=Firstname;
        this.Lastname=Lastname;
        this.mobileNo=mobileNo;
        this.emailNo=emailNo;
        this.address=address;
        this.attendance=attendance;
        acc = new Account(accountid,passcode);
    }
    abstract public String toString();
    abstract public double salary();

    @Override
    abstract public void run();
    //To change body of generated methods, choose Tools | Templates.
    }
