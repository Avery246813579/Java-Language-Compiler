package me.averydurrant.compiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * TODO:
 * - Check if variable name is a reserve word
 * - Check if integer is in bounds
 * - Concatination
 * - ! thing
 * - ( ) 
 * - Line Numbering
 */

public class Parser {
	/*
	 * Parses a string or file, turns it into a code space, and executes the
	 * code. If it contains any bodies then it will parse the respected body.
	 */
	public static void parse(File file) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String fullCode = "", line = null;
		try {
			while ((line = reader.readLine()) != null) {
				if (!line.trim().startsWith("//")) {
					fullCode += line;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		parseText(new CodeSpace(), fullCode);
	}

	public static void parseText(CodeSpace codeSpace, String unparsed) {
		if (unparsed.contains("{")) {
			int start = unparsed.indexOf('{');
			int end = unparsed.indexOf('}');

			String body = unparsed.substring(start + 1, end);
			String before = unparsed.substring(0, start);
			String beforeBefore = null;
			String header = null;

			// parseBody(codeSpace, , body);

			if (before.trim().length() < 1) {
				throw new Error("Nothing before brace");
			}

			if (before.contains(";")) {
				int lLoc = before.lastIndexOf(';');

				if (before.contains("}")) {
					int pLoc = before.lastIndexOf('}');

					if (pLoc > lLoc) {
						header = before.substring(pLoc + 1);
						beforeBefore = before.substring(0, pLoc + 1);
					} else {
						header = before.substring(lLoc + 1);
						beforeBefore = before.substring(0, lLoc + 1);
					}
				} else {
					header = before.substring(lLoc + 1);
					beforeBefore = before.substring(0, lLoc + 1);
				}
			} else if (before.contains("}")) {
				int pLoc = before.lastIndexOf('}');

				header = before.substring(pLoc + 1);
				beforeBefore = before.substring(0, pLoc + 1);
			} else {
				header = before;
			}

			if (beforeBefore != null) {
				parseLines(codeSpace, beforeBefore);
			}

			parseBody(codeSpace, header, body);

			String left = unparsed.substring(end + 1);

			parseText(codeSpace, left);
		} else {
			parseLines(codeSpace, unparsed);
		}
	}

	/*
	 * Parses a string or file, turns it into a code space, and executes the
	 * code. If it contains any bodies then it will parse the respected body.
	 */
	public static void parseLines(CodeSpace codeSpace, String str) {
		CodeSpace space = null;
		if (codeSpace != null) {
			space = new CodeSpace(codeSpace);
		} else {
			space = new CodeSpace();
		}

		String[] lines = str.split(";");

		for (String line : lines) {
			String removedSpaces = line.replaceAll("\\s+", " ");
			String[] words = line.split(" ");

			if (line.trim().isEmpty()) {
				continue;
			}

			switch (words[0].trim()) {
			case "int":
				/*
				 * int x = 0 int x=0 int x =0 int x= 0
				 */

				for (String section : removedSpaces.substring(3).split(",")) {
					if (section.contains("=")) {
						String[] assignmentSplit = section.split("=");
						String[] beforeSplit = assignmentSplit[0].split(" ");

						if (beforeSplit.length == 2 || beforeSplit.length == 1) {
							String name = beforeSplit[beforeSplit.length - 1];
							String assignment = assignmentSplit[1].trim();

							if (!space.getVariables().containsKey(name)) {
								space.addVariable(name, new Integer(assignment));
							} else {
								System.out.println(codeSpace);
								System.out.println(name);
								
								throw new Error("Variable already defined");
							}
						} else {
							System.out.println(section);
							throw new Error("Error with variable declaration");
						}
					} else {
						String[] split = section.split(" ");

						if (split.length == 2) {
							String name = split[1];

							if (!space.getVariables().containsKey(name)) {
								space.addVariable(name, new Integer());
							} else {
								throw new Error("Variable already defined");
							}
						} else {
							throw new Error("Error with error delclaration");
						}
					}
				}

				break;
			case "dump":
				System.out.println(codeSpace);
				break;
			case "cout":
				String[] lineSplit = line.replaceAll("\\s+", " ").substring(5).split("\\+");
				String toPrint = "";

				for (String segment : lineSplit) {
					if (segment.contains("\"")) {
						int first = segment.trim().indexOf("\"");
						int last = segment.trim().lastIndexOf("\"");

						if (first == last) {
							throw new Error("Error with string parsing");
						}

						if (first == 0 && last == segment.trim().length() - 1) {
							toPrint += segment.trim().substring(first + 2, last);
						} else {
							throw new Error("Error with string parsing");
						}
					} else if (space.getVariables().get(segment.trim()) != null) {
						toPrint += space.getVariables().get(segment.trim()).toData();
					} else {
						System.out.println(segment);
						System.out.println(line);
						throw new Error("Could not find variable or reserve word");
					}
				}

				System.out.println(toPrint);
				break;
			default:
				if (space.getVariables().get(words[0]) != null) {
					if (removedSpaces.contains("=")) {
						String[] split = removedSpaces.split("=");
						String[] beforeSplit = split[0].split(" ");

						if (beforeSplit.length == 1) {
							Member member = space.getVariables().get(beforeSplit[0]);
							if (member != null) {
								member.assign(split[1].trim());
							} else {
								throw new Error("Variable not found");
							}
						} else {
							throw new Error("Variable in assignment error");
						}
					} else {
						throw new Error("Assignment error on line");
					}
				} else if (line.contains("=")) {
					String[] split = removedSpaces.trim().split("=");
					String[] beforeSplit = split[0].split(" ");

					if (beforeSplit.length == 1) {
						Member member = space.getVariables().get(beforeSplit[0]);

						if (member != null) {
							member.assign(split[1].trim());
						} else {
							System.out.println(codeSpace);
							System.out.println(beforeSplit[0]);
							throw new Error("Variable not found");
						}
					} else {
						System.out.println(removedSpaces);
						throw new Error("Variable in assignment error");
					}
				} else if (line.contains("(") && line.contains(")")) {
					String[] methodSplit = line.split("\\(");

					Method method = codeSpace.findMethod(methodSplit[0].trim());
					if (method != null) {
						method.execute();
					}
				} else {
					System.out.println(line + "LINED");
					
					throw new Error("Could not find reserve word or variable: " + words[0]);
				}
			}
		}
	}

	/* Parses a header and statement using its header and body. **/
	public static void parseBody(CodeSpace codeSpace, String header, String body) {
		if (header.contains("(")) {
			if (header.contains(")")) {
				String pre = header.substring(0, header.indexOf('('));
				String parameters = header.substring(header.indexOf('(') + 1, header.lastIndexOf(')'));

				switch (pre.trim()) {
				default:
					String[] split = null;

					BodyType type = null;
					if (pre.contains("void")) {
						split = pre.split("void");
						type = BodyType.METHOD;
					}

					String[] preSplit = split[0].trim().split(" ");
					String[] postSplit = split[1].trim().split(" ");

					Visability visability = null;
					if (preSplit.length == 1 || preSplit.length == 2) {
						if (preSplit[0].length() == 0) {
							visability = Visability.PACKAGE;
						} else {
							visability = Visability.findVisability(preSplit[0]);
						}

						if (visability == null) {
							throw new Error("Error finding project visibility.");
						}

						Modifier modifier = null;
						if (preSplit.length == 2) {
							modifier = Modifier.findModifier(preSplit[1]);

							if (modifier == null) {
								throw new Error("Problem with Method Header Modifier. Could not be found");
							}
						}

						if (postSplit.length > 1 || postSplit[0].length() == 0) {
							throw new Error("Error with Name declaration");
						}

						String name = postSplit[0];
						if (type == BodyType.METHOD) {
							codeSpace.addMethods(new Method(name, parameters, body, codeSpace, visability, modifier));
						}
					} else {
						throw new Error("Problem with Method Header. Too many arguments");
					}

					break;
				case "if":
					new IfStatement(codeSpace, parameters, body);
					break;
				}
			} else {
				throw new Error("Header declaration error");
			}
		} else {
			throw new Error("Header declaration error");
		}
	}

	public static void main(String[] args) {
		Parser.parse(new File("test.txt"));
	}
}