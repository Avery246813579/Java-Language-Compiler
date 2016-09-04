package com.averydurrant.language;


public abstract class DataType {
	protected VariableType variableType;
	
	public DataType(VariableType variableType){
		this.variableType = variableType;
	}
	
	protected abstract Variable increment(DataType type);
	protected abstract Variable decrement(DataType type);
	protected abstract Variable multiply(DataType type);
	protected abstract Variable divide(DataType type);
	protected abstract Variable module(DataType type);
	protected abstract String toPrint();
}
