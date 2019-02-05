import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusTest {

    Bus bus;
    Person person;
    BusStop busStop;

    @Before
    public void before(){
        bus = new Bus("Glasgow", 4);
        person = new Person();
        busStop = new BusStop("Town");
        busStop.addToQueue(person);
    }

    @Test
    public void hasDestination(){
        assertEquals("Glasgow", bus.getDestination());
    }

    @Test
    public void hasCapacity(){
        assertEquals(4, bus.getCapacity());
    }

    @Test
    public void startsWithNoPassengers(){
        assertEquals(0, bus.passengerCount());
    }

    @Test
    public void canAddPassengerifSpaceAvailable(){
        bus.addPassenger(person);
        assertEquals(1, bus.passengerCount());
    }

    @Test
    public void canOnlyAddPassengersToCapcity(){
        bus.addPassenger(person);
        bus.addPassenger(person);
        bus.addPassenger(person);
        bus.addPassenger(person);
        bus.addPassenger(person);
        assertEquals(4, bus.passengerCount());
    }

    @Test
    public void canRemoverPassenger(){
        bus.addPassenger(person);
        bus.addPassenger(person);
        bus.removePassenger(0);
        assertEquals(1, bus.passengerCount());
    }

    @Test
   public void canPickUpPassenger(){
        bus.pickUp(busStop);
        assertEquals(0, busStop.queueLength());
        assertEquals(1, bus.passengerCount());
    }
}
