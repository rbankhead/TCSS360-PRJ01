import java.util.Random;

/**
 * Proxy data class to imitate the sensors of the Vantage Pro2 Sensor Suite
 * This class randomly generates data to be provided to the Sensor classes who will process that data
 * 
 * Each getter method returns a binary string representation of the sensor reading data in order to best imitate the Vantage Pro2 Sensor suite
 * 
 * @author richardbankhead
 */
public class ProxyData {
	
	/** Random object used to generate reasonable proxy sensor data */
	private static Random random = new Random();
	
	/** 0-360 wind direction represented in degrees */
	private static Integer windDirection;
	
	/** 1 byte unsigned, wind speed in mph */
	private static Integer windSpeed;
	
	/** 2 byte max likely unsigned, number of rain clicks */
	private static Integer rainCollector;
	
	/** 2 byte max signed, 10th of a degree F */
	private static Integer temperature;
	
	/** 1 byte max, humidity percentage */
	private static Integer humidity;
	
	/** 2 byte max radiation level, watts/sq meter */
	private static Integer radiationLevel;
	
	/** 1 byte max UV index */
	private static Integer ultravioletIndex;
	
	
	/**
	 * constructor to initialize a new reading from each sensor
	 */
	public ProxyData() {
		windDirection = random.nextInt(361); //from 0-360, represented in degrees. 0 degrees means no wind data
		windSpeed = random.nextInt(200); //1 byte max unsigned, 0-200 MPH
		rainCollector = random.nextInt(65535); //may need tweaking. the sensor sends 2 bytes worth of data but 65k is probably too big of a range to be reasonable
		temperature = random.nextInt(32768); //again 2 byte maximum yikes that's extreme. the documentation doesn't specify but we can assume this is a signed 2s complement value
		if(random.nextBoolean()) {
			temperature = -temperature; //50% chance to be negative value
		}
		humidity = random.nextInt(101); //from 0-100, field is a percentage
		radiationLevel = random.nextInt(65535); //number of watts per meter squared
		ultravioletIndex = random.nextInt(13); //field has a 1 byte max but UV>11 is considered extreme so I'm allowing a max of 12 here
	}
	
	
	/**
	 * It is a two byte unsigned value from 1 to 360 degrees.(0° is no wind data,90° is East, 180° is South, 270° is West and 360° is north)
	 */
	public static String getWindDirection() {
	    windDirection = random.nextInt(361); //from 0-360, represented in degrees. 0 degrees means no wind data
		return Integer.toBinaryString(windDirection);
	}
	
	
	/**
	 * It is a byte unsigned value in mph.  If the wind speed is dashed because it lost synchronization with the radio or due to some other reason, the wind speed is forced to be 0.
	 */
	public static String getWindSpeed() {
	    windSpeed = random.nextInt(200); //1 byte max unsigned, 0-200 MPH
		return Integer.toBinaryString(windSpeed);
	}


	/**
	 * This value is sent as number of rain clicks (0.2mm or 0.01in).  For example, 256 can represent 2.56 inches/hour.
	 */
	public static String getRainCollector() {
		return Integer.toBinaryString(rainCollector);
	}

	
	/**
	 * The value is sent as 10th of a degree in F.  For example, 795 is returned for 79.5°F.
	 * documentation doesn't specify but we can assume this is a signed value
	 */
	public static String getTemperature() {
		return Integer.toBinaryString(temperature);
	}

	/**
	 * This is the relative humidity in %, such as 50 is returned for 50%.
	 */
	public static String getHumidity() {
		return Integer.toBinaryString(humidity);
	}

	
	/**
	 * The unit is in watt/meter2.
	 */
	public static String getRadiationLevel() {
		return Integer.toBinaryString(radiationLevel);
	}
	
	/**
	 * The unit is in UV index.
	 */
	public static String getUltravioletIndex() {
		return Integer.toBinaryString(ultravioletIndex);
	}

	
}
