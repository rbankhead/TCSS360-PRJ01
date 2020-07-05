package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RainCollectorSensorTest {
	
	static ProxyData ProxyData = new ProxyData();
	
	@Test
	void test() {
		RainCollectorSensor rcs = new RainCollectorSensor();
		assertEquals(rcs.getReading(), 0.0);
		
		rcs.read();		
		double r = rcs.getReading();
		assertTrue(r >= 0.0);
		assertTrue(r <= 9999.0);
		
		// Test toString() for mm;
		assertTrue(rcs.toString().equals(rcs.getReading()+" mm in the collector."));
		
		// Test toString() for inches
		rcs.setUnitsMetric(false);
		rcs.getReading();
		assertTrue(rcs.toString().equals(rcs.getReading()+" in. in the collector."));
	}
	 
}
