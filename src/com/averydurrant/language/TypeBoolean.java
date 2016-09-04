package com.averydurrant.language;

public class TypeBoolean extends DataType{
	private boolean data;
	
	public TypeBoolean(boolean data) {
		super(VariableType.BOOLEAN);
		
		this.data = data;
	}
	
	public boolean getData(){
		return data;
	}
	
	public String toString(){
		return data + ": Boolean";
	}
	
	@Override
	protected Variable increment(DataType type) {
		Errors.throwError("Can't increment a boolean");
		
		return null;
	}

	@Override
	protected Variable decrement(DataType type) {
		Errors.throwError("Can't decrement a boolean");

		return null;
	}

	@Override
	protected Variable multiply(DataType type) {
		Errors.throwError("Can't multiply a boolean");

		return null;
	}

	@Override
	protected Variable divide(DataType type) {
		Errors.throwError("Can't divide a boolean");

		return null;
	}

	@Override
	protected Variable module(DataType type) {
		Errors.throwError("Can't module a boolean");

		return null;
	}

	@Override
	protected String toPrint() {
		return Boolean.toString(data);
	}
}
