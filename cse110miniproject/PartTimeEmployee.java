
package cse110miniproject;

import java.io.Serializable;

public class PartTimeEmployee extends Employee implements Runnable,Serializable{
    private double wage;
    private int hour;
    /*private Account account;*/
    public PartTimeEmployee(){
        
    }
    public PartTimeEmployee(int loginId,String employeeType,int employeeId,String Firstname,String Lastname,String mobileNo,
            String emailNo,String address,int attendance,double wage,int hour,
            int accountid,int passcode){
        super(loginId,employeeType,employeeId,Firstname,Lastname,mobileNo,emailNo, address,attendance,accountid,passcode);
        this.wage=wage;
        this.hour=hour;
    }
    @Override
    public String toString() {
       return   "~EMPLOYEE INFORMATION~"
                + "\nLogin Id: "+super.getlog().getloginId()
                +"\nEmployee Type: "+super.getlog().getemployeeType()+" Time Employee"
                + "\nEmployee Id: "+super.getemployeeId()
                + "\nFirst Name: "+super.getFirstname()
                + "\nLast Name: "+super.getLastname()
                + "\nMobile No: "+super.getmobileno()
                + "\nEmail No: "+super.getemailNo()
                + "\nAddress: "+super.getaddress()
                + "\nWage per hour: "+this.wage
                + "\nTotal working hour: "+this.hour
                + "\nSalary Amount: "+this.salary()+"$"
                + "\nAccount Id: "+super.getacc().getaccountid()
               + "\nAccount Password : *******"
               + "\nAccount Balance : "+super.getacc().addbalance(this.salary())+"$\n";
    }
    @Override
    public double salary() {
        return wage*hour*super.getattendance();
    }
    @Override
    public void run() {
       System.out.println("Thread is running!!(Part Time Employee Thread)");
    }
}
