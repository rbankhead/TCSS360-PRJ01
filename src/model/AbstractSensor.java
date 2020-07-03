package model;
/**
 * AbstractSensor includes behavior of a sensor within the Integrated Sensor Suite. A sensor provides data to the Vantage Pro2 Console.
 * @author chanteltrainer
 * @version 6/28/20
 */
public abstract class AbstractSensor {
    /** Each Vantage Pro2 console can receive data from up to 8 different wireless transmitters.
     *  The default transmitter ID for the sensor suite is 1, and in most cases it is not necessary to change it.
     */
    static int TRANSMITTER_ID = 1;
    
    /** The degree symbol for use in formatted strings regarding temperature or angles. */
    final static char DEGREE_SYMBOL = 0x00B0;
    
    /** Returns the transmitter ID. */
    public int getTransmitterId() {
        return TRANSMITTER_ID;
    };
    
    /** Changes the transmitter ID. */
    public void setTransmitterId(int theInt) {
        TRANSMITTER_ID = theInt;
        
        
    }
    //** Converts from binary to int. */
    public static int getDecimal(int binary){  
        int decimal = 0;  
        int n = 0;  
        while(true){  
          if(binary == 0){  
            break;  
          } else {  
              int temp = binary%10;  
              decimal += temp*Math.pow(2, n);  
              binary = binary/10;  
              n++;  
           }  
        }  
        return decimal;  
    } 
}
