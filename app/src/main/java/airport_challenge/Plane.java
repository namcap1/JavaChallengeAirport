/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package airport_challenge;

public class Plane {
    private String planeName;
    
    Plane(String planeName){
        this.planeName = planeName;
    }

    public String getPlaneName(){
        return this.planeName;
    }
}