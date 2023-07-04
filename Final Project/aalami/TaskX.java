public class TaskX extends Task {


    public TaskX(String name , int timeToRun){

        super(name,1, timeToRun );
        resources[0] = new String[]{"R1","0"};
        resources[1]=  new String[]{"R2","0"};

    }

}
