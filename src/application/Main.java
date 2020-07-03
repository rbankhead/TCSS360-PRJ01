package application;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import model.Anemometer;
import model.IntegratedSensorSuite;
import model.ProxyData;

/**
 * TCSS 360 Group project#1 - Group 01
 * Driver class for Vantage Pro2 Integrated Sensor Suite software
 * @author richardbankhead
 * 
 * Team: I added some vague class names based on Chapter 6 info. 
 * We don't need to use these but they might be a good place to start
 */
public class Main {

    static IntegratedSensorSuite myIntegratedSensorSuite = new IntegratedSensorSuite(1);
    
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
		System.out.println(a.getCurrentWindSpeed()); //should be the same value if <35s has passed...
		
		serialization("data.txt", myIntegratedSensorSuite);
		
	}

	/**
	 * A method which takes a filepath name and object to serialize. The file can then be deserialized to return the object. 
	 * @author chanteltrainer
	 * @param theFileName
	 * @param theObject
	 */
	public static void serialization(String theFilePath, Object theObject) {
	       try
	        {    
	            //Saving of object in a file 
	            FileOutputStream file = new FileOutputStream(theFilePath); 
	            ObjectOutputStream out = new ObjectOutputStream(file); 
	              
	            // Method for serialization of object 
	            out.writeObject(theObject); 
	              
	            out.close(); 
	            file.close(); 
	              
	            System.out.println("Object has been serialized"); 
	  
	        } 
	          
	        catch(IOException ex) 
	        { 
	            System.out.println("Serialization Failed."); 
	            ex.printStackTrace();
	        } 
	}
}
