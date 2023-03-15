
package cse110miniproject;

public class Account {
    private int accountid;
    private int passcode;
    private double accountbalance;

    Account(int accountid, int passcode) {
       this.accountid=accountid;
       this.passcode=passcode;
       
    }
    public int getaccountid(){
        return accountid;
    }
    public int getpasscode(){
        return passcode;
    }
   
    public double addbalance(double salary){
           return accountbalance=salary;
    }
}
