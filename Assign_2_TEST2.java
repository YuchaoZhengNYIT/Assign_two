// Run a class file in java 
  
// import java.io.*; 
//test
  
class Assign_2_TEST2 { 



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


	   



	    while(rtimes_i!=0){
	    	rtimes_i = rtimes_i-1;
	    	message = decode(message,depth_i);
	    }

	    System.out.println("plain is :"+message);
	    
	   
	    System.out.println("--------------------");
    }

    static String decode(String secret, int depth){
    	int length = secret.length();
    	String plain = "";
    	if(length<depth){
    		return secret;
    	}
    	else{
    		int depthTime = (length-1)/depth;
    		int residue = length - depthTime * depth;
    		// System.out.println("depthTime is :"+depthTime);
    		// System.out.println("residue is :"+residue);

    		
    		for(int i =0; i<=depthTime; i++){
				for(int j=0; j<=depth; j++){

					int ind = 0;
					if (j <= residue){
						ind = j*(depthTime+1)+i;
					}else{
						ind = j*(depthTime+1)+i+residue-j;
					}

					if(ind<length){
						// System.out.println("ind is :"+ind + "  ///  "+secret.charAt(ind));
						plain = plain + secret.charAt(ind);
					}	
    			}
    		}
    	}
    	return plain;
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