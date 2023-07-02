public class TaskZ extends Task{
    String resources[][];

    public TaskZ(String name, int timeToRun){

        super( name, 3, timeToRun);
        this.resources = new String[2][];
        resources[0] = new String[]{"R1", "0"};
        resources[1]=  new String[]{"R3" ,"0"};
    }
}
