import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusStopTest {

    BusStop busStop;
    Person person;


    @Before
    public void before(){
        busStop = new BusStop("Town");
        person = new Person();
    }

    @Test
    public void hasName(){
        assertEquals("Town", busStop.getName());
    }

    @Test
    public void queueStartsEmpty(){
        assertEquals(0, busStop.queueLength());
    }

    @Test
    public void canAddToQueue(){
        busStop.addToQueue(person);
        assertEquals(1, busStop.queueLength());
    }

    @Test
    public void canRemoveFromQueue(){
        busStop.addToQueue(person);
        busStop.addToQueue(person);
        busStop.removeFromQueue();
        assertEquals(1, busStop.queueLength());
    }
}
