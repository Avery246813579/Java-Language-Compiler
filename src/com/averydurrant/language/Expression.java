package com.averydurrant.language;

public class Expression {
	private Variable alpha, beta;
	private Operation operation;
	
	public Expression(Variable alpha, Variable beta, Operation operation){
		this.alpha = alpha;
		this.beta = beta;
		this.operation = operation;
	}
	
	public static Variable evaluate(Variable alpha, Variable beta, Operation operation){
		if(operation == Operation.PLUS){
			return alpha.increament(beta);
		}else if(operation == Operation.MINUS){
			return alpha.decrement(beta);
		}else if(operation == Operation.TIMES){
			return alpha.multiply(beta);
		}else if(operation == Operation.DIVIDE){
			return alpha.divide(beta);
		}else if(operation == Operation.MODULO){
			return alpha.module(beta);
		}
		
		return null;
	}
}
