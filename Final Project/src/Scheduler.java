import java.util.Queue;

public class Scheduler {
    Task[] ready;
    Task[] waiting;
    Resource[] R1, R2, R3;
    Task[] tasks;
    Task nowTask;

    public Scheduler(int r1, int r2, int r3, Task[] tasks){
        this.R1 = new Resource[r1];
        this.R2 = new Resource[r2];
        this.R3 = new Resource[r3];
        this.tasks = tasks;
        this.nowTask = null;
    }

    void Scheduling (){
        while (true){
            if(ready == null && waiting == null) break;
            //TODO algorithm give a task
            int n = ready.length


            //wait





        }
    }

    void SJF(){

    }
    void FCFS(){

    }
    void RR(){

    }


}