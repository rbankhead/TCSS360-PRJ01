package model;

import java.io.Serializable;

/** The integrated sensor suite is a device that contains many connected sensors which collect data about their environments.
 * 
 * @author chanteltrainer
 * @version July 2, 2020
 */
public class IntegratedSensorSuite implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 4721190505387048162L;

    /** The degree symbol for use in formatted strings regarding temperature or angles. */
    final static char DEGREE_SYMBOL = 0x00B0;
    
    //Serialized fields must be public. 
    public transient Anemometer myAnemometer;
    
    public transient HumiditySensor myHumiditySensor;
    
    public transient TemperatureSensor myTemperatureSensor;
    
    /** Each Vantage Pro2 console can receive data from up to 8 different wireless transmitters.
     *  The default transmitter ID for the sensor suite is 1, and in most cases it is not necessary to change it.
     */
    public int myTransmitterId = 1;
    
    public String myCurrentWindDirection;
    
    public String myCurrentWindSpeed;
    
    public int myCurrentHumidity;
    
    public int myCurrentTemperature;
    
    
    /** 
     * Constructor of a Integrated Sensor Suite which contains a variety of sensors and stores the current data. 
     * @param theTransmitterId
     */
    public IntegratedSensorSuite(int theTransmitterId) {
        myAnemometer = new Anemometer();
        myHumiditySensor = new HumiditySensor();
        myTemperatureSensor = new TemperatureSensor();
        myTransmitterId = theTransmitterId;
        reinitializeData();
        
    }

    /**
     * A method which re-initializes the current data of the sensors.
     */
    public void reinitializeData() {
        myCurrentWindDirection = myAnemometer.getCurrentWindDirection();
        myCurrentWindSpeed = myAnemometer.getCurrentWindSpeed();
        myCurrentHumidity = myHumiditySensor.getSensorReading();
        myCurrentTemperature = myTemperatureSensor.getSensorReading();
    }
    
    /** Returns the transmitter ID. */
    public int getTransmitterId() {
        return myTransmitterId;
    };
    
    /** Changes the transmitter ID. */
    public void setTransmitterId(int theInt) {
        myTransmitterId = theInt;
    }
    
    @Override
    public String toString() {
        return "Wind Direction: " + myCurrentWindDirection + ". Wind Speed: " + myCurrentWindSpeed + ". Humidity: " 
                + myCurrentHumidity + "%. Temperature: " + myCurrentTemperature + DEGREE_SYMBOL + "F.";
    }
}
