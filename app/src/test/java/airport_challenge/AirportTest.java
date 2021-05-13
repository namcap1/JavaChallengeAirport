package airport_challenge;

import java.util.ArrayList;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class AirportTest {
    @Test void canChangeTheSizeOfTheHangerToTwenty() {
        Airport classUnderTest = new Airport(20);
        assertEquals(classUnderTest.getAirportCapacity(), 20);
    }
    @Test void canChangeTheSizeOfTheHangerToFive() {
        Airport classUnderTest = new Airport(5);
        assertEquals(classUnderTest.getAirportCapacity(), 5);
    }
    @Test void canLandAPlane() {
        Airport classUnderTest = new Airport(5);
        Plane planeName = new Plane("Boeing 247");
        try{
            classUnderTest.land(planeName.getPlaneName());
            ArrayList<String> test = classUnderTest.getHanger();
            assertEquals(test.get(0), "Boeing 247");
        }catch(Exception e){
            System.err.println(e);
        }
    }
    @Test void canLandMultiplePlanes() {
        Airport classUnderTest = new Airport(5);
        Plane planeName = new Plane("Boeing 247");
        Plane planeName2 = new Plane("Boeing 248");
        try{
            classUnderTest.land(planeName.getPlaneName());
            classUnderTest.land(planeName2.getPlaneName());
            ArrayList<String> test = classUnderTest.getHanger();
            assertEquals(test.get(0), "Boeing 247");
            assertEquals(test.get(1), "Boeing 248");
        }catch(Exception e){
            System.err.println(e);
        }
    }
    @Test void throwsAnErrorWhenAirportIsFull() {
        Airport classUnderTest = new Airport(0);
        Plane planeName = new Plane("Boeing 247");
        Throwable exception = assertThrows(Exception.class, () -> {
            classUnderTest.land(planeName.getPlaneName());
        });
        ArrayList<String> test = new ArrayList<String>(0);
        assertTrue(test.equals(classUnderTest.getHanger()));   
        assertEquals("Airport full", exception.getMessage());
    }
    @Test void canTakeOffAPlane() {
        Airport classUnderTest = new Airport(5);
        Plane planeName = new Plane("Boeing 247");
        try{
            classUnderTest.land(planeName.getPlaneName());
            classUnderTest.takeOff(planeName.getPlaneName());
            ArrayList<String> test = new ArrayList<String>(5);
            assertTrue(test.equals(classUnderTest.getHanger()));
        }catch(Exception e){
            System.err.println(e);
        }
    }
    @Test void cannotTakeOffANotLandedPlane() {
        Airport classUnderTest = new Airport(5);
        Plane planeName = new Plane("Boeing 247");
        Throwable exception = assertThrows(Exception.class, () -> {
            classUnderTest.takeOff(planeName.getPlaneName());
        });
        assertEquals("Plane not landed", exception.getMessage());   
    }
    @Test void cannotLandAnAlreadyLandedPlane() {
        Airport classUnderTest = new Airport(5);
        Plane planeName = new Plane("Boeing 247");
        Throwable exception = assertThrows(Exception.class, () -> {
            classUnderTest.land(planeName.getPlaneName());
            classUnderTest.land(planeName.getPlaneName());
        });
        assertEquals("Already Landed", exception.getMessage());   
    }
}
