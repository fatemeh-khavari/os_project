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
        Task before = nowTask;
        boolean isSet = false;
        Task min_task = nowTask;
        int min_timer = nowTask.getTimeToRun();
        this.sort(ready);

        if(nowTask.getTimeToRun() == 0){
            Resource num1_nowTask = nowTask.num1;
            Resource num2_nowTask = nowTask.num2;
            num1_nowTask.getFree();
            num2_nowTask.getFree();
            for (int i = 0; i < ready.length; i++){
                if(isFreeResource(ready[i].getResources()[0][0], 1) && isFreeResource(ready[i].getResources()[1][0], 2) ){
                        ready[i].state = "running";
                        nowTask = ready[i];
                        delete_ready(i);
                        res[0].setAllocate(nowTask);
                        res[1].setAllocate(nowTask);
                        nowTask.setTimeToRun(nowTask.getTimeToRun() - 1);
                        nowTask.getResources()[0][1] = "1";
                        nowTask.getResources()[1][1] = "1";
                        isSet = true;
                        break;
                }
                else {
                    waiting[waitingNum ] = ready[i];
                    waitingNum++;
                    ready[i].state = "waiting";
                    delete_ready(i);
                }
            }
            if (! isSet){
                //todo from waiting add ready
            }

        }
        else{
            Resource num1_nowTask = nowTask.num1;
            Resource num2_nowTask = nowTask.num2;
            num1_nowTask.getFree();
            num2_nowTask.getFree();

            for (int i = 0; i < ready.length; i++){
                if (ready[i].getTimeToRun() < min_timer){
                    min_task = ready[i];
                    String res1 = min_task.getResources()[0][0];
                    String res2 = min_task.getResources()[1][0];

                    if(this.isFreeResource(res1,  1) && this.isFreeResource(res2, 2) ){

                        nowTask.state = "ready";
                        add_ready(nowTask);

                        delete_ready( i);
                        res[0].setAllocate(min_task);
                        res[1].setAllocate(min_task);
                        min_task.getResources()[0][1] = "1";
                        min_task.getResources()[1][1] = "1";
                        nowTask = min_task;
                        nowTask.state = "running";
                        nowTask.setTimeToRun(min_task.getTimeToRun() - 1);
                        isSet = true;
                        break;
                    }
                    else {

                        waiting[waitingNum] = min_task;
                        waitingNum++;
                        min_task.state = "waiting";
                        min_task = before;
                        delete_ready(i);
                    }
                }
                if(!isSet){
                    nowTask.setTimeToRun(nowTask.getTimeToRun() - 1);
                    nowTask = before;
                    nowTask.state = "running";
                    num1_nowTask.setAllocate(nowTask);
                    num2_nowTask.setAllocate(nowTask);
                    isSet = true;
                }
            }
        }


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

    public  void add_ready(Task task){
        //todo
    }

    public void delete_ready(int i ){
        // todo
    }

}
