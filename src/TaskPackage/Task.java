package TaskPackage;

import java.util.Scanner;

public class Task {
    Scanner Scan = new Scanner(System.in);
    final String color;
    private Double start_time,finish_time, newTime;
    public String name,user;

    public void setName(String name){
        if(name.length()<10)
            this.name=name;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setFinish_time(Double finish_time) {
        if(finish_time>0 && finish_time<=24 && finish_time > this.start_time)
            this.finish_time = finish_time;
        else {
            do {
                System.out.println("Entry time for the finish is not acceptable");
                newTime = Double.parseDouble(Scan.next());
            }while(!(newTime>0 && newTime<=24 && newTime > this.start_time));
            this.finish_time = newTime;
        }
    }

    public void setStart_time(Double start_time) {
        if(start_time>=0 && start_time<24)
            this.start_time = start_time;
        else{
            do{
                System.out.println("Entry time for the start is not acceptable");
                newTime = Double.parseDouble(Scan.next());
            }while(!(newTime>=0 && newTime<24));
            this.start_time = newTime;
        }
    }

    public String getColor() {
        return color;
    }

    public double getDuration(){
        return finish_time - start_time;
    }
    public String getname() {
        return name;
    }

    public static boolean isColorValid(String color){
        if (color.length() != 6) {
            return false;
        }
        for(int i=0;i<6;i++){
            char charcter=color.charAt(i);
            if (!((charcter >= '0' && charcter <= '9') || (charcter >= 'A' && charcter <= 'F')))
                return false;
        }
        return true;
    }

    public Task(String name, String user) {
        setName(name);
        this.setUser(user);
        this.color=null;
    }

    public Task(String name, String user, String color) {
        this.color = color;
        setName(name);
        setUser(user);
    }
}