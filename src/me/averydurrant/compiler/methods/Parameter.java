package me.averydurrant.compiler.methods;

import me.averydurrant.compiler.members.Member;

public class Parameter {
	private Member member;
	private String name;
	
	public Parameter(String name, Member member){
		this.name = name;
		this.member = member;
	}
	
	public String getName(){
		return name;
	}
	
	public Member getMember(){
		return member;
	}
}
