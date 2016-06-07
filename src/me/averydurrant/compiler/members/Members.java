package me.averydurrant.compiler.members;

public enum Members {
	INTEGER(new Integer()),
	STRING(new _String());
	
	private Member member;
	Members(Member member){
		this.member = member;
	}
	
	public Member getMember(){
		return member;
	}
}
