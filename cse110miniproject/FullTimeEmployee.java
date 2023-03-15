
package cse110miniproject;

import java.io.Serializable;

public class FullTimeEmployee extends Employee implements Runnable,Serializable{
    private double weeklysalary;
    private double medicalAll;
    private double houseRent;
    private double bonus;
    private double taxPercentage;
    private int nonpaidabsence;
    public FullTimeEmployee(){
        
    }
    public FullTimeEmployee(int loginId,String employeeType,int employeeId,String Firstname,String Lastname,String mobileNo,
            String emailNo,String address,int attendance, double weeklysalary,double medicalAll,
            double houseRent,double bonus,double taxPercentage,int nonpaidabsence,
            int accountid,int passcode){
        super(loginId,employeeType,employeeId,Firstname,Lastname,mobileNo,emailNo, address,attendance,accountid,passcode);
        this.weeklysalary=weeklysalary;
        this.medicalAll=medicalAll;
        this.houseRent=houseRent;
        this.bonus=bonus;
        this.taxPercentage=taxPercentage;
        this.nonpaidabsence=nonpaidabsence;
    }
    @Override
    public String toString() {
        return  "~EMPLOYEE INFORMATION~"
                + "\nLogin Id: "+super.getlog().getloginId()+
                "\nEmployee Type: "+super.getlog().getemployeeType()+" Time Employee"
                + "\nEmployee Id: "+super.getemployeeId()
                + "\nFirst Name: "+super.getFirstname()
                + "\nLast Name: "+super.getLastname()
                + "\nMobile No: "+super.getmobileno()
                + "\nEmail No: "+super.getemailNo()
                + "\nAddress: "+super.getaddress()
                + "\nAttendance: "+super.getattendance()
                +"\nNon-paid leave(s): "+this.nonpaidabsence
                + "\nNet Salary: "+this.netsalary()+"$"
                + "\nBonus amount: "+this.bonus+"$"
                + "\nTax amount: "+this.tax()+"$"
                + "\nSalary cut due to non-paid leave(s): "+this.nonpaidabsenceamount()+"$"
                + "\nSalary Amount: "+this.salary()+"$"
                + "\nAccount Id: "+super.getacc().getaccountid()
               + "\nAccount Password : *******"
               + "\nAccount Balance : "+super.getacc().addbalance(this.salary())+"$\n";
    }
    public double netsalary(){
        return ((weeklysalary/7)*(super.getattendance()+(super.getattendance()-this.nonpaidabsence)))+medicalAll+houseRent;
    }
    public double tax(){
        return netsalary()*taxPercentage;
    }
    public double nonpaidabsenceamount(){
        return (netsalary()/30)*nonpaidabsence;
    }
    @Override
    public double salary() {
        return (netsalary()+bonus-(tax()+nonpaidabsenceamount()));
    }
    
    @Override
    public void run() {
        System.out.println("Thread is running!!(Full Time Employee Thread)");
    }
}
