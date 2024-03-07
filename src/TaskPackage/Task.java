package TaskPackage;

public class Task {
    public Double start_time,finish_time;
    public String name,Nname;
    public double getDuration(){
        return finish_time - start_time;
    }
    public Task(String Nname){
        this.name = Nname;
    }
}
