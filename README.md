# Java-based ADAS

Implementing ADAS using the test vehicle's sensor data captured from the CAN bus. An initial data parser is created from the raw CAN data in the trace file for the simulation.

## Running the project

Install Gradle to run the project. Fork the project, go to the working directory, run the following command in the terminal and you are good to go!

```gradle
gradle run
```

## Files and Code Description

*CAN Frames Info.txt* file describes the CANFrames which are parsed.

*18 CANmessages.trc* is the trace file containing the raw CAN bus data.

**CANSimulation** is the main class that instantiates the traceParser and trace objects for parsing the CAN data present in the trace file and storing the decoded CAN frames messages in the trace object's vector collection.

**CANFrame** stores common data like Time and ID that corresponds to all the CAN frames. It also has a printCANFrame method which checks whether the canframe is an instance of canframeA or canframeB then retrieves the value in the appropriate object and displays it. This serves as better memory management as all frames don't have multiple sensor data.

**CANFrameA** is the child class of the CANFrame that stores a single value sensor data

**CANFrameB** is the child class of the CANFrame that stores three values as some CANframes have three sensor data in a single frame.

**CANTrace** Stores CANFrames in a Vector. In the future, it will be changed to TreeMap. It also has a method to print the whole vector.

**CANTraceParser** parses the trace file and stores data as appropriate CANFrameA or CANFrameB object in the trace object's vector.
