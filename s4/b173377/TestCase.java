package s4.b173377; // Please modify to s4.Bnnnnnn, where nnnnnn is your student ID. 
import java.lang.*;
import s4.specification.*;

/*
interface FrequencerInterface {     // This interface provides the design for frequency counter.
    void setTarget(byte[]  target); // set the data to search.
    void setSpace(byte[]  space);  // set the data to be searched target from.
    int frequency(); //It return -1, when TARGET is not set or TARGET's length is zero
                    //Otherwise, it return 0, when SPACE is not set or Space's length is zero
                    //Otherwise, get the frequency of TAGET in SPACE
    int subByteFrequency(int start, int end);
    // get the frequency of subByte of taget, i.e target[start], taget[start+1], ... , target[end-1].
    // For the incorrect value of START or END, the behavior is undefined.
}
*/

/*
package s4.specification;
public interface InformationEstimatorInterface{
    void setTarget(byte target[]); // set the data for computing the information quantities
    void setSpace(byte space[]); // set data for sample space to computer probability
    double estimation(); // It returns 0.0 when the target is not set or Target's length is zero;
// It returns Double.MAX_VALUE, when the true value is infinite, or space is not set.
// The behavior is undefined, if the true value is finete but larger than Double.MAX_VALUE.
// Note that this happens only when the space is unreasonably large. We will encounter other problem anyway.
// Otherwise, estimation of information quantity, 
}                        
*/


public class TestCase {
    public static void main(String[] args) {
	try {
        FrequencerInterface  myObject;
        int freq;
	    System.out.println("checking s4.b173377.Frequencer");
	    
        System.out.println("returns frequency of H in hi ho hi ho ");
        myObject = new s4.b173377.Frequencer();  //get H frequency
        myObject.setSpace("Hi Ho Hi Ho".getBytes());
        myObject.setTarget("H".getBytes());
        freq = myObject.frequency();
        System.out.print("\"H\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");
        if(4 == freq) { System.out.println("OK\n"); } else {System.out.println("WRONG"); }
    }
    catch(Exception e) {
        System.out.println("Exception occurred: STOP");
    }
    try{
        FrequencerInterface  myObject2;
        int freq2;
        System.out.println("checking when target is not set");
        myObject2 = new s4.b173377.Frequencer(); //returns -1 when Target is not set
        myObject2.setSpace("Hi Ho Hi Ho".getBytes());
        //myObject2.setTarget("".getBytes());
        freq2 = myObject2.frequency();
        System.out.println("Appears "+freq2+" times. ");
        if(-1 == freq2) { System.out.println("returns -1 when target is not set\n"); } else {System.out.println("WRONG"); }
    }
    catch(Exception e) {
        System.out.println("Exception occurred: STOP");
    }
    try{
        FrequencerInterface  myObject3;
        int freq3;
        System.out.println("checking when target length is 0");
        myObject3 = new s4.b173377.Frequencer(); //returns -1 when Target's length is 0
        myObject3.setSpace("Hi Ho Hi Ho".getBytes());
        myObject3.setTarget(null);
        freq3 = myObject3.frequency();
        System.out.println("Appears "+freq3+" times. ");
        if(-1 == freq3) { System.out.println("returns -1 when target's length is 0\n"); } else {System.out.println("WRONG"); }
    }
    catch(Exception e) {
        System.out.println("Exception occurred: STOP");
    }
    try{
        FrequencerInterface  myObject4;
        int freq4;
        System.out.println("checking when space is not set");
        myObject4 = new s4.b173377.Frequencer(); //returns 0 when Space is not set
        //myObject4.setSpace("".getBytes());
        myObject4.setTarget("H".getBytes());
        freq4 = myObject4.frequency();
        System.out.println("Appears "+freq4+" times. ");
        if(0 == freq4) { System.out.println("returns 0 when space is not set\n"); } else {System.out.println("WRONG"); }
    }
    catch(Exception e) {
        System.out.println("Exception occurred: STOP");
    }
    try{
        FrequencerInterface  myObject5;
        int freq5;
        System.out.println("checking when space length is 0");
        myObject5 = new s4.b173377.Frequencer(); //returns 0 when Space's length is 0
        myObject5.setSpace(null);
        myObject5.setTarget("H".getBytes());
        freq5 = myObject5.frequency();
        System.out.println("Appears "+freq5+" times. ");
        if(0 == freq5) { System.out.println("returns 0 when Space's length is 0\n"); } else {System.out.println("WRONG"); }
    }
    catch(Exception e) {
        System.out.println("Exception occurred: STOP");
    }
    try{
        FrequencerInterface  myObject6;
        int freq6;
        System.out.println("checking when target is not available");
        myObject6 = new s4.b173377.Frequencer(); //returns frequency of a
        myObject6.setSpace("Hi Ho Hi Ho".getBytes());
        myObject6.setTarget("a".getBytes());
        freq6 = myObject6.frequency();
        System.out.println("\"a \" in \"Hi Ho Hi Ho\" appears "+freq6+" times. ");
        if(0 == freq6) { System.out.println("returns frequency of a in hi ho hi ho \n"); } else {System.out.println("WRONG"); }
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

	try {
        InformationEstimatorInterface myObject;
        double value;
        double inf = Double.POSITIVE_INFINITY;
	    System.out.println("checking s4.b173377.InformationEstimator");
	    
        myObject = new s4.b173377.InformationEstimator();
        myObject.setSpace("3210321001230123".getBytes());
        
        System.out.println("Returns estimation of information quantity ");
        myObject.setTarget("0".getBytes());
        value = myObject.estimation();
        System.out.println(">0 "+value);
        
        myObject.setTarget("01".getBytes());
        value = myObject.estimation();
        System.out.println(">01 "+value);
        
        myObject.setTarget("0123".getBytes());
        value = myObject.estimation();
        System.out.println(">0123 "+value);
        
        myObject.setTarget("00".getBytes());
        value = myObject.estimation();
        System.out.println(">00 "+value);
    }
    catch(Exception e) {
        System.out.println("Exception occurred: STOP");
    }
    try{
        InformationEstimatorInterface myObject2;
        double value2;
        double inf = Double.POSITIVE_INFINITY;
        System.out.println("Returns estimation of information quantity when target is not set ");
        myObject2 = new s4.b173377.InformationEstimator(); //returns 0 when target not set
        myObject2.setSpace("3210321001230123".getBytes());
        //myObject2.setTarget("1".getBytes());
        value2 = myObject2.estimation();
        System.out.println("> "+value2);
        if(0 == value2) { System.out.println("returns 0 when target not set \n"); } else {System.out.println("WRONG"); }
    }
    catch(Exception e) {
        System.out.println("Exception occurred: STOP");
    }
    try{
        InformationEstimatorInterface myObject3;
        double value3;
        double inf = Double.POSITIVE_INFINITY;
        System.out.println("Returns estimation of information quantity when target length = 0 ");
        myObject3 = new s4.b173377.InformationEstimator(); //returns 0 when target not set
        myObject3.setSpace("3210321001230123".getBytes());
        myObject3.setTarget(null);
        value3 = myObject3.estimation();
        System.out.println("> "+value3);
        if(0 == value3) { System.out.println("returns target's length is 0 \n"); } else {System.out.println("WRONG"); }
    }
    catch(Exception e) {
        System.out.println("Exception occurred: STOP");
    }
    try{
        InformationEstimatorInterface myObject4;
        double value4;
        double inf = Double.POSITIVE_INFINITY;
        System.out.println("Returns estimation of information quantity when space is not set");
        myObject4 = new s4.b173377.InformationEstimator(); //returns double.max_value when space not set
        //myObject4.setSpace("3210321001230123".getBytes());
        myObject4.setTarget("2".getBytes());
        value4 = myObject4.estimation();
        System.out.println("> "+value4);
        if(Double.MAX_VALUE == value4) { System.out.println("returns Double max value when space not set \n"); } else {System.out.println("WRONG"); }
    }
    catch(Exception e) {
        System.out.println("Exception occurred: STOP");
    }
    try{
        InformationEstimatorInterface myObject5;
        double value5;
        double inf = Double.POSITIVE_INFINITY;
        System.out.println("Returns estimation of information quantity when space is infinite ");
        myObject5 = new s4.b173377.InformationEstimator(); //returns double.max_value when space is infinite
        myObject5.setSpace("qwertyuioasdfghzxcghjasgdnqwbndcxkzjbcnmqwebhjagxzbcnmq bsjxbcjkmnbsdqvsajhdgvhjwavenqsavbdnqbwvebdnsavdbnavsdnasdasdasdadqwsacdqw".getBytes());
        myObject5.setTarget("2".getBytes());
        value5 = myObject5.estimation();
        System.out.println("> "+value5);
        if(Double.MAX_VALUE == value5) { System.out.println("returns Double max value when space is infinite \n"); } else {System.out.println("WRONG"); }
    }
    catch(Exception e) {
        System.out.println("Exception occurred: STOP");
    }
    try{
        InformationEstimatorInterface myObject6;
        double value6;
        double inf = Double.POSITIVE_INFINITY;
        System.out.println("Returns estimation of information quantity when target is not available ");
        myObject6 = new s4.b173377.InformationEstimator(); //returns estimation of information quantity
        myObject6.setSpace("3210321001230123".getBytes());
        myObject6.setTarget("4".getBytes());
        value6 = myObject6.estimation();
        System.out.println(">4 "+value6);
        if(Double.MAX_VALUE == value6) { System.out.println("Returns estimation of information quantity (infinite)\n"); } else {System.out.println("WRONG"); }
        
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

    }
}	    
	    
