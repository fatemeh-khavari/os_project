public class Task {
    int priority;
    String state;
    int timeToRun;
    String name;

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

    


}

