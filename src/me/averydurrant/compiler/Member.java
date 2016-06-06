package me.averydurrant.compiler;

/* A member that is used to derive variables */
public abstract class Member {
	private String[] keywords;
	protected Object data;
	private String name;

	/** Creates a Member/Variable with a name and it’s respected keyword **/
	public Member(String name, String[] keywords) {
		this.keywords = keywords;
		this.name = name;
	}

	public String toString() {
		if (data != null) {
			return name + ": " + data;
		} else {
			return "Undefined " + name;
		}
	}

	public abstract String toData();

	/** Assigns the value of the member **/
	public abstract void assign(Object object);

	/** Increments and returns the new value **/
	public abstract void increment(Object object);

	public abstract void increment();

	/** Decrements and returns the new value **/
	public abstract void decrement(Object object);

	public abstract void decrement();

	/** Modulus the object and returns the new value **/
	public abstract void modulus(Object object);

	/** Divides the object and returns the new value **/
	public abstract void divide(Object object);

	/** Multiplies the object and returns the new value **/
	public abstract void mutliply(Object object);

	/**
	 * Compares the object to another. Returns 0 if the arg object is equal.
	 * Less than 0 if the object is less than arg. Returns > 0 if the object is
	 * more than arg
	 **/
	public abstract int compareTo(Object object);
	
	public static Member findMember(Object object){
		if(Integer.isType(object)){
			return new Integer(object);
		}
		
		return null;
	}
}
