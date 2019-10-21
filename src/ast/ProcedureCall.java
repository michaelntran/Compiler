package ast;

import java.util.List;

import environment.Environment;


public class ProcedureCall extends Expression {
	private String name;
	private List<String> params;
	
	
	
	public ProcedureCall(String name, List<String> params) {
		this.name = name;
		this.params = params;
	}



	public int eval(Environment env) {
		// TODO Auto-generated method stub
		return 0;
	}

}
