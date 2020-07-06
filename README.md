# TCSS360-PRJ01
TCSS360 Group Project #01

Group project for TCSS360, a java implementation of the core software for the Wireless Vantage Pro2 Integrated Sensor Suite (ISS)
(Product number: 6322) manufactured by Davis Instruments. 

The Integrated Sensor Suite software collects data measurements from all attached sensors of the device according to the device specifications. Since our program is not connected to the sensors themselves, for testing purposes the ISS software generates it's own data randomly (within the scope of the data provided by the sensors). 
The individual sensors process that data take the raw binary data and process it into a human readable format. The ISS pulls all of that data together in a single source so it can be provided to the console or transmitted wirelessly.
The data generation occurs once every 30 seconds and the program itself runs for 5 minutes however these are variable windows. When a new batch of data is generated, it generates a new reading for each sensor at the same time. The software is able to serialize the data post processing so that it can be transmitted wirelessly to another device, where the data can be deserialized.
