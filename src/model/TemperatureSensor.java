package model;

/**
 * The sensor dedicated to the temperature provided by the device.
 * 
 * @author Andrew Josten
 */
public class TemperatureSensor extends AbstractSensor{
	/**
	 * Holds the value of the temperature
	 */
    private int temp;

    /**
     * Constructor. Initializes temp to 0°.
     * To change temp value, call setTemp();
     */
    public TemperatureSensor(){
        temp = 0;
    }

    /**
     * Sets the temp in this class by pulling from raw data (in this case, the proxy class). 
     * If out of range (-40 to 150 F) rounds to nearest edge value. 
     */
    public void setTemp(){
    	temp = Integer.parseUnsignedInt(ProxyData.getTemperature(),2);
    	if(temp < -40) {
    		temp = -40;
    	}
    	else if(temp > 150) {
    		temp = 150;
    	}
    }

    /**
     * Returns int representation of temperature in range of -40 to 150 F
     * 
     * @returns Temperature as an int
     */
    public int getSensorReading(){
        return temp;
    }

    /**
     * Returns string representation of temperature
     * in format of "0° F"
     * 
     * @return A string representation of temperature
     */
    public String toString() {
        return (temp + "° F");
    }    
}