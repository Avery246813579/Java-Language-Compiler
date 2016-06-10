package me.averydurrant.compiler;

/**
 * Site Textbook
 */
public class Evaluator {
	private ExpressionTokenizer tokenizer;

	/**
	 * Constructs an evaluator
	 * 
	 * @param anExpression
	 */
	public Evaluator(String anExpression, CodeSpace codeSpace) {
		tokenizer = new ExpressionTokenizer(anExpression.replaceAll(" ", ""), codeSpace);
	}

	public double getExpressionValue() {
		double value = getTermValue();
		boolean done = false;

		while (!done) {
			String next = tokenizer.peekToken();
			if ("+".equals(next) || "-".equals(next)) {
				tokenizer.nextToken();
				double value2 = getTermValue();
				if ("+".equals(next)) {
					value = value + value2;
				} else {
					value = value - value2;
				}
			} else {
				done = true;
			}
		}

		return value;
	}

	public double getTermValue() {
		double value = getFactorValue();
		boolean done = false;

		while (!done) {
			String next = tokenizer.peekToken();
			if ("*".equals(next) || "/".equals(next)) {
				tokenizer.nextToken();
				double value2 = getFactorValue();
				if ("*".equals(next)) {
					value = value * value2;
				} else {
					value = value / value2;
				}
			} else {
				done = true;
			}
		}

		return value;
	}

	public double getFactorValue() {
		double value = 0;

		String next = tokenizer.peekToken();
		if ("(".equals(next)) {
			tokenizer.nextToken();
			value = getExpressionValue();
			tokenizer.nextToken();
		} else {
			try {
				value = Double.parseDouble(tokenizer.nextToken());
			} catch (Exception ex) {
				throw new Error("Expression Error");
			}
		}

		return value;
	}
}
