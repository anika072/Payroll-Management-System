
package cse110miniproject;

public class Login {
    private int loginId;
    private String employeeType;
    public int getloginId(){
        return loginId;
    }
    public String getemployeeType(){
        return employeeType;
    }
    public Login(){
        
    }
    public Login( int loginId,String employeeType){
        this.loginId=loginId;
        this.employeeType=employeeType;
 }
    @Override
    public String toString(){
        return "~EMPLOYEE INFORMATION~"
                + "\nLogin Id: "+this.getloginId()+
                "\nEmployee Type: "+this.getemployeeType()+" Time Employee";
    }
}
