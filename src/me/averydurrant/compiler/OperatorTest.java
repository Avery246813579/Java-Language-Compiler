package me.averydurrant.compiler;

public class OperatorTest {
	public static void main(String[] args){
		Evaluator evaluator = new Evaluator("(3 + 5) * .6", null);
		System.out.println(evaluator.getExpressionValue());
	}
}
