package me.averydurrant.compiler;

public abstract class Statement {
	protected String condition, keyword;
	protected CodeSpace codeSpace;
	
	public Statement(CodeSpace codeSpace, String keyword, String condition){
		this.condition = condition;
		this.codeSpace = codeSpace;
		this.keyword = keyword;
	}

	public abstract void onCondition();
	
	public void execute(){
		if(codeSpace.evaluateExpression(condition)){
			onCondition();
		}
	}
}
