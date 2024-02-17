// CANTraceParser Class

import java.io.*;
import java.util.*;

public class CANTraceParser {

    /* Parse the Trace file and stores in the CANTrace Object */
    public CANTrace parseCANTrace(String traceFile) throws FileNotFoundException, InterruptedException {

        File file = new File(traceFile);      // Trace File
        Scanner scan = new Scanner(file);     // Scannner to scan Trace File

        CANTrace trace = new CANTrace();    

        // Parsing whole Trace File
        while (scan.hasNextLine()) {
            String curr_line = scan.nextLine();                                 // Stores read line as String
            List<String> tokens = new ArrayList<>();                            // Initializes List of tokens to store tokenized string
            StringTokenizer tokenizer = new StringTokenizer(curr_line, " ");    // Tokenize the String
            
            // Add whole line into list
            while (tokenizer.hasMoreElements()) {
                tokens.add(tokenizer.nextToken());
            }

            // Create new canframeA and canframeB objects to store parsed sensor values in appropriate objects
            CANFrameA cfa = new CANFrameA();      
            CANFrameB cfb = new CANFrameB();

            /* Parsing values of string tokens, manipulating it and
             then adding it to appropriate CANFrameA or CANFrameB objects */
            
            if (tokens.contains("0B41")) { 
                cfb.setTime_offset(Float.parseFloat(tokens.get(1)));
                cfb.setMsg_id(tokens.get(3));
                cfb.setMsg_data1(Math.round((0.01 * Integer.parseInt(tokens.get(5) + tokens.get(6), 16) - 327.68)*100.0)/100.0);
                cfb.setMsg_data2(Math.round((0.08 * (Integer.parseInt(tokens.get(9), 16) - 128))*100.0)/100.0);
                cfb.setMsg_data3(Math.round((0.08 * (Integer.parseInt(tokens.get(10), 16) - 128))*100.0)/100.0);
                
                // Add CANFrameB object to vector in trace object
                trace.getTrace().addElement(cfb);        

            } else if (tokens.contains("0018")) {
                cfa.setTime_offset(Float.parseFloat(tokens.get(1)));
                cfa.setMsg_id(tokens.get(3));
                String d1 = tokens.get(5) + tokens.get(6);
                double d2 = Integer.parseInt(d1, 16);
                d2 = 0.5*d2 - 2048;
                cfa.setMsg_data1(Math.round(d2*100.0)/100.0);

                // Add CANFrameA object to vector in trace object
                trace.getTrace().addElement(cfa);

            } else if (tokens.contains("0F7A")) {
                cfa.setTime_offset(Float.parseFloat(tokens.get(1)));
                cfa.setMsg_id(tokens.get(3));
                String d1 = tokens.get(5) + tokens.get(6);
                d1.substring(1);
                cfa.setMsg_data1(Math.round(0.1 * (Integer.parseInt(d1, 16))*100.0)/100.0);

                // Add CANFrameA object to vector in trace object
                trace.getTrace().addElement(cfa);
            }
        }
        return trace;         // Returns trace object
    }
}
