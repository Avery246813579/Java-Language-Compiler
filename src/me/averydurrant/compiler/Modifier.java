package me.averydurrant.compiler;

public enum Modifier {
	STATIC,
	ABSTRACT;
	
	public static Modifier findModifier(String modifier){
		for(Modifier methodModifier : Modifier.values()){
			if(methodModifier.toString().toLowerCase().equals(modifier)){
				return methodModifier;
			}
		}
		
		return null;
	}
}
