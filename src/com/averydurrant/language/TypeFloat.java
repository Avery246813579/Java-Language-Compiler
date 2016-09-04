package com.averydurrant.language;

public class TypeFloat extends DataType {
	private Number data;
	private Type type;

	public TypeFloat(Number data, Type type) {
		super(VariableType.FLOAT);

		this.data = data;
		this.type = type;
	}

	protected Variable increment(DataType theIncrement) {
		if (theIncrement instanceof TypeWhole) {
			TypeWhole toIncrement = (TypeWhole) theIncrement;

			if (toIncrement.getType() == TypeWhole.Type.SHORT) {
				if (type == Type.FLOAT) {
					return new Variable(toIncrement.getData().shortValue() + data.floatValue());
				} else {
					return new Variable(toIncrement.getData().shortValue() + data.doubleValue());
				}
			} else if (toIncrement.getType() == TypeWhole.Type.INTEGER) {
				if (type == Type.FLOAT) {
					return new Variable(toIncrement.getData().intValue() + data.floatValue());
				} else {
					return new Variable(toIncrement.getData().intValue() + data.doubleValue());
				}
			} else {
				if (type == Type.FLOAT) {
					return new Variable(toIncrement.getData().longValue() + data.floatValue());
				} else {
					return new Variable(toIncrement.getData().longValue() + data.doubleValue());
				}
			}
		} else if (theIncrement instanceof TypeFloat) {
			TypeFloat toIncrement = (TypeFloat) theIncrement;

			if (toIncrement.getType() == TypeFloat.Type.FLOAT) {
				if (type == Type.FLOAT) {
					return new Variable(toIncrement.getData().floatValue() + data.floatValue());
				} else {
					return new Variable(toIncrement.getData().floatValue() + data.doubleValue());
				}
			} else {
				if (type == Type.FLOAT) {
					return new Variable(toIncrement.getData().doubleValue() + data.floatValue());
				} else {
					return new Variable(toIncrement.getData().doubleValue() + data.doubleValue());
				}
			}
		} else if (theIncrement instanceof TypeBoolean) {
			Errors.throwError("Can't concatinate Float and Boolean");
		} else if (theIncrement instanceof TypeString) {
			TypeString character = (TypeString) theIncrement;

			if (type == Type.FLOAT) {
				return new Variable(data.floatValue() + character.getData());
			} else {
				return new Variable(data.doubleValue() + character.getData());
			}
		}

		return null;
	}

	@Override
	protected Variable decrement(DataType theIncrement) {
		if (theIncrement instanceof TypeWhole) {
			TypeWhole toIncrement = (TypeWhole) theIncrement;

			if (toIncrement.getType() == TypeWhole.Type.SHORT) {
				if (type == Type.FLOAT) {
					return new Variable(data.floatValue() - toIncrement.getData().shortValue());
				} else {
					return new Variable(data.doubleValue() - toIncrement.getData().shortValue());
				}
			} else if (toIncrement.getType() == TypeWhole.Type.INTEGER) {
				if (type == Type.FLOAT) {
					return new Variable(data.floatValue() - toIncrement.getData().intValue());
				} else {
					return new Variable(data.doubleValue() - toIncrement.getData().intValue());
				}
			} else {
				if (type == Type.FLOAT) {
					return new Variable(data.floatValue() - toIncrement.getData().longValue());
				} else {
					return new Variable(data.doubleValue() - toIncrement.getData().longValue());
				}
			}
		} else if (theIncrement instanceof TypeFloat) {
			TypeFloat toIncrement = (TypeFloat) theIncrement;

			if (toIncrement.getType() == TypeFloat.Type.FLOAT) {
				if (type == Type.FLOAT) {
					return new Variable(data.floatValue() - toIncrement.getData().floatValue());
				} else {
					return new Variable(data.doubleValue() - toIncrement.getData().floatValue());
				}
			} else {
				if (type == Type.FLOAT) {
					return new Variable(data.floatValue() - toIncrement.getData().doubleValue());
				} else {
					return new Variable(data.doubleValue() - toIncrement.getData().doubleValue());
				}
			}
		} else if (theIncrement instanceof TypeBoolean) {
			Errors.throwError("Can't subtract Float and Boolean");
		} else if (theIncrement instanceof TypeString) {
			Errors.throwError("Can't subtract Float and String");
		}
		
		return null;
	}

	@Override
	protected Variable multiply(DataType theIncrement) {
		if (theIncrement instanceof TypeWhole) {
			TypeWhole toIncrement = (TypeWhole) theIncrement;

			if (toIncrement.getType() == TypeWhole.Type.SHORT) {
				if (type == Type.FLOAT) {
					return new Variable(data.floatValue() * toIncrement.getData().shortValue());
				} else {
					return new Variable(data.doubleValue() * toIncrement.getData().shortValue());
				}
			} else if (toIncrement.getType() == TypeWhole.Type.INTEGER) {
				if (type == Type.FLOAT) {
					return new Variable(data.floatValue() * toIncrement.getData().intValue());
				} else {
					return new Variable(data.doubleValue() * toIncrement.getData().intValue());
				}
			} else {
				if (type == Type.FLOAT) {
					return new Variable(data.floatValue() * toIncrement.getData().longValue());
				} else {
					return new Variable(data.doubleValue() * toIncrement.getData().longValue());
				}
			}
		} else if (theIncrement instanceof TypeFloat) {
			TypeFloat toIncrement = (TypeFloat) theIncrement;

			if (toIncrement.getType() == TypeFloat.Type.FLOAT) {
				if (type == Type.FLOAT) {
					return new Variable(data.floatValue() * toIncrement.getData().floatValue());
				} else {
					return new Variable(data.doubleValue() * toIncrement.getData().floatValue());
				}
			} else {
				if (type == Type.FLOAT) {
					return new Variable(data.floatValue() * toIncrement.getData().doubleValue());
				} else {
					return new Variable(data.doubleValue() * toIncrement.getData().doubleValue());
				}
			}
		} else if (theIncrement instanceof TypeBoolean) {
			Errors.throwError("Can't multiply Float and Boolean");
		} else if (theIncrement instanceof TypeString) {
			Errors.throwError("Can't multiply Float and String");
		}		
		
		return null;
	}

	@Override
	protected Variable divide(DataType theIncrement) {
		if (theIncrement instanceof TypeWhole) {
			TypeWhole toIncrement = (TypeWhole) theIncrement;

			if (toIncrement.getType() == TypeWhole.Type.SHORT) {
				if (type == Type.FLOAT) {
					return new Variable(data.floatValue() / toIncrement.getData().shortValue());
				} else {
					return new Variable(data.doubleValue() / toIncrement.getData().shortValue());
				}
			} else if (toIncrement.getType() == TypeWhole.Type.INTEGER) {
				if (type == Type.FLOAT) {
					return new Variable(data.floatValue() / toIncrement.getData().intValue());
				} else {
					return new Variable(data.doubleValue() / toIncrement.getData().intValue());
				}
			} else {
				if (type == Type.FLOAT) {
					return new Variable(data.floatValue() / toIncrement.getData().longValue());
				} else {
					return new Variable(data.doubleValue() / toIncrement.getData().longValue());
				}
			}
		} else if (theIncrement instanceof TypeFloat) {
			TypeFloat toIncrement = (TypeFloat) theIncrement;

			if (toIncrement.getType() == TypeFloat.Type.FLOAT) {
				if (type == Type.FLOAT) {
					return new Variable(data.floatValue() / toIncrement.getData().floatValue());
				} else {
					return new Variable(data.doubleValue() / toIncrement.getData().floatValue());
				}
			} else {
				if (type == Type.FLOAT) {
					return new Variable(data.floatValue() / toIncrement.getData().doubleValue());
				} else {
					return new Variable(data.doubleValue() / toIncrement.getData().doubleValue());
				}
			}
		} else if (theIncrement instanceof TypeBoolean) {
			Errors.throwError("Can't divide Float and Boolean");
		} else if (theIncrement instanceof TypeString) {
			Errors.throwError("Can't divide Float and String");
		}
		
		return null;
	}

	@Override
	protected Variable module(DataType theIncrement) {
		if (theIncrement instanceof TypeWhole) {
			TypeWhole toIncrement = (TypeWhole) theIncrement;

			if (toIncrement.getType() == TypeWhole.Type.SHORT) {
				if (type == Type.FLOAT) {
					return new Variable(data.floatValue() % toIncrement.getData().shortValue());
				} else {
					return new Variable(data.doubleValue() % toIncrement.getData().shortValue());
				}
			} else if (toIncrement.getType() == TypeWhole.Type.INTEGER) {
				if (type == Type.FLOAT) {
					return new Variable(data.floatValue() % toIncrement.getData().intValue());
				} else {
					return new Variable(data.doubleValue() % toIncrement.getData().intValue());
				}
			} else {
				if (type == Type.FLOAT) {
					return new Variable(data.floatValue() % toIncrement.getData().longValue());
				} else {
					return new Variable(data.doubleValue() % toIncrement.getData().longValue());
				}
			}
		} else if (theIncrement instanceof TypeFloat) {
			TypeFloat toIncrement = (TypeFloat) theIncrement;

			if (toIncrement.getType() == TypeFloat.Type.FLOAT) {
				if (type == Type.FLOAT) {
					return new Variable(data.floatValue() % toIncrement.getData().floatValue());
				} else {
					return new Variable(data.doubleValue() % toIncrement.getData().floatValue());
				}
			} else {
				if (type == Type.FLOAT) {
					return new Variable(data.floatValue() % toIncrement.getData().doubleValue());
				} else {
					return new Variable(data.doubleValue() % toIncrement.getData().doubleValue());
				}
			}
		} else if (theIncrement instanceof TypeBoolean) {
			Errors.throwError("Can't mod Float and Boolean");
		} else if (theIncrement instanceof TypeString) {
			Errors.throwError("Can't mod Float and String");
		}
		
		return null;
	}

	public Type getType() {
		return type;
	}

	public Number getData() {
		return data;
	}

	public String toString() {
		return data + ": Float Number (" + type + ")";
	}

	public enum Type {
		FLOAT, DOUBLE;
	}

	@Override
	protected String toPrint() {
		return data.toString();
	}
}
