// CANFrame Class

public class CANFrame {
    private float time_offset;  // Time Offset
    private String msg_id;      // Message ID

    // print the single CANFrame
    public void printCANFrame(CANFrame cf) {

        /* checks if the canframe is instance of canframeA or canframeB
           then retrieves the value in appropriate object and displays it */ 
           
        if (cf instanceof CANFrameA) {
            CANFrameA cfa = (CANFrameA) cf;
            System.out.printf("%s\t%s\t%s\t\n", cfa.getTime_offset(), cfa.getMsg_id(),cfa.getMsg_data1());
        }
        else if (cf instanceof CANFrameB) {
            CANFrameB cfb = (CANFrameB) cf;
            System.out.printf("%s\t%s\t%s\t%s\t%s\n", cfb.getTime_offset(), cfb.getMsg_id(), cfb.getMsg_data1(), cfb.getMsg_data2(), cfb.getMsg_data3());
        }
        else{
            System.out.printf("%s\n", "Time: \t \t" + cf.getTime_offset());
            System.out.printf("%s\n", "Message: \t" + cf.getMsg_id());
        }
    }

    // Getter and Setter Methods

    public float getTime_offset() {
        return time_offset;
    }

    public void setTime_offset(float time_offset) {
        this.time_offset = time_offset;
    }

    public String getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(String msg_id) {
        this.msg_id = msg_id;
    }

}
