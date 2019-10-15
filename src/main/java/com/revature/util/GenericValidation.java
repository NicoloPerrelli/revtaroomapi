package com.revature.util;

public class GenericValidation {
	
	public static boolean isNumber(final String str) {
		
		if(str == null || str.length() == 0) return false;
		
		for(char letter: str.toCharArray() ) {
			if(!Character.isDigit(letter)) return false;
		}
		
		return true;
	}
	
}
