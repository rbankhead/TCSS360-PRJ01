package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * JUnit test for TemperatureSensor.
 * NOTE: Cannot get full coverage because one branch in the if/else
 * to ensure reading is in range won't be hit necessarily. 
 * Since Proxy produces random values, this can't be hit on demand.
 * @author Andrew Josten
 */
class TemperatureSensorTest {
	static ProxyData ProxyData = new ProxyData();
	
	@Test
	void test() {
		//make new TS
		TemperatureSensor ts = new TemperatureSensor();
		assertEquals(ts.getSensorReading(), 0);
		
		//Test range
		ts.setTemp();		
		int h = ts.getSensorReading();
		assertTrue(h >= -40 && h <= 150);		
		
		//test toString();
		assertTrue(ts.toString().equals(ts.getSensorReading()+"Â° F"));
	}

}
