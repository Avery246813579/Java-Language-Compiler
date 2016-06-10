package me.averydurrant.compiler.members;

public class Integer extends Member {
	public Integer() {
		super("Integer", new String[] { "int" });
	}

	public Integer(Object data) {
		super("Integer", new String[] { "int" });

		assign(data);
	}

	@Override
	public void assign(Object object) {
		try {
			if(object instanceof java.lang.Integer){
				this.data = object;
				
				return;
			}
			
			this.data = java.lang.Integer.parseInt((String) object);
		} catch (Exception ex) {
			throw new Error("Error assigning integer value to " + object);
		}
	}

	@Override
	public void increment(Object object) {

	}

	@Override
	public void increment() {

	}

	@Override
	public void decrement(Object object) {

	}

	@Override
	public void decrement() {

	}

	@Override
	public void modulus(Object object) {

	}

	@Override
	public void divide(Object object) {

	}

	@Override
	public void mutliply(Object object) {

	}

	@Override
	public int compareTo(Object object) {
		if (object instanceof Integer) {
			Integer integer = (Integer) object;

			if ((int) data < (int) integer.data) {
				return -1;
			} else if (data == integer.data) {
				return 0;
			} else {
				return 1;
			}
		} else if (isType(object)) {
			Integer integer = new Integer(object);

			if ((int) data < (int) integer.data) {
				return -1;
			} else if (data == integer.data) {
				return 0;
			} else {
				return 1;
			}
		} else {
			throw new Error("Type miss match exception");
		}
	}

	public boolean isType(Object object) {
		try {
			if (object instanceof java.lang.Integer) {
				return true;
			} else {
				java.lang.Integer.parseInt((String) object);
			}

			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public String toData() {
		return java.lang.Integer.toString((int) data);
	}

	@Override
	public Object concatenate(Object object) {
		int data = (int) this.data;

		Members member = null;
		if (object instanceof Member) {
			if (object instanceof Integer) {
				Integer integer = (Integer) object;

				object = integer.toData();
				member = Members.INTEGER;
			} else if (object instanceof _String) {
				_String string = (_String) object;

				object = string.toData();
				member = Members.STRING;
			}
		} else {
			for (Members members : Members.values()) {
				if (members.getMember().isType(object)) {
					member = members;
					break;
				}
			}
		}

		if (member == null) {
			throw new Error("Could not concatenate String");
		}

		switch (member) {
		case STRING:
			throw new Error("Could not concatenate Integer with a String");
		case INTEGER:
			data += java.lang.Integer.parseInt((String) object);
		}

		return data;
	}
}
