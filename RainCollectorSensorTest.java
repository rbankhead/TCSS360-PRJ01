import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class RainCollectorSensorTest {
	
	private RainCollectorSensor mySensor;
	
	@Before
	public void setup() {
		mySensor = new RainCollectorSensor();
	}

	@Test
	void testContsructor() {
		RainCollectorSensor temp = new RainCollectorSensor();
		assertEquals(mySensor, temp);
	}
	
	@Test
	void testRead() {
		RainCollectorSensor temp = new RainCollectorSensor();
		assertEquals(mySensor.getReading(), 0.0);
	}
	
	@Test
	void testGetReading() {
		RainCollectorSensor temp = new RainCollectorSensor();
		assertEquals(mySensor.getReading(), temp.getReading());
	}

	@Test
	void testToString() {
		assertEquals(mySensor.toString(), "0.0  mm in the collector.");
	}
}
