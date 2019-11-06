package ast;

import java.util.List;

import environment.Environment;

public class ProcedureDeclaration extends Statement {
	private String name;
	private Statement stmt;
	private List<String> params;
	
	public ProcedureDeclaration(String name, Statement stmt, List<String> params) {
		this.name = name;
		this.stmt = stmt;
		this.params = params;
	}

	public Statement getProcedure()
	{
		return stmt;
	}
	
	public List<String> getParams()
	{
		return params;
	}
	
	public void exec(Environment env) {
		env.setProcedure(name, this);
	}
}
