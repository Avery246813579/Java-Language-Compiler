package com.averydurrant.language;

public class Variable {
	private DataType dataType;

	public Variable(Object data) {
		assign(data);
	}

	public void assign(Object data){
		if (data instanceof Number) {
			Number number = (Number) data;

			if(number instanceof Byte){
				System.out.println("I HAVE NO CLUE HOW TO HANDLE THIS BYTE");
			}else if (number instanceof Float || number instanceof Double) {
				double doubleValue = number.doubleValue();
				if(doubleValue - Math.floor(doubleValue) == 0){
					assign(number.longValue());
					return;
				}

				if(doubleValue < Float.MAX_VALUE && doubleValue > Float.MIN_VALUE){
					dataType = new TypeFloat(number, TypeFloat.Type.FLOAT);
				}else{
					dataType = new TypeFloat(number, TypeFloat.Type.DOUBLE);
				}
			} else if (number instanceof Short || number instanceof Integer || number instanceof Long) {
				long longValue = number.longValue();
				
				if (longValue < Short.MAX_VALUE && longValue > Short.MIN_VALUE) {
					dataType = new TypeWhole(number, TypeWhole.Type.SHORT);
				} else if (longValue < Integer.MAX_VALUE && longValue > Integer.MIN_VALUE) {
					dataType = new TypeWhole(number, TypeWhole.Type.INTEGER);
				} else {
					dataType = new TypeWhole(number, TypeWhole.Type.LONG);
				}
			}
		}else if(data instanceof Boolean){
			dataType = new TypeBoolean((boolean) data);
		}else if(data instanceof Character){
			dataType = new TypeString(Character.toString((char) data));
		}else if(data instanceof String){
			dataType = new TypeString((String) data);
		}else{
			Errors.throwError("Can't find data type");
		}
	}
	
	public Variable increament(Variable toIncrement){
		return dataType.increment(toIncrement.getData());
	}
	
	public Variable decrement(Variable toDecrement){
		return dataType.decrement(toDecrement.getData());
	}
	
	public Variable multiply(Variable toMultiply){
		return dataType.multiply(toMultiply.getData());
	}
	
	public Variable divide(Variable toDivide){
		return dataType.divide(toDivide.getData());
	}
	
	public Variable module(Variable toModule){
		return dataType.module(toModule.getData());
	}
	
	public String toString(){
		return dataType.toString();
	}
	
	private DataType getData(){
		return dataType; 
	}
	
	public String toPrint(){
		return dataType.toPrint();
	}
	
	public static void main(String[] args) {
		Variable one = new Variable("asfd");
		Variable two = new Variable(34);
		
		System.out.println(one.module(two));
	}
}
