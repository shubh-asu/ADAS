// CANFrame A Class

// Stores frame data with just 1 value
public class CANFrameA extends CANFrame{

    protected double msg_data1;        

    // Getter and Setter Methods

    public double getMsg_data1() {
        return msg_data1;
    }

    public void setMsg_data1(double msg_data1) {
        this.msg_data1 = msg_data1;
    }

}
