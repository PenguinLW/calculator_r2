package com.released2.calculation;

public class NumberSystemOperation {
	//
	public static String binary(String[] ns){
		String numb = "";
		switch(ns[0]){
		case "16":
            numb = "0b"+Integer.toBinaryString(    Integer.parseInt(   ns[1],16   ) );
			break;
		case "2":
            numb = "0b"+Integer.toBinaryString(    Integer.parseInt(   ns[1],2   ) );
			break;
		case "8":
	        numb = "0b"+Integer.toBinaryString(    Integer.parseInt(   ns[1],8   ) );
			break;
		case "10":
	        numb = "0b"+Integer.toBinaryString(    Integer.parseInt(   ns[1],10   ) );
			break;
		}
		return numb;
	}
	//
	public static String hex_a_decimal(String[] ns){
		String numb = "";
		switch(ns[0]){
		case "16":
            numb = "0x"+Integer.toHexString(    Integer.parseInt(   ns[1],16   ) );
			break;
		case "2":
            numb = "0x"+Integer.toHexString(    Integer.parseInt(   ns[1],2   ) );
			break;
		case "8":
	        numb = "0x"+Integer.toHexString(    Integer.parseInt(   ns[1],8   ) );
			break;
		case "10":
	        numb = "0x"+Integer.toHexString(    Integer.parseInt(   ns[1],10   ) );
			break;
		}
		return numb;
	}
	//
	public static String octal(String[] ns){
		String numb = "";
		switch(ns[0]){
		case "16":
            numb = "0"+Integer.toOctalString(    Integer.parseInt(   ns[1],16   ) );
			break;
		case "2":
            numb = "0"+Integer.toOctalString(    Integer.parseInt(   ns[1],2   ) );
			break;
		case "8":
	        numb = "0"+Integer.toOctalString(    Integer.parseInt(   ns[1],8   ) );
			break;
		case "10":
	        numb = "0"+Integer.toOctalString(    Integer.parseInt(   ns[1],10   ) );
			break;
		}
		return numb;
	}
	//
	public static String decimal(String[] ns){
		String numb = "";
		switch(ns[0]){
		case "16":
            numb = Integer.toString(    Integer.parseInt(   ns[1],16   ) );
			break;
		case "2":
            numb = Integer.toString(    Integer.parseInt(   ns[1],2   ) );
			break;
		case "8":
	        numb = Integer.toString(    Integer.parseInt(   ns[1],8   ) );
			break;
		case "10":
	        numb = Integer.toString(    Integer.parseInt(   ns[1],10   ) );
			break;
		}
		return numb;
	}
	public static String[] detectNS(String B){
		String[] ns = new String[2];
		if (B.contains("x")){
			ns[0] = "16";
			ns[1] = B.replaceFirst("0x", "");
           return ns;
        }
        else if (B.contains("b")){
        	ns[0] = "2";
			ns[1] = B.replaceFirst("0b", "");
           return ns;
            }
        else if(B.charAt(0)=='0' && (!B.contains("b") && !B.contains("x")) ){
        	ns[0] = "8";
			ns[1] = B.replaceFirst("0", "");
           return ns;
        }
        else{
        	ns[0] = "10";
        	ns[1] = B;
        	return ns;
        }
	}
}
