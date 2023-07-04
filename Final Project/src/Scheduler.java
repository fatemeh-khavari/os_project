import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;

public class Scheduler {
    Task[] ready;
    Task[] waiting;
    Resource[] R1, R2, R3;
    Task[] tasks;
    Task nowTask;
    Resource res[];
    int waitingNum;
    int readyNum;
    int quantum;
    int time;

    public Scheduler(int r1, int r2, int r3, Task[] tasks, int quantum){
        this.R1 = new Resource[r1];
        this.R2 = new Resource[r2];
        this.R3 = new Resource[r3];
        for (int i = 0; i < r1; i++){R1[i] = new Resource();}
        for (int i = 0; i < r2; i++){R2[i] = new Resource();}
        for (int i = 0; i < r3; i++){R3[i] = new Resource();}
        this.tasks = tasks;
        this.nowTask = null;
        this.res = new Resource[2];
        waitingNum = 0;
        readyNum = tasks.length;
        this.quantum = quantum;
        this.time = 1;
        this.ready = tasks;
        this.waiting = new Task[tasks.length];
    }

    void Scheduling (int i ){
        while (true){
            if(readyNum == 0 && waitingNum == 0 && nowTask.getTimeToRun() == 0)  break;
            //TODO algorithm give a task
             if (i == 0){
                 this.FCFS();
             }else if (i == 1){
                 this.SJF();
             }
             else {
                 this.RR(time);
             }

            System.out.println("Time : "  + time + " - Now Task: " + nowTask.name);
            System.out.println("quantum: " + quantum);
            print_resource();
            print_Ready();
            print_waiting();
            System.out.println("----------------------------------------------------------------");
            time +=1;
        }
    }

        void SJF(){

        if(time == 1){
            sort(tasks, readyNum);
            nowTask = ready[0];
            nowTask.state = "running";
            nowTask.setTimeToRun(nowTask.getTimeToRun() - 1);
            nowTask.resources[0][1] = "1";
            nowTask.resources[1][1] = "1";
            isFreeResource(nowTask.getResources()[0][0], 1 );
            isFreeResource(nowTask.getResources()[1][0], 2 );
            res[0].setAllocate(nowTask);
            res[1].setAllocate(nowTask);
            nowTask.num1 = res[0];
            nowTask.num2 = res[1];
            delete_ready(0);
        }
        else if(nowTask.getTimeToRun() == 0){// finish task

            Resource num1_nowTask = nowTask.num1;
            Resource num2_nowTask = nowTask.num2;
            num1_nowTask.getFree();
            num2_nowTask.getFree();
            nowTask.state = "finish";
            nowTask.getResources()[0][1] = "0";
            nowTask.getResources()[1][1] = "0";

            nowTask = ready[0];
            nowTask.state = "running";
            nowTask.setTimeToRun(nowTask.getTimeToRun() - 1);
            nowTask.resources[0][1] = "1";
            nowTask.resources[1][1] = "1";
            isFreeResource(nowTask.getResources()[0][0], 1 );
            isFreeResource(nowTask.getResources()[1][0], 2 );
            res[0].setAllocate(nowTask);
            res[1].setAllocate(nowTask);
            nowTask.num1 = res[0];
            nowTask.num2 = res[1];
            delete_ready(0);

        }

        else {
            nowTask.setTimeToRun(nowTask.getTimeToRun() - 1 );
        }
    }

    
        void FCFS(){
        if(time == 1){
            nowTask = ready[0];
            nowTask.state = "running";
            nowTask.setTimeToRun(nowTask.getTimeToRun() - 1);
            nowTask.resources[0][1] = "1";
            nowTask.resources[1][1] = "1";
            isFreeResource(nowTask.getResources()[0][0], 1 );
            isFreeResource(nowTask.getResources()[1][0], 2 );
            res[0].setAllocate(nowTask);
            res[1].setAllocate(nowTask);
            nowTask.num1 = res[0];
            nowTask.num2 = res[1];
            delete_ready(0);
        }
        else if(nowTask.getTimeToRun() == 0){// finish task

            Resource num1_nowTask = nowTask.num1;
            Resource num2_nowTask = nowTask.num2;
            num1_nowTask.getFree();
            num2_nowTask.getFree();
            nowTask.state = "finish";
            nowTask.getResources()[0][1] = "0";
            nowTask.getResources()[1][1] = "0";

            nowTask = ready[0];
            nowTask.state = "running";
            nowTask.setTimeToRun(nowTask.getTimeToRun() - 1);
            nowTask.resources[0][1] = "1";
            nowTask.resources[1][1] = "1";
            isFreeResource(nowTask.getResources()[0][0], 1 );
            isFreeResource(nowTask.getResources()[1][0], 2 );
            res[0].setAllocate(nowTask);
            res[1].setAllocate(nowTask);
            nowTask.num1 = res[0];
            nowTask.num2 = res[1];
            delete_ready(0);

        }

        else {
            nowTask.setTimeToRun(nowTask.getTimeToRun() - 1 );
        }
    }

    void RR(int time){
        boolean isSet = false;
        if(time == 1){
            sort(ready, readyNum );
            nowTask = ready[0];
            nowTask.state = "running";
            nowTask.setTimeToRun(nowTask.getTimeToRun() - 1);
            nowTask.resources[0][1] = "1";
            nowTask.resources[1][1] = "1";
            isFreeResource(nowTask.getResources()[0][0], 1 );
            isFreeResource(nowTask.getResources()[1][0], 2);
            res[0].setAllocate(nowTask);
            res[1].setAllocate(nowTask);
            nowTask.num1 = res[0];
            nowTask.num2 = res[1];
            delete_ready(0);
            isSet = true;
        }
        else if(nowTask.getTimeToRun() == 0){//finish
            this.sort(ready, readyNum );
            isSet = false;
            // finish task
            Resource num1_nowTask = nowTask.num1;
            Resource num2_nowTask = nowTask.num2;
            num1_nowTask.getFree();
            num2_nowTask.getFree();
            nowTask.state = "finish";
            nowTask.getResources()[0][1] = "0";
            nowTask.getResources()[1][1] = "0";

            for (int i = 0; i < readyNum; i++){
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
                    nowTask.num2 = res[0];
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
                    nowTask.num1 = res[0];
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
                    nowTask.num1 = res[0];
                    nowTask.num2 = res[1];
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
                ready = waiting;
                readyNum = waitingNum;
                waiting = new Task[tasks.length];
                waitingNum = 0;
                RR(time);
            }
        }
        else if(time % quantum  == 0){
            Resource num1_nowTask = nowTask.num1;
            Resource num2_nowTask = nowTask.num2;
            num1_nowTask.getFree();
            num2_nowTask.getFree();
            nowTask.state = "finish";
            nowTask.getResources()[0][1] = "0";
            nowTask.getResources()[1][1] = "0";

            add_ready(nowTask);
            nowTask.state = "ready";
            this.sort(ready, readyNum);
             isSet = false;
            // finish task



            for (int i = 0; i < readyNum; i++){
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
                    nowTask.num2 = res[0];
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
                    nowTask.num1 = res[0];
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
                    nowTask.num1 = res[0];
                    nowTask.num2 = res[1];
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
                    res[j-1] = R1[i];
                    return true;
                }
            }
            return false;
        }
        else if(typeResource.equals("R2")){
            for (int i = 0 ; i < R2.length; i++) {
                if (R2[i].isFree()) {
                    res[j-1] = R2[i];
                    return true;
                }
            }
            return false;
        }
        else {
            for (int i = 0 ; i < R3.length; i++) {
                if (R3[i].isFree()) {
                    res[j-1] = R3[i];
                    return true;
                }
            }
            return false;
        }


    }

    public  void sort(Task[] tasks, int x){
            Arrays.sort(tasks, new Comparator<Task>() {
                @Override
                public int compare(Task t1, Task t2) {
                    if (t1 == null && t2 == null) {
                        return 0;
                    } else if (t1 == null) {
                        return 1;
                    } else if (t2 == null) {
                        return -1;
                    } else if (t1.getPriority() != t2.getPriority()) {
                        return t1.getPriority() - t2.getPriority();
                    } else {
                        return t1.getTimeToRun() - t2.getTimeToRun();
                    }
                }
            });

            // جابجا کردن تسک‌های null به انتهای آرایه
            for (int i = x; i < tasks.length; i++) {
                if (tasks[i] == null) {
                    for (int j = i + 1; j < tasks.length; j++) {
                        if (tasks[j] != null) {
                            Task temp = tasks[i];
                            tasks[i] = tasks[j];
                            tasks[j] = temp;
                            break;
                        }
                    }
                }
            }


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
        System.out.println("R1: " + num1 + "  R2: " + num2 + "  R3: " + num3);
    }

    void  print_Ready(){
        System.out.print("Priority queue: [ ");
        for (int i = 0; i < readyNum; i++){
            System.out.print(ready[i].name + ", ");
        }
        System.out.print("]\n");
    }

    void print_waiting(){
        System.out.print("Waiting queue: [ ");
        for (int i = 0; i < waitingNum; i++){
            System.out.print(waiting[i].name + ", ");
        }
        System.out.print("]\n");
    }
        
    public  void add_ready(Task task){
        ready[readyNum] = task;
        readyNum++;
    }

    public void delete_ready(int i ){

        if (i >= ready.length || i < 0) {
            throw new IndexOutOfBoundsException("Invalid index!");
        }
        for (int j = i; j < readyNum - 1; j++) {
            ready[j] = ready[j + 1];
        }
        ready[readyNum - 1] = null;
        readyNum--;

    }

}
