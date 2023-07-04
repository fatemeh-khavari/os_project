public class TaskY extends Task{


    public TaskY(String name,  int timeToRun){

        super( name, 2, timeToRun);

        super.resources[0] = new String[]{"R2","0"};
        super.resources[1]=  new String[]{"R3","0"};
    }
    @Override
    public String[][] getResources() {
        return resources;
    }
}
