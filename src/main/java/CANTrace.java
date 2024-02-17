// CANTrace Class

import java.util.Vector;

public class CANTrace {

    // Time Index
    private Integer timeIndex = 0;
    // Java Collection of CANFrames
    private Vector<CANFrame> vec = new Vector();        
    
    public Vector<CANFrame> getTrace() {
        return vec;
    }

    // Print Trace method for Printing CANFrames
    public void printTrace(){
        for (int i = 0; i < vec.size(); i++){
            CANFrame cf = getNextMessage();
            try {
                cf.printCANFrame(cf);
            } catch (NullPointerException e) {
                resetNextMessage();
                System.out.println("Null");
            }   
        }
        // for (CANFrame canframes : vec) {
        //     canframes.printCANFrame(canframes);
        // }        
    }


    // getNextMessage method for getting CANFrame from Collection
    public CANFrame getNextMessage() {
        if (timeIndex == 0 ){
            this.timeIndex += 1;
            try {
                return vec.get(0);                
            } catch (ArrayIndexOutOfBoundsException e) {
                return null;
            }
        }
        else{
            this.timeIndex += 1;
            try {
                return vec.get(timeIndex);                
            } catch (ArrayIndexOutOfBoundsException e) {
                return null;
            }
        }
    }

    // resetNextMessage method for resetting iteration back to 0
    public void resetNextMessage() {
        this.timeIndex = 0;
    }

}
