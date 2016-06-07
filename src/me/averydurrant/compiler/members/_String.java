package me.averydurrant.compiler.members;

public class _String extends Member {

	public _String() {
		super("String", new String[] { "String", "string" });
	}

	public _String(Object object) {
		this();

		assign(object);
	}

	@Override
	public String toData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void assign(Object object) {
		try {
			this.data = (String) object;
		} catch (Exception ex) {
			throw new Error("Error assigning String");
		}
	}

	@Override
	public void increment(Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void increment() {
		// TODO Auto-generated method stub

	}

	@Override
	public void decrement(Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void decrement() {
		// TODO Auto-generated method stub

	}

	@Override
	public void modulus(Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void divide(Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mutliply(Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public int compareTo(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isType(Object object) {
		try {
			@SuppressWarnings("unused")
			String str = (String) object;

			return true;
		} catch (Exception ex) {
			return false;
		}

	}

	@Override
	public Object concatenate(Object object) {
		String data = (String) this.data;

		if (object instanceof Member) {
			Member member = (Member) object;
			
			data += member.toData();
		} else {
			data += object;
		}
		
		return data;
	}
}
