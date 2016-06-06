package me.averydurrant.compiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodeSpace {
	private Map<String, Member> variables = new HashMap<String, Member>();
	private List<Method> methods = new ArrayList<Method>();
	private CodeSpace codeSpace;

	public CodeSpace() {
	}

	public CodeSpace(CodeSpace codeSpace) {
		this.codeSpace = codeSpace;
	}

	public String toString() {
		return variables.toString();
	}
	
	public void evaluateSection(String string){
		
	}

	public boolean evaluateExpression(String expression) {
		if (expression.contains("||")) {
			String[] args = expression.split("||");

			for(String arg : args){
				if(evaluateExpression(arg.trim())){
					return true;
				}
			}
		} else if (expression.contains("&&")) {
			String[] args = expression.split("&&");

			for(String arg : args){
				if(!evaluateExpression(arg.trim())){
					return false;
				}
			}
			
			return true;
		} else if (expression.contains("==")) {
			String[] args = expression.split("==");

			if (evaluateExpression(args[0].trim(), args[1].trim(), "==")) {
				return true;
			}
		} else if (expression.contains(">=")) {
			String[] args = expression.split(">=");

			if (evaluateExpression(args[0].trim(), args[1].trim(), ">=")) {
				return true;
			}
		} else if (expression.contains(">")) {
			String[] args = expression.split(">");

			if (evaluateExpression(args[0].trim(), args[1].trim(), ">")) {
				return true;
			}
		} else if (expression.contains("<=")) {
			String[] args = expression.split("<=");

			if (evaluateExpression(args[0].trim(), args[1].trim(), "<=")) {
				return true;
			}
		} else if (expression.contains("<")) {
			String[] args = expression.split("<");

			if (evaluateExpression(args[0].trim(), args[1].trim(), "<")) {
				return true;
			}
		}  else if (expression.equals("false")) {
			return false;
		} else if (expression.equals("true")) {
			return true;
		} else {
			throw new Error("Statement error");
		}

		return false;
	}

	public boolean evaluateExpression(String one, String two, String operand) {
		Member memberOne = null;
		Member memberTwo = null;
		
		if (getVariables().containsKey(one)) {
			memberOne = getVariables().get(one);
		} else {
			memberOne = Member.findMember(one);
		}

		if (getVariables().containsKey(two)) {
			memberTwo = getVariables().get(two);
		} else {
			memberTwo = Member.findMember(two);
		}

		switch (operand) {
		case "==":
			if (memberOne.compareTo(memberTwo) == 0) {
				return true;
			}

			break;
		case ">":
			if (memberOne.compareTo(memberTwo) > 0) {
				return true;
			}

			break;
		case ">=":
			if (memberOne.compareTo(memberTwo) >= 0) {
				return true;
			}

			break;
		case "<":
			if (memberOne.compareTo(memberTwo) < 0) {
				return true;
			}

			break;
		case "<=":
			if (memberOne.compareTo(memberTwo) <= 0) {
				return true;
			}

			break;
		default:
			return false;
		}

		return false;
	}

	public Map<String, Member> getVariables() {
		if (codeSpace == null) {
			return variables;
		}

		Map<String, Member> combinedVariables = new HashMap<String, Member>();
		for(String keys : codeSpace.getVariables().keySet()){
			combinedVariables.put(keys, codeSpace.getVariables().get(keys));
		}
		
		for (String keys : variables.keySet()) {
			combinedVariables.put(keys, variables.get(keys));
		}

		return combinedVariables;
	}
	
	public void addVariable(String name, Member member){
		variables.put(name, member);
	}
	
	public Method findMethod(String name){
		for(Method method : methods){
			if(method.getName().equals(name)){
				return method;
			}
		}
		
		return null;
	}
	
	public void addMethods(Method method){
		methods.add(method);
	}
	
	public List<Method> getMethods(){
		return methods;
	}
}
