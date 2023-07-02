import java.util.Queue;

public class Scheduler {
    Task[] ready;
    Task[] waiting;
    Resource[] R1, R2, R3;
    Task[] tasks;
    Task nowTask;
    Resource res[];
    int waitingNum;
    public Scheduler(int r1, int r2, int r3, Task[] tasks){
        this.R1 = new Resource[r1];
        this.R2 = new Resource[r2];
        this.R3 = new Resource[r3];
        this.tasks = tasks;
        this.nowTask = null;
        this.res = new Resource[2];
        waitingNum = 0;
    }

    void Scheduling (){
        while (true){
            if(ready == null && waiting == null) break;
            //TODO algorithm give a task
            int n = ready.length;


            //wait





        }
    }

    void SJF(){

    }
    void FCFS(){

    }
    void RR(){
        
    }

    boolean isFreeResource(String typeResource, int j){
        if(typeResource.equals("R1")){
            for (int i = 0 ; i < R1.length; i++) {
                if (R1[i].isFree()) {
                    res[j] = R1[i];
                    return true;
                }
            }
            return false;
        }
        else if(typeResource.equals("R2")){
            for (int i = 0 ; i < R2.length; i++) {
                if (R2[i].isFree()) {
                    res[j] = R2[i];
                    return true;
                }
            }
            return false;
        }
        else {
            for (int i = 0 ; i < R3.length; i++) {
                if (R3[i].isFree()) {
                    res[j] = R3[i];
                    return true;
                }
            }
            return false;
        }


    }

    public  void sort(Task[] task){
        //todo
    }

}
