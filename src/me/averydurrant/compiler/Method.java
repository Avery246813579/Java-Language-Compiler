package me.averydurrant.compiler;

public class Method {
	private Visability visability;
	private CodeSpace codeSpace;
	private String name, body;
	private Modifier modifier;

	public Method(String name, String parameters, String body, CodeSpace codeSpace, Visability visability,
			Modifier modifier) {
		if (parameters.length() != 0) {
			for (String splitz : parameters.replaceAll("\\s+", " ").split(",")) {
				String[] split = splitz.split(" ");

				if (splitz.contains("=")) {
					if (split.equals("int")) {

					} else {
						throw new Error("Could not find parameter property");
					}
				} else if (split.length == 2) {
					Member member = null;

					if (split[0].equals("int")) {
						member = new Integer();
					}

					codeSpace.addVariable(split[1], member);
				} else {
					throw new Error("Could not parse method " + name + "'s parameters");
				}
			}
		}

		this.name = name;
		this.body = body;
		this.codeSpace = new CodeSpace(codeSpace);
		this.visability = visability;
		this.modifier = modifier;
	}

	public Object execute() {
		Parser.parseLines(codeSpace, body);

		return null;
	}

	public Visability getVisability() {
		return visability;
	}

	public Modifier getModifier() {
		return modifier;
	}

	public String getName() {
		return name;
	}

	public String getBody() {
		return body;
	}

	public CodeSpace getCodeSpace() {
		return codeSpace;
	}
}
