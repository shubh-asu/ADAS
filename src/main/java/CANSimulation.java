// Main File with CANSimulation class

import java.io.FileNotFoundException;

public class CANSimulation {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        // create trace and traceParser objects
        CANTrace trace = new CANTrace();     
        CANTraceParser traceParser = new CANTraceParser();

        // Parse whole file and store it in trace object        
        trace = traceParser.parseCANTrace("./18 CANmessages.trc");

        // Title
        System.out.printf("Time \tID \tData1 \tData2 \tData3 \n");



        // Uncomment to prints whole decoded trace file stored in trace object
        trace.printTrace();


        
        // prints first 30 values of CANframes in the trace object
        int i;      
        for(i=0; i<30; i++){
            CANFrame cf = trace.getNextMessage();
            cf.printCANFrame(cf);
        }
        
        System.out.println("------------------------------------------------");
        System.out.println("Reset");
        System.out.println("------------------------------------------------");

        // Reset the Loop
        trace.resetNextMessage();

        // prints first 5 CANframes
        for(i=0; i<5; i++){
            CANFrame cf = trace.getNextMessage();
            cf.printCANFrame(cf);
        }
    }
}