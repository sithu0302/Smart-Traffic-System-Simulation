import java.util.ArrayList;

public class IntersectionQueue {

    ArrayList<Vehicles> vehicles;

    public IntersectionQueue(){
        vehicles=new ArrayList<>();
    }

    public void addVehcles (Vehicles v){
        vehicles.add(v);
    }

    public int getVehiclesCountByType (String type){
        int count=0;
        for (Vehicles v : vehicles){
            if (v.type.equalsIgnoreCase(type)){
                count++;
            }
        }
        return count;
    }

    public int getTotalVehicleCount(){
        return vehicles.size();
    }

    public void displayVehicles(){
        for (Vehicles v: vehicles){
            System.out.println(v.toString());
        }
    }

   public void addVehicle(Vehicles v) {
    vehicles.add(v);
}


}