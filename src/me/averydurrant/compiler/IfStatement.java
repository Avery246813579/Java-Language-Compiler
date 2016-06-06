package me.averydurrant.compiler;

public class IfStatement extends Statement{
	private String body;
	
	public IfStatement(CodeSpace codeSpace, String condition, String body) {
		super(codeSpace, "if", condition);
	
		this.body = body;
		
		execute();
	}
	

	@Override
	public void onCondition() {
 		Parser.parseLines(codeSpace, body);
	}
}
