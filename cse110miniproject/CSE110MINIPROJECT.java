
package cse110miniproject;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
class InvalidhourException extends Exception{
    InvalidhourException(String s){
        super(s);
    }
}
class InvalidAttendanceException extends Exception{
    InvalidAttendanceException(String s){
        super(s);
    }
}
public class CSE110MINIPROJECT {
    static int checkhour(int hour) throws InvalidhourException{
        if(hour<12){
            throw new InvalidhourException("Part Time Employee's work hour must be more than 12 hours!");
        }
        else
            return hour;
    }
    static int checkattendance(int attendance) throws InvalidAttendanceException{
        if(attendance<15){
            throw new InvalidAttendanceException("Attendance must be more than 15 days a month!"
                    + "\nThe employee is not applicable for salary anymore.");
        }
        else return attendance;
    }
        public static FullTimeEmployee fe;
        public static PartTimeEmployee pe;
        public static Login log;
        public static Account account;
        public static int countfe=0,countpe=0,x;
        public static ArrayList<FullTimeEmployee> efe= new ArrayList<FullTimeEmployee>();
        public static ArrayList<PartTimeEmployee> epe= new ArrayList<PartTimeEmployee>();
        public static Thread t1,t2;
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner input = new Scanner(System.in);
        FileOutputStream fosf = new FileOutputStream("FullTimeEmployee.temp");
        FileOutputStream fosp = new FileOutputStream("PartTimeEmployee.temp");
        ObjectOutputStream oosf = new ObjectOutputStream(fosf);
        ObjectOutputStream oosp = new ObjectOutputStream(fosp);
        while(true){
            System.out.println("PRESS 1 TO ADD EMPLOYEE INFO"
                    + "\nPRESS 2 TO SEARCH EMPLOYEE INFO"
                    + "\nPRESS 0 TO EXIT");
            int opt = input.nextInt();
            if(opt==1){
                System.out.println("~ENTER LOGIN INFO~");
            System.out.println("Enter Login Id: ");
            int loginid = input.nextInt();
            System.out.println("Enter Employee Type: (Full/Part)");
            String employeetype = input.next();
            if(employeetype.equals("Full")){
                countfe++;
                System.out.println("Enter Employee Id: ");
                int employeeid = input.nextInt();
                System.out.println("Enter first name:");
                String fname = input.next();
                System.out.println("Enter last name:");
                String lname=input.next();
                System.out.println("Enter Mobile No:");
                String mno = input.next();
                System.out.println("Enter Email No: ");
                String eno = input.next();
                System.out.println("Enter Address: ");
                String address = input.next();
                System.out.println("Enter Attendance: ");
                int attendance = input.nextInt();
                try{
                    attendance =checkattendance(attendance);
                }
                catch(Exception e){
                    System.out.println(e);
                    break;
                }
                System.out.println("Enter weekly salary:");
                double weksal = input.nextDouble();
                System.out.println("Enter Medical Allowance: ");
                double medicalAll = input.nextDouble();
                System.out.println("Enter House Rent: ");
                double houseRent = input.nextDouble();
                System.out.println("Enter Bonus Amount :");
                double bonus = input.nextDouble();
                System.out.println("Enter tax percentage: ");
                double taxpercentage = input.nextDouble();
                System.out.println("Enter number of non paid absence days: ");
                int nonpaidabsence = input.nextInt();
                System.out.println("Enter Account Id: ");
                int accountid = input.nextInt();
                System.out.println("Enter Account passcode: ");
                int passcode = input.nextInt();
                fe = new FullTimeEmployee(loginid, employeetype,employeeid, fname, lname, mno,
                        eno, address, attendance, 
                        weksal, medicalAll, houseRent, bonus, taxpercentage, nonpaidabsence,
                accountid,passcode);
                efe.add(fe);
                t1 = new Thread(fe);
                t1.start();
                System.out.println(fe.toString());
            }
            else if(employeetype.equals("Part")){
                countpe++;
               System.out.println("Enter Employee Id: ");
                int employeeid = input.nextInt();
                System.out.println("Enter first name:");
                String fname = input.next();
                System.out.println("Enter last name:");
                String lname=input.next();
                System.out.println("Enter Mobile No:");
                String mno = input.next();
                System.out.println("Enter Email No: ");
                String eno = input.next();
                System.out.println("Enter Address: ");
                String address = input.next();
                System.out.println("Enter Attendance: ");
                int attendance = input.nextInt();
                System.out.println("Enter wage:");
                double wage = input.nextDouble();
                System.out.println("Enter hour:");
                int hour = input.nextInt();
                try{
                    hour =checkhour( hour);
                }
                catch(Exception e){
                    System.out.println(e);
                    break;
                }
                System.out.println("Enter Account Id: ");
                int accountid = input.nextInt();
                System.out.println("Enter Account passcode: (7digit number)");
                int passcode = input.nextInt();
                pe = new PartTimeEmployee(loginid, employeetype,employeeid,fname,lname,mno,eno,address,attendance,
                        wage,hour,accountid,passcode);
                epe.add(pe);
                t2 = new Thread(pe);
                t2.start();
                System.out.println(pe.toString());
            }
            }
            else if(opt==2){
                System.out.println("PRESS 1 TO SEARCH BY LOGIN ID"
                        + "\nPRESS 2 TO SEARCH BY EMPLOYEE ID"
                        + "\nPRESS 3 TO SEARCH BY ACCOUNT ID"
                        + "\nPRESS 0 TO EXIT");
                int o = input.nextInt();
                if(o==1){
                    System.out.println("PRESS 1 FOR FULL TIME EMPLOYEE"
                            + "\nPRESS 2 FOR PART TIME EMPLOYEE");
                    int x = input.nextInt();
                    if(x==1){
                        System.out.println("Enter Login Id: ");
                        int loginid = input.nextInt();
                        searchbyLoginIdF(loginid);
                    }
                    else if(x==2){
                        System.out.println("Enter Login Id: ");
                        int loginid = input.nextInt();
                        searchbyLoginIdP(loginid);
                    }
                }
                else if(o==2){
                    System.out.println("PRESS 1 FOR FULL TIME EMPLOYEE"
                            + "\nPRESS 2 FOR PART TIME EMPLOYEE");
                    int x = input.nextInt();
                    if(x==1){
                        System.out.println("Enter Employee Id: ");
                        int employeeid = input.nextInt();
                        searchbyEmployeeIdF(employeeid);
                    }
                    else if(x==2){
                        System.out.println("Enter Employee Id: ");
                        int employeeid = input.nextInt();
                        searchbyEmployeeIdP(employeeid);
                    }
                }
                else if(o==3){
                    System.out.println("PRESS 1 FOR FULL TIME EMPLOYEE"
                            + "\nPRESS 2 FOR PART TIME EMPLOYEE");
                    int x = input.nextInt();
                    if(x==1){
                        System.out.println("Enter Account Id: ");
                        int accid = input.nextInt();
                        searchbyAccountIdF(accid);
                    }
                    else if(x==2){
                        System.out.println("Enter Account Id: ");
                        int accid = input.nextInt();
                        searchbyAccountIdP(accid);
                    }
                }
                else if(o==0){
                    break;
                }
            }
            else if(opt==0){
                for(int i=0;i<epe.size();i++){
                   oosp.writeUTF(epe.get(i).toString());
                }
                for(int i=0;i<efe.size();i++){
                    oosf.writeUTF(efe.get(i).toString());
                }
                oosf.close();
                oosp.close();
                break;
            }
        }
    }
    //to search by loginid
    public static void searchbyLoginIdF(int loginid){
        for(int i=0;i<efe.size();i++){
            if(efe.get(i).getlog().getloginId()==loginid){
                System.out.println(efe.get(i).toString());
            }
            else
                System.out.println("LOGIN ID NOT FOUND");
        }
    }
    public static void searchbyLoginIdP(int loginid){
        for(int i=0;i<epe.size();i++){
            if(epe.get(i).getlog().getloginId()==loginid){
                System.out.println(epe.get(i).toString());
            }
            else
                System.out.println("LOGIN ID NOT FOUND");
        }
    }
    //to search by employeeid
    public static void searchbyEmployeeIdF(int employeeid){
        for(int i=0;i<efe.size();i++){
            if(efe.get(i).getemployeeId()==employeeid){
                System.out.println(efe.get(i).toString());
            }
            else
                System.out.println("EMPLOYEE ID NOT FOUND");
        }
    }
    public static void searchbyEmployeeIdP(int employeeid){
        for(int i=0;i<epe.size();i++){
            if(epe.get(i).getemployeeId()==employeeid){
                System.out.println(epe.get(i).toString());
            }
            else
                System.out.println("EMPLOYEE ID NOT FOUND");
        }
    }
    //to search by accid
    public static void searchbyAccountIdF(int accid){
        for(int i=0;i<efe.size();i++){
            if(efe.get(i).getacc().getaccountid()==accid){
                System.out.println(efe.get(i).toString());
            }
            else
                System.out.println("ACCOUNT ID NOT FOUND");
        }
    }
    public static void searchbyAccountIdP(int accid){
        for(int i=0;i<epe.size();i++){
            if(epe.get(i).getacc().getaccountid()==accid){
                System.out.println(epe.get(i).toString());
            }
            else
                System.out.println("ACCOUNT ID NOT FOUND");
        }
    }
}
