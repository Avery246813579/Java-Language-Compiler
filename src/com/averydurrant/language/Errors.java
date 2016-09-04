package com.averydurrant.language;

public class Errors {
	public static void throwError(String message){
		System.out.println("ERROR >> " + message);
		System.exit(0);
	}
}
