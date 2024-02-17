// CANFrame B Class

// Stores frame data with 3 values
public class CANFrameB extends CANFrame {

    protected double msg_data1;        
    protected double msg_data2;        
    protected double msg_data3;        

    // Getter and Setter Methods

    public double getMsg_data1() {
        return msg_data1;
    }

    public void setMsg_data1(double msg_data1) {
        this.msg_data1 = msg_data1;
    }

    public double getMsg_data2() {
        return msg_data2;
    }

    public void setMsg_data2(double msg_data2) {
        this.msg_data2 = msg_data2;
    }

    public double getMsg_data3() {
        return msg_data3;
    }

    public void setMsg_data3(double msg_data3) {
        this.msg_data3 = msg_data3;
    }

}
