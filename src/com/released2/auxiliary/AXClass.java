package com.released2.auxiliary;

public class AXClass {
	public static boolean detectTypeD(double numb){
		if( (numb - (int) numb) != 0)
			return true;
		else
			return false;
	}
	public static boolean detectTypeI(double numb){
		if(numb != 0) {
			if( (numb - (int) numb) == 0)
				return true;
			else
				return false;
		}
		else {
			return false;
		}
	}
}
