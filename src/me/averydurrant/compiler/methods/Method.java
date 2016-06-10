package me.averydurrant.compiler.methods;

import java.util.ArrayList;
import java.util.List;

import me.averydurrant.compiler.CodeSpace;
import me.averydurrant.compiler.Modifier;
import me.averydurrant.compiler.Parser;
import me.averydurrant.compiler.Visability;
import me.averydurrant.compiler.members.Integer;
import me.averydurrant.compiler.members.Member;

public class Method {
	private List<Parameter> parameters = new ArrayList<Parameter>();
	private Visability visability;
	private CodeSpace codeSpace;
	private String name, body;
	private Modifier modifier;

	public Method(String name, String parameters, String body, CodeSpace codeSpace, Visability visability,
			Modifier modifier) {
		this.codeSpace = new CodeSpace(codeSpace);

		if (parameters.length() != 0) {
			for (String splitz : parameters.replaceAll("\\s+", " ").split(",")) {
				String[] split = splitz.trim().split(" ");

				if (splitz.contains("=")) {
					// TODO
				} else if (split.length == 2) {
					Member member = null;

					if (split[0].equals("int")) {
						member = new Integer();
					}

					this.parameters.add(new Parameter(split[1], member));
				} else {
					throw new Error("Could not parse method " + name + "'s parameters");
				}
			}
		}

		this.name = name;
		this.body = body;
		this.visability = visability;
		this.modifier = modifier;
	}

	public Object execute(String parameters) {
		String[] paraSplit = parameters.split(",");

		if (paraSplit.length != this.parameters.size()) {
			throw new Error("Incorrect Parameter type");
		}

		for (int i = 0; i < this.parameters.size(); i++) {
			Parameter parameter = this.parameters.get(i);

			if (parameter.getMember().isType(paraSplit[i].trim())) {
				parameter.getMember().assign(paraSplit[i].trim());
				codeSpace.addVariable(parameter.getName(), parameter.getMember());
			} else {
				throw new Error("Parameter miss match");
			}
		}

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
