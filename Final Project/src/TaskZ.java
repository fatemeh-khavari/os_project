public class TaskZ extends Task{

    public TaskZ(String name, int timeToRun){

        super( name, 3, timeToRun);

        super.resources[0] = new String[]{"R1", "0"};
        super.resources[1]=  new String[]{"R3" ,"0"};
    }
    @Override
    public String[][] getResources() {
        return resources;
    }
}
