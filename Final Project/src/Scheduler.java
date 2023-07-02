import java.util.Queue;

public class Scheduler {
    Task[] ready;
    Task[] waiting;
    Resource[] R1, R2, R3;
    Task[] tasks;
    Task nowTask;
    Resource res[];
    int waitingNum;
    int quantum;
    int time;
    public Scheduler(int r1, int r2, int r3, Task[] tasks, int quantum){
        this.R1 = new Resource[r1];
        this.R2 = new Resource[r2];
        this.R3 = new Resource[r3];
        this.tasks = tasks;
        this.nowTask = null;
        this.res = new Resource[2];
        waitingNum = 0;
        this.quantum = quantum;
        this.time = 1;
    }

    void Scheduling (){
        while (true){
            if(ready == null && waiting == null) break;
            //TODO algorithm give a task
            this.RR();
            System.out.println("Time : "  + time + "Now Task: " + nowTask);
            this.RR();
            print_resource();
            print_Ready();
            print_waiting();
            time +=1;
        }
    }

    void SJF(){

    }
    void FCFS(){

    }
    void RR(int time){

        if(time == 1){
            sort(ready);
            nowTask = ready[0];
            nowTask.state = "running";
            nowTask.setTimeToRun(nowTask.getTimeToRun() - 1);
            nowTask.resources[0][1] = "1";
            nowTask.resources[1][1] = "1";
            isFreeResource(nowTask.getResources()[0][0], 1 );
            isFreeResource(nowTask.getResources()[1][0], 2);
            res[0].setAllocate(nowTask);
            res[1].setAllocate(nowTask);
            delete_ready(0);
        }
        else if(nowTask.getTimeToRun() == 0){//finish
            this.sort(ready);
            boolean isSet = false;
            // finish task
            Resource num1_nowTask = nowTask.num1;
            Resource num2_nowTask = nowTask.num2;
            num1_nowTask.getFree();
            num2_nowTask.getFree();
            nowTask.state = "finish";
            nowTask.getResources()[0][1] = "0";
            nowTask.getResources()[1][1] = "0";

            for (int i = 0; i < ready.length; i++){
                String[][] resourseTask = ready[i].getResources();

                if(resourseTask[0][1].equals("1") && resourseTask[1][1].equals("1")){
                    //they have resorces
                    nowTask = ready[i];
                    delete_ready(i);
                    nowTask.state = "running";
                    nowTask.setTimeToRun(nowTask.getTimeToRun() - 1);
                    isSet = true;
                    break;
                }
                else if (resourseTask[0][1].equals("1") && isFreeResource(resourseTask[1][0], 1)){
                    nowTask = ready[i];
                    delete_ready(i);
                    res[0].setAllocate(nowTask);
                    resourseTask[1][1] = "1";
                    nowTask.state = "running";
                    nowTask.setTimeToRun(nowTask.getTimeToRun() - 1);
                    isSet = true;
                    break;
                }
                else if (resourseTask[1][1].equals("1") && isFreeResource(resourseTask[0][0], 1)){
                    nowTask = ready[i];
                    delete_ready(i);
                    res[0].setAllocate(nowTask);
                    resourseTask[0][1] = "1";
                    nowTask.state = "running";
                    nowTask.setTimeToRun(nowTask.getTimeToRun() - 1);
                    isSet = true;
                    break;
                }
                else if(isFreeResource(resourseTask[0][0], 1) && isFreeResource(resourseTask[1][0], 2) ){
                    nowTask = ready[i];
                    delete_ready(i);
                    res[0].setAllocate(nowTask);
                    res[1].setAllocate(nowTask);
                    resourseTask[0][1] = "1";
                    resourseTask[1][1] = "1";
                    nowTask.state = "running";
                    nowTask.setTimeToRun(nowTask.getTimeToRun() - 1);
                    isSet = true;
                    break;
                }
                else {
                    nowTask.state = "waiting";
                    waiting[waitingNum] = ready[i];
                    waitingNum++;
                    delete_ready(i);
                }
            }
            if (!isSet){
                //todo for waiting and ready is null
            }
        }
        else if(time % quantum  == 0){

            add_ready(nowTask);
            nowTask.state = "ready";
            this.sort(ready);
            boolean isSet = false;
            // finish task
            Resource num1_nowTask = nowTask.num1;
            Resource num2_nowTask = nowTask.num2;
            num1_nowTask.getFree();
            num2_nowTask.getFree();
            nowTask.state = "finish";
            nowTask.getResources()[0][1] = "0";
            nowTask.getResources()[1][1] = "0";

            for (int i = 0; i < ready.length; i++){
                String[][] resourseTask = ready[i].getResources();

                if(resourseTask[0][1].equals("1") && resourseTask[1][1].equals("1")){
                    //they have resorces
                    nowTask = ready[i];
                    delete_ready(i);
                    nowTask.state = "running";
                    nowTask.setTimeToRun(nowTask.getTimeToRun() - 1);
                    isSet = true;
                    break;
                }
                else if (resourseTask[0][1].equals("1") && isFreeResource(resourseTask[1][0], 1)){
                    nowTask = ready[i];
                    delete_ready(i);
                    res[0].setAllocate(nowTask);
                    resourseTask[1][1] = "1";
                    nowTask.state = "running";
                    nowTask.setTimeToRun(nowTask.getTimeToRun() - 1);
                    isSet = true;
                    break;
                }
                else if (resourseTask[1][1].equals("1") && isFreeResource(resourseTask[0][0], 1)){
                    nowTask = ready[i];
                    delete_ready(i);
                    res[0].setAllocate(nowTask);
                    resourseTask[0][1] = "1";
                    nowTask.state = "running";
                    nowTask.setTimeToRun(nowTask.getTimeToRun() - 1);
                    isSet = true;
                    break;
                }
                else if(isFreeResource(resourseTask[0][0], 1) && isFreeResource(resourseTask[1][0], 2) ){
                    nowTask = ready[i];
                    delete_ready(i);
                    res[0].setAllocate(nowTask);
                    res[1].setAllocate(nowTask);
                    resourseTask[0][1] = "1";
                    resourseTask[1][1] = "1";
                    nowTask.state = "running";
                    nowTask.setTimeToRun(nowTask.getTimeToRun() - 1);
                    isSet = true;
                    break;
                }
                else {
                    nowTask.state = "waiting";
                    waiting[waitingNum] = ready[i];
                    waitingNum++;
                    delete_ready(i);
                }
            }
        }
        else {//do before task
           nowTask.setTimeToRun(nowTask.getTimeToRun() - 1);
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

    void print_resource(){
        int num1 =  0, num2 = 0, num3 = 0;
        for (int i = 0; i < R1.length; i++){
            if(R1[i].isFree()){
                num1++;
            }
        }
        for (int i = 0; i < R2.length; i++){
            if(R2[i].isFree()){
                num2++;
            }
        }
        for (int i = 0; i < R3.length; i++){
            if(R3[i].isFree()){
                num3++;
            }
        }
        System.out.println("R1: " + num1 + "R2: " + num2 + "R3: " + num3);
    }

    void  print_Ready(){
        System.out.print("Priority queue: [ ");
        for (int i = 0; i < ready.length; i++){
            System.out.print(ready[i].name + ", ");
        }
        System.out.print("]\n");
    }

    void print_waiting(){
        System.out.print("Waiting queue: [ ");
        for (int i = 0; i < waiting.length; i++){
            System.out.print(waiting[i].name + ", ");
        }
        System.out.print("]\n");
    }
        
    public  void add_ready(Task task){
        //todo
    }

    public void delete_ready(int i ){
        // todo
    }

}
