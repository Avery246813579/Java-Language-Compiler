package com.averydurrant.language;

public class TypeWhole extends DataType{
	private Type type;
	private Number data;
	
	//Make replacement for temparily using long
	public TypeWhole(Number data, Type type) {
		super(VariableType.WHOLE);
		
		this.data = data;
		this.type = type;
	}
	
	public TypeWhole(Number data){
		super(VariableType.WHOLE);
		
		assign(data);
	}
	
	public void assign(Number data){
		long longValue = data.longValue();
		
		if (longValue < Short.MAX_VALUE && longValue > Short.MIN_VALUE) {
			type = TypeWhole.Type.SHORT;
		} else if (longValue < Integer.MAX_VALUE && longValue > Integer.MIN_VALUE) {
			type = TypeWhole.Type.INTEGER;
		} else {
			type = TypeWhole.Type.LONG;
		}
	}

	protected Variable increment(DataType theIncrement) {
		if(theIncrement instanceof TypeWhole){
			TypeWhole toIncrement = (TypeWhole) theIncrement;
			
			if(toIncrement.type == Type.SHORT){
				if(type == Type.SHORT){
					return new Variable(toIncrement.data.shortValue() + data.shortValue());
				}else if(type == Type.INTEGER){
					return new Variable(toIncrement.data.shortValue() + data.intValue());
				}else{
					return new Variable(toIncrement.data.shortValue() + data.longValue());
				}
			}else if(toIncrement.type == Type.INTEGER){
				if(type == Type.SHORT){
					return new Variable(toIncrement.data.intValue() + data.shortValue());
				}else if(type == Type.INTEGER){
					return new Variable(toIncrement.data.intValue() + data.intValue());
				}else{
					return new Variable(toIncrement.data.intValue() + data.longValue());
				}
			}else{
				if(type == Type.SHORT){
					return new Variable(toIncrement.data.longValue() + data.shortValue());
				}else if(type == Type.INTEGER){
					return new Variable(toIncrement.data.longValue() + data.intValue());
				}else{
					return new Variable(toIncrement.data.longValue() + data.longValue());
				}
			}
		}else if(theIncrement instanceof TypeFloat){
			TypeFloat toIncrement = (TypeFloat) theIncrement;
			
			if(toIncrement.getType() == TypeFloat.Type.FLOAT){
				if(type == Type.SHORT){
					return new Variable(toIncrement.getData().floatValue() + data.shortValue());
				}else if(type == Type.INTEGER){
					return new Variable(toIncrement.getData().floatValue() + data.intValue());
				}else{
					return new Variable(toIncrement.getData().floatValue() + data.longValue());
				}
			}else{
				if(type == Type.SHORT){
					return new Variable(toIncrement.getData().doubleValue() + data.shortValue());
				}else if(type == Type.INTEGER){
					return new Variable(toIncrement.getData().doubleValue() + data.intValue());
				}else{
					return new Variable(toIncrement.getData().doubleValue() + data.longValue());
				}
			}
		}else if(theIncrement instanceof TypeBoolean){
			Errors.throwError("Can't concatinate Whole Number and Boolean");
		}else if(theIncrement instanceof TypeString){
			TypeString character = (TypeString) theIncrement;

			if(type == Type.SHORT){
				return new Variable(data.shortValue() + character.getData());
			}else if(type == Type.INTEGER){
				return new Variable(data.intValue() + character.getData());
			}else{
				return new Variable(data.longValue() + character.getData());
			}
		}
		
		return null;
	}
	
	@Override
	protected Variable decrement(DataType theIncrement) {
		if(theIncrement instanceof TypeWhole){
			TypeWhole toIncrement = (TypeWhole) theIncrement;
			
			if(toIncrement.type == Type.SHORT){
				if(type == Type.SHORT){
					return new Variable(data.shortValue() - toIncrement.data.shortValue());
				}else if(type == Type.INTEGER){
					return new Variable(data.intValue() - toIncrement.data.shortValue());
				}else{
					return new Variable(data.longValue() - toIncrement.data.shortValue());
				}
			}else if(toIncrement.type == Type.INTEGER){
				if(type == Type.SHORT){
					return new Variable(data.shortValue() - toIncrement.data.intValue());
				}else if(type == Type.INTEGER){
					return new Variable(data.intValue() - toIncrement.data.intValue());
				}else{
					return new Variable(data.longValue() - toIncrement.data.intValue());
				}
			}else{
				if(type == Type.SHORT){
					return new Variable(data.shortValue() - toIncrement.data.longValue());
				}else if(type == Type.INTEGER){
					return new Variable(data.intValue() - toIncrement.data.longValue());
				}else{
					return new Variable(data.longValue() - toIncrement.data.longValue());
				}
			}
		}else if(theIncrement instanceof TypeFloat){
			TypeFloat toIncrement = (TypeFloat) theIncrement;
			
			if(toIncrement.getType() == TypeFloat.Type.FLOAT){
				if(type == Type.SHORT){
					return new Variable(data.shortValue() - toIncrement.getData().floatValue());
				}else if(type == Type.INTEGER){
					return new Variable(data.intValue() - toIncrement.getData().floatValue());
				}else{
					return new Variable(data.longValue() - toIncrement.getData().floatValue());
				}
			}else{
				if(type == Type.SHORT){
					return new Variable(data.shortValue() - toIncrement.getData().doubleValue());
				}else if(type == Type.INTEGER){
					return new Variable(data.intValue() - toIncrement.getData().doubleValue());
				}else{
					return new Variable(data.longValue() - toIncrement.getData().doubleValue());
				}
			}
		}else if(theIncrement instanceof TypeBoolean){
			Errors.throwError("Can't substract Whole Number and Boolean");
		}else if(theIncrement instanceof TypeString){
			Errors.throwError("Can't substract Whole Number and String");
		}
		
		return null;
	}
	
	@Override
	protected Variable multiply(DataType theIncrement) {
		if(theIncrement instanceof TypeWhole){
			TypeWhole toIncrement = (TypeWhole) theIncrement;
			
			if(toIncrement.type == Type.SHORT){
				if(type == Type.SHORT){
					return new Variable(data.shortValue() * toIncrement.data.shortValue());
				}else if(type == Type.INTEGER){
					return new Variable(data.intValue() * toIncrement.data.shortValue());
				}else{
					return new Variable(data.longValue() * toIncrement.data.shortValue());
				}
			}else if(toIncrement.type == Type.INTEGER){
				if(type == Type.SHORT){
					return new Variable(data.shortValue() * toIncrement.data.intValue());
				}else if(type == Type.INTEGER){
					return new Variable(data.intValue() * toIncrement.data.intValue());
				}else{
					return new Variable(data.longValue() * toIncrement.data.intValue());
				}
			}else{
				if(type == Type.SHORT){
					return new Variable(data.shortValue() * toIncrement.data.longValue());
				}else if(type == Type.INTEGER){
					return new Variable(data.intValue() * toIncrement.data.longValue());
				}else{
					return new Variable(data.longValue() * toIncrement.data.longValue());
				}
			}
		}else if(theIncrement instanceof TypeFloat){
			TypeFloat toIncrement = (TypeFloat) theIncrement;
			
			if(toIncrement.getType() == TypeFloat.Type.FLOAT){
				if(type == Type.SHORT){
					return new Variable(data.shortValue() * toIncrement.getData().floatValue());
				}else if(type == Type.INTEGER){
					return new Variable(data.intValue() * toIncrement.getData().floatValue());
				}else{
					return new Variable(data.longValue() * toIncrement.getData().floatValue());
				}
			}else{
				if(type == Type.SHORT){
					return new Variable(data.shortValue() * toIncrement.getData().doubleValue());
				}else if(type == Type.INTEGER){
					return new Variable(data.intValue() * toIncrement.getData().doubleValue());
				}else{
					return new Variable(data.longValue() * toIncrement.getData().doubleValue());
				}
			}
		}else if(theIncrement instanceof TypeBoolean){
			Errors.throwError("Can't multiply Whole Number and Boolean");
		}else if(theIncrement instanceof TypeString){
			Errors.throwError("Can't multiply Whole Number and String");
		}
		
		return null;
	}

	@Override
	protected Variable divide(DataType theIncrement) {
		if(theIncrement instanceof TypeWhole){
			TypeWhole toIncrement = (TypeWhole) theIncrement;
			
			if(toIncrement.type == Type.SHORT){
				if(type == Type.SHORT){
					return new Variable(data.shortValue() / toIncrement.data.shortValue());
				}else if(type == Type.INTEGER){
					return new Variable(data.intValue() / toIncrement.data.shortValue());
				}else{
					return new Variable(data.longValue() / toIncrement.data.shortValue());
				}
			}else if(toIncrement.type == Type.INTEGER){
				if(type == Type.SHORT){
					return new Variable(data.shortValue() / toIncrement.data.intValue());
				}else if(type == Type.INTEGER){
					return new Variable(data.intValue() / toIncrement.data.intValue());
				}else{
					return new Variable(data.longValue() / toIncrement.data.intValue());
				}
			}else{
				if(type == Type.SHORT){
					return new Variable(data.shortValue() / toIncrement.data.longValue());
				}else if(type == Type.INTEGER){
					return new Variable(data.intValue() / toIncrement.data.longValue());
				}else{
					return new Variable(data.longValue() / toIncrement.data.longValue());
				}
			}
		}else if(theIncrement instanceof TypeFloat){
			TypeFloat toIncrement = (TypeFloat) theIncrement;
			
			if(toIncrement.getType() == TypeFloat.Type.FLOAT){
				if(type == Type.SHORT){
					return new Variable(data.shortValue() / toIncrement.getData().floatValue());
				}else if(type == Type.INTEGER){
					return new Variable(data.intValue() / toIncrement.getData().floatValue());
				}else{
					return new Variable(data.longValue() / toIncrement.getData().floatValue());
				}
			}else{
				if(type == Type.SHORT){
					return new Variable(data.shortValue() / toIncrement.getData().doubleValue());
				}else if(type == Type.INTEGER){
					return new Variable(data.intValue() / toIncrement.getData().doubleValue());
				}else{
					return new Variable(data.longValue() / toIncrement.getData().doubleValue());
				}
			}
		}else if(theIncrement instanceof TypeBoolean){
			Errors.throwError("Can't divide Whole Number and Boolean");
		}else if(theIncrement instanceof TypeString){
			Errors.throwError("Can't divide Whole Number and String");
		}
		
		return null;
	}

	@Override
	protected Variable module(DataType theIncrement) {
		if(theIncrement instanceof TypeWhole){
			TypeWhole toIncrement = (TypeWhole) theIncrement;
			
			if(toIncrement.type == Type.SHORT){
				if(type == Type.SHORT){
					return new Variable(data.shortValue() % toIncrement.data.shortValue());
				}else if(type == Type.INTEGER){
					return new Variable(data.intValue() % toIncrement.data.shortValue());
				}else{
					return new Variable(data.longValue() % toIncrement.data.shortValue());
				}
			}else if(toIncrement.type == Type.INTEGER){
				if(type == Type.SHORT){
					return new Variable(data.shortValue() % toIncrement.data.intValue());
				}else if(type == Type.INTEGER){
					return new Variable(data.intValue() % toIncrement.data.intValue());
				}else{
					return new Variable(data.longValue() % toIncrement.data.intValue());
				}
			}else{
				if(type == Type.SHORT){
					return new Variable(data.shortValue() % toIncrement.data.longValue());
				}else if(type == Type.INTEGER){
					return new Variable(data.intValue() % toIncrement.data.longValue());
				}else{
					return new Variable(data.longValue() % toIncrement.data.longValue());
				}
			}
		}else if(theIncrement instanceof TypeFloat){
			TypeFloat toIncrement = (TypeFloat) theIncrement;
			
			if(toIncrement.getType() == TypeFloat.Type.FLOAT){
				if(type == Type.SHORT){
					return new Variable(data.shortValue() % toIncrement.getData().floatValue());
				}else if(type == Type.INTEGER){
					return new Variable(data.intValue() % toIncrement.getData().floatValue());
				}else{
					return new Variable(data.longValue() % toIncrement.getData().floatValue());
				}
			}else{
				if(type == Type.SHORT){
					return new Variable(data.shortValue() % toIncrement.getData().doubleValue());
				}else if(type == Type.INTEGER){
					return new Variable(data.intValue() % toIncrement.getData().doubleValue());
				}else{
					return new Variable(data.longValue() % toIncrement.getData().doubleValue());
				}
			}
		}else if(theIncrement instanceof TypeBoolean){
			Errors.throwError("Can't mod Whole Number and Boolean");
		}else if(theIncrement instanceof TypeString){
			Errors.throwError("Can't mod Whole Number and String");
		}
		
		return null;
	}
	
	public Number getData(){
		return data;
	}
	
	public Type getType(){
		return type;
	}
	
	public String toString(){
		return data + ": Whole Number (" + type + ")";
	}
	
	public enum Type{
		SHORT,
		INTEGER,
		LONG;
	}

	@Override
	protected String toPrint() {
		return data.toString();
	}
}
