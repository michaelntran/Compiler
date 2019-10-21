package ast;

import environment.Environment;

public class ProcedureDeclaration extends Statement {
	private String name;
	private Statement stmt;
	
	public ProcedureDeclaration(String name, Statement stmt) {
		this.name = name;
		this.stmt = stmt;
	}

	public void exec(Environment env) {
		// TODO Auto-generated method stub

	}

}
