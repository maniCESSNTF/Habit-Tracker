package Activity;

public class Task extends ToDo{
    private Double finishTime;
    @Override
    public String getInfo() {
        return ("name : "+super.getName()+"start Time : "+super.getStartTime()+"finishTime : "+getFinishTime());
    }

    public Double getDuration(){
       return (super.getStartTime()-finishTime);
    }

    public void setFinishTime(double finishTime){
        Double newTime;
        if(finishTime>0 && finishTime<=24 && finishTime > super.getStartTime())
            this.finishTime = finishTime;
        else {
            do {
                System.out.println("Entry time for the finish is not acceptable");
                newTime = Double.parseDouble(scan.next());
            }while(!(newTime>0 && newTime<=24 && newTime > super.getStartTime()));
            this.finishTime = newTime;
        };
    }

    public Double getFinishTime() {
        return finishTime;
    }

    public Task(String name, String user) {
        super.setName(name);
        this.setUser(user);
        super.setColor(null);
    }

    public Task() {
    }
}
