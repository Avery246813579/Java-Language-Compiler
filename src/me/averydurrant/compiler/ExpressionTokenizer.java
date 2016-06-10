package me.averydurrant.compiler;

/**
 * Site Textbook
 */
public class ExpressionTokenizer {
	private String input;
	private int start, end;
	private CodeSpace codeSpace;

	public ExpressionTokenizer(String anInput, CodeSpace codeSpace) {
		input = anInput;
		nextToken();

		this.codeSpace = codeSpace;
	}

	public String peekToken() {
		if (start >= input.length()) {
			return null;
		} else {
			return input.substring(start, end);
		}
	}

	public String nextToken() {
		String r = peekToken();
		start = end;
		if (start >= input.length())
			return r;
		if (Character.isDigit(input.charAt(start)) || input.charAt(end) == '.' || Character.isAlphabetic(end)) {
			end = start + 1;
			while (end < input.length() && (Character.isDigit(input.charAt(end)) || input.charAt(end) == '.') || Character.isAlphabetic(end)) {
				end++;
			}
		} else {
			System.out.println("HERE: " + input.substring(start, end));
			end = start + 1;
		}

		return r;
	}
}
