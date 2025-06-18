public class EmergencyInterSection{
    String name;
    int priority;

    public EmergencyInterSection(String name, int priority){
        this.name=name;
        this.priority= priority;
    }

    public String toString(){
        return name + "(Priority)" + priority + ")";
    }
}