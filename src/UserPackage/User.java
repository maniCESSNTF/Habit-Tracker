package UserPackage;
import TaskPackage.Task;
import UtilityPackage.Utility;

import java.util.Scanner;
public class User {
    Scanner Scan = new Scanner(System.in);
    private String username;
    public Task[]tasks=new Task[100];
    private int taskCount=0;
    private String password;
    private String first_name,last_name,email;
    public int streak;

    public void setEmail(String email) {
        this.email = email;
    }
    public void settaskCount(int taskCount){
    this.taskCount=taskCount;
    }
    public void setFirst_name(String first_name) {
        for(int i=0;i<first_name.length();i++){
            if(first_name.charAt(i)<97) {
                char[] charArray = first_name.toCharArray();
                charArray[i] = (char) (charArray[i] + 32);
                first_name = new String(charArray); // تبدیل آرایه کاراکتر به رشته
            }
        }
            char[] charArray = first_name.toCharArray();
            charArray[0] = (char) (charArray[0] - 32);
            first_name = new String(charArray); // تبدیل آرایه کاراکتر به رشته
        this.first_name=first_name;
    }
    public void setLast_name(String Last_name) {


        for(int i=0;i<Last_name.length();i++){
            if(Last_name.charAt(i)<97) {
                char[] charArray = Last_name.toCharArray();
                charArray[i] = (char) (charArray[i] + 32);
                Last_name = new String(charArray); // تبدیل آرایه کاراکتر به رشته
            }
        }
            char[] charArray = Last_name.toCharArray();
            charArray[0] = (char) (charArray[0] - 32);
            Last_name = new String(charArray); // تبدیل آرایه کاراکتر به رشته
        this.last_name=Last_name;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public  void setPassword(String password) {
        if (Utility.isPasswordValid(password)) {
            this.password = password;}
        
else {
        do{
            System.out.println("try another password");
            String newpass=Scan.next();
            this.password=newpass;
        }while(!Utility.isPasswordValid(password));}
        }
    
    public String getFullName(){
        return  first_name + last_name;
    }
    public String getemail(){
        return  email;
    }
    public int gettaskCount(){
        return taskCount;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public boolean isTaskRepetitive(String taskName){
        for (int i=0;i<gettaskCount();i++) {
            if (tasks[i].getname().equals (taskName))
                return false;
        }
         return true;
    }
    public Task createTask(String name,String color) {
        String TASKname = null;
        do {
            if (!(isTaskRepetitive(name))) {
                System.out.println("You already have a task with the same name");
                System.out.println("Please enter another name");
                TASKname = Scan.next();
                name = TASKname;
            }
        } while ((!isTaskRepetitive(TASKname)));
        if(color == null)
            color = "000000";
        else if(!Task.isColorValid(color)){
            String newColor = null;
            do{
                   System.out.println("Text entered for color. It is not acceptable!");
                   System.out.println("Please try again!");
                    newColor = Scan.next();

             }while(!Task.isColorValid(newColor));
        }
            Task newTask = new Task(name,username,color);
            tasks[this.gettaskCount()] = newTask;
            settaskCount(gettaskCount() + 1);
            return newTask;
    }

    public boolean isEmailValid(String email) {
        if (email.endsWith("@gmail.com")) {
            return true;
        } else
            return false;
    }

    public String getFullName(User user) {
        if (first_name != null && last_name != null) {
            return String.join(" ", first_name, last_name);
        } else {
            return "Incomplete name";
        }
    }


    public User (String username,String password,String first_name,String last_name,String email){
    setUsername(username);
    setPassword(password);
    setFirst_name(first_name);
    setLast_name(last_name);
    while(!isEmailValid(email)){
    System.out.println("Email does not  end with @gmail.com");

email = Scan.next();
    };
    setEmail(email);
}
public Task getTaskByName(String TaskName){
        for(int i=0;i<gettaskCount();i++) {
            if (tasks[i].getname().equals(TaskName))
                return tasks[i];
        }
                System.out.println("is not any task whit this name");
    return null;
}
public Task[] getTaskByColor(String tasksColor){
        Task  ColorTasks[];
        int find=0;
    for(int i=0;i<gettaskCount();i++) {
        if (tasks[i].getColor().equals(tasksColor))
            find++;
    }
    if(find==0){
        System.out.println("There are no task with the  color.");
        return null;
    }
    else{
    ColorTasks=new Task[find];
    int z = 0;

    for (int i = 0; i < gettaskCount(); i++) {
        if (tasks[i].getColor().equals(tasksColor)) {
            ColorTasks[z] = tasks[i];
            z++;
        }
    }

    return ColorTasks;}
}

    public  void printUserInfo() {
        System.out.println("username :"+username);
        System.out.println("password :"+password);
        System.out.println("name :"+getFullName());
        System.out.println("email :"+email);
    }
   }
   
