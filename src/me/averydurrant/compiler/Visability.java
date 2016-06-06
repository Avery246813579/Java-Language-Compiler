package me.averydurrant.compiler;

public enum Visability {
	PACKAGE,
	PRIVATE,
	PROTECTED,
	PUBLIC;
	
	public static Visability findVisability(String search){
		for(Visability value : Visability.values()){
			if(value.toString().toLowerCase().equals(search)){
				return value;
			}
		}
		
		return null;
	}
}
