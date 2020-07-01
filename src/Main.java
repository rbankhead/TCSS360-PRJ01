/**
 * TCSS 360 Group project#1 - Group 01
 * Driver class for Vantage Pro2 Integrated Sensor Suite software
 * @author richardbankhead
 * 
 * Team: I added some vague class names based on Chapter 6 info. 
 * We don't need to use these but they might be a good place to start
 */
public class Main {

	public static void main(String[] args) {
		Thread proxyData = new Thread(new ProxyData()); //init proxydata thread
		proxyData.start(); //start thread
		Anemometer a = new Anemometer(); //test Anemometer
		System.out.println(a.getCurrentWindSpeed()); //output init reading
		long start = System.currentTimeMillis();
		long current  = System.currentTimeMillis();
		while(current-start < 35000) { 
			current  = System.currentTimeMillis(); //wait 35 seconds before taking the next reading
		}
		System.out.println(a.getCurrentWindSpeed()); //output updated reading
	}

}
