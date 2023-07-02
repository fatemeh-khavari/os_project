public class TaskY extends Task{
    String resources[][];

    public TaskY(String name,  int timeToRun){

        super( name, 2, timeToRun);
        this.resources = new String[2][];
        resources[0] = new String[]{"R2","0"};
        resources[1]=  new String[]{"R3","0"};
    }
    @Override
    public String[][] getResources() {
        return resources;
    }
}
