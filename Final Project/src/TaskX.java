public class TaskX extends Task {
    String resources[][];

    public TaskX(String name , int timeToRun){

        super(name,1, timeToRun);
        this.resources = new String[2][];
        resources[0] = new String[]{"R1","0"};
        resources[1]=  new String[]{"R2","0"};

    }
    @Override
    public String[][] getResources() {
        return resources;
    }
}
