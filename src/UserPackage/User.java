package UserPackage;
import TaskPackage.Task;
import java.util.Scanner;
public class User {
    Scanner Scan = new Scanner(System.in);
    private String password ,username;
    public String first_name,last_name,email;
    public int streak;
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {

        this.email = email;
    }
    public String getFullName(){
        return  first_name + last_name;
    }
    public Task createTask(){
         String nametask = Scan.next();
Task AP = new Task(nametask);
return AP;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public User (String Nusername, String Npassword, String Nfirst_name, String Nlast_name,String Nemail){
    setUsername(Nusername);
    setPassword(Npassword);
    setFirst_name(Nfirst_name);
    setLast_name(Nlast_name);
    setEmail(Nemail);
}
    public void printUserInfo() {
        System.out.println("username :"+username);
        System.out.println("password :"+password);
        System.out.println("first name :"+first_name);
        System.out.println("last name :"+last_name);
        System.out.println("email :"+email);
    }
}
