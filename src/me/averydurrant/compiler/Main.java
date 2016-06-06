package me.averydurrant.compiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public Main(){
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(new File("test.txt")));

			String fullText = "";
			String line = null;
			try {
				while((line = fileReader.readLine()) != null){
					fullText += line;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			parse(fullText);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void parse(String str){
		if(str.contains("{")){
			if(!str.contains("}")){
				throw new Error("No ending brace");
			}
			
			String body = str.substring(str.indexOf('{') + 1, str.lastIndexOf('}'));
			String before = str.substring(0, str.indexOf('{'));
			if(before.trim().length() < 1){
				throw new Error("Nothing before brace");
			}
			
			if(before.contains(";")){
				int lLoc = before.lastIndexOf(';');
				
				if(before.contains("}")){
					int pLoc = before.lastIndexOf('}');
					
					if(pLoc > lLoc){
						parseBody(before.substring(pLoc + 1), body);
					}else{
						parseBody(before.substring(lLoc + 1), body);
					}
				}else{
					parseBody(before.substring(lLoc + 1), body);
				}
			}else if(before.contains("}")){
				int pLoc = before.lastIndexOf('}');
				
				parseBody(before.substring(pLoc + 1), body);
			}else{
				parseBody(before, body);
			}
			
			str = str.substring(0, str.indexOf("{")) + str.substring(str.indexOf("}"));
		}
	}
	
	
	public void parseBody(String title, String body){
		System.out.println("Parsing Title: " + title);
		System.out.println("Parsing Body: " + body);
	}
	
	public void parseCodeSegments(String str){
	}
	
	
	public static void main(String[] args){
		new Main();
	}
}
