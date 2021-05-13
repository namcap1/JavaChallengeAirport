package airport_challenge;

import java.util.ArrayList;

public class Airport{
    private ArrayList<String> hanger;
    private int airportCapacity;

    Airport(int airportSize){
        this.airportCapacity = airportSize;
        this.hanger = new ArrayList<String>(this.airportCapacity);
    }

    public int getAirportCapacity(){
        return this.airportCapacity;
    }

    public ArrayList<String> getHanger(){
        return this.hanger;
    }

    public void land(String planeName) throws Exception{
        this.landingChecks(planeName);
        this.hanger.add(planeName);

    }

    public void takeOff(String planeName) throws Exception{
        if(this.planeCurrentlyInHanger(planeName)){
            this.hanger.remove(planeName);
        }else{
            throw new Exception("Plane not landed");
        }
    }
    
    private void landingChecks(String planeName) throws Exception{
        if(!(this.airportLimitMet())) throw new Exception("Airport full");
        if(this.planeCurrentlyInHanger(planeName)) throw new Exception("Already Landed");
    }
    private boolean planeCurrentlyInHanger(String planeName){
        return this.hanger.contains(planeName);
    }

    private boolean airportLimitMet(){
       return this.hanger.size() < this.airportCapacity;
    }

}