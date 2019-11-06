package ast;

import java.util.List;

import environment.Environment;

public class Program extends Statement {
	List<ProcedureDeclaration> procedures;
	Statement stmt;
	
	
	public Program(List<ProcedureDeclaration> procedures, Statement stmt) {
		this.procedures = procedures;
		this.stmt = stmt;
	}


	public void exec(Environment env) {
		for(ProcedureDeclaration dec: procedures)
			dec.exec(env);
		stmt.exec(env);
	}

}
