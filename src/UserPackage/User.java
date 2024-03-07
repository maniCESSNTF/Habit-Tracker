package UserPackage;
import TaskPackage.Task;
import java.util.Scanner;
public class User {
    Scanner Scan = new Scanner(System.in);
    private String username;
    private String password;
    public String first_name,last_name,email;
public int streak;

    public void setEmail(String email) {
        this.email = email;
    }
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
    public String getFullName(){
        return  first_name + last_name;
    }
    public Task createTask(){
         String nametask = Scan.next();
Task task1 = new Task(nametask);
return task1;
    }
    /*public String getUsername(){

    }*/
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
   public String getUsername(){
        return username;
   }

    public String getPassword(){
        return password;
    }
}
