package me.averydurrant.compiler;

public class Integer extends Member{
	public Integer() {
		super("Integer", new String[]{"int"});
	}
	
	public Integer(Object data){
		super("Integer", new String[]{"int"});

		assign(data);
	}
	
	@Override
	public void assign(Object object) {
		try{
			this.data = java.lang.Integer.parseInt((String) object);
		}catch(Exception ex){
			throw new Error("Error assigning integer value to " + object);

		}
	}

	@Override
	public void increment(Object object) {
		
	}

	@Override
	public void increment() {
		
	}

	@Override
	public void decrement(Object object) {
		
	}

	@Override
	public void decrement() {
		
	}

	@Override
	public void modulus(Object object) {
		
	}

	@Override
	public void divide(Object object) {
		
	}

	@Override
	public void mutliply(Object object) {
		
	}
	
	@Override
	public int compareTo(Object object){
		if(object instanceof Integer){
			Integer integer = (Integer) object;
			
			if((int) data < (int) integer.data){
				return -1;
			}else if(data == integer.data){
				return 0;
			}else{
				return 1;
			}
		}else if(isType(object)){
			Integer integer = new Integer(object); 
			
			if((int) data < (int) integer.data){
				return -1;
			}else if(data == integer.data){
				return 0;
			}else{
				return 1;
			}
		}else{
			throw new Error("Type miss match exception");
		}
	}
	
	public static boolean isType(Object object){
		try{
			java.lang.Integer.parseInt((String) object);
			
			return true;
		}catch(Exception ex){
			return false;
		}
	}

	@Override
	public String toData() {
		return java.lang.Integer.toString((int) data);
	}
}
