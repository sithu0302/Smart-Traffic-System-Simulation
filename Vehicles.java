public class Vehicles {

    String type;
    String direction;

    public Vehicles( String type,String direction){
        this.type = type;
        this.direction= direction;
    }
    public String  toString(){
        return "Vehicles Type"+type + ", Direction:" + direction;
    }
}