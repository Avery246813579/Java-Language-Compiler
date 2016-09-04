package com.averydurrant.language;

public class TypeString extends DataType {
	private String data;

	public TypeString(String data) {
		super(VariableType.STRING);

		this.data = data;
	}

	public String getData() {
		return data;
	}

	public String toString() {
		return data + ": String";
	}

	@Override
	protected Variable increment(DataType theIncrement) {
		if (theIncrement instanceof TypeWhole) {
			TypeWhole toIncrement = (TypeWhole) theIncrement;

			if (toIncrement.getType() == TypeWhole.Type.SHORT) {
				return new Variable(data + toIncrement.getData().shortValue());
			} else if (toIncrement.getType() == TypeWhole.Type.INTEGER) {
				return new Variable(data + toIncrement.getData().intValue());
			} else {
				return new Variable(data + toIncrement.getData().longValue());
			}
		} else if (theIncrement instanceof TypeFloat) {
			TypeFloat toIncrement = (TypeFloat) theIncrement;

			if (toIncrement.getType() == TypeFloat.Type.FLOAT) {
				return new Variable(data + toIncrement.getData().floatValue());
			} else {
				return new Variable(data + toIncrement.getData().doubleValue());
			}
		} else if (theIncrement instanceof TypeBoolean) {
			TypeBoolean typeBoolean = (TypeBoolean) theIncrement;
			
			return new Variable(data + typeBoolean.getData());
		} else if (theIncrement instanceof TypeString) {
			TypeString typeString = (TypeString) theIncrement;
			
			return new Variable(data + typeString.getData());
		}

		return null;
	}

	@Override
	protected Variable decrement(DataType theIncrement) {
		Errors.throwError("Can't decrement a String");
		
		return null;
	}

	@Override
	protected Variable multiply(DataType type) {
		Errors.throwError("Can't multiply a String");

		return null;
	}

	@Override
	protected Variable divide(DataType type) {
		Errors.throwError("Can't divide a String");

		return null;
	}

	@Override
	protected Variable module(DataType type) {
		Errors.throwError("Can't mod a String");

		return null;
	}

	@Override
	protected String toPrint() {
		return data;
	}
}
