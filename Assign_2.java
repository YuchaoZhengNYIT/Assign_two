// Run a class file in java 
  
// import java.io.*; 
//test
  
class Assign_2 { 



    public static void main(String[] args) 
    { 


    	// Java Assign_2 messageishere [2,3]
    	// Handle the input to message, depth_i, rtimes_i
    	String message = "";
    	Integer depth_i = 0;
    	Integer rtimes_i = 0;

    	try {
	    	message = args[0];
	    	String input_2 = args[1];
	    	String[] input_2s = input_2.split(",",2);
	        String depth = input_2s[0].substring(1,input_2s[0].length());
	        String rtimes = input_2s[1].substring(0,input_2s[1].length()-1);

	        depth_i = Integer.parseInt(depth);
	        rtimes_i = Integer.parseInt(rtimes);

	        System.out.println("--------------------");
	        System.out.println("message is " + message); 
	        System.out.println("depth is "   + depth_i);
	        System.out.println("rtimes is "  + rtimes_i);
	    }
	    catch(Exception e){
	    	System.out.println("Please input the correct format."); 
	    	System.out.println("example: Assign_2 \"message\" [4,23] "); 
	    	return;
	    }


	    // every loop to rail fence once
	    
	   	System.out.println("--------------------");


	    String beforeRailFence = message.replace(' ','@');
	    String finalText = "";

	    while(rtimes_i!=0){
	    	rtimes_i = rtimes_i-1;

	    	String afterRailFence = "";
	    	
	    	String[] result;
	    	result = split(beforeRailFence, depth_i);

	    	for(int i=0; i< result.length; i++){
	    		for(int j=0;j<result[i].length();j++){
	    			char thisOne = result[i].charAt(j);
	    			int pos = i + j * (i+1);
	    			afterRailFence = addChar(afterRailFence,thisOne,pos);
	    		}
	    	}

	    	beforeRailFence = afterRailFence;
	    	finalText = afterRailFence;
	    	System.out.println("This run text is :"+afterRailFence.replace('@',' '));
	    }
	    
	    System.out.println("FinalText is :"+ finalText.replace('@',' '));
	    System.out.println("--------------------");
    }

    //
    static String addChar(String str, char ch, int position) {
		return str.substring(0, position) + ch + str.substring(position);
	}

	// split a string to the same size
	static String[] split(String src, int len) {
	    String[] result = new String[(int)Math.ceil((double)src.length()/(double)len)];
	    for (int i=0; i<result.length; i++)
	        result[i] = src.substring(i*len, Math.min(src.length(), (i+1)*len));
	    return result;
	}
}