package com.averydurrant.language;

public class Evaluator {
	public Evaluator(String fullExpression) {
		System.out.println(evaluate(fullExpression));
	}

	public Variable evaluate(String fullExpression) {
		if (fullExpression.contains("(")) {
			if (fullExpression.contains(")")) {

			} else {
				Errors.throwError("Can't find Expressions closing brace");
			}
		} else if (fullExpression.contains("*") || fullExpression.contains("/") || fullExpression.contains("%")) {

		} else if (fullExpression.contains("+") || fullExpression.contains("-")) {
			return evaluateAS(fullExpression);
		} else {
			return new Variable(fullExpression);
		}

		return null;
	}

	public Variable evaluateAS(String fullExpression) {
		int firstPlus = fullExpression.indexOf('+');
		int firstMinus = fullExpression.indexOf('-');

		if(firstMinus == 0){
			firstMinus = fullExpression.substring(firstMinus + 1).indexOf("-");
		}
		
		System.out.println(fullExpression);
		if (firstMinus > firstPlus || firstMinus == -1) {
			String pre = fullExpression.substring(0, firstPlus).trim();
			String post = fullExpression.substring(firstPlus + 1).trim();

			if (post.contains("+") || post.contains("-")) {
				int secondPlus = post.indexOf("+");
				int secondMinus = post.indexOf("-");

				if(secondMinus == 0){
					secondMinus = post.substring(secondMinus + 1).indexOf("-");
				}
				
				if (secondMinus > secondPlus) {
					String middlePre = post.substring(0, secondPlus).trim();
					String middlePost = post.substring(secondPlus + 1).trim();

					System.out.println(pre + " __ " + middlePre);
					return evaluateAS(Expression.evaluate(findVariable(pre), findVariable(middlePre), Operation.PLUS).toPrint() + "+" + middlePost);
				} else {
					String middlePre = post.substring(0, secondMinus).trim();
					String middlePost = post.substring(secondMinus + 1).trim();

					return evaluateAS(Expression.evaluate(findVariable(pre), findVariable(middlePre), Operation.PLUS).toPrint() + "-" + middlePost);
				}
			} else {
				return Expression.evaluate(findVariable(pre), findVariable(post), Operation.PLUS);
			}
		} else {
			String pre = fullExpression.substring(0, firstMinus);
			String post = fullExpression.substring(firstMinus + 1).trim();

			if (post.contains("+") || post.contains("-")) {
				int secondPlus = post.indexOf("+");
				int secondMinus = post.indexOf("-");

				if (secondMinus > secondPlus) {
					String middlePre = post.substring(0, secondPlus).trim();
					String middlePost = post.substring(secondPlus + 1).trim();

					return evaluateAS(Expression.evaluate(findVariable(pre), findVariable(middlePre), Operation.MINUS).toPrint() + "+" + middlePost);
				} else {
					String middlePre = post.substring(0, secondMinus).trim();
					String middlePost = post.substring(secondMinus + 1).trim();

					return evaluateAS(Expression.evaluate(findVariable(pre), findVariable(middlePre), Operation.MINUS).toPrint() + "-" + middlePost);
				}
			} else {
				return Expression.evaluate(findVariable(pre), findVariable(post), Operation.MINUS);
			}
		}
	}

	public Variable findVariable(String context) {
		if(context.contains("\"") ){
			
		}else{
			if(context.contains(".")){
				return new Variable(Double.parseDouble(context));
			}else if(context.contains("true") || context.contains("false")){
				return new Variable(Boolean.parseBoolean(context));
			}else{
				return new Variable(Long.parseLong(context));
			}
		}
		
		return new Variable(context);
	}

	public static void main(String[] args) {
		new Evaluator("61 + 2 - 293 + 2 - 2");
	}
}
