public class Task {
    int priority;
    String state;
    int timeToRun;
    String name;
    String[][] resources;


    public Task(String name, int priority, int timeToRun){
        this.priority = priority;
        this.timeToRun = timeToRun;
        this.state = "None";
        this.name = name;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public int getTimeToRun(){return timeToRun;}

    public void setTimeToRun(int timeToRun) {
        this.timeToRun = timeToRun;
    }
    public String[][] getResources() {
        return resources;
    }
}

