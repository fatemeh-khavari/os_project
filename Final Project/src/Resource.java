public class Resource {
    String state; //'avalable' || 'onavalable'
    Task belongTo; // x - y - z - noun

    public  Resource(){
        this.state = "available";
        this.belongTo = null;
    }

    void getFree() {
        //TODO
        this.state = "available";
        this.belongTo = null;

    }

    void setAlloacate(Task task){
        //todo
        this.state = "disavailabe";
        this.belongTo = task;
    }

    boolean isFree(){
        return  this.belongTo == null;
    }


}
